/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80042
 Source Host           : localhost:3306
 Source Schema         : mybatis

 Target Server Type    : MySQL
 Target Server Version : 80042
 File Encoding         : 65001

 Date: 22/07/2025 16:15:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for backdown
-- ----------------------------
DROP TABLE IF EXISTS `backdown`;
CREATE TABLE `backdown`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `remarks` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备注',
  `is_deleted` int NOT NULL COMMENT '逻辑删除标记（0：显示；1：隐藏）',
  `customer_id` int NOT NULL COMMENT '客户ID',
  `retreat_time` date NOT NULL COMMENT '退住时间',
  `retreat_type` int NOT NULL COMMENT '退住类型 0-正常退住  1-死亡退住 2-保留床位',
  `retreat_reason` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '退住原因',
  `audit_status` int NOT NULL COMMENT '审批状态  0-已提交 1-同意  2-拒绝',
  `audit_person` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '审批人',
  `audit_time` date NULL DEFAULT NULL COMMENT '审批时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of backdown
-- ----------------------------
INSERT INTO `backdown` VALUES (1, '暂无', 0, 40, '2023-12-17', 2, '临时出院', 1, '1', '2023-12-18');
INSERT INTO `backdown` VALUES (2, NULL, 1, 39, '2023-12-19', 0, '康复出院', 0, NULL, NULL);
INSERT INTO `backdown` VALUES (3, NULL, 0, 33, '2023-12-20', 0, '', 2, '1', '2024-01-03');

-- ----------------------------
-- Table structure for bed
-- ----------------------------
DROP TABLE IF EXISTS `bed`;
CREATE TABLE `bed`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `room_no` int NOT NULL COMMENT '房间编号',
  `bed_status` int NOT NULL COMMENT '房间状态 1：空闲  2：有人  3：外出',
  `remarks` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备注',
  `bed_no` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '床位编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 53 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bed
-- ----------------------------
INSERT INTO `bed` VALUES (6, 1001, 2, NULL, '1001-1');
INSERT INTO `bed` VALUES (7, 1001, 1, NULL, '1001-2');
INSERT INTO `bed` VALUES (8, 1002, 1, NULL, '1002-1');
INSERT INTO `bed` VALUES (9, 1002, 2, NULL, '1002-2');
INSERT INTO `bed` VALUES (10, 1003, 1, NULL, '1003-1');
INSERT INTO `bed` VALUES (11, 1004, 2, NULL, '1004-1');
INSERT INTO `bed` VALUES (12, 1005, 1, NULL, '1005-1');
INSERT INTO `bed` VALUES (13, 1005, 2, NULL, '1005-2');
INSERT INTO `bed` VALUES (14, 1006, 1, NULL, '1006-1');
INSERT INTO `bed` VALUES (15, 1006, 2, NULL, '1006-2');
INSERT INTO `bed` VALUES (16, 1007, 1, NULL, '1007-1');
INSERT INTO `bed` VALUES (17, 1007, 1, NULL, '1007-2');
INSERT INTO `bed` VALUES (18, 1008, 1, NULL, '1008-1');
INSERT INTO `bed` VALUES (19, 1009, 1, NULL, '1009-1');
INSERT INTO `bed` VALUES (21, 1009, 1, NULL, '1009-2');
INSERT INTO `bed` VALUES (22, 1010, 2, NULL, '1010-1');
INSERT INTO `bed` VALUES (23, 1010, 1, NULL, '1010-2');
INSERT INTO `bed` VALUES (24, 1011, 1, NULL, '1011-1');
INSERT INTO `bed` VALUES (25, 1012, 1, NULL, '1012-1');
INSERT INTO `bed` VALUES (26, 1012, 2, NULL, '1012-2');
INSERT INTO `bed` VALUES (27, 1013, 1, NULL, '1013-1');
INSERT INTO `bed` VALUES (28, 1014, 2, NULL, '1014-1');
INSERT INTO `bed` VALUES (29, 1015, 1, NULL, '1015-1');
INSERT INTO `bed` VALUES (30, 1015, 1, NULL, '1015-2');
INSERT INTO `bed` VALUES (31, 1016, 1, NULL, '1016-1');
INSERT INTO `bed` VALUES (32, 1017, 2, NULL, '1017-1');
INSERT INTO `bed` VALUES (33, 1018, 1, NULL, '1018-1');
INSERT INTO `bed` VALUES (34, 2001, 1, NULL, '2001-1');
INSERT INTO `bed` VALUES (35, 2002, 2, NULL, '2002-1');
INSERT INTO `bed` VALUES (36, 2003, 1, NULL, '2003-1');
INSERT INTO `bed` VALUES (37, 2004, 1, NULL, '2004-1');
INSERT INTO `bed` VALUES (38, 2005, 2, NULL, '2005-1');
INSERT INTO `bed` VALUES (39, 2006, 1, NULL, '2006-1');
INSERT INTO `bed` VALUES (40, 2007, 1, NULL, '2007-1');
INSERT INTO `bed` VALUES (41, 2008, 1, NULL, '2008-1');
INSERT INTO `bed` VALUES (42, 2009, 1, NULL, '2009-1');
INSERT INTO `bed` VALUES (43, 2009, 1, NULL, '2009-2');
INSERT INTO `bed` VALUES (44, 2010, 1, NULL, '2010-1');
INSERT INTO `bed` VALUES (45, 2011, 1, NULL, '2011-1');
INSERT INTO `bed` VALUES (46, 2012, 1, NULL, '2012-1');
INSERT INTO `bed` VALUES (47, 2013, 1, NULL, '2013-1');
INSERT INTO `bed` VALUES (48, 2014, 2, NULL, '2014-1');
INSERT INTO `bed` VALUES (49, 2015, 1, NULL, '2015-1');
INSERT INTO `bed` VALUES (50, 2016, 1, NULL, '2016-1');
INSERT INTO `bed` VALUES (51, 2017, 2, NULL, '2017-1');
INSERT INTO `bed` VALUES (52, 2018, 2, NULL, '2018-1');

-- ----------------------------
-- Table structure for bed_details
-- ----------------------------
DROP TABLE IF EXISTS `bed_details`;
CREATE TABLE `bed_details`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `start_date` date NULL DEFAULT NULL COMMENT '床位起始日期',
  `end_date` date NULL DEFAULT NULL COMMENT '床位结束日期',
  `bed_details` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '床位详情信息',
  `customer_id` int NULL DEFAULT NULL COMMENT '顾客ID',
  `bed_id` int NULL DEFAULT NULL COMMENT '床位ID',
  `is_deleted` int NULL DEFAULT NULL COMMENT '逻辑删除标记（0：显示；1：隐藏）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 66 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bed_details
