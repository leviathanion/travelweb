/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : travel

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2020-09-23 10:02:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin_info`
-- ----------------------------
DROP TABLE IF EXISTS `admin_info`;
CREATE TABLE `admin_info` (
  `admin_id` int(11) NOT NULL,
  `admin_name` varchar(45) DEFAULT NULL,
  `admin_pwd` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of admin_info
-- ----------------------------
INSERT INTO `admin_info` VALUES ('123', 'admin', '123456');

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '商品列表');
INSERT INTO `category` VALUES ('2', '国内游');
INSERT INTO `category` VALUES ('3', '境外游');
INSERT INTO `category` VALUES ('4', '新闻');

-- ----------------------------
-- Table structure for `com_info`
-- ----------------------------
DROP TABLE IF EXISTS `com_info`;
CREATE TABLE `com_info` (
  `com_id` varchar(11) NOT NULL,
  `com_pwd` varchar(45) NOT NULL,
  `com_email` varchar(45) DEFAULT NULL,
  `com_name` varchar(45) DEFAULT NULL,
  `com_privilege` tinyint(4) DEFAULT '2' COMMENT '0为管理员\r\n1为用户\r\n2为商家\r\n3为黑名单',
  `com_address` varchar(45) DEFAULT NULL,
  `com_identify` tinyint(4) DEFAULT '1',
  `com_active` tinyint(4) DEFAULT '1',
  `com_create_date` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`com_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of com_info
-- ----------------------------
INSERT INTO `com_info` VALUES ('11111111111', '123456', 'tgp@qq.com', 'A股份有限公司', '2', '湖北武汉', '0', '1', '2020-09-21 16:14:47');
INSERT INTO `com_info` VALUES ('22222222222', '123456', 'tgp@qq.com', 'B股份有限公司', '2', '山东济南', '0', '1', '2020-09-21 16:16:27');
INSERT INTO `com_info` VALUES ('33333333333', '123456', 'tgp@qq.com', 'C股份有限公司', '2', '江苏南京', '0', '1', '2020-09-21 16:17:03');
INSERT INTO `com_info` VALUES ('44444444444', '123456', 'tgp@qq.com', 'D股份有限公司', '2', '安徽合肥', '0', '1', '2020-09-21 16:17:53');
INSERT INTO `com_info` VALUES ('55555555555', '123456', 'tgp@qq.com', 'E股份有限公司', '2', '湖南长沙', '0', '1', '2020-09-21 16:18:21');
INSERT INTO `com_info` VALUES ('66666666666', '123456', 'tgp@qq.com', 'F股份有限公司', '2', '江西南昌', '0', '1', '2020-09-21 16:19:01');
INSERT INTO `com_info` VALUES ('77777777777', '123456', 'tgp@qq.com', 'G股份有限公司', '2', '广东广州', '0', '1', '2020-09-21 16:20:00');
INSERT INTO `com_info` VALUES ('88888888888', '123456', 'tgp@qq.com', 'H股份有限公司', '2', '海南', '0', '1', '2020-09-21 16:20:24');
INSERT INTO `com_info` VALUES ('99999999999', '123456', 'tgp@qq.com', 'I股份有限公司', '2', '福建福州', '0', '1', '2020-09-21 16:21:05');

-- ----------------------------
-- Table structure for `news_info`
-- ----------------------------
DROP TABLE IF EXISTS `news_info`;
CREATE TABLE `news_info` (
  `news_id` int(11) NOT NULL AUTO_INCREMENT,
  `news_title` varchar(255) DEFAULT NULL,
  `news_content` varchar(1000) DEFAULT NULL,
  `news_img_url` varchar(255) DEFAULT NULL,
  `news_product` int(11) DEFAULT NULL,
  `news_create_date` datetime DEFAULT NULL,
  `news_status` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`news_id`) USING BTREE,
  KEY `news_product` (`news_product`) USING BTREE,
  CONSTRAINT `news_product` FOREIGN KEY (`news_product`) REFERENCES `product_info` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of news_info
-- ----------------------------
INSERT INTO `news_info` VALUES ('2', '￥299起秋冬特卖汇！温泉，赏秋，挑战玻璃桥...好东西当然要及时分享！', '大广州终于降温了，好在天气依旧晴朗\r\n并增添了一份秋日的凉爽！\r\n在这样舒适的季节里，出游是再适宜不过了\r\n周边游秋冬特卖汇来啦~\r\n泡泉望海、登高赏秋、网红栈道、\r\n丰收节、梅汕高铁率先打卡......一系列特色线路\r\n话不多说，我们即刻去片！\r\n\r\n豪叹惠州“小迪拜”超豪华温泉海滨度假酒店，300米私家沙滩，避免游人的纷扰！\r\n珍稀温泉富含十几种矿物质，将秋冬的疲惫轻松赶走！\r\n2珍稀温泉只想安静的泡温泉，享受温泉带来的滋润，纯温泉线路最适合你，还可以品尝超赞的自助餐！地派温泉森林覆盖率达84%，犹如世外桃源，山中葱郁竹林环绕，犹如拱月之势，十分壮观。温泉区建于缓坡之上，以禅乐养生为主题，竹林环绕，且富含珍稀“氡”元素。\r\n', '广州新闻2.jpg', '25', '2020-09-21 23:04:43', '1');
INSERT INTO `news_info` VALUES ('3', ' 2018清远温泉TOP5推荐', '清远温泉众多，是广东地区有名的温泉之乡，加上离珠三角很近，交通便利，一直以来都非常受欢迎。冬天天气寒冷干燥，很多人会感到口干舌燥，而泡温泉可以调养身心，消除一年下来的疲乏，更重要的是，泡温泉是一种集体活动，一家人一起泡温泉再好不过了。今天就给大家介绍下我个人比较推荐的几个清远温泉\r\n第一，清远美林湖温泉度假村\r\n推荐理由：\r\n1、风景优美，欧式风格建筑\r\n2、有全国最大的屋顶摩天轮\r\n第二、聚龙湾温泉\r\n推荐理由：\r\n1、 稀有珍贵的“氡”泉为东南亚发现的极品温泉\r\n2、对皮肤病、高血压等三十多种疾病有明显功效\r\n第三、新银盏温泉\r\n推荐理由：\r\n1、以大型露天温泉为主，各式菜肴特色温泉\r\n2、度假村内山峦起伏，树木葱茏，空气新鲜，出水相拥各种设施非常完善\r\n第四、森波拉温泉\r\n推荐理由：\r\n1、广州近郊最大的“一站式”旅游度假区\r\n2、远古森林奇妙之旅主题度假村\r\n\r\n第五、清远熹乐谷温泉\r\n推荐理由：\r\n1、以唐泰风韵为设计风格，以凤凰为主题的熹乐谷温泉酒店\r\n2、白天鹅酒店集团打造的南中国首个超五星的山顶温泉酒店\r\n', '广州新闻.jpg', '25', '2020-09-21 23:05:36', '1');
INSERT INTO `news_info` VALUES ('4', '仙景+抵价￥1699起,宝藏九寨沟重磅回归!瑶池碧水依旧,彩林翠湖归来', '近日，在大家的翘首以盼下\r\n重建修复两年多的九寨沟\r\n终于和大家见面了！\r\n时间擦去了她的尘埃\r\n秋风送来了彩林最佳观赏期\r\n累累伤痕的她再度“补妆归来”！\r\n准备去九寨沟的游客注意啦\r\n接待对象仅限旅行社组织的团队游客\r\n暂不接待散客，且每日限量5000人\r\n门票有限，赶紧报名出发吧！\r\n', '成都新闻.jpg', '27', '2020-09-22 09:13:15', '1');
INSERT INTO `news_info` VALUES ('5', '秋冬, 泡温泉才是正经事! ￥269起温泉风云榜悄悄上线!', '送走假期，迎来寒露\r\n早晚的风迎面吹来，凉飕飕的，又有点干燥~\r\n这在提醒着我们，是时候泡温泉啦！\r\n在干燥的秋天，温泉是最好的滋补方式\r\n温泉蕴含丰富矿物质\r\n有助于减轻各类疾病，疏通经络，美体塑身\r\n贴心的小编早已准备好\r\n本周：秋冬温泉酒店风云榜来啦！\r\n环球美食、国际品牌、白天鹅出品\r\n泡泉看海、金牌老字号...\r\n类型多种多样，任君选择！！！\r\n', '日本新闻.jpg', '39', '2020-09-22 09:17:40', '1');
INSERT INTO `news_info` VALUES ('6', '直飞北京￥1099起！打卡硬核', '前段时间，刷爆热搜的北京大兴国际机场\r\n相信大家已经不陌生了\r\n在经历了4年建设，7次综合模拟演练、3场验证试飞之后\r\n大兴机场终于迎来它“凤凰展翅”的高光时刻\r\n这也意味着\r\n报名金马北京团的金粉\r\n有机会飞到大兴机场乘机打卡\r\n除了火爆的大兴机场，\r\n正值金秋的北京也是红红火火。\r\n\r\n香山看香山红叶红满天\r\n香山的秋色随着天气变化而色彩纷呈\r\n漫山遍野的黄栌、红枫、银杏成为秋色的主调\r\n尽呈绚烂艳异之美，如梦如幻，宛似画卷。\r\n霜降之后，方圆数万亩坡地上枫树黄栌红艳似火\r\n远远望去，会误以为是飘落的花瓣\r\n走近看才辨清是椭圆的树叶。\r\n', '北京新闻.jpg', '40', '2020-09-22 09:24:10', '1');
INSERT INTO `news_info` VALUES ('7', '抢购!￥3999起直飞欧洲!东欧一价全包!含签证+全含餐!遇见全球醉美小镇', '抢！爆！了！\r\n欧洲全新优品——七大承诺！\r\n一经推出，就深受金粉们喜爱！\r\n手速稍微慢点就没位置了！\r\n这次可不要再错过，马上抢购吧！\r\n提起东欧，那是艺术家们的乐土，\r\n尼采盛赞，米兰•昆德拉厚爱。\r\n东欧确实很美，美得遗世独立！\r\n厚重的历史、恢弘精致的建筑、\r\n浪漫典雅的古城小镇。\r\n东欧是宁静的，古老的电车、圣洁的教堂、\r\n静静流淌的伏尔塔瓦河。\r\n东欧是浪漫的，布拉格查理大桥，\r\n艺术与诗意在这里静静的散发。\r\n东欧是优雅的，美妙的歌声不光在金色大厅，\r\n更在街头巷尾的每一个角落里。\r\n', '乌克兰新闻.jpg', '41', '2020-09-22 09:29:33', '1');
INSERT INTO `news_info` VALUES ('8', '￥1388起江西世遗龙虎山!访道教发源地,丹霞仙境,篁岭晒秋!天天特色餐,全程豪华酒店', '大老板到江西考察时曾说过：\r\n江西是个好地方，生态秀美，名胜甚多\r\n庐山、井冈山、龙虎山、三清山闻名天下\r\n人称“庐山天下悠、三清天下秀、龙虎天下绝”。\r\n快来看看龙虎山“绝”在何处！\r\n龙虎山精华\r\n龙虎山是中国道教发祥地，\r\n有“中国道教第一山”之称，\r\n以丹霞绝美、道宗绝圣、古越绝唱、\r\n阴阳绝妙享誉海内外，\r\n是世界自然遗产地、世界地质公园、国家级风景名胜区、国家5A级旅游景区、国家森林公园。\r\n', '龙虎山新闻.jpg', '42', '2020-09-22 09:33:18', '1');

