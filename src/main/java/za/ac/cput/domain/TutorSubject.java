package za.ac.cput.domain;

/**
 * TutorSubject.java
 * TutorSubject model class
 * Author: Edu Connect Team
 * Date: 30 July 2026
 */
public class TutorSubject {
    private Long tutorSubjectId;
    private TutorProfile tutorProfile;
    private Subject subject;

    public TutorSubject() {
    }

    private TutorSubject(Builder builder) {
        this.tutorSubjectId = builder.tutorSubjectId;
        this.tutorProfile = builder.tutorProfile;
        this.subject = builder.subject;
    }

    public Long getTutorSubjectId() {
        return tutorSubjectId;
    }

    public TutorProfile getTutorProfile() {
        return tutorProfile;
    }

    public Subject getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return "TutorSubject [tutorSubjectId=" + tutorSubjectId + ", tutorProfile=" + tutorProfile + ", subject="
                + subject + "]";
    }

    public static class Builder {
        private Long tutorSubjectId;
        private TutorProfile tutorProfile;
        private Subject subject;

        public Builder setTutorSubjectId(Long tutorSubjectId) {
            this.tutorSubjectId = tutorSubjectId;
            return this;
        }

        public Builder setTutorProfile(TutorProfile tutorProfile) {
            this.tutorProfile = tutorProfile;
            return this;
        }

        public Builder setSubject(Subject subject) {
            this.subject = subject;
            return this;
        }

        public Builder copy(TutorSubject tutorSubject) {
            this.tutorSubjectId = tutorSubject.tutorSubjectId;
            this.tutorProfile = tutorSubject.tutorProfile;
            this.subject = tutorSubject.subject;
            return this;
        }

        public TutorSubject build() {
            return new TutorSubject(this);
        }
    }
}