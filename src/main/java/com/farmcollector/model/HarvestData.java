package com.farmcollector.model;

import java.util.Objects;

public class HarvestData {
    private String farmName;
    private String cropType;
    private double harvestedProduct;  // in tons

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public String getCropType() {
        return cropType;
    }

    public void setCropType(String cropType) {
        this.cropType = cropType;
    }

    public double getHarvestedProduct() {
        return harvestedProduct;
    }

    public void setHarvestedProduct(double harvestedProduct) {
        this.harvestedProduct = harvestedProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        HarvestData that = (HarvestData) o;
        return Double.compare(harvestedProduct, that.harvestedProduct) == 0 && Objects.equals(
                farmName, that.farmName) && Objects.equals(cropType, that.cropType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(farmName, cropType, harvestedProduct);
    }
}
