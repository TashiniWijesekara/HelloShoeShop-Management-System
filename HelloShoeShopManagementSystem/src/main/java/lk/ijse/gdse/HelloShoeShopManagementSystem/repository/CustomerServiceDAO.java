package lk.ijse.gdse.HelloShoeShopManagementSystem.repository;

import lk.ijse.gdse.HelloShoeShopManagementSystem.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerServiceDAO extends JpaRepository {
    CustomerEntity findFirstByOrderByCustomerIdDesc();
}
