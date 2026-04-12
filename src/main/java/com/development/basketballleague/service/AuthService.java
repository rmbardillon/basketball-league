package com.development.basketballleague.service;

import com.development.basketballleague.dto.JwtResponse;
import com.development.basketballleague.dto.LoginRequest;
import com.development.basketballleague.dto.RegisterRequest;
import com.development.basketballleague.model.Admin;
import com.development.basketballleague.repository.AdminRepository;
import com.development.basketballleague.security.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    
    private final AuthenticationManager authenticationManager;
    private final AdminRepository adminRepository;
    private final PasswordEncoder encoder;
    private final JwtUtils jwtUtils;
    
    public JwtResponse authenticateUser(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        
        return new JwtResponse(jwt, loginRequest.getUsername());
    }
    
    public String registerUser(RegisterRequest signUpRequest) {
        if (adminRepository.existsByUsername(signUpRequest.getUsername())) {
            throw new RuntimeException("Error: Username is already taken!");
        }
        
        Admin admin = new Admin();
        admin.setUsername(signUpRequest.getUsername());
        admin.setPassword(encoder.encode(signUpRequest.getPassword()));
        
        adminRepository.save(admin);
        
        return "User registered successfully!";
    }
}