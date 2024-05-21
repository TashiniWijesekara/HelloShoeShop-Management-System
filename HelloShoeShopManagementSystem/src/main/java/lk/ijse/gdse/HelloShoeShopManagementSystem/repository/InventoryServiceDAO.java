package lk.ijse.gdse.HelloShoeShopManagementSystem.repository;

import lk.ijse.gdse.HelloShoeShopManagementSystem.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InventoryServiceDAO extends JpaRepository<ItemEntity,String> {
    @Query("SELECT itemCode FROM ItemEntity  WHERE itemCode LIKE CONCAT(:prefix, '%') ORDER BY itemCode DESC")
    String findLastItemCodeStartingWithPrefix(@Param("prefix") String prefix);

}
