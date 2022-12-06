package dataBaseApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dataBaseApp.dto.Accounting_deliveriesRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;


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
    @Column(name = "id_document_on_admission")
    private Long idDocumentOnAdmission;
    @Column(name = "id_storage")
    private Long idStorage;
    @Column(name = "id_contract")
    private Long idContract;
    //@Column(insertable=false, updatable=false)
    @Column(name = "id_product")
    private Long idProduct;

    @ColumnDefault("items")
    private String unit = "items";

    @Column(name = "count_products")
    private Integer countProducts;
    @Column(name = "date_of_admission")
    private LocalDate dateOfAdmission;
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


    @JsonIgnore
    @JoinColumns({
            @JoinColumn(name = "id_product", referencedColumnName = "id_product", updatable = false, insertable = false),
            @JoinColumn(name = "id_storage", referencedColumnName = "id_storage", updatable = false, insertable = false)
    })
    @ManyToOne(fetch = FetchType.EAGER)
    public Availability_products_in_storage availability_products_in_storage;

    @JsonIgnore
    @JoinColumns({
            @JoinColumn(name = "id_contract", referencedColumnName = "id_contract", updatable = false, insertable = false),
            @JoinColumn(name = "id_product", referencedColumnName = "id_product", updatable = false, insertable = false)
    })
    @ManyToOne(fetch = FetchType.EAGER)
    public Deliveries deliveries;


    public Accounting_deliveries(Long idStorage, Long idContract, Long idProduct, String unit, Integer countProducts, LocalDate dateOfAdmission) {
        this.idContract = idContract;
        this.idProduct = idProduct;
        this.unit = unit;
        this.countProducts = countProducts;
        this.dateOfAdmission = dateOfAdmission;
        this.idStorage = idStorage;
    }

    public static Accounting_deliveries fromDTO(final Accounting_deliveriesRequest accountingDeliveriesRequest) {
        Accounting_deliveries accountingDeliveries = new Accounting_deliveries();
        accountingDeliveries.setIdStorage(accountingDeliveriesRequest.getIdStorage());
        accountingDeliveries.setIdContract(accountingDeliveriesRequest.getIdContract());
        accountingDeliveries.setIdProduct(accountingDeliveriesRequest.getIdProduct());
        accountingDeliveries.setUnit(accountingDeliveriesRequest.getUnit());
        accountingDeliveries.setCountProducts(accountingDeliveriesRequest.getCountProducts());
        accountingDeliveries.setDateOfAdmission(accountingDeliveriesRequest.getDateOfAdmission());
        return accountingDeliveries;

    }


}
