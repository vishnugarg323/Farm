package com.farmcollector.model;

import java.util.Objects;

public class CropData {

    private String farmName;
    private String cropType;
    private double plantingArea;  // in acres
    private double expectedProduct;  // in tons

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

    public double getPlantingArea() {
        return plantingArea;
    }

    public void setPlantingArea(double plantingArea) {
        this.plantingArea = plantingArea;
    }

    public double getExpectedProduct() {
        return expectedProduct;
    }

    public void setExpectedProduct(double expectedProduct) {
        this.expectedProduct = expectedProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CropData cropData = (CropData) o;
        return Double.compare(plantingArea, cropData.plantingArea) == 0 && Double.compare(
                expectedProduct, cropData.expectedProduct) == 0 && Objects.equals(farmName,
                cropData.farmName) && Objects.equals(cropType, cropData.cropType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(farmName, cropType, plantingArea, expectedProduct);
    }

}
