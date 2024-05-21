package lk.ijse.gdse.HelloShoeShopManagementSystem.service.IMPL;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.HelloShoeShopManagementSystem.conversion.ConversionData;
import lk.ijse.gdse.HelloShoeShopManagementSystem.repository.UserServiceDAO;
import lk.ijse.gdse.HelloShoeShopManagementSystem.service.AuthenticationService;
import lk.ijse.gdse.HelloShoeShopManagementSystem.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserServiceDAO userServiceDAO;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final ConversionData conversionData;


}
