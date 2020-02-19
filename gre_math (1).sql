-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 11, 2019 at 07:57 AM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gre_math`
--

-- --------------------------------------------------------

--
-- Table structure for table `app_database`
--

CREATE TABLE `app_database` (
  `q_id` int(11) NOT NULL,
  `question` varchar(500) NOT NULL,
  `ans1` varchar(255) NOT NULL,
  `ans2` varchar(255) NOT NULL,
  `ans3` varchar(255) NOT NULL,
  `ans4` varchar(255) NOT NULL,
  `rightAns` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `app_database`
--

INSERT INTO `app_database` (`q_id`, `question`, `ans1`, `ans2`, `ans3`, `ans4`, `rightAns`) VALUES
(1, 'A certain pet store sells only dogs and cats. In March, the store sold twice as many dogs as cats. In April, the store sold twice the number of dogs that it sold in March, and three times the number of cats that it sold in March. If the total number of pets the store sold in March and April combined was 500, how many dogs did the store sell in March?', '80', '100', '120', '160', '100'),
(2, 'What is the possible solution of | |x – 2| – 2| = 5?', '-5', '-3', '-1', '7', '-5'),
(3, 'Test Question?', '32', '34', '5', '3', '3');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `app_database`
--
ALTER TABLE `app_database`
  ADD PRIMARY KEY (`q_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `app_database`
--
ALTER TABLE `app_database`
  MODIFY `q_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
