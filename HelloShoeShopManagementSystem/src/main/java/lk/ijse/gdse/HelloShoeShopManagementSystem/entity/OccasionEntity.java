package lk.ijse.gdse.HelloShoeShopManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
@Entity
@Table(name = "Occassion")
public class OccasionEntity {

    @Id
    private String occasionCode;
    private String occasionDesc;

    @OneToMany(mappedBy = "occasionEntity",cascade = CascadeType.ALL)
    private List<ItemEntity> itemEntities;
}
