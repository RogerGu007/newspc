package com.fc.entity;

public enum TopicEnum {
    JOB("招聘", "工作机会", "https://www.baidu.com/s?wd=58%E5%90%8C%E5%9F%8E&usm=1&ie=utf-8&rsv_cq=%E5%B7%A5%E4%BD%9C&rsv_dl=0_right_recommends_merge_21102&cq=%E5%B7%A5%E4%BD%9C&srcid=28310&rt=%E8%B5%84%E8%AE%AF%E7%B1%BB%E7%BD%91%E7%AB%99&recid=21102&euri=8364412a5b9c46af97061c60b7f362e7"),
    FRIEND("鹊桥", "牵线搭桥", "https://baike.baidu.com/pic/%E9%B9%8A%E6%A1%A5/1309743/0/77094b36acaf2eddd1747e9d8e1001e939019338?fr=lemma&ct=single"),
    INTERN("实习/兼职", "实习、兼职招聘", "http://www.doublefuck.top/image/b.jpg"),
    ALLTIME("全职", "全职招聘", "http://www.doublefuck.top/image/b.jpg"),
    SHANGHAI("上海", "上海热点消息", "http://www.doublefuck.top/image/b.jpg"),
    BEIJING("北京", "北京热点消息", "http://www.doublefuck.top/image/b.jpg"),
    NANJING("南京", "南京热点消息", "http://www.doublefuck.top/image/b.jpg"),
    WUHAN("武汉", "武汉热点消息", "http://www.doublefuck.top/image/b.jpg"),
    HANGZHOU("全职", "杭州热点消息", "http://www.doublefuck.top/image/b.jpg");

    private String name;
    private String content;
    private String image;

    private TopicEnum(String name, String content, String image) {
        this.name = name;
        this.content = content;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public String getImage() {
        return image;
    }
}
