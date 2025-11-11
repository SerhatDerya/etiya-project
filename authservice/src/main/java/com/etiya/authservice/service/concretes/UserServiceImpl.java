package com.etiya.authservice.service.concretes;


import com.etiya.authservice.domain.User;
import com.etiya.authservice.repository.UserRepository;
import com.etiya.authservice.service.abstracts.UserService;
import com.etiya.authservice.service.dtos.RegisterUserRequest;
import com.etiya.authservice.service.rules.UserRules;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRules userRules;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, UserRules userRules) {
        this.userRepository = userRepository;

        this.passwordEncoder = passwordEncoder;
        this.userRules = userRules;
    }


    @Override
    public void add(RegisterUserRequest request) {
        userRules.checkUserBeforeAdd(request.getUsername().toLowerCase());
        User user = new User();
        user.setUsername(request.getUsername().toLowerCase());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        userRepository.save(user);
    }


    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
        return userRepository.findByUsername(userName)
                .orElseThrow(() -> new AccessDeniedException("Login Failed"));
    }
}
