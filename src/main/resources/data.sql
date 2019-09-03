
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
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');



INSERT INTO users (id, email, password, user_Name) VALUES
-- Admin pass
(1, 'admin@gmail.com', '$2a$10$hKDVYxLefVHV/vtuPhWD3OigtRyOykRLDdUAp80Z1crSoS1lFqaFS', 'Admin'),
-- User pass
(2, 'user@gmail.com', '$2a$10$Hl8T1EaJvjhSc.Uf0elKm./YDHX6pICAmX7k8E9y1DpFWbbUvyuN2', 'User');

-- INSERT INTO `playground` (`id`, `address`, `name`, `description`, `equipment_id`) VALUES
-- (NULL, '', 'Fort Stevenson State Park', 'State Park', NULL),
-- (NULL, '', 'Beaver Lake State Park', 'State Park', NULL),
-- (NULL, '', 'Fort Abraham Lincoln State Park', 'State Park', NULL),
-- (NULL, '', 'Fort Ransom State Park', 'State Park', NULL),
-- (NULL, '', 'Grahams Island State Park', 'State Park', NULL),
-- (NULL, '', 'Icelandic State Park', 'State Park', NULL),
-- (NULL, '', 'Lake Metigoshe State Park', 'State Park', NULL),
-- (NULL, '', 'Lewis and Clark State Park', 'State Park', NULL),
-- (NULL, '', 'Lewis and Clark Interpretive Center', 'Interpretive Center', NULL),
-- (NULL, '', 'Fort Mandan State Recreation Area', 'State Recreation Area', NULL),
-- (NULL, '', 'Little Missouri State Park', 'State Park', NULL),
-- (NULL, '', 'Sully Creek State Park', 'State Park', NULL),
-- (NULL, '', 'Butte St. Paul State Recreation Area', 'State Recreation Area', NULL),
-- (NULL, '', 'Crow Flies High State Recreation Area', 'State Recreation Area', NULL),
-- (NULL, '', 'Turtle River State Park', 'State Park', NULL),
-- (NULL, '', 'Lake Sakakawea State Park', 'State Park', NULL),
-- (NULL, '', 'Elkhorn State Natural Area', 'State Natural Area', NULL),
-- (NULL, '', 'Fahlgren Park State Recreation Area', 'State Recreation Area', NULL),
-- (NULL, '', 'Gunlogson State Nature Preserve', 'State Nature Preserve', NULL),
-- (NULL, '', 'Head of the Mountain State Nature Preserve', 'State Nature Preserve', NULL),
-- (NULL, '', 'Missouri River State Natural Area', 'State Natural Area', NULL),
-- (NULL, '', 'Pembina Gorge State Recreation Area', 'State Recreation Area', NULL),
-- (NULL, '', 'Turtle Mountain State Recreation Area', 'State Recreation Area', NULL),
-- (NULL, '', 'Cross Ranch State Park', 'State Park', NULL),
-- (NULL, '', 'Pelican Point State Recreation Area', 'State Recreation Area', NULL);


insert into user_role(user_id, role_id) values(1,1),
(1,1),
(1,2),
(2,2);

