package lk.ijse.gdse.HelloShoeShopManagementSystem.repository;

import lk.ijse.gdse.HelloShoeShopManagementSystem.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierServiceDAO extends JpaRepository<SupplierEntity,String> {
    SupplierEntity findFirstByOrderBySupplierCodeDesc();
}
