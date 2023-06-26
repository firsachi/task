package ua.kyiv.informer.logic.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ua.kyiv.informer.logic.entity.UserApp;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserAppDetails implements UserDetails {

    private final UserApp userApp;

    public UserAppDetails(UserApp userApp) {
        this.userApp = userApp;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = userApp.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
        return authorities;
    }

    @Override
    public String getPassword() {
        return userApp.getPassword();
    }

    @Override
    public String getUsername() {
        return userApp.getUsername();
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
        return userApp.isEnabled();
    }
}
