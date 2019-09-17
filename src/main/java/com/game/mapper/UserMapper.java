package com.game.mapper;

import com.game.entity.user.UserEntity;
import com.game.model.app.user.UserModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
 * 用户
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:36
 **/
public interface UserMapper extends Mapper<UserEntity> {


    /**
     * 用户登录
     *
     * @param mobile 手机号
     * @return
     */
    @Select("select id,password,salt,disable from user where mobile=#{mobile}")
    UserModel login(@Param("mobile") String mobile);
}
