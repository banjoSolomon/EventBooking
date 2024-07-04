TRUNCATE TABLE event CASCADE;
TRUNCATE TABLE organizer CASCADE;


INSERT INTO event (id, name, description, event_date, start_time, location) VALUES
(10, 'Event 1', 'Description 1', '2024-07-13', '10:00:00', 'Location 1' ),
 (90, 'Event 2', 'Description 2', '2024-07-14', '11:00:00', 'Location 2'),
 (30, 'Event 3', 'Description 3', '2024-07-16', '12:00:00', 'Location 3');
INSERT INTO organizer (id, username, password, phone_number, email, date_registered) VALUES
 (6, 'user1', 'password1', '123456789', 'user1@example.com', '2024-01-01'),
 (9, 'user2', 'password2', '987654321', 'user2@example.com', '2024-01-02');

INSERT INTO ticket (id, price, category) VALUES
(5, '2000.0', 'VIP'),
(4, '2000.0', 'VIP'),
(7, '2000.0', 'VIP');
