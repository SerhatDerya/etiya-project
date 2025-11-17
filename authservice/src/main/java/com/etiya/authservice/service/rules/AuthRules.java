package com.etiya.authservice.service.rules;

import com.etiya.authservice.repository.UserRepository;
import com.etiya.common.localization.LocalizationService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthRules {
    private final UserRepository userRepository;
    private final LocalizationService localizationService;

    public AuthRules(UserRepository userRepository, LocalizationService localizationService) {
        this.userRepository = userRepository;
        this.localizationService = localizationService;
    }

    public void checkIfAuthenticated(Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new RuntimeException("Incorrect username or password");
        }
    }
}
