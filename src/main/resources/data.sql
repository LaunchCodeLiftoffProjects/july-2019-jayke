
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
(3,1),
(3,2);

--**************INSERT INTO**************

INSERT INTO `playground` (`id`, `address`, `description`, `name`, `water_feature`, `accessibility_id`, `amenities_id`, `equipment_id`, `shelters_id`, `special_needs_id`) VALUES
(7, '3824 Dunnica Ave, Saint Louis, MO 63116, United States', 'A playground.', 'Amberg Playground', b'0', 8, 9, 10, 11, 12),
(13, 'Amherst Park, 1200-50 Hodiamont Ave, Saint Louis, MO 63112, United States', 'A playground.', 'Amherst Playground', b'0', 14, 15, 16, 17, 18),
(19, '2901 Goodfellow Blvd, Saint Louis, MO 63120, United States', 'A playground.', 'Barrett Brothers Playground', b'0', 20, 21, 22, 23, 24),
(25, '4444 Page Blvd, Saint Louis, MO 63113, United States', 'A playground', 'Beckett Playground ', b'0', 26, 27, 28, 29, 30),
(31, '5570 S Broadway, Saint Louis, MO 63111, United States', 'A playground.', 'Bellerive Park Playground', b'0', 32, 33, 34, 35, 36),
(37, '3100 S Jefferson Ave, Saint Louis, MO 63118, United States', 'A playground.', 'Benton Park Playground', b'0', 85, 86, 87, 88, 89),
(43, '5400 Shaw Ave, Saint Louis, MO 63110, United States', 'A playground.', 'Berra Park Playground', b'0', 44, 45, 46, 47, 48),
(49, '2800-98 Hickory St, Saint Louis, MO 63104, United States', 'A playground.', 'Buder Park Playground', b'0', 50, 51, 52, 53, 54),
(55, '301-399 Davis St, St. Louis, MO 63111, United States', 'A playground.', 'Carondelet Lions Playground', b'0', 56, 57, 58, 59, 60),
(61, '3900 Holly Hills Blvd, Saint Louis, MO 63116, United States', 'A playground.', 'Carondelet Park Playground', b'0', 62, 63, 64, 65, 66),
(67, '3103-55 Bell Ave, Saint Louis, MO 63106, United States', 'A playground.', 'Chambers Park Playground', b'0', 68, 69, 70, 71, 72),
(73, '3200 Lemp Ave, Saint Louis, MO 63118, United States', 'A playground.', 'Cherokee Park Playground', b'0', 74, 75, 76, 77, 78),
(79, '5151 Christy Blvd, Saint Louis, MO 63116, United States', 'A playground', 'Christy Park Playground', b'0', 80, 81, 82, 83, 84),
(90, 'Clifton Park, 6100 Simpson Ave, Saint Louis, MO 63139, United States', 'A playground.', 'Clifton Heights Playground', b'0', 91, 92, 93, 94, 95),
(96, '2700-2730 Eads Ave, St. Louis, MO 63104', 'A playground.', 'Eads Park Playground', b'0', 97, 98, 99, 100, 101),
(102, 'Fairgrounds Park, 3715 Natural Bridge Ave, Saint Louis, MO 63107, United States', 'A playground.', 'Fairground Park Playground', b'0', 103, 104, 105, 106, 107),
(108, '5595 Grand Dr  Saint Louis, MO 63112, United States', 'A playground.', 'Forest Park Playgrounds', b'0', 109, 110, 111, 112, 113),
(114, '2751 Victor St, Saint Louis, MO 63104, United States', 'A playground.', 'Fox Park Playground', b'0', 115, 116, 117, 118, 119),
(120, '5399 Donovan Ave, Saint Louis, MO 63109, United States', 'A playground.', 'Francis Park Playground', b'0', 121, 122, 123, 124, 125),
(126, '6748 Mitchell Ave, Saint Louis, MO 63139, United States', 'A playground.', 'Franz Park Playground', b'0', 127, 128, 129, 130, 131),
(132, '2840 Wisconsin Ave Saint Louis, MO 63118', 'A playground located right by St. Agnes Apartments.', 'Fremont Park Playground', b'0', 133, 134, 135, 136, 137),
(138, '3200 Potomac St, Saint Louis, MO 63118, United States', 'A playground.', 'Gravios Park Playground', b'0', 139, 140, 141, 142, 143),
(144, '1300 Pine St, Saint Louis, MO 63103, United States', 'A playground.', 'Greg Freeman Playground', b'0', 145, 146, 147, 148, 149),
(150, '5800 Lilian Ave, St. Louis, MO 63120', 'A playground.', 'Gregory J. Carter Playground', b'0', 151, 152, 153, 154, 155),
(156, '924 Hodiamont Ave St. Louis, MO 63112', 'A playground.', 'Gwen Giles Playground', b'0', 157, 158, 159, 160, 161),
(162, '4821 Ashland Ave, Saint Louis, MO 63115, United States', 'A playground.', 'Handy Park Playground', b'0', 163, 164, 165, 166, 167);

-- --------------------------------------------------------

INSERT INTO `accessibility` (`id`, `parking_lot`, `trail`) VALUES
(8, b'0', b'0'),
(14, b'0', b'0'),
(20, b'0', b'0'),
(26, b'0', b'0'),
(32, b'0', b'0'),
(38, b'0', b'0'),
(44, b'0', b'0'),
(50, b'0', b'0'),
(56, b'0', b'0'),
(62, b'0', b'0'),
(68, b'0', b'0'),
(74, b'0', b'0'),
(80, b'0', b'0'),
(85, b'0', b'0'),
(91, b'0', b'0'),
(97, b'0', b'0'),
(103, b'0', b'0'),
(109, b'0', b'0'),
(115, b'0', b'0'),
(121, b'0', b'0'),
(127, b'0', b'0'),
(133, b'0', b'0'),
(139, b'0', b'0'),
(145, b'0', b'0'),
(151, b'0', b'0'),
(157, b'0', b'0'),
(163, b'0', b'0');

