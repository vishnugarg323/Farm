package com.farmcollector.service;

import com.farmcollector.model.HarvestData;
import com.farmcollector.repository.HarvestDataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class HarvestServiceTest {

    @Mock
    private HarvestDataRepository harvestedDataRepository;

    @InjectMocks
    private HarvestService harvestService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateHarvestedData() {
        HarvestData harvestData = new HarvestData();
        harvestData.setFarmId(100L);
        harvestData.setCropType("Corn");
        harvestData.setActualAmount(180);

        when(harvestedDataRepository.save(any(HarvestData.class))).thenReturn(harvestData);

        HarvestData result = harvestService.createHarvestedData(100L, harvestData);
        assertNotNull(result);
        assertEquals("Corn", result.getCropType());
        assertEquals(180, result.getActualAmount());
    }
}
