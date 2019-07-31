use shop;

CREATE TABLE `user`
(
    `id` int PRIMARY KEY auto_increment,
    `name` varchar(255) not null ,
    `password` varchar(64) not null ,
    `role` ENUM ('ADMIN', 'USER','COURIER') not null ,
    `telephone_number` varchar(255) not null ,
    `img` blob
);


CREATE TABLE `order`
(
    `id` int PRIMARY KEY auto_increment,
    `user_id` int not null ,
    `type_pay` ENUM ('cash', 'cashless'),
    `date_ord` date,
    `delivery_type` ENUM ('pickup', 'courier'),
    `total_price` decimal
);

CREATE TABLE `chose_product`
(
    `id` int auto_increment,
    `product_id` int not null ,
    `count` int,
    PRIMARY KEY (`id`)
);

create TABLE `cart`
(
    `user_id` int not null ,
    `chose_product_id` int not null ,
    primary key (`user_id`,`chose_product_id`)
);

create TABLE `product_ordered`
(
    `order_id` int not null ,
    `chose_product_id` int not null ,
    primary key (`order_id`,`chose_product_id`)
);

CREATE TABLE `product`
(
    `id` int PRIMARY KEY AUTO_INCREMENT,
    `name` varchar(255) not null ,
    `type` varchar(255) not null ,
    `cost` decimal not null ,
    `img` varchar(255)
);

CREATE TABLE `delivery`
(
    `order_id` int  not null ,
    `courier_id` int not null ,
    `user_id` int not null ,
    `cost` decimal,
    PRIMARY KEY(`order_id`,`courier_id`)
);

CREATE TABLE `addres`
(
    `user_id` int PRIMARY KEY,
    `street` varchar(255) not null ,
    `house` int not null
);

ALTER TABLE `order` ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
    ON UPDATE CASCADE
    ON DELETE RESTRICT;

ALTER TABLE `delivery` ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
    ON UPDATE CASCADE
    ON DELETE RESTRICT;

ALTER TABLE `delivery` ADD FOREIGN KEY (`courier_id`) REFERENCES `user` (`id`)
    ON UPDATE CASCADE
    ON DELETE RESTRICT;

ALTER TABLE `delivery` ADD FOREIGN KEY (`order_id`) REFERENCES  `order`(`id`)
    ON UPDATE CASCADE
    ON DELETE RESTRICT;

ALTER TABLE `addres` ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
    ON UPDATE CASCADE
    ON DELETE RESTRICT;

ALTER TABLE `chose_product` ADD FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
    ON UPDATE CASCADE
    ON DELETE RESTRICT;

ALTER TABLE `cart` ADD FOREIGN KEY (`user_id`) REFERENCES `user`(`id`)
    ON UPDATE CASCADE
    ON DELETE RESTRICT;

ALTER TABLE `cart` ADD FOREIGN KEY (`chose_product_id`) REFERENCES `chose_product`(`id`)
    ON UPDATE CASCADE
    ON DELETE RESTRICT;

ALTER TABLE product_ordered ADD FOREIGN KEY (`order_id`) REFERENCES `order` (`id`)
    ON UPDATE CASCADE
    ON DELETE RESTRICT ;

ALTER TABLE product_ordered ADD FOREIGN KEY (`chose_product_id`) REFERENCES `chose_product` (`id`)
    ON UPDATE CASCADE
    ON DELETE RESTRICT ;
