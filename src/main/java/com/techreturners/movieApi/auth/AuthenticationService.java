package com.techreturners.movieApi.auth;

import com.techreturners.movieApi.security.JwtService;
import com.techreturners.movieApi.repository.UserRepository;
import com.techreturners.movieApi.security.AuthenticationRequest;
import com.techreturners.movieApi.security.AuthenticationResponse;
import com.techreturners.movieApi.security.RegisterRequest;
import com.techreturners.movieApi.vo.Role;
import com.techreturners.movieApi.vo.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

  @Autowired
  private final UserRepository repository;
  @Autowired
  private final PasswordEncoder encoder;
  @Autowired
  private final JwtService jwtService;
  @Autowired
  private final AuthenticationManager authenticationManager;

  public AuthenticationResponse register(RegisterRequest request) {
    var user = User.builder()
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .email(request.getEmail())
            .password(encoder.encode(request.getPassword()))
            .role(Role.USER)
            .build();
    var userVo = repository.save(user.toDao()).toVo();
    var jwtToken = jwtService.generateToken(userVo);
    return AuthenticationResponse.builder().token(jwtToken).build();
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
    var user = repository.findByEmail(request.getEmail()).orElseThrow().toVo();
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder().token(jwtToken).build();
  }
}
