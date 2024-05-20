package lk.ijse.gdse.HelloShoeShopManagementSystem.entity;

import jakarta.persistence.*;
import lk.ijse.gdse.HelloShoeShopManagementSystem.Enum.PaymentMethod;

import java.sql.Timestamp;

@Entity
@Table(name = "Orders")
public class OrderEntity {

    @Id
    private String orderNo;
    private Timestamp purchasedDate;
    private int addedPoints;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn(name = "customerId",nullable = false)
    private CustomerEntity customerEntity ;
}
