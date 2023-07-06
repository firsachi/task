package ua.kyiv.informer.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ua.kyiv.informer.logic.entity.UserApp;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UserAppDetails implements UserDetails {

    private final UserApp userApp;

    private Set<SimpleGrantedAuthority> permissions;

    public UserAppDetails(UserApp userApp) {
        userApp.getRoles().stream().forEach(role -> {
          permissions = role.getPermissions().stream().map(permission -> new SimpleGrantedAuthority(permission.getPermissionNmae())).collect(Collectors.toSet());
        });
        this.userApp = userApp;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        /*
        List<GrantedAuthority> authorities = userApp.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
        return authorities;
         */
        return permissions;
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
