package com.st.service;

import com.st.common.Response;

public interface CommentService {
    public Response getComment(Long mid, Integer page, Integer count);
}
