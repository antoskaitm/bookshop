CREATE TABLE order_lines(
  id INT (11) NOT NULL AUTO_INCREMENT,
  order_id INT (11) NOT NULL,
  book_id INT (11) NOT NULL,
  quantity INT (11) NOT NULL,
  PRIMARY KEY (id),
  INDEX order_line_FK3 USING BTREE (book_id),
  INDEX order_line_FK4 USING BTREE (order_id),
  CONSTRAINT order_line_FK3 FOREIGN KEY (book_id)
  REFERENCES books (id),
  CONSTRAINT order_line_FK4 FOREIGN KEY (order_id)
  REFERENCES orders (id)
);