package com.etiya.authservice.service.concretes;

import com.etiya.authservice.service.abstracts.AuthService;
import com.etiya.authservice.service.abstracts.UserService;
import com.etiya.authservice.service.dtos.LoginRequest;
import com.etiya.authservice.service.dtos.RegisterUserRequest;
import com.etiya.authservice.service.rules.AuthRules;
import com.etiya.common.jwt.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


@Service
public class AuthServiceImpl implements AuthService {

    private final JwtService jwtService;
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final AuthRules authRules;

    public AuthServiceImpl(JwtService jwtService, UserService userService, AuthenticationManager authenticationManager, AuthRules authRules) {
        this.jwtService = jwtService;
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.authRules = authRules;
    }

    @Override
    public void register(RegisterUserRequest request) {
        userService.add(request);
    }

    @Override
    public String login(LoginRequest request) {
        String normalizedUsername = request.getUsername().toLowerCase();
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(normalizedUsername,request.getPassword()));
        authRules.checkIfAuthenticated(authentication);
        UserDetails user = (UserDetails) authentication.getPrincipal();
        return jwtService
                .generateToken(user.getUsername(),user.getAuthorities()
                        .stream().map(GrantedAuthority::getAuthority).toList());


    }
}
