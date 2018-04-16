package by.powerline.repzone.security.service;

import by.powerline.repzone.exception.auth.UserNotFoundException;
import by.powerline.repzone.model.db.Service;
import by.powerline.repzone.repository.ServiceRepository;
import by.powerline.repzone.security.model.JwtUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Objects;

/**
 * @author v.tarasevich
 * @version 1.0
 * @since 21.02.2018 1:15
 */
@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    private final ServiceRepository serviceRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Service user = this.serviceRepository.findServiceByServiceName(username);
        if(Objects.isNull(user)) {
            throw new UserNotFoundException("Username not found");
        }
        return new JwtUserDetails(user);
    }
}
