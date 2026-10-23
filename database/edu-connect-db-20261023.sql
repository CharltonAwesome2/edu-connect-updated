-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: edu-connect-db
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `availability`
--

DROP TABLE IF EXISTS `availability`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `availability` (
  `availability_id` bigint NOT NULL AUTO_INCREMENT,
  `tutor_profile_id` bigint NOT NULL,
  `day_of_week` enum('MONDAY','TUESDAY','WEDNESDAY','THURSDAY','FRIDAY','SATURDAY','SUNDAY') COLLATE utf8mb4_unicode_ci NOT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `is_recurring` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`availability_id`),
  KEY `fk_av_profile` (`tutor_profile_id`),
  CONSTRAINT `fk_av_profile` FOREIGN KEY (`tutor_profile_id`) REFERENCES `tutor_profile` (`tutor_profile_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `availability`
--

LOCK TABLES `availability` WRITE;
/*!40000 ALTER TABLE `availability` DISABLE KEYS */;
INSERT INTO `availability` VALUES (1,1,'MONDAY','2025-02-10 14:00:00','2025-02-10 18:00:00',1),(2,1,'WEDNESDAY','2025-02-12 14:00:00','2025-02-12 18:00:00',1),(3,2,'TUESDAY','2025-02-11 10:00:00','2025-02-11 13:00:00',1),(4,2,'THURSDAY','2025-02-13 10:00:00','2025-02-13 13:00:00',1),(5,2,'FRIDAY','2025-02-14 15:00:00','2025-02-14 19:00:00',1);
/*!40000 ALTER TABLE `availability` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking_requests`
--

DROP TABLE IF EXISTS `booking_requests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking_requests` (
  `booking_request_id` bigint NOT NULL AUTO_INCREMENT,
  `student_id` bigint NOT NULL,
  `tutor_profile_id` bigint NOT NULL,
  `subject_id` bigint NOT NULL,
  `requested_start_time` datetime NOT NULL,
  `duration_minutes` int NOT NULL,
  `status` enum('PENDING','APPROVED','REJECTED','CANCELED','EXPIRED') COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'PENDING',
  `student_notes` text COLLATE utf8mb4_unicode_ci,
  PRIMARY KEY (`booking_request_id`),
  KEY `fk_br_tutor` (`tutor_profile_id`),
  KEY `fk_br_subject` (`subject_id`),
  KEY `idx_br_student` (`student_id`),
  KEY `idx_br_status` (`status`),
  CONSTRAINT `fk_br_student` FOREIGN KEY (`student_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `fk_br_subject` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`),
  CONSTRAINT `fk_br_tutor` FOREIGN KEY (`tutor_profile_id`) REFERENCES `tutor_profile` (`tutor_profile_id`),
  CONSTRAINT `chk_duration` CHECK ((`duration_minutes` > 0))
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking_requests`
--

LOCK TABLES `booking_requests` WRITE;
/*!40000 ALTER TABLE `booking_requests` DISABLE KEYS */;
INSERT INTO `booking_requests` VALUES (1,1,1,3,'2025-02-10 14:00:00',60,'APPROVED','Struggling with loops and functions.'),(2,2,2,1,'2025-02-11 10:00:00',90,'APPROVED','Need help preparing for midterm.'),(3,5,1,4,'2025-02-12 15:00:00',60,'PENDING','Would like to go over binary trees.'),(4,1,2,2,'2025-02-13 16:00:00',60,'REJECTED','Requested slot clashes with tutor.'),(5,2,1,3,'2025-02-14 16:00:00',60,'CANCELED','Changed my mind.');
/*!40000 ALTER TABLE `booking_requests` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoice` (
  `invoice_id` bigint NOT NULL AUTO_INCREMENT,
  `payment_id` bigint NOT NULL,
  `invoice_number` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `issued_date` datetime DEFAULT NULL,
  `due_date` datetime DEFAULT NULL,
  `total_amount` decimal(10,2) DEFAULT NULL,
  `tax_amount` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`invoice_id`),
  UNIQUE KEY `uq_inv_payment` (`payment_id`),
  CONSTRAINT `fk_inv_payment` FOREIGN KEY (`payment_id`) REFERENCES `payment` (`payment_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
INSERT INTO `invoice` VALUES (1,1,'INV-2025-0001','2025-02-10 15:15:00','2025-02-24 15:15:00',180.00,27.00),(2,2,'INV-2025-0002','2025-02-11 11:50:00','2025-02-25 11:50:00',375.00,56.25);
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notification`
--

DROP TABLE IF EXISTS `notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notification` (
  `notification_id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `title` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `message` text COLLATE utf8mb4_unicode_ci,
  `type` enum('BOOKING_CONFIRMATION','BOOKING_REMINDER','SESSION_UPDATE','PAYMENT_CONFIRMATION','REVIEW_RECEIVED','SYSTEM_ALERT') COLLATE utf8mb4_unicode_ci NOT NULL,
  `is_read` tinyint(1) NOT NULL DEFAULT '0',
  `read_at` datetime DEFAULT NULL,
  PRIMARY KEY (`notification_id`),
  KEY `idx_notif_user_unread` (`user_id`,`is_read`),
  CONSTRAINT `fk_n_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notification`
--

LOCK TABLES `notification` WRITE;
/*!40000 ALTER TABLE `notification` DISABLE KEYS */;
INSERT INTO `notification` VALUES (1,1,'Booking approved','Your booking with Sipho Ndlovu has been approved.','BOOKING_CONFIRMATION',1,'2025-02-09 18:00:00'),(2,1,'Session reminder','Reminder: session with Sipho Ndlovu starts in 1 hour.','BOOKING_REMINDER',1,'2025-02-10 13:00:00'),(3,2,'Payment received','Your payment of R375.00 was successful.','PAYMENT_CONFIRMATION',1,'2025-02-11 11:46:00'),(4,3,'New review received','Thabo Mokoena left you a 5-star review.','REVIEW_RECEIVED',0,NULL),(5,5,'Booking pending approval','Your booking request is awaiting tutor approval.','SESSION_UPDATE',0,NULL);
/*!40000 ALTER TABLE `notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `payment_id` bigint NOT NULL AUTO_INCREMENT,
  `session_id` bigint NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `tutor_earnings` decimal(10,2) DEFAULT NULL,
  `platform_fee` decimal(10,2) DEFAULT NULL,
  `status` enum('PENDING','PAID','REFUNDED','FAILED','PARTIALLY_REFUNDED') COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'PENDING',
  `paid_at` datetime DEFAULT NULL,
  `payment_method` enum('CARD','EFT','CASH','PAYPAL','SNAPSCAN') COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `transaction_reference` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`payment_id`),
  UNIQUE KEY `uq_p_session` (`session_id`),
  UNIQUE KEY `transaction_reference` (`transaction_reference`),
  CONSTRAINT `fk_p_session` FOREIGN KEY (`session_id`) REFERENCES `tutoring_session` (`tutoring_session_id`),
  CONSTRAINT `chk_amount_positive` CHECK ((`amount` >= 0)),
  CONSTRAINT `chk_split` CHECK (((`tutor_earnings` + `platform_fee`) = `amount`))
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,1,180.00,153.00,27.00,'PAID','2025-02-10 15:10:00','CARD','TXN-10001'),(2,2,375.00,318.75,56.25,'PAID','2025-02-11 11:45:00','EFT','TXN-10002'),(3,3,180.00,153.00,27.00,'PENDING',NULL,'CARD','TXN-10003');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `report`
--

DROP TABLE IF EXISTS `report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `report` (
  `report_id` bigint NOT NULL AUTO_INCREMENT,
  `reporter_id` bigint NOT NULL,
  `reported_user_id` bigint NOT NULL,
  `session_id` bigint DEFAULT NULL,
  `reason` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `description` text COLLATE utf8mb4_unicode_ci,
  `status` enum('PENDING','INVESTIGATING','RESOLVED','DISMISSED') COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'PENDING',
  `reported_at` datetime DEFAULT NULL,
  `resolved_at` datetime DEFAULT NULL,
  PRIMARY KEY (`report_id`),
  KEY `fk_rep_reporter` (`reporter_id`),
  KEY `fk_rep_reported` (`reported_user_id`),
  KEY `fk_rep_session` (`session_id`),
  CONSTRAINT `fk_rep_reported` FOREIGN KEY (`reported_user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `fk_rep_reporter` FOREIGN KEY (`reporter_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `fk_rep_session` FOREIGN KEY (`session_id`) REFERENCES `tutoring_session` (`tutoring_session_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report`
--

LOCK TABLES `report` WRITE;
/*!40000 ALTER TABLE `report` DISABLE KEYS */;
INSERT INTO `report` VALUES (1,2,3,2,'Late start','Tutor joined 20 minutes late without notice.','RESOLVED','2025-02-11 12:00:00','2025-02-12 09:00:00'),(2,5,1,NULL,'No-show','Student did not attend the scheduled session.','INVESTIGATING','2025-02-13 09:30:00',NULL);
/*!40000 ALTER TABLE `report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `role_id` bigint NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'STUDENT','Can request tutoring sessions'),(2,'TUTOR','Can offer tutoring and manage availability'),(3,'ADMIN','System administrator');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject` (
  `subject_id` bigint NOT NULL AUTO_INCREMENT,
  `subject_name` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
  `subject_code` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `department` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`subject_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,'Calculus I','MATH101','Mathematics'),(2,'Linear Algebra','MATH201','Mathematics'),(3,'Introduction to Programming','CS101','Computer Science'),(4,'Data Structures','CS201','Computer Science'),(5,'Organic Chemistry','CHEM201','Chemistry');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tutor_profile`
--

DROP TABLE IF EXISTS `tutor_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tutor_profile` (
  `tutor_profile_id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `bio` text COLLATE utf8mb4_unicode_ci,
  `years_experience` int DEFAULT NULL,
  `hourly_rate` decimal(10,2) DEFAULT NULL,
  `average_rating` double NOT NULL DEFAULT '0',
  `created_at` datetime DEFAULT NULL,
  `is_verified` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`tutor_profile_id`),
  UNIQUE KEY `uq_tp_user` (`user_id`),
  CONSTRAINT `fk_tp_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE,
  CONSTRAINT `chk_rate` CHECK ((`hourly_rate` >= 0))
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tutor_profile`
--

