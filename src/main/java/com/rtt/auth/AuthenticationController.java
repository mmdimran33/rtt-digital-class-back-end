package com.rtt.auth;

import com.rtt.constants.RegistrationResponseConstants;
import com.rtt.exception.RegistrationException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService authenticationService;

  @PostMapping("/register")
  public ResponseEntity<RegistrationServiceResponse> register(
      @RequestBody RegisterRequest request) throws RegistrationException {

    try{
      RegistrationResponse response  = authenticationService.register(request);
      response.setResponseCode(RegistrationResponseConstants.REGISTRATION_RESPONSE_SUCCESS_CODE);
      response.setResponseDescription(RegistrationResponseConstants.REGISTRATION_RESPONSE_SUCCESS_DESCTIPTION);
      return ResponseEntity.ok(RegistrationServiceResponse.builder().registrationResponse(response).build());

    }catch (Exception e){
    throw new RegistrationException (RegistrationResponseConstants.REGISTRATION_RESPONSE_FAILURE_CODE,
              RegistrationResponseConstants.REGISTRATION_RESPONSE_FAILURE_DESCTIPTION + e.getMessage());
    }
  }
  @PostMapping("/authenticate")
  public ResponseEntity<UserLoginResponse> authenticate(
      @RequestBody AuthenticationRequest request
  ) {
    AuthenticationResponse authenticationResponse = authenticationService.authenticate(request);
    return ResponseEntity.ok(UserLoginResponse.builder().authenticationResponse(authenticationResponse).build());
  }

  @PostMapping("/refresh-token")
  public void refreshToken(
      HttpServletRequest request,
      HttpServletResponse response
  ) throws IOException {
    authenticationService.refreshToken(request, response);
  }


}
