CREATE DATABASE  IF NOT EXISTS `licence_directory`;
USE `licence_directory`;

--
-- Table structure for table `licence-fine`
--

CREATE TABLE  IF NOT EXISTS `licence_fine` (
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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `licence-fine`
--

INSERT INTO `licence_fine` VALUES 
	(1,'ABC12D456','13','Mucker Lane','Gotham','BT137FU','18000.5','Mickey','Longlegs','mlong@crooks.com'),
	(2,'ABC12D457','33','Robery Street','Gotham','BT112FU','18000.5','Danny','Stickyfingers','dfishy@crooks.com'),
	(3,'ABC12D458','7','Fallen Lane','Gotham','BT221FU','18000.5','Ronnie','Muckface','rface@crooks.com'),
	(4,'ABC12D459','256','Canibal Way','Gotham','BT877FU','18000.5','Paddy','Cont','pcont@crooks.com'),
	(5,'ABC12D460','77','Fishy Street','Gotham','BT666FU','18000.5','Manny','Longarms','manarms@crooks.com')

