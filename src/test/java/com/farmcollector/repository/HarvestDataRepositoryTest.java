package com.farmcollector.repository;

import com.farmcollector.model.HarvestData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class HarvestDataRepositoryTest {

    @Autowired
    private HarvestDataRepository harvestDataRepository;

    @Test
    void testFindByFarmId() {
        HarvestData harvestData = new HarvestData();
        harvestData.setFarmId(100L);
        harvestData.setCropType("Corn");
        harvestData.setActualAmount(180);

        harvestDataRepository.save(harvestData);

        assertNotNull(harvestDataRepository.findByFarmId(100L));
    }
}
