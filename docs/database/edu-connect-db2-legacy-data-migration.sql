-- EduConnect legacy schema compatibility migration
-- Target: MySQL 8.x, database edu-connect-db2
-- Run with an administrator account before starting the application.
-- This migration preserves the legacy users/users and booking_requests tables.

USE `edu-connect-db2`;

-- Copy legacy users into the table used by the current JPA model.
INSERT INTO `app_user`
    (`user_id`, `contact_number`, `created_at`, `email`, `is_admin`,
     `is_student`, `is_tutor`, `name`, `student_number`, `surname`)
SELECT
    u.`user_id`,
    u.`contact_number`,
    COALESCE(u.`created_at`, CURRENT_TIMESTAMP(6)),
    u.`email`,
    NULL,
    COALESCE(u.`is_student`, b'0'),
    COALESCE(u.`is_tutor`, b'0'),
    u.`name`,
    u.`student_number`,
    u.`surname`
FROM `users` u
WHERE NOT EXISTS (
    SELECT 1 FROM `app_user` a WHERE a.`user_id` = u.`user_id`
);

-- Add the field required by the current Notification entity.
ALTER TABLE `notification`
    ADD COLUMN IF NOT EXISTS `created_at` datetime(6)
    NOT NULL DEFAULT CURRENT_TIMESTAMP(6);

-- Copy legacy bookings into the table used by the current JPA model.
INSERT INTO `booking_request`
    (`booking_request_id`, `duration_minutes`, `requested_start_time`, `status`,
     `student_notes`, `student_id`, `subject_id`, `tutor_profile_id`)
SELECT
    b.`booking_request_id`,
    b.`duration_minutes`,
    b.`requested_start_time`,
    CASE WHEN b.`status` = 'CANCELED' THEN 'CANCELLED' ELSE b.`status` END,
    b.`student_notes`,
    b.`student_id`,
    b.`subject_id`,
    b.`tutor_profile_id`
FROM `booking_requests` b
WHERE NOT EXISTS (
    SELECT 1
    FROM `booking_request` n
    WHERE n.`booking_request_id` = b.`booking_request_id`
);

-- Move legacy user foreign keys to app_user. The current application creates
-- users in app_user, so writes must not continue referencing the legacy users table.
ALTER TABLE `booking_requests`
    DROP FOREIGN KEY `FKjotd4www0uvvir5bvjonnbcfy`,
    ADD CONSTRAINT `fk_booking_requests_student_app_user`
        FOREIGN KEY (`student_id`) REFERENCES `app_user` (`user_id`);

ALTER TABLE `notification`
    DROP FOREIGN KEY `FKnk4ftb5am9ubmkv1661h15ds9`,
    ADD CONSTRAINT `fk_notification_user_app_user`
        FOREIGN KEY (`user_id`) REFERENCES `app_user` (`user_id`);

ALTER TABLE `report`
    DROP FOREIGN KEY `FK2fm8nu7yscahr6sbhhgw082mp`,
    DROP FOREIGN KEY `FKqbhdxqd3ly7fkhly5nrl2j93k`,
    ADD CONSTRAINT `fk_report_reported_user_app_user`
        FOREIGN KEY (`reported_user_id`) REFERENCES `app_user` (`user_id`),
    ADD CONSTRAINT `fk_report_reporter_app_user`
        FOREIGN KEY (`reporter_id`) REFERENCES `app_user` (`user_id`);

ALTER TABLE `tutor_profile`
    DROP FOREIGN KEY `FKh2whb32k13etikxo99v2gtvdy`,
    ADD CONSTRAINT `fk_tutor_profile_user_app_user`
        FOREIGN KEY (`user_id`) REFERENCES `app_user` (`user_id`);

ALTER TABLE `tutor_review`
    DROP FOREIGN KEY `FKfhj7fpv5gj8wdk6640lrbuq5b`,
    ADD CONSTRAINT `fk_tutor_review_student_app_user`
        FOREIGN KEY (`student_id`) REFERENCES `app_user` (`user_id`);

ALTER TABLE `tutoring_session`
    DROP FOREIGN KEY `FKx3t37jkx0qw8ep5vxlh7umbp`,
    ADD CONSTRAINT `fk_tutoring_session_student_app_user`
        FOREIGN KEY (`student_id`) REFERENCES `app_user` (`user_id`);

ALTER TABLE `user_auth`
    DROP FOREIGN KEY `FK9hog4tmdalcddidanohglx6gl`,
    ADD CONSTRAINT `fk_user_auth_user_app_user`
        FOREIGN KEY (`user_id`) REFERENCES `app_user` (`user_id`);

ALTER TABLE `user_role`
    DROP FOREIGN KEY `FKj345gk1bovqvfame88rcx7yyx`,
    ADD CONSTRAINT `fk_user_role_user_app_user`
        FOREIGN KEY (`user_id`) REFERENCES `app_user` (`user_id`);
