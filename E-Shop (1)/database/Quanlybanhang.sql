create database quanlibanhang;
CREATE TABLE `Role` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(20)
);

CREATE TABLE `User` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `fullname` varchar(50),
  `email` varchar(150),
  `phone_number` varchar(20),
  `address` varchar(200),
  `password` varchar(100),
  `role_id` int,
  `created_at` datetime,
  `updated_at` datetime,
  `enabled` BIT DEFAULT 1
);

CREATE TABLE `Tokens` (
  `user_id` int,
  `token` varchar(32),
  `created_at` datetime,
  PRIMARY KEY (`user_id`, `token`)
);

CREATE TABLE `Category` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(100)
);

CREATE TABLE `Product` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `category_id` int,
  `title` varchar(250),
  `num` int,
  `price` double,
  `discount` double,
  `thumbnail` varchar(500),
  `description` longtext,
  `created_at` datetime,
  `updated_at` datetime,
  `deleted` int
);

CREATE TABLE `Galery` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `product_id` int,
  `thumbnail` varchar(500)
);

CREATE TABLE `FeedBack` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `firstname` varchar(30),
  `lastname` varchar(30),
  `email` varchar(250),
  `phone_number` varchar(20),
  `subject_name` varchar(350),
  `note` varchar(1000),
  `status` int DEFAULT 0,
  `created_at` datetime,
  `updated_at` datetime
);

CREATE TABLE `Orders` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `user_id` int,
  `fullname` varchar(50),
  `email` varchar(150),
  `phone_number` varchar(20),
  `address` varchar(200),
  `note` varchar(1000),
  `order_date` datetime,
  `status` int,
  `total_money` double
);

CREATE TABLE `Order_Details` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `order_id` int,
  `product_id` int,
  `price` double,
  `num` int,
  `total_money` double
);
CREATE TABLE `Cart` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `user_id` int,
  `product_id` int,
  `num` int,
  `created_at` datetime,
  `updated_at` datetime
);

CREATE TABLE `Payment` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `user_id` int,
  `amount` double,
  `payment_method` varchar(50),
  `payment_date` datetime
);

ALTER TABLE `User` ADD FOREIGN KEY (`role_id`) REFERENCES `Role` (`id`);

ALTER TABLE `Product` ADD FOREIGN KEY (`category_id`) REFERENCES `Category` (`id`);

ALTER TABLE `Order_Details` ADD FOREIGN KEY (`product_id`) REFERENCES `Product` (`id`);

ALTER TABLE `Galery` ADD FOREIGN KEY (`product_id`) REFERENCES `Product` (`id`);

ALTER TABLE `Order_Details` ADD FOREIGN KEY (`order_id`) REFERENCES `Orders` (`id`);

ALTER TABLE `Orders` ADD FOREIGN KEY (`user_id`) REFERENCES `User` (`id`);

ALTER TABLE `Tokens` ADD FOREIGN KEY (`user_id`) REFERENCES `User` (`id`);
ALTER TABLE `Cart` ADD FOREIGN KEY (`user_id`) REFERENCES `User` (`id`);
ALTER TABLE `Cart` ADD FOREIGN KEY (`product_id`) REFERENCES `Product` (`id`);
ALTER TABLE `Payment` ADD FOREIGN KEY (`user_id`) REFERENCES `User` (`id`);
