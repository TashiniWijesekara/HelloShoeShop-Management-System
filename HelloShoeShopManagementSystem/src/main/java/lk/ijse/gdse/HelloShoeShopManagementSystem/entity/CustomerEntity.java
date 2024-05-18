package lk.ijse.gdse.HelloShoeShopManagementSystem.entity;


import jakarta.persistence.*;
import lk.ijse.gdse.HelloShoeShopManagementSystem.Enum.Gender;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "customer")
public class CustomerEntity {

    @Id
    private  String cutomerId;

    private String customerName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Temporal(TemporalType.DATE)
    private Date joinDate;
}
