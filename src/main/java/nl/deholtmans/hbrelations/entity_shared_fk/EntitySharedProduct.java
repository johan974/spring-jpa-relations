package nl.deholtmans.hbrelations.entity_shared_fk;

import javax.persistence.*;

@Entity
@Table(name = "JOHAN_SHARED_PRODUCTS")
public class EntitySharedProduct {
    @Id
    @Column(name = "shared_supplier_id")
    private Long javaSupplierSharedId;

    //@MapsId
    @PrimaryKeyJoinColumn
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="shared_supplier_id")
    private EntitySharedSupplier supplierSharedRef;

    @Column(name = "prod_supplier_name")
    private String javaSharedProductName;

    public EntitySharedProduct() {
    }

    public Long getJavaSupplierSharedId() {
        return javaSupplierSharedId;
    }

    public void setJavaSupplierSharedId(Long javaSupplierSharedId) {
        this.javaSupplierSharedId = javaSupplierSharedId;
    }

    public EntitySharedSupplier getSupplierSharedRef() {
        return supplierSharedRef;
    }

    public void setSupplierSharedRef(EntitySharedSupplier supplierSharedRef) {
        this.supplierSharedRef = supplierSharedRef;
    }

    public String getJavaSharedProductName() {
        return javaSharedProductName;
    }

    public void setJavaSharedProductName(String javaSharedProductName) {
        this.javaSharedProductName = javaSharedProductName;
    }

    @Override
    public String toString() {
        return "EntitySharedProduct{" +
                "javaSharedSupplierId=" + javaSupplierSharedId +
                ", javaSharedProductName=" + javaSharedProductName +
                '}';
    }
}

