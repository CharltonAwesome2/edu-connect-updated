package za.ac.cput.domain;

// SubjectClass.java
//Subject model class
//Author:Reotshepile Stock (230875807)
//Date:17 March 2026

public class Subject {

    private Long subjectId;
    private String subjectName;
    private String subjectCode;
    private String department;

    public Subject(){
        
    }

    private Subject(Builder builder) {
        this.subjectId = builder.subjectId;
        this.subjectName = builder.subjectName;
        this.subjectCode = builder.subjectCode;
        this.department = builder.department;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                "department=" + department +
                ", subjectName='" + subjectName + '\'' +
                ", subjectCode='" + subjectCode + '\'' +
                '}';
    }

    public static class Builder {

        private Long subjectId;
        private String subjectName;
        private String subjectCode;
        private String department;

        public Builder setSubjectId(Long subjectId) {
            this.subjectId = subjectId;
            return this;
        }

        public Builder setSubjectName(String subjectName) {
            this.subjectName = subjectName;
            return this;
        }

        public Builder setDepartment(String department) {
            this.department = department;
            return this;
        }

        public Builder setSubjectCoe(String subjectCode){
            this.subjectCode = subjectCode;
            return this;

        }

        public Builder copy(Subject subject) {
            this.subjectId = subject.subjectId;
            this.subjectName = subject.subjectName;
            this.subjectCode = subject.subjectCode;
            this.department = subject.department;

            return this;
        }

        public Subject build() {
            return new Subject(this);
        }
    }
}
