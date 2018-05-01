package com.fc.service;

import com.fc.async.MessageTask;
import com.fc.gson.NewsDetailResultGson;
import com.fc.gson.NewsSubjectResultGson;
import com.fc.mapper.MessageMapper;
import com.fc.mapper.PostMapper;
import com.fc.mapper.ReplyMapper;
import com.fc.mapper.UserMapper;
import com.fc.model.NewsDTO;
import com.fc.model.NewsDetailDTO;
import com.fc.model.PageBean;
import com.fc.model.Post;
import com.fc.util.GsonUtils;
import com.fc.util.MyConstant;
import com.fc.util.MyUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.fc.entity.Constant.GET_NEWS_DETAIL;
import static com.fc.entity.Constant.GET_NEWS_LIST_SUBJECTS_BY_PAGE;
import static com.fc.entity.RetCode.RET_CODE_OK;


@Service
public class PostService {

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ReplyMapper replyMapper;

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private JedisPool jedisPool;

    @Autowired
    private TaskExecutor taskExecutor;

    @Autowired
    private HttpClientOperateService httpClientOperateService;

    Logger logger = Logger.getLogger(PostService.class.getName());

    //根据uid，获得帖子列表
    public List<Post> getPostList(int uid) {
        return postMapper.listPostByUid(uid);
    }

    public int publishPost(Post post) {

        //构造帖子
        post.setPublishTime(MyUtil.formatDate(new Date()));
        post.setReplyTime(MyUtil.formatDate(new Date()));
        post.setReplyCount(0);
        post.setLikeCount(0);
        post.setScanCount(0);
        //插入一条帖子记录
        postMapper.insertPost(post);
        System.out.println(post.getPid());
        //更新用户发帖量
        userMapper.updatePostCount(post.getUser().getUid());

        return post.getPid();
    }

    //按时间列出帖子
    public PageBean<NewsDTO> listPostByTime(int location, int newsType, int subNewsType, int curPage) {
        Map<String, String> newsMap = new HashMap<>();
        newsMap.put("location", String.valueOf(location));
        newsMap.put("newstype", String.valueOf(newsType));
        newsMap.put("page", String.valueOf(curPage));
        if (subNewsType != 0)
            newsMap.put("subnewstype", String.valueOf(subNewsType));

        PageBean<NewsDTO> pageBean = new PageBean<>(10, curPage);
        try {
            String response = httpClientOperateService.doGet(GET_NEWS_LIST_SUBJECTS_BY_PAGE, newsMap);
            NewsSubjectResultGson resultGson = GsonUtils.fromJson(response, NewsSubjectResultGson.class);
            pageBean.setList(resultGson.getNewsList());
        } catch (Exception e) {
            logger.error(GET_NEWS_LIST_SUBJECTS_BY_PAGE + " failed! " + e.getMessage());
        }

        return pageBean;
//        //每页记录数，从哪开始
//        int limit = 8;
//        int offset = (curPage-1) * limit;
//        //获得总记录数，总页数
//        int allCount = postMapper.selectPostCount();
//        int allPage = 0;
//        if (allCount <= limit) {
//            allPage = 1;
//        } else if (allCount / limit == 0) {
//            allPage = allCount / limit;
//        } else {
//            allPage = allCount / limit + 1;
//        }
//        //分页得到数据列表
//        List<Post> postList = postMapper.listPostByTime(offset,limit);
//        Jedis jedis = jedisPool.getResource();
//        for(Post post : postList){
//            post.setLikeCount((int)(long)jedis.scard(post.getPid()+":like"));
//        }
//
//        //构造PageBean
//        PageBean<Post> pageBean = new PageBean<>(allPage,curPage);
//        pageBean.setList(postList);
//
//        if(jedis!=null){
//            jedisPool.returnResource(jedis);
//        }
//        return pageBean;
    }

    //按时间列出帖子
    public PageBean<Post> listPostByTime(int curPage) {
        //每页记录数，从哪开始
        int limit = 8;
        int offset = (curPage-1) * limit;
        //获得总记录数，总页数
        int allCount = postMapper.selectPostCount();
        int allPage = 0;
        if (allCount <= limit) {
            allPage = 1;
        } else if (allCount / limit == 0) {
            allPage = allCount / limit;
        } else {
            allPage = allCount / limit + 1;
        }
        //分页得到数据列表
        List<Post> postList = postMapper.listPostByTime(offset,limit);
        Jedis jedis = jedisPool.getResource();
        for(Post post : postList){
            post.setLikeCount((int)(long)jedis.scard(post.getPid()+":like"));
        }

        //构造PageBean
        PageBean<Post> pageBean = new PageBean<>(allPage,curPage);
        pageBean.setList(postList);

        if(jedis!=null){
            jedisPool.returnResource(jedis);
        }
        return pageBean;
    }

//    public Post getPostByPid(int pid) {
//        //更新浏览数
//        postMapper.updateScanCount(pid);
//        Post post =postMapper.getPostByPid(pid);
//        //设置点赞数
//        Jedis jedis = jedisPool.getResource();
//        long likeCount = jedis.scard(pid+":like");
//        post.setLikeCount((int)likeCount);
//
//        if(jedis!=null){
//            jedisPool.returnResource(jedis);
//        }
//        return post;
//    }

    public NewsDetailDTO getPostDetail(int newsId, Long userId) {
        //更新浏览数
        postMapper.updateScanCount(newsId);
        Map<String, String> newsMap = new HashMap<>();
        newsMap.put("newsid", String.valueOf(newsId));
        newsMap.put("userid", String.valueOf(userId));
        NewsDetailDTO newsDetailDTO = null;
        try {
            String response = httpClientOperateService.doGet(GET_NEWS_DETAIL, newsMap);
            NewsDetailResultGson newsDetailResultGson
                    = GsonUtils.fromJson(response, NewsDetailResultGson.class);
            if (newsDetailResultGson.getRetCode() == RET_CODE_OK) {
                newsDetailDTO = newsDetailResultGson.getNewsDetailDTO();
            }
        } catch (Exception e) {
            logger.warn(GET_NEWS_DETAIL + " failed! " + e.getMessage());
        }

        return newsDetailDTO;

//        Post post = postMapper.getPostByPid(pid);
//        //设置点赞数
//        Jedis jedis = jedisPool.getResource();
//        long likeCount = jedis.scard(pid+":like");
//        post.setLikeCount((int)likeCount);
//
//        if(jedis!=null){
//            jedisPool.returnResource(jedis);
//        }
//        return post;
    }

    //点赞
    public String clickLike(int pid, int sessionUid) {
        Jedis jedis = jedisPool.getResource();
        //pid被sessionUid点赞
        jedis.sadd(pid+":like", String.valueOf(sessionUid));
        //增加用户获赞数
        jedis.hincrBy("vote",sessionUid+"",1);

        //插入一条点赞消息
        taskExecutor.execute(new MessageTask(messageMapper,userMapper,postMapper,replyMapper,pid,0,sessionUid, MyConstant.OPERATION_CLICK_LIKE));
        String result = String.valueOf(jedis.scard(pid+":like"));

        if(jedis!=null){
            jedisPool.returnResource(jedis);
        }
        return result;
    }

    //某用户是否赞过某帖子
    public boolean getLikeStatus(int pid, int sessionUid) {
        Jedis jedis = jedisPool.getResource();
        boolean result = jedis.sismember(pid+":like", String.valueOf(sessionUid));

        if(jedis!=null){
            jedisPool.returnResource(jedis);
        }
        return result;
    }
}

