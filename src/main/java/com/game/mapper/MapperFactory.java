package com.game.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 通用mapper的总仓库
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:34
 **/
@Component
public class MapperFactory {
    @Autowired
    public OthersMapper others;
    @Autowired
    public MemberMapper member;
    @Autowired
    public RegionMapper region;
    @Autowired
    public AccountMapper account;
    @Autowired
    public ModuleMapper module;
    @Autowired
    public RoleMapper role;
    @Autowired
    public SettingMapper setting;
    @Autowired
    public CompanyMapper company;
}
