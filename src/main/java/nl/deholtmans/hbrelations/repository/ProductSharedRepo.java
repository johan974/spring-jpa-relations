package nl.deholtmans.hbrelations.repository;

import nl.deholtmans.hbrelations.entity_shared_fk.EntitySharedProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ProductSharedRepo extends JpaRepository<EntitySharedProduct, Long> {
}
