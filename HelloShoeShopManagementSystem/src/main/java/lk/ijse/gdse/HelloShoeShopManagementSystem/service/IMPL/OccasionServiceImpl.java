package lk.ijse.gdse.HelloShoeShopManagementSystem.service.IMPL;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.HelloShoeShopManagementSystem.conversion.ConversionData;
import lk.ijse.gdse.HelloShoeShopManagementSystem.dto.OccasionDTO;
import lk.ijse.gdse.HelloShoeShopManagementSystem.exception.NotFoundException;
import lk.ijse.gdse.HelloShoeShopManagementSystem.repository.OccasionServiceDAO;
import lk.ijse.gdse.HelloShoeShopManagementSystem.service.OccasionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OccasionServiceImpl implements OccasionService {
    final private OccasionServiceDAO occasionServiceDAO;
    final private ConversionData conversionData;
    @Override
    public void saveOccasion(OccasionDTO occasionDTO) {
        occasionServiceDAO.save(conversionData.convertToOccasionEntity(occasionDTO));
    }

    @Override
    public List<OccasionDTO> getAllOccasion() {
        return conversionData.convertToOccasionDTOList(occasionServiceDAO.findAll());
    }

    @Override
    public void updateOccasion(String id, OccasionDTO occasionDTO) {
        if(!occasionServiceDAO.existsById(id)){throw new NotFoundException("Occasion Not Found");}
        occasionServiceDAO.save(conversionData.convertToOccasionEntity(occasionDTO));
    }

    @Override
    public void deleteOccasion(String id) {
        occasionServiceDAO.deleteById(id);
    }

}
