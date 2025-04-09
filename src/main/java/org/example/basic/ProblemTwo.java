package org.example.basic;

import java.time.LocalDate;
import java.util.List;

public class ProblemTwo {
    public String transform(List<LocalDate> dates)
    {
        StringBuilder result=new StringBuilder();
        for(LocalDate date:dates){
            if(date.isAfter(LocalDate.now())){
                result.append(date).append("\n");
            }
            else{
                result.append("Delayed\n");
            }
        }
        return result.toString();
    }
}
