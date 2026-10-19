package za.ac.cput.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import za.ac.cput.domain.Subject;

public class SubjectFactoryTest {

    String subjectName = "Application Development";
    String subjectCode = "AppDev";
    String department = "Engineering";

    @Test
    void createSubject() {
        Subject subject = SubjectFactory.createSubjectFactory(subjectName,
                subjectCode,
                department);

        assertNotNull(subject);
        assertNotNull(subject.getSubjectId());

        assertEquals(subjectName, subject.getSubjectName());
        assertEquals(subjectCode, subject.getSubjectCode());
        assertEquals(department, subject.getDepartment());
    }

    @Test
    void createSubjectWithNullSubjectName() {
        Subject subject = SubjectFactory.createSubjectFactory(null,
                subjectCode,
                department);

        assertNull(subject);

    }

    @Test
    void createSubjectWithEmptySubjectName() {
        Subject subject = SubjectFactory.createSubjectFactory("",
                subjectCode,
                department);

        assertNull(subject);

    }

    @Test
    void createSubjectWithNullSubjectCode() {
        Subject subject = SubjectFactory.createSubjectFactory(subjectName,
                null,
                department);

        assertNull(subject);

    }

    @Test
    void createSubjectWithEmptySubjectCode() {
        Subject subject = SubjectFactory.createSubjectFactory(subjectName,
                "",
                department);

        assertNull(subject);

    }

    @Test
    void createSubjectWithNullDepartment() {
        Subject subject = SubjectFactory.createSubjectFactory(subjectName,
                subjectCode,
                null);

        assertNull(subject);

    }

    @Test
    void createSubjectWithEmptyDepartment() {
        Subject subject = SubjectFactory.createSubjectFactory(subjectName,
                subjectCode,
                "");

        assertNull(subject);

    }
}