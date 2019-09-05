package com.game.service.admin.impl;

import com.fanglin.common.annotation.RedisCache;
import com.fanglin.common.annotation.RedisCacheRemove;
import com.fanglin.common.core.others.Assert;
import com.fanglin.common.core.page.Page;
import com.fanglin.common.core.page.PageResult;
import com.fanglin.common.core.token.TokenInfo;
import com.fanglin.common.utils.*;
import com.game.core.others.AdminTokenData;
import com.game.entity.role.AccountEntity;
import com.game.entity.role.ModuleEntity;
import com.game.entity.role.RoleEntity;
import com.game.mapper.MapperFactory;
import com.game.model.role.account.AccountListModel;
import com.game.model.role.account.AddAccountModel;
import com.game.model.role.account.UpdateAccountModel;
import com.game.model.role.model.AddModuleModel;
import com.game.model.role.model.ModuleListModel;
import com.game.model.role.model.ModuleTreeModel;
import com.game.model.role.model.UpdateModuleModel;
import com.game.model.role.role.AddRoleModel;
import com.game.model.role.role.RoleListModel;
import com.game.model.role.role.UpdateRoleModel;
import com.game.model.user.UserLoginResultModel;
import com.game.service.admin.AdminRoleService;
import com.github.pagehelper.PageRowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 系统服务实现类
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:44
 **/
@Service
public class AdminRoleServiceImpl implements AdminRoleService {
    @Autowired
    MapperFactory mapperFactory;

    /**
     * 系统模块树
     *
     * @return
     */
    @RedisCache(value = "'module_tree'", timeout = 1, unit = TimeUnit.HOURS)
    @Override
    public List<ModuleTreeModel> moduleTree() {
        return mapperFactory.module.moduleTree(null);
    }

    @Override
    public List<ModuleTreeModel> leftMenuTree(Integer accountId) {
        return mapperFactory.module.moduleTree(accountId);
    }

    @Override
    public PageResult<ModuleListModel> moduleList(Integer parentId, Page page) {
        PageRowBounds rowBounds = PageUtils.rowBounds(page);
        return new PageResult<>(mapperFactory.module.moduleList(parentId == null ? 0 : parentId, rowBounds), rowBounds.getTotal());
    }

    @RedisCacheRemove("'module_tree'")
    @Override
    public void addModule(AddModuleModel module) {
        ValidatorUtils.validate(module);
        Assert.isTrue(mapperFactory.module.selectCount(new ModuleEntity().setUrl(module.getUrl())) == 0, "路由已存在");
        mapperFactory.module.insertSelective(BeanUtils.copy(module, ModuleEntity.class));
    }

    @RedisCacheRemove("'module_tree'")
    @Override
    public void deleteModule(Integer moduleId) {
        int count = mapperFactory.module.deleteByPrimaryKey(moduleId);
        Assert.isTrue(count > 0, "修改失败");
    }

    @RedisCacheRemove("'module_tree'")
    @Override
    public void updateModule(UpdateModuleModel module) {
        ValidatorUtils.validate(module);
        if (OthersUtils.notEmpty(module.getUrl())) {
            Assert.isTrue(mapperFactory.module.selectCount(new ModuleEntity().setUrl(module.getUrl())) == 0, "路由已存在");
        }
        int count = mapperFactory.module.updateByPrimaryKeySelective(BeanUtils.copy(module, ModuleEntity.class));
        Assert.isTrue(count > 0, "修改失败");
    }

    @Override
    public PageResult<RoleListModel> roleList(Page page) {
        PageRowBounds rowBounds = PageUtils.rowBounds(page);
        return new PageResult<>(mapperFactory.role.roleList(rowBounds), rowBounds.getTotal());
    }

    @Override
    public void updateRole(UpdateRoleModel role) {
        ValidatorUtils.validate(role);
        int count = mapperFactory.role.updateByPrimaryKeySelective(BeanUtils.copy(role, RoleEntity.class));
        Assert.isTrue(count > 0, "修改失败");
    }

    @Override
    public void deleteRole(Integer roleId) {
        int count = mapperFactory.role.deleteByPrimaryKey(roleId);
        Assert.isTrue(count > 0, "删除失败");
    }

    @Override
    public void addRole(AddRoleModel role) {
        ValidatorUtils.validate(role);
        mapperFactory.role.insertSelective(BeanUtils.copy(role, RoleEntity.class));
    }

    @Override
    public PageResult<AccountListModel> accountList(String account, Boolean disable, Page page) {
        PageRowBounds rowBounds = PageUtils.rowBounds(page);
        return new PageResult<>(mapperFactory.account.accountList(account, disable, rowBounds), rowBounds.getTotal());
    }

    @Override
    public void updateAccount(UpdateAccountModel account) {
        ValidatorUtils.validate(account);
        if (OthersUtils.notEmpty(account.getAccount())) {
            Assert.isTrue(mapperFactory.account.selectCount(new AccountEntity().setAccount(account.getAccount())) == 0, "账号已存在");
        }
        int count = mapperFactory.account.updateByPrimaryKeySelective(BeanUtils.copy(account, AccountEntity.class));
        Assert.isTrue(count > 0, "修改失败");
    }

    @Override
    public void addAccount(AddAccountModel account) {
        ValidatorUtils.validate(account);
        Assert.isTrue(mapperFactory.account.selectCount(new AccountEntity().setAccount(account.getAccount())) == 0, "账号已存在");
        AccountEntity accountEntity = BeanUtils.copy(account, AccountEntity.class);
        accountEntity
            .setSalt(UUID.randomUUID().toString().replace("-", ""))
            .setPassword(EncodeUtils.md5Encode(account.getPassword(), accountEntity.getSalt()));
        mapperFactory.account.insertSelective(accountEntity);
    }

    @Override
    public void deleteAccount(Integer id) {
        Assert.isTrue(mapperFactory.account.deleteByPrimaryKey(id) > 0, "删除失败");
    }

    @Override
    public UserLoginResultModel login(HttpServletResponse response, String account, String password) {
        AccountEntity accountEntity = mapperFactory.account.login(account);
        Assert.notNull(accountEntity, "用户不存在");
        Assert.isFalse(accountEntity.getDisable(), "账号已冻结");
        Assert.isTrue(EncodeUtils.md5Encode(password, accountEntity.getSalt()).equals(accountEntity.getPassword()), "密码错误");
        AdminTokenData tokenData = new AdminTokenData(accountEntity.getId());
        TokenInfo tokenInfo = new TokenInfo().setData(tokenData).setType("admin").setRefreshTokenTimeout(0);
        TokenUtils.login(response, tokenInfo);
        return new UserLoginResultModel(tokenInfo.getAssessToken(), tokenInfo.getRefreshToken());
    }
}
