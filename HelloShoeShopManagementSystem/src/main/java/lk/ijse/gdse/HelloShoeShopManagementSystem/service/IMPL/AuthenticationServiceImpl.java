package lk.ijse.gdse.HelloShoeShopManagementSystem.service.IMPL;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.HelloShoeShopManagementSystem.conversion.ConversionData;
import lk.ijse.gdse.HelloShoeShopManagementSystem.dto.UserDTO;
import lk.ijse.gdse.HelloShoeShopManagementSystem.entity.UserEntity;
import lk.ijse.gdse.HelloShoeShopManagementSystem.repository.UserServiceDAO;
import lk.ijse.gdse.HelloShoeShopManagementSystem.repository.request.SignUpRequest;
import lk.ijse.gdse.HelloShoeShopManagementSystem.repository.request.SigninRequest;
import lk.ijse.gdse.HelloShoeShopManagementSystem.repository.response.JwtAuthenticationResponse;
import lk.ijse.gdse.HelloShoeShopManagementSystem.service.AuthenticationService;
import lk.ijse.gdse.HelloShoeShopManagementSystem.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserServiceDAO userServiceDAO;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final ConversionData conversionData;

    @Override
    public JwtAuthenticationResponse signup(SignUpRequest signUp) {
        UserDTO userDTO = UserDTO.builder()
                .id(UUID.randomUUID().toString())
                .email(signUp.getEmail())
                .password(passwordEncoder.encode(signUp.getPassword()))
                .role(signUp.getRole())
                .build();
        UserEntity saveUser = userServiceDAO.save(conversionData.convertToUserEntity(userDTO));
        String generateToken = jwtService.generateToken(saveUser);
        return JwtAuthenticationResponse.builder().token(generateToken).build();
    }

    @Override
    public JwtAuthenticationResponse signin(SigninRequest signIn) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signIn.getEmail(),signIn.getPassword())
        );
        UserEntity user = userServiceDAO.findByEmail(signIn.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var generateToken = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(generateToken).build();
    }

    @Override
    public JwtAuthenticationResponse refreshToken(String refreshToken) {
        var userEntity = userServiceDAO
                .findByEmail(jwtService.extractUserName(refreshToken))
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return JwtAuthenticationResponse.builder().
                token(jwtService.generateToken(userEntity)).build();
    }
}
