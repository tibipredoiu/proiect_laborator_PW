package com.example.proiectfinal;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserDetailsClass implements UserDetails {

    private UserClass userClass;

    public UserDetailsClass(UserClass _userClass)
    {
        userClass = _userClass;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return userClass.getPassword();
    }

    @Override
    public String getUsername() {
        return userClass.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getFullName()
    {
        return userClass.getName() + " " + userClass.getLastName();
    }
}
