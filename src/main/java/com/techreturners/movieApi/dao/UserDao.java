package com.techreturners.movieApi.dao;

import com.techreturners.movieApi.vo.Role;
import com.techreturners.movieApi.vo.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "_user")
public class UserDao {

  @Id @GeneratedValue private Integer id;
  private String firstName;
  private String lastName;
  private String email;
  private String password;

  @Enumerated(EnumType.STRING)
  private Role role;

  public User toVo() {
    return User.builder()
        .id(id)
        .firstName(firstName)
        .lastName(lastName)
        .email(email)
        .password(password)
        .role(role)
        .build();
  }
}
