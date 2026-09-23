/*
  ReportFactory.java
  Report Factory class
  Author: Nolwazi Zulu (220118876)
  Date: 05 September 2026
*/

package za.ac.cput.factory;

import java.time.LocalDateTime;
import za.ac.cput.domain.Report;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.domain.User;
import za.ac.cput.enums.ReportStatus;
import za.ac.cput.util.HelperUtil;

public class ReportFactory {

    public static Report createReport(User reporter,
            User reportedUser,
            TutoringSession session,
            String reason,
            String description,
            ReportStatus status,
            LocalDateTime reportedAt,
            LocalDateTime resolvedAt) {

        if (reporter == null ||
                reportedUser == null ||
                session == null ||
                HelperUtil.isNullOrEmpty(reason) ||
                HelperUtil.isNullOrEmpty(description) ||
                status == null ||
                reportedAt == null ||
                resolvedAt == null) {
            return null;
        }
        Long id = HelperUtil.generateId();

        return new Report.Builder()
                .setReportId(id)
                .setReporter(reporter)
                .setReportedUser(reportedUser)
                .setSession(session)
                .setReason(reason)
                .setDescription(description)
                .setStatus(status)
                .setReportedAt(reportedAt)
                .setResolvedAt(resolvedAt)
                .build();
    }
}
