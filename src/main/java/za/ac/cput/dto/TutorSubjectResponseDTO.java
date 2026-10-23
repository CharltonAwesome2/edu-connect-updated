package za.ac.cput.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TutorSubjectResponseDTO {
    private Long tutorSubjectId;
    private Long tutorProfileId;
    private String tutorName;
    private Long subjectId;
    private String subjectName;
    private String subjectCode;
}