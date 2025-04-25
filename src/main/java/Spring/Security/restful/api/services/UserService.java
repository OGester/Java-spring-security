package Spring.Security.restful.api.services;

import Spring.Security.restful.api.models.Role;
import Spring.Security.restful.api.models.User;
import Spring.Security.restful.api.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // register user
    public void registerUser(User user) {

        // hash password
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        if(user.getRoles() == null || user.getRoles().isEmpty()) {
            user.setRoles(Set.of(Role.USER));
        }
        userRepository.save(user);
    }

    // find user by username
    public User findByUsername(String username) {
       return userRepository.findByUsername(username)
               .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    // check if username already exists
    public boolean existsByUsername(String username) {
        return userRepository.findByUsername(username).isPresent();
    }











}
