package com.ypan.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateUserForm {

    @ApiModelProperty(value = "用户主键id", required = true)
    @NotNull(message = "主键id不得为空")
    private Long id;

    @ApiModelProperty(value = "用户名字")
    private String name;

    @ApiModelProperty(value = "用户年龄")
    private Integer age;
}
