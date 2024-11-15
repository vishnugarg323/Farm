package com.farmcollector.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

/**
 * Entity class representing the harvested data of a specific farm.
 * Contains information about the crops harvested and the actual yield.
 */
@Entity
public class HarvestData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long farmId;
    private String cropType;
    private double actualAmount;  // in tons

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

    public double getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(double actualAmount) {
        this.actualAmount = actualAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        HarvestData that = (HarvestData) o;
        return Double.compare(actualAmount, that.actualAmount) == 0 && Objects.equals(id,
                that.id) && Objects.equals(farmId, that.farmId) && Objects.equals(cropType,
                that.cropType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, farmId, cropType, actualAmount);
    }
}
