use test;
set names utf8;

CREATE TABLE `house`
(
    `id`                  bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'house唯一标识',
    `title`               varchar(255)        NOT NULL,
    `price`               int(11) unsigned    NOT NULL COMMENT '价格',
    `area`                int(11) unsigned    NOT NULL COMMENT '面积',
    `room`                int(11) unsigned    NOT NULL COMMENT '卧室数量',
    `floor`               int(11) unsigned    NOT NULL COMMENT '楼层',
    `total_floor`         int(11) unsigned    NOT NULL COMMENT '总楼层',
    `watch_times`         int(11) unsigned             DEFAULT '0' COMMENT '被看次数',
    `build_year`          int(4)              NOT NULL COMMENT '建立年限',
    `status`              int(4) unsigned     NOT NULL DEFAULT '0' COMMENT '房屋状态 0-未审核 1-审核通过 2-已出租 3-逻辑删除',
    `create_time`         datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `last_update_time`    datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最近数据更新时间',
    `city_en_name`        varchar(32)         NOT NULL COMMENT '城市标记缩写 如 北京bj',
    `region_en_name`      varchar(255)        NOT NULL COMMENT '地区英文简写 如昌平区 cpq',
    `cover`               varchar(32)                  DEFAULT NULL COMMENT '封面',
    `direction`           int(11)             NOT NULL COMMENT '房屋朝向',
    `distance_to_subway`  int(11)             NOT NULL DEFAULT '-1' COMMENT '距地铁距离 默认-1 附近无地铁',
    `parlour`             int(11)             NOT NULL DEFAULT '0' COMMENT '客厅数量',
    `district`            varchar(32)         NOT NULL COMMENT '所在小区',
    `admin_id`            int(11)             NOT NULL COMMENT '所属管理员id',
    `bathroom`            int(11)             NOT NULL DEFAULT '0',
    `street`              varchar(32)         NOT NULL COMMENT '街道',
    `baidu_map_latitude`  double              NOT NULL COMMENT '百度地图经度',
    `baidu_map_longitude` double              NOT NULL COMMENT '百度地图纬度',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

INSERT INTO `house`
VALUES ('15', '富力城 国贸CBD 时尚休闲 商务办公', '6200', '70', '2', '10', '20', '2', '2005', '1',
        '2017-09-06 18:56:14', '2017-12-03 11:13:46', 'bj', 'cyq', 'Fhxz_c16YmEmIz5UVxrp6ihwbvCk', '2', '10', '1',
        '融泽嘉园', '2', '0', '龙域西二路', '40.07304035934152', '116.33065000000001');
INSERT INTO `house`
VALUES ('16', '富二城 国贸 时尚休闲 商务办公', '6300', '70', '2', '10', '20', '0', '2012', '1',
        '2017-09-06 19:53:35', '2017-12-03 11:13:42', 'bj', 'cyq', 'FvkO1FFyGbrxCP_1O9tA94u2qvbP', '1', '-1', '1',
        '融泽嘉园', '2', '0', '龙域西二路', '40.07304035934152', '116.33065000000001');
INSERT INTO `house`
VALUES ('17', '二环东直门地铁站附近、王府井、天安门、国贸、三里屯、南锣鼓巷', '3000', '35', '1', '5', '10', '2', '2013', '1',
        '2017-09-06 20:45:35', '2017-12-03 11:13:36', 'bj', 'cyq', 'FpVYJRsLykrBRyUSCEOeqsqWU-bt', '1', '200', '0',
        '融泽嘉园', '2', '0', '富龙域西二路', '40.07304035934152', '116.33065000000001');
INSERT INTO `house`
VALUES ('18', '华贸城 东向一居挑空loft 干净温馨 随时可以签约', '5700', '52', '1', '7', '20', '0', '2012', '1',
        '2017-09-06 21:01:02', '2017-12-03 11:13:30', 'bj', 'cpq', 'Fl1lNikhmMIecbTn-JTsurxugtFU', '2', '1085', '1',
        '融泽嘉园', '2', '0', '富龙域西二路', '40.05387850450573', '116.44008358533833');
INSERT INTO `house`
VALUES ('19', '望春园板楼三居室 自住精装 南北通透 采光好视野棒！', '9200', '132', '3', '6', '14', '0', '2005', '1',
        '2017-09-06 22:44:25', '2017-12-03 11:13:25', 'bj', 'cyq', 'Fp1xPKVYtPsCeVHVQVW0Hif2FXk7', '2', '1108', '2',
        '华贸城', '2', '0', '龙域西二路', '40.07304035934152', '116.33065000000001');
INSERT INTO `house`
VALUES ('20', '高大上的整租两居室 业主诚意出租', '5400', '56', '2', '12', '20', '0', '2012', '1', '2017-09-06 23:39:50',
        '2017-12-03 11:13:20', 'bj', 'cyq', 'FvVqU8LneZZ5xaLBAOM1KXR2Pz1X', '2', '-1', '1', '融泽嘉园', '2', '0',
        '龙域西二路', '40.07304035934152', '116.33065000000001');
INSERT INTO `house`
VALUES ('21', '新康园 正规三居室 精装修 家电家具齐全', '1900', '18', '1', '13', '25', '0', '2012', '1',
        '2017-09-07 00:52:47', '2017-12-03 11:13:15', 'bj', 'cyq', 'FnuOFbFtDYTbpPdFoZthR-R0tszC', '3', '1302', '0',
        '融泽嘉园', '2', '0', '龙域西二路', '40.07304035934152', '116.33065000000001');
INSERT INTO `house`
VALUES ('24', '湖光壹号望京华府183-387㎡阔景大宅', '50000', '288', '5', '1', '1', '0', '2015', '1',
        '2017-09-07 11:42:20', '2017-12-03 11:13:10', 'bj', 'cyq', 'FvVqU8LneZZ5xaLBAOM1KXR2Pz1X', '5', '200', '3',
        '融泽嘉园', '2', '0', '龙域西二路', '40.07304035934152', '116.33065000000001');

CREATE TABLE `house_detail`
(
    `id`                  bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `description`         varchar(1000) DEFAULT NULL COMMENT '详细描述',
    `layout_desc`         varchar(255)  DEFAULT NULL COMMENT '户型介绍',
    `traffic`             varchar(1000) DEFAULT NULL COMMENT '交通出行',
    `round_service`       varchar(1000) DEFAULT NULL COMMENT '周边配套',
    `rent_way`            int(2)              NOT NULL COMMENT '租赁方式',
    `address`             varchar(32)         NOT NULL COMMENT '详细地址 ',
    `subway_line_id`      int(11)       DEFAULT NULL COMMENT '附近地铁线id',
    `subway_line_name`    varchar(32)   DEFAULT NULL COMMENT '附近地铁线名称',
    `subway_station_id`   int(11)       DEFAULT NULL COMMENT '地铁站id',
    `subway_station_name` varchar(32)   DEFAULT NULL COMMENT '地铁站名',
    `house_id`            bigint(20)          NOT NULL COMMENT '对应house的id',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

INSERT INTO `house_detail`
VALUES ('21',
        '国贸CBD商务区,近SOHO现代城,富顿中心,富力城商业街区,乐成中心,潘家园古玩城,八王坟长途客运站,北京游乐园,经由三环路可直达首都机场。附近有双井桥南,双井桥北,双井桥东双井桥西等30多条公交站牌!\n《天安门,故宫,王府井,三里屯,前门,天坛,北海,颐和园,雍和宫,奥林匹克公园,水立方,西单,欢乐谷,燕莎商城等》知名购物区及旅游名胜古迹,是您休闲旅游及商务下榻的理想选择',
        '房间采光良好,落地窗外景色宜人',
        '房子处于北京的CBD商务中心区国贸双井!紧邻双井地铁站,步行5分钟即到!这离国贸、中央电视台、潘家园、三里屯、团结湖、日坛使馆区、儿研所、大郊亭都很近',
        '房子闹中取静,地理位置优越,交通方便,紧邻呼家楼地铁站和东大桥地铁站;去机场可乘坐东直门机场快轨,非常方便｡购物中心有双井购物中心、国贸购物中心和侨福芳草地购物中心、三里屯购物中心等,远道而来的朋友可尽览都市璀璨!',
        '0', '二号院7号楼', '4', '10号线', '58', '双井', '15'),
       ('22',
        '国贸CBD商务区,近SOHO现代城,富顿中心,富力城商业街区,乐成中心,潘家园古玩城,八王坟长途客运站,北京游乐园,经由三环路可直达首都机场。附近有双井桥南,双井桥北,双井桥东双井桥西等30多条公交站牌!\n《天安门,故宫,王府井,三里屯,前门,天坛,北海,颐和园,雍和宫,奥林匹克公园,水立方,西单,欢乐谷,燕莎商城等》知名购物区及旅游名胜古迹,是您休闲旅游及商务下榻的理想选择!',
        '房间采光良好,落地窗外景色宜人', '房子处于北京的CBD商务中心区国贸双井!紧邻双井地铁站,步行5分钟即到',
        '这离国贸、中央电视台、潘家园、三里屯、团结湖、日坛使馆区、儿研所、大郊亭都很近。房子闹中取静,地理位置优越,交通方便,紧邻呼家楼地铁站和东大桥地铁站;去机场可乘坐东直门机场快轨,非常方便｡购物中心有双井购物中心、国贸购物中心和侨福芳草地购物中心、三里屯购物中心等,远道而来的朋友可尽览都市璀璨！',
        '0', '1号院1号楼', '1', '13号线', '5', '上地', '16'),
       ('24',
        '我和我女盆友当房东已经一年了,也是超赞房东,希望能为大家提供舒适的住所~ 房间的大门和房门都是密码门,小区有保安24小时值班,非常安全方便。 通常入住时间是下午三点,提前来的同学可以先寄存行李和洗澡哦~\n\n',
        '房間非常漂亮,空間很大,鵝黃色的牆壁看起來非常舒服', '位置距離地鐵站不遠',
        '距故宫、天安门、王府井、三里屯、簋街、南锣鼓巷等景点均可地铁半小时内到达,交通便利~', '0', '1号院2号楼', '1',
        '13号线', '16', '东直门', '17'),
       ('25', '这个经纪人很懒，没写核心卖点',
        '此房是一居室的格局，上下两层，面宽，房间亮堂，进门右手厨房，正前方是25平米的客厅，楼上是卧室，带洗手间！ 喧闹和安静隔开，适合居住',
        '小区距离地铁13号线北苑站500米的距离，交通出行便利....',
        '小区楼下就是华贸天地娱乐街，保利电影院，眉州东坡，中信银行，麦当劳等娱乐休闲设施齐全', '0', '1号院3号楼', '1',
        '13号线', '11', '北苑', '18'),
       ('26', '这个经纪人很懒，没写核心卖点',
        '此房为望春园小区板楼南北通透户型，主卧客厅朝南，次卧朝北，两个客厅双卫，居住很舒适。',
        '距离地铁5号线立水桥南站630米，有464,465,966,081，621等多条公交线路，交通出行四通八达。',
        '小区旁有大型购物商场易事达，物美超市，丰宁蔬菜基地，航空总医院、安贞医院北苑分院，中国银行、中国农业银行、中国工商银行、中国交通银行、中国建设银行、招商银行分布。小区旁有天奥健身房，还有立水桥公园..',
        '0', '6号院1号楼', '1', '13号线', '10', '立水桥', '19'),
       ('27',
        '高大上的整租两居室 业主诚意出租\n1、客厅挑高、宽敞舒适、阳光充足 2、卧室搭配的很新颖，使用之高 3、厨房带阳台，让您和家人有足够的空间展现私家厨艺',
        '客厅挑高、宽敞舒适、阳光充足 2、卧室搭配的很新颖，使用之高 3、厨房带阳台，让您和家人有足够的空间展现私家厨艺',
        '近地铁13号线东直门站',
        '社区环境好，环境优美，适宜居住，人文素质高，物业管理完善； 2、属于低密度社区 ，适宜居住 3、小区的林密树多，让您感受花园一样的家',
        '0', '1号院5号楼', '1', '13号线', '16', '东直门', '20'),
       ('28', '房子是正规三室一厅一厨一卫，装修保持的不错，家电家具都齐全。\n',
        '房子客厅朝北面积比较大，主卧西南朝向，次卧朝北，另一个次卧朝西，两个次卧面积差不多大。',
        '小区出南门到8号线育新地铁站614米，交通便利，小区500米范围内有物美，三旗百汇，龙旗广场等几个比较大的商场，生活购物便利，出小区北门朝东952米是地铁霍营站，是8号线和 13号线的换乘站，同时还有个S2线，通往怀来。（数据来源百度地图）',
        '小区西边300米就是物美超市和三旗百汇市场（日常百货、粮油米面、瓜果蔬菜、生鲜海货等等，日常生活很便利，消费成本低），北边200米是龙旗购物广场和永辉超市（保利影院，KFC，麦当劳等，轻松满足娱乐消费）。小区里还有商店，饭店，家政等。',
        '0', '2号院1号楼', '1', '13号线', '9', '霍营', '21'),
       ('31', '懒死了 不谢', '户型介绍', '交通出行', '周边配套', '0', '3号院1号楼', '1', '13号线', '12', '望京西',
        '24'),
       ('32', '房屋描述-编辑', '户型介绍', '交通出行', '周边配套-编辑', '0', '3号院2单元1003', '1', '13号线', '8',
        '回龙观', '25');

CREATE TABLE `house_picture`
(
    `id`         bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `house_id`   int(11)             NOT NULL COMMENT '所属房屋id',
    `cdn_prefix` varchar(255)        NOT NULL COMMENT '图片路径',
    `width`      int(11)     DEFAULT NULL COMMENT '宽',
    `height`     int(11)     DEFAULT NULL COMMENT '高',
    `location`   varchar(32) DEFAULT NULL COMMENT '所属房屋位置',
    `path`       varchar(255)        NOT NULL COMMENT '文件名',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

INSERT INTO `house_picture`
VALUES ('68', '19', 'http://7xo6gy.com1.z0.glb.clouddn.com/', '911', '683', null, 'Fp1xPKVYtPsCeVHVQVW0Hif2FXk7'),
       ('69', '19', 'http://7xo6gy.com1.z0.glb.clouddn.com/', '1012', '683', null, 'Fn371N5gLsJvjuIRC4IHjPtMy61h'),
       ('70', '24', 'http://7xo6gy.com1.z0.glb.clouddn.com/', '1280', '960', null, 'Fn1AGNmZfadCIVTJA33gByg6a33B'),
       ('71', '24', 'http://7xo6gy.com1.z0.glb.clouddn.com/', '1024', '683', null, 'FlgoAylUv1ilx1SAtxSyBCJF3bwb'),
       ('72', '21', 'http://7xo6gy.com1.z0.glb.clouddn.com/', '1024', '683', null, 'FnuOFbFtDYTbpPdFoZthR-R0tszC'),
       ('73', '21', 'http://7xo6gy.com1.z0.glb.clouddn.com/', '455', '683', null, 'FhCiRnyCDQ-O6pXusu5ftmZkIh0-'),
       ('74', '20', 'http://7xo6gy.com1.z0.glb.clouddn.com/', '1024', '683', null, 'FvVqU8LneZZ5xaLBAOM1KXR2Pz1X'),
       ('75', '20', 'http://7xo6gy.com1.z0.glb.clouddn.com/', '1024', '683', null, 'FtNl9uPM6p5PjEs8z2FnOuViNtOM'),
       ('76', '18', 'http://7xo6gy.com1.z0.glb.clouddn.com/', '1440', '960', null, 'FgcD3BufAprERe5y3Gd-Mezu5VAy'),
       ('77', '18', 'http://7xo6gy.com1.z0.glb.clouddn.com/', '1024', '683', null, 'Fl1lNikhmMIecbTn-JTsurxugtFU'),
       ('78', '17', 'http://7xo6gy.com1.z0.glb.clouddn.com/', '1024', '683', null, 'FvVHtS1qAApFFh6k5LMDm5tliufK'),
       ('79', '17', 'http://7xo6gy.com1.z0.glb.clouddn.com/', '1024', '683', null, 'FpVYJRsLykrBRyUSCEOeqsqWU-bt'),
       ('80', '16', 'http://7xo6gy.com1.z0.glb.clouddn.com/', '1024', '683', null, 'Fhysh6EcQ_ZTl-jdGe2zaCFi5Uvm'),
       ('81', '16', 'http://7xo6gy.com1.z0.glb.clouddn.com/', '1024', '683', null, 'Fvb9TDMRtl1haBj9gK9C0k43X0u0'),
       ('82', '16', 'http://7xo6gy.com1.z0.glb.clouddn.com/', '1024', '683', null, 'FvkO1FFyGbrxCP_1O9tA94u2qvbP'),
       ('83', '15', 'http://7xo6gy.com1.z0.glb.clouddn.com/', '1024', '683', null, 'FsxiS6rOTpSg5pK7tv41e8Zpnn_c'),
       ('84', '15', 'http://7xo6gy.com1.z0.glb.clouddn.com/', '1024', '683', null, 'FpOKJ2IEmbA1y1RbIqgZfqFKkJyS'),
       ('85', '15', 'http://7xo6gy.com1.z0.glb.clouddn.com/', '1440', '960', null, 'Fhxz_c16YmEmIz5UVxrp6ihwbvCk');

CREATE TABLE `house_subscribe`
(
    `id`               bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `house_id`         bigint(20)          NOT NULL COMMENT '房源id',
    `user_id`          bigint(20)          NOT NULL COMMENT '用户id',
    `desc`             varchar(255)                 DEFAULT NULL COMMENT '用户描述',
    `status`           int(2)              NOT NULL DEFAULT '0' COMMENT '预约状态 1-加入待看清单 2-已预约看房时间 3-看房完成',
    `create_time`      datetime            NOT NULL COMMENT '数据创建时间',
    `last_update_time` datetime            NOT NULL COMMENT '记录更新时间',
    `order_time`       datetime                     DEFAULT NULL COMMENT '预约时间',
    `telephone`        varchar(11)                  DEFAULT NULL COMMENT '联系电话',
    `admin_id`         bigint(20)          NOT NULL COMMENT '房源发布者id',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

INSERT INTO `house_subscribe`
VALUES ('9', '17', '1', null, '3', '2017-11-26 11:06:23', '2017-12-02 09:21:01', '2017-12-03 00:00:00', '13888888888',
        '2');

CREATE TABLE `house_tag`
(
    `house_id` bigint(20)          NOT NULL COMMENT '房屋id',
    `id`       bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '标签id',
    `name`     varchar(32)         NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;


INSERT INTO `house_tag`
VALUES ('15', '18', '独立阳台'),
       ('15', '17', '空调'),
       ('16', '16', '光照充足'),
       ('17', '15', '随时看房'),
       ('17', '14', '集体供暖'),
       ('18', '13', '精装修'),
       ('19', '12', '独立卫生间'),
       ('19', '11', '独立阳台'),
       ('21', '19', '光照充足'),
       ('21', '20', '独立卫生间'),
       ('24', '10', '光照充足'),
       ('24', '3', '精装修'),
       ('24', '8', '集体供暖'),
       ('25', '21', '独立阳台');

CREATE TABLE `subway`
(
    `id`           bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `name`         varchar(32)         NOT NULL COMMENT '线路名',
    `city_en_name` varchar(32)         NOT NULL COMMENT '所属城市英文名缩写',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

INSERT INTO `subway`
VALUES ('1', '13号线', 'bj'),
       ('2', '1号线', 'bj'),
       ('3', '2号线', 'bj'),
       ('4', '10号线', 'bj'),
       ('5', '8号线', 'bj'),
       ('6', '9号线', 'bj'),
       ('7', '7号线', 'bj');

CREATE TABLE `subway_station`
(
    `id`        bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `subway_id` bigint(20)          NOT NULL COMMENT '所属地铁线id',
    `name`      varchar(32)         NOT NULL COMMENT '站点名称',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

INSERT INTO `subway_station`
VALUES ('5', '1', '上地'),
       ('16', '1', '东直门'),
       ('4', '1', '五道口'),
       ('14', '1', '光熙门'),
       ('11', '1', '北苑'),
       ('8', '1', '回龙观'),
       ('2', '1', '大钟寺'),
       ('12', '1', '望京西'),
       ('15', '1', '柳芳'),
       ('3', '1', '知春路'),
       ('10', '1', '立水桥'),
       ('13', '1', '芍药居'),
       ('6', '1', '西二旗'),
       ('1', '1', '西直门'),
       ('9', '1', '霍营'),
       ('7', '1', '龙泽'),
       ('33', '4', '三元家庄'),
       ('51', '4', '三元桥'),
       ('41', '4', '丰台站'),
       ('52', '4', '亮马桥'),
       ('27', '4', '健德门'),
       ('46', '4', '公主坟'),
       ('44', '4', '六里桥'),
       ('53', '4', '农业展览馆'),
       ('62', '4', '分钟寺'),
       ('59', '4', '劲松'),
       ('28', '4', '北土城'),
       ('61', '4', '十里河'),
       ('58', '4', '双井'),
       ('55', '4', '呼家楼'),
       ('54', '4', '团结湖'),
       ('57', '4', '国贸'),
       ('35', '4', '大红门'),
       ('32', '4', '太阳宫'),
       ('29', '4', '安贞门'),
       ('64', '4', '宋家庄'),
       ('20', '4', '巴沟'),
       ('30', '4', '惠新西街南口'),
       ('48', '4', '慈寿寺'),
       ('63', '4', '成寿寺'),
       ('42', '4', '泥洼'),
       ('22', '4', '海淀黄庄'),
       ('60', '4', '潘家园'),
       ('19', '4', '火器营'),
       ('26', '4', '牡丹园'),
       ('24', '4', '知春路'),
       ('23', '4', '知春里'),
       ('34', '4', '石榴庄'),
       ('39', '4', '纪家庙'),
       ('31', '4', '芍药居'),
       ('21', '4', '苏州街'),
       ('38', '4', '草桥'),
       ('45', '4', '莲花桥'),
       ('25', '4', '西土城'),
       ('43', '4', '西局'),
       ('47', '4', '西钓鱼台'),
       ('36', '4', '角门东'),
       ('37', '4', '角门西'),
       ('17', '4', '车道沟'),
       ('56', '4', '金台夕照'),
       ('18', '4', '长春桥'),
       ('40', '4', '首经贸');

CREATE TABLE `support_address`
(
    `id`            bigint(11) unsigned NOT NULL AUTO_INCREMENT,
    `belong_to`     varchar(32)         NOT NULL DEFAULT '0' COMMENT '上一级行政单位名',
    `en_name`       varchar(32)         NOT NULL COMMENT '行政单位英文名缩写',
    `cn_name`       varchar(32)         NOT NULL COMMENT '行政单位中文名',
    `level`         varchar(16)         NOT NULL COMMENT '行政级别 市-city 地区-region',
    `baidu_map_lng` double              NOT NULL COMMENT '百度地图经度',
    `baidu_map_lat` double              NOT NULL COMMENT '百度地图纬度',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

INSERT INTO `support_address`
VALUES ('4', 'bj', 'bj', '北京', 'city', '116.395645', '39.929986'),
       ('5', 'sh', 'sh', '上海', 'city', '121.487899', '31.249162'),
       ('6', 'hb', 'sjz', '石家庄', 'city', '114.522082', '38.048958'),
       ('7', 'hb', 'ts', '唐山', 'city', '118.183451', '39.650531'),
       ('8', 'hb', 'hd', '邯郸', 'city', '114.482694', '36.609308'),
       ('9', 'bj', 'dcq', '东城区', 'region', '116.42188470126446', '39.93857401298612'),
       ('10', 'bj', 'xcq', '西城区', 'region', '116.37319010401802', '39.93428014370851'),
       ('12', 'bj', 'hdq', '海淀区', 'region', '116.23967780102151', '40.03316204507791'),
       ('13', 'bj', 'cpq', '昌平区', 'region', '116.21645635689414', '40.2217235498323'),
       ('14', 'sh', 'ptq', '普陀区', 'region', '121.39844294374956', '31.263742929075534'),
       ('15', 'sjz', 'caq', '长安区', 'region', '114.59262155387033', '38.07687479578663'),
       ('16', 'sjz', 'qdq', '桥东区', 'region', '114.51078430496142', '38.06338975380927'),
       ('17', 'sjz', 'qxq', '桥西区', 'region', '114.43813995531943', '38.033364550068136'),
       ('18', 'sjz', 'xhq', '新华区', 'region', '114.4535014286928', '38.117218640478164'),
       ('19', 'bj', 'cyq', '朝阳区', 'region', '116.52169489108084', '39.95895316640668');

CREATE TABLE `role`
(
    `id`      bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `user_id` bigint(20) unsigned NOT NULL COMMENT '用户id',
    `name`    varchar(32)         NOT NULL COMMENT '用户角色名',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

INSERT INTO `role` (id, name, user_id)
values (1, 'admin', 1);
INSERT INTO `role` (id, name, user_id)
values (2, 'user', 2);

CREATE TABLE `user`
(
    `id`               int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户唯一id',
    `name`             varchar(32)               DEFAULT NULL COMMENT '用户名',
    `email`            varchar(32)               DEFAULT NULL COMMENT '电子邮箱',
    `phone_number`     varchar(15)      NOT NULL COMMENT '电话号码',
    `password`         varchar(32)               DEFAULT NULL COMMENT '密码',
    `status`           int(2) unsigned  NOT NULL DEFAULT '0' COMMENT '用户状态 0-正常 1-封禁',
    `create_time`      datetime         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '用户账号创建时间',
    `last_login_time`  datetime         NULL     DEFAULT CURRENT_TIMESTAMP COMMENT '上次登录时间',
    `last_update_time` datetime         NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '上次更新记录时间',
    `avatar`           varchar(255)              DEFAULT NULL COMMENT '头像',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

INSERT INTO `user` (id, name, email, phone_number, password, status, create_time, last_login_time, last_update_time,
                    avatar)
values (1, 'admin', 'admin@qq.com', '', '{noop}admin', 1, now(), NULL, now(), '');
INSERT INTO `user` (id, name, email, phone_number, password, status, create_time, last_login_time, last_update_time,
                    avatar)
values (2, 'test', 'test@qq.com', '13100000000', '{noop}123456', 1, now(), NULL, now(), '');
