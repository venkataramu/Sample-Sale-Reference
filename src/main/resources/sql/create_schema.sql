CREATE DATABASE IF NOT EXISTS flashsale;
use flashsale;

DROP TABLE IF EXISTS flashsale.registered_users;
CREATE TABLE `registered_users` (
  `user_id` bigint(20) NOT NULL,
  `register_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB;

CREATE TABLE `products` (
  `product_id` bigint(20) NOT NULL,
  `created_on` timestamp NOT NULL DEFAULT NOW(),
  `name` varchar(255) DEFAULT NULL,
  `quantity_in_sale` bigint(20) NOT NULL,
  `sale_end_time` datetime DEFAULT NULL,
  `sale_start_time` datetime DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB;


CREATE TABLE `orders` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_on` timestamp NOT NULL DEFAULT NOW(),
  `product_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  CONSTRAINT `fk_key_userid` FOREIGN KEY (`user_id`) REFERENCES `registered_users` (`user_id`),
  CONSTRAINT `fk_key_productid` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`)
) ENGINE=InnoDB;





