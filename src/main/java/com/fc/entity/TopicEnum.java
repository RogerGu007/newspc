package com.fc.entity;

public enum TopicEnum {
    JOB("招聘", "工作机会", "https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=4173520529,1358963407&fm=58&bpow=1024&bpoh=614"),
    FRIEND("鹊桥", "牵线搭桥", "https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=2694270113,2292182059&fm=58&bpow=500&bpoh=311"),
    INTERN("实习/兼职", "实习、兼职招聘", "https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1497575856,1555364854&fm=58&bpow=564&bpoh=377"),
    ALLTIME("全职", "全职招聘", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1526189730559&di=ccb209cb02df6de8e3d389f2b49f596e&imgtype=0&src=http%3A%2F%2Fs1.sinaimg.cn%2Fmw690%2F003fd1Pzzy6MMpakPBuc0%26690"),
    SHANGHAI("上海", "上海热点消息", "https://ss3.baidu.com/-rVXeDTa2gU2pMbgoY3K/it/u=960266911,502707575&fm=202&src=781&mola=new&crop=v1"),
    BEIJING("北京", "北京热点消息", "https://ss3.baidu.com/-rVXeDTa2gU2pMbgoY3K/it/u=3802768454,1679233125&fm=202&src=2000&mola=new&crop=v1"),
    NANJING("南京", "南京热点消息", "https://ss0.baidu.com/73F1bjeh1BF3odCf/it/u=1516287591,3644593756&fm=85&s=18364795444C7D4F4802CDC1030060AB"),
    WUHAN("武汉", "武汉热点消息", "https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=3369017060,2602190605&fm=58&bpow=500&bpoh=389"),
    HANGZHOU("杭州", "杭州热点消息", "https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2117706685,1286189115&fm=58&bpow=1250&bpoh=800");

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
