package za.ac.cput.factory;

import org.junit.jupiter.api.Test;

import za.ac.cput.domain.Subject;

public class SubjectFactoryTest {

    String subjectName = "Application Development";
    String subjectCode = "AppDev";
    String department = "Engineering";

    private Subject subject = SubjectFactory.createSubjectFactory(subjectName,
            subjectCode,
            department);

    @Test
    void createSubject() {
        System.out.println(subject);

    }
}