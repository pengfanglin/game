package com.game.service.admin;


import com.fanglin.common.core.page.Page;
import com.fanglin.common.core.page.PageResult;
import com.game.model.admin.company.AddCompanyModel;
import com.game.model.admin.company.CompanyIdNameModel;
import com.game.model.admin.company.CompanyListModel;
import com.game.model.admin.member.MemberListModel;
import com.game.model.admin.member.MemberListSearch;

import java.util.List;

/**
 * 后台公司服务
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/4 10:00
 **/
public interface AdminCompanyService {


    /**
     * 会员列表
     *
     * @return
     */
    PageResult<CompanyListModel> companyList(String account, String name, Page page);

    /**
     * 增加会员
     *
     */
    void addCompany(AddCompanyModel addCompany);

    /**
     * 公司id名称搜索
     * @param name 公司名称
     * @return
     */
    List<CompanyIdNameModel> companyIdNameSearch(String name);
}
