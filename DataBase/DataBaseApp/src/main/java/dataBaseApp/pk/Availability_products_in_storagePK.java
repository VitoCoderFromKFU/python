package dataBaseApp.pk;

import jakarta.persistence.Entity;
import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Availability_products_in_storagePK implements Serializable {
    private Long idStorage;
    private Long idProduct;


}
