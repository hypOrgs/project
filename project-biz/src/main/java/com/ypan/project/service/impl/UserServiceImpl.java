package com.ypan.project.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ypan.form.AddUserForm;
import com.ypan.form.UpdateUserForm;
import com.ypan.project.dto.JDSaveTaskDTO;
import com.ypan.project.query.UserPageQuery;
import com.ypan.project.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ypan.project.entity.User;
import com.ypan.project.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ypan.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author pan
 * @since 2022-09-21
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public Boolean addUser(AddUserForm form) {
        User user = new User();
        user.setName(form.getName());
        QueryWrapper<Object> query = Wrappers.query();
        user.setAge(form.getAge());
        return this.save(user);
    }

    @Override
    public Boolean updateUser(UpdateUserForm form) {

        User user = new User();
        BeanUtils.copyProperties(form, user);
        return this.updateById(user);
    }

    @Override
    public Boolean deleteUserById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Page<UserVO> pageByQuery(UserPageQuery query) {

        Page<User> page = new Page<>();
        page.setCurrent(query.getPageNumber());
        page.setSize(query.getPageSize());

        Page<User> userPage = this.lambdaQuery()
                .like(Strings.isNotBlank(query.getName()), User::getName, query.getName())
                .eq(Objects.nonNull(query.getAge()), User::getAge, query.getAge())
                .page(page);


        Page<UserVO> userVOPage = new Page<>();
        BeanUtils.copyProperties(userPage, userVOPage);
        List<User> records = userPage.getRecords();
        List<UserVO> userVOList = new ArrayList<>(records.size());

        records.forEach(record -> {
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(record, userVO);
            userVOList.add(userVO);
        });

        userVOPage.setRecords(userVOList);
        return userVOPage;
    }

    @Override
    public Boolean testUser(User user) {

        if (true) {
            throw new RuntimeException("报着玩儿");
        }

        this.save(user);

       return true;
    }

    @Override
    public User getUser(String name) {

        return this.lambdaQuery().eq(User::getName, name).last("limit 1").one();
    }

    @Override
    public Object test(JDSaveTaskDTO jdSaveTaskDTO) {


        String s1 = JSON.toJSONString(jdSaveTaskDTO);
        log.info("=====:{}", s1);
        return null;

    }


}