-- ----------------------------
-- Table structure for `order_info`
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_user` varchar(11) NOT NULL,
  `order_product` int(11) NOT NULL,
  `order_population` int(11) DEFAULT NULL,
  `order_price` double(10,2) DEFAULT NULL,
  `order_ispaid` tinyint(4) DEFAULT '1',
  `order_active` tinyint(4) DEFAULT '1',
  `order_create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE,
  KEY `order_user` (`order_user`) USING BTREE,
  KEY `order_product` (`order_product`) USING BTREE,
  CONSTRAINT `order_product` FOREIGN KEY (`order_product`) REFERENCES `product_info` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `order_user` FOREIGN KEY (`order_user`) REFERENCES `user_info` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES ('1', '11111111111', '19', '3', '1500.00', '1', '1', '2020-01-09 22:02:48');
INSERT INTO `order_info` VALUES ('2', '10101010101', '19', '2', '1000.00', '1', '1', '2020-06-05 10:01:02');
INSERT INTO `order_info` VALUES ('3', '10101010101', '23', '5', '25000.00', '1', '1', '2020-04-24 10:01:19');
INSERT INTO `order_info` VALUES ('4', '10101010101', '30', '3', '2097.00', '1', '1', '2020-08-01 10:01:26');
INSERT INTO `order_info` VALUES ('5', '10101010101', '21', '1', '800.00', '1', '1', '2020-03-01 10:01:38');
INSERT INTO `order_info` VALUES ('6', '10101010101', '22', '1', '600.00', '1', '1', '2020-09-22 10:01:46');
INSERT INTO `order_info` VALUES ('7', '11111111111', '26', '5', '94440.00', '1', '1', '2020-01-25 10:02:03');
INSERT INTO `order_info` VALUES ('8', '11111111111', '36', '3', '59997.00', '1', '1', '2020-03-01 10:02:20');
INSERT INTO `order_info` VALUES ('9', '11111111111', '33', '4', '3996.00', '1', '1', '2020-07-01 10:02:32');
INSERT INTO `order_info` VALUES ('10', '15100000000', '30', '4', '2796.00', '1', '1', '2020-02-01 10:02:57');
INSERT INTO `order_info` VALUES ('11', '15100000000', '24', '3', '9000.00', '1', '1', '2020-08-01 10:03:03');
INSERT INTO `order_info` VALUES ('12', '15100000000', '25', '5', '13330.00', '1', '1', '2020-09-01 10:03:09');
INSERT INTO `order_info` VALUES ('13', '15100000000', '36', '4', '79996.00', '1', '1', '2020-09-22 10:03:21');
INSERT INTO `order_info` VALUES ('14', '15111111111', '36', '3', '59997.00', '1', '1', '2020-02-01 10:03:37');
INSERT INTO `order_info` VALUES ('15', '15111111111', '23', '5', '25000.00', '1', '1', '2020-03-01 10:03:43');
INSERT INTO `order_info` VALUES ('16', '15111111111', '31', '4', '676.00', '1', '1', '2020-04-01 10:04:12');
INSERT INTO `order_info` VALUES ('17', '15111111111', '36', '3', '59997.00', '1', '1', '2020-06-01 10:04:18');
INSERT INTO `order_info` VALUES ('18', '15122222222', '23', '4', '20000.00', '1', '1', '2020-03-01 10:04:37');
INSERT INTO `order_info` VALUES ('19', '15122222222', '30', '5', '3495.00', '1', '1', '2020-06-01 10:04:42');
INSERT INTO `order_info` VALUES ('20', '15122222222', '24', '5', '15000.00', '1', '1', '2020-08-01 10:04:47');
INSERT INTO `order_info` VALUES ('21', '15122222222', '32', '2', '998.00', '1', '1', '2020-08-01 10:04:54');
INSERT INTO `order_info` VALUES ('22', '15122222222', '31', '3', '507.00', '1', '1', '2020-09-22 10:04:59');
INSERT INTO `order_info` VALUES ('23', '15122222222', '33', '1', '999.00', '1', '1', '2020-09-22 10:05:05');
INSERT INTO `order_info` VALUES ('24', '15133333333', '23', '3', '15000.00', '1', '1', '2020-01-01 10:05:23');
INSERT INTO `order_info` VALUES ('25', '15133333333', '19', '3', '1500.00', '1', '1', '2020-04-01 10:05:30');
INSERT INTO `order_info` VALUES ('26', '15133333333', '21', '2', '1600.00', '1', '1', '2020-07-01 10:05:36');
INSERT INTO `order_info` VALUES ('27', '15133333333', '25', '3', '7998.00', '1', '1', '2020-08-01 10:05:42');
INSERT INTO `order_info` VALUES ('28', '15133333333', '24', '3', '9000.00', '1', '1', '2020-09-22 10:05:48');
INSERT INTO `order_info` VALUES ('29', '15144444444', '29', '1', '700.00', '1', '1', '2020-04-01 10:06:01');
INSERT INTO `order_info` VALUES ('30', '15144444444', '33', '4', '3996.00', '1', '1', '2020-05-01 10:06:07');
INSERT INTO `order_info` VALUES ('31', '15144444444', '20', '1', '300.00', '1', '1', '2020-06-01 10:06:11');
INSERT INTO `order_info` VALUES ('32', '15144444444', '23', '1', '5000.00', '1', '1', '2020-07-01 10:06:16');
INSERT INTO `order_info` VALUES ('33', '15155555555', '23', '1', '5000.00', '1', '1', '2020-01-01 10:06:34');
INSERT INTO `order_info` VALUES ('34', '15155555555', '19', '3', '1500.00', '1', '1', '2020-02-01 10:06:39');
INSERT INTO `order_info` VALUES ('35', '15155555555', '33', '4', '3996.00', '1', '1', '2020-03-01 10:06:44');
INSERT INTO `order_info` VALUES ('36', '15155555555', '21', '3', '2400.00', '1', '1', '2020-04-01 10:06:16');
INSERT INTO `order_info` VALUES ('37', '15155555555', '37', '4', '119996.00', '1', '1', '2020-05-01 10:06:57');
INSERT INTO `order_info` VALUES ('38', '15155555555', '38', '1', '21999.00', '1', '1', '2020-06-01 10:07:01');
INSERT INTO `order_info` VALUES ('39', '22222222222', '26', '3', '56664.00', '1', '1', '2020-02-01 10:07:16');
INSERT INTO `order_info` VALUES ('40', '22222222222', '28', '3', '59997.00', '1', '1', '2020-03-01 10:07:21');
INSERT INTO `order_info` VALUES ('41', '22222222222', '35', '1', '3999.00', '1', '1', '2020-04-01 10:07:24');
INSERT INTO `order_info` VALUES ('42', '22222222222', '36', '1', '19999.00', '1', '1', '2020-05-01 10:07:28');
INSERT INTO `order_info` VALUES ('43', '22222222222', '23', '2', '10000.00', '1', '1', '2020-06-01 10:07:37');
INSERT INTO `order_info` VALUES ('44', '22222222222', '29', '1', '700.00', '1', '1', '2020-07-01 10:07:43');
INSERT INTO `order_info` VALUES ('45', '33333333333', '20', '3', '900.00', '1', '1', '2020-03-01 10:07:59');
INSERT INTO `order_info` VALUES ('46', '33333333333', '23', '4', '20000.00', '1', '1', '2020-04-01 10:08:09');
INSERT INTO `order_info` VALUES ('47', '33333333333', '34', '3', '17997.00', '1', '1', '2020-05-01 10:08:13');
INSERT INTO `order_info` VALUES ('48', '33333333333', '36', '3', '59997.00', '1', '1', '2020-06-01 10:08:17');
INSERT INTO `order_info` VALUES ('49', '33333333333', '19', '4', '2000.00', '1', '1', '2020-07-01 10:08:35');
INSERT INTO `order_info` VALUES ('50', '33333333333', '25', '3', '7998.00', '1', '1', '2020-08-01 10:08:41');
INSERT INTO `order_info` VALUES ('51', '44444444444', '19', '3', '1500.00', '1', '1', '2020-04-01 10:09:00');
INSERT INTO `order_info` VALUES ('52', '44444444444', '21', '3', '2400.00', '1', '1', '2020-05-01 10:09:08');
INSERT INTO `order_info` VALUES ('53', '44444444444', '32', '1', '499.00', '1', '1', '2020-06-01 10:09:14');
INSERT INTO `order_info` VALUES ('54', '44444444444', '35', '1', '3999.00', '1', '1', '2020-07-01 10:09:21');
INSERT INTO `order_info` VALUES ('55', '55555555555', '26', '1', '18888.00', '1', '1', '2020-05-01 10:09:37');
INSERT INTO `order_info` VALUES ('56', '55555555555', '21', '3', '2400.00', '1', '1', '2020-06-05 10:09:43');
INSERT INTO `order_info` VALUES ('57', '55555555555', '23', '3', '15000.00', '1', '1', '2020-07-01 10:09:47');
INSERT INTO `order_info` VALUES ('58', '55555555555', '24', '1', '3000.00', '1', '1', '2020-08-01 10:09:52');
INSERT INTO `order_info` VALUES ('59', '55555555555', '33', '3', '2997.00', '1', '1', '2020-09-22 10:09:57');
INSERT INTO `order_info` VALUES ('60', '66666666666', '20', '3', '900.00', '1', '1', '2020-06-01 10:10:09');
INSERT INTO `order_info` VALUES ('61', '66666666666', '19', '2', '1000.00', '1', '1', '2020-07-01 10:10:14');
INSERT INTO `order_info` VALUES ('62', '66666666666', '32', '3', '1497.00', '1', '1', '2020-08-01 10:10:20');
INSERT INTO `order_info` VALUES ('63', '66666666666', '25', '3', '7998.00', '1', '1', '2020-09-22 10:10:25');
INSERT INTO `order_info` VALUES ('64', '66666666666', '38', '2', '43998.00', '1', '1', '2020-09-22 10:10:31');
INSERT INTO `order_info` VALUES ('65', '77777777777', '34', '1', '5999.00', '1', '1', '2020-01-01 10:10:44');
INSERT INTO `order_info` VALUES ('66', '77777777777', '33', '4', '3996.00', '1', '1', '2020-02-01 10:10:48');
INSERT INTO `order_info` VALUES ('67', '77777777777', '24', '3', '9000.00', '1', '1', '2020-03-01 10:10:54');
INSERT INTO `order_info` VALUES ('68', '77777777777', '33', '4', '3996.00', '1', '1', '2020-04-01 10:11:00');
INSERT INTO `order_info` VALUES ('69', '77777777777', '26', '5', '94440.00', '1', '1', '2020-05-01 10:11:04');
INSERT INTO `order_info` VALUES ('70', '88888888888', '26', '5', '94440.00', '1', '1', '2020-01-01 10:11:21');
INSERT INTO `order_info` VALUES ('71', '88888888888', '37', '5', '149995.00', '1', '1', '2020-02-01 10:11:36');
INSERT INTO `order_info` VALUES ('72', '88888888888', '23', '2', '10000.00', '1', '1', '2020-03-01 10:11:41');
INSERT INTO `order_info` VALUES ('73', '88888888888', '24', '2', '6000.00', '1', '1', '2020-04-01 10:11:46');
INSERT INTO `order_info` VALUES ('74', '88888888888', '25', '4', '10664.00', '1', '1', '2020-05-01 10:11:51');
INSERT INTO `order_info` VALUES ('75', '88888888888', '30', '2', '1398.00', '1', '1', '2020-08-01 10:11:57');
INSERT INTO `order_info` VALUES ('76', '99999999999', '19', '1', '500.00', '1', '1', '2020-01-01 10:12:10');
INSERT INTO `order_info` VALUES ('77', '99999999999', '20', '5', '1500.00', '1', '1', '2020-04-01 10:12:16');
INSERT INTO `order_info` VALUES ('78', '99999999999', '21', '5', '4000.00', '1', '1', '2020-06-01 10:12:21');
INSERT INTO `order_info` VALUES ('79', '99999999999', '23', '4', '20000.00', '1', '1', '2020-07-01 10:12:26');
INSERT INTO `order_info` VALUES ('80', '99999999999', '28', '4', '79996.00', '1', '1', '2020-08-01 10:12:31');
INSERT INTO `order_info` VALUES ('81', '99999999999', '36', '1', '19999.00', '1', '1', '2020-09-22 10:12:36');

