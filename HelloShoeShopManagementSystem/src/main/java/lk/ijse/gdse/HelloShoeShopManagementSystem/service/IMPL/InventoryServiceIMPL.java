package lk.ijse.gdse.HelloShoeShopManagementSystem.service.IMPL;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.HelloShoeShopManagementSystem.conversion.ConversionData;
import lk.ijse.gdse.HelloShoeShopManagementSystem.dto.ItemDTO;
import lk.ijse.gdse.HelloShoeShopManagementSystem.repository.InventoryServiceDAO;
import lk.ijse.gdse.HelloShoeShopManagementSystem.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class InventoryServiceIMPL implements InventoryService {
    final private InventoryServiceDAO inventoryServiceDAO;
    final private ConversionData conversionData;
    @Override
    public void saveInventory(ItemDTO inventoryDTO) {
        inventoryDTO.setItemCode(generateItemCode(inventoryDTO));
        inventoryServiceDAO.save(conversionData.convertToItemEntity(inventoryDTO));
    }

    @Override
    public String generateItemCode(ItemDTO itemDTO) {
        StringBuilder prefixBuilder = new StringBuilder();
        if (itemDTO.getGenderCode() != null) {
            prefixBuilder.append(itemDTO.getGenderCode());
        }
        if (itemDTO.getOccasionCode() != null) {
            prefixBuilder.append(itemDTO.getOccasionCode());
        }
        if (itemDTO.getVarietyCode() != null) {
            prefixBuilder.append(itemDTO.getVarietyCode());
        }
        String prefix = prefixBuilder.toString();

        String lastItemCodeStartingWithPrefix =
                inventoryServiceDAO.findLastItemCodeStartingWithPrefix(prefix);

        return (lastItemCodeStartingWithPrefix != null)
                ? String.format("%s%05d", prefix, Integer.parseInt(lastItemCodeStartingWithPrefix.replace(prefix, "")) + 1)
                : prefix + "00001";
    }

    @Override
    public List<ItemDTO> getAllInventory() {
        return null;
    }

    @Override
    public ItemDTO getInventory(String id) {
        return null;
    }

    @Override
    public void updateInventory(String id, ItemDTO inventoryDTO) {

    }

    @Override
    public void deleteInventory(String id) {

    }
}
