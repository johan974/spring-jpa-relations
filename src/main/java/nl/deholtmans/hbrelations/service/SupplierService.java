package nl.deholtmans.hbrelations.service;

import nl.deholtmans.hbrelations.entity_seperate_fk.EntityProduct;
import nl.deholtmans.hbrelations.entity_seperate_fk.EntitySupplier;
import nl.deholtmans.hbrelations.repository.SupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierService {
    private final SupplierRepo supplierRepo;

    @Autowired
    public SupplierService(SupplierRepo supplierRepo) {
        this.supplierRepo = supplierRepo;
    }


    public void insertSuppliers() {
        for (long sup = 1000; sup < 1005; sup++) {
            addSupplier(sup);
            System.out.println( "Inserted: " + sup);
        }
    }

    @Transactional
    public void addSupplier(long sup) {
        EntitySupplier supplier = new EntitySupplier();
        supplier.setJavaSupplierId((long) sup);
        supplier.setJavaSupplierName("Supplier-" + sup);
        supplier.setJavaSupplierContactName("Supplier-contact-" + sup);
        List<EntityProduct> products = new ArrayList<>();
        for (int i = 20; i < 23; i++) {
            EntityProduct product = new EntityProduct();
            product.setJavaProductId(sup * 500 + i * 10L);
            product.setSupplierRef(supplier);
            products.add( product);
        }
        supplier.setJavaProducts( products);
        supplierRepo.save(supplier);
    }

    @Transactional
    public void deleteSuppliers() {
        for (long sup = 1000; sup < 1005; sup++) {
            supplierRepo.deleteById( sup);
        }
    }

    @Transactional
    public void showSuppliers() {
        supplierRepo.findAll().forEach( s -> System.out.println( s));
    }
}
