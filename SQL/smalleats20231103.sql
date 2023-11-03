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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authority_tb`
--

LOCK TABLES `authority_tb` WRITE;
/*!40000 ALTER TABLE `authority_tb` DISABLE KEYS */;
INSERT INTO `authority_tb` VALUES (1,1,1,0),(2,2,1,0),(3,3,1,0),(4,4,1,0),(5,5,1,0),(6,6,1,0),(7,7,1,0),(8,8,1,0),(9,0,2,1),(10,0,2,2),(11,0,2,3),(12,0,2,4),(13,0,2,5),(18,11,3,0),(19,12,1,0),(20,0,2,6),(21,13,1,0);
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='음식점 카테고리 테이블';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_tb`
--

LOCK TABLES `category_tb` WRITE;
/*!40000 ALTER TABLE `category_tb` DISABLE KEYS */;
INSERT INTO `category_tb` VALUES (1,'족발'),(2,'패스트푸드'),(3,'한식'),(4,'중식'),(5,'일식');
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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='배달 가능 구역';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food_delivery_tb`
--

LOCK TABLES `food_delivery_tb` WRITE;
/*!40000 ALTER TABLE `food_delivery_tb` DISABLE KEYS */;
INSERT INTO `food_delivery_tb` VALUES (1,1,'동래구'),(2,1,'사상구'),(3,1,'남구'),(4,1,'북구'),(5,1,'해운대구'),(6,2,'수영구'),(7,2,'해운대구'),(8,2,'연제구'),(13,1,'수영구'),(14,1,'중구'),(15,2,'기장군'),(16,2,'북구'),(17,2,'강서구'),(18,2,'부산진구'),(19,2,'영도구'),(20,3,'동래구'),(21,3,'금정구');
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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='음식점 메뉴 테이블';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food_menu_tb`
--

LOCK TABLES `food_menu_tb` WRITE;
/*!40000 ALTER TABLE `food_menu_tb` DISABLE KEYS */;
INSERT INTO `food_menu_tb` VALUES (1,1,'음식점 1의 메뉴 1',NULL,'5000'),(2,1,'음식점 1의 메뉴 2',NULL,'6000'),(3,1,'음식점 1의 메뉴 3',NULL,'7000'),(4,2,'음식점 2의 메뉴1',NULL,'10000'),(5,2,'음식점 2의 메뉴3',NULL,'15000'),(8,1,'족발 소자',NULL,'20000'),(9,1,'족발 (中)자',NULL,'30000'),(10,1,'족발 (大)자',NULL,'40000'),(11,2,'불고기버거',NULL,'2000'),(12,2,'빅맥',NULL,'4400'),(13,3,'불고기',NULL,'5000'),(14,3,'감자튀김',NULL,'2000'),(15,3,'콜라',NULL,'1500'),(16,3,'빅맥',NULL,'5000'),(17,4,'연어덮밥',NULL,'9000'),(18,4,'닭꼬치 덮밥',NULL,'8000'),(19,4,'장어 덮밥',NULL,'14000'),(20,4,'소고기 덮밥',NULL,'8000'),(21,4,'매운삼겹 덮밥',NULL,'8000');
/*!40000 ALTER TABLE `food_menu_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `food_tb`
--

DROP TABLE IF EXISTS `food_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `food_tb` (
  `food_id` int NOT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='음식점 테이블';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food_tb`
--

LOCK TABLES `food_tb` WRITE;
/*!40000 ALTER TABLE `food_tb` DISABLE KEYS */;
INSERT INTO `food_tb` VALUES (1,3,'귀족향 동래점',NULL,'11','12','30000','3000','부산','부산 동래구 미남로 11','귀족향 동래점',47845),(2,2,'맥도날드 서면점',NULL,'0','24','10000','3000','부산','부산 부산진구 중앙대로692번길 33','맥도날드 서면3호점',47295);
/*!40000 ALTER TABLE `food_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_menu_tb`
--

DROP TABLE IF EXISTS `order_menu_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_menu_tb` (
  `order_id` int NOT NULL COMMENT '주문참조키',
  `order_menu_info` json NOT NULL COMMENT '주문한 메뉴 정보'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='구매 메뉴 테이블';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_menu_tb`
--

LOCK TABLES `order_menu_tb` WRITE;
/*!40000 ALTER TABLE `order_menu_tb` DISABLE KEYS */;
INSERT INTO `order_menu_tb` VALUES (1,'1'),(1,'1'),(1,'2'),(1,'2'),(2,'6'),(2,'6'),(3,'6'),(3,'10'),(4,'6'),(4,'7'),(5,'20'),(6,'6'),(6,'5'),(7,'4'),(7,'4'),(8,'4'),(8,'7'),(8,'6');
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
  `user_road_address` varchar(30) DEFAULT NULL,
  `user_detail_address` varchar(20) DEFAULT NULL,
  `user_zonecode` int DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='메뉴 구매 테이블';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_tb`
--

LOCK TABLES `order_tb` WRITE;
/*!40000 ALTER TABLE `order_tb` DISABLE KEYS */;
INSERT INTO `order_tb` VALUES (1,2,8,'11','2023-10-27',NULL,NULL,NULL),(2,1,8,'23','2023-10-28',NULL,NULL,NULL),(4,1,7,'19','2023-10-27',NULL,NULL,NULL),(5,2,7,'11','2023-10-27',NULL,NULL,NULL),(7,2,12,'13','2023-11-01',NULL,NULL,NULL),(8,2,7,'11','2023-10-31',NULL,NULL,NULL),(9,1,7,'14','2023-11-04',NULL,NULL,NULL),(10,1,7,'13','2023-11-04','서울 강남구 가로수길 5','강남 가로수길',6035),(11,1,7,'21','2023-11-04','서울 강남구 가로수길 5','강남 가로수길',6035),(12,1,7,'21','2023-11-04','서울 강남구 가로수길 5','강남 가로수길',6035);
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='파트너 회원 테이블';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partner_user_tb`
--

