USE sitter_gitter_db;


INSERT INTO users (username, email, password, first_name, last_name, street_addr, city, state, zip_code,
                   is_babysitter)
VALUES ('Dwight', 'dwight@codeup.com', '$2a$10$Vh/68GBeHSHiIgujx.zEzetpwORkBI0i7b9I43kyTIgP2JzTaz4Q2', 'Dwight', 'Bemisderfer', '600 Navarro St #350', 'San Antonio', 'TX', '78205', 0),
       ('Erik', 'erik@codeup.com', '$2a$10$Vh/68GBeHSHiIgujx.zEzetpwORkBI0i7b9I43kyTIgP2JzTaz4Q2', 'Erik', 'Behnke', '600 Navarro St #350', 'San Antonio', 'TX', '78205', 0),

       ('Mindy', 'mindy@codeup.com', '$2a$10$Vh/68GBeHSHiIgujx.zEzetpwORkBI0i7b9I43kyTIgP2JzTaz4Q2', 'Mindy',
        'Tillman', '600 Navarro St #350', 'San Antonio', 'TX', '78205', 0),

       ('Parent1', 'parent1@codeup.com', '$2a$10$Vh/68GBeHSHiIgujx.zEzetpwORkBI0i7b9I43kyTIgP2JzTaz4Q2', 'Parent1',
        'Gitter', '600 Navarro St #1', 'San Antonio', 'TX', '78201', 0),

       ('Parent2', 'parent2@codeup.com', '$2a$10$Vh/68GBeHSHiIgujx.zEzetpwORkBI0i7b9I43kyTIgP2JzTaz4Q2', 'Parent2',
        'Gitter', '600 Navarro St #2', 'San Antonio', 'TX', '78202', 0),

       ('Babysitter1', 'sitter1@codeup.com', '$2a$10$Vh/68GBeHSHiIgujx.zEzetpwORkBI0i7b9I43kyTIgP2JzTaz4Q2',
        'Baby1', 'Sitter', '600 Navarro St #1', 'San Antonio', 'TX', '78201', 1),

       ('Babysitter2', 'sitter2@codeup.com', '$2a$10$Vh/68GBeHSHiIgujx.zEzetpwORkBI0i7b9I43kyTIgP2JzTaz4Q2',
        'Baby2', 'Sitter', '600 Navarro St #2', 'San Antonio', 'TX', '78202', 1),

       ('Babysitter3', 'sitter3@codeup.com', '$2a$10$Vh/68GBeHSHiIgujx.zEzetpwORkBI0i7b9I43kyTIgP2JzTaz4Q2',
        'Baby3', 'Sitter', '600 Navarro St #3', 'San Antonio', 'TX', '78203', 1),

       ('Babysitter4', 'sitter4@codeup.com', '$2a$10$Vh/68GBeHSHiIgujx.zEzetpwORkBI0i7b9I43kyTIgP2JzTaz4Q2',
        'Baby4', 'Sitter', '600 Navarro St #4', 'San Antonio', 'TX', '78204', 1),

       ('Babysitter5', 'sitter5@codeup.com', '$2a$10$Vh/68GBeHSHiIgujx.zEzetpwORkBI0i7b9I43kyTIgP2JzTaz4Q2',
        'Baby5', 'Sitter', '600 Navarro St #5', 'San Antonio', 'TX', '78205', 1);


