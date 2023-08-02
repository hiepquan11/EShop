package vn.huynhduc.EShop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.huynhduc.EShop.Enity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    public User findByFullname(String fullnane);
    public User findUsersByEmail(String email);
}
