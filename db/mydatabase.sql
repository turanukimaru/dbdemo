-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- ホスト: mysql
-- 生成日時: 2023 年 12 月 08 日 08:07
-- サーバのバージョン： 8.0.28
-- PHP のバージョン: 8.2.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- データベース: `mydatabase`
--

-- --------------------------------------------------------

--
-- テーブルの構造 `child`
--

CREATE TABLE `child` (
  `child_id` int NOT NULL,
  `dummy_id` int NOT NULL,
  `name` text NOT NULL,
  `text` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- テーブルのデータのダンプ `child`
--

INSERT INTO `child` (`child_id`, `dummy_id`, `name`, `text`) VALUES
(1, 1, 'nameA', 'textA');

-- --------------------------------------------------------

--
-- テーブルの構造 `dummy`
--

CREATE TABLE `dummy` (
  `dummy_id` int NOT NULL,
  `name` text NOT NULL,
  `text` text NOT NULL,
  `comment` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- テーブルのデータのダンプ `dummy`
--

INSERT INTO `dummy` (`dummy_id`, `name`, `text`, `comment`) VALUES
(1, 'nameA', 'textA', 'commentA');

--
-- ダンプしたテーブルのインデックス
--

--
-- テーブルのインデックス `child`
--
ALTER TABLE `child`
  ADD PRIMARY KEY (`child_id`);

--
-- テーブルのインデックス `dummy`
--
ALTER TABLE `dummy`
  ADD PRIMARY KEY (`dummy_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
