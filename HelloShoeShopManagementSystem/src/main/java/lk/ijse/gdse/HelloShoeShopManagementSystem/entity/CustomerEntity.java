package lk.ijse.gdse.HelloShoeShopManagementSystem.entity;


import jakarta.persistence.*;
import lk.ijse.gdse.HelloShoeShopManagementSystem.Enum.Gender;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;

@Data
@Entity
@Table(name = "customer")
public class CustomerEntity {

    @Id
    private  String cutomerId;

    private String customerName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Level level;

    @Temporal(TemporalType.DATE)
    private Date joinDate;
    private Integer totalPoint;

    @Temporal(TemporalType.DATE)
    private Date dob;
    private String address1;
    private String address2;
    private String address3;
    private String address4;
    private String postalCode;
    private String contactNo;
    private String email;
    private Timestamp recentPurchasedDate;

    @OneToMany(mappedBy = "customerEntity",cascade = CascadeType.ALL)
    private List<OrderEntity> orderEntities;
}