-- ----------------------------
INSERT INTO `bed_details` VALUES (45, '2023-11-17', '2025-11-30', '606#1001-1', 27, 6, 0);
INSERT INTO `bed_details` VALUES (46, '2023-11-17', '2024-11-30', '606#1002-2', 28, 9, 0);
INSERT INTO `bed_details` VALUES (49, '2023-11-17', '2023-11-23', '606#2001-1', 30, 34, 1);
INSERT INTO `bed_details` VALUES (50, '2023-11-17', '2025-11-27', '606#2002-1', 29, 35, 0);
INSERT INTO `bed_details` VALUES (51, '2023-11-17', '2025-11-29', '606#2017-1', 31, 51, 0);
INSERT INTO `bed_details` VALUES (52, '2023-11-17', '2023-11-21', '606#2015-1', 32, 49, 1);
INSERT INTO `bed_details` VALUES (53, '2023-11-17', '2024-11-29', '606#2014-1', 33, 48, 0);
INSERT INTO `bed_details` VALUES (54, '2023-11-17', '2025-01-30', '606#1006-2', 34, 15, 0);
INSERT INTO `bed_details` VALUES (55, '2023-11-17', '2024-11-30', '606#1017-1', 35, 32, 0);
INSERT INTO `bed_details` VALUES (56, '2023-11-17', '2025-11-26', '606#1010-1', 36, 22, 0);
INSERT INTO `bed_details` VALUES (57, '2023-11-17', '2025-11-20', '606#1012-2', 37, 26, 0);
INSERT INTO `bed_details` VALUES (58, '2023-11-17', '2025-11-29', '606#2005-1', 38, 38, 0);
INSERT INTO `bed_details` VALUES (59, '2023-11-17', '2024-11-30', '606#1014-1', 39, 28, 0);
INSERT INTO `bed_details` VALUES (60, '2023-11-17', '2025-11-29', '606#2012-1', 40, 46, 0);
INSERT INTO `bed_details` VALUES (61, '2023-11-21', '2024-01-15', '606#2016-1', 32, 50, 1);
INSERT INTO `bed_details` VALUES (62, '2023-11-23', '2025-12-31', '606#2018-1', 30, 52, 0);
INSERT INTO `bed_details` VALUES (63, '2024-01-03', '2024-02-03', '606#1004-1', 41, 11, 0);
INSERT INTO `bed_details` VALUES (64, '2024-01-03', '2024-02-16', '606#1005-1', 41, 12, 0);
INSERT INTO `bed_details` VALUES (65, '2024-01-15', '2027-11-12', '606#1005-2', 32, 13, 0);

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `is_deleted` int NOT NULL COMMENT '逻辑删除标记（0：显示；1：隐藏）',
  `customer_name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '客户姓名',
  `customer_age` int NOT NULL COMMENT '年龄',
  `customer_sex` int NOT NULL COMMENT '性别  0：男  1：女',
  `id_card` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '身份证号',
  `room_no` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '房间号',
  `building_no` varchar(11) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '所属楼房',
  `checkin_date` date NOT NULL COMMENT '入住时间',
  `expiration_date` date NOT NULL COMMENT '合同到期时间',
  `contact_tel` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '联系电话',
  `bed_id` int NOT NULL COMMENT '床号',
  `psychosomatic_state` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '身心状况',
  `attention` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '注意事项',
  `birthday` date NULL DEFAULT NULL COMMENT '出生日期',
  `height` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '身高',
  `weight` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '体重',
  `blood_type` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '血型',
  `file_path` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '头像路径',
  `user_id` int NULL DEFAULT NULL COMMENT '关联系统健康管家(护工)  无管家设置  -1',
  `level_id` int NULL DEFAULT NULL COMMENT '护理等级',
  `family_member` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '家属',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `nurselevel_customer_fk`(`level_id` ASC) USING BTREE,
  INDEX `user_customer_fk`(`user_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 42 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (27, 0, '张三', 76, 0, '610104194707211657', '1001', '606', '2023-11-17', '2025-11-30', '18176756743', 6, '', NULL, '1947-07-21', NULL, NULL, 'O', '@/assets/tou.png', -1, NULL, '刘其元');
INSERT INTO `customer` VALUES (28, 0, '李四', 83, 0, '610404194103010017', '1002', '606', '2023-11-17', '2024-11-30', '13767675481', 9, '', NULL, '1941-03-01', NULL, NULL, 'A', '@/assets/tou.png', 5, NULL, '高校蓝');
INSERT INTO `customer` VALUES (29, 0, '王五', 72, 1, '610402194112240335', '2002', '606', '2023-11-17', '2025-11-27', '13534786754', 35, '', NULL, '1951-12-24', NULL, NULL, 'B', '@/assets/tou.png', -1, NULL, '刘宇');
INSERT INTO `customer` VALUES (30, 0, '赵六', 73, 1, '610422195102220029', '2018', '606', '2023-11-17', '2025-12-31', '13867541321', 52, '', NULL, '1951-02-22', NULL, NULL, 'O', '@/assets/tou.png', 5, NULL, '石杰颖');
INSERT INTO `customer` VALUES (31, 0, '小红', 62, 1, '610402196111166507', '2017', '606', '2023-11-17', '2025-11-29', '18765652312', 51, '', NULL, '1961-11-16', NULL, NULL, 'O', '@/assets/tou.png', 3, NULL, '何方');
INSERT INTO `customer` VALUES (32, 0, '小蓝', 73, 1, '61040419501227002x', '1005', '606', '2023-11-17', '2027-11-12', '15816164587', 13, '', NULL, '1950-12-27', NULL, NULL, 'O', '@/assets/tou.png', 4, NULL, '毛参');
INSERT INTO `customer` VALUES (33, 0, '小紫', 83, 1, '622801194104150240', '2014', '606', '2023-11-17', '2024-11-29', '18176572345', 48, '', NULL, '1941-04-14', NULL, NULL, 'B', '@/assets/tou.png', -1, NULL, '李天');
INSERT INTO `customer` VALUES (34, 0, '小慧', 64, 0, '510522196005042710', '1006', '606', '2023-11-17', '2025-01-30', '18798986545', 15, '', NULL, '1960-05-04', NULL, NULL, 'O', '@/assets/tou.png', -1, NULL, '刘高');
INSERT INTO `customer` VALUES (35, 0, '小亮', 58, 0, '610402196511056517', '1017', '606', '2023-11-17', '2024-11-30', '13423786754', 32, '', NULL, '1965-11-05', NULL, NULL, 'AB', '@/assets/tou.png', 3, 4, '王田雨');
INSERT INTO `customer` VALUES (36, 0, '小玉', 72, 0, '610123195204158510', '1010', '606', '2023-11-17', '2025-11-26', '18767560987', 22, '', NULL, '1952-04-15', NULL, NULL, 'O', '@/assets/tou.png', 5, 1, '刘晓');
INSERT INTO `customer` VALUES (37, 0, '小陈', 68, 0, '61040219560313030x', '1012', '606', '2023-11-17', '2025-11-20', '18567546712', 26, '', NULL, '1956-03-13', NULL, NULL, 'O', '@/assets/tou.png', -1, NULL, '陈荣光');
INSERT INTO `customer` VALUES (38, 0, '小亚', 67, 1, '622725195701081429', '2005', '606', '2023-11-17', '2025-11-29', '18367541987', 38, '', NULL, '1957-01-08', NULL, NULL, 'A', '@/assets/tou.png', 3, NULL, '苗存义');
INSERT INTO `customer` VALUES (39, 0, '小东', 77, 0, '610402194701286518', '1014', '606', '2023-11-17', '2024-11-30', '17745189064', 28, '', NULL, '1947-01-28', NULL, NULL, 'O', '@/assets/tou.png', 2, 3, '张明');
INSERT INTO `customer` VALUES (40, 0, '小北', 68, 1, '610404195603010027', '2012', '606', '2023-11-17', '2025-11-29', '18167564213', 46, '', NULL, '1956-03-01', NULL, NULL, 'O', '@/assets/tou.png', 2, 2, '孙石');
INSERT INTO `customer` VALUES (41, 0, '许三多', 0, 0, '210330198902011510', '1004', '606', '2024-01-03', '2024-02-03', '13398760987', 11, '过敏', NULL, '2024-01-03', NULL, NULL, 'O', '@/assets/tou.png', 2, 1, '许多');

