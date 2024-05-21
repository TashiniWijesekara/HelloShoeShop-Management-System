package lk.ijse.gdse.HelloShoeShopManagementSystem.service.IMPL;

import lk.ijse.gdse.HelloShoeShopManagementSystem.conversion.ConversionData;
import lk.ijse.gdse.HelloShoeShopManagementSystem.dto.GenderDTO;
import lk.ijse.gdse.HelloShoeShopManagementSystem.exception.NotFoundException;
import lk.ijse.gdse.HelloShoeShopManagementSystem.repository.GenderServiceDAO;
import lk.ijse.gdse.HelloShoeShopManagementSystem.service.GenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class GenderServiceImpl implements GenderService {
    final private GenderServiceDAO genderServiceDAO;
    final private ConversionData conversionData;
    @Override
    public void saveGender(GenderDTO genderDTO) {
        genderServiceDAO.save(conversionData.covertToGenderEntity(genderDTO));
    }

    @Override
    public List<GenderDTO> genderGetAll() {
        return conversionData.covertToGenderDTOList(genderServiceDAO.findAll());
    }

    @Override
    public void updateGender(String id, GenderDTO genderDTO) {
        if(genderServiceDAO.existsById(id)) throw new NotFoundException("Gender not found");
        genderServiceDAO.save(conversionData.covertToGenderEntity(genderDTO));
    }

    @Override
    public void deleteGender(String id) {
        genderServiceDAO.deleteById(id);
    }
}
