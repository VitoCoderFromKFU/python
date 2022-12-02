package dataBaseApp.pk;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveriesPK {
    private Long id_contract;
    private Long id_product;
}
