package com.example.proiectfinal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsClassService implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserClass userClass = repo.findByEmail(username);
        if (userClass == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new UserDetailsClass(userClass);
    }
}
