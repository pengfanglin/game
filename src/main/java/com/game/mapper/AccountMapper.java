package com.game.mapper;

import com.game.entity.role.AccountEntity;
import com.game.model.role.account.AccountListModel;
import com.github.pagehelper.PageRowBounds;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 系统账号
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:41
 **/
public interface AccountMapper extends Mapper<AccountEntity> {

    /**
     * 用户登录
     *
     * @param account 账号
     * @return
     */
    @Select("select id,password,salt,disable from admin_account where account=#{account}")
    AccountEntity login(@Param("account") String account);

    /**
     * 系统账号列表
     *
     * @param account 账号
     * @param disable 是否禁用
     * @param page    分页
     * @return
     */
    List<AccountListModel> accountList(@Param("account") String account, @Param("disable") Boolean disable, PageRowBounds page);
}
