package DataBaseApp;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Accounting_deliveries {

    private Integer id_storage;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id_document_on_admission;

    private Long id_contract;

    private Long id_product;

    @ColumnDefault("items")
    private String unit;

    private Integer count_products;

    private Date date_of_admission;

    @ManyToOne
    private Availability_products_in_storage availability_products_in_storage;
    @ManyToOne
    private Deliveries deliveries;



}
