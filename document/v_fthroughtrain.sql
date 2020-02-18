/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : v_fthroughtrain

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-02-18 14:59:47
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
INSERT INTO `back_menu` VALUES ('2', '后台管理系统', '1', '', 'fa fa-address-book', '2020-01-20 12:38:24', '', '0', '2020-01-20 12:38:24', '0', '-1', '_self');
INSERT INTO `back_menu` VALUES ('2d7d6459e88c186125c2c6ec4ddbda96', '订单管理', '8', '', 'fa ', '2020-01-20 13:37:11', 'admin:shop', '0', '2020-01-20 13:37:11', '0', '2', '_self');
INSERT INTO `back_menu` VALUES ('3', '系统菜单管理', '1', '/menu', 'fa fa-window-maximize', '2020-01-19 14:42:59', 'admin:admin', '0', '2020-01-19 14:42:59', '0', '2', '_self');
INSERT INTO `back_menu` VALUES ('32d51dc9a8a1910e0135e14cb8c2559f', '添加轮播图', '1', '/addbanner', 'fa fa-diamond', '2020-02-17 22:04:39', 'admin:admin', '0', '2020-02-17 22:04:39', '0', 'b83b2e0847bae9701624a21d652fba39', '_self');
INSERT INTO `back_menu` VALUES ('336deb632514c6eed96be86206517d57', '订单信息', '8', '/shoporder', 'fa fa-building-o', '2020-01-20 13:37:53', 'admin:shop', '0', '2020-01-20 13:37:53', '0', '2d7d6459e88c186125c2c6ec4ddbda96', '_self');
INSERT INTO `back_menu` VALUES ('4', '清理缓存', null, 'api/clear.json', null, '2020-01-20 12:38:59', '', null, '2020-01-20 12:38:59', null, '-1', '');
INSERT INTO `back_menu` VALUES ('5', '用户管理', '4', '', 'fa fa-calendar', '2020-01-19 13:50:34', 'admin:admin', '0', '2020-01-19 13:50:34', '0', '2', '_self');
INSERT INTO `back_menu` VALUES ('6', '用户数据统计', '1', '/role', 'fa fa-file-text', '2020-01-19 13:38:31', 'admin:admin', '0', '2020-01-19 13:38:31', '0', '5', '_self');
INSERT INTO `back_menu` VALUES ('7', '用户信息', '1', '/userInfo', 'fa fa-file-text', '2020-01-19 13:38:37', 'admin:admin', '0', '2020-01-19 13:38:37', '0', '5', '_self');
INSERT INTO `back_menu` VALUES ('705d5ce1bd8cf779003832b5e4256fb8', '商城菜单管理', '10', '/shopmenu', 'fa fa-group', '2020-01-20 13:43:09', 'admin:admin', '0', null, '0', '2', '_self');
INSERT INTO `back_menu` VALUES ('7c701e22ca6b9dfb69ff0973d163d62f', '商家审核', '3', '/userToshop', 'fa fa-eye', '2020-02-18 14:57:18', 'admin:admin', '0', null, '0', '12', '_self');
INSERT INTO `back_menu` VALUES ('7f846532e9865511ee1710495ca07570', '上架商品', '1', '/addgoods', 'fa fa-columns', '2020-01-20 12:11:00', 'admin:shop', '0', null, '0', 'f0ed143af49c280899cc370d8ee5a7b5', '_self');
INSERT INTO `back_menu` VALUES ('8', '权限管理', '2', '', 'fa fa-calendar', '2020-01-19 13:50:39', 'admin:admin', '0', '2020-01-19 13:50:39', '0', '2', '_self');
INSERT INTO `back_menu` VALUES ('9', '资源管理', '1', '/permission', 'fa fa-file-text', '2020-01-19 13:41:17', 'admin:admin', '0', '2020-01-19 13:41:17', '0', '8', '_self');
INSERT INTO `back_menu` VALUES ('912fa4eb2112bf7f80c6d72a5d237bb7', '查看轮播图', '0', '/viewbanner', 'fa fa-diamond', '2020-02-17 22:04:33', 'admin:admin', '0', '2020-02-17 22:04:33', '0', 'b83b2e0847bae9701624a21d652fba39', '_self');
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
INSERT INTO `banner` VALUES ('00ccaeeed920c306c22869c5c8a43515', '新鲜蔬菜', 'http://localhost:8080/photo/65ed4bf4add34e959994d5b780391c07.jpg', 'cdb54f1f07bf5bd325615d03a7e50485', '1');
INSERT INTO `banner` VALUES ('04534f04e55c856d6a76356395f97ea1', '新鲜水果', 'http://localhost:8080/photo/6dc0f11cdf3b427580f7b22fa5287e46.jpg', 'fd24703545f0438636b14df021b8dd4e', '1');
INSERT INTO `banner` VALUES ('d254c5d8a96407430f2806da7022ecf5', '新鲜蔬果', 'http://localhost:8080/photo/6deafadf53934273a824b97455317d21.jpg', 'fd24703545f0438636b14df021b8dd4e', '1');

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
INSERT INTO `category` VALUES ('9619cee863ea3c48e1f35e0d37114dbd', '蔬菜', '绿色的蔬菜');
INSERT INTO `category` VALUES ('a51045578d1bb20556da2760c0c178aa', '水果', '香甜的水果');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goods_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `goods_name` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品名字',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '商品创建时间',
  `shop_store_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '归属商家',
  `is_delete` int(1) DEFAULT '0' COMMENT '逻辑删除，1表示删除，0表示未删除',
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='商品表';

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('07235d02713e12ee96751879aec8ebc3', '南瓜', '2020-02-17 19:34:22', 'e9b736feed13141c436a385aead46464', '0');
INSERT INTO `goods` VALUES ('13acec17a6347ee186657e98693e7702', '李子', '2020-02-16 19:35:33', 'e9b736feed13141c436a385aead46464', '0');
INSERT INTO `goods` VALUES ('141ef5cdd72a539dc2d499a77bbf3773', '香蕉2', '2020-02-14 15:27:12', 'e9b736feed13141c436a385aead46464', '0');
INSERT INTO `goods` VALUES ('3841760a3f562457bb1b0fca7d0af5b9', '蒜苗', '2020-02-17 15:31:34', 'e9b736feed13141c436a385aead46464', '0');
INSERT INTO `goods` VALUES ('735822a82d67f7c25bebb8cbccc56ee8', '香蕉', '2020-02-14 15:27:00', 'e9b736feed13141c436a385aead46464', '0');
INSERT INTO `goods` VALUES ('a2e46ae2132a3f32ee45455b380d6ddc', '黄瓜', '2020-02-09 15:34:15', 'e9b736feed13141c436a385aead46464', '0');
INSERT INTO `goods` VALUES ('bcfc1e77f8cdb1724d71eaff0baf6005', '大白菜', '2020-02-17 15:30:44', 'e9b736feed13141c436a385aead46464', '0');
INSERT INTO `goods` VALUES ('cdb54f1f07bf5bd325615d03a7e50485', '可口苹果', '2020-02-12 13:49:47', 'e9b736feed13141c436a385aead46464', '0');
INSERT INTO `goods` VALUES ('fd24703545f0438636b14df021b8dd4e', '红富士苹果', '2020-02-15 13:48:20', 'e9b736feed13141c436a385aead46464', '0');
INSERT INTO `goods` VALUES ('fd3c8edfb4391a0f57d4689e15bc84de', '梨子', '2020-02-17 15:29:31', 'e9b736feed13141c436a385aead46464', '0');

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
INSERT INTO `goods_category` VALUES ('006e5db227e14c96d7870a8731fb16fc', '9619cee863ea3c48e1f35e0d37114dbd', '07235d02713e12ee96751879aec8ebc3');
INSERT INTO `goods_category` VALUES ('111453746f42bd5ef523b0b205671afe', '9619cee863ea3c48e1f35e0d37114dbd', 'a2e46ae2132a3f32ee45455b380d6ddc');
INSERT INTO `goods_category` VALUES ('23153f78109af1604c95e45cf1e162b4', 'a51045578d1bb20556da2760c0c178aa', '735822a82d67f7c25bebb8cbccc56ee8');
INSERT INTO `goods_category` VALUES ('23759b27c7feef242de69ad7ab036737', '9619cee863ea3c48e1f35e0d37114dbd', 'bcfc1e77f8cdb1724d71eaff0baf6005');
INSERT INTO `goods_category` VALUES ('49d701081cec4a40c6e642e15be85399', 'a51045578d1bb20556da2760c0c178aa', 'fd24703545f0438636b14df021b8dd4e');
INSERT INTO `goods_category` VALUES ('5bfa8aa02c0e5adb5ff291ddcd299738', 'a51045578d1bb20556da2760c0c178aa', 'cdb54f1f07bf5bd325615d03a7e50485');
INSERT INTO `goods_category` VALUES ('5ddc13fc913a7975e2d4844663131194', '9619cee863ea3c48e1f35e0d37114dbd', '3841760a3f562457bb1b0fca7d0af5b9');
INSERT INTO `goods_category` VALUES ('8f0b568347697f6cb7a620778a59418b', 'a51045578d1bb20556da2760c0c178aa', '13acec17a6347ee186657e98693e7702');
INSERT INTO `goods_category` VALUES ('a8f7c25765b47ef31b771762dd81b107', 'a51045578d1bb20556da2760c0c178aa', 'fd3c8edfb4391a0f57d4689e15bc84de');
INSERT INTO `goods_category` VALUES ('bcacb33c6bd9705b5df15b4939a91303', 'a51045578d1bb20556da2760c0c178aa', '141ef5cdd72a539dc2d499a77bbf3773');

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
INSERT INTO `goods_images` VALUES ('0414e5283c485b41401d80bcfe108780', 'http://localhost:8080/photo/9e477f2166894300a9acbd8350d4e240.jpg,http://localhost:8080/photo/e5179e66b9ea4fbd8867b825675a6c73.jpg,http://localhost:8080/photo/0ee6b0ecd6ee4e20ad05ecbbfa28b7fd.jpg', 'fd24703545f0438636b14df021b8dd4e');
INSERT INTO `goods_images` VALUES ('07597eaab6fda163f6df76a043d6fbfd', 'http://localhost:8080/photo/929e2cf1e4754c1a90699f2c4d2c1b35.jpg,http://localhost:8080/photo/126378cee22a491eb314a92a48b679f1.jpg', 'a2e46ae2132a3f32ee45455b380d6ddc');
INSERT INTO `goods_images` VALUES ('87b8b48bc3b8cac54279a1ac3a27ec84', 'http://localhost:8080/photo/300535c4ff174a0bbb551b375f14fa54.jpg,http://localhost:8080/photo/81a3240efca34e35bcf4aa6a8e079708.jpg', 'bcfc1e77f8cdb1724d71eaff0baf6005');
INSERT INTO `goods_images` VALUES ('a16633ba57a0c5d06e4a15ae311eae09', 'http://localhost:8080/photo/10367a00eafd44fda94623eab2715cd0.jpg,http://localhost:8080/photo/771c4b6dd33a493da5fa7f0c09cffa8e.jpg', '07235d02713e12ee96751879aec8ebc3');
INSERT INTO `goods_images` VALUES ('b1698e06ecd470e38c31621e197d17a5', 'http://localhost:8080/photo/6a8be4a6fe7b4552a65c01f97cce2c6e.jpg,http://localhost:8080/photo/2f284630949244a4b461056e24f9cf74.jpg', '141ef5cdd72a539dc2d499a77bbf3773');
INSERT INTO `goods_images` VALUES ('b91dfb48c8b0e62ba33bfeb919ece8c8', 'http://localhost:8080/photo/6a8be4a6fe7b4552a65c01f97cce2c6e.jpg,http://localhost:8080/photo/2f284630949244a4b461056e24f9cf74.jpg', '735822a82d67f7c25bebb8cbccc56ee8');
INSERT INTO `goods_images` VALUES ('cd48e5324e51786147091cbf897eac39', 'http://localhost:8080/photo/b739cdb087af4780ab9d2929b02144ff.jpg,http://localhost:8080/photo/2699c446c50141469d5ee83b31dd0bba.jpg', '3841760a3f562457bb1b0fca7d0af5b9');
INSERT INTO `goods_images` VALUES ('cea008c7cd606a8dcab9f9a80ec99aa2', 'http://localhost:8080/photo/3e3499d7622946e49b3fac90da57463f.jpg,http://localhost:8080/photo/59bf2b0b210b4a9c8462815a55b7e3f8.jpg,http://localhost:8080/photo/dfd4ab43b97640f084acfbfa5e938660.jpg', 'fd3c8edfb4391a0f57d4689e15bc84de');
INSERT INTO `goods_images` VALUES ('e0eb6b6749efa1e8d908ca57c76ba96f', 'http://localhost:8080/photo/b857dca3e81048eb8c317413df8d7a07.jpg,http://localhost:8080/photo/2457a4f67ff04a2a9c96e942f304a7e8.jpg', '13acec17a6347ee186657e98693e7702');
INSERT INTO `goods_images` VALUES ('fbf16c68a6d8944b2b37e38d7c3c2116', 'http://localhost:8080/photo/129419646d624a73b31498b867f2cfa4.jpg,http://localhost:8080/photo/ae90e43bdfab402b949a5bc7108d1084.jpg,http://localhost:8080/photo/2452d18f972e485b9cb274b910175eff.jpg', 'cdb54f1f07bf5bd325615d03a7e50485');

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
INSERT INTO `goods_norms` VALUES ('17d277c57e4af9b18b11f0a50a01ab01', '735822a82d67f7c25bebb8cbccc56ee8', '12.00', '11.00', '2kg', '1', '50');
INSERT INTO `goods_norms` VALUES ('357283861119af6382a143303985ce11', 'fd24703545f0438636b14df021b8dd4e', '9.90', '8.80', '1kg', '1', '50');
INSERT INTO `goods_norms` VALUES ('6b31deaaf1015f7778ff9e1d34c77763', '07235d02713e12ee96751879aec8ebc3', '30.00', '25.50', '5kg', '1', '100');
INSERT INTO `goods_norms` VALUES ('76982adf0049872d2933e5acf79a701b', '141ef5cdd72a539dc2d499a77bbf3773', '12.00', '11.00', '2kg', '1', '50');
INSERT INTO `goods_norms` VALUES ('7d043bd2a9e25f9dbeb3807c76e8dc31', '3841760a3f562457bb1b0fca7d0af5b9', '8.00', '6.60', '1kg', '1', '35');
INSERT INTO `goods_norms` VALUES ('8af16cbcb2a606c13d0ec43e57da4f2c', 'fd3c8edfb4391a0f57d4689e15bc84de', '36.00', '29.90', '3kg', '1', '150');
INSERT INTO `goods_norms` VALUES ('bb7920f9142708cf7a9b75283abfccd7', 'fd24703545f0438636b14df021b8dd4e', '49.90', '45.90', '5kg', '1', '20');
INSERT INTO `goods_norms` VALUES ('c391e1db5a5da53409111ac747b84f38', 'cdb54f1f07bf5bd325615d03a7e50485', '5.99', '5.59', '1kg', '1', '50');
INSERT INTO `goods_norms` VALUES ('d10208653789892ac492dccf6f2ce93b', 'a2e46ae2132a3f32ee45455b380d6ddc', '4.00', '3.99', '2kg', '1', '60');
INSERT INTO `goods_norms` VALUES ('eb08da3bcd7ae880f9e2f7c89e2587fd', 'bcfc1e77f8cdb1724d71eaff0baf6005', '3.00', '2.80', '1kg', '1', '40');
INSERT INTO `goods_norms` VALUES ('fc71a6fe5fcae74c860fa70ecad0b74d', '13acec17a6347ee186657e98693e7702', '30.00', '28.80', '5kg', '1', '200');

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
INSERT INTO `menu` VALUES ('7e566abd4e238ca115ee3fe0ad6ed54d', '本地水果', 'a51045578d1bb20556da2760c0c178aa', '', '1');
INSERT INTO `menu` VALUES ('7fda963e53a594ffb557d64ba05af19f', '本地蔬菜', '9619cee863ea3c48e1f35e0d37114dbd', '', '1');

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
INSERT INTO `permission` VALUES ('9a2319763f830e56caecdb6d7b16a37e', null, null, null);
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
INSERT INTO `shop_car` VALUES ('cb528f23b931b825835edbe761342971', '4c0a8228f927b6b252e10f6b8323c347', '735822a82d67f7c25bebb8cbccc56ee8', '17d277c57e4af9b18b11f0a50a01ab01', '4', '11', '44');

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
INSERT INTO `shop_store` VALUES ('e9b736feed13141c436a385aead46464', '苹果旗舰店', '各种苹果，又甜又鲜', '011732df4d5d9b6270e5b9ce59453d42', null, '1');

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
