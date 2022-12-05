package dataBaseApp.repositories;

import dataBaseApp.dto.ForTask2;
import dataBaseApp.entity.Accounting_deliveries;
import dataBaseApp.dto.ForTask1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Accounting_deliveriesRepository extends JpaRepository<Accounting_deliveries, Long> {
    List<Accounting_deliveries> findByIdDocumentOnAdmission(Long id_document_on_admission);

    List<Accounting_deliveries> findByIdStorage(Long id_storage);
    List<Accounting_deliveries> findByIdContract(Long id_contract);

    List<Accounting_deliveries> findByIdProduct(Long id_product);

    @Query("select new dataBaseApp.dto.ForTask1(ad.idDocumentOnAdmission, ad.idStorage, ad.idProduct,  ad.dateOfAdmission, " +
            "ad.countProducts,ad.idContract, del.planDelivery, del.endDate) FROM Accounting_deliveries AS ad,Deliveries AS del " +
            "WHERE YEAR(current_date())-YEAR(del.endDate)=0 AND ad.idContract=del.idContract AND ad.idProduct = del.idProduct")
    List<ForTask1> taskOne();

    @Query("SELECT new dataBaseApp.dto.ForTask2(ad.idContract,ad.idProduct,del.planDelivery,del.endDate, SUM(ad.countProducts)) " +
            "FROM Accounting_deliveries AS ad,Deliveries AS del WHERE ad.idContract=del.idContract AND ad.idProduct=del.idProduct " +
            "group by ad.idContract")
    List<ForTask2> taskTwo();
}
/*
    @Query("SELECT ad.id_document_on_admission, ad.id_storage, ad.id_product,  ad.date_of_admission, ad.count_products, "+
            "ad.id_contract, del.plan_delivery, del.end_date FROM accounting_deliveries AS ad,deliveries AS del "+
            " WHERE YEAR(current_date())-YEAR(end_date)=0 AND ad.id_contract=del.id_contract AND ad.id_product = del.id_product",nativeQuery = true)
 */