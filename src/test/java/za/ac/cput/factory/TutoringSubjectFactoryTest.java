package za.ac.cput.factory;

import org.junit.jupiter.api.Test;

import za.ac.cput.domain.Subject;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.TutorSubject;

public class TutoringSubjectFactoryTest{

    TutorProfile tutorProfile = new TutorProfile.Builder().build();
    Subject subject = new Subject.Builder().build();

    private TutorSubject tutorSubject = new TutorSubjectFactory().creatTutorSubject(tutorProfile, subject);

    @Test
    void creatTutorSubject(){
        System.out.println(tutorSubject);
    }
}
