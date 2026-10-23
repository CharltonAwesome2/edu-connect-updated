package za.ac.cput.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import za.ac.cput.enums.ReportStatus;

@Data
@Builder
@Entity
@Table(name = "report")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