-- ----------------------------
-- Table structure for customer_nurse_item
-- ----------------------------
DROP TABLE IF EXISTS `customer_nurse_item`;
CREATE TABLE `customer_nurse_item`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `item_id` int NOT NULL COMMENT '护理项目编号',
  `customer_id` int NOT NULL COMMENT '客户编号',
  `level_id` int NULL DEFAULT NULL COMMENT '护理级别编号',
  `nurse_number` int NOT NULL COMMENT '购买数量',
  `is_deleted` int NULL DEFAULT NULL COMMENT '逻辑删除标记（0：显示；1：隐藏）',
  `buy_time` date NOT NULL COMMENT '服务购买日期',
  `maturity_time` date NOT NULL COMMENT '服务到期日',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 91 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of customer_nurse_item
-- ----------------------------
INSERT INTO `customer_nurse_item` VALUES (58, 1, 40, 2, -5, 0, '2023-10-17', '2024-01-17');
INSERT INTO `customer_nurse_item` VALUES (59, 2, 40, 2, 56, 0, '2023-10-17', '2023-11-16');
INSERT INTO `customer_nurse_item` VALUES (60, 3, 40, 2, 1, 0, '2023-10-17', '2024-01-17');
INSERT INTO `customer_nurse_item` VALUES (61, 4, 40, 2, 80, 0, '2023-10-17', '2023-11-28');
INSERT INTO `customer_nurse_item` VALUES (62, 1, 39, 3, 44, 0, '2023-10-17', '2024-01-17');
INSERT INTO `customer_nurse_item` VALUES (63, 2, 39, 3, 100, 0, '2023-10-17', '2024-01-17');
INSERT INTO `customer_nurse_item` VALUES (64, 3, 39, 3, 76, 0, '2023-10-17', '2024-01-17');
INSERT INTO `customer_nurse_item` VALUES (65, 5, 39, 3, 80, 1, '2023-10-17', '2024-01-17');
INSERT INTO `customer_nurse_item` VALUES (66, 6, 39, 3, 70, 1, '2023-10-17', '2024-01-17');
INSERT INTO `customer_nurse_item` VALUES (67, 1, 36, NULL, 40, 0, '2023-10-21', '2024-01-21');
INSERT INTO `customer_nurse_item` VALUES (68, 3, 36, NULL, 70, 0, '2023-10-21', '2024-01-21');
INSERT INTO `customer_nurse_item` VALUES (69, 4, 36, NULL, 70, 1, '2023-10-21', '2024-01-21');
INSERT INTO `customer_nurse_item` VALUES (70, 4, 36, NULL, 19, 0, '2023-10-21', '2024-01-21');
INSERT INTO `customer_nurse_item` VALUES (71, 20, 40, NULL, 17, 0, '2023-10-23', '2024-01-23');
INSERT INTO `customer_nurse_item` VALUES (72, 17, 40, NULL, 16, 0, '2023-10-23', '2024-01-23');
INSERT INTO `customer_nurse_item` VALUES (73, 10, 40, NULL, 10, 0, '2023-10-23', '2024-01-23');
INSERT INTO `customer_nurse_item` VALUES (74, 12, 40, NULL, 17, 0, '2023-10-23', '2024-01-23');
INSERT INTO `customer_nurse_item` VALUES (75, 1, 35, 4, 98, 0, '2023-10-24', '2024-01-24');
INSERT INTO `customer_nurse_item` VALUES (76, 2, 35, 4, 99, 0, '2023-10-24', '2024-01-24');
INSERT INTO `customer_nurse_item` VALUES (77, 3, 35, 4, 100, 0, '2023-10-24', '2024-01-24');
INSERT INTO `customer_nurse_item` VALUES (78, 5, 35, 4, 100, 0, '2023-10-24', '2024-01-24');
INSERT INTO `customer_nurse_item` VALUES (79, 1, 41, 1, 0, 0, '2023-12-03', '2024-02-01');
INSERT INTO `customer_nurse_item` VALUES (80, 2, 41, 1, 0, 0, '2023-12-03', '2024-03-03');
INSERT INTO `customer_nurse_item` VALUES (81, 4, 41, 1, 1, 0, '2023-12-03', '2024-03-03');
INSERT INTO `customer_nurse_item` VALUES (82, 5, 41, 1, 1, 0, '2023-12-03', '2024-03-03');
INSERT INTO `customer_nurse_item` VALUES (83, 6, 41, 1, 1, 0, '2023-12-03', '2024-03-03');
INSERT INTO `customer_nurse_item` VALUES (84, 20, 41, NULL, 1, 0, '2023-12-03', '2024-01-05');
INSERT INTO `customer_nurse_item` VALUES (85, 1, 36, 1, 1, 0, '2023-12-15', '2024-03-15');
INSERT INTO `customer_nurse_item` VALUES (86, 2, 36, 1, 1, 0, '2023-12-15', '2024-03-15');
INSERT INTO `customer_nurse_item` VALUES (87, 4, 36, 1, 1, 0, '2023-12-15', '2024-03-15');
INSERT INTO `customer_nurse_item` VALUES (88, 5, 36, 1, 1, 0, '2023-12-15', '2024-03-15');
INSERT INTO `customer_nurse_item` VALUES (89, 6, 36, 1, 1, 0, '2023-12-15', '2024-01-17');
INSERT INTO `customer_nurse_item` VALUES (90, 3, 41, NULL, 1, 0, '2023-12-15', '2024-01-17');

-- ----------------------------
-- Table structure for customer_preference
-- ----------------------------
DROP TABLE IF EXISTS `customer_preference`;
CREATE TABLE `customer_preference`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '喜好ID',
  `customer_id` int NULL DEFAULT NULL COMMENT '顾客ID',
  `preferences` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '饮食喜好',
  `attention` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '注意事项',
  `remark` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `is_deleted` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of customer_preference
-- ----------------------------
INSERT INTO `customer_preference` VALUES (1, 29, '不吃辣，爱吃青菜，不爱吃肉', '风湿', '不辣多肉', 0);
INSERT INTO `customer_preference` VALUES (2, 30, '爱吃甜品，不爱吃青菜，口味清淡', '糖尿病，轻度脂肪肝', '少糖，多青菜', 0);
INSERT INTO `customer_preference` VALUES (3, 31, '爱吃辣，不吃内脏，口味清淡', '支气管炎', '多糖，少盐', 0);
INSERT INTO `customer_preference` VALUES (9, 41, '多糖', '不建议摄入过多糖分', '尽量少糖', 0);

-- ----------------------------
-- Table structure for dietary
-- ----------------------------
DROP TABLE IF EXISTS `dietary`;
CREATE TABLE `dietary`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '膳食ID',
  `is_deleted` int NULL DEFAULT NULL COMMENT '删除标志',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '膳食类型',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '膳食名称',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `Islamic` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '清真',
  `picture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图片',
  `create_on` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of dietary
-- ----------------------------

-- ----------------------------
-- Table structure for dietary_calendar
-- ----------------------------
DROP TABLE IF EXISTS `dietary_calendar`;
CREATE TABLE `dietary_calendar`  (
  `id` int NOT NULL COMMENT '膳食日历ID',
  `dietary_id` int NULL DEFAULT NULL COMMENT '膳食编号',
  `dietary_type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '早餐中餐晚餐',
  `week_day` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '星期',
  `taste` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '口味（多糖、多盐、少糖、少盐）',
  `create_on` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of dietary_calendar
-- ----------------------------

