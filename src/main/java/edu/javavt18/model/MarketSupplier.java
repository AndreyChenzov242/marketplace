package edu.javavt18.model;

import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "supplier")
@NamedQuery(name = "MarketSupplier.findAll", query = "select c from MarketSupplier c")

public class MarketSupplier implements Serializable {
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private int idSupplier;
    @NotEmpty @Column(unique=true, nullable=false)
    private String name;

    @Column private String address;

    @Column private String phoneNumber;

    public MarketSupplier() {}

    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "MarketSupplier{" +
                "idSupplier=" + idSupplier +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}