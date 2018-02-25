package by.powerline.repzone.security.model;

import com.google.common.collect.ImmutableSet;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

/**
 * @author v.tarasevich
 * @version 1.0
 * @since 20.02.2018 20:56
 */
public class JwtAuthenticationToken implements Authentication {

    private final JwtUserDetails userDetails;
    private final Serializable credentials;
    private final Collection<? extends GrantedAuthority> grantedAuthorities;
    private boolean isAuthenticated;

    public JwtAuthenticationToken(final String token) {
        this.credentials = token;
        this.userDetails = null;
        this.grantedAuthorities = null;
    }

    public JwtAuthenticationToken(JwtUserDetails userDetails) {
        this.credentials = null;
        this.userDetails = userDetails;
        this.grantedAuthorities = ImmutableSet.copyOf(userDetails.getAuthorities());
        this.isAuthenticated = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.grantedAuthorities;
    }

    @Override
    public Object getCredentials() {
        return this.credentials;
    }

    @Override
    public Object getDetails() {
        return this.userDetails;
    }

    @Override
    public Object getPrincipal() {
        return this.userDetails;
    }

    @Override
    public boolean isAuthenticated() {
        return this.isAuthenticated;
    }

    @Override
    public void setAuthenticated(final boolean isAuthenticated) throws IllegalArgumentException {
        if(isAuthenticated) {
            throw new IllegalArgumentException("Once created you cannot set this token to authenticated.");
        }
        this.isAuthenticated = false;
    }

    @Override
    public String getName() {
        return Objects.isNull(this.userDetails) ? null : this.userDetails.getUsername();
    }
}
