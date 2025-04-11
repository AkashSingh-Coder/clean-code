package org.example.basic;

import java.time.LocalDate;

public class InspectedItemTest {

    private LocalDate expirationDate;
    private Boolean approvedForConsumption;
    private Integer inspectorId;

    public InspectedItemTest (LocalDate expirationDate, Boolean approvedForConsumption, Integer inspectorId) {
        this.expirationDate = expirationDate;
        this.approvedForConsumption = approvedForConsumption;
        this.inspectorId = inspectorId;
    }

    public boolean isEdible()
    {
        return this.expirationDate.isAfter(LocalDate.now()) && this.approvedForConsumption && this.inspectorId!=null;

    }
}