/*
Navicat MySQL Data Transfer

Source Server         : limk
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : heterogeneousnetwork

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-03-22 21:25:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for lora_data
-- ----------------------------
DROP TABLE IF EXISTS `lora_data`;
CREATE TABLE `lora_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `snr` double(255,0) NOT NULL,
  `rssi` double(255,0) NOT NULL,
  `msg` varchar(255) COLLATE utf8_bin NOT NULL,
  `terminalId` int(11) NOT NULL,
  `time` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  KEY `pk_terminal` (`terminalId`),
  CONSTRAINT `pk_terminal` FOREIGN KEY (`terminalId`) REFERENCES `lora_terminal` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=243 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of lora_data
-- ----------------------------
INSERT INTO `lora_data` VALUES ('207', '7', '-22', 'Hello', '1', '2019-03-21 20:13:28');
INSERT INTO `lora_data` VALUES ('208', '7', '-23', 'Hello', '1', '2019-03-21 20:15:17');
INSERT INTO `lora_data` VALUES ('209', '7', '-24', 'Hello', '1', '2019-03-21 20:16:41');
INSERT INTO `lora_data` VALUES ('210', '8', '-26', 'Hello', '1', '2019-03-21 20:17:05');
INSERT INTO `lora_data` VALUES ('211', '8', '-27', 'Hello', '1', '2019-03-21 20:17:11');
INSERT INTO `lora_data` VALUES ('212', '8', '-23', 'Hello', '1', '2019-03-21 20:17:23');
INSERT INTO `lora_data` VALUES ('213', '7', '-25', 'Hello', '1', '2019-03-21 20:17:29');
INSERT INTO `lora_data` VALUES ('214', '7', '-29', 'Hello', '1', '2019-03-21 20:17:50');
INSERT INTO `lora_data` VALUES ('215', '7', '-22', 'Hello', '1', '2019-03-21 20:18:08');
INSERT INTO `lora_data` VALUES ('216', '7', '-23', 'Hello', '1', '2019-03-21 20:18:20');
INSERT INTO `lora_data` VALUES ('217', '7', '-25', 'Hello', '1', '2019-03-21 20:18:26');
INSERT INTO `lora_data` VALUES ('218', '6', '-45', 'Hello', '1', '2019-03-21 20:18:38');
INSERT INTO `lora_data` VALUES ('219', '8', '-23', 'Hello', '1', '2019-03-21 20:18:50');
INSERT INTO `lora_data` VALUES ('220', '8', '-33', 'Hello', '1', '2019-03-21 20:19:08');
INSERT INTO `lora_data` VALUES ('221', '7', '-22', 'Hello', '1', '2019-03-21 20:19:14');
INSERT INTO `lora_data` VALUES ('222', '7', '-35', 'Hello', '1', '2019-03-21 20:19:20');
INSERT INTO `lora_data` VALUES ('223', '8', '-26', 'Hello', '1', '2019-03-21 20:19:26');
INSERT INTO `lora_data` VALUES ('224', '8', '-27', 'Hello', '1', '2019-03-21 20:19:32');
INSERT INTO `lora_data` VALUES ('225', '7', '-23', 'Hello', '1', '2019-03-21 20:22:25');
INSERT INTO `lora_data` VALUES ('226', '8', '-34', 'Hello', '1', '2019-03-21 20:22:30');
INSERT INTO `lora_data` VALUES ('227', '7', '-20', 'Hello', '1', '2019-03-21 20:22:42');
INSERT INTO `lora_data` VALUES ('228', '7', '-18', 'Hello', '1', '2019-03-21 20:22:48');
INSERT INTO `lora_data` VALUES ('229', '6', '-41', 'Hello', '1', '2019-03-21 20:23:00');
INSERT INTO `lora_data` VALUES ('230', '7', '-32', 'Hello', '1', '2019-03-21 21:22:53');
INSERT INTO `lora_data` VALUES ('231', '7', '-25', 'Hello', '1', '2019-03-21 21:23:46');
INSERT INTO `lora_data` VALUES ('232', '7', '-22', 'Hello', '1', '2019-03-21 21:35:29');
INSERT INTO `lora_data` VALUES ('233', '7', '-32', 'Hello', '1', '2019-03-21 21:35:35');
INSERT INTO `lora_data` VALUES ('234', '8', '-24', 'Hello', '1', '2019-03-21 21:35:41');
INSERT INTO `lora_data` VALUES ('235', '7', '-29', 'Hello', '1', '2019-03-21 21:35:47');
INSERT INTO `lora_data` VALUES ('236', '7', '-31', 'Hello', '1', '2019-03-21 21:35:53');
INSERT INTO `lora_data` VALUES ('237', '7', '-31', 'Hello', '1', '2019-03-21 21:35:59');
INSERT INTO `lora_data` VALUES ('238', '7', '-32', 'Hello', '1', '2019-03-21 21:36:05');
INSERT INTO `lora_data` VALUES ('239', '7', '-31', 'Hello', '1', '2019-03-21 21:36:11');
INSERT INTO `lora_data` VALUES ('240', '7', '-20', 'Hello', '1', '2019-03-21 21:36:17');
INSERT INTO `lora_data` VALUES ('241', '7', '-31', 'Hello', '1', '2019-03-21 21:36:23');
INSERT INTO `lora_data` VALUES ('242', '7', '-22', 'Hello', '1', '2019-03-21 21:36:29');

-- ----------------------------
-- Table structure for lora_station
-- ----------------------------
DROP TABLE IF EXISTS `lora_station`;
CREATE TABLE `lora_station` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `x` double NOT NULL,
  `y` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of lora_station
-- ----------------------------
INSERT INTO `lora_station` VALUES ('1', '11', '5');

-- ----------------------------
-- Table structure for lora_terminal
-- ----------------------------
DROP TABLE IF EXISTS `lora_terminal`;
CREATE TABLE `lora_terminal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stationId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `pk_station` (`stationId`),
  CONSTRAINT `pk_station` FOREIGN KEY (`stationId`) REFERENCES `lora_station` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of lora_terminal
-- ----------------------------
INSERT INTO `lora_terminal` VALUES ('1', '1');

-- ----------------------------
-- Table structure for sensor_data
-- ----------------------------
DROP TABLE IF EXISTS `sensor_data`;
CREATE TABLE `sensor_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sensor_id` varchar(255) COLLATE utf8_bin NOT NULL,
  `data` varchar(255) COLLATE utf8_bin NOT NULL,
  `time` varchar(255) COLLATE utf8_bin NOT NULL,
  `rssi` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  KEY `pk_sensor` (`sensor_id`),
  CONSTRAINT `pk_sensor` FOREIGN KEY (`sensor_id`) REFERENCES `sensor_station` (`sensor_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1013 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of sensor_data
-- ----------------------------
INSERT INTO `sensor_data` VALUES ('377', 'BB11', '323', '2019-03-22 18:16:27', '16');
INSERT INTO `sensor_data` VALUES ('379', 'BB11', '323', '2019-03-22 18:16:27', '15');
INSERT INTO `sensor_data` VALUES ('381', 'BB11', '323', '2019-03-22 18:16:29', '16');
INSERT INTO `sensor_data` VALUES ('383', 'BB11', '323', '2019-03-22 18:16:31', '16');
INSERT INTO `sensor_data` VALUES ('385', 'BB11', '323', '2019-03-22 18:16:35', '16');
INSERT INTO `sensor_data` VALUES ('387', 'BB11', '323', '2019-03-22 18:16:35', '17');
INSERT INTO `sensor_data` VALUES ('389', 'BB11', '323', '2019-03-22 18:16:37', '27');
INSERT INTO `sensor_data` VALUES ('391', 'BB11', '323', '2019-03-22 18:16:42', '28');
INSERT INTO `sensor_data` VALUES ('393', 'BB11', '323', '2019-03-22 18:16:42', '28');
INSERT INTO `sensor_data` VALUES ('395', 'BB11', '323', '2019-03-22 18:16:44', '28');
INSERT INTO `sensor_data` VALUES ('397', 'BB11', '323', '2019-03-22 18:16:46', '28');
INSERT INTO `sensor_data` VALUES ('399', 'BB11', '323', '2019-03-22 18:16:50', '28');
INSERT INTO `sensor_data` VALUES ('401', 'BB11', '323', '2019-03-22 18:16:50', '28');
INSERT INTO `sensor_data` VALUES ('403', 'BB11', '323', '2019-03-22 18:16:52', '28');
INSERT INTO `sensor_data` VALUES ('405', 'BB11', '323', '2019-03-22 18:16:57', '28');
INSERT INTO `sensor_data` VALUES ('407', 'BB11', '323', '2019-03-22 18:16:57', '28');
INSERT INTO `sensor_data` VALUES ('409', 'BB11', '323', '2019-03-22 18:16:58', '28');
INSERT INTO `sensor_data` VALUES ('411', 'BB11', '323', '2019-03-22 18:17:00', '39');
INSERT INTO `sensor_data` VALUES ('413', 'BB11', '323', '2019-03-22 18:17:04', '32');
INSERT INTO `sensor_data` VALUES ('415', 'BB11', '323', '2019-03-22 18:17:04', '31');
INSERT INTO `sensor_data` VALUES ('417', 'BB11', '323', '2019-03-22 18:17:06', '35');
INSERT INTO `sensor_data` VALUES ('419', 'BB11', '323', '2019-03-22 18:17:12', '33');
INSERT INTO `sensor_data` VALUES ('421', 'BB11', '323', '2019-03-22 18:17:12', '35');
INSERT INTO `sensor_data` VALUES ('423', 'BB11', '323', '2019-03-22 18:17:13', '33');
INSERT INTO `sensor_data` VALUES ('425', 'BB11', '323', '2019-03-22 18:17:15', '36');
INSERT INTO `sensor_data` VALUES ('427', 'BB11', '323', '2019-03-22 18:17:21', '36');
INSERT INTO `sensor_data` VALUES ('429', 'BB11', '323', '2019-03-22 18:17:21', '38');
INSERT INTO `sensor_data` VALUES ('431', 'BB11', '323', '2019-03-22 18:17:21', '36');
INSERT INTO `sensor_data` VALUES ('433', 'BB11', '323', '2019-03-22 18:17:24', '36');
INSERT INTO `sensor_data` VALUES ('435', 'BB11', '323', '2019-03-22 18:17:30', '36');
INSERT INTO `sensor_data` VALUES ('437', 'BB11', '323', '2019-03-22 18:17:30', '38');
INSERT INTO `sensor_data` VALUES ('439', 'BB11', '323', '2019-03-22 18:17:30', '42');
INSERT INTO `sensor_data` VALUES ('441', 'BB11', '323', '2019-03-22 18:17:36', '38');
INSERT INTO `sensor_data` VALUES ('443', 'BB11', '323', '2019-03-22 18:17:36', '39');
INSERT INTO `sensor_data` VALUES ('445', 'BB11', '323', '2019-03-22 18:17:36', '38');
INSERT INTO `sensor_data` VALUES ('447', 'BB11', '323', '2019-03-22 18:17:38', '38');
INSERT INTO `sensor_data` VALUES ('449', 'BB11', '323', '2019-03-22 18:17:44', '41');
INSERT INTO `sensor_data` VALUES ('451', 'BB11', '323', '2019-03-22 18:17:44', '42');
INSERT INTO `sensor_data` VALUES ('453', 'BB11', '323', '2019-03-22 18:17:45', '42');
INSERT INTO `sensor_data` VALUES ('455', 'BB11', '323', '2019-03-22 18:17:47', '42');
INSERT INTO `sensor_data` VALUES ('457', 'BB11', '323', '2019-03-22 18:17:53', '42');
INSERT INTO `sensor_data` VALUES ('459', 'BB11', '323', '2019-03-22 18:17:53', '35');
INSERT INTO `sensor_data` VALUES ('460', 'BB11', '323', '2019-03-22 18:17:53', '35');
INSERT INTO `sensor_data` VALUES ('461', 'BB11', '323', '2019-03-22 18:17:56', '35');
INSERT INTO `sensor_data` VALUES ('462', 'BB11', '323', '2019-03-22 18:17:58', '35');
INSERT INTO `sensor_data` VALUES ('463', 'BB11', '323', '2019-03-22 18:18:02', '35');
INSERT INTO `sensor_data` VALUES ('464', 'BB11', '323', '2019-03-22 18:18:02', '35');
INSERT INTO `sensor_data` VALUES ('465', 'BB11', '323', '2019-03-22 18:18:04', '35');
INSERT INTO `sensor_data` VALUES ('466', 'BB11', '323', '2019-03-22 18:18:06', '35');
INSERT INTO `sensor_data` VALUES ('467', 'BB11', '323', '2019-03-22 18:18:11', '35');
INSERT INTO `sensor_data` VALUES ('468', 'BB11', '323', '2019-03-22 18:18:11', '35');
INSERT INTO `sensor_data` VALUES ('469', 'BB11', '323', '2019-03-22 18:18:13', '35');
INSERT INTO `sensor_data` VALUES ('470', 'BB11', '323', '2019-03-22 18:18:15', '35');
INSERT INTO `sensor_data` VALUES ('471', 'BB11', '323', '2019-03-22 18:18:19', '35');
INSERT INTO `sensor_data` VALUES ('472', 'BB11', '323', '2019-03-22 18:18:19', '35');
INSERT INTO `sensor_data` VALUES ('473', 'BB11', '323', '2019-03-22 18:18:21', '35');
INSERT INTO `sensor_data` VALUES ('474', 'BB11', '323', '2019-03-22 18:18:23', '35');
INSERT INTO `sensor_data` VALUES ('475', 'BB11', '323', '2019-03-22 18:18:27', '35');
INSERT INTO `sensor_data` VALUES ('476', 'BB11', '323', '2019-03-22 18:18:27', '35');
INSERT INTO `sensor_data` VALUES ('477', 'BB11', '323', '2019-03-22 18:18:29', '35');
INSERT INTO `sensor_data` VALUES ('478', 'BB11', '323', '2019-03-22 18:18:31', '35');
INSERT INTO `sensor_data` VALUES ('480', 'BB11', '323', '2019-03-22 18:18:57', '19');
INSERT INTO `sensor_data` VALUES ('482', 'BB11', '323', '2019-03-22 18:18:57', '31');
INSERT INTO `sensor_data` VALUES ('484', 'BB11', '323', '2019-03-22 18:18:57', '39');
INSERT INTO `sensor_data` VALUES ('486', 'BB11', '323', '2019-03-22 18:18:59', '36');
INSERT INTO `sensor_data` VALUES ('488', 'BB11', '323', '2019-03-22 18:19:03', '41');
INSERT INTO `sensor_data` VALUES ('490', 'BB11', '323', '2019-03-22 18:19:03', '52');
INSERT INTO `sensor_data` VALUES ('492', 'BB11', '323', '2019-03-22 18:19:06', '48');
INSERT INTO `sensor_data` VALUES ('493', 'BB11', '323', '2019-03-22 18:19:08', '48');
INSERT INTO `sensor_data` VALUES ('494', 'BB11', '323', '2019-03-22 18:19:12', '48');
INSERT INTO `sensor_data` VALUES ('495', 'BB11', '323', '2019-03-22 18:19:12', '48');
INSERT INTO `sensor_data` VALUES ('496', 'BB11', '323', '2019-03-22 18:19:14', '48');
INSERT INTO `sensor_data` VALUES ('497', 'BB11', '323', '2019-03-22 18:19:16', '48');
INSERT INTO `sensor_data` VALUES ('498', 'BB11', '323', '2019-03-22 18:19:21', '48');
INSERT INTO `sensor_data` VALUES ('499', 'BB11', '323', '2019-03-22 18:19:21', '48');
INSERT INTO `sensor_data` VALUES ('500', 'BB11', '323', '2019-03-22 18:19:23', '48');
INSERT INTO `sensor_data` VALUES ('501', 'BB11', '323', '2019-03-22 18:19:25', '48');
INSERT INTO `sensor_data` VALUES ('502', 'BB11', '323', '2019-03-22 18:19:29', '48');
INSERT INTO `sensor_data` VALUES ('503', 'BB11', '323', '2019-03-22 18:19:29', '48');
INSERT INTO `sensor_data` VALUES ('504', 'BB11', '323', '2019-03-22 18:19:31', '48');
INSERT INTO `sensor_data` VALUES ('505', 'BB11', '323', '2019-03-22 18:19:34', '48');
INSERT INTO `sensor_data` VALUES ('506', 'BB11', '323', '2019-03-22 18:19:38', '48');
INSERT INTO `sensor_data` VALUES ('507', 'BB11', '323', '2019-03-22 18:19:38', '48');
INSERT INTO `sensor_data` VALUES ('508', 'BB11', '323', '2019-03-22 18:19:40', '48');
INSERT INTO `sensor_data` VALUES ('509', 'BB11', '323', '2019-03-22 18:19:42', '48');
INSERT INTO `sensor_data` VALUES ('510', 'BB11', '323', '2019-03-22 18:19:46', '48');
INSERT INTO `sensor_data` VALUES ('511', 'BB11', '323', '2019-03-22 18:19:46', '48');
INSERT INTO `sensor_data` VALUES ('512', 'BB11', '323', '2019-03-22 18:19:48', '48');
INSERT INTO `sensor_data` VALUES ('513', 'BB11', '323', '2019-03-22 18:19:50', '48');
INSERT INTO `sensor_data` VALUES ('514', 'BB11', '323', '2019-03-22 18:19:54', '48');
INSERT INTO `sensor_data` VALUES ('515', 'BB11', '323', '2019-03-22 18:19:54', '48');
INSERT INTO `sensor_data` VALUES ('516', 'BB11', '323', '2019-03-22 18:19:56', '48');
INSERT INTO `sensor_data` VALUES ('517', 'BB11', '323', '2019-03-22 18:19:59', '48');
INSERT INTO `sensor_data` VALUES ('518', 'BB11', '323', '2019-03-22 18:20:04', '48');
INSERT INTO `sensor_data` VALUES ('519', 'BB11', '323', '2019-03-22 18:20:04', '48');
INSERT INTO `sensor_data` VALUES ('520', 'BB11', '323', '2019-03-22 18:20:04', '48');
INSERT INTO `sensor_data` VALUES ('521', 'BB11', '323', '2019-03-22 18:20:07', '48');
INSERT INTO `sensor_data` VALUES ('522', 'BB11', '323', '2019-03-22 18:20:11', '48');
INSERT INTO `sensor_data` VALUES ('523', 'BB11', '323', '2019-03-22 18:20:11', '48');
INSERT INTO `sensor_data` VALUES ('524', 'BB11', '323', '2019-03-22 18:20:13', '48');
INSERT INTO `sensor_data` VALUES ('525', 'BB11', '323', '2019-03-22 18:20:15', '48');
INSERT INTO `sensor_data` VALUES ('526', 'BB11', '323', '2019-03-22 18:20:20', '48');
INSERT INTO `sensor_data` VALUES ('527', 'BB11', '323', '2019-03-22 18:20:20', '48');
INSERT INTO `sensor_data` VALUES ('528', 'BB11', '323', '2019-03-22 18:20:22', '48');
INSERT INTO `sensor_data` VALUES ('529', 'BB11', '323', '2019-03-22 18:20:24', '48');
INSERT INTO `sensor_data` VALUES ('530', 'BB11', '323', '2019-03-22 18:20:38', '33');
INSERT INTO `sensor_data` VALUES ('532', 'BB11', '323', '2019-03-22 18:20:38', '33');
INSERT INTO `sensor_data` VALUES ('534', 'BB11', '323', '2019-03-22 18:20:39', '34');
INSERT INTO `sensor_data` VALUES ('536', 'BB11', '323', '2019-03-22 18:20:41', '34');
INSERT INTO `sensor_data` VALUES ('538', 'BB11', '323', '2019-03-22 18:20:47', '33');
INSERT INTO `sensor_data` VALUES ('540', 'BB11', '323', '2019-03-22 18:20:47', '34');
INSERT INTO `sensor_data` VALUES ('542', 'BB11', '323', '2019-03-22 18:20:47', '33');
INSERT INTO `sensor_data` VALUES ('544', 'BB11', '323', '2019-03-22 18:20:50', '35');
INSERT INTO `sensor_data` VALUES ('546', 'BB11', '323', '2019-03-22 18:20:55', '35');
INSERT INTO `sensor_data` VALUES ('548', 'BB11', '323', '2019-03-22 18:20:55', '37');
INSERT INTO `sensor_data` VALUES ('550', 'BB11', '323', '2019-03-22 18:20:56', '38');
INSERT INTO `sensor_data` VALUES ('552', 'BB11', '323', '2019-03-22 18:20:58', '38');
INSERT INTO `sensor_data` VALUES ('553', 'BB11', '323', '2019-03-22 18:21:03', '38');
INSERT INTO `sensor_data` VALUES ('554', 'BB11', '323', '2019-03-22 18:21:03', '38');
INSERT INTO `sensor_data` VALUES ('555', 'BB11', '323', '2019-03-22 18:21:05', '38');
INSERT INTO `sensor_data` VALUES ('556', 'BB11', '323', '2019-03-22 18:21:07', '38');
INSERT INTO `sensor_data` VALUES ('557', 'BB11', '323', '2019-03-22 18:21:11', '38');
INSERT INTO `sensor_data` VALUES ('558', 'BB11', '323', '2019-03-22 18:21:11', '38');
INSERT INTO `sensor_data` VALUES ('559', 'BB11', '323', '2019-03-22 18:21:13', '38');
INSERT INTO `sensor_data` VALUES ('560', 'BB11', '323', '2019-03-22 18:21:15', '38');
INSERT INTO `sensor_data` VALUES ('561', 'BB11', '323', '2019-03-22 18:21:19', '38');
INSERT INTO `sensor_data` VALUES ('562', 'BB11', '323', '2019-03-22 18:21:19', '38');
INSERT INTO `sensor_data` VALUES ('563', 'BB11', '323', '2019-03-22 18:21:42', '38');
INSERT INTO `sensor_data` VALUES ('564', 'BB11', '323', '2019-03-22 18:21:42', '11');
INSERT INTO `sensor_data` VALUES ('566', 'BB11', '323', '2019-03-22 18:21:42', '11');
INSERT INTO `sensor_data` VALUES ('568', 'BB11', '323', '2019-03-22 18:21:45', '11');
INSERT INTO `sensor_data` VALUES ('570', 'BB11', '323', '2019-03-22 18:21:49', '11');
INSERT INTO `sensor_data` VALUES ('572', 'BB11', '323', '2019-03-22 18:21:49', '11');
INSERT INTO `sensor_data` VALUES ('574', 'BB11', '323', '2019-03-22 18:21:51', '11');
INSERT INTO `sensor_data` VALUES ('576', 'BB11', '323', '2019-03-22 18:21:53', '11');
INSERT INTO `sensor_data` VALUES ('577', 'BB11', '323', '2019-03-22 18:22:40', '11');
INSERT INTO `sensor_data` VALUES ('579', 'BB11', '323', '2019-03-22 18:22:41', '20');
INSERT INTO `sensor_data` VALUES ('581', 'BB11', '323', '2019-03-22 18:22:42', '38');
INSERT INTO `sensor_data` VALUES ('583', 'BB11', '323', '2019-03-22 18:22:44', '30');
INSERT INTO `sensor_data` VALUES ('585', 'BB11', '323', '2019-03-22 18:22:48', '29');
INSERT INTO `sensor_data` VALUES ('587', 'BB11', '323', '2019-03-22 18:22:48', '26');
INSERT INTO `sensor_data` VALUES ('589', 'BB11', '323', '2019-03-22 18:22:50', '47');
INSERT INTO `sensor_data` VALUES ('591', 'BB11', '323', '2019-03-22 18:22:57', '36');
INSERT INTO `sensor_data` VALUES ('593', 'BB11', '323', '2019-03-22 18:22:57', '30');
INSERT INTO `sensor_data` VALUES ('594', 'BB11', '323', '2019-03-22 18:22:57', '30');
INSERT INTO `sensor_data` VALUES ('595', 'BB11', '323', '2019-03-22 18:22:59', '30');
INSERT INTO `sensor_data` VALUES ('596', 'BB11', '323', '2019-03-22 18:23:03', '30');
INSERT INTO `sensor_data` VALUES ('597', 'BB11', '323', '2019-03-22 18:23:03', '30');
INSERT INTO `sensor_data` VALUES ('598', 'BB11', '323', '2019-03-22 18:23:05', '30');
INSERT INTO `sensor_data` VALUES ('599', 'BB11', '323', '2019-03-22 18:23:07', '30');
INSERT INTO `sensor_data` VALUES ('600', 'BB11', '323', '2019-03-22 18:23:11', '30');
INSERT INTO `sensor_data` VALUES ('601', 'BB11', '323', '2019-03-22 18:23:11', '30');
INSERT INTO `sensor_data` VALUES ('602', 'BB11', '323', '2019-03-22 18:23:13', '30');
INSERT INTO `sensor_data` VALUES ('603', 'BB11', '323', '2019-03-22 18:23:16', '30');
INSERT INTO `sensor_data` VALUES ('604', 'BB11', '323', '2019-03-22 18:23:20', '30');
INSERT INTO `sensor_data` VALUES ('605', 'BB11', '323', '2019-03-22 18:23:20', '30');
INSERT INTO `sensor_data` VALUES ('606', 'BB11', '323', '2019-03-22 18:23:22', '30');
INSERT INTO `sensor_data` VALUES ('607', 'BB11', '323', '2019-03-22 18:23:24', '30');
INSERT INTO `sensor_data` VALUES ('608', 'BB11', '323', '2019-03-22 18:23:28', '30');
INSERT INTO `sensor_data` VALUES ('609', 'BB11', '323', '2019-03-22 18:23:28', '30');
INSERT INTO `sensor_data` VALUES ('610', 'BB11', '323', '2019-03-22 18:23:30', '30');
INSERT INTO `sensor_data` VALUES ('611', 'BB11', '323', '2019-03-22 18:23:33', '30');
INSERT INTO `sensor_data` VALUES ('612', 'BB11', '323', '2019-03-22 18:23:37', '30');
INSERT INTO `sensor_data` VALUES ('613', 'BB11', '323', '2019-03-22 18:23:37', '30');
INSERT INTO `sensor_data` VALUES ('614', 'BB11', '323', '2019-03-22 18:40:39', '30');
INSERT INTO `sensor_data` VALUES ('615', 'BB11', '323', '2019-03-22 18:40:39', '30');
INSERT INTO `sensor_data` VALUES ('616', 'BB11', '323', '2019-03-22 18:40:41', '30');
INSERT INTO `sensor_data` VALUES ('617', 'BB11', '323', '2019-03-22 18:40:43', '30');
INSERT INTO `sensor_data` VALUES ('618', 'BB11', '323', '2019-03-22 18:40:48', '30');
INSERT INTO `sensor_data` VALUES ('619', 'BB11', '323', '2019-03-22 18:40:48', '30');
INSERT INTO `sensor_data` VALUES ('620', 'BB11', '323', '2019-03-22 18:40:50', '30');
INSERT INTO `sensor_data` VALUES ('621', 'BB11', '323', '2019-03-22 18:40:52', '30');
INSERT INTO `sensor_data` VALUES ('622', 'BB11', '323', '2019-03-22 18:40:57', '30');
INSERT INTO `sensor_data` VALUES ('623', 'BB11', '323', '2019-03-22 18:40:57', '30');
INSERT INTO `sensor_data` VALUES ('624', 'BB11', '323', '2019-03-22 18:40:59', '15');
INSERT INTO `sensor_data` VALUES ('626', 'BB11', '323', '2019-03-22 18:41:04', '15');
INSERT INTO `sensor_data` VALUES ('628', 'BB11', '323', '2019-03-22 18:41:04', '15');
INSERT INTO `sensor_data` VALUES ('630', 'BB11', '323', '2019-03-22 18:41:05', '15');
INSERT INTO `sensor_data` VALUES ('632', 'BB11', '323', '2019-03-22 18:41:07', '15');
INSERT INTO `sensor_data` VALUES ('634', 'BB11', '323', '2019-03-22 18:41:11', '15');
INSERT INTO `sensor_data` VALUES ('636', 'BB11', '323', '2019-03-22 18:41:11', '15');
INSERT INTO `sensor_data` VALUES ('638', 'BB11', '323', '2019-03-22 18:41:13', '15');
INSERT INTO `sensor_data` VALUES ('640', 'BB11', '323', '2019-03-22 18:41:19', '15');
INSERT INTO `sensor_data` VALUES ('642', 'BB11', '323', '2019-03-22 18:41:19', '15');
INSERT INTO `sensor_data` VALUES ('644', 'BB11', '323', '2019-03-22 18:41:20', '15');
INSERT INTO `sensor_data` VALUES ('646', 'BB11', '323', '2019-03-22 18:41:22', '15');
INSERT INTO `sensor_data` VALUES ('648', 'BB11', '323', '2019-03-22 18:41:26', '15');
INSERT INTO `sensor_data` VALUES ('650', 'BB11', '323', '2019-03-22 18:41:26', '15');
INSERT INTO `sensor_data` VALUES ('651', 'BB11', '323', '2019-03-22 18:41:28', '15');
INSERT INTO `sensor_data` VALUES ('652', 'BB11', '323', '2019-03-22 18:41:31', '15');
INSERT INTO `sensor_data` VALUES ('653', 'BB11', '323', '2019-03-22 18:41:35', '15');
INSERT INTO `sensor_data` VALUES ('654', 'BB11', '323', '2019-03-22 18:41:35', '15');
INSERT INTO `sensor_data` VALUES ('655', 'BB11', '323', '2019-03-22 18:41:37', '15');
INSERT INTO `sensor_data` VALUES ('656', 'BB11', '323', '2019-03-22 18:41:39', '15');
INSERT INTO `sensor_data` VALUES ('657', 'BB11', '323', '2019-03-22 18:41:44', '15');
INSERT INTO `sensor_data` VALUES ('658', 'BB11', '323', '2019-03-22 18:41:44', '15');
INSERT INTO `sensor_data` VALUES ('659', 'BB11', '323', '2019-03-22 18:41:46', '15');
INSERT INTO `sensor_data` VALUES ('660', 'BB11', '323', '2019-03-22 18:41:48', '15');
INSERT INTO `sensor_data` VALUES ('661', 'BB11', '323', '2019-03-22 18:41:52', '15');
INSERT INTO `sensor_data` VALUES ('662', 'BB11', '323', '2019-03-22 18:41:52', '15');
INSERT INTO `sensor_data` VALUES ('663', 'BB11', '323', '2019-03-22 18:41:54', '15');
INSERT INTO `sensor_data` VALUES ('664', 'BB11', '323', '2019-03-22 18:41:56', '15');
INSERT INTO `sensor_data` VALUES ('665', 'BB11', '323', '2019-03-22 18:42:01', '15');
INSERT INTO `sensor_data` VALUES ('666', 'BB11', '323', '2019-03-22 18:42:01', '15');
INSERT INTO `sensor_data` VALUES ('667', 'BB11', '323', '2019-03-22 18:42:03', '15');
INSERT INTO `sensor_data` VALUES ('668', 'BB11', '323', '2019-03-22 18:42:05', '15');
INSERT INTO `sensor_data` VALUES ('669', 'BB11', '323', '2019-03-22 18:42:09', '15');
INSERT INTO `sensor_data` VALUES ('670', 'BB11', '323', '2019-03-22 18:42:09', '15');
INSERT INTO `sensor_data` VALUES ('671', 'BB11', '323', '2019-03-22 18:42:11', '15');
INSERT INTO `sensor_data` VALUES ('672', 'BB11', '323', '2019-03-22 18:42:13', '15');
INSERT INTO `sensor_data` VALUES ('673', 'BB11', '323', '2019-03-22 18:42:18', '15');
INSERT INTO `sensor_data` VALUES ('674', 'BB11', '323', '2019-03-22 18:42:18', '15');
INSERT INTO `sensor_data` VALUES ('675', 'BB11', '323', '2019-03-22 18:42:20', '15');
INSERT INTO `sensor_data` VALUES ('676', 'BB11', '323', '2019-03-22 18:42:22', '15');
INSERT INTO `sensor_data` VALUES ('677', 'BB11', '323', '2019-03-22 18:42:26', '15');
INSERT INTO `sensor_data` VALUES ('678', 'BB11', '323', '2019-03-22 18:42:26', '15');
INSERT INTO `sensor_data` VALUES ('679', 'BB11', '323', '2019-03-22 18:42:29', '15');
INSERT INTO `sensor_data` VALUES ('680', 'BB11', '323', '2019-03-22 18:42:31', '15');
INSERT INTO `sensor_data` VALUES ('681', 'BB11', '323', '2019-03-22 18:42:35', '15');
INSERT INTO `sensor_data` VALUES ('682', 'BB11', '323', '2019-03-22 18:42:35', '15');
INSERT INTO `sensor_data` VALUES ('683', 'BB11', '323', '2019-03-22 18:42:37', '15');
INSERT INTO `sensor_data` VALUES ('684', 'BB11', '323', '2019-03-22 18:42:39', '15');
INSERT INTO `sensor_data` VALUES ('685', 'BB11', '323', '2019-03-22 18:42:44', '15');
INSERT INTO `sensor_data` VALUES ('686', 'BB11', '323', '2019-03-22 18:42:44', '15');
INSERT INTO `sensor_data` VALUES ('687', 'BB11', '323', '2019-03-22 18:42:46', '15');
INSERT INTO `sensor_data` VALUES ('688', 'BB11', '323', '2019-03-22 18:42:48', '15');
INSERT INTO `sensor_data` VALUES ('689', 'BB11', '323', '2019-03-22 18:42:52', '15');
INSERT INTO `sensor_data` VALUES ('690', 'BB11', '323', '2019-03-22 18:42:52', '15');
INSERT INTO `sensor_data` VALUES ('691', 'BB11', '323', '2019-03-22 18:42:54', '15');
INSERT INTO `sensor_data` VALUES ('692', 'BB11', '323', '2019-03-22 18:42:57', '15');
INSERT INTO `sensor_data` VALUES ('693', 'BB11', '323', '2019-03-22 18:43:01', '15');
INSERT INTO `sensor_data` VALUES ('694', 'BB11', '323', '2019-03-22 18:43:01', '15');
INSERT INTO `sensor_data` VALUES ('695', 'BB11', '323', '2019-03-22 18:43:09', '15');
INSERT INTO `sensor_data` VALUES ('696', 'BB11', '323', '2019-03-22 18:43:09', '15');
INSERT INTO `sensor_data` VALUES ('697', 'BB11', '323', '2019-03-22 18:43:09', '15');
INSERT INTO `sensor_data` VALUES ('698', 'BB11', '323', '2019-03-22 18:43:12', '15');
INSERT INTO `sensor_data` VALUES ('699', 'BB11', '323', '2019-03-22 18:44:41', '15');
INSERT INTO `sensor_data` VALUES ('700', 'BB11', '323', '2019-03-22 18:44:41', '15');
INSERT INTO `sensor_data` VALUES ('701', 'BB11', '323', '2019-03-22 18:44:41', '15');
INSERT INTO `sensor_data` VALUES ('702', 'BB11', '323', '2019-03-22 18:44:43', '15');
INSERT INTO `sensor_data` VALUES ('703', 'BB11', '323', '2019-03-22 18:44:47', '15');
INSERT INTO `sensor_data` VALUES ('704', 'BB11', '323', '2019-03-22 18:44:47', '15');
INSERT INTO `sensor_data` VALUES ('705', 'BB11', '323', '2019-03-22 18:44:50', '15');
INSERT INTO `sensor_data` VALUES ('706', 'BB11', '323', '2019-03-22 18:44:52', '15');
INSERT INTO `sensor_data` VALUES ('707', 'BB11', '323', '2019-03-22 18:44:56', '29');
INSERT INTO `sensor_data` VALUES ('709', 'BB11', '323', '2019-03-22 18:44:56', '33');
INSERT INTO `sensor_data` VALUES ('711', 'BB11', '323', '2019-03-22 18:44:58', '18');
INSERT INTO `sensor_data` VALUES ('713', 'BB11', '323', '2019-03-22 18:45:04', '19');
INSERT INTO `sensor_data` VALUES ('715', 'BB11', '323', '2019-03-22 18:45:04', '19');
INSERT INTO `sensor_data` VALUES ('717', 'BB11', '323', '2019-03-22 18:45:05', '18');
INSERT INTO `sensor_data` VALUES ('719', 'BB11', '323', '2019-03-22 18:45:07', '18');
INSERT INTO `sensor_data` VALUES ('720', 'BB11', '323', '2019-03-22 20:54:24', '-9');
INSERT INTO `sensor_data` VALUES ('722', 'BB11', '323', '2019-03-22 20:54:24', '-9');
INSERT INTO `sensor_data` VALUES ('724', 'BB11', '323', '2019-03-22 20:54:25', '-10');
INSERT INTO `sensor_data` VALUES ('726', 'BB11', '323', '2019-03-22 20:54:27', '-9');
INSERT INTO `sensor_data` VALUES ('728', 'BB11', '323', '2019-03-22 20:54:30', '-9');
INSERT INTO `sensor_data` VALUES ('730', 'BB11', '323', '2019-03-22 20:54:31', '-10');
INSERT INTO `sensor_data` VALUES ('732', 'BB11', '323', '2019-03-22 20:54:33', '-9');
INSERT INTO `sensor_data` VALUES ('735', 'BB11', '323', '2019-03-22 20:54:53', '-9');
INSERT INTO `sensor_data` VALUES ('737', 'BB11', '323', '2019-03-22 20:54:53', '-9');
INSERT INTO `sensor_data` VALUES ('739', 'BB11', '323', '2019-03-22 20:54:55', '-9');
INSERT INTO `sensor_data` VALUES ('741', 'BB11', '323', '2019-03-22 20:54:57', '-9');
INSERT INTO `sensor_data` VALUES ('743', 'BB11', '323', '2019-03-22 20:55:01', '-9');
INSERT INTO `sensor_data` VALUES ('745', 'BB11', '323', '2019-03-22 20:55:01', '-9');
INSERT INTO `sensor_data` VALUES ('747', 'BB11', '323', '2019-03-22 20:55:03', '-9');
INSERT INTO `sensor_data` VALUES ('749', 'BB11', '323', '2019-03-22 20:55:07', '-9');
INSERT INTO `sensor_data` VALUES ('751', 'BB11', '323', '2019-03-22 20:55:07', '-9');
INSERT INTO `sensor_data` VALUES ('753', 'BB11', '323', '2019-03-22 20:55:10', '-9');
INSERT INTO `sensor_data` VALUES ('755', 'BB11', '323', '2019-03-22 20:55:12', '-9');
INSERT INTO `sensor_data` VALUES ('757', 'BB11', '323', '2019-03-22 20:55:15', '-9');
INSERT INTO `sensor_data` VALUES ('759', 'BB11', '323', '2019-03-22 20:55:16', '-9');
INSERT INTO `sensor_data` VALUES ('761', 'BB11', '323', '2019-03-22 20:55:18', '-9');
INSERT INTO `sensor_data` VALUES ('763', 'BB11', '323', '2019-03-22 20:55:24', '-9');
INSERT INTO `sensor_data` VALUES ('765', 'BB11', '323', '2019-03-22 20:55:24', '-9');
INSERT INTO `sensor_data` VALUES ('767', 'BB11', '323', '2019-03-22 21:03:48', '-10');
INSERT INTO `sensor_data` VALUES ('769', 'BB11', '323', '2019-03-22 21:03:48', '-10');
INSERT INTO `sensor_data` VALUES ('771', 'BB11', '323', '2019-03-22 21:03:50', '-10');
INSERT INTO `sensor_data` VALUES ('773', 'BB11', '323', '2019-03-22 21:03:52', '-10');
INSERT INTO `sensor_data` VALUES ('775', 'BB11', '323', '2019-03-22 21:03:56', '-11');
INSERT INTO `sensor_data` VALUES ('777', 'BB11', '323', '2019-03-22 21:03:56', '-31');
INSERT INTO `sensor_data` VALUES ('779', 'BB11', '323', '2019-03-22 21:03:59', '-38');
INSERT INTO `sensor_data` VALUES ('781', 'BB11', '323', '2019-03-22 21:04:03', '-35');
INSERT INTO `sensor_data` VALUES ('783', 'BB11', '323', '2019-03-22 21:04:03', '-37');
INSERT INTO `sensor_data` VALUES ('785', 'BB11', '323', '2019-03-22 21:04:05', '-38');
INSERT INTO `sensor_data` VALUES ('787', 'BB11', '323', '2019-03-22 21:04:07', '-42');
INSERT INTO `sensor_data` VALUES ('789', 'BB11', '323', '2019-03-22 21:04:11', '-30');
INSERT INTO `sensor_data` VALUES ('791', 'BB11', '323', '2019-03-22 21:04:11', '-32');
INSERT INTO `sensor_data` VALUES ('793', 'BB11', '323', '2019-03-22 21:04:13', '-33');
INSERT INTO `sensor_data` VALUES ('794', 'BB11', '323', '2019-03-22 21:04:16', '-33');
INSERT INTO `sensor_data` VALUES ('795', 'BB11', '323', '2019-03-22 21:04:20', '-33');
INSERT INTO `sensor_data` VALUES ('796', 'BB11', '323', '2019-03-22 21:04:20', '-33');
INSERT INTO `sensor_data` VALUES ('797', 'BB11', '323', '2019-03-22 21:04:22', '-33');
INSERT INTO `sensor_data` VALUES ('798', 'BB11', '323', '2019-03-22 21:04:24', '-33');
INSERT INTO `sensor_data` VALUES ('799', 'BB11', '323', '2019-03-22 21:05:13', '-33');
INSERT INTO `sensor_data` VALUES ('800', 'BB11', '323', '2019-03-22 21:05:13', '-33');
INSERT INTO `sensor_data` VALUES ('801', 'BB11', '323', '2019-03-22 21:05:15', '-33');
INSERT INTO `sensor_data` VALUES ('802', 'BB11', '323', '2019-03-22 21:05:17', '-33');
INSERT INTO `sensor_data` VALUES ('803', 'BB11', '323', '2019-03-22 21:05:21', '-33');
INSERT INTO `sensor_data` VALUES ('804', 'BB11', '323', '2019-03-22 21:05:21', '-33');
INSERT INTO `sensor_data` VALUES ('805', 'BB11', '323', '2019-03-22 21:05:23', '-33');
INSERT INTO `sensor_data` VALUES ('806', 'BB11', '323', '2019-03-22 21:05:25', '-33');
INSERT INTO `sensor_data` VALUES ('807', 'BB11', '323', '2019-03-22 21:05:30', '-33');
INSERT INTO `sensor_data` VALUES ('808', 'BB11', '323', '2019-03-22 21:05:30', '-33');
INSERT INTO `sensor_data` VALUES ('809', 'BB11', '323', '2019-03-22 21:05:32', '-33');
INSERT INTO `sensor_data` VALUES ('810', 'BB11', '323', '2019-03-22 21:05:34', '-24');
INSERT INTO `sensor_data` VALUES ('812', 'BB11', '323', '2019-03-22 21:05:37', '-24');
INSERT INTO `sensor_data` VALUES ('814', 'BB11', '323', '2019-03-22 21:05:38', '-24');
INSERT INTO `sensor_data` VALUES ('816', 'BB11', '323', '2019-03-22 21:05:40', '-24');
INSERT INTO `sensor_data` VALUES ('818', 'BB11', '323', '2019-03-22 21:05:46', '-24');
INSERT INTO `sensor_data` VALUES ('820', 'BB11', '323', '2019-03-22 21:05:46', '-24');
INSERT INTO `sensor_data` VALUES ('822', 'BB11', '323', '2019-03-22 21:05:46', '-24');
INSERT INTO `sensor_data` VALUES ('824', 'BB11', '323', '2019-03-22 21:05:49', '-24');
INSERT INTO `sensor_data` VALUES ('826', 'BB11', '323', '2019-03-22 21:05:52', '-24');
INSERT INTO `sensor_data` VALUES ('828', 'BB11', '323', '2019-03-22 21:05:53', '-24');
INSERT INTO `sensor_data` VALUES ('829', 'BB11', '323', '2019-03-22 21:10:32', '-28');
INSERT INTO `sensor_data` VALUES ('831', 'BB11', '323', '2019-03-22 21:10:32', '-27');
INSERT INTO `sensor_data` VALUES ('833', 'BB11', '323', '2019-03-22 21:10:34', '-36');
INSERT INTO `sensor_data` VALUES ('835', 'BB11', '323', '2019-03-22 21:10:37', '-34');
INSERT INTO `sensor_data` VALUES ('837', 'BB11', '323', '2019-03-22 21:10:41', '-36');
INSERT INTO `sensor_data` VALUES ('839', 'BB11', '323', '2019-03-22 21:10:41', '-42');
INSERT INTO `sensor_data` VALUES ('841', 'BB11', '323', '2019-03-22 21:10:43', '-42');
INSERT INTO `sensor_data` VALUES ('842', 'BB11', '323', '2019-03-22 21:10:45', '-42');
INSERT INTO `sensor_data` VALUES ('843', 'BB11', '323', '2019-03-22 21:10:49', '-42');
INSERT INTO `sensor_data` VALUES ('844', 'BB11', '323', '2019-03-22 21:10:49', '-42');
INSERT INTO `sensor_data` VALUES ('845', 'BB11', '323', '2019-03-22 21:10:51', '-42');
INSERT INTO `sensor_data` VALUES ('846', 'BB11', '323', '2019-03-22 21:10:53', '-42');
INSERT INTO `sensor_data` VALUES ('847', 'BB11', '323', '2019-03-22 21:10:58', '-42');
INSERT INTO `sensor_data` VALUES ('848', 'BB11', '323', '2019-03-22 21:10:58', '-42');
INSERT INTO `sensor_data` VALUES ('849', 'BB11', '323', '2019-03-22 21:11:00', '-42');
INSERT INTO `sensor_data` VALUES ('850', 'BB11', '323', '2019-03-22 21:11:02', '-42');
INSERT INTO `sensor_data` VALUES ('851', 'BB11', '323', '2019-03-22 21:15:43', '-42');
INSERT INTO `sensor_data` VALUES ('852', 'BB11', '323', '2019-03-22 21:15:43', '-42');
INSERT INTO `sensor_data` VALUES ('853', 'BB11', '323', '2019-03-22 21:15:45', '-42');
INSERT INTO `sensor_data` VALUES ('854', 'BB11', '323', '2019-03-22 21:15:47', '-42');
INSERT INTO `sensor_data` VALUES ('855', 'BB11', '323', '2019-03-22 21:15:52', '-42');
INSERT INTO `sensor_data` VALUES ('856', 'BB11', '323', '2019-03-22 21:15:52', '-42');
INSERT INTO `sensor_data` VALUES ('857', 'BB11', '323', '2019-03-22 21:15:54', '-42');
INSERT INTO `sensor_data` VALUES ('858', 'BB11', '323', '2019-03-22 21:15:56', '-42');
INSERT INTO `sensor_data` VALUES ('859', 'BB11', '323', '2019-03-22 21:16:00', '-42');
INSERT INTO `sensor_data` VALUES ('860', 'BB11', '323', '2019-03-22 21:16:00', '-42');
INSERT INTO `sensor_data` VALUES ('861', 'BB11', '323', '2019-03-22 21:16:02', '-42');
INSERT INTO `sensor_data` VALUES ('862', 'BB11', '323', '2019-03-22 21:16:04', '-42');
INSERT INTO `sensor_data` VALUES ('863', 'BB11', '323', '2019-03-22 21:16:09', '-42');
INSERT INTO `sensor_data` VALUES ('864', 'BB11', '323', '2019-03-22 21:16:09', '-42');
INSERT INTO `sensor_data` VALUES ('865', 'BB11', '323', '2019-03-22 21:16:11', '-42');
INSERT INTO `sensor_data` VALUES ('866', 'BB11', '323', '2019-03-22 21:16:13', '-42');
INSERT INTO `sensor_data` VALUES ('867', 'BB11', '323', '2019-03-22 21:16:17', '-42');
INSERT INTO `sensor_data` VALUES ('868', 'BB11', '323', '2019-03-22 21:16:17', '-42');
INSERT INTO `sensor_data` VALUES ('869', 'BB11', '323', '2019-03-22 21:16:19', '-42');
INSERT INTO `sensor_data` VALUES ('870', 'BB11', '323', '2019-03-22 21:16:21', '-42');
INSERT INTO `sensor_data` VALUES ('871', 'BB11', '323', '2019-03-22 21:16:26', '-42');
INSERT INTO `sensor_data` VALUES ('872', 'BB11', '323', '2019-03-22 21:16:26', '-42');
INSERT INTO `sensor_data` VALUES ('873', 'BB11', '323', '2019-03-22 21:16:28', '-42');
INSERT INTO `sensor_data` VALUES ('874', 'BB11', '323', '2019-03-22 21:16:30', '-42');
INSERT INTO `sensor_data` VALUES ('875', 'BB11', '323', '2019-03-22 21:16:34', '-42');
INSERT INTO `sensor_data` VALUES ('876', 'BB11', '323', '2019-03-22 21:16:34', '-42');
INSERT INTO `sensor_data` VALUES ('877', 'BB11', '323', '2019-03-22 21:16:36', '-42');
INSERT INTO `sensor_data` VALUES ('878', 'BB11', '323', '2019-03-22 21:16:38', '-42');
INSERT INTO `sensor_data` VALUES ('879', 'BB11', '323', '2019-03-22 21:16:42', '-42');
INSERT INTO `sensor_data` VALUES ('880', 'BB11', '323', '2019-03-22 21:16:42', '-42');
INSERT INTO `sensor_data` VALUES ('881', 'BB11', '323', '2019-03-22 21:16:45', '-42');
INSERT INTO `sensor_data` VALUES ('882', 'BB11', '323', '2019-03-22 21:16:47', '-42');
INSERT INTO `sensor_data` VALUES ('883', 'BB11', '323', '2019-03-22 21:16:51', '-42');
INSERT INTO `sensor_data` VALUES ('884', 'BB11', '323', '2019-03-22 21:16:51', '-42');
INSERT INTO `sensor_data` VALUES ('885', 'BB11', '323', '2019-03-22 21:16:53', '-42');
INSERT INTO `sensor_data` VALUES ('886', 'BB11', '323', '2019-03-22 21:16:55', '-42');
INSERT INTO `sensor_data` VALUES ('887', 'BB11', '323', '2019-03-22 21:16:59', '-42');
INSERT INTO `sensor_data` VALUES ('888', 'BB11', '323', '2019-03-22 21:16:59', '-42');
INSERT INTO `sensor_data` VALUES ('889', 'BB11', '323', '2019-03-22 21:17:02', '-42');
INSERT INTO `sensor_data` VALUES ('890', 'BB11', '323', '2019-03-22 21:17:04', '-42');
INSERT INTO `sensor_data` VALUES ('891', 'BB11', '323', '2019-03-22 21:17:08', '-42');
INSERT INTO `sensor_data` VALUES ('892', 'BB11', '323', '2019-03-22 21:17:08', '-42');
INSERT INTO `sensor_data` VALUES ('893', 'BB11', '323', '2019-03-22 21:17:10', '-42');
INSERT INTO `sensor_data` VALUES ('894', 'BB11', '323', '2019-03-22 21:17:12', '-42');
INSERT INTO `sensor_data` VALUES ('895', 'BB11', '323', '2019-03-22 21:17:17', '-42');
INSERT INTO `sensor_data` VALUES ('896', 'BB11', '323', '2019-03-22 21:17:17', '-42');
INSERT INTO `sensor_data` VALUES ('897', 'BB11', '323', '2019-03-22 21:17:19', '-42');
INSERT INTO `sensor_data` VALUES ('898', 'BB11', '323', '2019-03-22 21:17:21', '-42');
INSERT INTO `sensor_data` VALUES ('899', 'BB11', '323', '2019-03-22 21:17:25', '-42');
INSERT INTO `sensor_data` VALUES ('900', 'BB11', '323', '2019-03-22 21:17:25', '-42');
INSERT INTO `sensor_data` VALUES ('901', 'BB11', '323', '2019-03-22 21:17:27', '-42');
INSERT INTO `sensor_data` VALUES ('902', 'BB11', '323', '2019-03-22 21:17:29', '-42');
INSERT INTO `sensor_data` VALUES ('903', 'BB11', '323', '2019-03-22 21:17:34', '-42');
INSERT INTO `sensor_data` VALUES ('904', 'BB11', '323', '2019-03-22 21:17:34', '-42');
INSERT INTO `sensor_data` VALUES ('905', 'BB11', '323', '2019-03-22 21:17:36', '-42');
INSERT INTO `sensor_data` VALUES ('906', 'BB11', '323', '2019-03-22 21:17:38', '-42');
INSERT INTO `sensor_data` VALUES ('907', 'BB11', '323', '2019-03-22 21:17:42', '-42');
INSERT INTO `sensor_data` VALUES ('908', 'BB11', '323', '2019-03-22 21:17:42', '-42');
INSERT INTO `sensor_data` VALUES ('909', 'BB11', '323', '2019-03-22 21:17:44', '-42');
INSERT INTO `sensor_data` VALUES ('910', 'BB11', '323', '2019-03-22 21:17:46', '-42');
INSERT INTO `sensor_data` VALUES ('911', 'BB11', '323', '2019-03-22 21:17:50', '-42');
INSERT INTO `sensor_data` VALUES ('912', 'BB11', '323', '2019-03-22 21:17:50', '-42');
INSERT INTO `sensor_data` VALUES ('913', 'BB11', '323', '2019-03-22 21:17:52', '-42');
INSERT INTO `sensor_data` VALUES ('914', 'BB11', '323', '2019-03-22 21:17:54', '-42');
INSERT INTO `sensor_data` VALUES ('915', 'BB11', '323', '2019-03-22 21:17:59', '-42');
INSERT INTO `sensor_data` VALUES ('916', 'BB11', '323', '2019-03-22 21:17:59', '-42');
INSERT INTO `sensor_data` VALUES ('917', 'BB11', '323', '2019-03-22 21:18:01', '-42');
INSERT INTO `sensor_data` VALUES ('918', 'BB11', '323', '2019-03-22 21:18:03', '-42');
INSERT INTO `sensor_data` VALUES ('919', 'BB11', '323', '2019-03-22 21:18:07', '-42');
INSERT INTO `sensor_data` VALUES ('920', 'BB11', '323', '2019-03-22 21:18:07', '-42');
INSERT INTO `sensor_data` VALUES ('921', 'BB11', '323', '2019-03-22 21:18:09', '-42');
INSERT INTO `sensor_data` VALUES ('922', 'BB11', '323', '2019-03-22 21:18:12', '-42');
INSERT INTO `sensor_data` VALUES ('923', 'BB11', '323', '2019-03-22 21:18:16', '-42');
INSERT INTO `sensor_data` VALUES ('924', 'BB11', '323', '2019-03-22 21:18:16', '-42');
INSERT INTO `sensor_data` VALUES ('925', 'BB11', '323', '2019-03-22 21:18:18', '-42');
INSERT INTO `sensor_data` VALUES ('926', 'BB11', '323', '2019-03-22 21:18:20', '-42');
INSERT INTO `sensor_data` VALUES ('927', 'BB11', '323', '2019-03-22 21:18:25', '-42');
INSERT INTO `sensor_data` VALUES ('928', 'BB11', '323', '2019-03-22 21:18:25', '-42');
INSERT INTO `sensor_data` VALUES ('929', 'BB11', '323', '2019-03-22 21:18:27', '-42');
INSERT INTO `sensor_data` VALUES ('930', 'BB11', '323', '2019-03-22 21:18:29', '-42');
INSERT INTO `sensor_data` VALUES ('931', 'BB11', '323', '2019-03-22 21:18:33', '-42');
INSERT INTO `sensor_data` VALUES ('932', 'BB11', '323', '2019-03-22 21:18:33', '-42');
INSERT INTO `sensor_data` VALUES ('933', 'BB11', '323', '2019-03-22 21:18:35', '-42');
INSERT INTO `sensor_data` VALUES ('934', 'BB11', '323', '2019-03-22 21:18:37', '-42');
INSERT INTO `sensor_data` VALUES ('935', 'BB11', '323', '2019-03-22 21:18:41', '-42');
INSERT INTO `sensor_data` VALUES ('936', 'BB11', '323', '2019-03-22 21:18:41', '-42');
INSERT INTO `sensor_data` VALUES ('937', 'BB11', '323', '2019-03-22 21:18:44', '-42');
INSERT INTO `sensor_data` VALUES ('938', 'BB11', '323', '2019-03-22 21:18:46', '-42');
INSERT INTO `sensor_data` VALUES ('939', 'BB11', '323', '2019-03-22 21:18:50', '-42');
INSERT INTO `sensor_data` VALUES ('940', 'BB11', '323', '2019-03-22 21:18:50', '-42');
INSERT INTO `sensor_data` VALUES ('941', 'BB11', '323', '2019-03-22 21:18:52', '-42');
INSERT INTO `sensor_data` VALUES ('942', 'BB11', '323', '2019-03-22 21:18:54', '-42');
INSERT INTO `sensor_data` VALUES ('943', 'BB11', '323', '2019-03-22 21:18:58', '-42');
INSERT INTO `sensor_data` VALUES ('944', 'BB11', '323', '2019-03-22 21:18:58', '-42');
INSERT INTO `sensor_data` VALUES ('945', 'BB11', '323', '2019-03-22 21:19:00', '-42');
INSERT INTO `sensor_data` VALUES ('946', 'BB11', '323', '2019-03-22 21:19:02', '-42');
INSERT INTO `sensor_data` VALUES ('947', 'BB11', '323', '2019-03-22 21:20:07', '-42');
INSERT INTO `sensor_data` VALUES ('948', 'BB11', '323', '2019-03-22 21:20:07', '-42');
INSERT INTO `sensor_data` VALUES ('949', 'BB11', '323', '2019-03-22 21:20:07', '-42');
INSERT INTO `sensor_data` VALUES ('950', 'BB11', '323', '2019-03-22 21:20:09', '-42');
INSERT INTO `sensor_data` VALUES ('951', 'BB11', '323', '2019-03-22 21:20:11', '-42');
INSERT INTO `sensor_data` VALUES ('952', 'BB11', '323', '2019-03-22 21:20:15', '-42');
INSERT INTO `sensor_data` VALUES ('953', 'BB11', '323', '2019-03-22 21:20:15', '-42');
INSERT INTO `sensor_data` VALUES ('954', 'BB11', '323', '2019-03-22 21:20:17', '-33');
INSERT INTO `sensor_data` VALUES ('955', 'BB0B', '132', '2019-03-22 21:20:18', '-32');
INSERT INTO `sensor_data` VALUES ('956', 'BB11', '323', '2019-03-22 21:20:22', '-33');
INSERT INTO `sensor_data` VALUES ('957', 'BB0B', '133', '2019-03-22 21:20:22', '-32');
INSERT INTO `sensor_data` VALUES ('958', 'BB11', '323', '2019-03-22 21:20:22', '-33');
INSERT INTO `sensor_data` VALUES ('959', 'BB0B', '133', '2019-03-22 21:20:23', '-32');
INSERT INTO `sensor_data` VALUES ('960', 'BB11', '323', '2019-03-22 21:20:24', '-33');
INSERT INTO `sensor_data` VALUES ('961', 'BB0B', '133', '2019-03-22 21:20:25', '-32');
INSERT INTO `sensor_data` VALUES ('962', 'BB11', '323', '2019-03-22 21:20:26', '-33');
INSERT INTO `sensor_data` VALUES ('963', 'BB0B', '126', '2019-03-22 21:20:30', '-32');
INSERT INTO `sensor_data` VALUES ('964', 'BB11', '323', '2019-03-22 21:20:30', '-33');
INSERT INTO `sensor_data` VALUES ('965', 'BB0B', '128', '2019-03-22 21:20:30', '-32');
INSERT INTO `sensor_data` VALUES ('966', 'BB11', '323', '2019-03-22 21:20:30', '-33');
INSERT INTO `sensor_data` VALUES ('967', 'BB0B', '133', '2019-03-22 21:20:31', '-32');
INSERT INTO `sensor_data` VALUES ('968', 'BB11', '323', '2019-03-22 21:20:33', '-32');
INSERT INTO `sensor_data` VALUES ('969', 'BB0B', '128', '2019-03-22 21:20:33', '-32');
INSERT INTO `sensor_data` VALUES ('970', 'BB11', '323', '2019-03-22 21:20:37', '-32');
INSERT INTO `sensor_data` VALUES ('971', 'BB0B', '129', '2019-03-22 21:20:37', '-32');
INSERT INTO `sensor_data` VALUES ('972', 'BB11', '323', '2019-03-22 21:20:37', '-32');
INSERT INTO `sensor_data` VALUES ('973', 'BB0B', '125', '2019-03-22 21:20:37', '-30');
INSERT INTO `sensor_data` VALUES ('974', 'BB11', '323', '2019-03-22 21:20:39', '-30');
INSERT INTO `sensor_data` VALUES ('975', 'BB0B', '131', '2019-03-22 21:20:39', '-29');
INSERT INTO `sensor_data` VALUES ('976', 'BB11', '323', '2019-03-22 21:20:41', '-30');
INSERT INTO `sensor_data` VALUES ('977', 'BB11', '323', '2019-03-22 21:20:45', '-30');
INSERT INTO `sensor_data` VALUES ('978', 'BB11', '323', '2019-03-22 21:20:45', '-30');
INSERT INTO `sensor_data` VALUES ('979', 'BB11', '323', '2019-03-22 21:20:47', '-30');
INSERT INTO `sensor_data` VALUES ('980', 'BB11', '323', '2019-03-22 21:20:50', '-30');
INSERT INTO `sensor_data` VALUES ('981', 'BB11', '323', '2019-03-22 21:20:54', '-30');
INSERT INTO `sensor_data` VALUES ('982', 'BB11', '323', '2019-03-22 21:20:54', '-30');
INSERT INTO `sensor_data` VALUES ('983', 'BB11', '323', '2019-03-22 21:20:56', '-30');
INSERT INTO `sensor_data` VALUES ('984', 'BB11', '323', '2019-03-22 21:20:58', '-31');
INSERT INTO `sensor_data` VALUES ('985', 'BB0B', '127', '2019-03-22 21:21:02', '-30');
INSERT INTO `sensor_data` VALUES ('986', 'BB11', '323', '2019-03-22 21:21:02', '-31');
INSERT INTO `sensor_data` VALUES ('987', 'BB0B', '130', '2019-03-22 21:21:02', '-30');
INSERT INTO `sensor_data` VALUES ('988', 'BB11', '323', '2019-03-22 21:21:02', '-31');
INSERT INTO `sensor_data` VALUES ('989', 'BB0B', '131', '2019-03-22 21:21:03', '-30');
INSERT INTO `sensor_data` VALUES ('990', 'BB11', '323', '2019-03-22 21:21:04', '-32');
INSERT INTO `sensor_data` VALUES ('991', 'BB0B', '132', '2019-03-22 21:21:05', '-30');
INSERT INTO `sensor_data` VALUES ('992', 'BB11', '323', '2019-03-22 21:21:09', '-31');
INSERT INTO `sensor_data` VALUES ('993', 'BB0B', '129', '2019-03-22 21:21:09', '-31');
INSERT INTO `sensor_data` VALUES ('994', 'BB11', '323', '2019-03-22 21:21:09', '-32');
INSERT INTO `sensor_data` VALUES ('995', 'BB0B', '125', '2019-03-22 21:21:10', '-30');
INSERT INTO `sensor_data` VALUES ('996', 'BB11', '323', '2019-03-22 21:21:11', '-32');
INSERT INTO `sensor_data` VALUES ('997', 'BB0B', '128', '2019-03-22 21:21:12', '-30');
INSERT INTO `sensor_data` VALUES ('998', 'BB11', '323', '2019-03-22 21:21:13', '-32');
INSERT INTO `sensor_data` VALUES ('999', 'BB0B', '139', '2019-03-22 21:21:16', '-31');
INSERT INTO `sensor_data` VALUES ('1000', 'BB11', '323', '2019-03-22 21:21:16', '-30');
INSERT INTO `sensor_data` VALUES ('1001', 'BB0B', '113', '2019-03-22 21:21:16', '-34');
INSERT INTO `sensor_data` VALUES ('1002', 'BB11', '323', '2019-03-22 21:21:17', '-35');
INSERT INTO `sensor_data` VALUES ('1003', 'BB0B', '111', '2019-03-22 21:21:18', '-35');
INSERT INTO `sensor_data` VALUES ('1004', 'BB11', '323', '2019-03-22 21:21:20', '-36');
INSERT INTO `sensor_data` VALUES ('1005', 'BB0B', '112', '2019-03-22 21:21:20', '-34');
INSERT INTO `sensor_data` VALUES ('1006', 'BB11', '323', '2019-03-22 21:21:24', '-36');
INSERT INTO `sensor_data` VALUES ('1007', 'BB0B', '115', '2019-03-22 21:21:24', '-36');
INSERT INTO `sensor_data` VALUES ('1008', 'BB11', '323', '2019-03-22 21:21:24', '-36');
INSERT INTO `sensor_data` VALUES ('1009', 'BB0B', '113', '2019-03-22 21:21:25', '-35');
INSERT INTO `sensor_data` VALUES ('1010', 'BB11', '323', '2019-03-22 21:21:26', '-36');
INSERT INTO `sensor_data` VALUES ('1011', 'BB0B', '115', '2019-03-22 21:21:27', '-35');
INSERT INTO `sensor_data` VALUES ('1012', 'BB11', '323', '2019-03-22 21:21:28', '-36');

-- ----------------------------
-- Table structure for sensor_station
-- ----------------------------
DROP TABLE IF EXISTS `sensor_station`;
CREATE TABLE `sensor_station` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sensor_id` varchar(255) COLLATE utf8_bin NOT NULL,
  `sensor_addr` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `father_addr` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `x` double DEFAULT NULL,
  `y` double DEFAULT NULL,
  `isLeave` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`sensor_id`),
  KEY `sensor_id` (`sensor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of sensor_station
-- ----------------------------
INSERT INTO `sensor_station` VALUES ('1', '0000', '0000', '0000', '1', '2', '0');
INSERT INTO `sensor_station` VALUES ('8', 'BB11', '7776', '0000', '3', '4', '0');
INSERT INTO `sensor_station` VALUES ('9', 'BB0B', 'E319', '7776', '2', '2', '0');
