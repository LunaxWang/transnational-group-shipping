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

    @Column(name = "user_id")   //TODO: many to one
    private long userId;

    private String address;

    private String postcode;

    @Column(name = "received_by_tgs")
    private Boolean receivedByTGS;

    private double weight;

    private String contents;

    @Column(name = "shipping_method")
    private String shippingMethod;

    private double price;

    @Column(name = "confirmed_by_user")
    private Boolean confirmedByUser;

    private String departureTime;

    @Column(name = "out_tracking-id")
    private String outTrackingId;

    public Package() {
    }

    public Package(String inTrackingId, String inCarrier, long userId, String address,
                   String postcode, Boolean receivedByTGS, double weight, String contents,
                   String shippingMethod, double price, Boolean confirmedByUser,
                   String departureTime, String outTrackingId) {
        this.inTrackingId = inTrackingId;
        this.inCarrier = inCarrier;
        this.userId = userId;
        this.address = address;
        this.postcode = postcode;
        this.receivedByTGS = receivedByTGS;
        this.weight = weight;
        this.contents = contents;
        this.shippingMethod = shippingMethod;
        this.price = price;
        this.confirmedByUser = confirmedByUser;
        this.departureTime = departureTime;
        this.outTrackingId = outTrackingId;
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Boolean getReceivedByTGS() {
        return receivedByTGS;
    }

    public void setReceivedByTGS(Boolean receivedByTGS) {
        this.receivedByTGS = receivedByTGS;
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
}
