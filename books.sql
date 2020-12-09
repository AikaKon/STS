CREATE DATABASE `books_management`
    DEFAULT CHARSET utf8
    DEFAULT COLLATE utf8_general_ci
;
USE `books_management`;




CREATE TABLE `time` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `borrowing_time` datetime NOT NULL COMMENT '貸出日時',
  `return_due_date` datetime NOT NULL COMMENT '返却予定日',
  `return_time` datetime DEFAULT NULL COMMENT '返却日時',
  `book_id` int(11) NOT NULL COMMENT '本のID',
  `user_id` int(11) NOT NULL COMMENT 'ユーザーID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email_address` varchar(100) NOT NULL COMMENT 'アドレス',
  `encoded_password` varchar(255) NOT NULL COMMENT 'パスワード',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '本の名前',
  `user_id` int(11) DEFAULT NULL COMMENT 'ユーザーID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;


INSERT INTO `book`VALUES 
(1,'犬の気持ち',1),
(2,'犬人間',2),
(3,'ダックスフンドの本',1),
(4,'101',3),
(5,'犬の言葉が理解できる！',3),
(6,'book',4),
(7,'クリーム',NULL),
(8,'犬島',NULL),
(9,'犬の医学',NULL),
(10,'イッヌ',NULL)
;

INSERT INTO `users`VALUES
(1,'demo@demo.com','demo')
;