package com.ypan.project.service;

import com.ypan.form.AddUserForm;
import com.ypan.form.UpdateUserForm;
import com.ypan.project.dto.JDSaveTaskDTO;
import com.ypan.project.query.UserPageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ypan.project.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ypan.vo.UserVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author pan
 * @since 2022-09-21
 */
public interface UserService extends IService<User> {

    /**
     * 新增一个用户
     * @param
     * @return
     */
    Boolean addUser(AddUserForm form);


    /**
     * 修改用户信息
     * @param
     * @return
     */
    Boolean updateUser(UpdateUserForm form);

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    Boolean deleteUserById(Long id);

    /**
     * 分页查询用户列表
     * @param query
     * @return
     */
    Page<UserVO> pageByQuery(UserPageQuery query);

    Boolean testUser(User user);

    User getUser(String name);

    Object test(JDSaveTaskDTO jdSaveTaskDTO);
}
