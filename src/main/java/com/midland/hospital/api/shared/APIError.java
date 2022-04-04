package com.midland.hospital.api.shared;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class APIError {

    private String code;
    private String message;
}
