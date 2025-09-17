--CREATE TABLE user_details (
--  id BIGINT AUTO_INCREMENT PRIMARY KEY,
--  birth_date DATE,
--  name VARCHAR(255)
--);

INSERT INTO user_details (birth_date, name) VALUES (current_date(), 'Eva');
INSERT INTO user_details (birth_date, name) VALUES (current_date(), 'Allison');
INSERT INTO user_details (birth_date, name) VALUES (current_date(), 'William');
INSERT INTO user_details (birth_date, name) VALUES (current_date(), 'Sophia');
INSERT INTO user_details (birth_date, name) VALUES (current_date(), 'James');
INSERT INTO user_details (birth_date, name) VALUES (current_date(), 'Isabella');
INSERT INTO user_details (birth_date, name) VALUES (current_date(), 'Oliver');


INSERT INTO post_details (description, user_id) VALUES ('Post 1 Description', 1);
INSERT INTO post_details (description, user_id) VALUES ('Post 2 Description', 1);
INSERT INTO post_details (description, user_id) VALUES ('Post 3 Description', 2);
INSERT INTO post_details (description, user_id) VALUES ('Post 4 Description', 6);
INSERT INTO post_details (description, user_id) VALUES ('Post 5 Description', 3);
INSERT INTO post_details (description, user_id) VALUES ('Post 6 Description', 4);
INSERT INTO post_details (description, user_id) VALUES ('Post 7 Description', 1);
INSERT INTO post_details (description, user_id) VALUES ('Post 8 Description', 5);