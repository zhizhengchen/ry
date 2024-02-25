/*
 Navicat Premium Data Transfer

 Source Server         : 本机数据库MySql_8.0.23
 Source Server Type    : MySQL
 Source Server Version : 80032
 Source Host           : localhost:3306
 Source Schema         : ry-vue

 Target Server Type    : MySQL
 Target Server Version : 80032
 File Encoding         : 65001

 Date: 25/02/2024 15:25:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sample
-- ----------------------------
DROP TABLE IF EXISTS `sample`;
CREATE TABLE `sample`  (
  `io_id` int NOT NULL AUTO_INCREMENT,
  `number` int NULL DEFAULT NULL,
  `sample_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `investigation_ship` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `voyage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sea_area` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `standing_position` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `x_coordinate` float NULL DEFAULT NULL,
  `y_coordinate` float NULL DEFAULT NULL,
  `detailed_address` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `end_depth` float NULL DEFAULT NULL,
  `heart_length` float NULL DEFAULT NULL,
  `storage_location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `preservation_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `remarks` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  PRIMARY KEY (`io_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 244 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
