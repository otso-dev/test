CREATE DATABASE  IF NOT EXISTS `smalleatsDB` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `smalleatsDB`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: smalleatsDB
-- ------------------------------------------------------
-- Server version	8.1.0

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
-- Table structure for table `address_tb`
--

DROP TABLE IF EXISTS `address_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address_tb` (
  `address_id` int NOT NULL AUTO_INCREMENT,
  `road_address` varchar(45) NOT NULL COMMENT '도로명 주소',
  `detail_address` varchar(45) NOT NULL COMMENT '상세주소',
  `zonecode` int NOT NULL COMMENT '우편번호',
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='구매시 새롭게 입력할 주소 테이블';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address_tb`
--

LOCK TABLES `address_tb` WRITE;
/*!40000 ALTER TABLE `address_tb` DISABLE KEYS */;
/*!40000 ALTER TABLE `address_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authority_tb`
--

DROP TABLE IF EXISTS `authority_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authority_tb` (
  `authority_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `role_id` int NOT NULL,
  `partner_id` int DEFAULT NULL,
  PRIMARY KEY (`authority_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authority_tb`
--

LOCK TABLES `authority_tb` WRITE;
/*!40000 ALTER TABLE `authority_tb` DISABLE KEYS */;
INSERT INTO `authority_tb` VALUES (1,1,1,NULL),(2,2,1,NULL),(3,3,1,NULL),(4,4,1,NULL),(5,5,1,NULL),(6,6,1,NULL),(7,7,1,NULL),(8,8,1,NULL),(9,0,2,1),(10,0,2,NULL),(11,0,2,3),(12,0,2,4);
/*!40000 ALTER TABLE `authority_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category_tb`
--

DROP TABLE IF EXISTS `category_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category_tb` (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `category_name` varchar(45) NOT NULL COMMENT '음식점 카테고리 이름',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='음식점 카테고리 테이블';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_tb`
--

LOCK TABLES `category_tb` WRITE;
/*!40000 ALTER TABLE `category_tb` DISABLE KEYS */;
/*!40000 ALTER TABLE `category_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `food_delivery_tb`
--

DROP TABLE IF EXISTS `food_delivery_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `food_delivery_tb` (
  `food_delivery_id` int NOT NULL AUTO_INCREMENT,
  `food_id` int NOT NULL COMMENT '음식점 참조키',
  `food_delivery_area` varchar(45) NOT NULL COMMENT '음식점 배달 가능 구역',
  PRIMARY KEY (`food_delivery_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='배달 가능 구역';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food_delivery_tb`
--

LOCK TABLES `food_delivery_tb` WRITE;
/*!40000 ALTER TABLE `food_delivery_tb` DISABLE KEYS */;
INSERT INTO `food_delivery_tb` VALUES (1,1,'동래구'),(2,1,'사상구'),(3,1,'남구'),(4,1,'북구'),(5,1,'해운대구'),(6,2,'수영구'),(7,2,'해운대구'),(8,2,'연제구'),(9,3,'기장군'),(10,3,'사상구'),(11,3,'수영구');
/*!40000 ALTER TABLE `food_delivery_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `food_menu_tb`
--

DROP TABLE IF EXISTS `food_menu_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `food_menu_tb` (
  `food_menu_id` int NOT NULL AUTO_INCREMENT,
  `food_id` int NOT NULL,
  `food_menu_name` varchar(45) NOT NULL COMMENT '음식점 메뉴 이름',
  `food_menu_img` varchar(45) DEFAULT NULL COMMENT '음식점 메뉴 사진',
  `food_menu_price` varchar(45) NOT NULL COMMENT '음식점 메뉴 가격',
  PRIMARY KEY (`food_menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='음식점 메뉴 테이블';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food_menu_tb`
--

LOCK TABLES `food_menu_tb` WRITE;
/*!40000 ALTER TABLE `food_menu_tb` DISABLE KEYS */;
INSERT INTO `food_menu_tb` VALUES (1,1,'음식점 1의 메뉴 1',NULL,'5000'),(2,1,'음식점 1의 메뉴 2',NULL,'6000'),(3,1,'음식점 1의 메뉴 3',NULL,'7000'),(4,2,'음식점 2의 메뉴1',NULL,'10000'),(5,2,'음식점 2의 메뉴3',NULL,'15000'),(6,3,'음식점 3의 메뉴1',NULL,'20000'),(7,3,'음식점 3의 메뉴5',NULL,'25000');
/*!40000 ALTER TABLE `food_menu_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `food_tb`
--

DROP TABLE IF EXISTS `food_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `food_tb` (
  `food_id` int NOT NULL AUTO_INCREMENT,
  `category_id` int NOT NULL COMMENT '음식점 카테고리',
  `food_name` varchar(40) NOT NULL COMMENT '음식점 이름',
  `food_img` varchar(45) DEFAULT NULL COMMENT '음식점 메인 사진',
  `food_open` varchar(45) NOT NULL COMMENT '음식점 오픈시간',
  `food_close` varchar(45) NOT NULL COMMENT '음식점 마감시간',
  `food_min` varchar(45) NOT NULL COMMENT '음식점 최소구매 금액',
  `food_delivery_price` varchar(45) NOT NULL COMMENT '음식점 배달비',
  `food_address_sido` varchar(10) NOT NULL COMMENT '음식점 주소 시/도',
  `food_road_address` varchar(20) DEFAULT NULL COMMENT '음식점 도로명 주소',
  `food_detail_address` varchar(20) DEFAULT NULL COMMENT '음식점 상세주소',
  `food_zonecode` int DEFAULT NULL,
  PRIMARY KEY (`food_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='음식점 테이블';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food_tb`
--

LOCK TABLES `food_tb` WRITE;
/*!40000 ALTER TABLE `food_tb` DISABLE KEYS */;
INSERT INTO `food_tb` VALUES (1,0,'음식점1',NULL,'7','9','10000','3000','',NULL,NULL,NULL),(2,0,'음식점2',NULL,'8','10','20000','5000','',NULL,NULL,NULL),(3,0,'음식점3',NULL,'10','10','25000','4000','',NULL,NULL,NULL);
/*!40000 ALTER TABLE `food_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_menu_tb`
--

DROP TABLE IF EXISTS `order_menu_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_menu_tb` (
  `order_menu_id` int NOT NULL AUTO_INCREMENT,
  `order_id` int NOT NULL COMMENT '주문참조키',
  `menu_id` int NOT NULL COMMENT '메뉴 참조키',
  `order_menu_numbers` int NOT NULL COMMENT '구매할 메뉴 갯수',
  PRIMARY KEY (`order_menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='구매 메뉴 테이블';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_menu_tb`
--

LOCK TABLES `order_menu_tb` WRITE;
/*!40000 ALTER TABLE `order_menu_tb` DISABLE KEYS */;
INSERT INTO `order_menu_tb` VALUES (1,8,1,1),(2,8,2,1),(3,8,3,1),(4,9,1,2),(5,9,2,1),(6,9,3,2),(7,10,1,3),(8,10,2,3),(9,10,3,3),(10,11,4,10),(11,11,5,10),(12,12,1,9),(13,12,2,5),(14,12,3,4),(15,13,6,10),(16,13,7,10),(17,16,4,5),(18,16,5,4),(19,17,1,2),(20,17,2,2),(21,17,3,2),(22,18,4,2),(23,18,5,2),(24,19,6,3),(25,19,7,4);
/*!40000 ALTER TABLE `order_menu_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_tb`
--

DROP TABLE IF EXISTS `order_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_tb` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `food_id` int NOT NULL COMMENT '음식점 참조키',
  `user_id` int NOT NULL COMMENT '유저 참조키',
  `order_req_time` varchar(45) NOT NULL COMMENT '배달요청시간',
  `order_delivery_day` varchar(45) NOT NULL COMMENT '배달요청날짜',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='메뉴 구매 테이블';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_tb`
--

LOCK TABLES `order_tb` WRITE;
/*!40000 ALTER TABLE `order_tb` DISABLE KEYS */;
INSERT INTO `order_tb` VALUES (1,1,5,'15','2023-10-18'),(2,1,5,'21','2023-10-19'),(3,1,5,'15','2023-10-18'),(4,1,5,'15','2023-10-20'),(5,1,5,'20','2023-10-20'),(6,2,5,'13','2023-10-18'),(7,2,5,'13','2023-10-18'),(8,2,5,'13','2023-10-18'),(9,1,5,'14','2023-10-19'),(10,1,5,'15','2023-10-19'),(11,2,5,'16','2023-10-20'),(12,1,6,'12','2023-10-24'),(13,3,6,'','2023-10-23'),(14,2,7,'14','2023-10-24'),(15,2,7,'',''),(16,2,7,'',''),(17,1,7,'',''),(18,2,7,'',''),(19,3,7,'16','2023-10-21');
/*!40000 ALTER TABLE `order_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partner_authority_tb`
--

DROP TABLE IF EXISTS `partner_authority_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `partner_authority_tb` (
  `partner_authority_id` int NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `partner_id` int NOT NULL COMMENT '파트너 참조키',
  `role_id` int NOT NULL COMMENT '권한 참조키',
  PRIMARY KEY (`partner_authority_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='파트너 회원권한 테이블';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partner_authority_tb`
--

LOCK TABLES `partner_authority_tb` WRITE;
/*!40000 ALTER TABLE `partner_authority_tb` DISABLE KEYS */;
INSERT INTO `partner_authority_tb` VALUES (1,1,2);
/*!40000 ALTER TABLE `partner_authority_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partner_user_tb`
--

DROP TABLE IF EXISTS `partner_user_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `partner_user_tb` (
  `partner_id` int NOT NULL AUTO_INCREMENT COMMENT '파트너 회원 PK',
  `partner_username` varchar(30) NOT NULL COMMENT '파트너 유저 이름',
  `partner_user_password` varchar(100) NOT NULL COMMENT '파트너 회원 비밀번호',
  `partner_user_email` varchar(30) NOT NULL COMMENT '파트너 회원 이메일',
  `partner_phone_number` varchar(30) NOT NULL COMMENT '파트너 유저 개인 전화번호(연락처)',
  `partner_business_name` varchar(30) NOT NULL COMMENT '상호명',
  `partner_business_number` int NOT NULL COMMENT '사업장번호',
  PRIMARY KEY (`partner_id`),
  UNIQUE KEY `partner_user_email_UNIQUE` (`partner_user_email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='파트너 회원 테이블';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partner_user_tb`
--

LOCK TABLES `partner_user_tb` WRITE;
/*!40000 ALTER TABLE `partner_user_tb` DISABLE KEYS */;
INSERT INTO `partner_user_tb` VALUES (1,'파트너회원','$2a$10$TI.qOlxfPKioln6ArL1T8.RoFhM0R3qoFIYwHcQ9QixhjpZCNJZeG','partnerTest@a.com','111-1111-1111','상호명',12345678),(2,'파트너테스트2','$2a$10$PXJGTDDIIJCczJ.MeC2TkOtXbnrfAM27iB6iAaWnjo8XBbxDO09Re','partnerTest2@a.com','1234','상호',12345678),(3,'파트너테스트2','$2a$10$OYi4Mxk/p6mOsZLQ7Lsh9.lZ/LAZ94sA51eMLsay7AYZM6TT/gmb2','partnerTest3@a.com','1234','상호',12345678),(4,'테스트4','$2a$10$iYRDJ2STgkl/2AxzHuT2JejQpiTEeAscyXmBL9aISgs1kZtSnZIUq','partnerTest4@a.com','1234','1234',1234);
/*!40000 ALTER TABLE `partner_user_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_tb`
--

DROP TABLE IF EXISTS `payment_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment_tb` (
  `payment_id` int NOT NULL AUTO_INCREMENT,
  `order_id` int NOT NULL COMMENT '주문 참조키',
  `food_id` int NOT NULL COMMENT '음식점 참조키',
  `payment_price` int NOT NULL COMMENT '총 구매 금액',
  PRIMARY KEY (`payment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='결제 테이블';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_tb`
--

LOCK TABLES `payment_tb` WRITE;
/*!40000 ALTER TABLE `payment_tb` DISABLE KEYS */;
INSERT INTO `payment_tb` VALUES (1,11,2,255000),(2,12,1,106000),(3,13,3,454000),(4,16,2,115000),(5,17,1,39000),(6,18,2,55000),(7,19,3,164000);
/*!40000 ALTER TABLE `payment_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pending_food_tb`
--

DROP TABLE IF EXISTS `pending_food_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pending_food_tb` (
  `pending_food_id` int NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `food_id` int NOT NULL COMMENT '음식점 참조키',
  `category_id` int NOT NULL COMMENT '음식점 종류 참조키',
  `food_name` varchar(40) NOT NULL COMMENT '음식점 이름',
  `food_img` varchar(100) DEFAULT NULL COMMENT '음식점 사진',
  `food_open` int NOT NULL COMMENT '음식점 오픈시간',
  `food_close` int NOT NULL COMMENT '음식점 마감시간',
  `food_min` int NOT NULL COMMENT '최소 주문금액',
  `food_delivery_price` int NOT NULL COMMENT '배달비',
  `food_address_sido` varchar(20) NOT NULL COMMENT '음식점 주소 시/도',
  `food_road_address` varchar(20) NOT NULL COMMENT '음식점 도로명 주소',
  `food_detail_address` varchar(20) NOT NULL COMMENT '음식점 상세주소',
  `food_zonecode` int DEFAULT NULL COMMENT '음식점 우편번호',
  PRIMARY KEY (`pending_food_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='음식점 등록 전 임시 테이블';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pending_food_tb`
--

LOCK TABLES `pending_food_tb` WRITE;
/*!40000 ALTER TABLE `pending_food_tb` DISABLE KEYS */;
/*!40000 ALTER TABLE `pending_food_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_tb`
--

DROP TABLE IF EXISTS `role_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role_tb` (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(15) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_tb`
--

LOCK TABLES `role_tb` WRITE;
/*!40000 ALTER TABLE `role_tb` DISABLE KEYS */;
INSERT INTO `role_tb` VALUES (1,'ROLE_USER'),(2,'ROLE_PARTNER'),(3,'ROLE_ADMIN');
/*!40000 ALTER TABLE `role_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_address_tb`
--

DROP TABLE IF EXISTS `user_address_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_address_tb` (
  `user_address_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL COMMENT '유저 참조키',
  `user_road_address` varchar(30) NOT NULL COMMENT '도로명 주소',
  `user_detail_address` varchar(45) NOT NULL COMMENT '상세주소',
  `user_zonecode` int NOT NULL COMMENT '우편번호',
  `user_address_sido` varchar(10) DEFAULT NULL COMMENT '유저 주소 시/도',
  `user_address_bname` varchar(10) DEFAULT NULL COMMENT '유저 주소 구이름',
  `user_address_category` varchar(10) DEFAULT NULL COMMENT '주소 종류',
  PRIMARY KEY (`user_address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_address_tb`
--

LOCK TABLES `user_address_tb` WRITE;
/*!40000 ALTER TABLE `user_address_tb` DISABLE KEYS */;
INSERT INTO `user_address_tb` VALUES (1,2,'경북 안동시 강남1길 49','테스트3',36751,NULL,NULL,NULL),(2,2,'경북 경주시 남산순환로 12-5','테스트2',38174,NULL,NULL,NULL),(4,2,'서울 강남구 가로수길 5','강남살기',6035,NULL,NULL,NULL),(5,3,'부산 사상구 가야대로 1','사직운동장',46990,NULL,NULL,NULL),(6,6,'경기 성남시 분당구 대왕판교로 477','판교에서 살아보기',13480,NULL,NULL,NULL),(7,7,'경기 성남시 분당구 내정로 54','분당구',13607,NULL,NULL,NULL);
/*!40000 ALTER TABLE `user_address_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_tb`
--

DROP TABLE IF EXISTS `user_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_tb` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(100) NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  `profile_img` varchar(100) DEFAULT NULL,
  `provider` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_tb`
--

LOCK TABLES `user_tb` WRITE;
/*!40000 ALTER TABLE `user_tb` DISABLE KEYS */;
INSERT INTO `user_tb` VALUES (1,'jsh','test@testmail.com','$2a$10$ksJpwLxBRfjotecrXpo5Ku9vs0slhZD8Rq/My64eDBaNYHrn8BlTG','010-1111-1111',NULL,NULL),(2,'jsh','test2@testemail.com','$2a$10$Vn2bo43fViAzffiGwhyTRObzEcsPTjJpGSjt1YDeD2W3Krl8a/4Qm','1234',NULL,NULL),(3,'testuser','test3@email.com','$2a$10$/nzPFZ7Fni5jDf5JKXB0Xe6KUbNikWSpbRfSvgNPJ/7j1X.O58mw2','010-1111-1111',NULL,NULL),(4,'testUser','test@test,com','$2a$10$eyXzt2xW59SIX9PkRJJ/buDX5L7uKF6I6eMmHv8CgbgVyLgrx6L7W','11111111',NULL,NULL),(5,'test4','email@test.com','$2a$10$hC7Vx3gZfu1Gvo6IOwfPqOp59E.T5blMI3o7OGplGp4XnY31ETNcK','1111111',NULL,NULL),(6,'testuser','test6@a.com','$2a$10$1k5KrdMsJtYkI3nkTq/62.C9P3zFBvg/iz3XF8a0lY7MwQQffz2bK','1234',NULL,NULL),(7,'테스트 유저','test7@a.com','$2a$10$Kc0ueq13S2hwGGX3SOrPm.WmT/kVxaM33RhN5sQs1DRUDQadcLl9O','1234',NULL,NULL),(8,'1','1','$2a$10$u2RiccGQYJbKY64LStMXiuhKA1Fv4SesvJwCewh9f13RhSakHDYvK','1',NULL,NULL);
/*!40000 ALTER TABLE `user_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'smalleatsDB'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-20 18:10:59
