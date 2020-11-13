CREATE DATABASE file_comac;
USE file_comac;
CREATE TABLE file_info (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    file_name VARCHAR(255) NOT NULL,
    file_raw_name VARCHAR(255) NOT NULL,
    filename_desc VARCHAR(255) NOT NULL,
    file_path VARCHAR(255) NOT NULL
);