USE sitter_gitter_db;


INSERT INTO users (username, email, password, first_name, last_name, street_addr, city, state, zip_code,
                   is_babysitter)
VALUES ('Dwight', 'dwight@sitter-gitter.com', '$2a$10$Vh/68GBeHSHiIgujx.zEzetpwORkBI0i7b9I43kyTIgP2JzTaz4Q2', 'Dwight',
        'Bemisderfer', '600 Navarro St #350', 'San Antonio', 'TX', '78205', 0),
       ('Erik', 'erik@sitter-gitter.com', '$2a$10$Vh/68GBeHSHiIgujx.zEzetpwORkBI0i7b9I43kyTIgP2JzTaz4Q2', 'Erik',
        'Behnke',
        '600
       Navarro St #350', 'San Antonio', 'TX', '78205', 0),

       ('Mindy', 'mindy@sitter-gitter.com', '$2a$10$Vh/68GBeHSHiIgujx.zEzetpwORkBI0i7b9I43kyTIgP2JzTaz4Q2', 'Mindy',
        'Tillman', '600 Navarro St #350', 'San Antonio', 'TX', '78205', 0),

       ('Daniel', 'daniel@sitter-gitter.com', '$2a$10$Vh/68GBeHSHiIgujx.zEzetpwORkBI0i7b9I43kyTIgP2JzTaz4Q2',
        'Parent1',
        'Gitter', '600 Navarro St #1', 'San Antonio', 'TX', '78201', 0),

       ('Justin', 'justin@sitter-gitter.com', '$2a$10$Vh/68GBeHSHiIgujx.zEzetpwORkBI0i7b9I43kyTIgP2JzTaz4Q2',
        'Parent2',
        'Gitter', '600 Navarro St #2', 'San Antonio', 'TX', '78202', 0),

       ('Alexis', 'alexis@sitter-gitter.com', '$2a$10$Vh/68GBeHSHiIgujx.zEzetpwORkBI0i7b9I43kyTIgP2JzTaz4Q2',
        'Baby1', 'Sitter', '600 Navarro St #1', 'San Antonio', 'TX', '78201', 1),

       ('Barbara', 'barbara@sitter-gitter.com', '$2a$10$Vh/68GBeHSHiIgujx.zEzetpwORkBI0i7b9I43kyTIgP2JzTaz4Q2',
        'Baby2', 'Sitter', '600 Navarro St #2', 'San Antonio', 'TX', '78202', 1),

       ('Bob', 'bob@sitter-gitter.com', '$2a$10$Vh/68GBeHSHiIgujx.zEzetpwORkBI0i7b9I43kyTIgP2JzTaz4Q2',
        'Baby3', 'Sitter', '600 Navarro St #3', 'San Antonio', 'TX', '78203', 1),

       ('Beatrice', 'beatrice@sitter-gitter.com', '$2a$10$Vh/68GBeHSHiIgujx.zEzetpwORkBI0i7b9I43kyTIgP2JzTaz4Q2',
        'Baby4', 'Sitter', '600 Navarro St #4', 'San Antonio', 'TX', '78204', 1),

       ('Brenda', 'brenda@sitter-gitter.com', '$2a$10$Vh/68GBeHSHiIgujx.zEzetpwORkBI0i7b9I43kyTIgP2JzTaz4Q2',
        'Baby5', 'Sitter', '600 Navarro St #5', 'San Antonio', 'TX', '78205', 1);


INSERT INTO children (name, birthdate, special_note, parent_id)
VALUES
       ('Chris', '2015-12-11', 'Chris need to take a nap at 2pm.', (SELECT id FROM users WHERE email =
                                                                                            'dwight@sitter-gitter
       .com')),
       ('Cory', '2017-07-05', 'Cory likes warm milk before going to bed.', (SELECT id FROM users WHERE email =
                                                                                                           'dwight@sitter-gitter.com')),
       ('Charlie', '2018-03-09', 'Please give Charlie a bedtime story and a backrub to help her go to sleep.', (SELECT
                                                                                                                     id FROM users WHERE email = 'dwight@sitter-gitter.com')),
       ('Clarise', '2015-12-11', 'Keep Clarise away from the cat food!', (SELECT id FROM users WHERE email =
                                                                                              'erik@sitter-gitter.com')),
       ('Cinthia', '2017-07-05', 'Please make sure Cinthia gets her Flinstone vitamins in the morning', (SELECT id FROM
                                                                                                                   users WHERE
                                                                                                                  email =
                                                                                                           'erik@codeup
                                                                                                           .com')),
       ('Cindy', '2018-03-09', 'Please give Cindy a bedtime story and a backrub to help her go to sleep.', (SELECT
                                                                                                                     id FROM users WHERE email = 'erik@sitter-gitter.com')),
       ('Cleo', '2015-12-11', 'Keep Cleo away from the cat food!', (SELECT id FROM users WHERE email =
                                                                                             'mindy@sitter-gitter.com')),
       ('Carlo', '2017-07-05', 'Carlo likes warm milk before going to bed.', (SELECT id FROM users WHERE email =
                                                                                                           'mindy@codeup
                                                                                                           .com')),
       ('Carly', '2018-03-09', 'Please give Carly a bedtime story and a backrub to help her go to sleep.', (SELECT
                                                                                                                      id FROM users WHERE email = 'mindy@sitter-gitter.com')),
       ('Charlotte', '2015-12-11', 'Please make sure Charlotte gets her Flinstone vitamins in the morning', (SELECT id
       FROM users WHERE email = 'juston@sitter-gitter.com')),
       ('Chance', '2017-07-05', 'Chance likes warm milk before going to bed.', (SELECT id FROM users WHERE email =
                                                                                                           'daniel@codeup
                                                                                                           .com')),
       ('Chuck', '2018-03-09', 'Please give Chuck a bedtime story and a backrub to help her go to sleep.', (SELECT
                                                                                                                     id FROM users WHERE email = 'daniel@sitter-gitter.com')),
       ('Charles', '2015-12-11', 'Keep Charles away from the cat food!', (SELECT id FROM users WHERE email =
                                                                                               'justin@sitter-gitter
                                                                                               .com')),
       ('Cathy', '2017-07-05', 'Cathy likes warm milk before going to bed.', (SELECT id FROM users WHERE email =
                                                                                                           'daniel@codeup
                                                                                                           .com')),
       ('Cadence', '2018-03-09', 'Please give Cadence a bedtime story and a backrub to help her go to sleep.', (SELECT
                                                                                                                     id FROM users WHERE email = 'justin@sitter-gitter.com')),
       ('Caleb', '2015-12-11', 'Please make sure Caleb gets his Flinstone vitamins in the morning', (SELECT id FROM
                                                                                                                    users
       WHERE email = 'erik@sitter-gitter.com')),
       ('Connor', '2017-07-05', 'Connor likes warm milk before going to bed.', (SELECT id FROM users WHERE email =
                                                                                                           'mindy@codeup
                                                                                                           .com')),
       ('Chase', '2018-03-09', 'Please give Chase a bedtime story and a backrub to help her go to sleep.', (SELECT
                                                                                                                     id FROM users WHERE email = 'dwight@sitter-gitter.com'));



INSERT INTO available_times (start, end, babysitter_id, is_taken)
VALUES
       ('2019-05-31 08:00:00', '2019-05-31 23:00:00', 6, 0),
       ('2019-06-01 08:00:00', '2019-06-01 23:00:00', 6, 0),
       ('2019-06-02 08:00:00', '2019-06-02 23:00:00', 6, 0),
       ('2019-06-03 08:00:00', '2019-06-03 23:00:00', 6, 0),
       ('2019-06-04 08:00:00', '2019-06-04 23:00:00', 6, 0),
       ('2019-05-05 08:00:00', '2019-05-05 23:00:00', 6, 1),
       ('2019-02-06 08:00:00', '2019-02-06 23:00:00', 6, 1),
       ('2019-04-07 08:00:00', '2019-04-07 21:00:00', 6, 1),
       ('2019-06-08 08:00:00', '2019-06-08 23:00:00', 6, 0),
       ('2019-05-31 08:00:00', '2019-05-31 23:00:00', 7, 0),
       ('2019-06-01 08:00:00', '2019-06-01 23:00:00', 7, 0),
       ('2019-06-02 08:00:00', '2019-06-02 23:00:00', 7, 0),
       ('2019-06-03 08:00:00', '2019-06-03 23:00:00', 7, 0),
       ('2019-06-04 08:00:00', '2019-06-04 23:00:00', 7, 0),
       ('2019-06-05 08:00:00', '2019-06-05 23:00:00', 7, 1),
       ('2019-06-06 08:00:00', '2019-06-06 23:00:00', 7, 1),
       ('2019-06-07 08:00:00', '2019-06-07 21:00:00', 7, 1),
       ('2019-06-08 08:00:00', '2019-06-08 23:00:00', 7, 0),
       ('2019-05-31 08:00:00', '2019-05-31 23:00:00', 8, 0),
       ('2019-06-01 08:00:00', '2019-06-01 23:00:00', 8, 0),
       ('2019-06-02 08:00:00', '2019-06-02 23:00:00', 8, 0),
       ('2019-06-03 08:00:00', '2019-06-03 23:00:00', 8, 0),
       ('2019-06-04 08:00:00', '2019-06-04 23:00:00', 8, 0),
       ('2019-06-05 08:00:00', '2019-06-05 23:00:00', 8, 1),
       ('2019-06-06 08:00:00', '2019-06-06 23:00:00', 8, 1),
       ('2019-06-07 08:00:00', '2019-06-07 21:00:00', 8, 1),
       ('2019-06-08 08:00:00', '2019-06-08 23:00:00', 8, 0),
       ('2019-05-31 08:00:00', '2019-05-31 23:00:00', 9, 0),
       ('2019-06-01 08:00:00', '2019-06-01 23:00:00', 9, 0),
       ('2019-06-02 08:00:00', '2019-06-02 23:00:00', 9, 0),
       ('2019-06-03 08:00:00', '2019-06-03 23:00:00', 9, 0),
       ('2019-06-04 08:00:00', '2019-06-04 23:00:00', 9, 0),
       ('2019-06-05 08:00:00', '2019-06-05 23:00:00', 9, 1),
       ('2019-06-06 08:00:00', '2019-06-06 23:00:00', 9, 1),
       ('2019-06-07 08:00:00', '2019-06-07 21:00:00', 9, 1),
       ('2019-06-08 08:00:00', '2019-06-08 23:00:00', 9, 0),
       ('2019-05-31 08:00:00', '2019-05-31 23:00:00', 10, 0),
       ('2019-06-01 08:00:00', '2019-06-01 23:00:00', 10, 0),
       ('2019-06-02 08:00:00', '2019-06-02 23:00:00', 10, 0),
       ('2019-06-03 08:00:00', '2019-06-03 23:00:00', 6, 0),
       ('2019-06-04 08:00:00', '2019-06-04 23:00:00', 6, 0),
       ('2019-06-05 08:00:00', '2019-06-05 23:00:00', 10, 1),
       ('2019-06-06 08:00:00', '2019-06-06 23:00:00', 10, 1),
       ('2019-06-07 08:00:00', '2019-06-07 21:00:00', 10, 1),
       ('2019-06-08 08:00:00', '2019-06-08 23:00:00', 10, 0);



INSERT INTO appointments (start, end, sitter_approved, is_reviewed, babysitter_id, parent_id, available_time_id)
VALUES ('2019-05-05 11:00:00', '2019-05-05 20:00:00', 1, 0, 6, 1, 6),
       ('2019-02-06 11:00:00', '2019-02-06 20:00:00', 1, 0, 6, 1, 7),
       ('2019-04-07 11:00:00', '2019-04-07 20:00:00', 1, 0, 6, 1, 8),
       ('2019-06-05 11:00:00', '2019-06-05 20:00:00', 1, 1, 7, 2, 17),
       ('2019-06-06 11:00:00', '2019-06-06 20:00:00', 1, 1, 7, 2, 18),
       ('2019-06-07 11:00:00', '2019-06-07 20:00:00', 1, 1, 7, 2, 19),
       ('2019-06-05 11:00:00', '2019-06-05 20:00:00', 1, 1, 8, 3, 28),
       ('2019-06-06 11:00:00', '2019-06-06 20:00:00', 1, 1, 8, 3, 29),
       ('2019-06-07 11:00:00', '2019-06-07 20:00:00', 1, 1, 8, 3, 30),
       ('2019-06-05 11:00:00', '2019-06-05 20:00:00', 1, 1, 6, 1, 39),
       ('2019-06-06 11:00:00', '2019-06-06 20:00:00', 1, 1, 6, 1, 40),
       ('2019-06-07 11:00:00', '2019-06-07 20:00:00', 1, 0, 6, 1, 41);
#        ('2019-06-05 11:00:00', '2019-06-05 20:00:00', 1, 1, 10, 5, 51),
#        ('2019-06-06 11:00:00', '2019-06-06 20:00:00', 1, 1, 10, 5, 52),
#        ('2019-06-07 11:00:00', '2019-06-07 20:00:00', 1, 0, 10, 5, 53);


INSERT INTO reviews (title, body, is_recommended, babysitter_id, parent_id, appointment_id)
VALUES ('Highly Recommended!', 'Everybody in the city should hire this babysitter. She\'s just that good.', 1, 6, 1, 1),
       ('Don\'t waste your money, people!', 'This babysitter spilled a bag of potato chips on our couch and didn\'t
       even bother to clean up the mess. Horrid!', 0, 6, 1, 2),
       ('Highly Recommended!', 'Everybody in the city should hire this babysitter. She\'s just that good.', 1, 6, 1, 3),
       ('Don\'t waste your money, people!', 'This babysitter spilled a bag of potato chips on our couch and didn\'t
       even bother to clean up the mess. Horrid!', 0, 7, 2, 4),
       ('Highly Recommended!', 'Everybody in the city should hire this babysitter. She\'s just that good.', 1, 7, 2, 5),
       ('Don\'t waste your money, people!', 'This babysitter spilled a bag of potato chips on our couch and didn\'t
       even bother to clean up the mess. Horrid!', 0, 7, 2, 6),
       ('Highly Recommended!', 'Everybody in the city should hire this babysitter. She\'s just that good.', 1, 8, 3, 7),
       ('Don\'t waste your money, people!', 'This babysitter spilled a bag of potato chips on our couch and didn\'t
       even bother to clean up the mess. Horrid!', 0, 8, 3, 8),
       ('Highly Recommended!', 'Everybody in the city should hire this babysitter. She\'s just that good.', 1, 8, 3,
        9),
       ('Don\'t waste your money, people!', 'This babysitter spilled a bag of potato chips on our couch and didn\'t
       even bother to clean up the mess. Horrid!', 0, 9, 4, 10);


INSERT INTO specifications (is_smoker, has_cpr_training, has_transportation, years_of_experience, birthdate, babysitter_id)
VALUES (false, false, false, 1, '1991-01-01', 6),
       (false, false, false, 2, '1992-02-02', 7),
       (false, false, false, 3, '1993-03-03', 8),
       (false, false, false, 4, '1994-04-04', 9),
       (false, false, false, 5, '1995-05-05', 10);