package com.farmcollector.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

/**
 * Entity class representing the planting data of a specific farm.
 * Contains information about the crops planted, expected yield, and the area planted.
 */
@Entity
public class PlantingData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long farmId;
    private String cropType;
    private double areaPlanted;  // in acres
    private double expectedAmount;  // in tons

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFarmId() {
        return farmId;
    }

    public void setFarmId(Long farmId) {
        this.farmId = farmId;
    }

    public String getCropType() {
        return cropType;
    }

    public void setCropType(String cropType) {
        this.cropType = cropType;
    }

    public double getAreaPlanted() {
        return areaPlanted;
    }

    public void setAreaPlanted(double areaPlanted) {
        this.areaPlanted = areaPlanted;
    }

    public double getExpectedAmount() {
        return expectedAmount;
    }

    public void setExpectedAmount(double expectedAmount) {
        this.expectedAmount = expectedAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PlantingData that = (PlantingData) o;
        return Double.compare(areaPlanted, that.areaPlanted) == 0 && Double.compare(expectedAmount,
                that.expectedAmount) == 0 && Objects.equals(id, that.id) && Objects.equals(farmId,
                that.farmId) && Objects.equals(cropType, that.cropType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, farmId, cropType, areaPlanted, expectedAmount);
    }
}
