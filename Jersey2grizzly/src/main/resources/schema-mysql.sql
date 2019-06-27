--CREATE DATABASE appws;
CREATE TABLE `appws`.`N01_Autor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `appws`.`N02_Category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `appws`.`N03_School` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `appws`.`N04_Student` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(100) NULL,
    `birthday` DATE NULL,
    `id_school` INT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_N04_Student_School_idx` (`id_school` ASC) VISIBLE,
    CONSTRAINT `fk_N04_Student_School`
      FOREIGN KEY (`id_school`)
      REFERENCES `appws`.`N03_School` (`id`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);

CREATE TABLE `appws`.`N05_Book` (
        `id` INT NOT NULL AUTO_INCREMENT,
        `name` VARCHAR(100) NULL,
        `publication` VARCHAR(45) NULL,
        `id_autor` INT NULL,
        `id_category` INT NULL,
        PRIMARY KEY (`id`),
        INDEX `fk_N05_Book_Autor_idx` (`id_autor` ASC) VISIBLE,
        INDEX `fk_N05_Book_Category_idx` (`id_category` ASC) VISIBLE,
        CONSTRAINT `fk_N05_Book_Autor`
          FOREIGN KEY (`id_autor`)
          REFERENCES `appws`.`N01_Autor` (`id`)
          ON DELETE NO ACTION
          ON UPDATE NO ACTION,
        CONSTRAINT `fk_N05_Book_Category`
          FOREIGN KEY (`id_category`)
          REFERENCES `appws`.`N02_Category` (`id`)
          ON DELETE NO ACTION
          ON UPDATE NO ACTION);
-- UPDATE `appws`.`N01_Autor` SET `name` = 'Amanda Silva' WHERE (`id` = '2');
/*INSERT INTO `appws`.`N02_Category`
(`name`)
VALUES
('Fantasia');
INSERT INTO `appws`.`N02_Category`
(`name`)
VALUES
('Ação');
INSERT INTO `appws`.`N02_Category`
(`name`)
VALUES
('Terror');
INSERT INTO `appws`.`N02_Category`
(`name`)
VALUES
('Tecnologia');
INSERT INTO `appws`.`N05_Book`
(`name`,
`publication`,
`id_autor`,
`id_category`)
VALUES(
'Book 1',
'2019-06-01',
1,
3);

INSERT INTO `appws`.`N05_Book`
(`name`,
`publication`,
`id_autor`,
`id_category`)
VALUES(
'Book 2',
'2019-06-01',
1,
3);

INSERT INTO `appws`.`N05_Book`
(`name`,
`publication`,
`id_autor`,
`id_category`)
VALUES(
'Book 4',
'2019-06-01',
1,
3);

INSERT INTO `appws`.`N05_Book`
(`name`,
`publication`,
`id_autor`,
`id_category`)
VALUES(
'Book 5',
'2019-06-01',
1,
3);

*/
