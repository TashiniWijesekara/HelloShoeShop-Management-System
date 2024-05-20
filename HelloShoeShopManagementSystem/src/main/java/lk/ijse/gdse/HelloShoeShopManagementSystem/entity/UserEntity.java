package lk.ijse.gdse.HelloShoeShopManagementSystem.entity;


import jakarta.persistence.*;
import lk.ijse.gdse.HelloShoeShopManagementSystem.Enum.Role;
import lombok.Data;

@Entity
@Table(name = "User")
@Data
public class UserEntity {

    @Id
    private String userId;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
}
