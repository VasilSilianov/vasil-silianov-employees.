import records.EmployeesWorkInfo;
import records.WorkedTogether;
import utils.DateCalculator;
import utils.Utils;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeeOperations {

    public static List<WorkedTogether> findEmployeePairWorkedTogether(String filePath) throws IOException, ParseException {
        List<EmployeesWorkInfo> employeesWorkInfoList = Utils.readFile(filePath);
        return findEmployeePairWorkedTogether(employeesWorkInfoList);
    }

    public static List<WorkedTogether> findEmployeePairWorkedTogether(List<EmployeesWorkInfo> employeesWorkInfoList) {
        Map<Integer, List<EmployeesWorkInfo>> groupByProjectId = Utils.groupByProjectId(employeesWorkInfoList);
        List<WorkedTogether> biggestDaysWorkedTogetherForEachProject = new ArrayList<>();
        for (Map.Entry<Integer, List<EmployeesWorkInfo>> entry : groupByProjectId.entrySet()) {
            int projectID = entry.getKey();
            List<EmployeesWorkInfo> EmployeesWorkInfoList = entry.getValue();
            if (EmployeesWorkInfoList.size() > 1) {

                List<WorkedTogether> daysWorkedTogether = new ArrayList<>();
                for (int i = 0; i < EmployeesWorkInfoList.size() - 1; i++) {
                    for (int j = 1; j < EmployeesWorkInfoList.size(); j++) {
                        if (EmployeesWorkInfoList.get(i) != EmployeesWorkInfoList.get(j)) {
                            if (DateCalculator.isOverlapDuration(EmployeesWorkInfoList.get(i), EmployeesWorkInfoList.get(j))) {
                                if (DateCalculator.isOverlapCondition(EmployeesWorkInfoList.get(i), EmployeesWorkInfoList.get(j))) {
                                    WorkedTogether workedTogether = DateCalculator.isOverLapAndFindMin(EmployeesWorkInfoList.get(i), EmployeesWorkInfoList.get(j), projectID);
                                    System.out.println(workedTogether.employeeID1() + ", " + workedTogether.employeeID2() + ", " + workedTogether.daysWorked());
                                    daysWorkedTogether.add(DateCalculator.isOverLapAndFindMin(EmployeesWorkInfoList.get(i), EmployeesWorkInfoList.get(j), projectID));

                                }
                            }
                        }
                    }
                }
                biggestDaysWorkedTogetherForEachProject.add(Utils.findBiggest(daysWorkedTogether));
            }
        }
        return biggestDaysWorkedTogetherForEachProject;
    }


}
