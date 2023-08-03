package vn.huynhduc.EShop.Service;

import org.springframework.security.core.userdetails.UserDetailsService;
import vn.huynhduc.EShop.Enity.User;

public interface UserService extends UserDetailsService {

    public User findUserByUsername(String username);
}
