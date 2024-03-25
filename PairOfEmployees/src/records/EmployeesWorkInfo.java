package records;

import java.time.LocalDate;

public class EmployeesWorkInfo {
    private int employeeID;
    private int projectID;
    private LocalDate dateFrom;
    private LocalDate  dateTo;

    public EmployeesWorkInfo(int employeeID, int projectID, LocalDate  dateFrom, LocalDate  dateTo) {
        this.employeeID = employeeID;
        this.projectID = projectID;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public int getProjectID() {
        return projectID;
    }

    public LocalDate  getDateFrom() {
        return dateFrom;
    }

    public LocalDate  getDateTo() {
        return dateTo;
    }

    @Override
    public String toString() {
        return "EmployeesProjects{" +
                "employeeID=" + employeeID +
                ", projectID=" + projectID +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                '}';
    }
}
