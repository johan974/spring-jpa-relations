package nl.deholtmans.hbrelations;

import nl.deholtmans.hbrelations.repository.SupplierSharedRepo;
import nl.deholtmans.hbrelations.service.SupplierService;
import nl.deholtmans.hbrelations.service.SupplierSharedService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    private final SupplierService sup;
    private final SupplierSharedService supShared;

    public MainApplication(SupplierService sup,
                           SupplierSharedService supShared) {
        this.sup = sup;
        this.supShared = supShared;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            System.out.println("\nInsert suppliers with products  ...");
            sup.insertSuppliers();

            System.out.println("\nShow suppliers with products...");
            sup.showSuppliers();

            System.out.println("\nDelete all suppliers...");
            sup.deleteSuppliers();

            System.out.println( "\nDONE!");

            System.out.println("\nInsert suppliers with products  ...");
            supShared.insertSharedSuppliers();

            System.out.println("\nShow suppliers with products...");
            supShared.showSharedSuppliers();

            System.out.println("\nDelete all suppliers...");
            supShared.deleteSharedSuppliers();

            System.out.println( "\nDONE!");
        };
    }
}