-- ----------------------------
-- Table structure for `product_img`
-- ----------------------------
DROP TABLE IF EXISTS `product_img`;
CREATE TABLE `product_img` (
  `img_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `big_img` varchar(255) DEFAULT NULL,
  `small_img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`img_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of product_img
-- ----------------------------
INSERT INTO `product_img` VALUES ('23', '18', '/images/1600676815257', '/images/1600676815257');
INSERT INTO `product_img` VALUES ('24', '18', '/images/1600676815257', '/images/1600676815257');
INSERT INTO `product_img` VALUES ('25', '18', '/images/1600676815257', '/images/1600676815257');
INSERT INTO `product_img` VALUES ('26', '18', '/images/1600676815257', '/images/1600676815257');
INSERT INTO `product_img` VALUES ('27', '19', '/images/张家界1.jpg', '/images/张家界1.jpg');
INSERT INTO `product_img` VALUES ('28', '19', '/images/张家界2.jpg', '/images/张家界2.jpg');
INSERT INTO `product_img` VALUES ('29', '19', '/images/张家界3.png', '/images/张家界3.png');
INSERT INTO `product_img` VALUES ('30', '19', '/images/张家界4.png', '/images/张家界4.png');
INSERT INTO `product_img` VALUES ('31', '20', '/images/西安1.png', '/images/西安1.png');
INSERT INTO `product_img` VALUES ('32', '20', '/images/西安2.jpg', '/images/西安2.jpg');
INSERT INTO `product_img` VALUES ('33', '20', '/images/西安3.jpg', '/images/西安3.jpg');
INSERT INTO `product_img` VALUES ('34', '20', '/images/西安4.jpg', '/images/西安4.jpg');
INSERT INTO `product_img` VALUES ('35', '21', '/images/台北1.jpg', '/images/台北1.jpg');
INSERT INTO `product_img` VALUES ('36', '21', '/images/台北2.jpg', '/images/台北2.jpg');
INSERT INTO `product_img` VALUES ('37', '21', '/images/台北3.jpg', '/images/台北3.jpg');
INSERT INTO `product_img` VALUES ('38', '21', '/images/台北4.png', '/images/台北4.png');
INSERT INTO `product_img` VALUES ('39', '22', '/images/苏州1.jpg', '/images/苏州1.jpg');
INSERT INTO `product_img` VALUES ('40', '22', '/images/苏州2.jpg', '/images/苏州2.jpg');
INSERT INTO `product_img` VALUES ('41', '22', '/images/苏州3.jpg', '/images/苏州3.jpg');
INSERT INTO `product_img` VALUES ('42', '22', '/images/苏州4.jpg', '/images/苏州4.jpg');
INSERT INTO `product_img` VALUES ('43', '23', '/images/三亚1.jpg', '/images/三亚1.jpg');
INSERT INTO `product_img` VALUES ('44', '23', '/images/三亚2.jpg', '/images/三亚2.jpg');
INSERT INTO `product_img` VALUES ('45', '23', '/images/三亚3.jpg', '/images/三亚3.jpg');
INSERT INTO `product_img` VALUES ('46', '23', '/images/三亚4.jpg', '/images/三亚4.jpg');
INSERT INTO `product_img` VALUES ('47', '24', '/images/丽江1.jpg', '/images/丽江1.jpg');
INSERT INTO `product_img` VALUES ('48', '24', '/images/丽江2.jpg', '/images/丽江2.jpg');
INSERT INTO `product_img` VALUES ('49', '24', '/images/丽江3.jpg', '/images/丽江3.jpg');
INSERT INTO `product_img` VALUES ('50', '24', '/images/丽江4.jpg', '/images/丽江4.jpg');
INSERT INTO `product_img` VALUES ('51', '25', '/images/广州1.jpg', '/images/广州1.jpg');
INSERT INTO `product_img` VALUES ('52', '25', '/images/广州2.jpg', '/images/广州2.jpg');
INSERT INTO `product_img` VALUES ('53', '25', '/images/广州3.jpg', '/images/广州3.jpg');
INSERT INTO `product_img` VALUES ('54', '25', '/images/广州4.jpg', '/images/广州4.jpg');
INSERT INTO `product_img` VALUES ('55', '26', '/images/法国1.jpg', '/images/法国1.jpg');
INSERT INTO `product_img` VALUES ('56', '26', '/images/法国2.jpg', '/images/法国2.jpg');
INSERT INTO `product_img` VALUES ('57', '26', '/images/法国3.jpg', '/images/法国3.jpg');
INSERT INTO `product_img` VALUES ('58', '26', '/images/法国4.jpg', '/images/法国4.jpg');
INSERT INTO `product_img` VALUES ('59', '27', '/images/成都1.png', '/images/成都1.png');
INSERT INTO `product_img` VALUES ('60', '27', '/images/成都2.png', '/images/成都2.png');
INSERT INTO `product_img` VALUES ('61', '27', '/images/成都3.jpg', '/images/成都3.jpg');
INSERT INTO `product_img` VALUES ('62', '27', '/images/成都4.jpg', '/images/成都4.jpg');
INSERT INTO `product_img` VALUES ('63', '28', '/images/冰岛1.jpg', '/images/冰岛1.jpg');
INSERT INTO `product_img` VALUES ('64', '28', '/images/冰岛2.jpg', '/images/冰岛2.jpg');
INSERT INTO `product_img` VALUES ('65', '28', '/images/冰岛3.jpg', '/images/冰岛3.jpg');
INSERT INTO `product_img` VALUES ('66', '28', '/images/冰岛4.jpg', '/images/冰岛4.jpg');
INSERT INTO `product_img` VALUES ('67', '29', '/images/新疆1.jpg', '/images/新疆1.jpg');
INSERT INTO `product_img` VALUES ('68', '29', '/images/新疆2.jpg', '/images/新疆2.jpg');
INSERT INTO `product_img` VALUES ('69', '29', '/images/新疆3.jpg', '/images/新疆3.jpg');
INSERT INTO `product_img` VALUES ('70', '29', '/images/新疆4.jpg', '/images/新疆4.jpg');
INSERT INTO `product_img` VALUES ('71', '30', '/images/满洲里1.png', '/images/满洲里1.png');
INSERT INTO `product_img` VALUES ('72', '30', '/images/满洲里2.png', '/images/满洲里2.png');
INSERT INTO `product_img` VALUES ('73', '30', '/images/满洲里3.jpg', '/images/满洲里3.jpg');
INSERT INTO `product_img` VALUES ('74', '30', '/images/满洲里4.png', '/images/满洲里4.png');
INSERT INTO `product_img` VALUES ('75', '31', '/images/桂林1.jpg', '/images/桂林1.jpg');
INSERT INTO `product_img` VALUES ('76', '31', '/images/桂林2.jpg', '/images/桂林2.jpg');
INSERT INTO `product_img` VALUES ('77', '31', '/images/桂林3.jpg', '/images/桂林3.jpg');
INSERT INTO `product_img` VALUES ('78', '31', '/images/桂林4.jpg', '/images/桂林4.jpg');
INSERT INTO `product_img` VALUES ('79', '32', '/images/贵州1.jpg', '/images/贵州1.jpg');
INSERT INTO `product_img` VALUES ('80', '32', '/images/贵州2.jpg', '/images/贵州2.jpg');
INSERT INTO `product_img` VALUES ('81', '32', '/images/贵州3.jpg', '/images/贵州3.jpg');
INSERT INTO `product_img` VALUES ('82', '32', '/images/贵州4.jpg', '/images/贵州4.jpg');
INSERT INTO `product_img` VALUES ('83', '33', '/images/敦煌1.jpg', '/images/敦煌1.jpg');
INSERT INTO `product_img` VALUES ('84', '33', '/images/敦煌2.jpg', '/images/敦煌2.jpg');
INSERT INTO `product_img` VALUES ('85', '33', '/images/敦煌3.jpg', '/images/敦煌3.jpg');
INSERT INTO `product_img` VALUES ('86', '33', '/images/敦煌4.jpg', '/images/敦煌4.jpg');
INSERT INTO `product_img` VALUES ('87', '34', '/images/西班牙1.jpg', '/images/西班牙1.jpg');
INSERT INTO `product_img` VALUES ('88', '34', '/images/西班牙2.jpg', '/images/西班牙2.jpg');
INSERT INTO `product_img` VALUES ('89', '34', '/images/西班牙3.jpg', '/images/西班牙3.jpg');
INSERT INTO `product_img` VALUES ('90', '34', '/images/西班牙4.jpg', '/images/西班牙4.jpg');
INSERT INTO `product_img` VALUES ('91', '35', '/images/肯尼亚1.jpg', '/images/肯尼亚1.jpg');
INSERT INTO `product_img` VALUES ('92', '35', '/images/肯尼亚2.jpg', '/images/肯尼亚2.jpg');
INSERT INTO `product_img` VALUES ('93', '35', '/images/肯尼亚3.jpg', '/images/肯尼亚3.jpg');
INSERT INTO `product_img` VALUES ('94', '35', '/images/肯尼亚4.jpg', '/images/肯尼亚4.jpg');
INSERT INTO `product_img` VALUES ('95', '36', '/images/加拿大1.jpg', '/images/加拿大1.jpg');
INSERT INTO `product_img` VALUES ('96', '36', '/images/加拿大2.jpg', '/images/加拿大2.jpg');
INSERT INTO `product_img` VALUES ('97', '36', '/images/加拿大3.jpg', '/images/加拿大3.jpg');
INSERT INTO `product_img` VALUES ('98', '36', '/images/加拿大4.jpg', '/images/加拿大4.jpg');
INSERT INTO `product_img` VALUES ('99', '37', '/images/迪拜1.jpg', '/images/迪拜1.jpg');
INSERT INTO `product_img` VALUES ('100', '37', '/images/迪拜2.jpg', '/images/迪拜2.jpg');
INSERT INTO `product_img` VALUES ('101', '37', '/images/迪拜3.jpg', '/images/迪拜3.jpg');
INSERT INTO `product_img` VALUES ('102', '37', '/images/迪拜4.jpg', '/images/迪拜4.jpg');
INSERT INTO `product_img` VALUES ('103', '38', '/images/大溪地1.jpg', '/images/大溪地1.jpg');
INSERT INTO `product_img` VALUES ('104', '38', '/images/大溪地2.jpg', '/images/大溪地2.jpg');
INSERT INTO `product_img` VALUES ('105', '38', '/images/大溪地3.jpg', '/images/大溪地3.jpg');
INSERT INTO `product_img` VALUES ('106', '38', '/images/大溪地4.jpg', '/images/大溪地4.jpg');
INSERT INTO `product_img` VALUES ('107', '39', '/images/日本1.jpg', '/images/日本1.jpg');
INSERT INTO `product_img` VALUES ('108', '39', '/images/日本2.jpg', '/images/日本2.jpg');
INSERT INTO `product_img` VALUES ('109', '39', '/images/日本3.jpg', '/images/日本3.jpg');
INSERT INTO `product_img` VALUES ('110', '39', '/images/日本4.jpg', '/images/日本4.jpg');
INSERT INTO `product_img` VALUES ('111', '40', '/images/香山1.jpg', '/images/香山1.jpg');
INSERT INTO `product_img` VALUES ('112', '40', '/images/香山2.jpg', '/images/香山2.jpg');
INSERT INTO `product_img` VALUES ('113', '40', '/images/香山3.jpg', '/images/香山3.jpg');
INSERT INTO `product_img` VALUES ('114', '40', '/images/香山4.jpg', '/images/香山4.jpg');
INSERT INTO `product_img` VALUES ('115', '41', '/images/乌克兰1.jpg', '/images/乌克兰1.jpg');
INSERT INTO `product_img` VALUES ('116', '41', '/images/乌克兰2.jpg', '/images/乌克兰2.jpg');
INSERT INTO `product_img` VALUES ('117', '41', '/images/乌克兰3.jpg', '/images/乌克兰3.jpg');
INSERT INTO `product_img` VALUES ('118', '41', '/images/乌克兰4.jpg', '/images/乌克兰4.jpg');
INSERT INTO `product_img` VALUES ('119', '42', '/images/龙虎山1.jpg', '/images/龙虎山1.jpg');
INSERT INTO `product_img` VALUES ('120', '42', '/images/龙虎山2.jpg', '/images/龙虎山2.jpg');
INSERT INTO `product_img` VALUES ('121', '42', '/images/龙虎山3.jpg', '/images/龙虎山3.jpg');
INSERT INTO `product_img` VALUES ('122', '42', '/images/龙虎山4.jpg', '/images/龙虎山4.jpg');

-- ----------------------------
-- Table structure for `product_info`
-- ----------------------------
DROP TABLE IF EXISTS `product_info`;
CREATE TABLE `product_info` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_com` varchar(11) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `product_route` varchar(1000) DEFAULT NULL,
  `product_price` double(10,2) DEFAULT NULL,
  `product_active` tinyint(4) DEFAULT '0',
  `product_starttime` datetime DEFAULT NULL,
  `product_endtime` datetime DEFAULT NULL,
  `product_img_url` varchar(255) DEFAULT NULL,
  `product_introduce` varchar(1000) DEFAULT NULL,
  `product_create_time` datetime DEFAULT NULL,
  `product_click_count` int(11) DEFAULT '0',
  `category_id` int(11) NOT NULL DEFAULT '1',
  `isThemeTour` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`product_id`) USING BTREE,
  KEY `product_com` (`product_com`) USING BTREE,
  CONSTRAINT `product_com` FOREIGN KEY (`product_com`) REFERENCES `com_info` (`com_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of product_info
-- ----------------------------
INSERT INTO `product_info` VALUES ('19', '11111111111', '张家界五日游', '张家界+武陵源区+天门山+湘西+凤凰5日4晚跟团游(5钻)', '500.00', '1', '2020-09-01 00:00:00', '2020-09-06 00:00:00', '/images/张家界1.jpg', '温馨的家-抵达张家界市区--入住5钻酒店\r\n全天\r\n航班：从各地前往张家界，我们安排工作人员从张家界荷花机场接您至酒店。（工作人员会在出行前一 天21点前，短信或电话通知接您的事宜，请您保持订单中提供的电话通畅。）\r\n携程旅游管家24小时服务，出发前一天管家给您发短信，然后添加WX，行程中遇到任何问题，管家都会耐心为您解答，为您解决您行中问题！\r\n\r\n酒店房型：标准双人间！若您需要安排《大床房》请在下单时候备注需要大床房，供应商将酌情为您贴心安排（无需增加费用）因数量有限，以供应商安排为准哈！\r\n13:00 午餐\r\n成人：不含餐    儿童：不含餐\r\n今天无统一行程，敬请自理；\r\n行驶: 约1公里/约5分钟\r\n用餐时间：约1小时 \r\n全天\r\n酒店：张家界京武铂尔曼酒店 或 张家界青和锦江国际酒店\r\n免费升级5星豪华房型。\r\n\r\n国庆期间无法指定铂尔曼，以安排披露酒店为准，敬请谅解\r\n行驶: 约7公里/约10分钟\r\n18:00 晚餐\r\n成人：不含餐    儿童：不含餐\r\n今天无统一行程，敬请自理；\r\n推荐小吃：我们安排的酒店地理位置很好，周边很多小吃街，您可自行前往品尝！\r\n温馨提示：自由活动期间游客注意自身安全及财产安全。\r\n行驶: 约2公里/约10分钟\r\n用餐时间：约1小时\r\n\r\n', '2020-09-21 17:08:22', '354', '1', null);
INSERT INTO `product_info` VALUES ('20', '22222222222', '西安四日游', '西安兵马俑+法门寺4日3晚跟团游(5钻)', '300.00', '1', '2020-09-02 00:00:00', '2020-09-06 00:00:00', '/images/西安1.png', '出发地（全国）-西安（24小时专车接机，直达酒店，自由活动）\r\n全天\r\n交通：请客人自行前往机场，办理登机托运手续赴古城西安，到达后，接团送酒店，当日自由活动。\r\n【温馨提示】\r\n1、航班时间由您自行选配，前台默认航班按照价格低展示，机票信息处可点击“选择其他航班”，选择您中意的航班时间，需补一定的差价，敬请知悉。\r\n2、微管家服务：我们为您贴心提供24H接机服务，随叫随到，接机车队和导游会在您出发前一天联系您，请注意查看短信或接听电话。\r\n3、抵达西安后请务必保证手机开机，司机会在您抵达前联系，告知您具体接机时间与地点。\r\n行驶: 约20公里/约1小时\r\n午餐\r\n成人：不含餐    儿童：不含餐\r\n方便游玩，敬请自理\r\n', '2020-09-21 17:11:25', '3453', '1', null);
INSERT INTO `product_info` VALUES ('21', '33333333333', '台北五日游', '象山步道+四四南村+彩虹河滨公园+圆山饭店周边', '800.00', '1', '2020-09-07 00:00:00', '2020-09-12 00:00:00', '/images/台北1.jpg', '产品包含：5天往返含税机票+4晚市区酒店\r\n★【温馨提示】台湾自由行预订，需通行证、G签、入台证缺一不可。如您选择临近日期出发，请确保证件齐全。具体要求请查看签证/签注页面须知。\r\n★\r\n可在下一步资源中选择：wifi、交通卡、门票、一日游、包车游等应有尽有，一站式服务保障您的自由行！\r\n给大家推荐几处101大楼拍照取景地：\r\n象山步道\r\n四兽山（虎、豹、狮、象）步道中的高地，270度视野极贴近101，摄影平台、六巨石、永春岗平台、市疗平台、石乳园、象山打印台、超然亭等，均有完善的步道设施，能将101烟火和周遭景观尽收眼底。\r\n交通：捷运象山站下车，往信义路五段中强公园方向步行，约15分钟抵150巷22弄登山口；或由捷运永春站下车，往永春高中方向步行，约25分钟抵永春岗公园\r\n四四南村\r\n在四四南村看101大楼，可体会新旧并陈的强烈对比，是摄影师取景的好去处。\r\n交通：捷运台北101／世贸站2号出口出来左转，步行约3分钟\r\n彩虹河滨公园\r\n彩虹河滨公园位于台北101北北东方，正是位置。\r\n交通：搭乘捷运至松山站，转搭204路公车至新湖民善街口下\r\n圆山饭店周边\r\n圆山饭店因地势较高，居高临下，可欣赏台北夜景，例如圆山风景区观景平台，经好美步道步行即可到达。\r\n交通：捷运于圆山站、大直站及剑潭站出口，都有免费接驳车至圆山饭店\r\n', '2020-09-21 17:19:37', '3453', '1', null);
INSERT INTO `product_info` VALUES ('22', '44444444444', '古镇三日游', '苏州+乌镇+杭州3日2晚跟团游(5钻)', '600.00', '1', '2020-09-17 00:00:00', '2020-09-20 00:00:00', '/images/苏州1.jpg', '上海—苏州—乌镇 【宿：乌镇】 （含中餐）\r\n09:00\r\n交通：虹桥站集合，乘车前往苏州\r\n【集合时间】：09：00，具体已导游通知为准！\r\n【集合地点】：“虹桥高铁站”p9停车库，1F地面一层（交通：地铁2、10、17号直达，上海虹桥站）。\r\n\r\n10:30\r\n前往：拙政园4.6/5分\r\n拙政园是“中国四大名园”之一，并被列入世界文化遗产名录。拙政园以水景见胜，凸现江南水乡风貌，典雅大方。花园总体分为东、中、西三部分，各具特色，尤其是中部花园，基本保持明代园林朴素自然的风格，为全园的精华。\r\n12:00 午餐\r\n成人：含餐    儿童：含餐\r\n品尝苏式特色餐\r\n随桌赠送：时令水果盘、2支瓶酒、1支大瓶可乐或雪碧\r\n参考菜单：酱油虾、苏式松鼠鱼、回锅肉夹饼、笋干红烧肉、尖椒小炒肉、银鱼蒸蛋、苏式烤鸭、干锅有机花菜、时令蔬菜二道、三鲜砂锅\r\n13:00\r\n交通：集合前往“江南古镇中的佼佼者”乌镇西栅\r\n15:30\r\n前往：乌镇4.6/5分\r\n乌镇地处位于桐乡市北郊，是一座有着一千三百多年建镇史的古镇。这里有着典型的小桥、流水，还有大片雅致的江南民居建筑，更有着丰富的美食特产和悠闲的生活节奏，是感受江南水乡风情的好去处。\r\n\r\n前往：西栅4.6/5分\r\n西栅毗邻古老的京杭大运河畔，由十二个碧水环绕的岛屿组成。景区内保留了大面积的明清建筑，西栅老街横贯东西，内有纵横交叉的河道无数及形态各异的古石桥72座，真正呈现了原汁原味的江南水乡古镇的历史风貌。\r\n17:30 晚餐\r\n成人：不含餐    儿童：不含餐\r\n自由品乌镇特色小吃\r\n小吃推荐：姑嫂饼、三珍斋酱品、红烧羊肉、熏豆茶、三白酒、白水鱼、定胜糕、红烧羊肉、酱鸡鸭等...\r\n\r\n18:00\r\n前往：西栅夜游4.7/5分\r\n夜游西栅和白天是完全不同的感受。特别是坐着乌蓬船（西栅船游是不包含在门票内的，需要自行购票）泛舟河上，河面上是被灯光映照出彩色倒影的一座座古桥，顺着河道看两岸的古建筑在色彩斑斓的灯光中呈现出新的意境，新旧交替恍然如入两座古镇，一个是昨日的班驳，一个是今日的绚烂。\r\n\r\n20:00\r\n酒店：乌镇子夜大酒店 或 乌镇梵璞主题文化酒店 或 桐乡振石大酒店', '2020-09-21 18:14:55', '8766', '1', null);
INSERT INTO `product_info` VALUES ('23', '55555555555', '三亚五日游', '《潜水&水上飞龙》+定制《单人海鲜火锅》+海棠湾免税店 限时享『1对1专车接送机☆双VIP免排队通道☆24H高颜值管家』 任选酒店【180海景|度假天堂亚龙湾|亚特兰蒂斯】', '5000.00', '1', '2020-09-10 00:00:00', '2020-09-15 00:00:00', '/images/三亚1.jpg', 'D1\r\n美丽的三亚\r\n全天\r\n\"自行前往出发地机场，办理登机手续。出发地没有导游哦~抵达三亚，接机人员安排车辆送您到酒店,沿途欣赏南国风光,回酒店休息\"。\r\n\r\n温馨提醒：\r\n【1】今天全天不含餐，餐食需自理。\r\n【2】首日到三亚请勿食用过多热带水果及大量海鲜，以防肠胃不适，影响第二天行程。\r\n【3】每个人的航班到达时间有所差异，到达酒店后请自行到前台办理入住手续，如有疑问可咨询酒店前台。\r\n【4】航班：搭乘班机到三亚（具体航班信息请在预订下一步中查看）； 出发地没有导游哦~工作人员会在出行前一 天21点前，短信或电话通知您接机事宜，请您保持订单中提供的电话通畅\r\n【5】海南娱乐活动丰富，潜水、美味的海鲜餐；各种晚间活动更是多彩：有骏达车技表演、夜游三亚湾、三亚千古情表演等；除了我们行程中包含景点外，您在自由活动休息的时候也可以自行参加您感兴趣的另付费娱乐项目；\r\n\r\n亲爱的客人，以下两处我们坦诚告诉您：\r\n①海南的旅游车队属于政府调度中心统一负责，不归旅行社管理，如果遇到司机细节服务不够完.美地方，敬请您谅解\r\n②我们承诺绝不减少餐标，但海南饮食口味清淡，且三亚物价水平较高，餐未必能达到亲的要求，我们有几处留白的餐饮，大家可以根据个人口味 自行安排 ~\r\n\r\n预订须知：机场均会采取体温检测、登机前查验健康码和核查个人活动轨迹的方式进行管理。\r\n12:00 午餐\r\n成人：不含餐    儿童：不含餐\r\n自行品尝海南当地特色美食\r\n【舌尖上的海南——美食推荐】\r\n海南特色美食：海南粉、抱罗粉、陵水酸粉、临高烤乳猪、海南鸡饭、斋菜煲、椰子饭、椰子鸡汤、竹筒饭；\r\n18:00 晚餐\r\n成人：不含餐    儿童：不含餐\r\n自行品尝海南当地特色美食\r\n【舌尖上的海南——美食推荐】\r\n海南四大名菜：文昌鸡、东山羊、和乐蟹、加积鸭；\r\n海南甜点小吃：清补凉、芒果肠粉、水果绵绵冰、甜薯奶、鸡屎藤粑仔；\r\n', '2020-09-21 18:17:47', '46123', '1', null);
INSERT INTO `product_info` VALUES ('24', '66666666666', '昆明+大理+丽江+玉龙雪山6日5晚', '昆明+大理+丽江+玉龙雪山', '3000.00', '1', '2020-09-03 00:00:00', '2021-09-18 00:00:00', '/images/丽江1.jpg', '•	★ 【五星精选】携程贵宾独立发团，AB线下单立减588/单•冲销2万人，百事特专属送机，云南本土旅行社专业服务，不转团卖团。\r\n•	★ 【度假首选】热销明星爆单款，云南人气榜第一，累计服务人数近2万人，6千多真实点评，7*24小时旅行管家服务\r\n•	★ 【缤纷景点】3大表演+4大5A景点|网红玩法+4晚5钻酒店+全程特色美食\r\nD1\r\n各地游客_昆明\r\n全天\r\n航班：各地旅客乘飞机抵达昆明长水国际机场，我司接站之后乘车前往酒店安排入住。选择乘坐祥鹏、春秋、西部航空\\首都航空中国联航天津航空等经济舱航班旅客，部分舱位无免费托运行李额，行李额规定详见各航司官网，逾重行李请旅客自行通过航空公司官方网站、机场值机柜台购买逾重行李，请在下单前务必查看清楚具体航班的行李额信息，关于其它航空的行李额规定请致电航司客服进行咨询，谢谢您的配合。\r\n飞行: 约1046公里/约2小时20分钟\r\n全天\r\n自由活动：各地旅客乘飞机抵达昆明长水国际机场，接机安排酒店入住。随后自由活动。\r\n在时间允许的情况下推荐大家自行前往游览位于昆明市中心的昆明地标“金马碧鸡坊”，还可以到“祥云”美食城品尝云南特色小吃：感受一下特色臭豆腐、来一碗香喷喷的小锅米线、时鲜的各类果汁，让人眼花缭乱的云南小吃，上百品种供您选择，同时感受“春城”气息！\r\n全天\r\n【24小时接机】：您下单后我们客服会将接机组联系方式发送至您手机，您下飞机后，请先打开手机保持通信畅通，把行李取到后从国内到达A号安检口或者C号安检口出来到外面的大厅，我们接机工作人员会及时联系您，接到您后，送至酒店办理入住。\r\n全天\r\n酒店：昆明花之城豪生国际大酒店 或 昆明中凰酒店 或 昆明晟世仟和酒店 或 昆明鑫盛达宏晟国际酒店\r\n行驶: 约25公里/约40分钟\r\n\r\n', '2020-09-21 18:19:26', '6834', '1', null);
INSERT INTO `product_info` VALUES ('25', '77777777777', '广州长隆+珠海长隆5日4晚半自助游', '广州长隆+珠海长隆', '2666.00', '1', '2020-09-03 00:00:00', '2020-09-20 00:00:00', '/images/广州1.jpg', '【国庆班期赠长隆公仔】【全程住熊猫+企鹅酒店】〖含3大乐园门票+赠帝企鹅自助餐〗【官方代理 • 实力控房】玩转动物世界+海洋王国+国际马戏 • 住客享景区专属通道入园 • 看美食攻略吃遍长隆• 探秘野生世界• 品实景马戏• 游神秘海洋 限时赠横琴马戏 10.8日前赠水上乐园【双飞/双高】\r\n•	★ 【尊享入住】【全程住长隆景区酒店•优享体验】含海洋王国+动物园+大马戏门票！优享住客特权！\r\n•	★ 【特色美食】【赠帝企鹅餐厅用餐】赠1餐帝企鹅餐厅自助午餐或晚餐，非比寻常用餐体验！\r\n•	★ 【度假首选】【自由行套餐】没有跟团的拘束，你的行程你做主～情侣or亲子游优选！\r\n•	【全程住熊猫+企鹅酒店】\r\n•	套餐内容：\r\n•	住：2晚熊猫酒店帅帅房+2晚企鹅酒店极地房（两成人入住一间，儿童默认不占床，默认安排双床，具体以酒店房态为准，如您有特殊要求请下单备注，尽量安排）\r\n•	玩：动物园+大马戏+海洋王国2日票（成人和儿童均含）\r\n•	吃：帝企鹅餐厅1个自助午餐或晚餐（成人和儿童均含） \r\n\r\n•	车：景区免费提供接驳车往返广州长隆和珠海长隆之间（需提前在前台预约），景区免费提供接驳车往返广州长隆园区和景区酒店之间（无需预约）（现广州长隆往返珠海长隆的接驳车暂未开放，您可自行选择乘车方式过去）\r\n•	赠：10.8日之前入住熊猫酒店期间 赠送水上乐园门票，1间房至多赠送3张，仅限入住期间使用！\r\n•	\r\n\r\n•	备注：由于疫情防控游客进入园区前，须在入口处接受体温测量筛检、有效身份证明文件核对、“健康码”核验，敬请提前准备好有效身份证明文件和“健康码”\r\nPS：儿童不满一米海洋王国+餐食皆可免票，不用报名！\r\n\r\n酒店住客享8大权益：酒店专属免费停车场、海洋王国提前30分钟入园、免押入住 快速退房、享横琴水世界优惠购票、儿童物品免费借用、免费园区穿梭巴 无缝对接、提前告知享生日礼遇、特快腕带5折优惠\r\n\r\n备注：珠海长隆海洋王国暂不开放项目为：空中飞人 具体以园区公告为准\r\n•	\r\n\r\n•	特别提示：节假日期间长隆马戏票会出现随时售罄的情况；如遇订单中马戏临时售罄，无法观看，我社可做订单内差价退款，敬请谅解，请知悉\r\n\r\n', '2020-09-21 18:20:51', '3458', '1', null);
INSERT INTO `product_info` VALUES ('26', '88888888888', '法国+德国+意大利+瑞士12日跟团游', '庄园酒店 少女峰+卢浮宫+凡尔赛宫+新天鹅堡+塞纳河游船+贡多拉+巴黎蒙帕纳思56层观光廊+吕德斯海姆+科隆', '18888.00', '1', '2020-09-04 00:00:00', '2020-09-20 00:00:00', '/images/法国1.jpg', '•	★ 【度假首选】【携程匠心】全程4钻+升1晚托斯卡纳庄园酒店+无购物无自费含签证费 赠WIFI\r\n•	★ 【缤纷景点】登顶瑞士少女峰+卢浮宫(官导)+凡尔赛宫(导览)+新天鹅堡(官导)+双游船\r\n•	★ 【特色美食】吕德斯海姆+科隆+登顶巴黎蒙帕纳斯+6菜1汤+威尼斯墨鱼面+蜜月生日礼遇\r\n•	【出行无忧】 无自费 无购物 含司导服务费小费 含各地酒店税 经典四国，匠心打造欧罗巴值得游览的线路\r\n\r\n•	【拒签全退】 有过欧美出境记录，且无申根拒签记录，按照外网披露要求提供齐全真实有效的材料，如果被拒签，可以享受团费全退的待遇（签证费用不退）\r\n•	【行程秒懂】 法兰克福进-罗马出，不走回头路\r\n•	【精选住宿】 全程4钻酒店（保证booking评分7.5分及以上）含欧式自助早餐，特别升级[1晚托斯卡纳庄园酒店]\r\n•	【经典全含】 齿轮火车登顶少女峰+卢浮宫（含专业官导讲解）+凡尔赛宫（含官方导览器）+新天鹅堡（含官方导览）+登顶蒙帕纳思大厦俯瞰巴黎全景\r\n•	【浪漫游船】 巴黎塞纳河游船+威尼斯贡多拉游船\r\n•	【地道美食】 威尼斯特色墨鱼面+GELATO双球冰淇凌+中式团餐6菜1汤\r\n•	【自由购物】 THE MALL+DFS+巴黎老佛爷+春天百货，度假同时尽享购物乐趣\r\n•	\r\n•	【匠心礼遇】\r\n【1】移动WIFI\r\n•	● 4人一台设备；每台设备每日前500M为4G高速，500M之后降速根据网络信号降为2G或3G），随时分享旅途的美好心情\r\n•	【2】无线导览耳机\r\n● 1人1台，全程无线导览耳机、倾听更专业的导游讲解，防止走丢可能性。\r\n•	【3】国际转换插头\r\n•	● 2人1台，贴心赠送旅游必备神器，解决“断电”小尴尬\r\n•	【4】蜜月/生日赠送专享浪漫礼遇\r\n•	● 蜜月或生日期间（红酒1瓶）\r\n•	（为方便准备，需在报名时提供1年内结婚证/出生日期在出团时间内的身份证，详情请咨询客服） \r\n', '2020-09-21 18:22:09', '4584', '2', null);
INSERT INTO `product_info` VALUES ('27', '99999999999', '成都+黄龙风景名胜区5日4晚跟团游', '九寨沟风景区+熊猫乐园', '2550.00', '1', '2020-09-05 00:00:00', '2020-09-27 00:00:00', '/images/成都1.png', '九寨沟风景区+熊猫乐园【CD线1+1排座专享座驾15人小团】【ABE线3排座头等舱大巴22人小团】真纯玩•无购物•全程5钻酒店•沟口2晚酒店连住不挪窝•戏熊猫•红叶+专车接送站•严选导游『往返交通任选』限时大促•立减100/成人\r\n•	★ 【优质交通】2款车型选择：3排座头等舱大巴22人小团•or壹号座驾15人小团，独立式沙发座椅，USB充电\r\n•	★ 【精选酒店】优选全程5钻住宿，九寨沟沟口连住2晚，不换酒店• 真纯玩•无购物•无车上推销。\r\n•	★ 【缤纷景点】金秋赏红叶•游童话世界，逗萌宠，限制进沟人数，适合家庭出游，成都休闲逛街\r\n•	注意事项（请游客朋友一定仔细阅读）：\r\n•	行程套餐区别: \r\n•	1、1排3座头等舱大巴或者1排2座一号座驾车型. \r\n•	 2、团友人数多少，22人团或者15人团  \r\n•	此套餐：九寨沟+黄龙+熊猫乐园【1排3座头等舱22人团】+【5.钻酒店4晚】\r\n•	---------------------------------------------------------------------------------------------------\r\n•	本产品为真纯玩产品，无任何隐形店，请区别低价购物团，请放心预定。\r\n•	温馨提示:\r\n•	1.接机工作人员会提前1天约定接机事宜，预订成功后请耐心等待，如需提前联系，可联系订单内的紧急联系人。\r\n•	2.导游会在成都出团前一天晚上19:00-21:30点主动电话联系，到时候请保持手机畅通。\r\n•	3、温馨提示：新冠疫情防控期间，根据景区规定：景区只接收中国身份证游客，目前境外人员，身份证号属于中高风险地区或经过中高风险地区游客\r\n•	（如不清楚所在地风险等级的，可下载或微信小程序搜索（国务院客户端）查询，如您有计划出游，请下单前咨询客服！敬请理解~\r\n•	4、如您是医护人员，请在下单时备注（备注：所属机构名称，执业证书编号），九寨沟景区对医护人员以及一名陪伴家人免门票费用（五一和十一(10月1-8号)除外），\r\n•	如未提前告知，则不能享受免门票优惠。\r\n\r\n', '2020-09-21 18:23:52', '9535', '1', null);
INSERT INTO `product_info` VALUES ('28', '99999999999', '极地探索•冰岛9天•4人小团', '蓝湖酒店+旷野山原美居，私享温泉遇见绚烂极光，冰洞探险+冰川徒步+火山岩洞探险+黑沙滩+冰河湖+黄金大圆环', '19999.00', '1', '2020-09-03 00:00:00', '2020-09-26 00:00:00', '/images/冰岛1.jpg', '•	★ 【度假首选】入住蓝湖酒店，冰河湖游船+冰川徒步+出海观鲸，费用已包含，无需付费升级；\r\n•	★ 【缤纷景点】与海盗骑马共进午餐，上帝视角飞越冰岛，近30个极地体验和景点全包含；\r\n•	★ 【服务保障】4-6人小团、专属车导、入住指定酒店、司机导游小费已包含，真正一价全包。\r\n•	根据入住酒店不同，行程分A线和B线：\r\n•	     A线-高端奢选（周一/周三/周五/周日）92%客户的选择\r\n•	     B线-品质臻选（周二/周四/周六）8%客户的选择\r\n•	     A线、B线每天均可发团，详询旅行顾问。\r\n•	\r\n•	     一手资源：所有酒店、用车均由小满旅行冰岛分公司在当地直接采购，一手价格，无中间环节，服务响应更迅速。\r\n•	\r\n•	【温馨提示】办理冰岛签证需20-25个工作日，建议您尽早报名，以预留充足的签证时间。\r\n\r\n', '2020-09-21 18:25:51', '321', '2', null);
INSERT INTO `product_info` VALUES ('29', '11111111111', '新疆7日北疆大环线定制', '喀纳斯+伊犁+独库公路+赛里木湖+禾木景区+薰衣草', '700.00', '1', '2020-05-01 00:00:00', '2020-05-08 00:00:00', '/images/新疆1.jpg', '【五彩滩】宽阔的河滩上，高耸的山峰，幽深的峡谷，错综的街道，纵横的沟壑，在夕阳下显得斑斓而又神奇，一切都沐浴在柔和的光线中，像神灵们的天国，迷离而虚幻！ \r\n【河堤夜市】\r\n布尔津可逛布尔津夜市，夜市以卖烤冷水鱼为主，生意红火，南来北往的游客都来这儿霄夜，大胡子烤鱼鲜嫩味美，一条鱼大约花50元，体会一下布尔津烧烤，值得！\r\n【喀纳斯景区】，游览三湾一湖，卧龙湾，月亮湾，神仙湾，喀纳斯湖。\r\n【世界魔鬼城】魔鬼城区间车为小火车，单向行驶，停靠5个停靠点，第二个停靠点可骑骆驼拍照，第三个停靠点是电影天地英雄的拍摄地，第三个停靠点是电影七剑下天山的拍摄地。骑着骆驼来一场西域大片吧。 ', '2020-09-21 22:16:37', '534', '1', null);
INSERT INTO `product_info` VALUES ('30', '22222222222', '金秋草原·呼伦贝尔金秋草原7日定制游', 'SUV深度穿越金秋草原+无人机航拍+不限时骑马+网红打卡线+舌尖上的草原+星空蒙古包篝火狂欢夜+甄选特色住宿+退改无忧', '699.00', '1', '2020-07-01 00:00:00', '2020-07-08 00:00:00', '/images/满洲里1.png', '海拉尔--天下草原景区--草原迎宾--彩虹滑梯--滑翔机--草原制高点--草原BBQ--唯美白桦林--恩和民族乡\r\n\r\n恩和俄罗斯民族乡—七卡—五卡—太极八卦图—丰泽农场—列夫湿地庄园\r\n列夫湿地庄园—不限时骑马—186彩带河—千米滑草—网红秋千—巴尔虎蒙古部落—篝火狂欢夜\r\n做一天蒙古人—呼伦湖—满洲里', '2020-09-21 22:26:31', '8454', '1', null);
INSERT INTO `product_info` VALUES ('31', '33333333333', '桂林龙脊醉美龙脊梯田2日游新体验', '探索绝地逃亡拍摄地+平安民族服装拍照+赠当地长寿果含平安梯田星级名宿酒店一晚+景区门票+金坑大寨单程索道+往返专车接送', '169.00', '1', '2020-08-19 00:00:00', '2020-08-22 00:00:00', '/images/桂林1.jpg', '金坑大寨梯田（含用车，景区门票，单程索道） \r\n平安壮寨梯田（含用车，景区门票）【赠送民族服装拍照 限每人一套】 ', '2020-09-21 22:28:32', '3456', '1', null);
INSERT INTO `product_info` VALUES ('32', '44444444444', '贵州民族山水5日游', '黄果树大瀑布起穿越水帘洞+西江千户苗寨品长桌宴+肇兴侗寨抓稻田鱼+荔波小七孔漂流+梵净山佛国圣地', '499.00', '1', '2020-03-01 00:00:00', '2020-03-06 00:00:00', '/images/贵州1.jpg', '【黄果树瀑布】，车程2半个小时，10:30游览【陡坡塘】，陡坡塘瀑布位于贵州省黄果树瀑布上游1公里处，瀑顶宽105米，高21米，是黄果树瀑布群中瀑顶最宽的瀑布。\r\n【镇远古镇】，大概4个半小时的路程，晚上入住镇远古镇， 晚上可以夜游《舞阳河》自由活动。\r\n镇远古镇——梵净山——西江千户苗寨 \r\n西江千户苗寨——贵阳——家 ', '2020-09-21 22:30:23', '4512', '1', null);
INSERT INTO `product_info` VALUES ('33', '55555555555', '青甘大环线8天7晚跟团游', '全程无自费+豪华品质酒店+七彩丹霞+嘉峪关城楼+鸣沙山月牙泉+莫高窟+茶卡盐湖+塔尔寺+青海湖', '999.00', '1', '2020-06-18 00:00:00', '2020-06-26 00:00:00', '/images/敦煌1.jpg', '乘动车前往张掖【丹霞口度假小镇】\r\n观影结束后前往【七彩丹霞】（游览约2小时）张掖丹霞地貌奇观形成于600万年前，位于张掖市临泽、肃南县境内，面积约510多平方公里。\r\n，乘车前往【嘉峪关城楼】嘉峪关是明代万里长城的西端起点，是明代长城沿线建造规模最为壮观', '2020-09-21 22:31:41', '5467', '1', null);
INSERT INTO `product_info` VALUES ('34', '66666666666', '西班牙+葡萄牙秘境定制14日', '畅游梦幻海岸线拉古什+打卡魔幻之都巴塞罗那+漫步天空之城龙达+品味独特蓝白小镇米哈斯', '5999.00', '1', '2020-01-01 00:00:00', '2020-01-15 00:00:00', '/images/西班牙1.jpg', 'DAY 1-2   巴塞罗那 \r\nDAY 3-4   安道尔 \r\nDAY 5     巴塞罗那 \r\nDAY 6     圣塞瓦斯蒂安\r\nDAY 7     毕尔巴鄂\r\nDAY 8     萨拉曼卡\r\nDAY 9-11  马德里\r\n马德里：  马德里王宫门票（快速通关门票）\r\n巴塞罗那：巴塞罗那圣家堂（门票+语音导览+塔楼登顶）\r\n	  巴特罗之家（语音导览+私人大厅+贵宾通道+复古照片+门票）', '2020-09-21 22:32:54', '4561', '2', null);
INSERT INTO `product_info` VALUES ('35', '77777777777', '肯尼亚7日动物大迁徙之旅', '桑布鲁+阿布戴尔+奈瓦沙+马赛马拉', '3999.00', '1', '2020-08-15 00:00:00', '2020-08-23 00:00:00', '/images/肯尼亚1.jpg', '内罗毕-桑布鲁（含用车+门票） \r\n桑布鲁-阿布戴尔（含用车+门票） \r\n阿布戴尔-奈瓦沙（含用车+门票） \r\n奈瓦沙-马赛马拉国家保护区（含用车+门票） \r\n马赛马拉保护区（含用车+门票） \r\n马赛马拉-内罗毕机场-离开（含用车） \r\n', '2020-09-21 22:34:01', '5434', '2', null);
INSERT INTO `product_info` VALUES ('36', '88888888888', '加拿大落基山脉+尼亚加拉大瀑布深度体验14日', '班夫国家公园+贾斯伯+幽鹤+哥伦比亚冰原+星空保护区+个性玩法+费尔蒙温泉网红酒店', '19999.00', '1', '2020-07-13 00:00:00', '2020-07-28 00:00:00', '/images/加拿大1.jpg', '伊丽莎白女王公园（Queen Elizabeth Park）：到达温哥华，稍作休整，然后前往温哥华的最高点——伊丽莎白女王公园，站在公园的最高处眺望远处的城区，一览城市街区的繁华和熙熙攘攘，再配上背后连绵起伏的雪山，有看遍红尘的遗世独立之感，感觉自己仙仙哒。 \r\n温哥华-海天公路-惠斯勒 ：早餐后，出发前往惠斯勒，开始激动人心的自驾之旅。驱车在风光旖旎的海天公路，一边是连绵不断高山，另一侧是浪花滚滚，海天相接，充满诗情画意，还有海湾，山川，瀑布，森林相伴，目不暇接，美不胜收，最美世界十大公路之一名副其实！\r\n\r\n惠斯勒-joffre lakes-甘露市 ：早餐后，我们从惠勒斯沿着海天公路所在的99号公路开往甘露市。\r\n韦尔斯格雷省立公园（Wells Gray Provincial Park）：途径韦尔斯格雷省立公园，这所公园以史前森林般的景色文明内外，在公园内全年你都有机会看到驯鹿，还有应季出来活动的各种动物，黑尾鹿，黑熊，郊狼，鲑鱼等，让你大饱眼福。这所公园藏着40多处瀑布群，让它更加富有，最著名的就是加拿大第四高瀑布——罕肯瀑布（Heimcken Falls），堪称公园的标志景点。落差为142米的瀑布直泻而下，在底部冲刷出了一个巨大峡谷，远远望去颇为壮观。走至近前，轰隆隆的水声震耳欲聋，森林的虫鸣鸟叫骤然消失，全被它的嘶吼所掩盖。', '2020-09-21 22:35:11', '3215', '2', null);
INSERT INTO `product_info` VALUES ('37', '99999999999', '迪拜阿布扎比6日奢华定制游', '棕榈岛高空跳伞+360度缆车观光+越野车沙漠冲沙+IMG冒险乐园', '29999.00', '1', '2020-09-17 00:00:00', '2020-09-25 00:00:00', '/images/迪拜1.jpg', '海上快艇自驾+越野车沙漠冲沙 \r\n阿布扎比城市观光一日游 \r\n迪拜一日游（跳伞+老城区半日游） \r\n摩登迪拜一日游 \r\n', '2020-09-21 22:36:14', '4587', '2', null);
INSERT INTO `product_info` VALUES ('38', '99999999999', '大溪地10日轻奢定制游', '免费行程路书+茉莉雅希尔顿3晚+波拉波拉瑞吉4晚+大溪地1晚+水上别墅+预定赠大溪地黑珍珠一颗', '21999.00', '1', '2020-09-08 00:00:00', '2020-09-19 00:00:00', '/images/大溪地1.jpg', '高端邮轮 高端享受\r\n “保罗高更号”邮轮是一艘全年巡游在波利尼西亚海域的超五星级邮轮。它的舱房全部为海景舱，70%拥有私人阳台，B级以上套房还为您配备私人管家。船上共有217个船员，平均每2名船员服务3名客人，是邮轮界中船员与乘客的最高比例之一，可以为您提供贴身的个性化服务。\r\n一价全包 米其林级美食畅享\r\n从第一天的晚餐岛最后一天的早餐，您可以任意品尝这次邮轮专供的精致美餐，其中包括法国米其林二星大厨VIGATO创意签单的美食餐厅。同时整个巡航中您可以畅饮大溪地HINANO啤酒及餐厅酒吧中精选的葡萄酒等。更有每天供应的下午茶供您挑选！\r\n多岛畅玩 省时省力省心\r\n被誉为“绝世海岛”的海岛大溪地，一次邮轮行程探访多个最经典岛屿，在有限的时间里让您尽赏最经典的美景，不受人声鼎沸、拥挤嘈杂的搅扰，是真正意义上的休闲度假之旅。\r\n告别单调 海面上的游乐中心\r\n邮轮旅行优雅、闲适又自由，是欧美人最向往的度假方式之一。在邮轮上您可以参加各种文化活动，波利尼西亚文艺表演、魔术表演、摄影讲座等活动将让您的船上时光丰富多彩。您还可以在泳池中畅游或玩一些简单的水上设施。图书馆、健身房、博物馆等也是您歇息享乐的好去处。', '2020-09-21 22:37:00', '6546', '2', null);
INSERT INTO `product_info` VALUES ('39', '99999999999', '日本东京大阪京都奈良7天6晚亲子家庭定制游', '畅玩东京迪士尼乐园+大阪环球影城+花见小路和服美拍+京都古寺神社祈福+宇治抹茶手工体验+奈良萌鹿亲密互动+心斋桥/道顿崛美食扫货', '8880.00', '1', '2020-05-01 00:00:00', '2020-05-08 00:00:00', '/images/日本1.jpg', '【真实日本】日本当地深度旅游，行程/时间/人数/随意调整，打造私人旅行；\r\n【一价全含】往返机票/精选酒店/门票/交通/WIFI,旅行所需要的，定制全搞定；\r\n【高端旅游】专业司机兼导游，中文服务，当地活地图，高品质有保障；\r\n【安全省心】私人顾问24小时在线，全程跟进贴心服务，为您的旅行保驾护航。', '2020-09-22 09:16:52', '6457', '2', null);
INSERT INTO `product_info` VALUES ('40', '11111111111', '北京5日4晚跟团游', '7正餐全含+19项门票全含+无购物无自费+观升旗仪式+9-10月班期香山赏枫+赠后海八爷胡同游+奥运杂技演出+24H无忧接送 性价比高 物超所值', '2708.00', '1', '2020-07-01 00:00:00', '2020-07-06 00:00:00', '/images/香山1.jpg', '\r\n★ 【精品小团 安心】16人小团，高空座率大巴安全保障，导游更加贴心照顾到每一位家人！\r\n★ 【一价全含 省心】全程0购物0自费，还赠胡同游+杂技演出，让家人更省心的圆梦首都！\r\n★ 【不赶不累 舒心】行程中7正餐全含，每天精选2-3大景点搭配表演等，让家人玩的更舒心', '2020-09-22 09:23:24', '5464', '1', null);
INSERT INTO `product_info` VALUES ('41', '22222222222', '深度人文·乌克兰9天', '达人互动，持枪游击队餐+巧克力大师亲授制作+探访油画市场+火车之旅头等舱+基辅双世界文化遗产】网红爱情隧道+“小布拉格”沃利夫+“黑海明珠”敖德萨+乘坐浪漫热气球', '19999.00', '1', '2020-10-01 00:00:00', '2020-10-11 00:00:00', '/images/乌克兰1.jpg', '★ 【2人私家团】与达人互动，游击队餐厅，乌克兰巧克力制作，深度感受乌克兰\r\n★ 【深度人文】基辅双世界文化遗产+“小布拉格”沃利夫+“黑海明珠”敖德萨\r\n★ ​【咨询立减500元】华人礼遇宫廷酒店，提供私人定制服务，第三方权威认证', '2020-09-22 09:28:39', '6413', '2', null);
INSERT INTO `product_info` VALUES ('42', '33333333333', '三清山+龙虎山+婺源5日4晚跟团游', '高铁或动车往返【赏花季】江西精华景点【享下单立减小红包】观鲜花小镇-赏晒秋美景【贴心含婺源篁岭+三清山往返索道+龙虎山竹筏】观道教名山-住舒适酒店-含接送站-纯玩无购物', '2139.00', '1', '2020-11-01 00:00:00', '2020-11-06 00:00:00', '/images/龙虎山1.jpg', '★ 精选景点-三清山、龙虎山、婺源篁岭，下单享立减小红包\r\n★ 含三清山索道+婺源篁岭索道+龙虎山竹筏，含接送站\r\n★ 丰富经验导游陪同，路线合理，酒店舒适', '2020-09-22 09:32:20', '3458', '1', null);

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id` varchar(11) NOT NULL,
  `user_name` varchar(45) DEFAULT NULL,
  `user_pwd` varchar(255) NOT NULL,
  `user_sex` tinyint(4) DEFAULT NULL,
  `user_age` int(11) DEFAULT NULL,
  `user_address` varchar(255) DEFAULT NULL,
  `user_email` varchar(45) DEFAULT NULL,
  `user_privilege` tinyint(4) DEFAULT '1' COMMENT '0为管理员',
  `user_job` varchar(45) DEFAULT NULL,
  `user_img_url` varchar(255) DEFAULT NULL,
  `user_remark` varchar(255) DEFAULT NULL,
  `user_create_date` datetime DEFAULT NULL,
  `user_active` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('10101010101', '张三', '123456', '1', '22', '湖北武汉', 'tfg@qq.com', '1', '老师', null, '我是一名老师', '2020-09-21 15:36:34', '1');
INSERT INTO `user_info` VALUES ('11111111111', '李四', '123456', '0', '23', '山东济南', 'tfg@qq.com', '1', '程序员', null, '我是一名程序员', '2020-09-21 15:39:00', '1');
INSERT INTO `user_info` VALUES ('15100000000', '塞恩', '123456', '1', '30', '新疆乌鲁木齐', 'tfg@qq.com', '1', '司机', null, '我是一名司机', '2020-09-21 16:07:32', '1');
INSERT INTO `user_info` VALUES ('15111111111', '蔚', '123456', '0', '20', '西藏拉萨', 'tfg@qq.com', '1', '警察', null, '我是一名警察', '2020-09-21 16:08:36', '1');
INSERT INTO `user_info` VALUES ('15122222222', '加里奥', '123456', '1', '300', '云南昆明', 'tfg@qq.com', '1', '保安', null, '我是一名保安', '2020-09-21 16:09:40', '1');
INSERT INTO `user_info` VALUES ('15133333333', '赵信', '123456', '1', '45', '四川成都', 'tfg@qq.com', '1', '教练', null, '我是一名教练', '2020-09-21 16:10:57', '1');
INSERT INTO `user_info` VALUES ('15144444444', '普朗克', '123456', '1', '30', '广西南陵', 'tfg@qq.com', '1', '船长', null, '我是一名船长', '2020-09-21 16:11:48', '1');
INSERT INTO `user_info` VALUES ('15155555555', '韩金龙', '123456', '1', '40', '安徽芜湖', 'tfg@qq.com', '1', '厨师', null, '我是一名初始', '2020-09-21 16:13:02', '1');
INSERT INTO `user_info` VALUES ('22222222222', '王五', '123456', '1', '33', '河南郑州', 'tfg@qq.com', '1', '工人', null, '我是一名工人', '2020-09-21 15:46:54', '1');
INSERT INTO `user_info` VALUES ('33333333333', '赵六', '123456', '0', '33', '北京', 'tfg@qq.com', '1', '医生', null, '我是一名医生', '2020-09-21 15:50:26', '1');
INSERT INTO `user_info` VALUES ('44444444444', '马七', '123456', '0', '44', '黑龙江哈尔滨', 'tfg@qq.com', '1', '推销员', null, '我是一名推销员', '2020-09-21 15:54:47', '1');
INSERT INTO `user_info` VALUES ('55555555555', '王二麻子', '123456', '0', '22', '吉林长春', 'tfg@qq.com', '1', '老师', null, '我是一名老师', '2020-09-21 15:58:45', '1');
INSERT INTO `user_info` VALUES ('66666666666', '亚索', '123456', '1', '30', '河北石家庄', 'tfg@qq.com', '1', '医生', null, '我是一名医生', '2020-09-21 16:00:21', '1');
INSERT INTO `user_info` VALUES ('77777777777', '永恩', '123456', '1', '33', '甘肃兰州', 'tfg@qq.com', '1', '司机', null, '我是一名司机', '2020-09-21 16:03:11', '1');
INSERT INTO `user_info` VALUES ('88888888888', '凯特琳', '123456', '0', '20', '内蒙古呼和浩特', 'tfg@qq.com', '1', '警察', null, '我是一名警察', '2020-09-21 16:04:44', '1');
INSERT INTO `user_info` VALUES ('99999999999', '蒙多', '123456', '1', '50', '青海西林', 'tfg@qq.com', '1', '医生', null, '我是一名医生', '2020-09-21 16:06:00', '1');
