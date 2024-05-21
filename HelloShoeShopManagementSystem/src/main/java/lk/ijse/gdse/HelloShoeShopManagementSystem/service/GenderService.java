package lk.ijse.gdse.HelloShoeShopManagementSystem.service;

import lk.ijse.gdse.HelloShoeShopManagementSystem.dto.GenderDTO;

import java.util.List;

public interface GenderService {
    void saveGender(GenderDTO genderDTO);
    List<GenderDTO> genderGetAll();
    void updateGender(String id, GenderDTO genderDTO);
    void deleteGender(String id);
}
