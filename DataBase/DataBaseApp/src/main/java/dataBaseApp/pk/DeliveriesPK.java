package dataBaseApp.pk;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class DeliveriesPK implements Serializable {
    public Long idContract;
    private Long idProduct;
}
