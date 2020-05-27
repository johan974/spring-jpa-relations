package nl.deholtmans.hbrelations.repository;

import nl.deholtmans.hbrelations.entity_seperate_fk.EntitySupplier;
import nl.deholtmans.hbrelations.entity_shared_fk.EntitySharedProduct;
import nl.deholtmans.hbrelations.entity_shared_fk.EntitySharedSupplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface SupplierSharedRepo extends JpaRepository<EntitySharedSupplier, Long> {
}
