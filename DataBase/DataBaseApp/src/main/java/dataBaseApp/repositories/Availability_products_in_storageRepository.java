package dataBaseApp.repositories;

import dataBaseApp.data.Availability_products_in_storage;
import dataBaseApp.pk.Availability_products_in_storagePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Availability_products_in_storageRepository extends JpaRepository<Availability_products_in_storage, Availability_products_in_storagePK> {

}
