/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : v_fthroughtrain

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-02-16 12:32:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for back_menu
-- ----------------------------
DROP TABLE IF EXISTS `back_menu`;
CREATE TABLE `back_menu` (
  `menu_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '菜单id',
  `title` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '菜单名字',
  `order_number` int(11) DEFAULT NULL COMMENT '排序',
  `href` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '菜单地址',
  `icon` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '菜单图标',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `authority` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '权限',
  `checked` int(11) DEFAULT NULL COMMENT '选择',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_menu` int(11) DEFAULT NULL COMMENT '菜单类型',
  `parent_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '父级菜单',
  `target` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '展示方式',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='菜单表';

-- ----------------------------
-- Records of back_menu
-- ----------------------------
INSERT INTO `back_menu` VALUES ('0', '管理员首页', '1', '/welcome', 'fa fa-home', '2020-01-19 12:32:50', 'admin:admin', '0', '2020-01-19 12:32:50', '0', '-1', '_self');
INSERT INTO `back_menu` VALUES ('1', '农家蔬果直通车', '1', '', 'images/logo.png', '2020-01-20 12:38:08', '', '0', '2020-01-20 12:38:08', '0', '-1', '_self');
INSERT INTO `back_menu` VALUES ('10', '角色管理', '1', '/role', 'fa fa-file-text', '2020-01-19 13:41:18', 'admin:admin', '0', '2020-01-19 13:41:18', '0', '8', '_self');
INSERT INTO `back_menu` VALUES ('11', '授权管理', '1', '/rolepermission', 'fa fa-file-text', '2020-01-19 13:41:23', 'admin:admin', '0', '2020-01-19 13:41:23', '0', '8', '_self');
INSERT INTO `back_menu` VALUES ('12', '商家管理', '3', '', 'fa fa-calendar', '2020-01-19 13:50:43', 'admin:admin', '0', '2020-01-19 13:50:43', '0', '2', '_self');
INSERT INTO `back_menu` VALUES ('13', '商家信息', '1', '/shopInfo', 'fa fa-list-alt', '2020-01-19 13:43:19', 'admin:admin', '0', '2020-01-19 13:43:19', '0', '12', '_self');
INSERT INTO `back_menu` VALUES ('14', '商家录入', '1', '/addshop', 'fa fa-navicon', '2020-01-19 13:43:22', 'admin:admin', '0', '2020-01-19 13:43:22', '0', '12', '_self');
INSERT INTO `back_menu` VALUES ('15', '商家首页', '1', '/shopwelcome', 'fa fa-home', '2020-01-20 12:37:48', 'admin:shop', '0', '2020-01-20 12:37:48', '0', '-1', '_self');
INSERT INTO `back_menu` VALUES ('15290d4ade6929166600962e1d933180', '优惠券管理', '6', '', 'fa fa-align-justify', '2020-01-20 13:19:26', '', '0', null, '0', '2', '_self');
INSERT INTO `back_menu` VALUES ('2', '后台管理系统', '1', '', 'fa fa-address-book', '2020-01-20 12:38:24', '', '0', '2020-01-20 12:38:24', '0', '-1', '_self');
INSERT INTO `back_menu` VALUES ('2d7d6459e88c186125c2c6ec4ddbda96', '订单管理', '8', '', 'fa ', '2020-01-20 13:37:11', 'admin:shop', '0', '2020-01-20 13:37:11', '0', '2', '_self');
INSERT INTO `back_menu` VALUES ('3', '系统菜单管理', '1', '/menu', 'fa fa-window-maximize', '2020-01-19 14:42:59', 'admin:admin', '0', '2020-01-19 14:42:59', '0', '2', '_self');
INSERT INTO `back_menu` VALUES ('32d51dc9a8a1910e0135e14cb8c2559f', '添加轮播图', '1', '/addbanner', 'fa ', '2020-02-05 11:00:09', 'admin:admin', '0', null, '0', 'b83b2e0847bae9701624a21d652fba39', '_self');
INSERT INTO `back_menu` VALUES ('336deb632514c6eed96be86206517d57', '订单信息', '8', '/shoporder', 'fa fa-building-o', '2020-01-20 13:37:53', 'admin:shop', '0', '2020-01-20 13:37:53', '0', '2d7d6459e88c186125c2c6ec4ddbda96', '_self');
INSERT INTO `back_menu` VALUES ('4', '清理缓存', null, 'api/clear.json', null, '2020-01-20 12:38:59', '', null, '2020-01-20 12:38:59', null, '-1', '');
INSERT INTO `back_menu` VALUES ('424ce3991e7478cd25a2a8e033077b7d', '优惠券信息', '0', '/coupon', 'fa fa-align-justify', '2020-01-20 13:20:11', '', '0', null, '0', '15290d4ade6929166600962e1d933180', '_self');
INSERT INTO `back_menu` VALUES ('5', '用户管理', '4', '', 'fa fa-calendar', '2020-01-19 13:50:34', 'admin:admin', '0', '2020-01-19 13:50:34', '0', '2', '_self');
INSERT INTO `back_menu` VALUES ('6', '用户数据统计', '1', '/role', 'fa fa-file-text', '2020-01-19 13:38:31', 'admin:admin', '0', '2020-01-19 13:38:31', '0', '5', '_self');
INSERT INTO `back_menu` VALUES ('7', '用户信息', '1', '/userInfo', 'fa fa-file-text', '2020-01-19 13:38:37', 'admin:admin', '0', '2020-01-19 13:38:37', '0', '5', '_self');
INSERT INTO `back_menu` VALUES ('705d5ce1bd8cf779003832b5e4256fb8', '商城菜单管理', '10', '/shopmenu', 'fa fa-group', '2020-01-20 13:43:09', 'admin:admin', '0', null, '0', '2', '_self');
INSERT INTO `back_menu` VALUES ('7f846532e9865511ee1710495ca07570', '上架商品', '1', '/addgoods', 'fa fa-columns', '2020-01-20 12:11:00', 'admin:shop', '0', null, '0', 'f0ed143af49c280899cc370d8ee5a7b5', '_self');
INSERT INTO `back_menu` VALUES ('8', '权限管理', '2', '', 'fa fa-calendar', '2020-01-19 13:50:39', 'admin:admin', '0', '2020-01-19 13:50:39', '0', '2', '_self');
INSERT INTO `back_menu` VALUES ('9', '资源管理', '1', '/permission', 'fa fa-file-text', '2020-01-19 13:41:17', 'admin:admin', '0', '2020-01-19 13:41:17', '0', '8', '_self');
INSERT INTO `back_menu` VALUES ('912fa4eb2112bf7f80c6d72a5d237bb7', '查看轮播图', '0', '/viewbanner', 'fa ', '2020-02-05 10:59:41', 'admin:admin', '0', null, '0', 'b83b2e0847bae9701624a21d652fba39', '_self');
INSERT INTO `back_menu` VALUES ('b81203b2c06c1538d45f0061c872269a', '商品信息', '0', '/goodsInfo', 'fa fa-diamond', '2020-01-20 12:39:40', '', '0', '2020-01-20 12:39:40', '0', 'f0ed143af49c280899cc370d8ee5a7b5', '_self');
INSERT INTO `back_menu` VALUES ('b83b2e0847bae9701624a21d652fba39', '轮播图管理', '9', '/bannner', 'fa fa-image', '2020-01-20 13:40:41', 'admin:admin', '0', null, '0', '2', '_self');
INSERT INTO `back_menu` VALUES ('c5e1e0404a60f8ded6d087111cb6fe51', '分类管理', '7', '', 'fa fa-align-justify', '2020-01-20 13:20:57', 'admin:admin', '0', null, '0', '2', '_self');
INSERT INTO `back_menu` VALUES ('e6401736e7ad7d15a97651aeb88ac5f0', '分类信息', '0', '/category', 'fa fa-500px', '2020-01-20 13:21:42', 'admin:admin', '0', null, '0', 'c5e1e0404a60f8ded6d087111cb6fe51', '_self');
INSERT INTO `back_menu` VALUES ('f0ed143af49c280899cc370d8ee5a7b5', '商品管理', '5', '', 'fa fa-shopping-bag', '2020-01-20 12:39:47', '', '0', '2020-01-20 12:39:47', '0', '2', '_self');

-- ----------------------------
-- Table structure for banner
-- ----------------------------
DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner` (
  `banner_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '编号',
  `banner_description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '图片描述',
  `banner_url` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '图片地址',
  `goods_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '关联商品',
  `is_show` int(1) DEFAULT '0' COMMENT '是否展示',
  PRIMARY KEY (`banner_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='轮播表';

-- ----------------------------
-- Records of banner
-- ----------------------------
INSERT INTO `banner` VALUES ('1b210b8ec016eaf2dce98975d8c0990d', '苹果', 'http://localhost:8080/photo/057f298540ce49d1bbc0b810ee44d58d.jpg', '0988f90f2c1d5184e37a9dc93e46ec18', '1');
INSERT INTO `banner` VALUES ('7f8b0694e4e2517225f596972e5fce29', '苹果', 'http://localhost:8080/photo/15192650f2584b48800df3577d550bd6.jpg', '0988f90f2c1d5184e37a9dc93e46ec18', '1');
INSERT INTO `banner` VALUES ('9a099ceff9cc9fe0169c6608dba569b7', '香蕉', 'http://localhost:8080/photo/180488e2ae25498498cdf70b4538be9e.jpg', '6c9b0f1cbf04de7c8f5f36b3056b9b31', '0');
INSERT INTO `banner` VALUES ('cbfa5808cb6e71023b4ba2b3e8d236c7', '香蕉', 'http://localhost:8080/photo/168b4381540c4cff96e2dbc6cf8be62a.jpg', '6c9b0f1cbf04de7c8f5f36b3056b9b31', '0');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `category_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `category_name` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '类别名称',
  `category_description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '类别描述',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='类别表';

-- ----------------------------
-- Records of category
-- ----------------------------

-- ----------------------------
-- Table structure for coupon
-- ----------------------------
DROP TABLE IF EXISTS `coupon`;
CREATE TABLE `coupon` (
  `coupon_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `shop_store_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商家编号',
  `coupon_price` double(32,0) DEFAULT NULL COMMENT '优惠金额',
  `coupon_factor` double(32,0) DEFAULT NULL COMMENT '优惠条件',
  `coupon_start_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '开始时间',
  `coupon_end_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '结束时间',
  `coupon_number` int(11) DEFAULT NULL COMMENT '优惠券数量',
  `coupon_status` int(1) DEFAULT NULL COMMENT '优惠券状态',
  PRIMARY KEY (`coupon_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='优惠券表';

-- ----------------------------
-- Records of coupon
-- ----------------------------

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goods_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `goods_name` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品名字',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '商品创建时间',
  `shop_store_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '归属商家',
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='商品表';

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('107b05ec70b99d5672c5bb303d60430a', '香蕉', '2020-02-06 19:24:34', '531b593d35dc3557c513d707301e7b6f');
INSERT INTO `goods` VALUES ('1fe1378ad78f95be2eab2649a52d0eb8', '香蕉', '2020-02-06 19:25:03', '531b593d35dc3557c513d707301e7b6f');
INSERT INTO `goods` VALUES ('45055ae5dac9af9a94a3976a62a84bc4', '美女', '2020-02-06 19:36:48', '531b593d35dc3557c513d707301e7b6f');
INSERT INTO `goods` VALUES ('4e7ab0234ea644b996489d065c2b19fa', '香蕉', '2020-02-06 19:24:38', '531b593d35dc3557c513d707301e7b6f');
INSERT INTO `goods` VALUES ('7df0c96ec19f4d9c89f14272200b0a38', '香蕉', '2020-02-06 19:25:00', '531b593d35dc3557c513d707301e7b6f');
INSERT INTO `goods` VALUES ('8085adea03dbbe82bd7f828ae8ac2bfe', '香蕉', '2020-02-06 19:24:53', '531b593d35dc3557c513d707301e7b6f');
INSERT INTO `goods` VALUES ('859ee48679290a41ce70dd94467b5857', '香蕉', '2020-02-06 19:24:57', '531b593d35dc3557c513d707301e7b6f');
INSERT INTO `goods` VALUES ('96a709334b50e2e0fab7056abae52753', '香蕉', '2020-02-06 19:25:11', '531b593d35dc3557c513d707301e7b6f');
INSERT INTO `goods` VALUES ('a2270d0ac635e0fac03d9599c3268665', '香蕉', '2020-02-06 19:25:06', '531b593d35dc3557c513d707301e7b6f');
INSERT INTO `goods` VALUES ('ba955b281bb5a33686d5070672302a79', '香蕉', '2020-02-06 19:24:43', '531b593d35dc3557c513d707301e7b6f');
INSERT INTO `goods` VALUES ('f11dfefaeed4d1bda7b31a63f4fe38d1', '香蕉', '2020-02-06 19:23:59', '531b593d35dc3557c513d707301e7b6f');

-- ----------------------------
-- Table structure for goods_category
-- ----------------------------
DROP TABLE IF EXISTS `goods_category`;
CREATE TABLE `goods_category` (
  `goods_category_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `category_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '类别编号',
  `goods_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品编号',
  PRIMARY KEY (`goods_category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='商品类别';

-- ----------------------------
-- Records of goods_category
-- ----------------------------

-- ----------------------------
-- Table structure for goods_images
-- ----------------------------
DROP TABLE IF EXISTS `goods_images`;
CREATE TABLE `goods_images` (
  `goods_images_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `goods_images_url` varchar(1024) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '图片地址',
  `goods_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品编号',
  PRIMARY KEY (`goods_images_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='商品详情页表';

-- ----------------------------
-- Records of goods_images
-- ----------------------------
INSERT INTO `goods_images` VALUES ('005d6ccf74851d8c135b5054fe638c5c', 'http://localhost:8080/photo/c439a5eab4c443fa9d4295dad5bb1d3e.jpg,http://localhost:8080/photo/8da83278448e408db1b42be5f1462d14.jpg,http://localhost:8080/photo/0f3b4ddb73664fa08116ecbb711dbaaf.jpg', '7df0c96ec19f4d9c89f14272200b0a38');
INSERT INTO `goods_images` VALUES ('20b5d4ab8cc49ca76e0d1564c30c7aa6', 'http://localhost:8080/photo/c439a5eab4c443fa9d4295dad5bb1d3e.jpg,http://localhost:8080/photo/8da83278448e408db1b42be5f1462d14.jpg,http://localhost:8080/photo/0f3b4ddb73664fa08116ecbb711dbaaf.jpg', '8085adea03dbbe82bd7f828ae8ac2bfe');
INSERT INTO `goods_images` VALUES ('2e81845cc41ab755bcec4be3c0cfccf0', 'http://localhost:8080/photo/c439a5eab4c443fa9d4295dad5bb1d3e.jpg,http://localhost:8080/photo/8da83278448e408db1b42be5f1462d14.jpg,http://localhost:8080/photo/0f3b4ddb73664fa08116ecbb711dbaaf.jpg', '859ee48679290a41ce70dd94467b5857');
INSERT INTO `goods_images` VALUES ('91eaa1b7000583f16a6ffe61bced10b4', 'http://localhost:8080/photo/c439a5eab4c443fa9d4295dad5bb1d3e.jpg,http://localhost:8080/photo/8da83278448e408db1b42be5f1462d14.jpg,http://localhost:8080/photo/0f3b4ddb73664fa08116ecbb711dbaaf.jpg', '107b05ec70b99d5672c5bb303d60430a');
INSERT INTO `goods_images` VALUES ('9392cdcae205b5bc34217ef7b6edb714', 'http://localhost:8080/photo/c439a5eab4c443fa9d4295dad5bb1d3e.jpg,http://localhost:8080/photo/8da83278448e408db1b42be5f1462d14.jpg,http://localhost:8080/photo/0f3b4ddb73664fa08116ecbb711dbaaf.jpg', 'ba955b281bb5a33686d5070672302a79');
INSERT INTO `goods_images` VALUES ('a261bd44c455c13ee4280251ad69731d', 'http://localhost:8080/photo/c439a5eab4c443fa9d4295dad5bb1d3e.jpg,http://localhost:8080/photo/8da83278448e408db1b42be5f1462d14.jpg,http://localhost:8080/photo/0f3b4ddb73664fa08116ecbb711dbaaf.jpg', '1fe1378ad78f95be2eab2649a52d0eb8');
INSERT INTO `goods_images` VALUES ('a6df9f39681486125975614d7827e3ca', 'http://localhost:8080/photo/c439a5eab4c443fa9d4295dad5bb1d3e.jpg,http://localhost:8080/photo/8da83278448e408db1b42be5f1462d14.jpg,http://localhost:8080/photo/0f3b4ddb73664fa08116ecbb711dbaaf.jpg', 'f11dfefaeed4d1bda7b31a63f4fe38d1');
INSERT INTO `goods_images` VALUES ('b0a3679ec8f2e2e707b0f699f792d630', 'http://localhost:8080/photo/721b205fff2b4705b4f8e497f11b4ead.jpg,http://localhost:8080/photo/b7d2fe1eb8cd4595969b2e0ae3a56486.jpg,http://localhost:8080/photo/f785fbcd1b264a618c964331ec0bab58.jpg,http://localhost:8080/photo/1630d6a26fef48e6b37a5b29d869e34b.jpg', '45055ae5dac9af9a94a3976a62a84bc4');
INSERT INTO `goods_images` VALUES ('dc369b82441e2350a1153ec473a30751', 'G:\\毕业设计\\images\\e0b32c4552784442bdb9353344347181.jpg,G:\\毕业设计\\images\\e27893ad9ff5486db5b438a6d4da24a0.jpg,G:\\毕业设计\\images\\d19f27f3a7a14e1ba04ea1e28faf8a92.jpg,G:\\毕业设计\\images\\507b2d62283f41ec84a90f8535285ab5.jpg', '6c9b0f1cbf04de7c8f5f36b3056b9b31');
INSERT INTO `goods_images` VALUES ('dc4382b48af0c3610bebc8c965c37168', 'http://localhost:8080/photo/c439a5eab4c443fa9d4295dad5bb1d3e.jpg,http://localhost:8080/photo/8da83278448e408db1b42be5f1462d14.jpg,http://localhost:8080/photo/0f3b4ddb73664fa08116ecbb711dbaaf.jpg', '4e7ab0234ea644b996489d065c2b19fa');
INSERT INTO `goods_images` VALUES ('dd25e0ae7036e2dea0d37d3feb5e395c', 'http://localhost:8080/photo/c439a5eab4c443fa9d4295dad5bb1d3e.jpg,http://localhost:8080/photo/8da83278448e408db1b42be5f1462d14.jpg,http://localhost:8080/photo/0f3b4ddb73664fa08116ecbb711dbaaf.jpg', 'a2270d0ac635e0fac03d9599c3268665');
INSERT INTO `goods_images` VALUES ('e1f31cc91f58c32b00a9f11145840384', 'G:\\毕业设计\\images\\e0b32c4552784442bdb9353344347181.jpg,G:\\毕业设计\\images\\e27893ad9ff5486db5b438a6d4da24a0.jpg,G:\\毕业设计\\images\\d19f27f3a7a14e1ba04ea1e28faf8a92.jpg,G:\\毕业设计\\images\\507b2d62283f41ec84a90f8535285ab5.jpg', '0988f90f2c1d5184e37a9dc93e46ec18');
INSERT INTO `goods_images` VALUES ('f34230103a16aefdeefbad0a2b7e61e6', 'http://localhost:8080/photo/c439a5eab4c443fa9d4295dad5bb1d3e.jpg,http://localhost:8080/photo/8da83278448e408db1b42be5f1462d14.jpg,http://localhost:8080/photo/0f3b4ddb73664fa08116ecbb711dbaaf.jpg', '96a709334b50e2e0fab7056abae52753');

-- ----------------------------
-- Table structure for goods_norms
-- ----------------------------
DROP TABLE IF EXISTS `goods_norms`;
CREATE TABLE `goods_norms` (
  `goods_norms_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `goods_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品编号',
  `goods_old_price` double(10,2) DEFAULT NULL COMMENT '商品原价',
  `goods_now_price` double(10,2) DEFAULT NULL COMMENT '商品现价',
  `goods_name` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品规格名称',
  `goods_status` int(1) DEFAULT NULL COMMENT '商品状态',
  `goods_number` int(11) DEFAULT NULL COMMENT '商品库存',
  PRIMARY KEY (`goods_norms_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='商品规格表';

-- ----------------------------
-- Records of goods_norms
-- ----------------------------
INSERT INTO `goods_norms` VALUES ('0338bef24fbd4e36a0520f86b7aa7751', '859ee48679290a41ce70dd94467b5857', '99.99', '88.88', '10Kg', '1', '999');
INSERT INTO `goods_norms` VALUES ('0484091ddf1449b3229396504492c619', 'f11dfefaeed4d1bda7b31a63f4fe38d1', '9.99', '8.88', '1000g', '1', '999');
INSERT INTO `goods_norms` VALUES ('1b50b168eeac656495f3ce30807d703b', '96a709334b50e2e0fab7056abae52753', '99.99', '88.88', '10Kg', '1', '999');
INSERT INTO `goods_norms` VALUES ('1cd7eef67f336aa67b2adeba8018b136', '96a709334b50e2e0fab7056abae52753', '9.99', '8.88', '1000g', '1', '999');
INSERT INTO `goods_norms` VALUES ('23eedde90f1ba07a90730ecf8af6aae4', '4e7ab0234ea644b996489d065c2b19fa', '9.99', '8.88', '1000g', '1', '999');
INSERT INTO `goods_norms` VALUES ('297b23c923ebed8a1444c91a84121126', '8085adea03dbbe82bd7f828ae8ac2bfe', '99.99', '88.88', '10Kg', '1', '999');
INSERT INTO `goods_norms` VALUES ('38de51f789f925379de8fcff4b8217e2', 'ba955b281bb5a33686d5070672302a79', '99.99', '88.88', '10Kg', '1', '999');
INSERT INTO `goods_norms` VALUES ('447277c5f0c08f9bbfbc4a7fd9f889fb', '859ee48679290a41ce70dd94467b5857', '9.99', '8.88', '1000g', '1', '999');
INSERT INTO `goods_norms` VALUES ('4b05ab07f080a93d760ae6d0983b84df', '45055ae5dac9af9a94a3976a62a84bc4', '1.00', '1.00', '1', '1', '1');
INSERT INTO `goods_norms` VALUES ('4d6c6bc1d460e61cbe5c2a71b4f64faa', '7df0c96ec19f4d9c89f14272200b0a38', '99.99', '88.88', '10Kg', '1', '999');
INSERT INTO `goods_norms` VALUES ('5bef7680eee7a87a7c8bc2d0c944bf1c', '7df0c96ec19f4d9c89f14272200b0a38', '9.99', '8.88', '1000g', '1', '999');
INSERT INTO `goods_norms` VALUES ('619eca96a5381cea66862477f79fc02a', '107b05ec70b99d5672c5bb303d60430a', '9.99', '8.88', '1000g', '1', '999');
INSERT INTO `goods_norms` VALUES ('769d6a3b4a5aac818b228803c78b5a09', '0988f90f2c1d5184e37a9dc93e46ec18', '2.00', '2.00', '2', '2', '2');
INSERT INTO `goods_norms` VALUES ('77d6f47ec4098d609abf31fa341df9fc', 'a2270d0ac635e0fac03d9599c3268665', '99.99', '88.88', '10Kg', '1', '999');
INSERT INTO `goods_norms` VALUES ('7b65eff179824b467d3a9b66c05edbac', '1fe1378ad78f95be2eab2649a52d0eb8', '99.99', '88.88', '10Kg', '1', '999');
INSERT INTO `goods_norms` VALUES ('8a23d34eae2e77e5ac933cdb9e644052', '6c9b0f1cbf04de7c8f5f36b3056b9b31', '3.00', '3.00', '3', '3', '3');
INSERT INTO `goods_norms` VALUES ('a767eda66352e3420ce6340db28bada3', '6c9b0f1cbf04de7c8f5f36b3056b9b31', '4.00', '4.00', '4', '4', '4');
INSERT INTO `goods_norms` VALUES ('c4bc114245ef7a1f70c7b16ee62cd9c0', '6c9b0f1cbf04de7c8f5f36b3056b9b31', '5.00', '5.00', '5', '5', '5');
INSERT INTO `goods_norms` VALUES ('c803bf30b0e2b57f5d3fecdc86c55e8c', '45055ae5dac9af9a94a3976a62a84bc4', '2.00', '2.00', '2', '2', '2');
INSERT INTO `goods_norms` VALUES ('cd08858e0942e9ef98ac153f143bd715', 'f11dfefaeed4d1bda7b31a63f4fe38d1', '99.99', '88.88', '10Kg', '1', '999');
INSERT INTO `goods_norms` VALUES ('cefcf484bded2a801d50e52ff69b85d4', '0988f90f2c1d5184e37a9dc93e46ec18', '1.00', '1.00', '1', '1', '1');
INSERT INTO `goods_norms` VALUES ('d114cda5dd6fc6e7a05325168944266e', '107b05ec70b99d5672c5bb303d60430a', '99.99', '88.88', '10Kg', '1', '999');
INSERT INTO `goods_norms` VALUES ('e10f002420ab0049ee4b40b5aad75dda', 'ba955b281bb5a33686d5070672302a79', '9.99', '8.88', '1000g', '1', '999');
INSERT INTO `goods_norms` VALUES ('e182348697072ead2bb4da1218ec14a4', '1fe1378ad78f95be2eab2649a52d0eb8', '9.99', '8.88', '1000g', '1', '999');
INSERT INTO `goods_norms` VALUES ('e9f89e00111c6583f387a5013b92e1cb', '4e7ab0234ea644b996489d065c2b19fa', '99.99', '88.88', '10Kg', '1', '999');
INSERT INTO `goods_norms` VALUES ('f27aff85ece3030ff32b65393578850d', '8085adea03dbbe82bd7f828ae8ac2bfe', '9.99', '8.88', '1000g', '1', '999');
INSERT INTO `goods_norms` VALUES ('f733311948b2a97deceaa759c8ae79f2', 'a2270d0ac635e0fac03d9599c3268665', '9.99', '8.88', '1000g', '1', '999');

-- ----------------------------
-- Table structure for goods_return
-- ----------------------------
DROP TABLE IF EXISTS `goods_return`;
CREATE TABLE `goods_return` (
  `goods_return_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `user_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户编号',
  `return_description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '反馈详情',
  `per_return_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '上级反馈',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '反馈时间',
  PRIMARY KEY (`goods_return_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='商品反馈表';

-- ----------------------------
-- Records of goods_return
-- ----------------------------

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `menu_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '编号',
  `menu_name` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '菜单名字',
  `category_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '关联分类',
  `per_menu_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '上级菜单',
  `menu_status` int(1) DEFAULT NULL COMMENT '菜单状态',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='菜单表';

-- ----------------------------
-- Records of menu
-- ----------------------------

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `orders_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `order_name` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '订单名称',
  `order_price` double DEFAULT NULL COMMENT '订单金额',
  `shop_store_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商家',
  `user_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `orders_status` int(1) DEFAULT NULL COMMENT '订单状态',
  `delete_status` int(1) DEFAULT NULL COMMENT '逻辑删除',
  `person_address_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '收货地址',
  `user_coupon_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '优惠券',
  PRIMARY KEY (`orders_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='订单表';

-- ----------------------------
-- Records of orders
-- ----------------------------

-- ----------------------------
-- Table structure for order_details
-- ----------------------------
DROP TABLE IF EXISTS `order_details`;
CREATE TABLE `order_details` (
  `order_details_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `orders_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '订单编号',
  `goods_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品编号',
  `goods_norms_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品规格',
  `good_number` int(11) DEFAULT NULL COMMENT '商品数量',
  `good_price` double DEFAULT NULL COMMENT '商品单价',
  `good_all_price` double DEFAULT NULL COMMENT '商品总价',
  PRIMARY KEY (`order_details_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='订单详情表';

-- ----------------------------
-- Records of order_details
-- ----------------------------

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `permission_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '编号',
  `permission_name` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '权限名字',
  `permission_url` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '权限地址',
  `permission_description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '权限描述',
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='权限表（permission）';

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('0b528ff5e57b3632aa9e4702850cfc91', '上架商品', '/addgoods', '上架商品');
INSERT INTO `permission` VALUES ('0c5408f54aef7788f4f303d457b1e2cf', '角色管理', '/role', '角色管理菜单');
INSERT INTO `permission` VALUES ('1b06e3f7510f0b2670c3a2698643106f', '授权管理', '/rolepermission', '授权管理');
INSERT INTO `permission` VALUES ('44a1f7b026a2bf03f6c23e6c64815d59', '系统菜单管理', '/menu', '系统菜单管理');
INSERT INTO `permission` VALUES ('5a97617c30375fcd2073836de67b1572', '商家录入', '/addshop', '商家录入');
INSERT INTO `permission` VALUES ('b622cdb149c1fb884c4497a104b51d79', '商家信息', '/shopInfo', '商家信息');
INSERT INTO `permission` VALUES ('ea7eba60c0e0b27cd6d5ce92010c2de6', '商品信息', '/goodsInfo', '商品信息');
INSERT INTO `permission` VALUES ('f7eb6804cacd39bbea73cf964d81a37a', '资源管理', '/permission', '资源管理');
INSERT INTO `permission` VALUES ('fc7b96e96b28f895068c073d53683dc5', '用户信息', '/userInfo', '用户信息');

-- ----------------------------
-- Table structure for person_address
-- ----------------------------
DROP TABLE IF EXISTS `person_address`;
CREATE TABLE `person_address` (
  `person_address_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '编号',
  `user_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户编号',
  `address_description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '地址描述',
  `address_status` int(1) DEFAULT '0' COMMENT '地址状态 0:正常 1：删除',
  PRIMARY KEY (`person_address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='个人收货地址表';

-- ----------------------------
-- Records of person_address
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '编号',
  `role_flag` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '权限标识',
  `role_name` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '角色名称',
  `role_description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='角色表';

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'user:youke', '游客', '未登陆的用户');
INSERT INTO `role` VALUES ('2', 'user:user', '用户', '登陆的用户');
INSERT INTO `role` VALUES ('3', 'admin:shop', '商家', '拥有店铺的用户');
INSERT INTO `role` VALUES ('4', 'admin:admin', '管理员', '系统管理人员');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `role_permission_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '编号',
  `permission_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '权限编号',
  `role_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '角色编号',
  PRIMARY KEY (`role_permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='角色权限表';

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('27eef47f6cd0819d6b4043a872ad0ef0', '1b06e3f7510f0b2670c3a2698643106f', '4');
INSERT INTO `role_permission` VALUES ('37e0e25209f9277e4503fa0af4e8304e', '0b528ff5e57b3632aa9e4702850cfc91', '3');
INSERT INTO `role_permission` VALUES ('439840ff5a080c0364a94f13234ae00e', 'fc7b96e96b28f895068c073d53683dc5', '4');
INSERT INTO `role_permission` VALUES ('4992ed4129466e4be8930a10a559832e', '5a97617c30375fcd2073836de67b1572', '4');
INSERT INTO `role_permission` VALUES ('5d5b84b48ea0649279c02577c6e00bc0', 'debb8e6ad552ea69c665476cc4e11996', '4');
INSERT INTO `role_permission` VALUES ('d2a7f183c9f1d7575fd7688e4b4a3ec7', '44a1f7b026a2bf03f6c23e6c64815d59', '4');
INSERT INTO `role_permission` VALUES ('da71ec4a8b357f615b1a39f90ecab1fa', '0c5408f54aef7788f4f303d457b1e2cf', '4');
INSERT INTO `role_permission` VALUES ('fe2168bd5da66d8085613dddf4e127e0', 'f7eb6804cacd39bbea73cf964d81a37a', '4');

-- ----------------------------
-- Table structure for shop_car
-- ----------------------------
DROP TABLE IF EXISTS `shop_car`;
CREATE TABLE `shop_car` (
  `shop_car_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `user_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户编号',
  `goods_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品编号',
  `goods_norms_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品规格',
  `good_number` int(11) DEFAULT NULL COMMENT '商品数量',
  `good_price` double DEFAULT NULL COMMENT '商品单价',
  `good_all_price` double DEFAULT NULL COMMENT '商品总价',
  PRIMARY KEY (`shop_car_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='购物车';

-- ----------------------------
-- Records of shop_car
-- ----------------------------
INSERT INTO `shop_car` VALUES ('2ab243e2155d275632f21b5ee9da7536', 'cf21724fde2550b3b9936842d6adbf83', '45055ae5dac9af9a94a3976a62a84bc4', '4b05ab07f080a93d760ae6d0983b84df', '1', '1', '1');
INSERT INTO `shop_car` VALUES ('4cf819c35c7b7a9a583faa99f362c422', '4c0a8228f927b6b252e10f6b8323c347', '45055ae5dac9af9a94a3976a62a84bc4', '4b05ab07f080a93d760ae6d0983b84df', '1', '1', '1');
INSERT INTO `shop_car` VALUES ('9fc718e9ebf44d077d7445435fd95cb6', 'cf21724fde2550b3b9936842d6adbf83', '45055ae5dac9af9a94a3976a62a84bc4', 'c803bf30b0e2b57f5d3fecdc86c55e8c', '1', '2', '2');

-- ----------------------------
-- Table structure for shop_store
-- ----------------------------
DROP TABLE IF EXISTS `shop_store`;
CREATE TABLE `shop_store` (
  `shop_store_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `shop_store_name` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商家名称',
  `shop_store_description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商家描述',
  `shop_store_owner_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '归属用户',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `del_status` int(1) DEFAULT NULL COMMENT '逻辑删除',
  PRIMARY KEY (`shop_store_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='商家表';

-- ----------------------------
-- Records of shop_store
-- ----------------------------
INSERT INTO `shop_store` VALUES ('20cc494f788298aceb7c072bd09d0a7c', '苹果店', '买苹果的', 'b5966d135478ad38322f05f7998fb24b', '2020-01-19 11:58:06', '0');
INSERT INTO `shop_store` VALUES ('531b593d35dc3557c513d707301e7b6f', '香蕉店', '买香蕉', '011732df4d5d9b6270e5b9ce59453d42', '2020-01-18 13:07:17', '1');
INSERT INTO `shop_store` VALUES ('5503cb4690d70d7b621dd8716824fd71', '苹果店', '买苹果的', 'b5966d135478ad38322f05f7998fb24b', '2020-01-19 11:58:12', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '编号',
  `account` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户账号',
  `nickname` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户昵称',
  `password` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户密码',
  `salt` varchar(4) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '加密盐值',
  `role_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户角色',
  `user_status` int(1) DEFAULT '1' COMMENT '用户状态 用户状态(0:逻辑删除，1:正常，2:锁定，3：违规)',
  `register_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('011732df4d5d9b6270e5b9ce59453d42', 'wanjy', '小猫咪', '72803f8d03ecd02e88976ea822ec260d', 'S8MX', '3', '1', '2020-01-20 12:14:20');
INSERT INTO `user` VALUES ('4c0a8228f927b6b252e10f6b8323c347', 'zs', '大宝贝', '248e568de4e5525ed9bacc26ed79549c', '7gsR', '2', '1', '2020-02-03 10:02:20');
INSERT INTO `user` VALUES ('b5966d135478ad38322f05f7998fb24b', 'admin', '管理员', 'be056463f899115df56108efd5a33719', 'b8pt', '4', '1', '2020-01-16 19:26:07');
INSERT INTO `user` VALUES ('cf21724fde2550b3b9936842d6adbf83', 'zhousong', '大宝贝', '0b6d4e518e7217245af003f427b900e9', 'iPdD', '2', '1', '2020-02-03 10:03:48');

-- ----------------------------
-- Table structure for user_coupon
-- ----------------------------
DROP TABLE IF EXISTS `user_coupon`;
CREATE TABLE `user_coupon` (
  `user_coupon_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `user_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户编号',
  `coupon_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '卡券编号',
  `use_status` int(1) DEFAULT NULL COMMENT '使用状态',
  `get_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '领取时间',
  PRIMARY KEY (`user_coupon_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='用户优惠券表';

-- ----------------------------
-- Records of user_coupon
-- ----------------------------

-- ----------------------------
-- Table structure for user_details
-- ----------------------------
DROP TABLE IF EXISTS `user_details`;
CREATE TABLE `user_details` (
  `user_details_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '编号',
  `user_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户id',
  `phone` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '联系方式',
  `email` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `sex` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '性别',
  `real_name` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '真实姓名',
  `id_card` varchar(18) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '身份证',
  PRIMARY KEY (`user_details_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='用户详情表';

-- ----------------------------
-- Records of user_details
-- ----------------------------
INSERT INTO `user_details` VALUES ('12312dsdaasda', 'b5966d135478ad38322f05f7998fb24b', '18785361585', '1206834441@qq.com', '男', '周是', '522132193510157612');
INSERT INTO `user_details` VALUES ('1231daasdaasd', '011732df4d5d9b6270e5b9ce59453d42', '18785361585', '1206834441@qq.com', '男', '周是', '522132193510157612');

-- ----------------------------
-- Table structure for watch
-- ----------------------------
DROP TABLE IF EXISTS `watch`;
CREATE TABLE `watch` (
  `watch_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '编号',
  `user_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户编号',
  `goods_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品或商家编号',
  `type` int(1) DEFAULT NULL COMMENT '关注类型 0:商家，1:商品',
  `delete_status` int(1) DEFAULT NULL COMMENT '逻辑删除  0:删除，1:正常',
  PRIMARY KEY (`watch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='关注表';

-- ----------------------------
-- Records of watch
-- ----------------------------
