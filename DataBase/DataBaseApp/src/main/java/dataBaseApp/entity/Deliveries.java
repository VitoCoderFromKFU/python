package dataBaseApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dataBaseApp.dto.DeliveriesRequest;
import dataBaseApp.pk.DeliveriesPK;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@IdClass(DeliveriesPK.class)
@Table(name = "deliveries")
@Data
public class Deliveries {
    @Id
    @GenericGenerator(name = " ", strategy = "increment")
    @Column(name = "id_contract")
    private Long idContract;
    @Id
    @Column(name = "id_product")
    private Long idProduct;
    @ColumnDefault("items")
    private String unit = "items";
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    @Column(name = "plan_delivery")
    private Integer planDelivery;
    @Column(name = "price_unit")
    private Double priceUnit;
    @JsonIgnore
    @OneToMany(mappedBy = "deliveries")
    public List<Accounting_deliveries> accounting_deliveries;


    public DeliveriesPK getDeliveriesPKId() {
        return new DeliveriesPK(idContract, idProduct);
    }
    public void setDeliveriesPKId(DeliveriesPK deliveriesPK) {
        this.idContract = deliveriesPK.getIdContract();
        this.idProduct = deliveriesPK.getIdProduct();
    }
    public Deliveries(Long idProduct, String unit, LocalDate startDate, LocalDate endDate, Integer planDelivery, Double price_unit) {
        this.idProduct = idProduct;
        this.unit = unit;
        this.startDate = startDate;
        this.endDate = endDate;
        this.planDelivery = planDelivery;
        this.priceUnit = price_unit;
    }
    public static Deliveries fromDTO(final DeliveriesRequest deliveriesRequest) {
        Deliveries deliveries = new Deliveries();
        deliveries.setIdProduct(deliveriesRequest.getIdProduct());
        deliveries.setUnit(deliveriesRequest.getUnit());
        deliveries.setStartDate(deliveriesRequest.getStartDate());
        deliveries.setEndDate(deliveriesRequest.getEndDate());
        deliveries.setPlanDelivery(deliveriesRequest.getPlanDelivery());
        deliveries.setPriceUnit(deliveriesRequest.getPriceUnit());
        return deliveries;
    }
}

