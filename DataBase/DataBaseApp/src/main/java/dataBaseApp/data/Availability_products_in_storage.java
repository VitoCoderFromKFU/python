package DataBaseApp;

import DataBaseApp.PK.Availability_products_in_storagePK;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@IdClass(Availability_products_in_storagePK.class)
@Check(constraints = "id_storage IS NOT NULL AND id_product IS NOT NULL")
public class Availability_products_in_storage {
    @Id
    private Long id_storage;
    @Id
    private Long id_product;

    @ColumnDefault("items")
    private String unit;

    @ColumnDefault("0")
    private Integer count_in_storage;

    private Date date_last_operation;

    @OneToMany
    private List<Accounting_deliveries> accounting_deliveries;


}
