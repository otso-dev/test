package com.smalleats.security;

import com.smalleats.entity.Authority;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Builder
public class PrincipalUser implements UserDetails {
    private int userId;
    private String userName;
    private String email;
    private String password;
    private String phoneNumber;
    private String provider;

    private int partnerId;
    private String partnerUserName;
    private String partnerPassword;
    private String partnerUserEmail;
    private String partnerPhoneNumber;

    private List<Authority> authorities;

    private boolean isUser;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        this.authorities.forEach(authority -> {
           authorities.add(new SimpleGrantedAuthority(authority.getRole().getRoleName()));
        });
        return authorities;
    }

    @Override
    public String getPassword() {
        if(isUser){
            return password;
        }
        return partnerPassword;
    }

    @Override
    public String getUsername() {
        if(isUser){
            return email;
        }
        return partnerUserEmail;
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
}
