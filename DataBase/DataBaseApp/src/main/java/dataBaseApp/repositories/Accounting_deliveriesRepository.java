package dataBaseApp.repositories;

import dataBaseApp.data.Accounting_deliveries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Accounting_deliveriesRepository extends JpaRepository<Accounting_deliveries,Long> {

}
