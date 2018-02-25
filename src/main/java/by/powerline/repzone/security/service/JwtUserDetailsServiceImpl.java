package by.powerline.repzone.security.service;

import by.powerline.repzone.model.db.User;
import by.powerline.repzone.repository.UserRepository;
import by.powerline.repzone.security.model.JwtUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author v.tarasevich
 * @version 1.0
 * @since 21.02.2018 1:15
 */
@Service
@RequiredArgsConstructor
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findUserByUsername(username);
        return new JwtUserDetails(user);
    }
}
