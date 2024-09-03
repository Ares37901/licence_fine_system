CREATE DATABASE  IF NOT EXISTS `licence_directory`;
USE `licence_directory`;

--
-- Table structure for table `licence-fine`
--

DROP TABLE IF EXISTS `licence_fine`;

CREATE TABLE `licence_fine` (
  `id` int NOT NULL AUTO_INCREMENT,
  `reference` varchar(45) DEFAULT NULL,
  `house` varchar(45) DEFAULT NULL,
  `street` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `postcode` varchar(45) DEFAULT NULL,
  `fine` varchar(45) DEFAULT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Data for table `licence-fine`
--

INSERT INTO `licence_fine` VALUES 
	(1,'ABC12D456','13','Robbery Street','Gotham','BT137FU','18000','Mickey','Longlegs','mlong@crooks.com')

