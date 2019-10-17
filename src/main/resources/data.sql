
create table if not exists persistent_logins (
  username varchar(100) not null,
  series varchar(64) primary key,
  token varchar(64) not null,
  last_used timestamp not null
);

delete from  user_role;
delete from  roles;
delete from  users;

--**************delete from**************

delete from playground;
delete from accessibility;
delete from amenities;
delete from equipment;
delete from shelters;
delete from special_needs;


INSERT INTO roles (id, name) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');



INSERT INTO users (id, email, password, user_Name) VALUES
-- Admin pass
(1, 'admin@gmail.com', '$2a$10$hKDVYxLefVHV/vtuPhWD3OigtRyOykRLDdUAp80Z1crSoS1lFqaFS', 'Admin'),
-- User pass
(2, 'user@gmail.com', '$2a$10$Hl8T1EaJvjhSc.Uf0elKm./YDHX6pICAmX7k8E9y1DpFWbbUvyuN2', 'User'),
(3, 'blap@blap.com', '$2a$10$D.GWCGeUwkkvQPyngfTvl.BmniTd8eDNs.6gbIn7vH2iF4Y/xCR6O', 'blap');

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


insert into user_role(user_id, role_id) values
(1,1),
(1,2),
(2,2),
(3,2);

--**************INSERT INTO**************

INSERT INTO `playground` (`id`, `address`, `description`, `name`, `water_feature`, `accessibility_id`, `amenities_id`, `equipment_id`, `shelters_id`, `special_needs_id`) VALUES
(4, '123 WHATEVER STREET', 'Example description', 'Example Playground', b'1', 5, 6, 7, 8, 9);

-- --------------------------------------------------------

INSERT INTO `accessibility` (`id`, `parking_lot`, `trail`) VALUES
(5, b'0', b'1');

-- --------------------------------------------------------

INSERT INTO `amenities` (`id`, `restroom_changing_station`, `water_fountain`) VALUES
(6, b'1', b'0');

-- --------------------------------------------------------

INSERT INTO `equipment` (`id`, `climbing_walls`, `ladders`, `seesaw`, `slides`, `structures`, `swings`) VALUES
(7, b'0', b'0', b'0', b'1', b'1', b'1');

-- --------------------------------------------------------

INSERT INTO `shelters` (`id`, `benches`, `pavillion`) VALUES
(8, b'1', b'0');

-- --------------------------------------------------------

INSERT INTO `special_needs` (`id`, `sensory`, `wheelchair_accessible`) VALUES
(9, b'0', b'1');

-- --------------------------------------------------------