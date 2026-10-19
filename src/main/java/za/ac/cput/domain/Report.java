package za.ac.cput.domain;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
import za.ac.cput.enums.ReportStatus;

@Data 
@Builder
public class Report {

    private Long reportId;
    private User reporter;
    private User reportedUser;
    private TutoringSession session;
    private String reason;
    private String description;
    private ReportStatus status;
    private LocalDateTime reportAt;
    private LocalDateTime resolvedAt;

}
