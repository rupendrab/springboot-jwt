INSERT INTO auth.app_role (id, role_name, description) VALUES (1, 'STANDARD_USER', 'Standard User - Has no admin rights');
INSERT INTO auth.app_role (id, role_name, description) VALUES (2, 'ADMIN_USER', 'Admin User - Has permission to perform admin tasks');

-- USER
-- non-encrypted password: jwtpass
-- INSERT INTO app_user (id, first_name, last_name, password, username) VALUES (1, 'John', 'Doe', '821f498d827d4edad2ed0960408a98edceb661d9f34287ceda2962417881231a', 'john.doe');
INSERT INTO auth.app_user (id, first_name, last_name, password, username) VALUES (1, 'John', 'Doe', '$2a$10$J8LToGM/yoqQ7.pqCYH1COYmTz7YWAXpl1d43xbBvik.NnJAy4gAC', 'john.doe');
INSERT INTO auth.app_user (id, first_name, last_name, password, username) VALUES (2, 'Admin', 'Admin', '$2a$10$J8LToGM/yoqQ7.pqCYH1COYmTz7YWAXpl1d43xbBvik.NnJAy4gAC', 'admin.admin');


INSERT INTO auth.user_role(user_id, role_id) VALUES(1,1);
INSERT INTO auth.user_role(user_id, role_id) VALUES(2,1);
INSERT INTO auth.user_role(user_id, role_id) VALUES(2,2);

-- Populate random city table

INSERT INTO auth.random_city(id, name) VALUES (1, 'Bamako');
INSERT INTO auth.random_city(id, name) VALUES (2, 'Nonkon');
INSERT INTO auth.random_city(id, name) VALUES (3, 'Houston');
INSERT INTO auth.random_city(id, name) VALUES (4, 'Toronto');
INSERT INTO auth.random_city(id, name) VALUES (5, 'New York City');
INSERT INTO auth.random_city(id, name) VALUES (6, 'Mopti');
INSERT INTO auth.random_city(id, name) VALUES (7, 'Koulikoro');
INSERT INTO auth.random_city(id, name) VALUES (8, 'Moscow');
