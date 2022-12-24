package dataBaseApp.repositories;

import dataBaseApp.entity.Deliveries;
import dataBaseApp.pk.DeliveriesPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveriesRepository extends JpaRepository<Deliveries, DeliveriesPK> {
}
