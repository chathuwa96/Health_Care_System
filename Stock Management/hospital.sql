-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 19, 2020 at 08:41 AM
-- Server version: 5.1.53
-- PHP Version: 5.3.4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `hospital`
--

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE IF NOT EXISTS `invoice` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `inv_no` varchar(15) NOT NULL,
  `pro_code` varchar(15) NOT NULL,
  `pro_des` varchar(50) NOT NULL,
  `price` float NOT NULL,
  `qty` int(11) NOT NULL,
  `subtot` float NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=44 ;

--
-- Dumping data for table `invoice`
--

INSERT INTO `invoice` (`ID`, `inv_no`, `pro_code`, `pro_des`, `price`, `qty`, `subtot`) VALUES
(1, 'INV1001', 'MED1001', 'test', 1250, 3, 3750),
(2, 'INV1002', 'MED1002', 'test2', 654, 5, 3270),
(3, 'INV1003', 'MED1002', 'test2', 654, 5, 3270),
(4, 'INV1003', 'MED1001', 'test', 1250, 5, 6250),
(5, 'INV1003', 'MED1001', 'test', 1250, 2, 2500),
(6, 'INV1004', 'MED1002', 'test2', 654, 5, 3270),
(7, 'INV1004', 'MED1002', 'test2', 654, 2, 1308),
(8, 'INV1004', 'MED1001', 'test', 1250, 1, 1250),
(9, 'INV1004', 'MED1002', 'test2', 654, 1, 654),
(14, 'INV1006', 'MED1003', 'test3', 1260, 2, 2520),
(11, 'INV1005', 'MED1003', 'test3', 1260, 20, 25200),
(23, 'INV1008', 'MED1002', 'test2', 654, 10, 6540),
(21, 'INV1007', 'MED1002', 'test2', 654, 5, 3270),
(27, 'INV1009', 'MED1002', 'test2', 654, 5, 3270),
(31, 'INV1011', 'MED1002', 'test2', 654, 5, 3270),
(30, 'INV1010', 'MED1002', 'test2', 654, 5, 3270),
(33, 'INV1012', 'MED1002', 'test2', 654, 1, 654),
(34, 'INV1013', 'MED1002', 'test2', 654, 2, 1308),
(36, 'INV1014', 'MED1002', 'test2', 654, 2, 1308),
(43, 'INV1017', 'MED1002', 'test2New', 654, 5, 3270),
(40, 'INV1015', 'MED1003', 'test3', 1260, 3, 3780),
(42, 'INV1016', 'MED1002', 'test2New', 654, 5, 3270);

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE IF NOT EXISTS `products` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `item_code` varchar(10) NOT NULL,
  `pro_name` varchar(50) NOT NULL,
  `price` float NOT NULL,
  `stock` int(11) NOT NULL,
  `re_order_point` int(11) NOT NULL,
  `description` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `item_code` (`item_code`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=27 ;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`ID`, `item_code`, `pro_name`, `price`, `stock`, `re_order_point`, `description`) VALUES
(25, 'MED1002', 'test2New', 654, 40, 5, 'test22'),
(26, 'MED1003', 'test3', 1260, 57, 10, 'Testing Goods');

-- --------------------------------------------------------

--
-- Table structure for table `register`
--

CREATE TABLE IF NOT EXISTS `register` (
  `UID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`UID`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `register`
--

INSERT INTO `register` (`UID`, `name`, `phone`, `email`, `password`) VALUES
(1, 'Admin', '0715961248', 'Admin@gmail.com', 'admin123');

-- --------------------------------------------------------

--
-- Table structure for table `test`
--

CREATE TABLE IF NOT EXISTS `test` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `pro_name` varchar(50) NOT NULL,
  `price` varchar(50) NOT NULL,
  `stock` varchar(50) NOT NULL,
  `re_order_point` varchar(50) NOT NULL,
  `description` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `test`
--

INSERT INTO `test` (`ID`, `pro_name`, `price`, `stock`, `re_order_point`, `description`) VALUES
(1, 'null', 'null', 'null', 'null', 'null'),
(2, 'null', 'null', 'null', 'null', 'null'),
(3, 'null', 'null', 'null', 'null', 'null'),
(4, 'null', 'null', 'null', 'null', 'null'),
(5, 'null', 'null', 'null', 'null', 'null'),
(6, 'ckahkjh', 'ghgg', 'ghgjj', 'ghhgjg', 'jgjgj');
