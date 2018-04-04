package com.st.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WeiboRepost extends WeiboResp {

    //可选的父级内容id
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Long pid;

    @JsonProperty("reposts_count")
    private Integer repostsCount;

    @JsonProperty("comments_count")
    private Integer commentsCount;

    @JsonProperty("attitudes_count")
    private Integer attitudesCount;

}
