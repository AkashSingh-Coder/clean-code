package org.example.basic;

import java.time.LocalDate;

public class ProblemOne {

    private LocalDate expirationDate;
    private Boolean approvedForConsumption;
    private Integer inspectorId;

    public ProblemOne(LocalDate expirationDate, Boolean approvedForConsumption, Integer inspectorId) {
        this.expirationDate = expirationDate;
        this.approvedForConsumption = approvedForConsumption;
        this.inspectorId = inspectorId;
    }

    public boolean isEdible()
    {
        return this.expirationDate.isAfter(LocalDate.now()) && this.approvedForConsumption && this.inspectorId!=null;

    }
}