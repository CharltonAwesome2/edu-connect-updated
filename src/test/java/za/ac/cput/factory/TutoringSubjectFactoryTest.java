package za.ac.cput.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import za.ac.cput.domain.Subject;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.TutorSubject;

public class TutoringSubjectFactoryTest {

    TutorProfile tutorProfile = new TutorProfile.Builder().build();
    Subject subject = new Subject.Builder().build();

    @Test
    void creatTutorSubject() {
        TutorSubject tutorSubject = TutorSubjectFactory.creatTutorSubject(tutorProfile, subject);

        assertNotNull(tutorSubject);
        assertNotNull(tutorSubject.getTutorSubjectId());

        assertEquals(tutorProfile, tutorSubject.getTutorProfile());
        assertEquals(subject, tutorSubject.getSubject());
    }

    @Test
    void creatTutorSubjectWithNullTutorProfile() {
        TutorSubject tutorSubject = TutorSubjectFactory.creatTutorSubject(null, subject);
        assertNull(tutorSubject);
    }

        @Test
    void creatTutorSubjectWithNullSubject() {
        TutorSubject tutorSubject = TutorSubjectFactory.creatTutorSubject(tutorProfile, null);
        assertNull(tutorSubject);
    }
}
