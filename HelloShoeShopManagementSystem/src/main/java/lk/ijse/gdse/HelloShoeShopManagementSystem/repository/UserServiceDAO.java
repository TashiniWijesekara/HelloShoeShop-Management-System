package lk.ijse.gdse.HelloShoeShopManagementSystem.repository;

import lk.ijse.gdse.HelloShoeShopManagementSystem.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserServiceDAO extends JpaRepository<UserEntity,String> {
    Optional<UserEntity> findByEmail(String email);
}