-- ----------------------------
-- Table structure for food
-- ----------------------------
DROP TABLE IF EXISTS `food`;
CREATE TABLE `food`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '食品ID',
  `food_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '食品名称',
  `food_type` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '食品类型',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `is_halal` int NULL DEFAULT NULL COMMENT '是否清真',
  `food_img` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图片路径',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of food
-- ----------------------------
INSERT INTO `food` VALUES (1, '面包', '主食', 15.00, 0, 'bread.jpg');
INSERT INTO `food` VALUES (2, '白灼虾', '大荤', 20.00, 0, 'shrimp.jpg');
INSERT INTO `food` VALUES (3, '宫保鸡丁', '小荤', 20.00, 0, 'chicken.jpg');
INSERT INTO `food` VALUES (4, '白灼芥兰', '素材', 5.00, 0, 'arabidopsis.jpg');
INSERT INTO `food` VALUES (5, '素烩汤', '汤', 5.00, 0, 'chowder_soup.jpg');
INSERT INTO `food` VALUES (6, '小米粥', '主食', 3.00, 0, 'congee.jpg');
INSERT INTO `food` VALUES (7, '红烧牛肉', '大荤', 25.00, 1, 'beef.jpg');
INSERT INTO `food` VALUES (8, '燕麦粥', '主食', 5.00, 0, 'oatmeal.jpg');
INSERT INTO `food` VALUES (9, '欢喜坨', '主食', 10.00, 0, 'hxt.jpg');
INSERT INTO `food` VALUES (10, '清蒸鲈鱼', '大荤', 28.00, 0, 'steamed_fish.jpg');
INSERT INTO `food` VALUES (11, '凉拌木耳', '素菜', 8.00, 0, 'fungus.jpg');
INSERT INTO `food` VALUES (12, '水煮蛋', '蛋类', 2.00, 0, 'boiled_egg.jpg');
INSERT INTO `food` VALUES (13, '全麦面包', '主食', 18.00, 0, 'whole_wheat_bread.jpg');
INSERT INTO `food` VALUES (14, '番茄炒蛋', '小荤', 12.00, 0, 'tomato_egg.jpg');
INSERT INTO `food` VALUES (15, '清炒西兰花', '素菜', 10.00, 0, 'broccoli.jpg');
INSERT INTO `food` VALUES (16, '蒸红薯', '主食', 6.00, 0, 'sweet_potato.jpg');
INSERT INTO `food` VALUES (17, '酸奶', '饮品', 8.00, 0, 'yogurt.jpg');
INSERT INTO `food` VALUES (18, '香蕉', '水果', 4.00, 0, 'banana.jpg');
INSERT INTO `food` VALUES (19, '核桃仁', '坚果', 15.00, 0, 'walnut.jpg');
INSERT INTO `food` VALUES (20, '清蒸鲈鱼', '大荤', 28.00, 0, 'steamed_fish.jpg');
INSERT INTO `food` VALUES (21, '凉拌木耳', '素菜', 8.00, 0, 'fungus.jpg');
INSERT INTO `food` VALUES (22, '水煮蛋', '蛋类', 2.00, 0, 'boiled_egg.jpg');
INSERT INTO `food` VALUES (23, '全麦面包', '主食', 18.00, 0, 'whole_wheat_bread.jpg');
INSERT INTO `food` VALUES (24, '番茄炒蛋', '小荤', 12.00, 0, 'tomato_egg.jpg');
INSERT INTO `food` VALUES (25, '清炒西兰花', '素菜', 10.00, 0, 'broccoli.jpg');
INSERT INTO `food` VALUES (26, '蒸红薯', '主食', 6.00, 0, 'sweet_potato.jpg');
INSERT INTO `food` VALUES (27, '酸奶', '饮品', 8.00, 0, 'yogurt.jpg');
INSERT INTO `food` VALUES (28, '香蕉', '水果', 4.00, 0, 'banana.jpg');
INSERT INTO `food` VALUES (29, '核桃仁', '坚果', 15.00, 0, 'walnut.jpg');

-- ----------------------------
-- Table structure for food_health_tag
-- ----------------------------
DROP TABLE IF EXISTS `food_health_tag`;
CREATE TABLE `food_health_tag`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `food_id` int NOT NULL,
  `tag_id` int NOT NULL,
  `suitability` enum('RECOMMENDED','NEUTRAL','AVOID') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '推荐程度',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `food_id`(`food_id` ASC) USING BTREE,
  INDEX `tag_id`(`tag_id` ASC) USING BTREE,
  CONSTRAINT `food_health_tag_ibfk_1` FOREIGN KEY (`food_id`) REFERENCES `food` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `food_health_tag_ibfk_2` FOREIGN KEY (`tag_id`) REFERENCES `health_tag` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 117 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of food_health_tag
-- ----------------------------
INSERT INTO `food_health_tag` VALUES (1, 1, 2, 'AVOID');
INSERT INTO `food_health_tag` VALUES (2, 1, 4, 'AVOID');
INSERT INTO `food_health_tag` VALUES (3, 1, 6, 'NEUTRAL');
INSERT INTO `food_health_tag` VALUES (4, 2, 1, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (5, 2, 3, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (6, 2, 5, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (7, 3, 1, 'AVOID');
INSERT INTO `food_health_tag` VALUES (8, 3, 2, 'NEUTRAL');
INSERT INTO `food_health_tag` VALUES (9, 3, 3, 'AVOID');
INSERT INTO `food_health_tag` VALUES (10, 4, 1, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (11, 4, 2, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (12, 4, 4, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (13, 5, 1, 'NEUTRAL');
INSERT INTO `food_health_tag` VALUES (14, 5, 2, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (15, 5, 8, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (16, 6, 2, 'NEUTRAL');
INSERT INTO `food_health_tag` VALUES (17, 6, 4, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (18, 6, 6, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (19, 7, 1, 'AVOID');
INSERT INTO `food_health_tag` VALUES (20, 7, 3, 'AVOID');
INSERT INTO `food_health_tag` VALUES (21, 7, 5, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (22, 7, 7, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (23, 8, 2, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (24, 8, 4, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (25, 8, 6, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (26, 9, 2, 'AVOID');
INSERT INTO `food_health_tag` VALUES (27, 9, 4, 'AVOID');
INSERT INTO `food_health_tag` VALUES (28, 9, 6, 'AVOID');
INSERT INTO `food_health_tag` VALUES (29, 1, 1, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (30, 1, 3, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (31, 1, 5, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (32, 2, 1, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (33, 2, 2, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (34, 2, 4, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (35, 3, 5, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (36, 3, 4, 'NEUTRAL');
INSERT INTO `food_health_tag` VALUES (37, 3, 3, 'NEUTRAL');
INSERT INTO `food_health_tag` VALUES (38, 4, 6, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (39, 4, 4, 'NEUTRAL');
INSERT INTO `food_health_tag` VALUES (40, 4, 2, 'NEUTRAL');
INSERT INTO `food_health_tag` VALUES (41, 5, 5, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (42, 5, 1, 'NEUTRAL');
INSERT INTO `food_health_tag` VALUES (43, 5, 2, 'NEUTRAL');
INSERT INTO `food_health_tag` VALUES (44, 6, 1, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (45, 6, 2, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (46, 6, 4, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (47, 7, 6, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (48, 7, 4, 'NEUTRAL');
INSERT INTO `food_health_tag` VALUES (49, 7, 2, 'NEUTRAL');
INSERT INTO `food_health_tag` VALUES (50, 8, 5, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (51, 8, 2, 'NEUTRAL');
INSERT INTO `food_health_tag` VALUES (52, 8, 4, 'NEUTRAL');
INSERT INTO `food_health_tag` VALUES (53, 9, 2, 'NEUTRAL');
INSERT INTO `food_health_tag` VALUES (54, 9, 6, 'NEUTRAL');
INSERT INTO `food_health_tag` VALUES (55, 9, 4, 'NEUTRAL');
INSERT INTO `food_health_tag` VALUES (56, 10, 3, 'AVOID');
INSERT INTO `food_health_tag` VALUES (57, 10, 4, 'AVOID');
INSERT INTO `food_health_tag` VALUES (58, 10, 5, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (59, 1, 2, 'AVOID');
INSERT INTO `food_health_tag` VALUES (60, 1, 4, 'AVOID');
INSERT INTO `food_health_tag` VALUES (61, 1, 6, 'NEUTRAL');
INSERT INTO `food_health_tag` VALUES (62, 2, 1, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (63, 2, 3, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (64, 2, 5, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (65, 3, 1, 'AVOID');
INSERT INTO `food_health_tag` VALUES (66, 3, 2, 'NEUTRAL');
INSERT INTO `food_health_tag` VALUES (67, 3, 3, 'AVOID');
INSERT INTO `food_health_tag` VALUES (68, 4, 1, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (69, 4, 2, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (70, 4, 4, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (71, 5, 1, 'NEUTRAL');
INSERT INTO `food_health_tag` VALUES (72, 5, 2, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (73, 5, 8, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (74, 6, 2, 'NEUTRAL');
INSERT INTO `food_health_tag` VALUES (75, 6, 4, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (76, 6, 6, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (77, 7, 1, 'AVOID');
INSERT INTO `food_health_tag` VALUES (78, 7, 3, 'AVOID');
INSERT INTO `food_health_tag` VALUES (79, 7, 5, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (80, 7, 7, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (81, 8, 2, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (82, 8, 4, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (83, 8, 6, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (84, 9, 2, 'AVOID');
INSERT INTO `food_health_tag` VALUES (85, 9, 4, 'AVOID');
INSERT INTO `food_health_tag` VALUES (86, 9, 6, 'AVOID');
INSERT INTO `food_health_tag` VALUES (87, 11, 1, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (88, 11, 3, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (89, 11, 5, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (90, 12, 1, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (91, 12, 2, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (92, 12, 4, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (93, 13, 5, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (94, 13, 4, 'NEUTRAL');
INSERT INTO `food_health_tag` VALUES (95, 13, 3, 'NEUTRAL');
INSERT INTO `food_health_tag` VALUES (96, 14, 6, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (97, 14, 4, 'NEUTRAL');
INSERT INTO `food_health_tag` VALUES (98, 14, 2, 'NEUTRAL');
INSERT INTO `food_health_tag` VALUES (99, 15, 5, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (100, 15, 1, 'NEUTRAL');
INSERT INTO `food_health_tag` VALUES (101, 15, 2, 'NEUTRAL');
INSERT INTO `food_health_tag` VALUES (102, 16, 1, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (103, 16, 2, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (104, 16, 4, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (105, 17, 6, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (106, 17, 4, 'NEUTRAL');
INSERT INTO `food_health_tag` VALUES (107, 17, 2, 'NEUTRAL');
INSERT INTO `food_health_tag` VALUES (108, 18, 5, 'RECOMMENDED');
INSERT INTO `food_health_tag` VALUES (109, 18, 2, 'NEUTRAL');
INSERT INTO `food_health_tag` VALUES (110, 18, 4, 'NEUTRAL');
INSERT INTO `food_health_tag` VALUES (111, 19, 2, 'NEUTRAL');
INSERT INTO `food_health_tag` VALUES (112, 19, 6, 'NEUTRAL');
INSERT INTO `food_health_tag` VALUES (113, 19, 4, 'NEUTRAL');
INSERT INTO `food_health_tag` VALUES (114, 20, 3, 'AVOID');
INSERT INTO `food_health_tag` VALUES (115, 20, 4, 'AVOID');
INSERT INTO `food_health_tag` VALUES (116, 20, 5, 'RECOMMENDED');

-- ----------------------------
-- Table structure for health_tag
-- ----------------------------
DROP TABLE IF EXISTS `health_tag`;
CREATE TABLE `health_tag`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '健康标签名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标签描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of health_tag
-- ----------------------------
INSERT INTO `health_tag` VALUES (1, '高血压', '需要控制钠摄入量');
INSERT INTO `health_tag` VALUES (2, '糖尿病', '需要控制糖分和碳水化合物摄入');
INSERT INTO `health_tag` VALUES (3, '高血脂', '需要控制脂肪摄入');
INSERT INTO `health_tag` VALUES (4, '减重', '需要控制热量摄入');
INSERT INTO `health_tag` VALUES (5, '高蛋白', '需要增加蛋白质摄入');
INSERT INTO `health_tag` VALUES (6, '低GI', '适合需要控制血糖波动的饮食');
INSERT INTO `health_tag` VALUES (7, '清真', '符合伊斯兰教饮食规定');
INSERT INTO `health_tag` VALUES (8, '素食', '不含肉类成分');
INSERT INTO `health_tag` VALUES (9, '高血压', '需要控制钠摄入量');
INSERT INTO `health_tag` VALUES (10, '糖尿病', '需要控制糖分和碳水化合物摄入');
INSERT INTO `health_tag` VALUES (11, '高血脂', '需要控制脂肪摄入');
INSERT INTO `health_tag` VALUES (12, '减重', '需要控制热量摄入');
INSERT INTO `health_tag` VALUES (13, '高蛋白', '需要增加蛋白质摄入');
INSERT INTO `health_tag` VALUES (14, '低GI', '适合需要控制血糖波动的饮食');
INSERT INTO `health_tag` VALUES (15, '清真', '符合伊斯兰教饮食规定');
INSERT INTO `health_tag` VALUES (16, '素食', '不含肉类成分');

-- ----------------------------
-- Table structure for meal
-- ----------------------------
DROP TABLE IF EXISTS `meal`;
CREATE TABLE `meal`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '饮食ID',
  `week_day` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '星期几',
  `food_id` int NULL DEFAULT NULL COMMENT '食品ID',
  `meal_type` int NULL DEFAULT NULL COMMENT '食品类型（1.早餐、2.午餐、3.晚餐）',
  `taste` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '口味（多糖、多盐、少糖、少盐）',
  `is_deleted` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 93 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of meal
-- ----------------------------
INSERT INTO `meal` VALUES (2, '周二', 1, 2, '多糖', 0);
INSERT INTO `meal` VALUES (3, '周一', 1, 1, '多糖', 0);
INSERT INTO `meal` VALUES (7, '周一', 7, 2, '少盐', 0);
INSERT INTO `meal` VALUES (8, '周一', 3, 2, '多盐', 0);
INSERT INTO `meal` VALUES (16, '周一', 6, 3, '少盐', 0);
INSERT INTO `meal` VALUES (22, '周二', 2, 2, '少糖', 0);
INSERT INTO `meal` VALUES (23, '周二', 1, 1, '多糖', 0);
INSERT INTO `meal` VALUES (24, '周二', 5, 1, '正常', 0);
INSERT INTO `meal` VALUES (26, '周二', 9, 2, '少糖', 0);
INSERT INTO `meal` VALUES (27, '周二', 8, 3, '多糖', 0);
INSERT INTO `meal` VALUES (28, '周二', 2, 3, '少糖', 0);
INSERT INTO `meal` VALUES (29, '周二', 3, 2, '少盐', 0);
INSERT INTO `meal` VALUES (32, '周二', 3, 3, '多盐', 0);
INSERT INTO `meal` VALUES (33, '周二', 1, 3, '少糖', 0);
INSERT INTO `meal` VALUES (34, '周三', 6, 1, '正常', 0);
INSERT INTO `meal` VALUES (35, '周三', 7, 3, '正常', 0);
INSERT INTO `meal` VALUES (36, '周三', 8, 3, '少糖', 0);
INSERT INTO `meal` VALUES (37, '周三', 9, 2, '多糖', 0);
INSERT INTO `meal` VALUES (39, '周三', 1, 3, '少盐', 0);
INSERT INTO `meal` VALUES (40, '周三', 2, 3, '正常', 0);
INSERT INTO `meal` VALUES (41, '周三', 3, 2, '正常', 0);
INSERT INTO `meal` VALUES (42, '周四', 5, 2, '少盐', 0);
INSERT INTO `meal` VALUES (43, '周四', 2, 1, '正常', 0);
INSERT INTO `meal` VALUES (44, '周四', 6, 1, '正常', 0);
INSERT INTO `meal` VALUES (45, '周四', 1, 2, '少糖', 0);
INSERT INTO `meal` VALUES (47, '周四', 7, 3, '少糖', 0);
INSERT INTO `meal` VALUES (48, '周四', 3, 3, '多盐', 0);
INSERT INTO `meal` VALUES (49, '周五', 5, 2, '少糖', 0);
INSERT INTO `meal` VALUES (50, '周五', 2, 2, '少盐', 0);
INSERT INTO `meal` VALUES (52, '周五', 8, 3, '正常', 0);
INSERT INTO `meal` VALUES (55, '周五', 5, 1, '正常', 0);
INSERT INTO `meal` VALUES (56, '周六', 9, 2, '少糖', 0);
INSERT INTO `meal` VALUES (57, '周六', 8, 3, '多糖', 0);
INSERT INTO `meal` VALUES (58, '周六', 2, 3, '少糖', 0);
INSERT INTO `meal` VALUES (59, '周六', 3, 2, '少盐', 0);
INSERT INTO `meal` VALUES (60, '周六', 5, 1, '多盐', 0);
INSERT INTO `meal` VALUES (62, '周六', 3, 3, '多盐', 0);
INSERT INTO `meal` VALUES (63, '周六', 1, 3, '少糖', 0);
INSERT INTO `meal` VALUES (64, '周日', 6, 2, '正常', 0);
INSERT INTO `meal` VALUES (65, '周日', 3, 3, '正常', 0);
INSERT INTO `meal` VALUES (66, '周日', 8, 3, '少糖', 0);
INSERT INTO `meal` VALUES (67, '周日', 9, 2, '多糖', 0);
INSERT INTO `meal` VALUES (70, '周日', 2, 3, '正常', 0);
INSERT INTO `meal` VALUES (72, '周一', 8, 1, '多糖', 0);
INSERT INTO `meal` VALUES (73, '周一', 1, 3, '多糖', 0);
INSERT INTO `meal` VALUES (75, '周日', 1, 1, '多糖', 0);
INSERT INTO `meal` VALUES (76, '周日', 6, 1, '少盐', 0);
INSERT INTO `meal` VALUES (78, '周一', 2, 1, '多糖', 0);
INSERT INTO `meal` VALUES (79, '周一', 9, 1, '多糖', 0);
INSERT INTO `meal` VALUES (80, '周一', 4, 1, '多糖', 0);
INSERT INTO `meal` VALUES (81, '周六', 2, 1, '多糖', 0);
INSERT INTO `meal` VALUES (83, '周六', 5, 1, '多糖', 0);
INSERT INTO `meal` VALUES (91, '周五', 1, 1, '正常', 0);
INSERT INTO `meal` VALUES (92, '周五', 5, 1, '少盐', 0);

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menus_index` varchar(5) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '一级菜单索引',
  `title` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '菜单标题',
  `icon` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '菜单图标',
  `path` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '菜单路径',
  `parent_id` int NULL DEFAULT NULL COMMENT '父级Id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '1', '床位管理', 'Operation', NULL, 0);
