-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 08, 2020 at 03:04 PM
-- Server version: 10.1.35-MariaDB
-- PHP Version: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `app_login`
--

-- --------------------------------------------------------

--
-- Table structure for table `idkarya`
--

CREATE TABLE `idkarya` (
  `id` int(20) NOT NULL,
  `user` varchar(20) NOT NULL,
  `gambar` varchar(100) NOT NULL,
  `judul` varchar(50) NOT NULL,
  `platform` varchar(30) NOT NULL,
  `dekripsi` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `idkarya`
--

INSERT INTO `idkarya` (`id`, `user`, `gambar`, `judul`, `platform`, `dekripsi`) VALUES
(1, 'PutraWicaksana', 'https://appkey.co.id/wp-content/uploads/2019/09/android-app008.jpg', 'Logo Saver Application', 'Android', 'Menyimpan secara online desain logo yang dibuat');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `title` varchar(1000) NOT NULL,
  `shortdesc` varchar(500) NOT NULL,
  `user` varchar(50) NOT NULL,
  `platform` varchar(50) NOT NULL,
  `image` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `title`, `shortdesc`, `user`, `platform`, `image`) VALUES
(1, '\"Logo Saver Apllication\"', '\"For Better Application Saving\"', 'dimasputra', 'android', 'https://appkey.co.id/wp-content/uploads/2019/09/android-app008.jpg'),
(2, '\"Logo Saver Apllication\"', '\"For Better Application Saving\"', 'greezelboy', 'Web', 'https://solutech.id/wp-content/uploads/2019/07/crayon.co_-e1564042831113.png');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(5) NOT NULL,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`) VALUES
(1, 'dimas', 'dimas');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `idkarya`
--
ALTER TABLE `idkarya`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
