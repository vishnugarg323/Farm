package com.farmcollector.repository;

import com.farmcollector.model.PlantingData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PlantingDataRepositoryTest {

    @Autowired
    private PlantingDataRepository plantingDataRepository;

    @Test
    void testFindByFarmId() {
        PlantingData plantingData = new PlantingData();
        plantingData.setFarmId(100L);
        plantingData.setCropType("Corn");
        plantingData.setAreaPlanted(50);
        plantingData.setExpectedAmount(200);

        plantingDataRepository.save(plantingData);

        assertNotNull(plantingDataRepository.findByFarmId(100L));
    }
}
