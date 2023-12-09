-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 09, 2023 at 07:14 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `decisiongame`
--

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `Nama` varchar(30) NOT NULL,
  `Score` bigint(20) NOT NULL,
  `HighLv` tinyint(4) NOT NULL,
  `NumReset` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `Nama`, `Score`, `HighLv`, `NumReset`) VALUES
(1, 'Amdila', 0, 1, 0),
(2, 'Rahmadi', 0, 1, 0),
(3, 'Amdila', 0, 1, 0),
(4, 'Amdila', 0, 1, 0),
(5, 'Rahmadi', 0, 1, 0),
(6, 'Amd', 0, 1, 0),
(7, 'Amd', 0, 1, 0),
(8, 'Amdul', 0, 1, 0),
(9, 'Amdull', 0, 1, 0),
(10, 'ass', -14, 1, 0),
(11, 'Amdila', 90616000, 21, 2),
(12, 'aa', -3, 1, 0),
(13, 'A', -100, 1, 0),
(14, 'a', -39, 1, 0),
(15, 'b', 0, 1, 0),
(16, 'bb', 0, 1, 0),
(17, 'aa', -100, 1, 0),
(18, 'ccc', -100, 1, 5),
(19, 'a', -100, 1, 0),
(20, 'a', -100, 1, 0),
(21, 'amdila', -15, 1, 0),
(22, 'a', -16, 1, 0),
(23, 'c', -100, 1, 0),
(24, 'z', -100, 1, 0),
(25, 'c', 0, 1, 0),
(26, 'v', 0, 1, 0),
(27, 's', 0, 1, 0),
(28, 'zz', -9, 1, 0),
(29, 'aaaa', -12, 1, 0),
(30, 'aaaa', -18, 1, 0),
(31, 'd', 0, 1, 0),
(32, 'Amed', -4, 1, 0),
(33, 'aaaaaa', -15, 1, 1),
(34, 'sss', -100, 1, 0),
(35, 'kk', -15, 2, 0),
(36, 'm', -4, 1, 0),
(37, 'oo', -100, 1, 7),
(38, 'kl', -20, 1, 0),
(39, 'jj', -13, 1, 1),
(40, 'ghghf', -27, 1, 0),
(41, 'opo', -22, 1, 0),
(42, 'lllll', -100, 1, 0),
(43, 'nnnnnnn', 0, 1, 0),
(44, 'adada', 0, 1, 0),
(45, 'amdal', 0, 1, 0),
(46, 'jjo', -33, 1, 0),
(47, 'amdal', 0, 1, 0),
(48, 'alkam', -22, 1, 1),
(49, 'mbmbm', -21, 1, 0),
(50, 'sally', -100, 6, 7),
(51, 'SallyLah', -719, 6, 7),
(52, 'sallylah', -100, 6, 8),
(53, 'SallyLah', 22031797, 21, 1),
(54, 'Maola', -2, 2, 1),
(55, 'df', 0, 1, 0),
(56, 'df', -5, 2, 0),
(57, 'ddf', 5, 1, 0),
(58, 'Anjim', 19, 3, 0),
(59, 'ff', -15, 2, 0),
(60, 'er', 0, 1, 0),
(61, 'wew', -18, 2, 0),
(62, 'rr', -100, 2, 7),
(63, 'gh', -100, 8, 7),
(64, 'ddddd', -12, 1, 1),
(65, 'gggg', -100, 1, 7),
(66, 'ffvfvfvf', 1229607696, 21, 1),
(67, 'rre', -3, 6, 6),
(68, 'h', 0, 1, 0),
(69, 'j', 0, 1, 0),
(70, 'j', 0, 1, 0),
(71, 'j', 0, 1, 0),
(72, 'f', 5, 1, 0),
(73, 'kk', 5, 1, 0),
(74, 'dd', 0, 1, 0),
(75, 'llll', 5, 1, 0),
(76, 'ss', -16, 1, 0),
(77, 'n', 5, 1, 0),
(78, 'jj', 5, 1, 0),
(79, 'aaaa', -18, 1, 0),
(80, 'mk', 0, 1, 0),
(81, 'sss', 23, 2, 2),
(82, 's', -100, 1, 0),
(83, 'halu', 20697093, 21, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=84;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
