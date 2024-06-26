package lk.ijse.gdse.HelloShoeShopManagementSystem.controller;

import lk.ijse.gdse.HelloShoeShopManagementSystem.dto.SupplierDTO;
import lk.ijse.gdse.HelloShoeShopManagementSystem.exception.NotFoundException;
import lk.ijse.gdse.HelloShoeShopManagementSystem.service.SupplierService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/supplier")
@AllArgsConstructor
public class SupplierController {
    final private SupplierService supplierService;

    @GetMapping("health")
    public String healthCheck(){
        return "Supplier Health Check";
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveSupplier(@Validated @RequestBody SupplierDTO supplierDTO,
                                               BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }

        try {
            supplierService.saveSupplier(supplierDTO);
            return ResponseEntity.status(HttpStatus.OK).body("Supplier Saved Successfully.");
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Supplier Saved Unsuccessfully.\nMore details.\n"+exception);
        }
    }

    @GetMapping(value = "/{id}",produces = "application/json")
    public ResponseEntity<?> getSupplier(@PathVariable String id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(supplierService.getSupplier(id));
        }catch (NotFoundException notFoundException){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Supplier Not Found");
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Supplier Details fetched suuccessfully.\nMore details.\n"+exception);
        }
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<?> getAllSuppliers(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(supplierService.getAllSuppliers());
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Supplier Details fetched suuccessfully.\nMore details.\n"+exception);
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteSupplier(@PathVariable String id){
        try {
            supplierService.deleteSupplier(id);
            return ResponseEntity.status(HttpStatus.OK).body("Supplier Deleted Successfully.");
        }catch (NotFoundException notFoundException){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Supplier Not Found.");
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Supplier Deleted Unsuccessfully.\nMore details.\n"+exception);
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateSupplier(@Validated @RequestBody SupplierDTO supplierDTO,
                                            BindingResult bindingResult,@PathVariable ("id") String id){
        try {
            supplierService.updateSupplier(id, supplierDTO);
            return ResponseEntity.status(HttpStatus.OK).body("Supplier Updated Successfully.");
        }catch (NotFoundException notFoundException){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Supplier Not Found.");
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Supplier Updated Unsuccessfully.\nMore details.\n"+exception);
        }
    }
}
