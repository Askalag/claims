CREATE SCHEMA public AUTHORIZATION postgres;

CREATE TABLE public.users (
    id bigserial NOT NULL,
    email varchar(50) NULL UNIQUE,
    name varchar(50) NULL,
    password varchar(100) NULL,
    username varchar(50) NOT NULL UNIQUE ,
    CONSTRAINT users_pkey PRIMARY KEY (id)
);

CREATE TABLE public.roles (
    id int8 NOT NULL,
    name varchar(255) NOT NULL ,
    CONSTRAINT roles_pkey PRIMARY KEY (id)
);

CREATE TABLE public.user_roles (
    user_id int8 NOT NULL,
    role_id int8 NOT NULL,
    FOREIGN KEY (role_id) REFERENCES roles(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- username: "user", password: "user"
-- username: "admin", password: "admin"
INSERT INTO public.users (id, email, name, password, username)
VALUES (1, 'user@email.com', 'clams', '$2a$10$PydxIwCg1phfjJtXMPvd8uxU6sotqLDbFHjkaFjGccFuGEIp9pyAO', 'user'),
       (2, 'admin@email.com', 'simpleAdmin', '$2a$10$d5.ow1eWAkFnSGMPcDTWAe.EqKcJbjtDe04g/gKBtqrznSt7myHrC', 'admin');

-- Insert 2 roles
INSERT INTO public.roles (id, name)
VALUES (1, 'ROLE_USER'),
       (2, 'ROLE_ADMIN');

-- Insert ref roles for admin and user
INSERT INTO public.user_roles (user_id, role_id)
VALUES (1, 1),
       (2, 1),
       (2, 2);
