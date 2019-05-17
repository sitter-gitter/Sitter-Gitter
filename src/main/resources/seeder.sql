USE sitter_gitter_db;


INSERT INTO users (username, email, password, first_name, last_name, address, city, state, zip_code, is_babysitter)
VALUES ('Dwight', 'dwight@codeup.com', '$2a$10$Vh/68GBeHSHiIgujx.zEzetpwORkBI0i7b9I43kyTIgP2JzTaz4Q2', 'Dwight', 'Bemisderfer', '600 Navarro St #350', 'San Antonio', 'TX', '78205', 0),
       ('Erik', 'erik@codeup.com', '$2a$10$Vh/68GBeHSHiIgujx.zEzetpwORkBI0i7b9I43kyTIgP2JzTaz4Q2', 'Erik', 'Behnke', '600 Navarro St #350', 'San Antonio', 'TX', '78205', 0),
       ('Mindy', 'mindy@codeup.com', '$2a$10$Vh/68GBeHSHiIgujx.zEzetpwORkBI0i7b9I43kyTIgP2JzTaz4Q2', 'Mindy', 'Tillman', '600 Navarro St #350', 'San Antonio', 'TX', '78205', 1);


INSERT INTO children (name, birthdate, special_note, parent_id)
VALUES ('Harry', '2015-12-11', NULL, (SELECT id FROM users WHERE email = 'dwight@codeup.com')),
       ('Larry', '2017-07-05', 'Larry likes warm milk before going to bed.', (SELECT id FROM users WHERE email = 'dwight@codeup.com')),
       ('Mary', '2018-03-09', 'Please give Mary a bedtime story and a backrub to help her go to sleep.', (SELECT id FROM users WHERE email = 'erik@codeup.com'));


INSERT INTO appointments (start, end, sitter_approved, babysitter_id, parent_id)
VALUES ('2019-05-31 18:00:00', '2019-05-31 21:00:00', 1, 3, 1),
       ('2019-06-07 18:00:00', '2019-06-07 20:00:00', 1, 3, 1),
       ('2019-06-05 16:00:00', '2019-06-05 22:00:00', 1, 3, 2);


INSERT INTO reviews (title, body, is_recommended, babysitter_id, parent_id)
VALUES ('Highly Recommended!', 'Everybody in the city should hire this babysitter. She\'s just that good.', 1, 3, 1),
       ('Don\'t waste your money, people!', 'This babysitter spilled a bag of potato chips on our couch and didn\'t even bother to clean up the mess. Horrid!', 0, 3, 2);


INSERT INTO available_times (start, end, babysitter_id)
VALUES ('2019-05-31 12:00:00', '2019-05-31 23:00:00', 3),
       ('2019-06-01 12:00:00', '2019-06-01 23:00:00', 3),
       ('2019-06-02 12:00:00', '2019-06-02 23:00:00', 3),
       ('2019-06-03 12:00:00', '2019-06-03 23:00:00', 3),
       ('2019-06-04 12:00:00', '2019-06-04 23:00:00', 3),
       ('2019-06-05 12:00:00', '2019-06-05 16:00:00', 3),
       ('2019-06-06 12:00:00', '2019-06-06 23:00:00', 3),
       ('2019-06-07 12:00:00', '2019-06-07 14:00:00', 3),
       ('2019-06-08 12:00:00', '2019-06-08 23:00:00', 3);

INSERT INTO specifications (is_smoker, has_cpr_training, has_transportation, years_of_experience, birthdate, babysitter_id)
VALUES (false, true, true, 5, '1993-10-23', 3);

# INSERT INTO specifications (is_smoker, has_cpr_training, has_transportation, years_of_experience, education_level, birthdate, babysitter_id)
# VALUES (false, true, true, 5, e3, '1993-10-23', 3);

