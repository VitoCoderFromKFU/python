package dataBaseApp.repositories;

import dataBaseApp.dto.ForTask1;
import dataBaseApp.dto.ForTask2;
import dataBaseApp.entity.Accounting_deliveries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Accounting_deliveriesRepository extends JpaRepository<Accounting_deliveries, Long> {

    @Query("select new dataBaseApp.dto.ForTask1(ad.idDocumentOnAdmission, ad.idStorage, ad.idProduct,  ad.dateOfAdmission, " +
            "ad.countProducts,ad.idContract, del.planDelivery, del.endDate) FROM Accounting_deliveries AS ad,Deliveries AS del " +
            "WHERE YEAR(current_date())-YEAR(del.endDate)=0 AND ad.idContract=del.idContract AND ad.idProduct = del.idProduct")
    List<ForTask1> taskOne();

    @Query("SELECT new dataBaseApp.dto.ForTask2(ad.idContract,ad.idProduct,del.planDelivery,del.endDate, SUM(ad.countProducts)) " +
            "FROM Accounting_deliveries AS ad,Deliveries AS del WHERE ad.idContract=del.idContract AND ad.idProduct=del.idProduct " +
            "group by ad.idContract")
    List<ForTask2> taskTwo();
}
