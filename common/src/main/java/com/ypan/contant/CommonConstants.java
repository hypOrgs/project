package com.ypan.contant;

/**
 * 全局变量
 */
public interface CommonConstants {

    /**
     * header 中版本信息
     */
    String VERSION = "VERSION";

    /**
     * 租户ID
     */
    String TENANT_ID_1 = "1";

    /**
     * 默认root节点
     */
    String DEFAULT_PARENT = "0";
    /**
     * 删除
     */
    String STATUS_DEL = "1";
    /**
     * 正常
     */
    String STATUS_NORMAL = "0";

    /**
     * 锁定
     */
    String STATUS_LOCK = "9";

    /**
     * 菜单树根节点
     */
    String MENU_TREE_ROOT_ID = "-1";

    /**
     * 编码
     */
    String UTF8 = "UTF-8";

    /**
     * 成功标记
     */
    Integer SUCCESS = 0;
    /**
     * 失败标记
     */
    Integer FAIL = 1;
    /***
     * 请求HEADER 参数 RequestId
     */

    String REQUEST_ID = "RequestId";
    /***
     * 请求HEADER 参数 FromId
     */
    String FROM_ID = "FromId";
}

