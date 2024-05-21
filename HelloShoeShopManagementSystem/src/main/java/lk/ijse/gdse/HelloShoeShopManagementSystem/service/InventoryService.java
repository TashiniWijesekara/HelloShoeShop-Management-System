package lk.ijse.gdse.HelloShoeShopManagementSystem.service;

import lk.ijse.gdse.HelloShoeShopManagementSystem.dto.ItemDTO;

import java.util.List;

public interface InventoryService {
    void saveInventory(ItemDTO inventoryDTO);
    String generateItemCode(ItemDTO itemDTO);
    List<ItemDTO> getAllInventory();
    ItemDTO getInventory(String id);
    void updateInventory(String id, ItemDTO inventoryDTO);
    void deleteInventory(String id);
}
