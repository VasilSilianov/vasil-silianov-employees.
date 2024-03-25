package utils;

import records.EmployeesWorkInfo;
import records.WorkedTogether;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {


    public static List<EmployeesWorkInfo> readFile(String filePath) throws IOException {
        LocalDate date = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth());
        File file = new File(filePath);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        List<EmployeesWorkInfo> employeesWorkInfoList = new ArrayList<>();
        String currentLine;
        int employeeID;
        int projectID;
        LocalDate dateFrom;
        LocalDate dateTo;
       bufferedReader.readLine();
        while ((currentLine = bufferedReader.readLine()) != null) {
            String[] currentLineData = currentLine.split(",");
            employeeID = Integer.parseInt(currentLineData[0].trim());
            projectID = Integer.parseInt(currentLineData[1].trim());
            dateFrom = LocalDate.parse(currentLineData[2].trim(), DateTimeFormatter.ofPattern("[yyyy-MM-dd][yyyy/MM/dd][yyyy:MM:dd][yyyy-M-dd][yyyy-M-d][yyyy-MM-d]"));
            dateTo = currentLineData[3].trim().equalsIgnoreCase("NULL") ? date : LocalDate.parse(currentLineData[3].trim(), DateTimeFormatter.ofPattern("[yyyy-MM-dd][yyyy/MM/dd][yyyy:MM:dd][yyyy-M-dd][yyyy-M-d][yyyy-MM-d]"));
            employeesWorkInfoList.add(new EmployeesWorkInfo(employeeID, projectID, dateFrom, dateTo));
        }
        return employeesWorkInfoList;
    }

    public static Map<Integer, List<EmployeesWorkInfo>> groupByProjectId(List<EmployeesWorkInfo> employeesWorkInfoList) {

        Map<Integer, List<EmployeesWorkInfo>> groupEmployeesProjectsListByProjectID = new HashMap<>();

        for (EmployeesWorkInfo employeesWorkInfo : employeesWorkInfoList) {
            if (!groupEmployeesProjectsListByProjectID.containsKey(employeesWorkInfo.getProjectID())) {
                groupEmployeesProjectsListByProjectID.put(employeesWorkInfo.getProjectID(), new ArrayList<>());
                groupEmployeesProjectsListByProjectID.get(employeesWorkInfo.getProjectID()).add(employeesWorkInfo);
                continue;
            }
            groupEmployeesProjectsListByProjectID.get(employeesWorkInfo.getProjectID()).add(employeesWorkInfo);
        }
        return groupEmployeesProjectsListByProjectID;
    }


    public static WorkedTogether findBiggest(List<WorkedTogether> workedTogetherList) {

        WorkedTogether biggest = workedTogetherList.getFirst();
        if (workedTogetherList.size() > 1) {
            for (int i = 1; i < workedTogetherList.size(); i++) {
                if (biggest.daysWorked() < workedTogetherList.get(i).daysWorked()) {
                    biggest = workedTogetherList.get(i);
                }
            }
        }
        return biggest;
    }

    //    Employee ID #1, Employee ID #2, Project ID, Days worked
    public static String printWorkedTogether(List<WorkedTogether> workedTogetherList) {
        StringBuilder sb = new StringBuilder();
        for (WorkedTogether workedTogether : workedTogetherList) {
            sb.append(workedTogether.employeeID1()).append(", ");
            sb.append(workedTogether.employeeID2()).append(", ");
            sb.append(workedTogether.projectID()).append(", ");
            sb.append(workedTogether.daysWorked()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
