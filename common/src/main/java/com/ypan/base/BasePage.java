package com.ypan.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "分页查询参数")
public class BasePage {

    @ApiModelProperty("当前页码，默认为1")
    private Integer pageNumber = 1;

    @ApiModelProperty("每页条数，默认为10")
    private Integer pageSize = 10;
}
