CREATE TABLE IF NOT EXISTS `user_profile` (
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `full_name` VARCHAR(255) NOT NULL,
    `email` VARCHAR(255) UNIQUE NOT NULL,
    `date_of_birth` DATE,
    `telephone_number` VARCHAR(20),
    `address` VARCHAR(255),
PRIMARY KEY (`id`))
ENGINE = InnoDB;