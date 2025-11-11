package com.etiya.authservice.service.rules;

import com.etiya.authservice.repository.UserRepository;
import com.etiya.common.localization.LocalizationService;
import org.springframework.stereotype.Service;

@Service
public class UserRules {
    private final UserRepository userRepository;
    private final LocalizationService localizationService;

    public UserRules(UserRepository userRepository, LocalizationService localizationService) {
        this.userRepository = userRepository;
        this.localizationService = localizationService;
    }

    public void checkUserBeforeAdd(String username){
        if (userRepository.existsByUsernameIgnoreCase(username)) {
            throw new RuntimeException("Username already exists!");
        }
    }
}
