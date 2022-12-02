package dataBaseApp.repositories;

import dataBaseApp.data.Deliveries;
import dataBaseApp.pk.DeliveriesPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveriesRepository extends JpaRepository<Deliveries, DeliveriesPK> {

}
