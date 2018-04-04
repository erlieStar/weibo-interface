package com.st.service.impl;

import com.st.common.ContentResp;
import com.st.common.Response;
import com.st.pojo.WeiboContent;
import com.st.pojo.WeiboUser;
import com.st.service.ContentService;
import com.st.util.DateTimeUtil;
import com.st.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@Slf4j
@Service
public class ContentServiceImpl implements ContentService {


    @Override
    public Response getContent(String ids) {

        ContentResp contentResp = new ContentResp();
        ArrayList<WeiboContent> list = new ArrayList<>(50);

        String[] idArray = ids.split(",");
        for (int i = 0; i < idArray.length; i++) {
            WeiboContent weiboContent = new WeiboContent();

            weiboContent.setCreatedAt(DateTimeUtil.dateToStr(new Date()));

            weiboContent.setId(Long.valueOf(idArray[i]));

            weiboContent.setText("aaa");

            weiboContent.setMid(Long.valueOf(idArray[i]));

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
            weiboContent.setUser(user);
            list.add(weiboContent);
        }
        contentResp.setStatuses(list);
        contentResp.setTotalNumber(idArray.length);
        return contentResp;
    }
}
