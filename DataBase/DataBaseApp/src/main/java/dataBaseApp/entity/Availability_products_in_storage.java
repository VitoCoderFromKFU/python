package dataBaseApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dataBaseApp.dto.Availability_products_in_storageRequest;
import dataBaseApp.pk.Availability_products_in_storagePK;
import jakarta.persistence.*;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@IdClass(Availability_products_in_storagePK.class)
@Data
@Table(name = "availability_products_in_storage")
//@Check(constraints = "id_storage IS NOT NULL AND id_product IS NOT NULL")
public class Availability_products_in_storage {


    @Id
    @Column(name = "id_storage")
    private Long idStorage;
    @Id
    @Column(name = "id_product")
    private Long idProduct;
    //@Column(columnDefinition = "varchar(25) default items")
    private String unit;

    //@Column(columnDefinition = "int default 0")
    @Column(name = "count_in_storage")
    private Integer countInStorage = 0;
    @Column(name = "date_last_operation")
    private LocalDate dateLastOperation;

    @JsonIgnore
    @OneToMany(mappedBy = "availability_products_in_storage")
    public List<Accounting_deliveries> accounting_deliveries;


    public Availability_products_in_storage(Long idStorage, Long id_product, String unit, Integer countInStorage) {
        this.idStorage = idStorage;
        this.idProduct = id_product;
        this.unit = unit;
        this.countInStorage = countInStorage;
        //this.date_last_operation TODO: check work trigger in mysql if not then need write query in there

    }

    public Availability_products_in_storagePK getId() {
        return new Availability_products_in_storagePK(idStorage, idProduct);
    }

    public void setId(Availability_products_in_storagePK storagePK) {
        this.idStorage = storagePK.getIdStorage();
        this.idProduct = storagePK.getIdProduct();
    }

    public static Availability_products_in_storage fromDTO(final Availability_products_in_storageRequest storageRequest){
        Availability_products_in_storage storage = new Availability_products_in_storage();
        storage.setIdStorage(storageRequest.getIdStorage());
        storage.setIdProduct(storageRequest.getIdProduct());
        storage.setUnit(storageRequest.getUnit());
        storage.setCountInStorage(storageRequest.getCountInStorage());
        storage.setDateLastOperation(storageRequest.getDateLastOperation());
        return storage;
    }


}
