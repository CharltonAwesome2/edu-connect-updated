/*
    SubjectFactoryTest.java
    Subject Factory Test class
    Author: Reotshepile Stock
    Date: 02 October 2026
*/
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;

import za.ac.cput.domain.Subject;

import static org.junit.jupiter.api.Assertions.*;

class SubjectFactoryTest {

    String subjectName = "Software Development";
    String subjectCode = "ADP372S";
    String department = "ICT";

    @Test
    void createSubject() {

        Subject subject = SubjectFactory.createSubjectFactory(
                subjectName,
                subjectCode,
                department);

        assertNotNull(subject);
        assertNotNull(subject.getSubjectId());
        assertEquals(subjectName, subject.getSubjectName());
        assertEquals(department, subject.getDepartment());
    }

    @Test
    void createSubjectWithNullSubjectName() {

        Subject subject = SubjectFactory.createSubjectFactory(
                null,
                subjectCode,
                department);

        assertNull(subject);
    }

    @Test
    void createSubjectWithEmptySubjectName() {

        Subject subject = SubjectFactory.createSubjectFactory(
                "",
                subjectCode,
                department);

        assertNull(subject);
    }

    @Test
    void createSubjectWithNullSubjectCode() {

        Subject subject = SubjectFactory.createSubjectFactory(
                subjectName,
                null,
                department);

        assertNull(subject);
    }

    @Test
    void createSubjectWithEmptySubjectCode() {

        Subject subject = SubjectFactory.createSubjectFactory(
                subjectName,
                "",
                department);

        assertNull(subject);
    }

    @Test
    void createSubjectWithNullDepartment() {

        Subject subject = SubjectFactory.createSubjectFactory(
                subjectName,
                subjectCode,
                null);

        assertNull(subject);
    }

    @Test
    void createSubjectWithEmptyDepartment() {

        Subject subject = SubjectFactory.createSubjectFactory(
                subjectName,
                subjectCode,
                "");

        assertNull(subject);
    }
}
```