INSERT INTO children (name, birthdate, special_note, parent_id)
VALUES
       ('Child1', '2015-12-11', 'Special Note', (SELECT id FROM users WHERE email = 'dwight@codeup.com')),
       ('Child2', '2017-07-05', 'Child2 likes warm milk before going to bed.', (SELECT id FROM users WHERE email = 'dwight@codeup.com')),
       ('Child3', '2018-03-09', 'Please give Child3 a bedtime story and a backrub to help her go to sleep.', (SELECT id FROM users WHERE email = 'dwight@codeup.com')),
       ('Child4', '2015-12-11', 'Special Note', (SELECT id FROM users WHERE email = 'erik@codeup.com')),
       ('Child5', '2017-07-05', 'Child5 likes warm milk before going to bed.', (SELECT id FROM users WHERE email =
                                                                                                           'erik@codeup
                                                                                                           .com')),
       ('Child6', '2018-03-09', 'Please give Child6 a bedtime story and a backrub to help her go to sleep.', (SELECT
                                                                                                                     id FROM users WHERE email = 'erik@codeup.com')),
       ('Child7', '2015-12-11', 'Special Note', (SELECT id FROM users WHERE email = 'mindy@codeup.com')),
       ('Child8', '2017-07-05', 'Child8 likes warm milk before going to bed.', (SELECT id FROM users WHERE email =
                                                                                                           'mindy@codeup
                                                                                                           .com')),
       ('Child9', '2018-03-09', 'Please give Child9 a bedtime story and a backrub to help her go to sleep.', (SELECT
                                                                                                                      id FROM users WHERE email = 'mindy@codeup.com')),
       ('Child10', '2015-12-11', 'Special Note', (SELECT id FROM users WHERE email = 'parent1@codeup.com')),
       ('Child11', '2017-07-05', 'Child11 likes warm milk before going to bed.', (SELECT id FROM users WHERE email =
                                                                                                           'parent1@codeup
                                                                                                           .com')),
       ('Child12', '2018-03-09', 'Please give Child12 a bedtime story and a backrub to help her go to sleep.', (SELECT
                                                                                                                     id FROM users WHERE email = 'parent1@codeup.com')),
       ('Child13', '2015-12-11', 'Special Note', (SELECT id FROM users WHERE email = 'parent2@codeup.com')),
       ('Child14', '2017-07-05', 'Child14 likes warm milk before going to bed.', (SELECT id FROM users WHERE email =
                                                                                                           'parent2@codeup
                                                                                                           .com')),
       ('Child15', '2018-03-09', 'Please give Child15 a bedtime story and a backrub to help her go to sleep.', (SELECT
                                                                                                                     id FROM users WHERE email = 'parent2@codeup.com')),
       ('Child16', '2015-12-11', 'Special Note', (SELECT id FROM users WHERE email = 'erik@codeup.com')),
       ('Child17', '2017-07-05', 'Child17 likes warm milk before going to bed.', (SELECT id FROM users WHERE email =
                                                                                                           'mindy@codeup
                                                                                                           .com')),
       ('Child18', '2018-03-09', 'Please give Child18 a bedtime story and a backrub to help her go to sleep.', (SELECT
                                                                                                                     id FROM users WHERE email = 'dwight@codeup.com'));



INSERT INTO available_times (start, end, babysitter_id, is_taken)
VALUES ('2019-05-31 08:00:00', '2019-05-31 23:00:00', 6, 0),
       ('2019-06-01 08:00:00', '2019-06-01 23:00:00', 6, 0),
       ('2019-06-02 08:00:00', '2019-06-02 23:00:00', 6, 0),
       ('2019-06-03 08:00:00', '2019-06-03 23:00:00', 6, 0),
       ('2019-06-04 08:00:00', '2019-06-04 23:00:00', 6, 0),
       ('2019-05-05 08:00:00', '2019-05-05 23:00:00', 6, 1),
       ('2019-02-06 08:00:00', '2019-02-06 23:00:00', 6, 1),
       ('2019-04-07 08:00:00', '2019-04-07 21:00:00', 6, 1),
       ('2019-06-08 08:00:00', '2019-06-08 23:00:00', 6, 0),
       ('2019-06-09 08:00:00', '2019-06-09 21:00:00', 6, 0),
       ('2019-06-10 08:00:00', '2019-06-10 23:00:00', 6, 0),
       ('2019-05-31 08:00:00', '2019-05-31 23:00:00', 7, 0),
       ('2019-06-01 08:00:00', '2019-06-01 23:00:00', 7, 0),
       ('2019-06-02 08:00:00', '2019-06-02 23:00:00', 7, 0),
       ('2019-06-03 08:00:00', '2019-06-03 23:00:00', 7, 0),
       ('2019-06-04 08:00:00', '2019-06-04 23:00:00', 7, 0),
       ('2019-06-05 08:00:00', '2019-06-05 23:00:00', 7, 1),
       ('2019-06-06 08:00:00', '2019-06-06 23:00:00', 7, 1),
       ('2019-06-07 08:00:00', '2019-06-07 21:00:00', 7, 1),
       ('2019-06-08 08:00:00', '2019-06-08 23:00:00', 7, 0),
       ('2019-06-09 08:00:00', '2019-06-09 21:00:00', 7, 0),
       ('2019-06-10 08:00:00', '2019-06-10 23:00:00', 7, 0),
       ('2019-05-31 08:00:00', '2019-05-31 23:00:00', 8, 0),
       ('2019-06-01 08:00:00', '2019-06-01 23:00:00', 8, 0),
       ('2019-06-02 08:00:00', '2019-06-02 23:00:00', 8, 0),
       ('2019-06-03 08:00:00', '2019-06-03 23:00:00', 8, 0),
       ('2019-06-04 08:00:00', '2019-06-04 23:00:00', 8, 0),
       ('2019-06-05 08:00:00', '2019-06-05 23:00:00', 8, 1),
       ('2019-06-06 08:00:00', '2019-06-06 23:00:00', 8, 1),
       ('2019-06-07 08:00:00', '2019-06-07 21:00:00', 8, 1),
       ('2019-06-08 08:00:00', '2019-06-08 23:00:00', 8, 0),
       ('2019-06-09 08:00:00', '2019-06-09 21:00:00', 8, 0),
       ('2019-06-10 08:00:00', '2019-06-10 23:00:00', 8, 0),
       ('2019-05-31 08:00:00', '2019-05-31 23:00:00', 9, 0),
       ('2019-06-01 08:00:00', '2019-06-01 23:00:00', 9, 0),
       ('2019-06-02 08:00:00', '2019-06-02 23:00:00', 9, 0),
       ('2019-06-03 08:00:00', '2019-06-03 23:00:00', 9, 0),
       ('2019-06-04 08:00:00', '2019-06-04 23:00:00', 9, 0),
       ('2019-06-05 08:00:00', '2019-06-05 23:00:00', 9, 1),
       ('2019-06-06 08:00:00', '2019-06-06 23:00:00', 9, 1),
       ('2019-06-07 08:00:00', '2019-06-07 21:00:00', 9, 1),
       ('2019-06-08 08:00:00', '2019-06-08 23:00:00', 9, 0),
       ('2019-06-09 08:00:00', '2019-06-09 21:00:00', 9, 0),
       ('2019-06-10 08:00:00', '2019-06-10 23:00:00', 9, 0),
       ('2019-05-31 08:00:00', '2019-05-31 23:00:00', 10, 0),
       ('2019-06-01 08:00:00', '2019-06-01 23:00:00', 10, 0),
       ('2019-06-02 08:00:00', '2019-06-02 23:00:00', 10, 0),
       ('2019-06-03 08:00:00', '2019-06-03 23:00:00', 10, 0),
       ('2019-06-04 08:00:00', '2019-06-04 23:00:00', 10, 0),
       ('2019-06-05 08:00:00', '2019-06-05 23:00:00', 10, 1),
       ('2019-06-06 08:00:00', '2019-06-06 23:00:00', 10, 1),
       ('2019-06-07 08:00:00', '2019-06-07 21:00:00', 10, 1),
       ('2019-06-08 08:00:00', '2019-06-08 23:00:00', 10, 0),
       ('2019-06-09 08:00:00', '2019-06-09 21:00:00', 10, 0),
       ('2019-06-10 08:00:00', '2019-06-10 23:00:00', 10, 0);



INSERT INTO appointments (start, end, sitter_approved, babysitter_id, parent_id, available_time_id)
VALUES ('2019-05-05 11:00:00', '2019-05-05 20:00:00', 1, 6, 1, 6),
       ('2019-02-06 11:00:00', '2019-02-06 20:00:00', 1, 6, 1, 7),
       ('2019-04-07 11:00:00', '2019-04-07 20:00:00', 1, 6, 1, 8),
       ('2019-06-05 11:00:00', '2019-06-05 20:00:00', 1, 7, 2, 17),
       ('2019-06-06 11:00:00', '2019-06-06 20:00:00', 1, 7, 2, 18),
       ('2019-06-07 11:00:00', '2019-06-07 20:00:00', 1, 7, 2, 19),
       ('2019-06-05 11:00:00', '2019-06-05 20:00:00', 1, 8, 3, 28),
       ('2019-06-06 11:00:00', '2019-06-06 20:00:00', 1, 8, 3, 29),
       ('2019-06-07 11:00:00', '2019-06-07 20:00:00', 1, 8, 3, 30),
       ('2019-06-05 11:00:00', '2019-06-05 20:00:00', 1, 9, 4, 39),
       ('2019-06-06 11:00:00', '2019-06-06 20:00:00', 1, 9, 4, 40),
       ('2019-06-07 11:00:00', '2019-06-07 20:00:00', 1, 9, 4, 41),
       ('2019-06-05 11:00:00', '2019-06-05 20:00:00', 1, 10, 5, 51),
       ('2019-06-06 11:00:00', '2019-06-06 20:00:00', 1, 10, 5, 52),
       ('2019-06-07 11:00:00', '2019-06-07 20:00:00', 1, 10, 5, 53);


INSERT INTO reviews (title, body, is_recommended, babysitter_id, parent_id, appointment_id)
VALUES ('Highly Recommended!', 'Everybody in the city should hire this babysitter. She\'s just that good.', 1, 6, 1, 1),
       ('Don\'t waste your money, people!', 'This babysitter spilled a bag of potato chips on our couch and didn\'t
       even bother to clean up the mess. Horrid!', 0, 6, 1, 4),
       ('Highly Recommended!', 'Everybody in the city should hire this babysitter. She\'s just that good.', 1, 7, 2, 7),
       ('Don\'t waste your money, people!', 'This babysitter spilled a bag of potato chips on our couch and didn\'t
       even bother to clean up the mess. Horrid!', 0, 7, 2, 10),
       ('Highly Recommended!', 'Everybody in the city should hire this babysitter. She\'s just that good.', 1, 8, 3, 13),
       ('Don\'t waste your money, people!', 'This babysitter spilled a bag of potato chips on our couch and didn\'t
       even bother to clean up the mess. Horrid!', 0, 8, 3, 2),
       ('Highly Recommended!', 'Everybody in the city should hire this babysitter. She\'s just that good.', 1, 9, 4, 5),
       ('Don\'t waste your money, people!', 'This babysitter spilled a bag of potato chips on our couch and didn\'t
       even bother to clean up the mess. Horrid!', 0, 9, 4, 8),
       ('Highly Recommended!', 'Everybody in the city should hire this babysitter. She\'s just that good.', 1, 10, 5, 11),
       ('Don\'t waste your money, people!', 'This babysitter spilled a bag of potato chips on our couch and didn\'t
       even bother to clean up the mess. Horrid!', 0, 10, 5, 14);



INSERT INTO specifications (is_smoker, has_cpr_training, has_transportation, years_of_experience, birthdate, babysitter_id)
VALUES (true, true, true, 1, '1991-01-01', 6),
       (true, true, true, 2, '1992-02-02', 7),
       (false, false, false, 3, '1993-03-03', 8),
       (false, true, false, 4, '1994-04-04', 9),
       (true, false, true, 5, '1995-05-05', 10);

