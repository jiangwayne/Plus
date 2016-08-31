package com.plus.server.model;

import java.util.Date;

public class Plan {
    private Long id;

    private Integer planeId;

    private String model;

    private Integer passengers;

    private String manufacturer;

    private Integer merchantId;

    private Date deliveryTime;

    private String outsideUrl;

    private String insideUrl;

    private String seatUrl;

    private Integer valid;

    private Date gmtCreate;

    private Date gmtModify;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPlaneId() {
        return planeId;
    }

    public void setPlaneId(Integer planeId) {
        this.planeId = planeId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public Integer getPassengers() {
        return passengers;
    }

    public void setPassengers(Integer passengers) {
        this.passengers = passengers;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getOutsideUrl() {
        return outsideUrl;
    }

    public void setOutsideUrl(String outsideUrl) {
        this.outsideUrl = outsideUrl == null ? null : outsideUrl.trim();
    }

    public String getInsideUrl() {
        return insideUrl;
    }

    public void setInsideUrl(String insideUrl) {
        this.insideUrl = insideUrl == null ? null : insideUrl.trim();
    }

    public String getSeatUrl() {
        return seatUrl;
    }

    public void setSeatUrl(String seatUrl) {
        this.seatUrl = seatUrl == null ? null : seatUrl.trim();
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }
}