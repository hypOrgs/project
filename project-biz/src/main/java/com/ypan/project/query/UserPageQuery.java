package com.ypan.project.query;

import com.ypan.base.BasePage;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserPageQuery extends BasePage {

    @ApiModelProperty("用户名字")
    private String name;

    private Integer age;


}
