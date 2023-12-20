--
-- テーブルの構造 `child`
--
CREATE TABLE `child`
(
    `child_id` int  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `dummy_id` int  NOT NULL,
    `name`     text NOT NULL,
    `text`     text NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- テーブルの構造 `dummy`
--

CREATE TABLE `dummy`
(
    `dummy_id` int  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name`     text NOT NULL,
    `text`     text NOT NULL,
    `comment`  text NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
