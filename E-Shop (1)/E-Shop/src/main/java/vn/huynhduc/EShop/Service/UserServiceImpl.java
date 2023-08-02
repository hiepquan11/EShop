package vn.huynhduc.EShop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.huynhduc.EShop.Enity.Role;
import vn.huynhduc.EShop.Enity.User;
import vn.huynhduc.EShop.dao.RoleRepository;
import vn.huynhduc.EShop.dao.UserRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUsersByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findUsersByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException("invalid email or password");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),rolesAuThorities(user.getRole_id()));
    }

    private Collection<? extends GrantedAuthority> rolesAuThorities(Collection<Role> roles){
        return roles.stream().map(role->new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }


}
