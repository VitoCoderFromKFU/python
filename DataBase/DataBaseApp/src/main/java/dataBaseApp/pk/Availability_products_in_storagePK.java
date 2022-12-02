package dataBaseApp.pk;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Availability_products_in_storagePK {
    private Long id_storage;
    private Long id_product;

}
