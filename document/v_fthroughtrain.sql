/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : v_fthroughtrain

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-01-20 10:18:59
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
INSERT INTO `back_menu` VALUES ('1', '农家蔬果直通车', '1', '', 'images/logo.png', '2020-01-19 12:32:51', 'admin:admin', '0', '2020-01-19 12:32:51', '0', '-1', '_self');
INSERT INTO `back_menu` VALUES ('10', '角色管理', '1', '/role', 'fa fa-file-text', '2020-01-19 13:41:18', 'admin:admin', '0', '2020-01-19 13:41:18', '0', '8', '_self');
INSERT INTO `back_menu` VALUES ('11', '授权管理', '1', '/rolepermission', 'fa fa-file-text', '2020-01-19 13:41:23', 'admin:admin', '0', '2020-01-19 13:41:23', '0', '8', '_self');
INSERT INTO `back_menu` VALUES ('12', '商家管理', '3', '', 'fa fa-calendar', '2020-01-19 13:50:43', 'admin:admin', '0', '2020-01-19 13:50:43', '0', '2', '_self');
INSERT INTO `back_menu` VALUES ('13', '商家信息', '1', '/shopInfo', 'fa fa-list-alt', '2020-01-19 13:43:19', 'admin:admin', '0', '2020-01-19 13:43:19', '0', '12', '_self');
INSERT INTO `back_menu` VALUES ('14', '商家录入', '1', '/addshop', 'fa fa-navicon', '2020-01-19 13:43:22', 'admin:admin', '0', '2020-01-19 13:43:22', '0', '12', '_self');
INSERT INTO `back_menu` VALUES ('2', '后台管理系统', '1', '', 'fa fa-address-book', '2020-01-19 12:32:53', 'admin:admin', '0', '2020-01-19 12:32:53', '0', '-1', '_self');
INSERT INTO `back_menu` VALUES ('3', '系统菜单管理', '1', '/menu', 'fa fa-window-maximize', '2020-01-19 14:42:59', 'admin:admin', '0', '2020-01-19 14:42:59', '0', '2', '_self');
INSERT INTO `back_menu` VALUES ('4', '清理缓存', null, 'api/clear.json', null, '2020-01-19 12:50:23', 'admin:admin', null, '2020-01-19 12:50:23', null, '-1', '');
INSERT INTO `back_menu` VALUES ('5', '用户管理', '4', '', 'fa fa-calendar', '2020-01-19 13:50:34', 'admin:admin', '0', '2020-01-19 13:50:34', '0', '2', '_self');
INSERT INTO `back_menu` VALUES ('6', '用户数据统计', '1', '/role', 'fa fa-file-text', '2020-01-19 13:38:31', 'admin:admin', '0', '2020-01-19 13:38:31', '0', '5', '_self');
INSERT INTO `back_menu` VALUES ('7', '用户信息', '1', '/userInfo', 'fa fa-file-text', '2020-01-19 13:38:37', 'admin:admin', '0', '2020-01-19 13:38:37', '0', '5', '_self');
INSERT INTO `back_menu` VALUES ('8', '权限管理', '2', '', 'fa fa-calendar', '2020-01-19 13:50:39', 'admin:admin', '0', '2020-01-19 13:50:39', '0', '2', '_self');
INSERT INTO `back_menu` VALUES ('9', '资源管理', '1', '/permission', 'fa fa-file-text', '2020-01-19 13:41:17', 'admin:admin', '0', '2020-01-19 13:41:17', '0', '8', '_self');

-- ----------------------------
-- Table structure for banner
-- ----------------------------
DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner` (
  `banner_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '编号',
  `banner_description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '图片描述',
  `banner_url` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '图片地址',
  `goods_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '关联商品',
  PRIMARY KEY (`banner_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='轮播表';

-- ----------------------------
-- Records of banner
-- ----------------------------

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

-- ----------------------------
-- Table structure for goods_category
-- ----------------------------
DROP TABLE IF EXISTS `goods_category`;
CREATE TABLE `goods_category` (
  `goods_category_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `goods_category_name` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '类别名字',
  `goods_category_description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '类别描述',
  `goods_category_status` int(1) DEFAULT NULL COMMENT '类别状态',
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
  `goods_images_url` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '图片地址',
  `goods_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品编号',
  PRIMARY KEY (`goods_images_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='商品详情页表';

-- ----------------------------
-- Records of goods_images
-- ----------------------------

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
INSERT INTO `permission` VALUES ('0c5408f54aef7788f4f303d457b1e2cf', '角色管理', '/role', '角色管理菜单');
INSERT INTO `permission` VALUES ('1b06e3f7510f0b2670c3a2698643106f', '授权管理', '/rolepermission', '授权管理');
INSERT INTO `permission` VALUES ('f7eb6804cacd39bbea73cf964d81a37a', '资源管理', '/permission', '资源管理');

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
INSERT INTO `shop_store` VALUES ('1', '理发的', '就是理发的', '011732df4d5d9b6270e5b9ce59453d42', '2020-01-18 12:15:06', '0');
INSERT INTO `shop_store` VALUES ('20cc494f788298aceb7c072bd09d0a7c', '苹果店', '买苹果的', 'b5966d135478ad38322f05f7998fb24b', '2020-01-19 11:58:06', '0');
INSERT INTO `shop_store` VALUES ('531b593d35dc3557c513d707301e7b6f', '香蕉店', '买香蕉', '011732df4d5d9b6270e5b9ce59453d42', '2020-01-18 13:07:17', '1');
INSERT INTO `shop_store` VALUES ('5503cb4690d70d7b621dd8716824fd71', '苹果店', '买苹果的', 'b5966d135478ad38322f05f7998fb24b', '2020-01-19 11:58:12', '1');
INSERT INTO `shop_store` VALUES ('c8e1d9cd703a3aa311dcacf8b8782488', '洗头店', '洗头的', '011732df4d5d9b6270e5b9ce59453d42', null, '1');

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
INSERT INTO `user` VALUES ('011732df4d5d9b6270e5b9ce59453d42', 'wanjy', '小猫咪', '72803f8d03ecd02e88976ea822ec260d', 'S8MX', '4', '1', '2020-01-17 15:46:25');
INSERT INTO `user` VALUES ('b5966d135478ad38322f05f7998fb24b', 'admin', '管理员', 'be056463f899115df56108efd5a33719', 'b8pt', '4', '1', '2020-01-16 19:26:07');

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
