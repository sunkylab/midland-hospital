package com.midland.hospital.api.shared;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class APIResponse {

    private String code;
    private String message;
    private Object data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private APIError error;

    public APIResponse() {
    }

    public APIResponse(Object data) {
        this.data = data;
        this.code="00";
        this.message="success";
    }
}
