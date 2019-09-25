package com.game.mapper;

import com.game.entity.company.CompanyEntity;
import com.game.entity.role.AccountEntity;
import com.game.model.admin.company.CompanyIdNameModel;
import com.game.model.admin.company.CompanyListModel;
import com.game.model.admin.role.account.AccountListModel;
import com.github.pagehelper.PageRowBounds;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 公司
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:41
 **/
public interface CompanyMapper extends Mapper<CompanyEntity> {

    /**
     * 登录
     *
     * @param account 账号
     * @return
     */
    @Select("select id,password,salt,disable from company where account=#{account}")
    AccountEntity login(@Param("account") String account);

    /**
     * 公司列表
     *
     * @param account   账号
     * @param name      名称
     * @param rowBounds
     * @return
     */
    List<CompanyListModel> companyList(@Param("account") String account, @Param("name") String name, PageRowBounds rowBounds);

    /**
     * 公司id名称搜索
     *
     * @param name 公司名称
     * @return
     */
    List<CompanyIdNameModel> companyIdNameSearch(@Param("name") String name);
}
