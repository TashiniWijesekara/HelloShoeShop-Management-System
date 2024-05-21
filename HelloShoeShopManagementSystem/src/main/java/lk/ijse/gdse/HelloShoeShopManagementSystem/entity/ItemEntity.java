package lk.ijse.gdse.HelloShoeShopManagementSystem.entity;


import jakarta.persistence.*;
import lk.ijse.gdse.HelloShoeShopManagementSystem.Enum.Status;

@Entity
@Table(name = "Item")
public class ItemEntity {
    @Id
    private String itemCode;
    private String itemDesc;

    @Column(columnDefinition = "LONGTEXT")
    private String pic;

    @Enumerated(EnumType.STRING)
    private Status status;
}