LOCK TABLES `partner_user_tb` WRITE;
/*!40000 ALTER TABLE `partner_user_tb` DISABLE KEYS */;
INSERT INTO `partner_user_tb` VALUES (1,'파트너회원','$2a$10$TI.qOlxfPKioln6ArL1T8.RoFhM0R3qoFIYwHcQ9QixhjpZCNJZeG','partnerTest@a.com','111-1111-1111','상호명',12345678),(2,'파트너테스트2','$2a$10$PXJGTDDIIJCczJ.MeC2TkOtXbnrfAM27iB6iAaWnjo8XBbxDO09Re','partnerTest2@a.com','1234','상호',12345678),(3,'파트너테스트2','$2a$10$OYi4Mxk/p6mOsZLQ7Lsh9.lZ/LAZ94sA51eMLsay7AYZM6TT/gmb2','partnerTest3@a.com','1234','상호',12345678),(4,'테스트4','$2a$10$iYRDJ2STgkl/2AxzHuT2JejQpiTEeAscyXmBL9aISgs1kZtSnZIUq','partnerTest4@a.com','1234','1234',1234),(5,'1','$2a$10$Dwe6m4DS8JsMNvrF1c93kOF5pjwO.Yoj488GYrkydveFjpnIC6CGm','2','1','1',1),(6,'파트너테스트5','$2a$10$jLNQmFwC9BiBWtYoiXrqQOMBveJ5kNHgzsKXrbuHbJLRZJpp9tmxG','partnerTest5@a.com','010-1234-1234','덮밥',1234);
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
  `payment_order_state` varchar(15) DEFAULT NULL,
  `payment_day` date DEFAULT NULL,
  PRIMARY KEY (`payment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='결제 테이블';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_tb`
--

LOCK TABLES `payment_tb` WRITE;
/*!40000 ALTER TABLE `payment_tb` DISABLE KEYS */;
INSERT INTO `payment_tb` VALUES (1,1,2,40800,'주문접수',NULL),(2,2,1,303000,'배달완료',NULL),(4,4,1,463000,'배달완료',NULL),(5,5,2,43000,'주문접수대기중',NULL),(7,7,2,28600,'배달중',NULL),(8,8,2,103400,'주문접수',NULL);
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
  `food_road_address` varchar(30) NOT NULL COMMENT '음식점 도로명 주소',
  `food_detail_address` varchar(20) NOT NULL COMMENT '음식점 상세주소',
  `food_zonecode` int DEFAULT NULL COMMENT '음식점 우편번호',
  `partner_id` int NOT NULL,
  `pending_status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`pending_food_id`),
  UNIQUE KEY `food_id_UNIQUE` (`food_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='음식점 등록 전 임시 테이블';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pending_food_tb`
--

LOCK TABLES `pending_food_tb` WRITE;
/*!40000 ALTER TABLE `pending_food_tb` DISABLE KEYS */;
INSERT INTO `pending_food_tb` VALUES (2,1,3,'귀족향 동래점',NULL,11,12,30000,3000,'부산','부산 동래구 미남로 11','귀족향 동래점',47845,1,'APPROVED'),(3,2,2,'맥도날드 서면점',NULL,0,24,10000,3000,'부산','부산 부산진구 중앙대로692번길 33','맥도날드 서면3호점',47295,3,'APPROVED'),(9,3,2,'롯데리아 롯데마트 동래점',NULL,10,22,10000,3000,'부산','부산 동래구 중앙대로 1393','롯데리아 롯데마트 동래점',47727,2,'PENDING'),(10,4,5,'각방',NULL,11,20,12000,5000,'부산','부산 부산진구 동천로107번길 12-5','각방',47246,4,'PENDING'),(14,5,5,'페이센동',NULL,11,20,15000,3000,'부산','부산 부산진구 서전로46번길 6','페이센동 전포본점',47293,6,'PENDING');
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
  `user_address_sigungu` varchar(10) DEFAULT NULL COMMENT '유저 주소 구이름',
  `user_address_category` varchar(10) DEFAULT NULL COMMENT '주소 종류',
  `user_address_flag` int DEFAULT NULL,
  PRIMARY KEY (`user_address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_address_tb`
--

LOCK TABLES `user_address_tb` WRITE;
/*!40000 ALTER TABLE `user_address_tb` DISABLE KEYS */;
INSERT INTO `user_address_tb` VALUES (1,2,'경북 안동시 강남1길 49','테스트3',36751,NULL,NULL,NULL,NULL),(2,2,'경북 경주시 남산순환로 12-5','테스트2',38174,NULL,NULL,NULL,NULL),(4,2,'서울 강남구 가로수길 5','강남살기',6035,NULL,NULL,NULL,NULL),(5,3,'부산 사상구 가야대로 1','사직운동장',46990,NULL,NULL,NULL,NULL),(6,6,'경기 성남시 분당구 대왕판교로 477','판교에서 살아보기',13480,NULL,NULL,NULL,NULL),(8,8,'부산 강서구 거가대로 2571','테스트 주소',46770,'부산','강서구',NULL,NULL),(10,12,'서울 종로구 북촌로 31-4','북촌',3055,'서울','종로구',NULL,0),(11,12,'부산 강서구 가달1로 7','강서구',46729,'부산','강서구','집',1),(12,7,'서울 강남구 가로수길 5','강남 가로수길',6035,'서울','강남구','',1),(13,7,'부산 강서구 경등중앙길 140','부산주소테스트',46717,'부산','강서구','집',0);
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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_tb`
--

LOCK TABLES `user_tb` WRITE;
/*!40000 ALTER TABLE `user_tb` DISABLE KEYS */;
INSERT INTO `user_tb` VALUES (1,'jsh','test@testmail.com','$2a$10$ksJpwLxBRfjotecrXpo5Ku9vs0slhZD8Rq/My64eDBaNYHrn8BlTG','010-1111-1111',NULL,NULL),(2,'jsh','test2@testemail.com','$2a$10$Vn2bo43fViAzffiGwhyTRObzEcsPTjJpGSjt1YDeD2W3Krl8a/4Qm','1234',NULL,NULL),(3,'testuser','test3@email.com','$2a$10$/nzPFZ7Fni5jDf5JKXB0Xe6KUbNikWSpbRfSvgNPJ/7j1X.O58mw2','010-1111-1111',NULL,NULL),(4,'testUser','test@test,com','$2a$10$eyXzt2xW59SIX9PkRJJ/buDX5L7uKF6I6eMmHv8CgbgVyLgrx6L7W','11111111',NULL,NULL),(5,'test4','email@test.com','$2a$10$hC7Vx3gZfu1Gvo6IOwfPqOp59E.T5blMI3o7OGplGp4XnY31ETNcK','1111111',NULL,NULL),(6,'testuser','test6@a.com','$2a$10$1k5KrdMsJtYkI3nkTq/62.C9P3zFBvg/iz3XF8a0lY7MwQQffz2bK','1234',NULL,NULL),(7,'테스트 유저','test7@a.com','$2a$10$Kc0ueq13S2hwGGX3SOrPm.WmT/kVxaM33RhN5sQs1DRUDQadcLl9O','1234',NULL,NULL),(8,'1','1','$2a$10$u2RiccGQYJbKY64LStMXiuhKA1Fv4SesvJwCewh9f13RhSakHDYvK','1',NULL,NULL),(11,'관리자','admin@a.com','$2a$10$vnU7TYmpJRbV6s3s3YZWMeIAPukJMnMBumD2vPom/n9xwmMxuPkh.','010-1234-5678',NULL,NULL),(12,'테스트유저4','test4@email.com','$2a$10$p6W81muZifkrqecorHTtueJgTjVZ8G/RkC4Sm35S5j7EjrW6wpDfC','010-1111-1111',NULL,NULL),(13,'테스트유저8','test8@email.com','$2a$10$qEOa/N6uVlckKciTCQzCzOBgTUYjMbIG62tqCAdYU/HKyGCvzzX6q','010-1111-1111',NULL,NULL);
/*!40000 ALTER TABLE `user_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'smalleatsDB'
--

--
-- Dumping routines for database 'smalleatsDB'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-03 18:00:20
