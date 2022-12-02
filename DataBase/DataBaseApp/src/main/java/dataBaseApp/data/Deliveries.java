package dataBaseApp.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dataBaseApp.data.Accounting_deliveries;
import dataBaseApp.pk.DeliveriesPK;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Check(constraints = "start_date>end_date AND plan_delivery > 0 AND id_product IS NOT NULL")
@IdClass(DeliveriesPK.class)
@Table(name = "deliveries")
@Data
public class Deliveries {
    @Id
    private Long id_contract;
    @Id
    //@Column(insertable=false, updatable=false)
    private Long id_product;
    /*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_contract;
    @Id
    private Long id_product;

     */
    //@Column(columnDefinition = "varchar(25) default items")
    private String unit;

    private LocalDate start_date;

    private LocalDate end_date;

    private Integer plan_delivery;

    private Double price_unit;
    /*
    @JoinColumns({
        @JoinColumn(name = "id_contract"),
        @JoinColumn(name = "id_product")
    })

     */
    @JsonIgnore
    @OneToMany(mappedBy = "deliveries")
    public List<Accounting_deliveries> accounting_deliveries;



    public DeliveriesPK getId() {
        return new DeliveriesPK(id_contract, id_product);
    }

    public void setId(DeliveriesPK deliveriesPK) {
        this.id_contract = deliveriesPK.getId_contract();
        this.id_product = deliveriesPK.getId_product();
    }
/*
    public Long getId_contract() {
        return id_contract;
    }

    public Long getId_product() {
        return id_product;
    }

    public LocalLocalDate getStart_date() {
        return start_date;
    }

 */


/*
    @Override
    public String toString() {
        return "Deliveries{" +
                "id_contract=" + id_contract +
                ", id_product=" + id_product +
                ", unit='" + unit + '\'' +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", plan_delivery=" + plan_delivery +
                ", price_unit=" + price_unit +
                "}\n";
    }

 */
}

