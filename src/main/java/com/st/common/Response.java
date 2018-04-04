package com.st.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Response {

    @JsonProperty("total_number")
    private int totalNumber;

}