INSERT INTO `menu` VALUES (2, '2', '客户管理', 'User', NULL, 0);
INSERT INTO `menu` VALUES (4, '4', '护理管理', 'SuitcaseLine', NULL, 0);
INSERT INTO `menu` VALUES (5, '5', '健康管家', 'Coin', NULL, 0);
INSERT INTO `menu` VALUES (6, '6', '用户管理', 'Avatar', NULL, 0);
INSERT INTO `menu` VALUES (7, NULL, '床位示意图', 'Picture', '/bed/bedMap', 1);
INSERT INTO `menu` VALUES (8, NULL, '床位管理', 'Collection', '/bed/bedManage', 1);
INSERT INTO `menu` VALUES (9, NULL, '入住登记', 'DArrowRight', '/customer/checkIn', 2);
INSERT INTO `menu` VALUES (11, NULL, '退住登记', 'DArrowLeft', '/customer/checkOut', 2);
INSERT INTO `menu` VALUES (12, NULL, '外出登记', 'Location', '/customer/outRecords', 2);
INSERT INTO `menu` VALUES (17, NULL, '护理级别', 'Sort', '/nurse/nurseLevel', 4);
INSERT INTO `menu` VALUES (18, NULL, '护理项目', 'ZoomIn', '/nurse/nurseItem', 4);
INSERT INTO `menu` VALUES (19, NULL, '客户护理设置', 'Setting', '/nurse/nurseSetting', 4);
INSERT INTO `menu` VALUES (20, NULL, '护理记录', 'ScaleToOriginal', '/nurse/nurseRecords', 4);
INSERT INTO `menu` VALUES (21, NULL, '设置服务对象', 'Setting', '/health/serviceCustomerSetting', 5);
INSERT INTO `menu` VALUES (22, '2', '健康管家', 'Coin', NULL, 0);
INSERT INTO `menu` VALUES (23, NULL, '日常护理', 'Help', '/health/dailyNurse', 22);
INSERT INTO `menu` VALUES (24, NULL, '服务关注', 'View', '/health/serviceCare', 5);
INSERT INTO `menu` VALUES (25, NULL, '基础数据维护', 'List', '/user/listUser', 6);
INSERT INTO `menu` VALUES (26, '1', '客户管理', 'User', NULL, 0);
INSERT INTO `menu` VALUES (27, NULL, '外出登记', 'Location', '/customer/outRecords', 26);
INSERT INTO `menu` VALUES (28, NULL, '退住登记', 'DArrowLeft', '/customer/checkOut', 26);
INSERT INTO `menu` VALUES (29, NULL, '护理记录', 'ScaleToOriginal', '/nurse/nurseRecordsToUser', 22);
INSERT INTO `menu` VALUES (30, NULL, '膳食管理', 'Setting', '/customer/preference', 2);
INSERT INTO `menu` VALUES (31, NULL, '膳食日历', 'Picture', '/customer/meal', 2);
INSERT INTO `menu` VALUES (32, '71', '健康饮食推荐', 'KnifeFork', NULL, 29);
INSERT INTO `menu` VALUES (33, '71', '健康饮食推荐', 'KnifeFork', '/recommend/food', 87);

