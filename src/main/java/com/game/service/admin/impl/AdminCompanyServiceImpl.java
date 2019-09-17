package com.game.service.admin.impl;

import com.fanglin.common.core.others.Assert;
import com.fanglin.common.core.others.BusinessException;
import com.fanglin.common.core.page.Page;
import com.fanglin.common.core.page.PageResult;
import com.fanglin.common.util.BeanUtils;
import com.fanglin.common.util.EncodeUtils;
import com.fanglin.common.util.PageUtils;
import com.fanglin.common.util.ValidatorUtils;
import com.game.entity.company.CompanyEntity;
import com.game.entity.member.MemberEntity;
import com.game.mapper.MapperFactory;
import com.game.model.admin.company.AddCompanyModel;
import com.game.model.admin.company.CompanyListModel;
import com.game.service.admin.AdminCompanyService;
import com.github.pagehelper.PageRowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:36
 **/
@Service
public class AdminCompanyServiceImpl implements AdminCompanyService {

    @Autowired
    MapperFactory mapperFactory;


    @Override
    public PageResult<CompanyListModel> companyList(String account, String name, Page page) {
        PageRowBounds rowBounds = PageUtils.rowBounds(page);
        return new PageResult<>(mapperFactory.company.companyList(account, name, rowBounds), rowBounds.getTotal());
    }

    @Override
    public void addCompany(AddCompanyModel addCompany) {
        ValidatorUtils.validate(addCompany);
        Assert.isTrue(addCompany.getAccount().length() <= 20, "账号最多20个字符");
        Assert.isTrue(addCompany.getPassword().length() <= 20, "密码最多20个字符");
        CompanyEntity company = BeanUtils.copy(addCompany, CompanyEntity.class);
        company.setSalt(UUID.randomUUID().toString().replace("-", ""))
            .setPassword(EncodeUtils.md5Encode(company.getPassword(), company.getSalt()));
        try {
            mapperFactory.company.insertSelective(company);
        } catch (DuplicateKeyException e) {
            throw new BusinessException("账号已存在");
        }
    }
}
