package lk.ijse.gdse.HelloShoeShopManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
@Entity(name = "Variety")
public class VarietyEntity {
    @Id
    private String varietyCode;
    private String varietyDesc;

    @OneToMany(mappedBy = "varietyEntity",cascade = CascadeType.ALL)
    private List<ItemEntity> itemEntities;
}
