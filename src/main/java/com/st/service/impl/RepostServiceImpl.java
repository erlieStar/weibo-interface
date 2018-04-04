package com.st.service.impl;

import com.st.common.RepostResp;
import com.st.common.Response;
import com.st.pojo.WeiboRepost;
import com.st.pojo.WeiboUser;
import com.st.service.RepostService;
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
public class RepostServiceImpl implements RepostService {

    private long repostId = 0;

    @Override
    public Response getRepost(Long mid, Integer page, Integer count) {
        RepostResp repostResp = new RepostResp();

        ArrayList<WeiboRepost> list = new ArrayList<>(50);
        for (int i = 0; i < count; i++) {
            WeiboRepost weiboRepost = new WeiboRepost();

            weiboRepost.setCreatedAt(DateTimeUtil.dateToStr(new Date()));

            weiboRepost.setId(repostId++);

            weiboRepost.setText("aaa");
            weiboRepost.setAttitudesCount(10);
            weiboRepost.setCommentsCount(10);
            weiboRepost.setRepostsCount(10);

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
            weiboRepost.setUser(user);
            list.add(weiboRepost);
        }
        repostResp.setReposts(list);
        int start = YamlUtil.getInteger("start");
        int end = YamlUtil.getInteger("end");
        Random random = new Random();
        //生成[start,end]范围之内的数字
//        int totalNumber = random.nextInt(end - start + 1) + start;
        int totalNumber = 200;
        repostResp.setTotalNumber(totalNumber);

        return repostResp;
    }
}
