package nl.deholtmans.hbrelations.entity_seperate_fk;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "JOHAN_SUPPLIER")
public class EntitySupplier {
    @Id
    @Column(name = "supplier_id")
    private Long javaSupplierId;

    @Column(name = "supplier_name")
    private String javaSupplierName;

    @Column(name = "contact_name")
    private String javaSupplierContactName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierRef", orphanRemoval = true)
    private List<EntityProduct> javaProducts;

    public EntitySupplier() {
    }

    public Long getJavaSupplierId() {
        return javaSupplierId;
    }

    public void setJavaSupplierId(Long javaSupplierId) {
        this.javaSupplierId = javaSupplierId;
    }

    public String getJavaSupplierName() {
        return javaSupplierName;
    }

    public void setJavaSupplierName(String javaSupplierName) {
        this.javaSupplierName = javaSupplierName;
    }

    public String getJavaSupplierContactName() {
        return javaSupplierContactName;
    }

    public void setJavaSupplierContactName(String javaSupplierContactName) {
        this.javaSupplierContactName = javaSupplierContactName;
    }

    public List<EntityProduct> getJavaProducts() {
        return javaProducts;
    }

    public void setJavaProducts(List<EntityProduct> products) {
        this.javaProducts = products;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for( EntityProduct productJ : javaProducts) {
            sb.append( "Prod: " + productJ + "\n");
        }
        return "EntitySupplier{" +
                "javaSupplierId=" + javaSupplierId +
                ", javaSupplierName='" + javaSupplierName + '\'' +
                ", javaSupplierContactName='" + javaSupplierContactName + '\'' +
                ", products=" + sb.toString() +
                '}';
    }
}

