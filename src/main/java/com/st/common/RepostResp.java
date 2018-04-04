package com.st.common;

import com.st.pojo.WeiboRepost;
import lombok.Data;

import java.util.ArrayList;

@Data
public class RepostResp extends Response {

    private ArrayList<WeiboRepost> reposts = new ArrayList<>(50);
}
