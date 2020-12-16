package edu.javavt18.model;

import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="product")
@NamedQuery(name="MarketProduct.findAll", query="select m from MarketProduct m")

public class MarketProduct implements Serializable {
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private int idProduct;

    @Column(insertable = false, updatable = false)
    private int idSupplier;

    @ManyToOne
    @JoinColumn(name = "idSupplier")
    private MarketSupplier marketSupplier;

    @NotEmpty @Column
    private String productName;
    @Column private String description;
    @Column private short productionYear;
    public MarketProduct() {}

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }

    public MarketSupplier getMarketSupplier() {
        return marketSupplier;
    }

    public void setMarketSupplier(MarketSupplier marketSupplier) {
        this.marketSupplier = marketSupplier;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public short getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(short productionYear) {
        this.productionYear = productionYear;
    }

    @Override
    public String toString() {
        return "MarketProduct{" +
                "idProduct=" + idProduct +
                ", idSupplier=" + idSupplier +
                ", marketSupplier=" + marketSupplier +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", productionYear=" + productionYear +
                '}';
    }
}