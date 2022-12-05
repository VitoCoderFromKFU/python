package dataBaseApp.repositories;

import dataBaseApp.dto.ForTask3;
import dataBaseApp.entity.Availability_products_in_storage;
import dataBaseApp.pk.Availability_products_in_storagePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface Availability_products_in_storageRepository extends JpaRepository<Availability_products_in_storage, Availability_products_in_storagePK> {


    List<Availability_products_in_storage> findAllByIdStorage(Long id_storage);
    List<Availability_products_in_storage> findAllByIdProduct(Long id_product);
    @Query("SELECT new dataBaseApp.dto.ForTask3(apis.idStorage,apis.idProduct,apis.unit,apis.countInStorage,apis.dateLastOperation) " +
            "FROM Availability_products_in_storage AS apis,Deliveries AS del,Accounting_deliveries AS ad " +
            "WHERE del.planDelivery>1000 AND 50<ALL(SELECT ac.countProducts FROM Accounting_deliveries AS ac WHERE ac.idContract=del.idContract) " +
            "AND del.idContract=ad.idContract AND ad.idStorage=apis.idStorage")
    List<ForTask3> taskThree();


}
