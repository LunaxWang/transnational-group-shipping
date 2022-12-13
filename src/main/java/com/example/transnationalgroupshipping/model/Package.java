package com.example.transnationalgroupshipping.model;

import javax.persistence.*;

@Entity
@Table(name = "packages")
public class Package {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "in_tracking_id")
    private String inTrackingId;

    @Column(name = "in_carrier")
    private String inCarrier;

    @Column(name = "username")   //TODO: many to one
    private String username;

    @Column(name = "address_postcode")
    private String addNPostcode;
    @Column( columnDefinition="Decimal(10,2) default '100.00'")
    private double weight = 0.0;
    private String contents;
    @Column(name = "shipping_method")
    private String shippingMethod;
    @Column( columnDefinition="Decimal(10,2) default '100.00'")
    private double price = 0.0;

    @Column(name = "confirmed_by_user")
    private Boolean confirmedByUser = false;

    private String departureTime;

    @Column(name = "out_tracking_id")
    private String outTrackingId;

    @Column(name = "curr_stage")
    private int currStage;

    public Package() {
    }

    public Package(String inTrackingId, String inCarrier, String username, String address,
                   double weight, String contents,
                   String shippingMethod, double price, Boolean confirmedByUser,
                   String departureTime, String outTrackingId) {
        this.inTrackingId = inTrackingId;
        this.inCarrier = inCarrier;
        this.username = username;
        this.addNPostcode = address;

        this.weight = weight;
        this.contents = contents;
        this.shippingMethod = shippingMethod;
        this.price = price;
        this.confirmedByUser = confirmedByUser;
        this.departureTime = departureTime;
        this.outTrackingId = outTrackingId;
        this.currStage = 1;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInTrackingId() {
        return inTrackingId;
    }

    public void setInTrackingId(String inTrackingId) {
        this.inTrackingId = inTrackingId;
    }

    public String getInCarrier() {
        return inCarrier;
    }

    public void setInCarrier(String inCarrier) {
        this.inCarrier = inCarrier;
    }

    public String getUserName() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddNPostcode() {
        return addNPostcode;
    }

    public void setAddNPostcode(String address) {
        this.addNPostcode = address;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Boolean getConfirmedByUser() {
        return confirmedByUser;
    }

    public void setConfirmedByUser(Boolean confirmedByUser) {
        this.confirmedByUser = confirmedByUser;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getOutTrackingId() {
        return outTrackingId;
    }

    public void setOutTrackingId(String outTrackingId) {
        this.outTrackingId = outTrackingId;
    }

    public int getCurrStage() {
        return currStage;
    }

    public void setCurrStage(int currStage) {
        this.currStage = currStage;
    }
}
