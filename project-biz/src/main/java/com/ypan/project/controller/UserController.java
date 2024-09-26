package com.ypan.project.controller;


import cn.dev33.satoken.stp.StpUtil;
import com.ypan.base.BaseResult;
import com.ypan.form.AddUserForm;
import com.ypan.form.UpdateUserForm;
import com.ypan.project.aspect.annotion.RateLimiter;
import com.ypan.project.dto.JDSaveTaskDTO;
import com.ypan.project.entity.User;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ypan.project.query.UserPageQuery;
import com.ypan.project.service.TestService;
import com.ypan.project.service.UserService;
import com.ypan.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author pan
 * @since 2022-09-21
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户管理", tags = "用户管理")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TestService testService;

    @ApiOperation(value = "新增用户")
    @PostMapping("/add")
    public BaseResult<Boolean> addUser(@RequestBody @Valid AddUserForm form) {
        return BaseResult.ok(userService.addUser(form));
    }

    @GetMapping("/save")
    public BaseResult<Boolean> save() {
        return BaseResult.ok(testService.testAsync());
    }

    @ApiOperation(value = "修改用户信息")
    @PostMapping("/update")
    public BaseResult<Boolean> updateUser(@RequestBody UpdateUserForm form) {
        return BaseResult.ok(userService.updateUser(form));
    }

    @ApiOperation(value = "根据Id删除用户信息")
    @GetMapping("/delete")
    public BaseResult<Boolean> deleteUser(@RequestParam Long id) {
        return BaseResult.ok(userService.deleteUserById(id));
    }

    @ApiOperation(value = "分页查询用户信息")
    @PostMapping("/page")
    public BaseResult<Page<UserVO>> page(@RequestBody UserPageQuery query) {
        return BaseResult.ok(userService.pageByQuery(query));
    }

    @GetMapping("/get/name/count")
    public BaseResult<Integer> getCount(@RequestParam("name") String name) {
        return BaseResult.ok(100);
    }

    @GetMapping("/get/user/name")
    @RateLimiter(time = 60, count = 3)
    public BaseResult<User> getUser(@RequestParam(value = "name", required = false) String name) {
        return BaseResult.ok(userService.getUser(name));
    }

    @ApiOperation(value = "分页查询用户信息")
    @PostMapping("/test")
    public BaseResult test(@RequestBody JDSaveTaskDTO jdSaveTaskDTO) {
        return BaseResult.ok(userService.test(jdSaveTaskDTO));
    }

    // 测试登录，浏览器访问： http://localhost:8081/user/doLogin?username=zhang&password=123456
    @PostMapping("doLogin")
    public String doLogin(String username, String password) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if("zhang".equals(username) && "123456".equals(password)) {
            StpUtil.login(10001);
            return "登录成功";
        }
        return "登录失败";
    }

    // 查询登录状态，浏览器访问： http://localhost:8081/user/isLogin
    @GetMapping("isLogin")
    public String isLogin() {
        return "当前会话是否登录：" + StpUtil.isLogin();
    }


}

