package lk.ijse.gdse.HelloShoeShopManagementSystem.repository;

import lk.ijse.gdse.HelloShoeShopManagementSystem.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeServiceDAO extends JpaRepository<EmployeeEntity,String> {
    EmployeeEntity findFirstByOrderByEmployeeCodeDesc();
}
