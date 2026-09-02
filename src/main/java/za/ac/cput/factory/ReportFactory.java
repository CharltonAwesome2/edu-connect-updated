/*
  ReportFactory.java
  Report Factory class
  Author: Nolwazi Zulu (220118876)
  Date: 23 March 2026 
  */

package za.ac.cput.factory;

import java.time.LocalDateTime;
import za.ac.cput.domain.Report;
import za.ac.cput.domain.User;
import za.ac.cput.util.HelperUtil;

public class ReportFactory {

    public static Report createReport(String reason,
            LocalDateTime reportDate,
            User reporter,
            User reportedUser) {

        if (HelperUtil.isNullOrEmpty(reason)
                || reportDate == null
                || reporter == null
                || reportedUser == null) {
            return null;
        }
        Long reportId = HelperUtil.generateId();

        return new Report.Builder()
                .setReportId(reportId)
                .setReason(reason)
                .setReportDate(reportDate)
                .setReporter(reporter)
                .setReportedUser(reportedUser)
                .build();
    }
}
