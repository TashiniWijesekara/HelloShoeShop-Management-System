package lk.ijse.gdse.HelloShoeShopManagementSystem.controller;

import lk.ijse.gdse.HelloShoeShopManagementSystem.repository.request.SignUpRequest;
import lk.ijse.gdse.HelloShoeShopManagementSystem.repository.request.SigninRequest;
import lk.ijse.gdse.HelloShoeShopManagementSystem.repository.response.JwtAuthenticationResponse;
import lk.ijse.gdse.HelloShoeShopManagementSystem.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/auth")
public class UserController {
    private final AuthenticationService authenticationService;

    @PostMapping("/signUp")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest signup){
        return ResponseEntity.ok(authenticationService.signup(signup));
    }

    @PostMapping("/signIn")
    public ResponseEntity<JwtAuthenticationResponse> signIn(@RequestBody SigninRequest signIn){
        return ResponseEntity.ok(authenticationService.signin(signIn));
    }

    @GetMapping("/refresh")
    public ResponseEntity<JwtAuthenticationResponse> refresh(
            @RequestParam("refreshToken") String refreshToken
    ){
        System.out.println(refreshToken);
        return ResponseEntity.ok(authenticationService.refreshToken(refreshToken));
    }
}
