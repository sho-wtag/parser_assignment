CREATE DATABASE access_parser;
USE access_parser;

DROP TABLE IF EXISTS `log_entries`;

CREATE TABLE `log_entries` (
`id` bigint(20) NOT NULL,
`log_date` datetime DEFAULT NULL,
`log_ip` varchar(255) DEFAULT NULL,
`log_request` varchar(255) DEFAULT NULL,
`log_status` int(11) NOT NULL,
`log_user_agent` varchar(255) DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `log_entries_blocked`;

CREATE TABLE `log_entries_blocked` (
`id` bigint(20) NOT NULL,
`log_ip` varchar(255) DEFAULT NULL,
`log_message` varchar(255) DEFAULT NULL,
`log_request` varchar(255) DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;