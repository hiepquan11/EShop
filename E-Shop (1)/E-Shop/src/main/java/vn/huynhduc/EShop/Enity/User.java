package vn.huynhduc.EShop.Enity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "fullname", length = 50)
    private String fullname;
    @Column(name = "email", length = 150)
    private String email;
    @Column(name = "phone_number",length = 20)
    private String phone_number;
    @Column(name = "address", length = 200)
    private String address;
    @Column(name = "password")
    private String password;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
    joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> role_id;

    @Column(name = "created_at")
    private LocalDateTime createc_at;
    @Column(name = "updated_at")
    private LocalDateTime updated_at;

    @Column(name = "enabled")
    private int enabled;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", role_id=" + role_id +
                ", createc_at=" + createc_at +
                ", updated_at=" + updated_at +
                ", enabled=" + enabled +
                '}';
    }
}
