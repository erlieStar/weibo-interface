package com.st.controller;

import com.st.common.Response;
import com.st.service.CommentService;
import com.st.service.ContentService;
import com.st.service.RepostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    CommentService commentService;

    @Autowired
    RepostService repostService;

    @Autowired
    ContentService contentService;

    //page 第几页
    //count 每页的个数
    //获取微博评论
    @RequestMapping("/2/comments/show/all.json")
    public Response getComment(@RequestParam("id") Long mid, @RequestParam("page") Integer page, @RequestParam("count") Integer count) {

        return commentService.getComment(mid, page, count);
    }

    //获取微博转发
    @RequestMapping("/2/statuses/repost_timeline/all.json")
    public Response getRepost(@RequestParam("id") Long mid, @RequestParam("page") Integer page, @RequestParam("count") Integer count) {
        return repostService.getRepost(mid, page, count);
    }

    //接口说明地址：http://open.weibo.com/wiki/C/2/statuses/show_batch/biz
    //根据微博ID批量获取微博信息
    @RequestMapping("/2/statuses/show_batch/biz.json")
    public Response getContent(@RequestParam("ids") String ids) {
        return contentService.getContent(ids);
    }

}
