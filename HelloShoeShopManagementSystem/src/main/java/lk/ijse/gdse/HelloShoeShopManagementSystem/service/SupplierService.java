package lk.ijse.gdse.HelloShoeShopManagementSystem.service;

import lk.ijse.gdse.HelloShoeShopManagementSystem.dto.SupplierDTO;

import java.util.List;

public interface SupplierService {
    void saveSupplier(SupplierDTO supplierDTO);
    void updateSupplier(String id,SupplierDTO supplierDTO);
    void deleteSupplier(String id);
    SupplierDTO getSupplier(String id);
    List<SupplierDTO> getAllSuppliers();
}
