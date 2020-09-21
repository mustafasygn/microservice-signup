package com.eureka.user.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "user")
public class User implements Serializable{

    private static final long serialVersionUID = 9097639215351514001L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    @Column(name = "merchant_type")
    String merchantType;

    @NotNull
    @Column(name = "merchant_name")
    String merchantName;

    @NotNull
    @Column(name = "owner_name")
    String ownerName;

    @NotNull
    @Column(name = "address")
    String address;

    @NotNull
    @Column(name = "phone_number")
    String phoneNumber;

    @NotNull
    @Column(name = "email_address")
    String emailAddress;

    @NotNull
    @Column(name = "password")
    String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMerchantType() {
        return merchantType;
    }

    public void setMerchantType(String merchantType) {
        this.merchantType = merchantType;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) &&
                merchantType.equals(user.merchantType) &&
                merchantName.equals(user.merchantName) &&
                ownerName.equals(user.ownerName) &&
                address.equals(user.address) &&
                phoneNumber.equals(user.phoneNumber) &&
                emailAddress.equals(user.emailAddress) &&
                password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, merchantType, merchantName, ownerName, address, phoneNumber, emailAddress, password);
    }
}