-- ----------------------------
-- Table structure for nurse_content
-- ----------------------------
DROP TABLE IF EXISTS `nurse_content`;
CREATE TABLE `nurse_content`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `serial_number` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '编号',
  `nursing_name` varchar(55) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '名称',
  `service_price` varchar(55) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '价格',
  `message` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT ' 描述',
  `status` int NOT NULL COMMENT '状态 1：启用；2：停用',
  `execution_cycle` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '执行周期',
  `execution_times` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '执行次数',
  `is_deleted` int NULL DEFAULT NULL COMMENT '逻辑删除标记（0：显示；1：隐藏）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of nurse_content
-- ----------------------------
INSERT INTO `nurse_content` VALUES (1, 'HLXM0001', '吸氧', '60元/次', '', 1, '每天', '2', 0);
INSERT INTO `nurse_content` VALUES (2, 'HLXM0002', '协助服药', '免费', '', 1, '每天', '3', 0);
INSERT INTO `nurse_content` VALUES (3, 'HLXM0003', '测量血压', '免费', '', 1, '每天', '1', 0);
INSERT INTO `nurse_content` VALUES (4, 'HLXM0004', '协助穿衣', '10元/次', NULL, 1, '每天', '2', 0);
INSERT INTO `nurse_content` VALUES (5, 'HLXM0005', '床上洗头', '20元/次', NULL, 1, '每周', '3', 0);
INSERT INTO `nurse_content` VALUES (6, 'HLXM0006', '健身', '10元/小时', '', 1, '每天', '1', 0);
INSERT INTO `nurse_content` VALUES (7, 'HLXM0007', '清洁床铺', '10元/次', '', 1, '每周', '2', 0);
INSERT INTO `nurse_content` VALUES (8, 'HLXM0008', '如厕服务', '20元/次', '', 1, '每天', '2', 0);
INSERT INTO `nurse_content` VALUES (9, 'HLXM0009', '口腔清洁', '50元/次', '', 1, '每月', '2', 0);
INSERT INTO `nurse_content` VALUES (10, 'HLXM0010', '假牙清洁', '20元/次', '', 1, '每周', '2', 0);
INSERT INTO `nurse_content` VALUES (12, 'HLXM0012', '擦拭身体', '20元/次', '', 1, '每天', '1', 0);
INSERT INTO `nurse_content` VALUES (14, 'HLXM0014', '体温测量', '免费', '', 1, '每天', '1', 0);
INSERT INTO `nurse_content` VALUES (15, 'HLXM0015', '协助饮食', '50元/次', '', 2, '每天', '3', 0);
INSERT INTO `nurse_content` VALUES (16, 'HLXM0016', '血压测量', '免费', '', 2, '每天', '1', 1);
INSERT INTO `nurse_content` VALUES (17, 'HLXM0017', '剪指甲', '12/次', '', 1, '每月', '2', 0);
INSERT INTO `nurse_content` VALUES (20, 'HLXM0019', '协助外出', '100/次', '', 1, '每月', '4', 0);
INSERT INTO `nurse_content` VALUES (21, 'HLXM0020', '瑜伽辅导', '80/次', '', 2, '每周', '2', 0);

