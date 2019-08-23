
create table if not exists persistent_logins (
  username varchar(100) not null,
  series varchar(64) primary key,
  token varchar(64) not null,
  last_used timestamp not null
);

delete from  user_role;
delete from  roles;
delete from  users;


INSERT INTO roles (id, name) VALUES
(1, 'ROLE_ADMIN');


INSERT INTO users (id, email, password, user_Name) VALUES
(9999, 'admin@gmail.com', '$2a$10$hKDVYxLefVHV/vtuPhWD3OigtRyOykRLDdUAp80Z1crSoS1lFqaFS', 'Admin'),
(9998, 'admin2@gmail.com', '$2a$10$R27tQeNfxMi7h1VlreTWAexexoOby5N6ouBEy5rw.UeqG6gKfTzXe', 'User');


insert into user_role(user_id, role_id) values
(1,1),
(2,1)
;
