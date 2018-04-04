package com.st.service;

import com.st.common.Response;

public interface RepostService {
    public Response getRepost(Long mid, Integer page, Integer count);
}
