package cz.marek.springblog.models.services;

import cz.marek.springblog.models.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    void create(UserDTO user, boolean isAdmin);
}
