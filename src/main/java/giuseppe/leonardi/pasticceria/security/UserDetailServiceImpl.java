package giuseppe.leonardi.pasticceria.security;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    Logger log = LoggerFactory.getLogger(UserDetailServiceImpl.class);


    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = null;
        try {
            user = userRepository.findByUsername(username);
            log.info("User succesfully logged!");
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new HashSet<>());
        } catch (Exception e) {
            log.warn("User not found. Probably wrong username and password!");
            return new org.springframework.security.core.userdetails.User("nouser", "nopwd", new HashSet<>());
        }
    }
}