-- ----------------------------
-- Table structure for nurse_level
-- ----------------------------
DROP TABLE IF EXISTS `nurse_level`;
CREATE TABLE `nurse_level`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `level_name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '护理级别',
  `level_status` int NULL DEFAULT NULL COMMENT '级别状态 1：启用；2：停用',
  `is_deleted` int NULL DEFAULT NULL COMMENT '逻辑删除标记（0：显示；1：隐藏）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of nurse_level
-- ----------------------------
INSERT INTO `nurse_level` VALUES (1, '一级', 1, NULL);
INSERT INTO `nurse_level` VALUES (2, '二级', 1, NULL);
INSERT INTO `nurse_level` VALUES (3, '三级', 1, NULL);
INSERT INTO `nurse_level` VALUES (4, '四级', 1, NULL);
INSERT INTO `nurse_level` VALUES (5, '五级', 2, NULL);
INSERT INTO `nurse_level` VALUES (7, '六级', 2, NULL);
INSERT INTO `nurse_level` VALUES (8, 'x', 1, NULL);
INSERT INTO `nurse_level` VALUES (9, '八级', 1, NULL);

-- ----------------------------
-- Table structure for nurse_level_item
-- ----------------------------
DROP TABLE IF EXISTS `nurse_level_item`;
CREATE TABLE `nurse_level_item`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `level_id` int NOT NULL COMMENT '关联护理级别',
  `item_id` int NOT NULL COMMENT '关联护理项目',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `nurselevel_id_fk`(`level_id` ASC) USING BTREE,
  INDEX `nurseItem_id_fk`(`item_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 92 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of nurse_level_item
-- ----------------------------
INSERT INTO `nurse_level_item` VALUES (23, 1, 2);
INSERT INTO `nurse_level_item` VALUES (25, 1, 4);
INSERT INTO `nurse_level_item` VALUES (28, 2, 1);
INSERT INTO `nurse_level_item` VALUES (29, 2, 2);
INSERT INTO `nurse_level_item` VALUES (39, 3, 2);
INSERT INTO `nurse_level_item` VALUES (40, 3, 3);
INSERT INTO `nurse_level_item` VALUES (41, 3, 5);
INSERT INTO `nurse_level_item` VALUES (53, 4, 1);
INSERT INTO `nurse_level_item` VALUES (54, 4, 2);
INSERT INTO `nurse_level_item` VALUES (55, 4, 3);
INSERT INTO `nurse_level_item` VALUES (63, 1, 5);
INSERT INTO `nurse_level_item` VALUES (71, 4, 5);
INSERT INTO `nurse_level_item` VALUES (72, 3, 1);
INSERT INTO `nurse_level_item` VALUES (73, 3, 6);
INSERT INTO `nurse_level_item` VALUES (74, 1, 6);
INSERT INTO `nurse_level_item` VALUES (76, 8, 2);
INSERT INTO `nurse_level_item` VALUES (77, 8, 3);
INSERT INTO `nurse_level_item` VALUES (78, 8, 14);
INSERT INTO `nurse_level_item` VALUES (79, 9, 2);
INSERT INTO `nurse_level_item` VALUES (80, 9, 4);
INSERT INTO `nurse_level_item` VALUES (82, 9, 1);
INSERT INTO `nurse_level_item` VALUES (83, 2, 3);
INSERT INTO `nurse_level_item` VALUES (87, 2, 5);
INSERT INTO `nurse_level_item` VALUES (91, 1, 1);

-- ----------------------------
-- Table structure for nurse_record
-- ----------------------------
DROP TABLE IF EXISTS `nurse_record`;
CREATE TABLE `nurse_record`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `is_deleted` int NOT NULL COMMENT '逻辑删除标记（0：显示；1：隐藏）',
  `customer_id` int NOT NULL COMMENT '客户ID',
  `item_id` int NOT NULL COMMENT '护理项目ID',
  `nursing_time` datetime NOT NULL COMMENT '护理时间',
  `nursing_content` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '护理内容',
  `nursing_count` int NOT NULL COMMENT '护理数量',
  `user_id` int NOT NULL COMMENT '护理人员ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of nurse_record
-- ----------------------------
INSERT INTO `nurse_record` VALUES (9, 0, 40, 3, '2023-11-24 13:36:56', '日常血压测量', 1, 2);
INSERT INTO `nurse_record` VALUES (10, 0, 40, 17, '2023-11-24 13:37:18', '指甲修剪金和保养', 1, 2);
INSERT INTO `nurse_record` VALUES (11, 1, 40, 20, '2023-11-24 13:37:55', '陪同外出购物', 1, 2);
INSERT INTO `nurse_record` VALUES (12, 0, 35, 2, '2023-11-24 13:38:37', '按照医嘱进行喂药', 1, 3);
INSERT INTO `nurse_record` VALUES (13, 0, 35, 1, '2023-11-24 13:39:22', '仪器型号：XY09,吸氧服务', 1, 3);
INSERT INTO `nurse_record` VALUES (14, 0, 39, 1, '2023-11-24 18:05:24', '吸氧护理', 1, 2);
INSERT INTO `nurse_record` VALUES (15, 0, 40, 3, '2024-01-03 00:00:00', '测量血压', 1, 2);
INSERT INTO `nurse_record` VALUES (16, 0, 41, 1, '2024-01-16 00:00:00', '', 1, 2);
INSERT INTO `nurse_record` VALUES (17, 0, 41, 2, '2024-05-20 00:00:00', '协助服药', 1, 2);

