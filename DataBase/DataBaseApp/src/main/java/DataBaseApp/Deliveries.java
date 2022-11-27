package DataBaseApp;

import DataBaseApp.Controllers.PK.DeliveriesPK;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@IdClass(DeliveriesPK.class)
@Entity
@Check(constraints = "start_date>end_date AND plan_delivery > 0 AND id_product IS NOT NULL")

public class Deliveries {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id_contract;
    @Id
    private Long id_product;
    @ColumnDefault("items")
    private String unit;

    private Date start_date;

    private Date end_date;

    private Integer plan_delivery;

    private Double price_unit;

    @OneToMany
    private List<Accounting_deliveries> accounting_deliveries;

    public Long getId_contract() {
        return id_contract;
    }

    public Long getId_product() {
        return id_product;
    }

    public Date getStart_date() {
        return start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public Integer getPlan_delivery() {
        return plan_delivery;
    }

    public Double getPrice_unit() {
        return price_unit;
    }

    public List<Accounting_deliveries> getAccounting_deliveries() {
        return accounting_deliveries;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public void setId_product(Long id_product) {
        this.id_product = id_product;
    }

    public void setAccounting_deliveries(List<Accounting_deliveries> accounting_deliveries) {
        this.accounting_deliveries = accounting_deliveries;
    }

    public void setPlan_delivery(Integer plan_delivery) {
        this.plan_delivery = plan_delivery;
    }

    public void setPrice_unit(Double price_unit) {
        this.price_unit = price_unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public void setId_contract(Long id_contract) {
        this.id_contract = id_contract;
    }
}

