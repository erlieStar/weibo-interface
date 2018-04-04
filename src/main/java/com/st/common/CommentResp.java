package com.st.common;

import com.st.pojo.WeiboComment;
import lombok.Data;

import java.util.ArrayList;

@Data
public class CommentResp extends Response {

    private ArrayList<WeiboComment> comments = new ArrayList<>(50);
}