-- ----------------------------
-- Table structure for outward
-- ----------------------------
DROP TABLE IF EXISTS `outward`;
CREATE TABLE `outward`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `remarks` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备注',
  `is_deleted` int NOT NULL COMMENT '逻辑删除标记（0：显示；1：隐藏）',
  `customer_id` int NOT NULL COMMENT '客户ID',
  `outgoing_reason` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '外出事由',
  `outgoing_time` date NOT NULL COMMENT '外出时间',
  `expected_return_time` date NOT NULL COMMENT '预计回院时间',
  `actual_return_time` date NULL DEFAULT NULL COMMENT '实际回院时间',
  `escorted` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '陪同人',
  `relation` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '与老人关系',
  `escorted_tel` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '陪同人电话',
  `audit_status` int NOT NULL COMMENT '审批状态  0-已提交 1-同意  2-拒绝',
  `audit_person` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '审批人',
  `audit_time` date NULL DEFAULT NULL COMMENT '审批时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of outward
-- ----------------------------
INSERT INTO `outward` VALUES (1, NULL, 0, 40, '想家', '2023-12-17', '2023-12-20', NULL, '女儿', '母女', '13312341234', 1, '1', '2023-12-18');
INSERT INTO `outward` VALUES (2, NULL, 0, 33, '出门', '2023-12-17', '2023-12-19', NULL, '儿子', NULL, '13812341234', 2, NULL, NULL);
INSERT INTO `outward` VALUES (3, NULL, 1, 33, '出门', '2023-12-17', '2023-12-20', '2023-12-29', '儿子', NULL, '13812341234', 0, NULL, NULL);
INSERT INTO `outward` VALUES (4, NULL, 1, 33, '出门', '2023-12-18', '2023-12-20', NULL, '儿子', NULL, '13312341234', 0, NULL, NULL);
INSERT INTO `outward` VALUES (5, NULL, 0, 40, '外出业务', '2024-01-03', '2024-01-06', '2024-01-07', '儿子', NULL, '13819870987', 1, '1', '2024-01-03');
INSERT INTO `outward` VALUES (6, NULL, 0, 39, '回家', '2024-01-15', '2024-01-17', NULL, '儿子', NULL, '13312341234', 0, '', NULL);
INSERT INTO `outward` VALUES (7, NULL, 0, 41, '回家探亲', '2024-05-20', '2024-05-22', '2024-05-20', '女儿', NULL, '13312341234', 1, '1', '2024-05-20');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime(6) NOT NULL COMMENT '创建时间',
  `update_time` datetime(6) NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` int NULL DEFAULT NULL COMMENT '更新人',
  `is_deleted` int NOT NULL COMMENT '逻辑删除标记（0：显示；1：隐藏）',
  `name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '系统角色名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '2023-11-01 17:13:16.000000', NULL, NULL, 0, '系统管理员');
INSERT INTO `role` VALUES (2, '2023-11-01 17:13:13.000000', NULL, NULL, 0, '健康管家');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` int NOT NULL COMMENT '角色编号',
  `menu` int NOT NULL COMMENT '菜单编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES (1, 1, 1);
INSERT INTO `role_menu` VALUES (2, 1, 2);
INSERT INTO `role_menu` VALUES (3, 1, 3);
INSERT INTO `role_menu` VALUES (4, 1, 4);
INSERT INTO `role_menu` VALUES (5, 1, 5);
INSERT INTO `role_menu` VALUES (6, 1, 6);
INSERT INTO `role_menu` VALUES (7, 2, 26);
INSERT INTO `role_menu` VALUES (8, 2, 22);
INSERT INTO `role_menu` VALUES (9, 1, 7);
INSERT INTO `role_menu` VALUES (10, 1, 71);
INSERT INTO `role_menu` VALUES (11, 1, 7);
INSERT INTO `role_menu` VALUES (12, 1, 71);

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `room_floor` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '房间楼层',
  `room_no` int NOT NULL COMMENT '房间编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES (1, '一楼', 1001);
INSERT INTO `room` VALUES (2, '一楼', 1002);
INSERT INTO `room` VALUES (3, '一楼', 1003);
INSERT INTO `room` VALUES (4, '一楼', 1004);
INSERT INTO `room` VALUES (5, '一楼', 1005);
INSERT INTO `room` VALUES (6, '一楼', 1006);
INSERT INTO `room` VALUES (7, '一楼', 1007);
INSERT INTO `room` VALUES (8, '一楼', 1008);
INSERT INTO `room` VALUES (9, '一楼', 1009);
INSERT INTO `room` VALUES (10, '一楼', 1010);
INSERT INTO `room` VALUES (11, '一楼', 1011);
INSERT INTO `room` VALUES (12, '一楼', 1012);
INSERT INTO `room` VALUES (13, '一楼', 1013);
INSERT INTO `room` VALUES (14, '一楼', 1014);
INSERT INTO `room` VALUES (15, '一楼', 1015);
INSERT INTO `room` VALUES (16, '一楼', 1016);
INSERT INTO `room` VALUES (17, '一楼', 1017);
INSERT INTO `room` VALUES (18, '一楼', 1018);
INSERT INTO `room` VALUES (19, '二楼', 2001);
INSERT INTO `room` VALUES (20, '二楼', 2002);
INSERT INTO `room` VALUES (21, '二楼', 2003);
INSERT INTO `room` VALUES (22, '二楼', 2004);
INSERT INTO `room` VALUES (23, '二楼', 2005);
INSERT INTO `room` VALUES (24, '二楼', 2006);
INSERT INTO `room` VALUES (25, '二楼', 2007);
INSERT INTO `room` VALUES (26, '二楼', 2008);
INSERT INTO `room` VALUES (27, '二楼', 2009);
INSERT INTO `room` VALUES (28, '二楼', 2010);
INSERT INTO `room` VALUES (29, '二楼', 2011);
INSERT INTO `room` VALUES (30, '二楼', 2012);
INSERT INTO `room` VALUES (31, '二楼', 2013);
INSERT INTO `room` VALUES (32, '二楼', 2014);
INSERT INTO `room` VALUES (33, '二楼', 2015);
INSERT INTO `room` VALUES (34, '二楼', 2016);
INSERT INTO `room` VALUES (35, '二楼', 2017);
INSERT INTO `room` VALUES (36, '二楼', 2018);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` date NOT NULL COMMENT '创建时间',
  `create_by` int NOT NULL COMMENT '创建者',
  `update_time` date NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` int NULL DEFAULT NULL COMMENT '更新者',
  `is_deleted` int NOT NULL COMMENT '逻辑删除标记（0：显示；1：隐藏）',
  `nick_name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '真实姓名',
  `user_name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '系统账号',
  `password` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '密码',
  `sex` int NOT NULL COMMENT '性别（0：女  1：男）',
  `email` varchar(254) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `phone_number` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '电话号码',
  `role_id` int NOT NULL COMMENT '系统角色编号（1-管理员 2-健康管家）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '2023-11-02', 0, '2023-11-02', 0, 0, 'admin', 'admin', 'admin', 1, 'zhangxing@s.cq', '13545453412', 1);
INSERT INTO `user` VALUES (2, '2023-11-03', 0, '2023-11-03', 0, 0, '11', '111', '111', 1, '11@s.cq', '13517178987', 2);
INSERT INTO `user` VALUES (3, '2023-11-21', 0, '2023-11-21', 0, 0, '22', '222', '222', 0, '22@s.cq', '18767890987', 2);
INSERT INTO `user` VALUES (4, '2023-11-21', 0, '2023-11-21', 0, 0, '33', '333', '333', 1, '33@s.cq', '18878675643', 2);
INSERT INTO `user` VALUES (5, '2023-11-21', 0, '2023-11-21', 0, 0, '44', '444', '444', 0, '44@s.cq', '13412128976', 2);
INSERT INTO `user` VALUES (6, '2023-11-21', 0, '2023-11-21', 0, 0, '55', '555', '555', 0, '55@s.cq', '13567452789', 2);

SET FOREIGN_KEY_CHECKS = 1;
