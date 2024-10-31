package com.rtt.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rtt.user.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

  @JsonProperty("first_name")
  private String firstname;
  @JsonProperty("last_name")
  private String lastname;
  @JsonProperty("email")
  private String email;
  @JsonProperty("password")
  private String password;
  @JsonProperty("mobile_no")
  private String mobileNo;
  @JsonProperty("role")
  private Role role;
}
