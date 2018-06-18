package com.fc.entity;

import java.util.HashMap;
import java.util.Map;

public enum BBSEnum {
    SJTU_BBS(2L, "上海交通大学BBS", "https://bbs.sjtu.edu.cn", "http://www.211sq.com/asset/image/university/sjtu.jpg"),
    TJ_BBS(1L, "同济大学BBS", "https://bbs.tongji.net", "http://www.211sq.com/asset/image/university/tj.jpg"),
    FUDAN_BBS(3L, "复旦大学BBS", "https://bbs.fudan.edu.cn", "http://www.211sq.com/asset/image/university/fudan.jpg"),
    ECNU_BBS(4L, "华东师范大学BBS", "http://bbs.iecnu.com", "http://www.211sq.com/asset/image/university/iecnu.jpg"),
//    SUFE_BBS(5L, "上海财经大学BBS", "http://www.newsmth.net", "https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=1403325730,2877275142&fm=58&bpow=715&bpoh=715"),
    ECUST_BBS(6L, "华东理工大学BBS", "http://www.ecust.com", "http://www.211sq.com/asset/image/university/ecust.jpg"),
    NJU_BBS(7L, "南京大学BBS", "http://bbs.nju.edu.cn", "http://www.211sq.com/asset/image/university/nju.jpg"),
    SEU_BBS(8L, "东南大学BBS", "http://bbs.seu.edu.cn", "http://www.211sq.com/asset/image/university/seu.jpg"),
    TSING_BBS(9L, "清华大学BBS", "http://www.newsmth.net", "http://www.211sq.com/asset/image/university/tsing.jpg"),
    PEKING_BBS(10L, "北京大学BBS", "https://bbs.pku.edu.cn/v2/home.php", "http://www.211sq.com/asset/image/university/pku.jpg"),
//    RUC_BBS(11L, "中国人民大学BBS", "http://www.newsmth.net", "https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=3632758401,3403372161&fm=58&bpow=693&bpoh=689"),
    WHU_BBS(12L, "武汉大学BBS", "http://bbs.whu.edu.cn", "http://www.211sq.com/asset/image/university/whu.jpg"),
//    HUST_BBS(13L, "华中科技大学BBS", "http://www.newsmth.net", "https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=4258120518,4176695131&fm=58&bpow=787&bpoh=599"),
//    USTC_BBS(14L, "中科大BBS", "http://www.newsmth.net", "https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=3623014369,3274114902&fm=58&bpow=465&bpoh=461"),
    ZJU_BBS(15L, "浙江大学BBS", "http://www.zju1.com", "http://www.211sq.com/asset/image/university/zju.jpg");

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
