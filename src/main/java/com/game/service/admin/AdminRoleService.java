package com.game.service.admin;

import com.fanglin.common.core.page.Page;
import com.fanglin.common.core.page.PageResult;
import com.game.model.admin.role.account.AccountListModel;
import com.game.model.admin.role.account.AddAccountModel;
import com.game.model.admin.role.account.UpdateAccountModel;
import com.game.model.admin.role.module.AddModuleModel;
import com.game.model.admin.role.module.ModuleListModel;
import com.game.model.admin.role.module.ModuleTreeModel;
import com.game.model.admin.role.module.UpdateModuleModel;
import com.game.model.admin.role.role.AddRoleModel;
import com.game.model.admin.role.role.RoleListModel;
import com.game.model.admin.role.role.UpdateRoleModel;
import com.game.model.app.member.MemberLoginResultModel;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/4 10:00
 **/
public interface AdminRoleService {
    /**
     * 系统模块树
     *
     * @return
     */
    List<ModuleTreeModel> moduleTree();

    /**
     * 系统账号左侧菜单树
     *
     * @param id 账号id
     * @return
     */
    List<ModuleTreeModel> leftMenuTree(Integer id);

    /**
     * 获取系统模块列表
     *
     * @param module
     * @param page
     * @return
     */
    PageResult<ModuleListModel> moduleList(Integer parentId, Page page);

    /**
     * 添加系统模块
     *
     * @param module
     */
    void addModule(AddModuleModel module);

    /**
     * 删除系统模块
     *
     * @param id
     */
    void deleteModule(Integer id);

    /**
     * 修改系统模块
     *
     * @param module
     */
    void updateModule(UpdateModuleModel module);

    /**
     * 角色列表
     *
     * @param page
     * @return
     */
    PageResult<RoleListModel> roleList(Page page);

    /**
     * 修改角色信息
     *
     * @param role
     */
    void updateRole(UpdateRoleModel role);

    /**
     * 删除角色
     *
     * @param id
     */
    void deleteRole(Integer id);

    /**
     * 添加角色信息
     *
     * @param role
     */
    void addRole(AddRoleModel role);

    /**
     * 系统账号列表
     *
     * @param account 账号
     * @param disable 是否禁用
     * @param page    分页
     * @return
     */
    PageResult<AccountListModel> accountList(String account, Boolean disable, Page page);

    /**
     * 修改系统账号
     *
     * @param account 系统账号
     */
    void updateAccount(UpdateAccountModel account);

    /**
     * 添加系统账号
     *
     * @param account 账号
     */
    void addAccount(AddAccountModel account);

    /**
     * 删除系统账号
     *
     * @param id 账号id
     */
    void deleteAccount(Integer id);

    /**
     * 登录
     *
     * @param response
     * @param account  账号
     * @param password 密码
     * @return
     */
    MemberLoginResultModel login(HttpServletResponse response, String account, String password);
}
