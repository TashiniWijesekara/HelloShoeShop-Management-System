package lk.ijse.gdse.HelloShoeShopManagementSystem.service;

import lk.ijse.gdse.HelloShoeShopManagementSystem.dto.OccasionDTO;

import java.util.List;

public interface OccasionService {
    void saveOccasion(OccasionDTO occasionDTO);
    List<OccasionDTO> getAllOccasion();
    void updateOccasion(String id, OccasionDTO occasionDTO);
    void deleteOccasion(String id);
}
