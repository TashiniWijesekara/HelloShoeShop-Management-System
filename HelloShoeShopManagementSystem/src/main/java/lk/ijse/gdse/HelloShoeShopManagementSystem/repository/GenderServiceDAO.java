package lk.ijse.gdse.HelloShoeShopManagementSystem.repository;

import lk.ijse.gdse.HelloShoeShopManagementSystem.entity.GenderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderServiceDAO extends JpaRepository<GenderEntity,String> {
}
