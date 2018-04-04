package com.st.common;

import com.st.pojo.WeiboContent;
import lombok.Data;

import java.util.ArrayList;

@Data
public class ContentResp extends Response {

    private ArrayList<WeiboContent> statuses = new ArrayList<>(50);
}
