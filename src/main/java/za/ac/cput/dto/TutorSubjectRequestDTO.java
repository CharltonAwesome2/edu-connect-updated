package za.ac.cput.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TutorSubjectRequestDTO {
    private Long tutorProfileId;
    private Long subjectId;
}