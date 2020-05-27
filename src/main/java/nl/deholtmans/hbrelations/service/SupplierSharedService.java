package nl.deholtmans.hbrelations.service;

import nl.deholtmans.hbrelations.entity_shared_fk.EntitySharedProduct;
import nl.deholtmans.hbrelations.entity_shared_fk.EntitySharedSupplier;
import nl.deholtmans.hbrelations.repository.ProductSharedRepo;
import nl.deholtmans.hbrelations.repository.SupplierSharedRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SupplierSharedService {
    private final SupplierSharedRepo supplierSharedRepo;
    private final ProductSharedRepo productSharedRepo;

    @Autowired
    public SupplierSharedService(SupplierSharedRepo supplierSharedRepo,
                                 ProductSharedRepo productSharedRepo) {
        this.supplierSharedRepo = supplierSharedRepo;
        this.productSharedRepo = productSharedRepo;
    }


    public void insertSharedSuppliers() {
        for (int sup = 2000; sup < 2005; sup++) {
            saveSupplier(sup);
        }
    }

    @Transactional
    public void saveSupplier(int sup) {
        EntitySharedSupplier supplier = new EntitySharedSupplier();
        supplier.setJavaSharedSupplierName("SharedSupplier-" + sup);
        supplier.setJavaSharedSupplierContactName("SharedSupplier-contact-" + sup);
        EntitySharedProduct product = new EntitySharedProduct();
        product.setJavaSharedProductName("SharedSupplier-Book-" + sup);
        product.setSupplierSharedRef(supplier);
        supplier.setJavaSharedProduct( product);
        supplier.setJavaSharedSupplierId((long) sup);
        // supplierSharedRepo.save(supplier);
        // productSharedRepo.save( product);
        supplierSharedRepo.save(supplier);
    }

    @Transactional
    public void deleteSharedSuppliers() {
        for (long sup = 2000; sup < 2005; sup++) {
            supplierSharedRepo.deleteById(sup);
        }
    }

    @Transactional
    public void showSharedSuppliers() {
        supplierSharedRepo.findAll().forEach(s -> System.out.println(s));
    }
}
