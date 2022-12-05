package dataBaseApp.pk;

import jakarta.persistence.Entity;
import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class DeliveriesPK implements Serializable {
    private Long idContract;
    private Long idProduct;
}
