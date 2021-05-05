package ge.tsu.service;

import ge.tsu.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService  extends UserDetailsService {
    UserDto createUser(UserDto user);
}
