package nl.deholtmans.hbrelations.entity_seperate_fk;

import javax.persistence.*;

@Entity
@Table(name = "JOHAN_PRODUCTS")
public class EntityProduct {
    @Id
    @Column(name = "product_id")
    private Long javaProductId;

    @ManyToOne
    @JoinColumn(name = "prod_supplier_id")
    private EntitySupplier supplierRef;

    public EntityProduct() {
    }

    public Long getJavaProductId() {
        return javaProductId;
    }

    public void setJavaProductId(Long javaProductId) {
        this.javaProductId = javaProductId;
    }

    public EntitySupplier getSupplierRef() {
        return supplierRef;
    }

    public void setSupplierRef(EntitySupplier supplierRef) {
        this.supplierRef = supplierRef;
    }

    @Override
    public String toString() {
        return "EntityProduct{" +
                "javaProductId=" + javaProductId + '}';
    }
}

