package com.ypan.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AddUserForm {

    @ApiModelProperty(value = "用户名字", required = true)
    @NotBlank(message = "用户名字不能为空")
    private String name;

    @ApiModelProperty(value = "用户年龄", required = true)
    @NotNull(message = "用户年龄不能为空")
    private Integer age;
}
