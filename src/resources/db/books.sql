CREATE TABLE books (
  id INT NOT NULL AUTO_INCREMENT,
  book_title VARCHAR(255) NOT NULL,
  book_author VARCHAR(255) NOT NULL,
  book_price DOUBLE NOT NULL,
  book_image LONGBLOB NULL,
  PRIMARY KEY (id));
