package dataBaseApp.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "accounting_deliveries")
public class Accounting_deliveries {

    //private Long id_storage;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_document_on_admission;

    private Long id_contract;
    //@Column(insertable=false, updatable=false)
    private Long id_product;

    //@Column(columnDefinition = "varchar(25) default items")
    private String unit;


    private Integer count_products;

    private LocalDate date_of_admission;
/*
    Accounting_deliveries(Long id_storage, Long id_contract, Long id_product, String unit, Integer count_products,
                         LocalDate date_of_admission) {
        this.id_storage = id_storage;
        this.id_contract = id_contract;
        this.id_product = id_product;
        this.unit = unit;
        this.count_products = count_products;
        this.date_of_admission = date_of_admission;

    }

 */



    @JoinColumns({
            @JoinColumn(name = "id_product",referencedColumnName = "id_product",updatable = false,insertable = false),
            @JoinColumn(name = "id_storage",referencedColumnName = "id_storage",updatable = false,insertable = false)
    })
    @ManyToOne
    public Availability_products_in_storage availability_products_in_storage;


     @JoinColumns({
            @JoinColumn(name = "id_contract",referencedColumnName = "id_contract",updatable = false,insertable = false),
            @JoinColumn(name = "id_product",referencedColumnName = "id_product",updatable = false,insertable = false)
    })
    @ManyToOne
    public Deliveries deliveries;


/*
    @Override
    public String toString() {
        return "Accounting_deliveries{" +
                "id_storage=" + id_storage +
                ", id_document_on_admission=" + id_document_on_admission +
                ", id_contract=" + id_contract +
                ", id_product=" + id_product +
                ", unit='" + unit + '\'' +
                ", count_products=" + count_products +
                ", date_of_admission=" + date_of_admission +

                '}';
    }

 */


}
