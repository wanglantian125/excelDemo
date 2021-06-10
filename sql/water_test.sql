/*
 Navicat Premium Data Transfer

 Source Server         : 本地数据库
 Source Server Type    : MySQL
 Source Server Version : 50713
 Source Host           : localhost:3306
 Source Schema         : citywater

 Target Server Type    : MySQL
 Target Server Version : 50713
 File Encoding         : 65001

 Date: 10/06/2021 11:21:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for water_test
-- ----------------------------
DROP TABLE IF EXISTS `water_test`;
CREATE TABLE `water_test`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `year` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `city` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `people_All` double(10, 2) DEFAULT NULL,
  `gdp` double(10, 2) DEFAULT NULL,
  `people_City` double(10, 2) DEFAULT NULL,
  `water_All` double(10, 2) DEFAULT NULL,
  `water_Life` double(10, 2) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 833 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of water_test
-- ----------------------------
INSERT INTO `water_test` VALUES (625, '2007', '济南', 783.93, 2930.08, 471.39, 19.80, 3.65);
INSERT INTO `water_test` VALUES (626, '2007', '青岛', 838.67, 3786.52, 465.82, 9.57, 2.81);
INSERT INTO `water_test` VALUES (627, '2007', '淄博', 448.39, 1945.02, 183.53, 10.39, 1.51);
INSERT INTO `water_test` VALUES (628, '2007', '枣庄', 364.04, 925.56, 121.29, 5.24, 1.28);
INSERT INTO `water_test` VALUES (629, '2007', '东营', 199.09, 1664.80, 78.80, 9.46, 0.82);
INSERT INTO `water_test` VALUES (630, '2007', '烟台', 699.45, 2879.96, 300.16, 9.15, 1.53);
INSERT INTO `water_test` VALUES (631, '2007', '潍坊', 883.61, 2056.02, 371.72, 16.75, 2.06);
INSERT INTO `water_test` VALUES (632, '2007', '济宁', 791.66, 1736.01, 209.74, 25.71, 3.03);
INSERT INTO `water_test` VALUES (633, '2007', '泰安', 543.34, 1226.11, 159.06, 10.97, 1.36);
INSERT INTO `water_test` VALUES (634, '2007', '威海', 279.96, 1583.45, 119.05, 2.86, 0.74);
INSERT INTO `water_test` VALUES (635, '2007', '日照', 272.29, 629.58, 99.54, 4.81, 0.62);
INSERT INTO `water_test` VALUES (636, '2007', '临沂', 979.94, 1660.46, 210.68, 16.15, 2.35);
INSERT INTO `water_test` VALUES (637, '2007', '德州', 545.28, 1180.82, 159.80, 21.57, 1.34);
INSERT INTO `water_test` VALUES (638, '2007', '聊城', 553.66, 1025.42, 213.09, 21.55, 1.68);
INSERT INTO `water_test` VALUES (639, '2007', '滨州', 367.12, 1030.29, 95.29, 14.87, 0.89);
INSERT INTO `water_test` VALUES (640, '2007', '菏泽', 816.55, 686.02, 177.41, 20.69, 1.76);
INSERT INTO `water_test` VALUES (641, '2008', '济南', 790.22, 3473.21, 480.72, 19.75, 3.39);
INSERT INTO `water_test` VALUES (642, '2008', '青岛', 845.61, 4436.18, 468.24, 9.73, 3.46);
INSERT INTO `water_test` VALUES (643, '2008', '淄博', 450.51, 2316.78, 184.13, 9.51, 1.27);
INSERT INTO `water_test` VALUES (644, '2008', '枣庄', 365.04, 1092.83, 124.33, 5.71, 1.38);
INSERT INTO `water_test` VALUES (645, '2008', '东营', 200.48, 2052.62, 76.91, 9.34, 0.71);
INSERT INTO `water_test` VALUES (646, '2008', '烟台', 701.91, 3434.19, 297.10, 8.53, 1.67);
INSERT INTO `water_test` VALUES (647, '2008', '潍坊', 889.54, 2491.81, 398.30, 16.89, 2.79);
INSERT INTO `water_test` VALUES (648, '2008', '济宁', 796.70, 2122.16, 256.12, 26.25, 2.40);
INSERT INTO `water_test` VALUES (649, '2008', '泰安', 545.62, 1513.30, 159.26, 11.55, 1.54);
INSERT INTO `water_test` VALUES (650, '2008', '威海', 280.61, 1780.35, 120.78, 2.63, 0.75);
INSERT INTO `water_test` VALUES (651, '2008', '日照', 274.09, 773.14, 100.66, 5.02, 0.71);
INSERT INTO `water_test` VALUES (652, '2008', '临沂', 983.25, 1958.21, 212.26, 16.29, 2.52);
INSERT INTO `water_test` VALUES (653, '2008', '德州', 548.94, 1400.91, 160.59, 21.67, 1.39);
INSERT INTO `water_test` VALUES (654, '2008', '聊城', 557.09, 1252.67, 208.19, 20.85, 1.65);
INSERT INTO `water_test` VALUES (655, '2008', '滨州', 368.86, 1236.83, 104.47, 14.68, 0.96);
INSERT INTO `water_test` VALUES (656, '2008', '菏泽', 818.77, 821.79, 180.31, 21.49, 2.12);
INSERT INTO `water_test` VALUES (657, '2009', '济南', 795.71, 3812.21, 480.64, 19.88, 3.72);
INSERT INTO `water_test` VALUES (658, '2009', '青岛', 850.03, 4853.87, 478.42, 9.86, 3.42);
INSERT INTO `water_test` VALUES (659, '2009', '淄博', 451.32, 2445.28, 181.74, 9.59, 1.38);
INSERT INTO `water_test` VALUES (660, '2009', '枣庄', 366.52, 1196.04, 132.57, 5.76, 1.39);
INSERT INTO `water_test` VALUES (661, '2009', '东营', 201.78, 2058.97, 79.32, 9.37, 0.87);
INSERT INTO `water_test` VALUES (662, '2009', '烟台', 703.40, 3701.79, 311.00, 8.54, 1.66);
INSERT INTO `water_test` VALUES (663, '2009', '潍坊', 895.15, 2707.23, 407.17, 16.56, 2.77);
INSERT INTO `water_test` VALUES (664, '2009', '济宁', 803.18, 2238.12, 252.53, 26.08, 2.37);
INSERT INTO `water_test` VALUES (665, '2009', '泰安', 548.02, 1715.66, 157.74, 12.15, 1.91);
INSERT INTO `water_test` VALUES (666, '2009', '威海', 281.69, 1733.19, 122.90, 2.79, 0.81);
INSERT INTO `water_test` VALUES (667, '2009', '日照', 275.75, 864.66, 100.76, 5.27, 0.72);
INSERT INTO `water_test` VALUES (668, '2009', '临沂', 988.90, 2069.11, 216.81, 16.84, 2.67);
INSERT INTO `water_test` VALUES (669, '2009', '德州', 553.07, 1475.08, 166.59, 21.50, 1.48);
INSERT INTO `water_test` VALUES (670, '2009', '聊城', 560.96, 1378.37, 170.24, 19.97, 1.51);
INSERT INTO `water_test` VALUES (671, '2009', '滨州', 369.98, 1354.99, 105.26, 15.30, 1.04);
INSERT INTO `water_test` VALUES (672, '2009', '菏泽', 824.84, 957.31, 184.06, 20.56, 2.04);
INSERT INTO `water_test` VALUES (673, '2010', '济南', 811.72, 4456.86, 489.22, 19.88, 3.72);
INSERT INTO `water_test` VALUES (674, '2010', '青岛', 871.90, 5666.19, 479.89, 9.86, 3.42);
INSERT INTO `water_test` VALUES (675, '2010', '淄博', 453.25, 2866.75, 182.24, 9.59, 1.38);
INSERT INTO `water_test` VALUES (676, '2010', '枣庄', 373.38, 1362.04, 135.97, 5.76, 1.39);
INSERT INTO `water_test` VALUES (677, '2010', '东营', 203.69, 2359.94, 80.88, 9.37, 0.87);
INSERT INTO `water_test` VALUES (678, '2010', '烟台', 696.82, 4358.46, 323.36, 8.54, 1.66);
INSERT INTO `water_test` VALUES (679, '2010', '潍坊', 909.23, 3090.92, 451.39, 16.56, 2.77);
INSERT INTO `water_test` VALUES (680, '2010', '济宁', 809.18, 2542.81, 266.14, 26.08, 2.37);
INSERT INTO `water_test` VALUES (681, '2010', '泰安', 549.84, 2051.68, 189.87, 12.15, 1.91);
INSERT INTO `water_test` VALUES (682, '2010', '威海', 280.46, 1944.70, 129.96, 2.79, 0.81);
INSERT INTO `water_test` VALUES (683, '2010', '日照', 280.30, 1025.08, 101.57, 5.27, 0.72);
INSERT INTO `water_test` VALUES (684, '2010', '临沂', 1005.50, 2399.99, 330.18, 16.84, 2.67);
INSERT INTO `water_test` VALUES (685, '2010', '德州', 557.42, 1657.82, 168.31, 21.50, 1.48);
INSERT INTO `water_test` VALUES (686, '2010', '聊城', 579.77, 1622.38, 185.40, 19.97, 1.51);
INSERT INTO `water_test` VALUES (687, '2010', '滨州', 375.17, 1551.52, 120.47, 15.30, 1.04);
INSERT INTO `water_test` VALUES (688, '2010', '菏泽', 830.18, 1227.09, 203.79, 20.56, 2.04);
INSERT INTO `water_test` VALUES (689, '2011', '济南', 819.09, 5018.17, 491.56, 19.88, 3.72);
INSERT INTO `water_test` VALUES (690, '2011', '青岛', 879.51, 6615.60, 482.68, 9.86, 3.42);
INSERT INTO `water_test` VALUES (691, '2011', '淄博', 455.63, 3280.23, 197.55, 9.59, 1.38);
INSERT INTO `water_test` VALUES (692, '2011', '枣庄', 375.27, 1561.68, 136.87, 5.76, 1.39);
INSERT INTO `water_test` VALUES (693, '2011', '东营', 205.50, 2676.35, 81.04, 9.37, 0.87);
INSERT INTO `water_test` VALUES (694, '2011', '烟台', 697.57, 4906.83, 324.19, 8.54, 1.66);
INSERT INTO `water_test` VALUES (695, '2011', '潍坊', 915.53, 3541.84, 459.35, 16.56, 2.77);
INSERT INTO `water_test` VALUES (696, '2011', '济宁', 812.86, 2896.69, 268.29, 26.08, 2.37);
INSERT INTO `water_test` VALUES (697, '2011', '泰安', 551.39, 2304.31, 193.59, 12.15, 1.91);
INSERT INTO `water_test` VALUES (698, '2011', '威海', 280.10, 2110.95, 130.07, 2.79, 0.81);
INSERT INTO `water_test` VALUES (699, '2011', '日照', 281.89, 1214.07, 103.04, 5.27, 0.72);
INSERT INTO `water_test` VALUES (700, '2011', '临沂', 1009.06, 2770.45, 364.34, 16.84, 2.67);
INSERT INTO `water_test` VALUES (701, '2011', '德州', 560.31, 1950.71, 174.68, 21.50, 1.48);
INSERT INTO `water_test` VALUES (702, '2011', '聊城', 584.63, 1919.42, 192.29, 19.97, 1.51);
INSERT INTO `water_test` VALUES (703, '2011', '滨州', 377.05, 1817.58, 139.83, 15.30, 1.04);
INSERT INTO `water_test` VALUES (704, '2011', '菏泽', 831.87, 1556.52, 205.51, 20.56, 2.04);
INSERT INTO `water_test` VALUES (705, '2012', '济南', 826.31, 5435.08, 500.78, 20.73, 4.26);
INSERT INTO `water_test` VALUES (706, '2012', '青岛', 886.85, 7302.11, 485.96, 9.81, 3.78);
INSERT INTO `water_test` VALUES (707, '2012', '淄博', 457.93, 3557.21, 197.47, 11.47, 1.65);
INSERT INTO `water_test` VALUES (708, '2012', '枣庄', 377.20, 1702.92, 137.01, 6.05, 1.58);
INSERT INTO `water_test` VALUES (709, '2012', '东营', 207.26, 3000.66, 80.38, 9.33, 1.11);
INSERT INTO `water_test` VALUES (710, '2012', '烟台', 698.29, 5281.38, 325.85, 9.55, 1.77);
INSERT INTO `water_test` VALUES (711, '2012', '潍坊', 921.61, 4012.43, 460.25, 14.60, 2.66);
INSERT INTO `water_test` VALUES (712, '2012', '济宁', 815.81, 3189.37, 303.30, 24.01, 2.36);
INSERT INTO `water_test` VALUES (713, '2012', '泰安', 552.89, 2547.01, 206.60, 12.98, 2.32);
INSERT INTO `water_test` VALUES (714, '2012', '威海', 279.75, 2337.86, 130.25, 3.62, 0.89);
INSERT INTO `water_test` VALUES (715, '2012', '日照', 283.43, 1352.57, 103.22, 5.44, 0.96);
INSERT INTO `water_test` VALUES (716, '2012', '临沂', 1012.44, 3012.81, 364.17, 18.53, 3.05);
INSERT INTO `water_test` VALUES (717, '2012', '德州', 563.10, 2230.55, 177.14, 18.96, 1.45);
INSERT INTO `water_test` VALUES (718, '2012', '聊城', 589.33, 2146.75, 197.95, 17.87, 1.51);
INSERT INTO `water_test` VALUES (719, '2012', '滨州', 378.87, 1987.73, 143.50, 15.43, 0.91);
INSERT INTO `water_test` VALUES (720, '2012', '菏泽', 833.81, 1787.36, 206.90, 23.39, 2.54);
INSERT INTO `water_test` VALUES (721, '2013', '济南', 833.15, 5883.67, 535.45, 20.19, 4.29);
INSERT INTO `water_test` VALUES (722, '2013', '青岛', 896.41, 8006.56, 607.05, 10.59, 3.97);
INSERT INTO `water_test` VALUES (723, '2013', '淄博', 459.26, 3801.24, 299.94, 10.50, 1.80);
INSERT INTO `water_test` VALUES (724, '2013', '枣庄', 380.10, 1830.63, 191.70, 6.05, 1.49);
INSERT INTO `water_test` VALUES (725, '2013', '东营', 208.49, 3250.20, 131.75, 9.03, 1.17);
INSERT INTO `water_test` VALUES (726, '2013', '烟台', 698.93, 5613.87, 404.34, 9.72, 1.78);
INSERT INTO `water_test` VALUES (727, '2013', '潍坊', 922.52, 4420.70, 477.46, 15.48, 2.76);
INSERT INTO `water_test` VALUES (728, '2013', '济宁', 820.58, 3501.54, 396.58, 24.10, 2.42);
INSERT INTO `water_test` VALUES (729, '2013', '泰安', 556.83, 2790.70, 299.34, 12.09, 2.09);
INSERT INTO `water_test` VALUES (730, '2013', '威海', 280.56, 2549.69, 169.22, 3.61, 0.85);
INSERT INTO `water_test` VALUES (731, '2013', '日照', 285.05, 1500.16, 146.26, 5.54, 1.07);
INSERT INTO `water_test` VALUES (732, '2013', '临沂', 1015.90, 3336.81, 511.61, 17.41, 3.17);
INSERT INTO `water_test` VALUES (733, '2013', '德州', 567.11, 2460.57, 270.74, 18.13, 1.44);
INSERT INTO `water_test` VALUES (734, '2013', '聊城', 591.13, 2365.87, 248.56, 17.87, 1.46);
INSERT INTO `water_test` VALUES (735, '2013', '滨州', 380.59, 2155.73, 194.85, 14.21, 1.01);
INSERT INTO `water_test` VALUES (736, '2013', '菏泽', 836.79, 2050.01, 348.19, 23.43, 2.53);
INSERT INTO `water_test` VALUES (737, '2014', '济南', 841.32, 6458.20, 545.30, 19.98, 4.40);
INSERT INTO `water_test` VALUES (738, '2014', '青岛', 904.62, 8692.10, 618.81, 10.70, 3.84);
INSERT INTO `water_test` VALUES (739, '2014', '淄博', 461.50, 4029.77, 303.25, 11.68, 1.72);
INSERT INTO `water_test` VALUES (740, '2014', '枣庄', 383.09, 1980.13, 196.69, 5.93, 1.55);
INSERT INTO `water_test` VALUES (741, '2014', '东营', 209.91, 3430.49, 134.43, 9.24, 1.23);
INSERT INTO `water_test` VALUES (742, '2014', '烟台', 700.23, 6002.08, 409.99, 8.40, 1.72);
INSERT INTO `water_test` VALUES (743, '2014', '潍坊', 924.72, 4786.74, 495.33, 13.37, 2.56);
INSERT INTO `water_test` VALUES (744, '2014', '济宁', 824.00, 3800.06, 414.10, 22.39, 2.54);
INSERT INTO `water_test` VALUES (745, '2014', '泰安', 558.13, 3002.19, 307.08, 11.36, 2.15);
INSERT INTO `water_test` VALUES (746, '2014', '威海', 280.92, 2790.34, 172.25, 3.45, 0.87);
INSERT INTO `water_test` VALUES (747, '2014', '日照', 287.05, 1611.84, 151.30, 5.58, 0.97);
INSERT INTO `water_test` VALUES (748, '2014', '临沂', 1022.10, 3569.80, 528.63, 16.62, 3.16);
INSERT INTO `water_test` VALUES (749, '2014', '德州', 570.51, 2596.08, 282.55, 19.86, 1.41);
INSERT INTO `water_test` VALUES (750, '2014', '聊城', 593.57, 2516.40, 260.87, 17.97, 1.56);
INSERT INTO `water_test` VALUES (751, '2014', '滨州', 383.96, 2276.71, 201.48, 15.15, 1.24);
INSERT INTO `water_test` VALUES (752, '2014', '菏泽', 843.79, 2222.19, 363.29, 22.85, 2.46);
INSERT INTO `water_test` VALUES (753, '2015', '济南', 848.36, 6766.06, 564.21, 18.82, 3.98);
INSERT INTO `water_test` VALUES (754, '2015', '青岛', 909.70, 9300.07, 636.66, 8.76, 3.73);
INSERT INTO `water_test` VALUES (755, '2015', '淄博', 464.20, 4130.24, 312.22, 10.69, 1.39);
INSERT INTO `water_test` VALUES (756, '2015', '枣庄', 387.80, 2031.00, 207.33, 6.10, 1.56);
INSERT INTO `water_test` VALUES (757, '2015', '东营', 211.06, 3450.64, 138.29, 10.07, 1.41);
INSERT INTO `water_test` VALUES (758, '2015', '烟台', 701.41, 6446.08, 423.31, 8.69, 1.74);
INSERT INTO `water_test` VALUES (759, '2015', '潍坊', 927.72, 5170.53, 517.63, 13.39, 2.55);
INSERT INTO `water_test` VALUES (760, '2015', '济宁', 829.92, 4013.12, 437.82, 23.60, 2.53);
INSERT INTO `water_test` VALUES (761, '2015', '泰安', 560.08, 3158.39, 319.47, 11.51, 2.29);
INSERT INTO `water_test` VALUES (762, '2015', '威海', 280.53, 3001.57, 177.20, 4.06, 0.92);
INSERT INTO `water_test` VALUES (763, '2015', '日照', 288.00, 1670.80, 157.85, 5.11, 1.09);
INSERT INTO `water_test` VALUES (764, '2015', '临沂', 1031.16, 3763.17, 554.97, 17.19, 3.23);
INSERT INTO `water_test` VALUES (765, '2015', '德州', 574.23, 2750.94, 297.04, 19.16, 1.33);
INSERT INTO `water_test` VALUES (766, '2015', '聊城', 597.06, 2663.62, 275.54, 18.08, 1.61);
INSERT INTO `water_test` VALUES (767, '2015', '滨州', 385.90, 2355.33, 210.79, 15.41, 1.15);
INSERT INTO `water_test` VALUES (768, '2015', '菏泽', 850.03, 2400.96, 383.58, 22.12, 2.47);
INSERT INTO `water_test` VALUES (769, '2016', '济南', 860.89, 7238.88, 586.50, 19.06, 4.06);
INSERT INTO `water_test` VALUES (770, '2016', '青岛', 920.40, 10011.29, 658.36, 9.32, 4.12);
INSERT INTO `water_test` VALUES (771, '2016', '淄博', 468.69, 4412.01, 323.91, 10.37, 1.42);
INSERT INTO `water_test` VALUES (772, '2016', '枣庄', 391.56, 2142.63, 217.20, 5.88, 1.55);
INSERT INTO `water_test` VALUES (773, '2016', '东营', 213.21, 3479.60, 142.15, 9.83, 1.28);
INSERT INTO `water_test` VALUES (774, '2016', '烟台', 706.40, 6925.66, 438.67, 8.42, 1.86);
INSERT INTO `water_test` VALUES (775, '2016', '潍坊', 935.70, 5522.68, 544.11, 13.30, 2.57);
INSERT INTO `water_test` VALUES (776, '2016', '济宁', 835.44, 4301.82, 461.58, 23.50, 2.60);
INSERT INTO `water_test` VALUES (777, '2016', '泰安', 563.74, 3316.79, 332.94, 11.36, 2.41);
INSERT INTO `water_test` VALUES (778, '2016', '威海', 281.93, 3212.20, 183.25, 4.21, 0.94);
INSERT INTO `water_test` VALUES (779, '2016', '日照', 290.11, 1802.49, 164.96, 5.34, 1.12);
INSERT INTO `water_test` VALUES (780, '2016', '临沂', 1044.30, 4026.75, 583.14, 17.89, 3.54);
INSERT INTO `water_test` VALUES (781, '2016', '德州', 579.23, 2932.99, 311.45, 19.37, 1.31);
INSERT INTO `water_test` VALUES (782, '2016', '聊城', 603.68, 2859.18, 292.78, 18.28, 1.74);
INSERT INTO `water_test` VALUES (783, '2016', '滨州', 389.10, 2470.10, 221.13, 14.96, 1.24);
INSERT INTO `water_test` VALUES (784, '2016', '菏泽', 862.26, 2560.24, 408.37, 22.91, 2.45);
INSERT INTO `water_test` VALUES (785, '2017', '济南', 869.72, 8046.60, 602.47, 18.35, 3.96);
INSERT INTO `water_test` VALUES (786, '2017', '青岛', 929.05, 11024.11, 674.21, 9.44, 4.23);
INSERT INTO `water_test` VALUES (787, '2017', '淄博', 470.84, 4771.36, 330.81, 9.61, 1.43);
INSERT INTO `water_test` VALUES (788, '2017', '枣庄', 392.03, 2303.67, 224.71, 5.58, 1.53);
INSERT INTO `water_test` VALUES (789, '2017', '东营', 215.46, 3814.35, 145.97, 10.27, 1.15);
INSERT INTO `water_test` VALUES (790, '2017', '烟台', 708.94, 7343.53, 451.31, 8.73, 1.97);
INSERT INTO `water_test` VALUES (791, '2017', '潍坊', 936.30, 5854.93, 561.31, 12.09, 2.55);
INSERT INTO `water_test` VALUES (792, '2017', '济宁', 837.59, 4636.77, 478.43, 21.59, 2.60);
INSERT INTO `water_test` VALUES (793, '2017', '泰安', 564.51, 3578.39, 342.26, 12.19, 2.59);
INSERT INTO `water_test` VALUES (794, '2017', '威海', 282.56, 3512.91, 187.79, 4.19, 1.03);
INSERT INTO `water_test` VALUES (795, '2017', '日照', 291.65, 2008.88, 171.05, 5.77, 1.15);
INSERT INTO `water_test` VALUES (796, '2017', '临沂', 1056.34, 4330.11, 606.34, 16.49, 3.49);
INSERT INTO `water_test` VALUES (797, '2017', '德州', 579.58, 3141.66, 322.07, 19.93, 1.40);
INSERT INTO `water_test` VALUES (798, '2017', '聊城', 606.43, 3013.55, 305.28, 18.30, 1.75);
INSERT INTO `water_test` VALUES (799, '2017', '滨州', 391.23, 2601.14, 229.38, 15.95, 1.30);
INSERT INTO `water_test` VALUES (800, '2017', '菏泽', 873.60, 2825.81, 428.50, 20.99, 2.43);
INSERT INTO `water_test` VALUES (801, '2018', '济南', 883.94, 8862.21, 625.80, 18.46, 4.32);
INSERT INTO `water_test` VALUES (802, '2018', '青岛', 939.48, 12001.52, 692.15, 9.33, 4.23);
INSERT INTO `water_test` VALUES (803, '2018', '淄博', 470.18, 5068.35, 336.15, 9.92, 1.58);
INSERT INTO `water_test` VALUES (804, '2018', '枣庄', 392.73, 2402.38, 231.25, 5.51, 1.49);
INSERT INTO `water_test` VALUES (805, '2018', '东营', 217.21, 4152.47, 149.97, 10.45, 1.17);
INSERT INTO `water_test` VALUES (806, '2018', '烟台', 712.18, 7832.58, 463.45, 9.01, 2.30);
INSERT INTO `water_test` VALUES (807, '2018', '潍坊', 937.30, 6156.78, 579.28, 12.27, 2.85);
INSERT INTO `water_test` VALUES (808, '2018', '济宁', 834.59, 4930.58, 491.19, 21.53, 2.67);
INSERT INTO `water_test` VALUES (809, '2018', '泰安', 564.00, 3651.53, 348.97, 11.59, 2.53);
INSERT INTO `water_test` VALUES (810, '2018', '威海', 283.00, 3641.48, 191.91, 4.18, 1.11);
INSERT INTO `water_test` VALUES (811, '2018', '日照', 293.03, 2202.17, 176.85, 5.57, 1.16);
INSERT INTO `water_test` VALUES (812, '2018', '临沂', 1062.40, 4717.80, 547.59, 16.54, 3.46);
INSERT INTO `water_test` VALUES (813, '2018', '德州', 581.00, 3380.30, 331.25, 20.09, 1.51);
INSERT INTO `water_test` VALUES (814, '2018', '聊城', 607.45, 3152.15, 314.50, 18.67, 1.80);
INSERT INTO `water_test` VALUES (815, '2018', '滨州', 392.25, 2640.52, 226.11, 17.14, 1.30);
INSERT INTO `water_test` VALUES (816, '2018', '菏泽', 876.50, 3078.78, 440.48, 22.39, 2.58);
INSERT INTO `water_test` VALUES (817, '2019', '济南', 890.87, 9443.37, 634.39, 19.60, 4.61);
INSERT INTO `water_test` VALUES (818, '2019', '青岛', 949.98, 11741.31, 704.13, 9.18, 4.39);
INSERT INTO `water_test` VALUES (819, '2019', '淄博', 469.68, 3642.42, 338.36, 10.91, 1.69);
INSERT INTO `water_test` VALUES (820, '2019', '枣庄', 393.30, 1693.91, 232.83, 5.60, 1.46);
INSERT INTO `water_test` VALUES (821, '2019', '东营', 217.97, 2916.19, 150.93, 15.73, 1.37);
INSERT INTO `water_test` VALUES (822, '2019', '烟台', 713.80, 7653.45, 466.97, 9.27, 2.42);
INSERT INTO `water_test` VALUES (823, '2019', '潍坊', 935.15, 5688.50, 581.48, 12.69, 3.04);
INSERT INTO `water_test` VALUES (824, '2019', '济宁', 835.60, 4370.17, 498.78, 21.36, 2.73);
INSERT INTO `water_test` VALUES (825, '2019', '泰安', 563.50, 2663.59, 349.44, 11.69, 2.16);
INSERT INTO `water_test` VALUES (826, '2019', '威海', 283.60, 2963.73, 194.89, 4.24, 1.08);
INSERT INTO `water_test` VALUES (827, '2019', '日照', 294.90, 1949.38, 179.89, 5.88, 1.23);
INSERT INTO `water_test` VALUES (828, '2019', '临沂', 1066.71, 4600.25, 562.69, 16.54, 3.41);
INSERT INTO `water_test` VALUES (829, '2019', '德州', 574.85, 3022.27, 304.84, 21.54, 1.55);
INSERT INTO `water_test` VALUES (830, '2019', '聊城', 609.83, 2259.82, 321.50, 18.93, 1.77);
INSERT INTO `water_test` VALUES (831, '2019', '滨州', 392.30, 2457.19, 228.45, 20.08, 1.72);
INSERT INTO `water_test` VALUES (832, '2019', '菏泽', 878.17, 3409.98, 444.62, 22.03, 2.67);

SET FOREIGN_KEY_CHECKS = 1;
