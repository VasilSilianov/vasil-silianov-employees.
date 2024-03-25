package utils;

import records.EmployeesWorkInfo;
import records.WorkedTogether;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateCalculator {

    public static boolean isOverlapDuration(EmployeesWorkInfo employee1, EmployeesWorkInfo employee2){
        long overlap  = Math.min(employee1.getDateTo().toEpochDay(), employee2.getDateTo().toEpochDay()) - Math.max(employee1.getDateFrom().toEpochDay(),employee2.getDateFrom().toEpochDay());
    return overlap >=0;
    }

    public  static boolean isOverlapCondition(EmployeesWorkInfo employee1, EmployeesWorkInfo employee2){
        return !(employee1.getDateTo().isBefore(employee2.getDateFrom()) || employee1.getDateFrom().isAfter(employee2.getDateTo()));
    }

    public  static WorkedTogether isOverLapAndFindMin(EmployeesWorkInfo employee1, EmployeesWorkInfo employee2 , int projectID) {
        long overlap1 = Math.min(employee1.getDateTo().toEpochDay() - employee1.getDateFrom().toEpochDay(),
                employee1.getDateTo().toEpochDay() - employee2.getDateFrom().toEpochDay());
        long overlap2 = Math.min(employee2.getDateTo().toEpochDay() - employee2.getDateFrom().toEpochDay(),
                employee2.getDateTo().toEpochDay() - employee1.getDateFrom().toEpochDay());
        long daysWorked = (Math.min(overlap1, overlap2)) + 1; // the interval to be inclusive  +1

        return new WorkedTogether(employee1.getEmployeeID(),employee2.getEmployeeID(), projectID,daysWorked);
    }
}
