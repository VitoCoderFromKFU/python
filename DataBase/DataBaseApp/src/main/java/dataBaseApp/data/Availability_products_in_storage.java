package dataBaseApp.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dataBaseApp.data.Accounting_deliveries;
import dataBaseApp.pk.Availability_products_in_storagePK;
import jakarta.persistence.*;

import lombok.*;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@IdClass(Availability_products_in_storagePK.class)
@Table(name = "availability_products_in_storage")
//@Check(constraints = "id_storage IS NOT NULL AND id_product IS NOT NULL")
public class Availability_products_in_storage {
    @Id
    private Long id_storage;
    @Id
    //@Column(insertable=false, updatable=false)
    private Long id_product;
    //@Column(columnDefinition = "varchar(25) default items")
    private String unit;

    //@Column(columnDefinition = "int default 0")
    private Integer count_in_storage = 0;

    private LocalDate date_last_operation;

    /*
        @JoinColumns({
                @JoinColumn(name = "id_contract"),
                @JoinColumn(name = "id_storage")
        })

     */
    @JsonIgnore
    @OneToMany(mappedBy = "availability_products_in_storage")
    public List<Accounting_deliveries> accounting_deliveries;



    public Availability_products_in_storagePK getId() {
        return new Availability_products_in_storagePK(id_storage, id_product);
    }

    public void setId(Availability_products_in_storagePK storagePK) {
        this.id_storage = storagePK.getId_storage();
        this.id_product = storagePK.getId_product();
    }
/*
    @Override
    public String toString() {
        return "Availability_products_in_storage{" +
                "id_storage=" + id_storage +
                ", id_product=" + id_product +
                ", unit='" + unit + '\'' +
                ", count_in_storage=" + count_in_storage +
                ", date_last_operation=" + date_last_operation +
                '}';
    }

 */


}
