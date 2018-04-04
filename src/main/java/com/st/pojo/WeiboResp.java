package com.st.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WeiboResp {

    @JsonProperty("created_at")
    private String createdAt;

    private Long id;

    private WeiboUser user;

    private String text;

    //发布来源，如华为，三星
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String source;
}