-- --------------------------------------------------------

INSERT INTO `amenities` (`id`, `restroom_changing_station`, `water_fountain`) VALUES
(9, b'0', b'0'),
(15, b'0', b'0'),
(21, b'0', b'0'),
(27, b'0', b'0'),
(33, b'0', b'0'),
(39, b'0', b'0'),
(45, b'0', b'0'),
(51, b'0', b'0'),
(57, b'0', b'0'),
(63, b'0', b'0'),
(69, b'0', b'0'),
(75, b'0', b'0'),
(81, b'0', b'0'),
(86, b'0', b'0'),
(92, b'0', b'0'),
(98, b'0', b'0'),
(104, b'0', b'0'),
(110, b'0', b'0'),
(116, b'0', b'0'),
(122, b'0', b'0'),
(128, b'0', b'0'),
(134, b'0', b'0'),
(140, b'0', b'0'),
(146, b'0', b'0'),
(152, b'0', b'0'),
(158, b'0', b'0'),
(164, b'0', b'0');

-- --------------------------------------------------------

INSERT INTO `equipment` (`id`, `climbing_walls`, `ladders`, `seesaw`, `slides`, `structures`, `swings`) VALUES
(10, b'0', b'0', b'0', b'0', b'0', b'0'),
(16, b'0', b'0', b'0', b'0', b'0', b'0'),
(22, b'0', b'0', b'0', b'0', b'0', b'0'),
(28, b'0', b'0', b'0', b'0', b'0', b'0'),
(34, b'0', b'0', b'0', b'0', b'0', b'0'),
(40, b'0', b'0', b'0', b'0', b'0', b'0'),
(46, b'0', b'0', b'0', b'0', b'0', b'0'),
(52, b'0', b'0', b'0', b'0', b'0', b'0'),
(58, b'0', b'0', b'0', b'0', b'0', b'0'),
(64, b'0', b'0', b'0', b'0', b'0', b'0'),
(70, b'0', b'0', b'0', b'0', b'0', b'0'),
(76, b'0', b'0', b'0', b'0', b'0', b'0'),
(82, b'0', b'0', b'0', b'0', b'0', b'0'),
(87, b'0', b'0', b'0', b'0', b'0', b'0'),
(93, b'0', b'0', b'0', b'0', b'0', b'0'),
(99, b'0', b'0', b'0', b'0', b'0', b'0'),
(105, b'0', b'0', b'0', b'0', b'0', b'0'),
(111, b'0', b'0', b'0', b'0', b'0', b'0'),
(117, b'0', b'0', b'0', b'0', b'0', b'0'),
(123, b'0', b'0', b'0', b'0', b'0', b'0'),
(129, b'0', b'0', b'0', b'0', b'0', b'0'),
(135, b'0', b'0', b'0', b'0', b'0', b'0'),
(141, b'0', b'0', b'0', b'0', b'0', b'0'),
(147, b'0', b'0', b'0', b'0', b'0', b'0'),
(153, b'0', b'0', b'0', b'0', b'0', b'0'),
(159, b'0', b'0', b'0', b'0', b'0', b'0'),
(165, b'0', b'0', b'0', b'0', b'0', b'0');

-- --------------------------------------------------------

INSERT INTO `shelters` (`id`, `benches`, `pavillion`) VALUES
(11, b'0', b'0'),
(17, b'0', b'0'),
(23, b'0', b'0'),
(29, b'0', b'0'),
(35, b'0', b'0'),
(41, b'0', b'0'),
(47, b'0', b'0'),
(53, b'0', b'0'),
(59, b'0', b'0'),
(65, b'0', b'0'),
(71, b'0', b'0'),
(77, b'0', b'0'),
(83, b'0', b'0'),
(88, b'0', b'0'),
(94, b'0', b'0'),
(100, b'0', b'0'),
(106, b'0', b'0'),
(112, b'0', b'0'),
(118, b'0', b'0'),
(124, b'0', b'0'),
(130, b'0', b'0'),
(136, b'0', b'0'),
(142, b'0', b'0'),
(148, b'0', b'0'),
(154, b'0', b'0'),
(160, b'0', b'0'),
(166, b'0', b'0');

-- --------------------------------------------------------

INSERT INTO `special_needs` (`id`, `sensory`, `wheelchair_accessible`) VALUES
(12, b'0', b'0'),
(18, b'0', b'0'),
(24, b'0', b'0'),
(30, b'0', b'0'),
(36, b'0', b'0'),
(42, b'0', b'0'),
(48, b'0', b'0'),
(54, b'0', b'0'),
(60, b'0', b'0'),
(66, b'0', b'0'),
(72, b'0', b'0'),
(78, b'0', b'0'),
(84, b'0', b'0'),
(89, b'0', b'0'),
(95, b'0', b'0'),
(101, b'0', b'0'),
(107, b'0', b'0'),
(113, b'0', b'0'),
(119, b'0', b'0'),
(125, b'0', b'0'),
(131, b'0', b'0'),
(137, b'0', b'0'),
(143, b'0', b'0'),
(149, b'0', b'0'),
(155, b'0', b'0'),
(161, b'0', b'0'),
(167, b'0', b'0');

-- --------------------------------------------------------