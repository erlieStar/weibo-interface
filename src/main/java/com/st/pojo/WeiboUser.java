package com.st.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WeiboUser {

    private Long id;
    private String name;
    private Integer province;
    private String location;
    private String gender;

    //认证类型: 1=蓝v 2=金V黄v 3=达人 4=普通
    @JsonProperty("verified_type")
    private Integer verifiedType;

    //粉丝数
    @JsonProperty("followers_count")
    private Integer followersCount;

    //关注数
    @JsonProperty("friends_count")
    private Integer friendsCount;

    //微博数
    @JsonProperty("statuses_count")
    private Integer statusesCount;

    //注册时间
    @JsonProperty("created_at")
    private String createdAt;

    //头像地址
    @JsonProperty("profile_image_url")
    private String profileImageUrl;

}
