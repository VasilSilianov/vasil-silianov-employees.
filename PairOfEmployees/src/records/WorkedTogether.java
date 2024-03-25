package records;

public record WorkedTogether(int employeeID1, int employeeID2, int projectID, long daysWorked) {

    @Override
    public int employeeID1() {
        return employeeID1;
    }

    @Override
    public int employeeID2() {
        return employeeID2;
    }

    @Override
    public int projectID() {
        return projectID;
    }

    @Override
    public long daysWorked() {
        return daysWorked;
    }

}
