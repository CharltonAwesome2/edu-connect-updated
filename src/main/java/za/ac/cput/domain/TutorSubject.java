

public class TutorSubject {
    private Long tutorSubjectId;
    private Long tutorProfileId;
    private Long subjectId;

    public Long getTutorSubjectId() {
        return tutorSubjectId;
    }

    public Long getTutorProfileId() {
        return tutorProfileId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public static class Builder {
        private Long tutorSubjectId;
        private Long tutorProfileId;
        private Long subjectId;

        public Builder setTutorSubjectId(Long tutorSubjectId) {
            this.tutorSubjectId = tutorSubjectId;
            return this;
        }

        public Builder setTutorProfileId(Long tutorProfileId) {
            this.tutorProfileId = tutorProfileId;
            return this;
        }

        public Builder setSubjectId(Long subjectId) {
            this.subjectId = subjectId;
            return this;
        }

        public Builder co() {
        }
    }
}