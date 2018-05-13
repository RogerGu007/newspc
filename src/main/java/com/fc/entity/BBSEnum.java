package com.fc.entity;

import java.util.HashMap;
import java.util.Map;

public enum BBSEnum {
    SJTU_BBS(2L, "上海交通大学BBS", "https://bbs.sjtu.edu.cn", "https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=3375747713,2591547652&fm=58&bpow=1024&bpoh=1024"),
    TJ_BBS(1L, "同济大学BBS", "https://bbs.tongji.net", "https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2951361712,2965132577&fm=58&bpow=971&bpoh=974"),
    FUDAN_BBS(3L, "复旦大学BBS", "https://bbs.fudan.edu.cn", "https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2031677745,545048845&fm=58&bpow=400&bpoh=400"),
    ECNU_BBS(4L, "华东师范大学BBS", "http://bbs.iecnu.com", "https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=2025476624,2981669612&fm=58&bpow=600&bpoh=600"),
//    SUFE_BBS(5L, "上海财经大学BBS", "http://www.newsmth.net", "https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=1403325730,2877275142&fm=58&bpow=715&bpoh=715"),
    ECUST_BBS(6L, "华东理工大学BBS", "http://www.newsmth.net", "https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1733592537,1506739280&fm=58&bpow=800&bpoh=800"),
    NJU_BBS(7L, "南京大学BBS", "http://bbs.nju.edu.cn", "https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=1076576704,4283853172&fm=58&bpow=1200&bpoh=1504"),
    SEU_BBS(8L, "东南大学BBS", "http://bbs.seu.edu.cn", "https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2433426127,2743121596&fm=58&bpow=718&bpoh=718"),
    TSING_BBS(9L, "清华大学BBS", "http://www.newsmth.net", "https://ss1.baidu.com/70cFfyinKgQFm2e88IuM_a/forum/pic/item/ce2e42a7d933c8953198e931d71373f0830200a4.jpg"),
    PEKING_BBS(10L, "北京大学BBS", "https://bbs.pku.edu.cn/v2/home.php", "https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=4127653021,2219382705&fm=58"),
//    RUC_BBS(11L, "中国人民大学BBS", "http://www.newsmth.net", "https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=3632758401,3403372161&fm=58&bpow=693&bpoh=689"),
    WHU_BBS(12L, "武汉大学BBS", "http://bbs.whu.edu.cn", "https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=659974452,3463077321&fm=58&bpow=600&bpoh=600"),
//    HUST_BBS(13L, "华中科技大学BBS", "http://www.newsmth.net", "https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=4258120518,4176695131&fm=58&bpow=787&bpoh=599"),
//    USTC_BBS(14L, "中科大BBS", "http://www.newsmth.net", "https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=3623014369,3274114902&fm=58&bpow=465&bpoh=461"),
    ZJU_BBS(15L, "浙江大学BBS", "http://www.zju1.com", "https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2194450869,662627224&fm=58&w=200&h=200&img.JPEG");

    private Long userId;
    private String username;
    private String linkUrl;
    private String avatarUrl;

    private BBSEnum(Long userId, String username, String linkUrl, String avatarUrl) {
        this.userId = userId;
        this.username = username;
        this.linkUrl = linkUrl;
        this.avatarUrl = avatarUrl;
    }

    public static BBSEnum userIdToBBS(Long userId) {
        for (BBSEnum bbsEnum : BBSEnum.values()) {
            if (bbsEnum.userId == userId) {
                return bbsEnum;
            }
        }

        return null;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }
}
