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
                reportedAt == null) {
            return null;
        }
        Long id = HelperUtil.generateId();

        return Report.builder()
                .reportId(id)
                .reporter(reporter)
                .reportedUser(reportedUser)
                .session(session)
                .reason(reason)
                .description(description)
                .status(status)
                .reportAt(reportedAt)
                .resolvedAt(resolvedAt)
                .build();
    }
}
