package lk.ijse.gdse.HelloShoeShopManagementSystem.service;

import lk.ijse.gdse.HelloShoeShopManagementSystem.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    void saveEmployee(EmployeeDTO employeeDTO);
    void updateEmployee(String id,EmployeeDTO employeeDTO);
    void deleteEmployee(String id);
    EmployeeDTO getEmployee(String id);
    List<EmployeeDTO> getAllEmployees();
}
