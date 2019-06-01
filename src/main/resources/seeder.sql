USE sitter_gitter_db;


INSERT INTO users
  (username, email, password, first_name, last_name, street_addr, city, state, zip_code, is_babysitter) VALUES
  ('Dwight', 'dwight@sitter-gitter.com', '$2a$10$Vh/68GBeHSHiIgujx.zEzetpwORkBI0i7b9I43kyTIgP2JzTaz4Q2', 'Dwight', 'Bemisderfer', '600 Navarro St #350', 'San Antonio', 'TX', '78205', 0),
  ('Erik', 'erik@sitter-gitter.com', '$2a$10$Vh/68GBeHSHiIgujx.zEzetpwORkBI0i7b9I43kyTIgP2JzTaz4Q2', 'Erik','Behnke', '600 Navarro St #350', 'San Antonio', 'TX', '78205', 0),
  ('Mindy', 'mindy@sitter-gitter.com', '$2a$10$Vh/68GBeHSHiIgujx.zEzetpwORkBI0i7b9I43kyTIgP2JzTaz4Q2', 'Mindy', 'Tillman', '600 Navarro St #350', 'San Antonio', 'TX', '78205', 0),
  #         BABYSITTERS
  ('Alexis', 'alexis@sitter-gitter.com', '$2a$10$Vh/68GBeHSHiIgujx.zEzetpwORkBI0i7b9I43kyTIgP2JzTaz4Q2', 'Alexis', 'Sitter', '600 Navarro St #350', 'San Antonio', 'TX', '78205', 1),
  ('Bob', 'bob@sitter-gitter.com', '$2a$10$Vh/68GBeHSHiIgujx.zEzetpwORkBI0i7b9I43kyTIgP2JzTaz4Q2', 'Babysitter', 'Bob', '808 Bobert Blvd #13', 'San Antonio', 'TX', '78303', 1);


INSERT INTO children
  (name, birthdate, special_note, parent_id) VALUES
  #        DWIGHTS KIDS
  ('Erika', '2015-12-11', 'Erika really likes it when she\'s employed before bedtime.', (SELECT id FROM users WHERE email = 'dwight@sitter-gitter.com')),
  ('Mandy', '2017-07-05', 'Mandy likes drawing on the walls.', (SELECT id FROM users WHERE email = 'dwight@sitter-gitter.com')),
  #        ERIKS KIDS
  ('Charlie', '2018-03-09', 'Please give Charlie a bedtime story and a backrub to help her go to sleep.', (SELECT id FROM users WHERE email = 'erik@sitter-gitter.com')),
  ('Clarise', '2015-12-11', 'Keep Clarise away from the cat food!', (SELECT id FROM users WHERE email = 'erik@sitter-gitter.com')),
  #        MINDYS KIDS
  ('Cinthia', '2017-07-05', 'Please make sure Cinthia gets her Flinstone vitamins in the morning', (SELECT id FROM users WHERE email = 'mindy@codeup.com')),
  ('Cindy', '2018-03-09', 'Please give Cindy a bedtime story and a backrub to help her go to sleep.', (SELECT id FROM users WHERE email = 'mindy@sitter-gitter.com'));


INSERT INTO available_times
  (start, end, babysitter_id, is_taken) VALUES
  #        ALEXIS PAST
  ('2019-01-01 08:00:00', '2019-01-01 23:00:00', 4, 1),
  ('2019-02-02 08:00:00', '2019-02-02 23:00:00', 4, 1),
  ('2019-03-03 08:00:00', '2019-03-03 23:00:00', 4, 1),
  ('2019-04-04 08:00:00', '2019-04-04 23:00:00', 4, 1),
  #        BOB PAST
  ('2019-01-01 08:00:00', '2019-01-01 23:00:00', 5, 1),
  ('2019-02-02 08:00:00', '2019-02-02 23:00:00', 5, 1),
  ('2019-04-04 08:00:00', '2019-04-04 23:00:00', 5, 1),
  #        ALEXIS FUTURE
  ('2019-06-05 08:00:00', '2019-06-05 23:00:00', 4, 1),
  ('2019-06-06 08:00:00', '2019-06-06 23:00:00', 4, 1),
  ('2019-06-07 08:00:00', '2019-06-07 23:00:00', 4, 1),
  ('2019-06-08 08:00:00', '2019-06-08 23:00:00', 4, 0),

  #        BOB FUTURE
  ('2019-06-05 08:00:00', '2019-06-05 23:00:00', 5, 1),
  ('2019-06-06 08:00:00', '2019-06-06 23:00:00', 5, 1),
  ('2019-06-07 08:00:00', '2019-06-07 23:00:00', 5, 1),
  ('2019-06-08 08:00:00', '2019-06-08 23:00:00', 5, 0);


INSERT INTO appointments
  (start, end, sitter_approved, is_reviewed, babysitter_id, parent_id, available_time_id) VALUES
# ALEXIS
#   PAST NOT REVIEWED
  ('2019-01-01 11:00:00', '2019-02-02 20:00:00', 1, 0, 4, 1, 1),
#   PAST REVIEWED
  ('2019-02-02 11:00:00', '2019-03-03 20:00:00', 1, 1, 4, 3, 2),
  ('2019-03-03 11:00:00', '2019-04-04 20:00:00', 1, 1, 4, 2, 3),
  ('2019-04-04 11:00:00', '2019-05-05 20:00:00', 1, 1, 4, 1, 4),
#   FUTURE APPOINTMENTS
  ('2019-06-05 11:00:00', '2019-06-05 20:00:00', 1, 0, 4, 1, 8),
  ('2019-06-06 11:00:00', '2019-06-06 20:00:00', 1, 0, 4, 2, 9),
  ('2019-06-07 11:00:00', '2019-06-07 20:00:00', 1, 0, 4, 3, 10),
# BOB
#   PAST NOT REVIEWED
  ('2019-01-01 11:00:00', '2019-02-02 20:00:00', 1, 0, 5, 2, 5),
  ('2019-02-02 11:00:00', '2019-03-03 20:00:00', 1, 0, 5, 1, 6),
#   PAST REVIEWED
  ('2019-04-04 11:00:00', '2019-05-05 20:00:00', 1, 1, 5, 2, 7),
#   FUTURE APPOINTMENTS
  ('2019-06-05 11:00:00', '2019-06-05 20:00:00', 1, 0, 5, 3, 12),
  ('2019-06-06 11:00:00', '2019-06-06 20:00:00', 1, 0, 5, 1, 13),
  ('2019-06-07 11:00:00', '2019-06-07 20:00:00', 1, 0, 5, 1, 14);


INSERT INTO reviews
  (title, body, is_recommended, babysitter_id, parent_id, appointment_id) VALUES
  ('Unbelievable!', 'She had my kids folding laundry when I got home. So cool!!', 1, 4, 1, 4),
  ('Unbelieveable..', 'She had the nerve to tell my kids to fold laundry..', 0, 4, 2, 3),
  ('Worth every penny!', 'Gittin\' is a blast when Alexis is Sittin\'!', 1, 4, 3, 2),
  ('Alexis who!?', 'Babysitter Bob had my kids asleep a half our before bedtime! I\'m not sure where all my Benadryl went, though..', 1, 5, 2, 10);


INSERT INTO specifications
  (is_smoker, has_cpr_training, has_transportation, years_of_experience, birthdate, babysitter_id) VALUES
  (true, false, false, 7, '1991-01-01', 4),
  (false, true, true, 20, '1992-02-02', 5);