package com.sadiker.MyFormSite.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sadiker.MyFormSite.models.User;
import com.sadiker.MyFormSite.repository.UserRepository;

@Service
public class SecurityImp implements UserDetailsService {

    @Autowired
    private UserRepository urepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = urepo.findByUsername(username);
        return new CustomUser(user);
    }

}

