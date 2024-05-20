package lk.ijse.gdse.HelloShoeShopManagementSystem.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "StockSize")
public class StockSizeEntity {

    @Id
    private String stockSizeId;
    private int qty;
    private Double unitBuyingPrice;
    private Double unitSellingPrice;
    private Double profit;
    private Double profitMargin;
}
