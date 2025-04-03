-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
SET @@session.restrict_fk_on_non_standard_key=OFF;
-- -----------------------------------------------------
-- Schema green_univ
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema green_univ
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `green_univ` DEFAULT CHARACTER SET utf8 ;
USE `green_univ` ;

-- -----------------------------------------------------
-- Table `green_univ`.`image`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`image` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `location` VARCHAR(255) NULL,
  `thumbnail_location` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `green_univ`.`college`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`college` (
  `id` INT NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `eng_name` VARCHAR(100) NULL,
  `description` TEXT NOT NULL,
  `image_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_college_image1_idx` (`image_id` ASC) VISIBLE,
  CONSTRAINT `fk_college_image1`
    FOREIGN KEY (`image_id`)
    REFERENCES `green_univ`.`image` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `green_univ`.`department`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`department` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `college_id` INT NOT NULL,
  `est_year` YEAR NULL,
  `name` VARCHAR(20) NOT NULL,
  `eng_name` VARCHAR(100) NULL,
  `contact` VARCHAR(14) NOT NULL,
  `office` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_department_college1_idx` (`college_id` ASC) VISIBLE,
  CONSTRAINT `fk_department_college1`
    FOREIGN KEY (`college_id`)
    REFERENCES `green_univ`.`college` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `green_univ`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`user` (
  `id` VARCHAR(20) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `eng_name` VARCHAR(50) NULL,
  `gender` ENUM("m", "f") NULL,
  `nationality` VARCHAR(20) NULL,
  `social_number` VARCHAR(45) NULL,
  `email` VARCHAR(45) NOT NULL,
  `contact` VARCHAR(45) NOT NULL,
  `zip` CHAR(5) NOT NULL,
  `address` VARCHAR(255) NOT NULL,
  `address_detail` VARCHAR(100) NOT NULL,
  `role` ENUM("professor", "student", "admin", "general") NOT NULL,
  `agreed_terms` TINYINT NOT NULL DEFAULT 0,
  `register_date` DATETIME NOT NULL,
  `leave_date` DATETIME NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `contact_UNIQUE` (`contact` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `green_univ`.`professor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`professor` (
  `id` CHAR(7) NOT NULL,
  `user_id` VARCHAR(20) NOT NULL,
  `department_id` INT NOT NULL,
  `graduated_from` VARCHAR(100) NOT NULL,
  `graduated_at` DATE NOT NULL,
  `major` VARCHAR(50) NOT NULL,
  `degree` ENUM("master", "phd") NOT NULL,
  `employed_at` DATE NOT NULL,
  `status` ENUM("in", "break", "out") NOT NULL,
  `position` ENUM("full", "assoc", "asst") NOT NULL,
  `is_chief` TINYINT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  INDEX `fk_professor_department1_idx` (`department_id` ASC) VISIBLE,
  INDEX `fk_professor_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_professor_department1`
    FOREIGN KEY (`department_id`)
    REFERENCES `green_univ`.`department` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_professor_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `green_univ`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `green_univ`.`article`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`article` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(20) NOT NULL,
  `title` VARCHAR(50) NOT NULL,
  `category` ENUM("notice", "news", "column", "employment", "bulletin", "qna", "gallery", "resources") NOT NULL,
  `status` ENUM("open", "close") NULL DEFAULT 'open',
  `content` TEXT NOT NULL,
  `view` INT NOT NULL DEFAULT 0,
  `register_date` DATE NOT NULL,
  PRIMARY KEY (`id`, `user_id`),
  INDEX `fk_article_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_article_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `green_univ`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `green_univ`.`schedule`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`schedule` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(25) NOT NULL,
  `date` DATE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `green_univ`.`student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`student` (
  `student_number` CHAR(8) NOT NULL,
  `user_id` VARCHAR(20) NOT NULL,
  `department_id` INT NOT NULL,
  `image_id` INT NULL,
  `grade` TINYINT NOT NULL DEFAULT 1,
  `semester` TINYINT NOT NULL DEFAULT 1,
  `current_credit` INT NOT NULL DEFAULT 0,
  `graduation_credit` INT NOT NULL,
  `status` ENUM("in", "grad", "break", "expell") NOT NULL DEFAULT 'in',
  `entrance_type` ENUM("regular", "rolling") NOT NULL,
  `entrance_year` YEAR NOT NULL,
  `entrance_grade` TINYINT NULL,
  `entrance_semester` TINYINT NOT NULL,
  `graduation_year` YEAR NULL,
  `supvis_prof_id` CHAR(7) NOT NULL,
  PRIMARY KEY (`student_number`, `user_id`),
  INDEX `fk_student_department_idx` (`department_id` ASC) VISIBLE,
  INDEX `fk_student_user1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_student_organization_image1_idx` (`image_id` ASC) VISIBLE,
  INDEX `fk_student_professor1_idx` (`supvis_prof_id` ASC) VISIBLE,
  CONSTRAINT `fk_student_department`
    FOREIGN KEY (`department_id`)
    REFERENCES `green_univ`.`department` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_student_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `green_univ`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_student_organization_image1`
    FOREIGN KEY (`image_id`)
    REFERENCES `green_univ`.`image` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_professor1`
    FOREIGN KEY (`supvis_prof_id`)
    REFERENCES `green_univ`.`professor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `green_univ`.`lecture_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`lecture_info` (
  `id` CHAR(6) NOT NULL,
  `department_id` INT NOT NULL,
  `professor_id` CHAR(7) NOT NULL,
  `level` TINYINT NOT NULL,
  `classification` ENUM("major", "selective", "liberal") NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `credit` TINYINT NOT NULL,
  `semester` TINYINT NOT NULL,
  `description` TEXT NULL,
  `textbook` VARCHAR(255) NULL,
  `classroom` VARCHAR(50) NULL,
  `start_date` DATE NULL,
  `end_date` DATE NULL,
  `evaluation_methods` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_lecture_department1_idx` (`department_id` ASC) VISIBLE,
  INDEX `fk_lecture_professor1_idx` (`professor_id` ASC) VISIBLE,
  CONSTRAINT `fk_lecture_department1`
    FOREIGN KEY (`department_id`)
    REFERENCES `green_univ`.`department` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_lecture_professor1`
    FOREIGN KEY (`professor_id`)
    REFERENCES `green_univ`.`professor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `green_univ`.`lecture_day`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`lecture_day` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `day` ENUM("mon", "tue", "wed", "thur", "fri") NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `green_univ`.`lecture_time`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`lecture_time` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `time` TIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `green_univ`.`lecture`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`lecture` (
  `id` CHAR(6) NOT NULL,
  `lecture_day_id` INT NOT NULL,
  `start_time_id` INT NOT NULL,
  `end_time_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_lecture_time_lecture1_idx` (`id` ASC) VISIBLE,
  INDEX `fk_lecture_time_lecture_day1_idx` (`lecture_day_id` ASC) VISIBLE,
  INDEX `fk_lecture_time_lecture_time1_idx` (`start_time_id` ASC) VISIBLE,
  CONSTRAINT `fk_lecture_time_lecture1`
    FOREIGN KEY (`id`)
    REFERENCES `green_univ`.`lecture_info` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_lecture_time_lecture_day1`
    FOREIGN KEY (`lecture_day_id`)
    REFERENCES `green_univ`.`lecture_day` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_lecture_time_lecture_time1`
    FOREIGN KEY (`start_time_id`)
    REFERENCES `green_univ`.`lecture_time` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `green_univ`.`registry_lecture`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`registry_lecture` (
  `id` CHAR(6) NOT NULL,
  `registered_number` TINYINT NOT NULL DEFAULT 0,
  `max_registered` TINYINT NOT NULL,
  `register_date` DATE NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_registry_lecture_lecture1_idx` (`id` ASC) VISIBLE,
  CONSTRAINT `fk_registry_lecture_lecture1`
    FOREIGN KEY (`id`)
    REFERENCES `green_univ`.`lecture` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `green_univ`.`registry`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`registry` (
  `student_number` CHAR(8) NOT NULL,
  `id` CHAR(6) NOT NULL,
  `current_year` YEAR NOT NULL,
  `register_date` DATE NOT NULL,
  PRIMARY KEY (`student_number`, `id`),
  INDEX `fk_registry_student1_idx` (`student_number` ASC) VISIBLE,
  INDEX `fk_registry_registry_lecture1_idx` (`id` ASC) VISIBLE,
  CONSTRAINT `fk_registry_student1`
    FOREIGN KEY (`student_number`)
    REFERENCES `green_univ`.`student` (`student_number`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_registry_registry_lecture1`
    FOREIGN KEY (`id`)
    REFERENCES `green_univ`.`registry_lecture` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `green_univ`.`file`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`file` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `article_id` INT NOT NULL,
  `location` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_file_article1_idx` (`article_id` ASC) VISIBLE,
  CONSTRAINT `fk_file_article1`
    FOREIGN KEY (`article_id`)
    REFERENCES `green_univ`.`article` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `green_univ`.`score`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`score` (
  `student_number` CHAR(8) NOT NULL,
  `lecture_id` CHAR(6) NOT NULL,
  `attend_score` TINYINT NULL,
  `mid_score` TINYINT NULL,
  `final_score` TINYINT NULL,
  `etc_score` TINYINT NULL,
  `grade` CHAR(1) NULL,
  PRIMARY KEY (`student_number`, `lecture_id`),
  INDEX `fk_score_lecture1_idx` (`lecture_id` ASC) VISIBLE,
  CONSTRAINT `fk_score_student1`
    FOREIGN KEY (`student_number`)
    REFERENCES `green_univ`.`student` (`student_number`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_score_lecture1`
    FOREIGN KEY (`lecture_id`)
    REFERENCES `green_univ`.`lecture_info` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `green_univ`.`student_council`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`student_council` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(25) NOT NULL,
  `content` VARCHAR(255) NOT NULL,
  `url` TEXT NULL,
  `image_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_student_council_organization_image1_idx` (`image_id` ASC) VISIBLE,
  CONSTRAINT `fk_student_council_organization_image1`
    FOREIGN KEY (`image_id`)
    REFERENCES `green_univ`.`image` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `green_univ`.`article_image`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`article_image` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `article_id` INT NOT NULL,
  `location` VARCHAR(255) NOT NULL,
  `thumbnail_location` VARCHAR(255) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_image_article1_idx` (`article_id` ASC) VISIBLE,
  CONSTRAINT `fk_image_article1`
    FOREIGN KEY (`article_id`)
    REFERENCES `green_univ`.`article` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `green_univ`.`club`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`club` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(25) NOT NULL,
  `content` VARCHAR(45) NOT NULL,
  `url` TEXT NULL,
  `image_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_club_organization_image1_idx` (`image_id` ASC) VISIBLE,
  CONSTRAINT `fk_club_organization_image1`
    FOREIGN KEY (`image_id`)
    REFERENCES `green_univ`.`image` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `green_univ`.`menu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`menu` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `main` VARCHAR(10) NOT NULL,
  `soup` VARCHAR(10) NOT NULL,
  `rice` VARCHAR(10) NOT NULL,
  `side_1` VARCHAR(10) NULL,
  `side_2` VARCHAR(10) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `green_univ`.`meal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`meal` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `menu_id` INT NOT NULL,
  `date` DATE NOT NULL,
  `meal_time` ENUM("breakfast", "lunch", "dinner") NOT NULL,
  PRIMARY KEY (`id`, `menu_id`),
  INDEX `fk_meal_menu1_idx` (`menu_id` ASC) VISIBLE,
  CONSTRAINT `fk_meal_menu1`
    FOREIGN KEY (`menu_id`)
    REFERENCES `green_univ`.`menu` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `green_univ`.`comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(20) NOT NULL,
  `article_id` INT NOT NULL,
  `content` VARCHAR(255) NOT NULL,
  `register_date` DATETIME NOT NULL,
  PRIMARY KEY (`id`, `user_id`),
  INDEX `fk_comment_user1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_comment_article1_idx` (`article_id` ASC) VISIBLE,
  CONSTRAINT `fk_comment_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `green_univ`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_comment_article1`
    FOREIGN KEY (`article_id`)
    REFERENCES `green_univ`.`article` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `green_univ`.`faq`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`faq` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `category` VARCHAR(100) NOT NULL,
  `question` VARCHAR(255) NOT NULL,
  `answer` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `green_univ`.`term`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`term` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NULL,
  `content` TEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `green_univ`.`qna`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`qna` (
  `question_id` INT NOT NULL AUTO_INCREMENT,
  `answer_id` INT NULL,
  `is_private` TINYINT NULL DEFAULT 0,
  `password` CHAR(8) NULL,
  PRIMARY KEY (`question_id`),
  INDEX `fk_reply_article_article1_idx` (`question_id` ASC) VISIBLE,
  CONSTRAINT `fk_reply_article_article1`
    FOREIGN KEY (`question_id`)
    REFERENCES `green_univ`.`article` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
