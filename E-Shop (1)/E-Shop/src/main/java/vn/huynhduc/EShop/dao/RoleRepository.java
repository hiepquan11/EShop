package vn.huynhduc.EShop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.huynhduc.EShop.Enity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    public Role findByName(String role);
}
