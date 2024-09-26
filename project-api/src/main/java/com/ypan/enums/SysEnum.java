package com.ypan.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SysEnum {

    SUCCESS(1, "成功");

    private Integer code;
    private String desc;
}
