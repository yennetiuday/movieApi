package com.techreturners.movieApi.auth;

import com.techreturners.movieApi.security.AuthenticationRequest;
import com.techreturners.movieApi.security.AuthenticationResponse;
import com.techreturners.movieApi.security.RegisterRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import static org.mockito.Mockito.*;

class AuthenticationControllerTest {
  @Mock AuthenticationService service;
  @InjectMocks AuthenticationController authenticationController;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testRegister() {
    when(service.register(any())).thenReturn(new AuthenticationResponse("token"));

    ResponseEntity<AuthenticationResponse> result =
        authenticationController.register(
            new RegisterRequest("firstName", "lastName", "email", "password"));
    Assertions.assertEquals(200, result.getStatusCode().value());
  }

  @Test
  void testAuthenticate() {
    when(service.authenticate(any())).thenReturn(new AuthenticationResponse("token"));

    ResponseEntity<AuthenticationResponse> result =
        authenticationController.authenticate(new AuthenticationRequest("email", "password"));
    Assertions.assertEquals(200, result.getStatusCode().value());
  }
}