package za.ac.cput.factory;

import za.ac.cput.domain.Subject;
import za.ac.cput.util.HelperUtil;

public class SubjectFactory {

    public static Subject createSubjectFactory(String subjectName, String subjectCode, String department) {

        if (!HelperUtil.isNullOrEmpty(subjectName) ||
                !HelperUtil.isNullOrEmpty(subjectCode) ||
                !HelperUtil.isNullOrEmpty(department)) {
            return null;
        }

        Long id = HelperUtil.generateId();

        return Subject.builder()
                .subjectId(id)
                .subjectName(subjectName)
                .subjectCode(subjectCode)
                .department(department)
                .build();
    }
}