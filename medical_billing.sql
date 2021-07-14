-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 05, 2021 at 08:11 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `medical_billing`
--

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `customer_id` int(11) DEFAULT NULL,
  `drug_name` varchar(50) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `customer_info`
--

CREATE TABLE `customer_info` (
  `customer_id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `total_pay` float DEFAULT NULL,
  `purchase_date` date DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer_info`
--

INSERT INTO `customer_info` (`customer_id`, `name`, `gender`, `mobile`, `address`, `total_pay`, `purchase_date`) VALUES
(1, 'satya', 'male', '839399393', 'kld', 9, '2021-03-29'),
(3, 'satya', 'male', '839399393', 'ad', 9, '2021-03-29'),
(4, 'pooja', 'female', '292992929', 'address', 1, '2021-03-29'),
(6, 'anoop', 'male', '22993934', 'addarss', 33, '2021-03-30');

-- --------------------------------------------------------

--
-- Table structure for table `drugs_info`
--

CREATE TABLE `drugs_info` (
  `drug_name` varchar(50) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `total_price` float DEFAULT NULL,
  `price_per_pcs` float DEFAULT NULL,
  `cur_date` date DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `drugs_info`
--

INSERT INTO `drugs_info` (`drug_name`, `quantity`, `total_price`, `price_per_pcs`, `cur_date`) VALUES
('Abacavir', 340, 233.34, 0.686294, '2021-03-27'),
('Alendronate', 190, 1400, 7.36842, '2021-03-27'),
('Allopurinol', 190, 2239, 11.7842, '2021-03-27');

-- --------------------------------------------------------

--
-- Table structure for table `login_info`
--

CREATE TABLE `login_info` (
  `usr_name` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `mobile` varchar(50) DEFAULT NULL,
  `passwd` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login_info`
--

INSERT INTO `login_info` (`usr_name`, `name`, `gender`, `email`, `address`, `mobile`, `passwd`) VALUES
('thepuja', 'puja gupta', 'female', 'puja@gmail.com', 'gorakhpur', '123456789', '123'),
('thesatya', 'satya mishra', 'male', 'satyamishra559@gmail.com', 'kld', '123456789', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD KEY `customer_id` (`customer_id`),
  ADD KEY `drug_name` (`drug_name`);

--
-- Indexes for table `customer_info`
--
ALTER TABLE `customer_info`
  ADD PRIMARY KEY (`customer_id`);

--
-- Indexes for table `drugs_info`
--
ALTER TABLE `drugs_info`
  ADD PRIMARY KEY (`drug_name`);

--
-- Indexes for table `login_info`
--
ALTER TABLE `login_info`
  ADD PRIMARY KEY (`usr_name`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer_info`
--
ALTER TABLE `customer_info`
  MODIFY `customer_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bill`
--
ALTER TABLE `bill`
  ADD CONSTRAINT `bill_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer_info` (`customer_id`),
  ADD CONSTRAINT `bill_ibfk_2` FOREIGN KEY (`drug_name`) REFERENCES `drugs_info` (`drug_name`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
