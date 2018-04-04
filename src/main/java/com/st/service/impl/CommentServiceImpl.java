package com.st.service.impl;

import com.st.common.CommentResp;
import com.st.common.Response;
import com.st.pojo.WeiboComment;
import com.st.pojo.WeiboUser;
import com.st.service.CommentService;
import com.st.util.DateTimeUtil;
import com.st.util.RandomUtil;
import com.st.util.YamlUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

@Slf4j
@Service
public class CommentServiceImpl implements CommentService {

    private long commentId = 0;

    @Override
    public Response getComment(Long mid, Integer page, Integer count) {

        CommentResp commentResp = new CommentResp();

        ArrayList<WeiboComment> list = new ArrayList<>(50);
        for (int i = 0; i < count; i++) {
            WeiboComment weiboComment = new WeiboComment();

            weiboComment.setCreatedAt(DateTimeUtil.dateToStr(new Date()));

            weiboComment.setId(commentId++);

            weiboComment.setText("aaa");

            WeiboUser user = new WeiboUser();
            UUID uuid = UUID.randomUUID();
            user.setId(RandomUtil.getRandomUserId());
            user.setName(uuid.toString());
            user.setCreatedAt(DateTimeUtil.dateToStr(new Date()));
            user.setGender(RandomUtil.getRandomGender());
            user.setLocation(RandomUtil.getRandomCity());
            user.setProvince(RandomUtil.getRandomProvince());
            user.setFollowersCount(10);
            user.setFriendsCount(10);
            user.setStatusesCount(10);
            user.setProfileImageUrl("www.image.aa");
            user.setVerifiedType(RandomUtil.getRandomVerifiedType());
            weiboComment.setUser(user);
            list.add(weiboComment);
        }
        commentResp.setComments(list);
        int start = YamlUtil.getInteger("start");
        int end = YamlUtil.getInteger("end");
        Random random = new Random();
        //生成[start,end]范围之内的数字
//        int totalNumber = random.nextInt(end - start + 1) + start;
        int totalNumber = 200;
        commentResp.setTotalNumber(totalNumber);

        return commentResp;
    }
}
