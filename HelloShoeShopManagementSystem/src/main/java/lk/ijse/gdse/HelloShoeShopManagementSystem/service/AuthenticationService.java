package lk.ijse.gdse.HelloShoeShopManagementSystem.service;

import lk.ijse.gdse.HelloShoeShopManagementSystem.repository.request.SignUpRequest;
import lk.ijse.gdse.HelloShoeShopManagementSystem.repository.request.SigninRequest;
import lk.ijse.gdse.HelloShoeShopManagementSystem.repository.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);

    JwtAuthenticationResponse refreshToken(String refreshToken);

}
