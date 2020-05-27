package nl.deholtmans.hbrelations.repository;

import nl.deholtmans.hbrelations.entity_seperate_fk.EntityProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ProductRepo extends JpaRepository<EntityProduct, Long> {
}