LOCK TABLES `tutor_profile` WRITE;
/*!40000 ALTER TABLE `tutor_profile` DISABLE KEYS */;
INSERT INTO `tutor_profile` VALUES (1,3,'Final-year CS student passionate about teaching programming.',3,180.00,4.7,'2025-01-07 10:00:00',1),(2,4,'Maths postgraduate with 5 years tutoring experience.',5,250.00,4.9,'2025-01-08 10:00:00',1);
/*!40000 ALTER TABLE `tutor_profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tutor_review`
--

DROP TABLE IF EXISTS `tutor_review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tutor_review` (
  `tutor_review_id` bigint NOT NULL AUTO_INCREMENT,
  `session_id` bigint NOT NULL,
  `student_id` bigint NOT NULL,
  `tutor_profile_id` bigint NOT NULL,
  `rating` int NOT NULL,
  `comment` text COLLATE utf8mb4_unicode_ci,
  `strengths` text COLLATE utf8mb4_unicode_ci,
  `improvements` text COLLATE utf8mb4_unicode_ci,
  `reviewed_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `is_public` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`tutor_review_id`),
  UNIQUE KEY `uq_rev_session` (`session_id`),
  KEY `fk_rev_student` (`student_id`),
  KEY `idx_rev_tutor` (`tutor_profile_id`),
  CONSTRAINT `fk_rev_session` FOREIGN KEY (`session_id`) REFERENCES `tutoring_session` (`tutoring_session_id`),
  CONSTRAINT `fk_rev_student` FOREIGN KEY (`student_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `fk_rev_tutor` FOREIGN KEY (`tutor_profile_id`) REFERENCES `tutor_profile` (`tutor_profile_id`),
  CONSTRAINT `chk_rating` CHECK ((`rating` between 1 and 5))
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tutor_review`
--

LOCK TABLES `tutor_review` WRITE;
/*!40000 ALTER TABLE `tutor_review` DISABLE KEYS */;
INSERT INTO `tutor_review` VALUES (1,1,1,1,5,'Sipho made functions click for me!','Very patient and clear explanations.','Could share more practice problems.','2025-02-10 18:00:00',1),(2,2,2,2,4,'Great session, very helpful.','Deep subject knowledge.','Would like more worked examples.','2025-02-11 14:00:00',1);
/*!40000 ALTER TABLE `tutor_review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tutor_subject`
--

DROP TABLE IF EXISTS `tutor_subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tutor_subject` (
  `tutor_subject_id` bigint NOT NULL AUTO_INCREMENT,
  `tutor_profile_id` bigint NOT NULL,
  `subject_id` bigint NOT NULL,
  PRIMARY KEY (`tutor_subject_id`),
  KEY `fk_ts_profile` (`tutor_profile_id`),
  KEY `fk_ts_subject` (`subject_id`),
  CONSTRAINT `fk_ts_profile` FOREIGN KEY (`tutor_profile_id`) REFERENCES `tutor_profile` (`tutor_profile_id`) ON DELETE CASCADE,
  CONSTRAINT `fk_ts_subject` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tutor_subject`
--

LOCK TABLES `tutor_subject` WRITE;
/*!40000 ALTER TABLE `tutor_subject` DISABLE KEYS */;
INSERT INTO `tutor_subject` VALUES (1,1,3),(2,1,4),(3,2,1),(4,2,2);
/*!40000 ALTER TABLE `tutor_subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tutoring_session`
--

DROP TABLE IF EXISTS `tutoring_session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tutoring_session` (
  `tutoring_session_id` bigint NOT NULL AUTO_INCREMENT,
  `booking_request_id` bigint NOT NULL,
  `student_id` bigint NOT NULL,
  `tutor_profile_id` bigint NOT NULL,
  `subject_id` bigint NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `status` enum('SCHEDULED','IN_PROGRESS','COMPLETED','CANCELED','NO_SHOW','RESCHEDULED') COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'SCHEDULED',
  `session_notes` text COLLATE utf8mb4_unicode_ci,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`tutoring_session_id`),
  UNIQUE KEY `uq_s_booking` (`booking_request_id`),
  KEY `fk_s_tutor` (`tutor_profile_id`),
  KEY `fk_s_subject` (`subject_id`),
  KEY `idx_s_student` (`student_id`),
  KEY `idx_s_start` (`start_time`),
  CONSTRAINT `fk_s_booking` FOREIGN KEY (`booking_request_id`) REFERENCES `booking_requests` (`booking_request_id`),
  CONSTRAINT `fk_s_student` FOREIGN KEY (`student_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `fk_s_subject` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`),
  CONSTRAINT `fk_s_tutor` FOREIGN KEY (`tutor_profile_id`) REFERENCES `tutor_profile` (`tutor_profile_id`),
  CONSTRAINT `chk_times` CHECK ((`end_time` > `start_time`))
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tutoring_session`
--

LOCK TABLES `tutoring_session` WRITE;
/*!40000 ALTER TABLE `tutoring_session` DISABLE KEYS */;
INSERT INTO `tutoring_session` VALUES (1,1,1,1,3,'2025-02-10 14:00:00','2025-02-10 15:00:00','COMPLETED','Covered loops and functions.','2025-02-10 15:05:00','2025-02-10 15:05:00'),(2,2,2,2,1,'2025-02-11 10:00:00','2025-02-11 11:30:00','COMPLETED','Worked through past exam papers.','2025-02-11 11:35:00','2025-02-11 11:35:00'),(3,3,5,1,4,'2025-02-12 15:00:00','2025-02-12 16:00:00','SCHEDULED','Pending approval finalised.','2025-02-12 09:00:00','2025-02-12 09:00:00');
/*!40000 ALTER TABLE `tutoring_session` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_auth`
--

DROP TABLE IF EXISTS `user_auth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_auth` (
  `user_auth_id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `password_hash` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `last_login` datetime DEFAULT NULL,
  PRIMARY KEY (`user_auth_id`),
  UNIQUE KEY `uq_auth_user` (`user_id`),
  CONSTRAINT `fk_auth_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_auth`
--

LOCK TABLES `user_auth` WRITE;
/*!40000 ALTER TABLE `user_auth` DISABLE KEYS */;
INSERT INTO `user_auth` VALUES (1,1,'$2a$12$Zv6kk5NZ/JH4ifZnhVjH0OQd7Kuv06cYQO2MoN9sOjhO.dIeitsZ6','2025-01-10 08:15:00'),(2,2,'$2a$12$Zv6kk5NZ/JH4ifZnhVjH0OQd7Kuv06cYQO2MoN9sOjhO.dIeitsZ6','2025-01-11 09:30:00'),(3,3,'$2a$12$Zv6kk5NZ/JH4ifZnhVjH0OQd7Kuv06cYQO2MoN9sOjhO.dIeitsZ6','2025-01-12 10:45:00'),(4,4,'$2a$12$Zv6kk5NZ/JH4ifZnhVjH0OQd7Kuv06cYQO2MoN9sOjhO.dIeitsZ6','2025-01-12 14:20:00'),(5,5,'$2a$12$Zv6kk5NZ/JH4ifZnhVjH0OQd7Kuv06cYQO2MoN9sOjhO.dIeitsZ6',NULL);
/*!40000 ALTER TABLE `user_auth` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `user_role_id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`user_role_id`),
  KEY `fk_ur_user` (`user_id`),
  KEY `fk_ur_role` (`role_id`),
  CONSTRAINT `fk_ur_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`) ON DELETE CASCADE,
  CONSTRAINT `fk_ur_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1,1),(2,2,1),(3,3,2),(4,4,2),(5,4,1),(6,5,1);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `surname` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `student_number` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `contact_number` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `is_tutor` tinyint(1) NOT NULL DEFAULT '0',
  `is_student` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Thabo','Mokoena','STU001','thabo.mokoena@example.com','+27821234567','2025-01-05 09:00:00',0,1),(2,'Lerato','Dlamini','STU002','lerato.dlamini@example.com','+27827654321','2025-01-06 09:00:00',0,1),(3,'Sipho','Ndlovu','TUT001','sipho.ndlovu@example.com','+27831112222','2025-01-07 09:00:00',1,0),(4,'Aisha','Patel','TUT002','aisha.patel@example.com','+27833334444','2025-01-08 09:00:00',1,1),(5,'Kagiso','Molefe','STU003','kagiso.molefe@example.com','+27825556666','2025-01-09 09:00:00',0,1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-10-23 11:02:54
