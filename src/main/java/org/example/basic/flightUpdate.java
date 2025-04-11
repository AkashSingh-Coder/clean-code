package org.example.basic;

import java.time.LocalDate;
import java.util.List;

public class flightUpdate{
    private static final String STATUS="Delayed";
    final String BREAK_LINE="\n";
    public String flight_status(List<LocalDate> arrival_dates)
    {
        StringBuilder result=new StringBuilder();
        for(LocalDate date:arrival_dates){
            if(date.isAfter(LocalDate.now())){
                result.append(date).append(BREAK_LINE);
            }
            else{
                result.append(STATUS);
            }
        }
        return result.toString();
    }
}
