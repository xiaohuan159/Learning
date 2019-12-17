package com.jq.learning.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class NeInfo {
    private String id ="jwx813858";
    private String countryCode = "CN";
    private String cityCode = "xian";
    private String operatorCode = "liantong";
    private String neName;
    private String neType;
    private double coorX;
    private double coorY;
    private String layer;

    public NeInfo(String neName, String neType, double coorX, double coorY, String layer) {
        this.neName = neName;
        this.neType = neType;
        this.coorX = coorX;
        this.coorY = coorY;
        this.layer = layer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    public String getNeName() {
        return neName;
    }

    public void setNeName(String neName) {
        this.neName = neName;
    }

    public String getNeType() {
        return neType;
    }

    public void setNeType(String neType) {
        this.neType = neType;
    }

    public double getCoorX() {
        return coorX;
    }

    public void setCoorX(double coorX) {
        this.coorX = coorX;
    }

    public double getCoorY() {
        return coorY;
    }

    public void setCoorY(double coorY) {
        this.coorY = coorY;
    }

    public String getLayer() {
        return layer;
    }

    public void setLayer(String layer) {
        this.layer = layer;
    }
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        NeInfo neInfo = (NeInfo) o;

        return new EqualsBuilder()
                .append(neName, neInfo.neName)
                .append(neType, neInfo.neType)
                .append(layer, neInfo.layer)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(neName)
                .append(neType)
                .append(layer)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "NeInfo{" +
                "neName='" + neName + '\'' +
                ", neType='" + neType + '\'' +
                ", coorX=" + coorX +
                ", coorY=" + coorY +
                ", layer='" + layer + '\'' +
                '}';
    }
}
