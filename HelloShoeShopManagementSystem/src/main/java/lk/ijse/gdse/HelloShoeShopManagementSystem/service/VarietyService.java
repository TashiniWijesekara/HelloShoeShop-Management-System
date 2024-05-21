package lk.ijse.gdse.HelloShoeShopManagementSystem.service;

import lk.ijse.gdse.HelloShoeShopManagementSystem.dto.VarietyDTO;

import java.util.List;

public interface VarietyService {
    void saveVariety(VarietyDTO varietyDTO);
    void updateVariety(String id, VarietyDTO varietyDTO);
    void deleteVariety(String id);
    VarietyDTO getVariety(String id);
    List<VarietyDTO> getAllVariety();
}
