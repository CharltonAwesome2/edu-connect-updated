package za.ac.cput.factory;

import za.ac.cput.domain.Subject;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.TutorSubject;
import za.ac.cput.util.HelperUtil;

public class TutorSubjectFactory {

    public static TutorSubject creatTutorSubject(TutorProfile tutorProfile, Subject subject) {

        if (tutorProfile == null || subject == null) {
            return null;
        }

        Long id = HelperUtil.generateId();

        return TutorSubject.builder()
                .tutorSubjectId(id)
                .tutorProfile(tutorProfile)
                .subject(subject)
                .build();

    }
}