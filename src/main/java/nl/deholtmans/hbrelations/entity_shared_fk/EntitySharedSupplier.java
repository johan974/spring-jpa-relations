package nl.deholtmans.hbrelations.entity_shared_fk;

import javax.persistence.*;

@Entity
@Table(name = "JOHAN_SHARED_SUPPLIER")
public class EntitySharedSupplier {
    @Id
    @Column(name = "supplier_shared_id")
    private Long javaSharedSupplierId;

    @Column(name = "supplier_shared_name")
    private String javaSharedSupplierName;

    @Column(name = "contact_shared_name")
    private String javaSharedSupplierContactName;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,
            mappedBy = "supplierSharedRef", orphanRemoval = true)
    private EntitySharedProduct javaSharedProduct;

    public EntitySharedSupplier() {
    }

    public Long getJavaSharedSupplierId() {
        return javaSharedSupplierId;
    }

    public void setJavaSharedSupplierId(Long javaSupplierId) {
        this.javaSharedSupplierId = javaSupplierId;
        if( javaSharedProduct != null) {
            javaSharedProduct.setJavaSupplierSharedId( javaSupplierId);
        }
    }

    public String getJavaSharedSupplierName() {
        return javaSharedSupplierName;
    }

    public void setJavaSharedSupplierName(String javaSupplierName) {
        this.javaSharedSupplierName = javaSupplierName;
    }

    public String getJavaSharedSupplierContactName() {
        return javaSharedSupplierContactName;
    }

    public void setJavaSharedSupplierContactName(String javaSupplierContactName) {
        this.javaSharedSupplierContactName = javaSupplierContactName;
    }

    public EntitySharedProduct getJavaSharedProduct() {
        return javaSharedProduct;
    }

    public void setJavaSharedProduct(EntitySharedProduct javaSharedProducts) {
        this.javaSharedProduct = javaSharedProducts;
    }

    @Override
    public String toString() {
        return "EntitySharedSupplier{" +
                "javaSharedSupplierId=" + javaSharedSupplierId +
                ", javaSharedSupplierName='" + javaSharedSupplierName + '\'' +
                ", javaSharedSupplierContactName='" + javaSharedSupplierContactName + '\'' +
                ", javaSharedProduct=" + javaSharedProduct +
                '}';
    }
}

