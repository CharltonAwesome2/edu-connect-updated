package za.ac.cput.domain;

import java.time.LocalDateTime;

/**
 * User.java
 * User model class
 * Author: Lesego Kutlwano Tshabalala (240263952)
 * Date: 22/07/2026
 */

public class User {

    private long userId;
    private String name;
    private String surname;
    private String studentNumber;
    private String email;
    private String contactNumber;
    private LocalDateTime createdAt;
    private Boolean isTutor;
    private Boolean isStudent;

    private User(Builder builder) {
        this.userId = builder.userId;
        this.name = builder.name;
        this.surname = builder.surname;
        this.studentNumber = builder.studentNumber;
        this.email = builder.email;
        this.contactNumber = builder.contactNumber;
        this.createdAt = builder.createdAt;
        this.isTutor= builder.isTutor;
        this.isStudent= builder.isStudent;
    }

    public long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Boolean getIsTutor(){return isTutor;}

    public Boolean getIsStudent(){return isStudent;}


    @Override
    public String toString() {
        return "User [userId=" + userId + ", name=" + name + ", surname=" + surname + ", studentNumber=" + studentNumber
                + ", email=" + email + ", contactNumber=" + contactNumber + ", createdAt=" + createdAt + ", isTutor=" + isTutor + ", isStudent=" + isStudent +  "]";
    }

    public static class Builder {
        private long userId;
        private String name;
        private String surname;
        private String studentNumber;
        private String email;
        private String contactNumber;
        private LocalDateTime createdAt;
        private  Boolean isTutor;
        private Boolean isStudent;

        public Builder setUserId(long userId) {
            this.userId = userId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder setStudentNumber(String studentNumber) {
            this.studentNumber = studentNumber;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setContactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
            return this;
        }

        public Builder setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder setIsTutor(Boolean isTutor) {
            this.isTutor = isTutor;
            return this;
        }

        public Builder setIsStudent(Boolean isStudent) {
            this.isStudent = isStudent;
            return this;
        }

        public Builder copy(User user) {
            this.userId = user.userId;
            this.name = user.name;
            this.surname = user.surname;
            this.studentNumber = user.studentNumber;
            this.email = user.email;
            this.contactNumber = user.contactNumber;
            this.createdAt = user.createdAt;
            this.isTutor = user.isTutor;
            this.isStudent = user.isStudent;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

}
