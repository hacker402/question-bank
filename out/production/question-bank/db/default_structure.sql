/*
Navicat MySQL Data Transfer

Source Server         : 192.168.8.112
Source Server Version : 50635
Source Host           : 192.168.8.112:3306
Source Database       : lb_taobao

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2019-09-06 18:23:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for manage_menu
-- ----------------------------
DROP TABLE IF EXISTS `manage_menu`;
CREATE TABLE `manage_menu` (
  `id` varchar(50) NOT NULL,
  `parent_id` varchar(50) NOT NULL COMMENT '父级ID',
  `menu_name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `menu_title` varchar(255) DEFAULT NULL COMMENT '菜单title',
  `menu_path` varchar(255) DEFAULT NULL COMMENT '菜单路由',
  `menu_icon` varchar(255) DEFAULT NULL COMMENT '菜单图标',
  `component` varchar(255) DEFAULT NULL COMMENT '组件类型',
  `menu_order` int(2) DEFAULT NULL COMMENT '菜单排序',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='菜单表';

-- ----------------------------
-- Records of manage_menu
-- ----------------------------
INSERT INTO `manage_menu` VALUES ('1166634632393904129', '0', 'manage', '统一后台管理', 'manage', null, 'Main', '1', null, '2019-09-02 16:46:56');
INSERT INTO `manage_menu` VALUES ('1168458105870548994', '0', 'shops', '宝贝管理', null, null, null, null, '2019-09-02 17:38:16', null);
INSERT INTO `manage_menu` VALUES ('1168460898954051585', '0', 'agent', '代理商管理', null, null, null, null, '2019-09-02 17:49:22', null);
INSERT INTO `manage_menu` VALUES ('1168460971821694977', '0', 'order', '订单管理', null, null, null, null, '2019-09-02 17:49:39', null);
INSERT INTO `manage_menu` VALUES ('1168709439513382914', '0', 'system', '系统配置', null, null, null, null, '2019-09-03 10:16:59', null);
INSERT INTO `manage_menu` VALUES ('1169089405290139649', '0', 'bill', '对账单', null, null, null, null, '2019-09-04 11:26:50', null);
INSERT INTO `manage_menu` VALUES ('1169089467680411649', '0', 'daily', '操作日志', null, null, null, null, '2019-09-04 11:27:04', null);
INSERT INTO `manage_menu` VALUES ('1169196899766874113', '0', 'zip', '压缩包配置', null, null, null, null, '2019-09-04 18:33:58', null);
INSERT INTO `manage_menu` VALUES ('1169418706078248961', '0', 'reports', '统计报表', null, null, null, null, '2019-09-05 09:15:21', null);
INSERT INTO `manage_menu` VALUES ('1169856028059570178', '0', 'advert', '广告管理', null, null, null, null, '2019-09-06 14:13:07', null);

-- ----------------------------
-- Table structure for manage_role
-- ----------------------------
DROP TABLE IF EXISTS `manage_role`;
CREATE TABLE `manage_role` (
  `id` varchar(50) NOT NULL,
  `role_name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `enable` tinyint(1) DEFAULT '1' COMMENT '是否启用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `role_code` varchar(100) DEFAULT NULL COMMENT '角色编码',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_role_code` (`role_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户角色表';

-- ----------------------------
-- Records of manage_role
-- ----------------------------
INSERT INTO `manage_role` VALUES ('1166616807256203261', '管理员', '1', '2019-09-02 16:45:07', '2019-09-02 16:45:11', 'admin');
INSERT INTO `manage_role` VALUES ('1166616807256203262', '代理商', '1', '2019-09-03 09:36:14', '2019-09-03 09:36:16', 'agent');

-- ----------------------------
-- Table structure for manage_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `manage_role_menu`;
CREATE TABLE `manage_role_menu` (
  `id` varchar(50) NOT NULL,
  `role_id` varchar(50) NOT NULL COMMENT '角色ID',
  `menu_id` varchar(50) NOT NULL COMMENT '菜单ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色菜单表';

-- ----------------------------
-- Records of manage_role_menu
-- ----------------------------
INSERT INTO `manage_role_menu` VALUES ('1169856130266370050', '1166616807256203261', '1168458105870548994', '2019-09-06 14:13:31');
INSERT INTO `manage_role_menu` VALUES ('1169856130295730178', '1166616807256203261', '1168460898954051585', '2019-09-06 14:13:31');
INSERT INTO `manage_role_menu` VALUES ('1169856130304118786', '1166616807256203261', '1168460971821694977', '2019-09-06 14:13:31');
INSERT INTO `manage_role_menu` VALUES ('1169856130316701697', '1166616807256203261', '1168709439513382914', '2019-09-06 14:13:31');
INSERT INTO `manage_role_menu` VALUES ('1169856130329284609', '1166616807256203261', '1169089405290139649', '2019-09-06 14:13:31');
INSERT INTO `manage_role_menu` VALUES ('1169856130341867522', '1166616807256203261', '1169089467680411649', '2019-09-06 14:13:31');
INSERT INTO `manage_role_menu` VALUES ('1169856130354450433', '1166616807256203261', '1169196899766874113', '2019-09-06 14:13:31');
INSERT INTO `manage_role_menu` VALUES ('1169856130367033345', '1166616807256203261', '1169418706078248961', '2019-09-06 14:13:31');
INSERT INTO `manage_role_menu` VALUES ('1169856130383810562', '1166616807256203261', '1169856028059570178', '2019-09-06 14:13:31');
INSERT INTO `manage_role_menu` VALUES ('1169856130392199170', '1166616807256203261', '1166634632393904129', '2019-09-06 14:13:31');

-- ----------------------------
-- Table structure for manage_user
-- ----------------------------
DROP TABLE IF EXISTS `manage_user`;
CREATE TABLE `manage_user` (
  `id` varchar(50) NOT NULL,
  `user_name` varchar(100) NOT NULL COMMENT '用户名',
  `pass` varchar(255) NOT NULL COMMENT '密码',
  `nick_name` varchar(100) NOT NULL DEFAULT '' COMMENT '昵称',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `balance` double(7,1) NOT NULL DEFAULT '0.0' COMMENT '余额',
  `user_type` int(1) NOT NULL DEFAULT '1' COMMENT '用户类型：1-管理员，2-代理商',
  `role_id` varchar(255) NOT NULL COMMENT '角色Id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `enable` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否启用',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_user_name` (`user_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- ----------------------------
-- Records of manage_user
-- ----------------------------
INSERT INTO `manage_user` VALUES ('1167288039630741578', 'admin', '4QrcOUm6Wau+VuBX8g+IPg==', '管理员', '64556@qq.com', '15972937919', '0.0', '1', '1166616807256203261', '2019-08-29 11:54:58', '1');
INSERT INTO `manage_user` VALUES ('1168814861673394177', '1111', 'WDt7Ri7TPGp2Vyx7id61BQ==', '代理商1', '12345678@qq.com', '15836978944', '40.0', '2', '1166616807256203262', '2019-09-03 17:15:53', '1');
INSERT INTO `manage_user` VALUES ('1168815148236652546', 'ellen_xiang', 'zXKZXswoAZogbIknj4zThw==', '代理商', '12641654@qq.com', '15975463215', '10.5', '2', '1166616807256203262', '2019-09-03 17:17:02', '1');
INSERT INTO `manage_user` VALUES ('1169081887402872833', '123456', 'WDt7Ri7TPGp2Vyx7id61BQ==', '代理商2', '925418687@qq.com', '13525871456', '0.0', '2', '1166616807256203262', '2019-09-04 10:56:57', '1');
INSERT INTO `manage_user` VALUES ('1169084265988444162', '1234567', 'WDt7Ri7TPGp2Vyx7id61BQ==', '代理商3', '925418458@163.com', '18547513256', '0.0', '2', '1166616807256203262', '2019-09-04 11:06:24', '1');
INSERT INTO `manage_user` VALUES ('1169088101553655809', '12345678', 'WDt7Ri7TPGp2Vyx7id61BQ==', '代理商4', '9254188356@163.com', '15823697456', '0.0', '2', '1166616807256203262', '2019-09-04 11:21:39', '1');
INSERT INTO `manage_user` VALUES ('1169088314901123074', '7654321', 'WDt7Ri7TPGp2Vyx7id61BQ==', '代理商5', '99584585@163.com', '18612345689', '0.0', '2', '1166616807256203262', '2019-09-04 11:22:30', '1');
INSERT INTO `manage_user` VALUES ('1169088445260091393', 'test001', '4QrcOUm6Wau+VuBX8g+IPg==', '代理商', '9s25417892@qq.com', '15879546845', '0.0', '2', '1166616807256203262', '2019-09-04 11:23:01', '1');

-- ----------------------------
-- Table structure for operation_logs
-- ----------------------------
DROP TABLE IF EXISTS `operation_logs`;
CREATE TABLE `operation_logs` (
  `id` varchar(50) NOT NULL,
  `target_type` varchar(100) NOT NULL COMMENT '目标类型',
  `target_id` varchar(50) NOT NULL COMMENT '目标ID',
  `target_name` varchar(255) NOT NULL COMMENT '目标名称',
  `action_code` varchar(100) NOT NULL COMMENT '操作类型：update、add、delete等等',
  `description` text COMMENT '描述信息',
  `operator_user_id` varchar(50) NOT NULL COMMENT '操作用户ID',
  `operator_user_name` varchar(255) NOT NULL COMMENT '操作用户名称',
  `ip` varchar(255) NOT NULL COMMENT '操作IP',
  `create_time` datetime NOT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`),
  KEY `target_type` (`target_type`,`target_id`,`action_code`,`create_time`),
  KEY `target_type_2` (`target_type`,`target_id`,`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='操作日志表';

-- ----------------------------
-- Records of operation_logs
-- ----------------------------
INSERT INTO `operation_logs` VALUES ('1', 'add', '1', '测试', 'update', '新增数据', '1', 'admin', '127.0.0.1', '2019-09-06 16:58:45');

-- ----------------------------
-- Table structure for t_ad_info
-- ----------------------------
DROP TABLE IF EXISTS `t_ad_info`;
CREATE TABLE `t_ad_info` (
  `id` varchar(50) NOT NULL COMMENT '主键ID',
  `f_user_id` varchar(50) NOT NULL COMMENT '代理商ID',
  `f_ad_picture` varchar(50) NOT NULL COMMENT '广告图',
  `f_ad_link` varchar(200) NOT NULL DEFAULT '' COMMENT '广告链接',
  `f_ad_bak` varchar(200) NOT NULL DEFAULT '' COMMENT '备注',
  `f_create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `f_enabled` tinyint(4) DEFAULT '1' COMMENT '启用/禁用:1-启用，0-禁用',
  `f_oss_id` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='广告配置表';

-- ----------------------------
-- Records of t_ad_info
-- ----------------------------
INSERT INTO `t_ad_info` VALUES ('1169892030937534465', '1167288039630741578', '广告', 'tex', '备注s', '2019-09-06 16:36:10', '0', '');
INSERT INTO `t_ad_info` VALUES ('1169892426561064962', '1167288039630741578', '广告', 'http', '测试一下', '2019-09-06 16:37:45', '1', '996f1c3b-0d20-4376-a434-347ab0df05ba');

-- ----------------------------
-- Table structure for t_pay_order
-- ----------------------------
DROP TABLE IF EXISTS `t_pay_order`;
CREATE TABLE `t_pay_order` (
  `id` varchar(50) NOT NULL COMMENT '主键ID',
  `f_user_id` varchar(50) NOT NULL COMMENT '代理商ID',
  `f_product_name` varchar(50) NOT NULL COMMENT '产品名字',
  `f_product_desc` varchar(200) NOT NULL DEFAULT '' COMMENT '产品描述',
  `f_pay_way` varchar(50) NOT NULL COMMENT '支付方式 wxpay：微信 alipay: 支付宝',
  `f_pay_amount` double(7,1) NOT NULL DEFAULT '0.0' COMMENT '充值金额',
  `f_pay_state` int(11) NOT NULL COMMENT '支付状态 0:为支付 1:以支付',
  `f_create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='充值订单表';

-- ----------------------------
-- Records of t_pay_order
-- ----------------------------
INSERT INTO `t_pay_order` VALUES ('1167288039630741578', '1167288039630741578', 'test', 'testtest', 'wxpay', '10.2', '0', '2019-09-05 14:17:16');
INSERT INTO `t_pay_order` VALUES ('1169492659641204737', '1167288039630741578', 'test', 'testtest', 'wxpay', '10.2', '1', '2019-09-05 14:09:13');
INSERT INTO `t_pay_order` VALUES ('1169494049453199362', '1169084265988444162', 'test', 'testtest', 'wxpay', '10.2', '0', '2019-09-05 14:14:44');
INSERT INTO `t_pay_order` VALUES ('1169495568705626114', '1167288039630741578', 'test', 'testtest', 'wxpay', '10.2', '0', '2019-09-05 14:20:46');
INSERT INTO `t_pay_order` VALUES ('1169495772368445441', '1167288039630741578', 'test', 'testtest', 'wxpay', '10.2', '-1', '2019-09-05 14:21:35');
INSERT INTO `t_pay_order` VALUES ('1169496586247970817', '1167288039630741578', 'test', 'testtest', 'alipay', '10.2', '0', '2019-09-05 14:24:49');
INSERT INTO `t_pay_order` VALUES ('1169498057744027650', '1169084265988444162', 'test', 'testtest', 'wxpay', '10.2', '0', '2019-09-05 14:30:40');
INSERT INTO `t_pay_order` VALUES ('1169498719768752129', '1167288039630741578', 'test', 'testtest', 'wxpay', '0.0', '2', '2019-09-05 14:33:18');
INSERT INTO `t_pay_order` VALUES ('1169499293666979842', '1169084265988444162', 'test', 'testtest', 'wxpay', '0.0', '0', '2019-09-05 14:35:35');
INSERT INTO `t_pay_order` VALUES ('1169889138209906690', '1167288039630741578', 'test', 'testtest', 'wxpay', '100.0', '0', '2019-09-06 16:24:41');
INSERT INTO `t_pay_order` VALUES ('1169889253779759106', '1167288039630741578', 'test', 'testtest', 'wxpay', '100.0', '0', '2019-09-06 16:25:08');
INSERT INTO `t_pay_order` VALUES ('1169889657204695041', '1167288039630741578', 'test', 'testtest', 'alipay', '500.0', '0', '2019-09-06 16:26:44');
INSERT INTO `t_pay_order` VALUES ('1169890012135133185', '1167288039630741578', 'æµè¯', 'testtest', 'alipay', '100.0', '0', '2019-09-06 16:28:09');

-- ----------------------------
-- Table structure for t_self_order
-- ----------------------------
DROP TABLE IF EXISTS `t_self_order`;
CREATE TABLE `t_self_order` (
  `id` varchar(50) NOT NULL COMMENT '主键ID，订单号',
  `f_site_id` varchar(50) NOT NULL COMMENT '宝贝ID',
  `f_user_id` varchar(50) NOT NULL COMMENT '代理商ID',
  `f_amount` int(11) NOT NULL COMMENT '件数',
  `f_amount_money` double(7,1) NOT NULL COMMENT '扣费',
  `f_create_time` datetime NOT NULL COMMENT '创建时间',
  `f_used` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否使用：1-是，0-否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='生成订单表';

-- ----------------------------
-- Records of t_self_order
-- ----------------------------
INSERT INTO `t_self_order` VALUES ('1169811865568354306', '2', '1167288039630741578', '2', '40.0', '2019-09-06 11:17:37', '0');
INSERT INTO `t_self_order` VALUES ('1169811904999006210', '2', '1167288039630741578', '20', '400.0', '2019-09-06 11:17:47', '0');
INSERT INTO `t_self_order` VALUES ('1169812038495313922', '2', '1167288039630741578', '100', '2000.0', '2019-09-06 11:18:19', '0');
INSERT INTO `t_self_order` VALUES ('1169814400383377409', '2', '1167288039630741578', '2', '40.0', '2019-09-06 11:27:42', '0');
INSERT INTO `t_self_order` VALUES ('1169814423179419650', '2', '1167288039630741578', '2', '40.0', '2019-09-06 11:27:47', '0');
INSERT INTO `t_self_order` VALUES ('1169814810162683905', '2', '1167288039630741578', '2', '40.0', '2019-09-06 11:29:20', '0');

-- ----------------------------
-- Table structure for t_site_zip_config
-- ----------------------------
DROP TABLE IF EXISTS `t_site_zip_config`;
CREATE TABLE `t_site_zip_config` (
  `id` varchar(50) NOT NULL COMMENT '主键ID',
  `f_site_id` int(11) NOT NULL COMMENT '宝贝ID',
  `f_user_id` varchar(50) NOT NULL COMMENT '代理商用户ID',
  `f_zip_id` varchar(50) NOT NULL COMMENT 'OSS存储ID',
  `f_file_name` varchar(50) NOT NULL COMMENT '文件名',
  `f_create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='压缩包配置';

-- ----------------------------
-- Records of t_site_zip_config
-- ----------------------------
INSERT INTO `t_site_zip_config` VALUES ('1169874246857850882', '2', '1167288039630741578', 'dee29c93-15b2-4b11-8dfe-be3c6c93fbea', '新建 Microsoft Word 文档.docx', '2019-09-06 15:25:30');
INSERT INTO `t_site_zip_config` VALUES ('1169876391313215490', '3', '1167288039630741578', '5af0e790-fb7b-4b88-88bd-8bc229c18e81', '公司简介2.pptx', '2019-09-06 15:34:02');

-- ----------------------------
-- Table structure for t_system_config
-- ----------------------------
DROP TABLE IF EXISTS `t_system_config`;
CREATE TABLE `t_system_config` (
  `id` varchar(50) NOT NULL COMMENT '主键ID',
  `f_name` varchar(100) NOT NULL COMMENT '名称',
  `f_check_type` int(11) NOT NULL DEFAULT '1' COMMENT '1-查重，2-降重',
  `f_edition` int(11) NOT NULL DEFAULT '0' COMMENT '版本',
  `f_edition_name` varchar(50) NOT NULL COMMENT '版本名称',
  `f_unit_price` double(7,1) NOT NULL DEFAULT '0.0' COMMENT '计费单价',
  `f_unit_type` int(11) NOT NULL DEFAULT '1' COMMENT '计费类型：1-按字数，2-按篇',
  `f_unit_word` int(11) NOT NULL DEFAULT '1000' COMMENT '计费单位',
  `f_min_word` int(11) NOT NULL DEFAULT '100' COMMENT '最小字数限制',
  `f_max_word` int(11) NOT NULL DEFAULT '300000' COMMENT '最大字数限制',
  `f_enabled` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否启用：1-启用，0-禁用',
  `f_create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统配置';

-- ----------------------------
-- Records of t_system_config
-- ----------------------------
INSERT INTO `t_system_config` VALUES ('11111111111', 'teste', '1', '0', '1', '0.0', '1', '1000', '100', '300000', '0', '2019-09-03 10:59:58');
INSERT INTO `t_system_config` VALUES ('1168770277414682626', 'test', '1', '1', 'test', '12.0', '1', '1000', '100', '3000', '0', '2019-09-03 14:18:43');
INSERT INTO `t_system_config` VALUES ('1168800310344716289', '测是', '2', '2', '测试一下', '20.0', '2', '10', '100', '400000', '1', '2019-09-03 16:18:04');
INSERT INTO `t_system_config` VALUES ('1169861578377891842', '我的测试', '2', '1', 'quqwTest01', '16.0', '1', '1000', '100', '300000', '1', '2019-09-06 14:35:10');
INSERT INTO `t_system_config` VALUES ('123', '专业版', '1', '3', '专业版', '0.0', '1', '1000', '100', '300000', '1', '2019-09-05 11:44:20');
INSERT INTO `t_system_config` VALUES ('124', '英文版', '1', '4', '英文版', '20.0', '1', '1560', '100', '300000', '1', '2019-09-05 11:44:58');
INSERT INTO `t_system_config` VALUES ('125', '知网PMLC', '1', '5', '知网PMLC', '0.0', '1', '1000', '100', '300000', '1', '2019-09-05 11:45:17');
INSERT INTO `t_system_config` VALUES ('126', '知网AMLC', '1', '6', '知网AMLC', '0.0', '1', '1000', '100', '300000', '1', '2019-09-05 11:45:37');
INSERT INTO `t_system_config` VALUES ('127', '知网vip5.1', '1', '7', '知网vip5.1', '0.0', '1', '1000', '100', '300000', '1', '2019-09-05 11:46:00');

-- ----------------------------
-- Table structure for t_taobao_order
-- ----------------------------
DROP TABLE IF EXISTS `t_taobao_order`;
CREATE TABLE `t_taobao_order` (
  `f_order_no` varchar(50) NOT NULL COMMENT '订单编号',
  `f_site_id` int(11) NOT NULL COMMENT '店铺ID',
  `f_total_amount` int(11) NOT NULL COMMENT '件数',
  `f_remain_amount` int(11) NOT NULL COMMENT '剩余可用件数',
  `f_create_time` datetime NOT NULL COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='淘宝订单表';

-- ----------------------------
-- Records of t_taobao_order
-- ----------------------------

-- ----------------------------
-- Table structure for t_taobao_site
-- ----------------------------
DROP TABLE IF EXISTS `t_taobao_site`;
CREATE TABLE `t_taobao_site` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '宝贝ID',
  `f_user_id` varchar(50) NOT NULL COMMENT '代理商ID',
  `f_config_id` varchar(50) NOT NULL COMMENT '系统配置ID',
  `f_name` varchar(100) NOT NULL COMMENT '店铺名称',
  `f_no_picture` varchar(255) NOT NULL DEFAULT '/static/images/angentPage_logo.gif' COMMENT '暂无图片配置',
  `f_domain` varchar(100) NOT NULL DEFAULT '' COMMENT '域名:默认生成',
  `f_logo` varchar(255) NOT NULL DEFAULT '/static/images/angentPage_logo.gif' COMMENT '站点LOGO',
  `f_show_user_id` varchar(255) NOT NULL DEFAULT '-1' COMMENT '淘宝店铺（授权API返回）',
  `f_taobao_shopman` varchar(255) NOT NULL DEFAULT '' COMMENT '淘宝店铺名（授权API返回）',
  `f_shop_title` varchar(100) NOT NULL DEFAULT '我的淘宝店铺' COMMENT '店铺名称',
  `f_shop_link` varchar(255) NOT NULL COMMENT '淘宝店铺链接地址',
  `f_goods_id` varchar(100) NOT NULL COMMENT '宝贝ID',
  `f_goods_link` varchar(255) NOT NULL COMMENT '宝贝地址',
  `f_alitalk_account` varchar(255) NOT NULL DEFAULT '' COMMENT '阿里旺旺账号',
  `f_qq_account` varchar(255) NOT NULL DEFAULT '' COMMENT 'QQ客服账号',
  `f_enabled` tinyint(4) NOT NULL DEFAULT '1' COMMENT '启用/禁用',
  `f_bind` tinyint(4) NOT NULL DEFAULT '0' COMMENT '绑定状态：1-已绑定，0-未绑定',
  `f_app_id` varchar(50) NOT NULL COMMENT 'appId(自动回填不显示)',
  `f_app_key` varchar(50) NOT NULL COMMENT 'appKey(自动回填不显示)',
  `f_create_time` datetime NOT NULL,
  `f_oauth_end_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_goods_id` (`f_goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='站点宝贝表';

-- ----------------------------
-- Records of t_taobao_site
-- ----------------------------
INSERT INTO `t_taobao_site` VALUES ('1', '1168814861673394177', '11111111111', 'PaperYY论文查重', '/static/images/angentPage_logo.gif', '', '/static/images/angentPage_logo.gif', '1', '1', '我的淘宝店', '1', '1111', '11111', '敏敏查重吧', '2841816004', '1', '1', '10012', 'CTynPNysBxNajG2Ji68YGZHCjPYc7Qrn', '2019-09-04 09:36:12', '2019-09-04 09:36:16');
INSERT INTO `t_taobao_site` VALUES ('2', '1167288039630741578', '1168800310344716289', '测试一下', '/static/images/angentPage_logo.gif', '', '/static/images/angentPage_logo.gif', '-1', '', '123456', 'http://', '123456', 'https://item.taobao.com/item.htm?id=123456', '测试一下', '989898', '0', '0', '10012', 'CTynPNysBxNajG2Ji68YGZHCjPYc7Qrn', '2019-09-04 17:33:11', '2019-09-04 17:33:11');
INSERT INTO `t_taobao_site` VALUES ('3', '1167288039630741578', '1169861578377891842', 'test', '/static/images/angentPage_logo.gif', 'http://localhost/taobao/test', '/static/images/angentPage_logo.gif', '-1', '', '111111fd111', 'https://item.taobao.com/item.htm?id=test', 'test', 'https://item.taobao.com/item.htm?id=test', 'teste', '111111111111', '1', '0', '10012', 'CTynPNysBxNajG2Ji68YGZHCjPYc7Qrn', '2019-09-06 14:38:21', '2020-09-05 23:59:59');
INSERT INTO `t_taobao_site` VALUES ('4', '1167288039630741578', '1169861578377891842', 'ddddd', '/static/images/angentPage_logo.gif', 'http://localhost/taobao/dddddddddddddd', '/static/images/angentPage_logo.gif', '-1', '', 'dddddd', 'https://item.taobao.com/item.htm?id=dddddddddddddd', 'dddddddddddddd', 'https://item.taobao.com/item.htm?id=dddddddddddddd', 'ddddd', 'ddddd', '1', '0', '10012', 'CTynPNysBxNajG2Ji68YGZHCjPYc7Qrn', '2019-09-06 14:51:39', '2020-09-05 23:59:59');

-- ----------------------------
-- Table structure for t_taobao_user_thesis
-- ----------------------------
DROP TABLE IF EXISTS `t_taobao_user_thesis`;
CREATE TABLE `t_taobao_user_thesis` (
  `id` varchar(50) NOT NULL COMMENT '主键ID',
  `f_site_id` varchar(50) NOT NULL COMMENT '宝贝ID',
  `f_user_id` varchar(50) NOT NULL COMMENT '代理商ID',
  `f_config_id` varchar(50) NOT NULL COMMENT '配置ID',
  `f_title` varchar(200) NOT NULL COMMENT '标题',
  `f_author` varchar(100) NOT NULL DEFAULT '' COMMENT '作者',
  `f_task_id` varchar(50) NOT NULL COMMENT 'OSS存储ID',
  `f_edition` int(11) NOT NULL COMMENT '版本',
  `f_state` int(11) NOT NULL COMMENT '检测状态：1-待提交，2-检测中，3-已完成',
  `f_word_count` int(11) NOT NULL COMMENT '字数',
  `f_similarity` varchar(10) DEFAULT NULL COMMENT '相似度',
  `f_report_no` varchar(50) DEFAULT NULL COMMENT '报告编号',
  `f_create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `f_post_time` datetime DEFAULT NULL COMMENT '提交时间',
  `f_finish_time` datetime DEFAULT NULL COMMENT '完成时间',
  `f_deleted` tinyint(4) DEFAULT '0' COMMENT '是否标记为删除',
  `f_report_type` int(11) NOT NULL COMMENT '检测类型:1-YY',
  `f_order_first` varchar(50) NOT NULL COMMENT '淘宝订单编号1',
  `f_order_second` varchar(50) NOT NULL DEFAULT '' COMMENT '淘宝订单编号2',
  `f_order_third` varchar(50) NOT NULL DEFAULT '' COMMENT '淘宝订单编号3',
  `f_unit_type` int(11) NOT NULL DEFAULT '1' COMMENT '扣除单价类型',
  `f_unit_words` int(11) NOT NULL DEFAULT '0' COMMENT '扣除单价单位',
  `f_deduction_count` int(11) NOT NULL DEFAULT '0' COMMENT '扣除件数',
  `f_deduction_price` double(4,2) NOT NULL DEFAULT '0.00' COMMENT '扣除金额',
  `f_operate_time` datetime DEFAULT NULL COMMENT '操作时间',
  `f_type` int(11) NOT NULL DEFAULT '1' COMMENT '类型：1-查重，2-降重',
  `f_user_ip` varchar(50) DEFAULT NULL,
  `f_report_source` int(11) NOT NULL DEFAULT '1' COMMENT '报告来源 默认：1-PaperYY,2-笔杆，3-知网,4-维普，5-期刊，6-paperpass',
  PRIMARY KEY (`id`),
  UNIQUE KEY `f_task_id` (`f_task_id`),
  UNIQUE KEY `uk_report_no` (`f_report_no`) USING BTREE,
  KEY `idx_f_user_id` (`f_user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='提交记录表';

-- ----------------------------
-- Records of t_taobao_user_thesis
-- ----------------------------
INSERT INTO `t_taobao_user_thesis` VALUES ('1', '11', '1167288039630741578', '125', '查重1', 'ellen', '1', '1', '2', '5000', null, '1', '2019-09-01 12:00:05', '2019-09-01 12:00:05', '2019-09-01 12:00:05', '0', '1', '2', '', '', '1', '0', '1', '0.00', '2019-09-06 18:23:20', '1', '127.0.0.1', '1');
INSERT INTO `t_taobao_user_thesis` VALUES ('10', '11', '1167288039630741578', '127', '查重', 'ellen', '10', '1', '1', '5000', null, '10', '2019-09-01 12:00:05', '2019-09-01 12:00:05', '2019-09-01 12:00:05', '0', '1', '2', '', '', '1', '0', '10', '0.00', '2019-09-06 18:23:20', '1', '127.0.0.1', '1');
INSERT INTO `t_taobao_user_thesis` VALUES ('11', '11', '1168815148236652547', '127', '查重', 'ellen', '11', '1', '1', '5000', null, '11', '2019-09-02 12:00:05', '2019-09-02 12:00:05', '2019-09-02 12:00:05', '0', '1', '2', '', '', '1', '0', '11', '10.00', '2019-09-06 18:23:20', '1', '127.0.0.1', '1');
INSERT INTO `t_taobao_user_thesis` VALUES ('12', '11', '1168815148236652546', '127', '查重', 'ellen', '12', '1', '1', '5000', null, '12', '2019-09-02 12:00:05', '2019-09-02 12:00:05', '2019-09-02 12:00:05', '0', '1', '2', '', '', '1', '0', '12', '0.00', '2019-09-06 18:23:20', '1', '127.0.0.1', '1');
INSERT INTO `t_taobao_user_thesis` VALUES ('13', '11', '1167288039630741578', '127', '查重', 'ellen', '13', '1', '1', '5000', null, '13', '2019-09-04 12:00:05', '2019-09-04 12:00:05', '2019-09-04 12:00:05', '0', '1', '2', '', '', '1', '0', '13', '0.00', '2019-09-06 18:23:20', '1', '127.0.0.1', '1');
INSERT INTO `t_taobao_user_thesis` VALUES ('14', '11', '1168815148236652547', '127', '查重', 'ellen', '14', '1', '1', '5000', null, '14', '2019-09-03 12:00:05', '2019-09-03 12:00:05', '2019-09-03 12:00:05', '0', '1', '2', '', '', '1', '0', '14', '11.00', '2019-09-06 18:23:20', '1', '127.0.0.1', '1');
INSERT INTO `t_taobao_user_thesis` VALUES ('15', '11', '1167288039630741578', '127', '查重', 'ellen', '15', '1', '1', '5000', null, '15', '2019-09-06 12:00:05', '2019-09-05 12:00:05', '2019-09-05 12:00:05', '0', '1', '2', '', '', '1', '0', '15', '0.00', '2019-09-06 18:23:20', '1', '127.0.0.1', '1');
INSERT INTO `t_taobao_user_thesis` VALUES ('16', '11', '1168815148236652547', '123', '查重', 'ellen', '20', '1', '1', '5000', null, '16', '2019-09-01 12:00:05', '2019-09-01 12:00:05', '2019-09-01 12:00:05', '0', '1', '2', '', '', '1', '0', '16', '0.00', '2019-09-06 18:23:20', '1', '127.0.0.1', '1');
INSERT INTO `t_taobao_user_thesis` VALUES ('17', '11', '1167288039630741578', '127', '查重', 'ellen', '17', '1', '1', '5000', null, '17', '2019-09-04 12:00:05', '2019-09-04 12:00:05', '2019-09-04 12:00:05', '0', '1', '2', '', '', '1', '0', '17', '0.00', '2019-09-06 18:23:20', '1', '127.0.0.1', '1');
INSERT INTO `t_taobao_user_thesis` VALUES ('18', '11', '1167288039630741578', '127', '查重', 'ellen', '18', '1', '1', '5000', null, '18', '2019-09-03 12:00:05', '2019-09-03 12:00:05', '2019-09-03 12:00:05', '0', '1', '2', '', '', '1', '0', '18', '0.00', '2019-09-06 18:23:20', '1', '127.0.0.1', '1');
INSERT INTO `t_taobao_user_thesis` VALUES ('19', '11', '1168815148236652546', '124', '查重', 'ellen', '19', '1', '1', '5000', null, '19', '2019-09-05 12:00:05', '2019-09-05 12:00:05', '2019-09-05 12:00:05', '0', '1', '2', '', '', '1', '0', '19', '0.00', '2019-09-05 17:23:20', '2', '127.0.0.1', '1');
INSERT INTO `t_taobao_user_thesis` VALUES ('2', '11', '1167288039630741578', '123', '查重', 'ellen', '2', '1', '1', '5000', null, '2', '2019-09-01 12:00:05', '2019-09-01 12:00:05', '2019-09-01 12:00:05', '0', '1', '2', '', '', '1', '0', '1', '0.00', '2019-09-06 18:23:20', '1', '127.0.0.1', '1');
INSERT INTO `t_taobao_user_thesis` VALUES ('3', '11', '1167288039630741578', '124', '查重', 'ellen', '3', '1', '1', '5000', null, '3', '2019-09-01 12:00:05', '2019-09-01 12:00:05', '2019-09-01 12:00:05', '0', '1', '2', '', '', '1', '0', '10', '0.00', '2019-09-06 18:23:20', '1', '127.0.0.1', '1');
INSERT INTO `t_taobao_user_thesis` VALUES ('4', '11', '1168815148236652547', '125', '查重', 'ellen', '4', '1', '1', '5000', null, '4', '2019-09-02 12:00:05', '2019-09-02 12:00:05', '2019-09-02 12:00:05', '0', '1', '2', '', '', '1', '0', '11', '10.00', '2019-09-06 18:23:20', '1', '127.0.0.1', '1');
INSERT INTO `t_taobao_user_thesis` VALUES ('5', '11', '1168815148236652546', '126', '查重', 'ellen', '5', '1', '1', '5000', null, '5', '2019-09-02 12:00:05', '2019-09-02 12:00:05', '2019-09-02 12:00:05', '0', '1', '2', '', '', '1', '0', '12', '0.00', '2019-09-06 18:23:20', '1', '127.0.0.1', '1');
INSERT INTO `t_taobao_user_thesis` VALUES ('6', '11', '1167288039630741578', '125', '查重', 'ellen', '6', '1', '1', '5000', null, '6', '2019-09-04 12:00:05', '2019-09-04 12:00:05', '2019-09-04 12:00:05', '0', '1', '2', '', '', '1', '0', '13', '0.00', '2019-09-06 18:23:20', '1', '127.0.0.1', '1');
INSERT INTO `t_taobao_user_thesis` VALUES ('7', '11', '1168815148236652547', '124', '查重', 'ellen', '7', '1', '1', '5000', null, '7', '2019-09-03 12:00:05', '2019-09-03 12:00:05', '2019-09-03 12:00:05', '0', '1', '2', '', '', '1', '0', '14', '11.00', '2019-09-06 18:23:20', '1', '127.0.0.1', '1');
INSERT INTO `t_taobao_user_thesis` VALUES ('8', '11', '1167288039630741578', '124', '查重', 'ellen', '8', '1', '1', '5000', null, '8', '2019-09-05 12:00:05', '2019-09-05 12:00:05', '2019-09-05 12:00:05', '0', '1', '2', '', '', '1', '0', '15', '0.00', '2019-09-06 18:23:20', '1', '127.0.0.1', '1');
INSERT INTO `t_taobao_user_thesis` VALUES ('9', '11', '1168815148236652547', '123', '查重', 'ellen', '9', '1', '1', '5000', null, '9', '2019-09-01 12:00:05', '2019-09-01 12:00:05', '2019-09-01 12:00:05', '0', '1', '2', '', '', '1', '0', '16', '0.00', '2019-09-06 18:23:20', '1', '127.0.0.1', '1');
