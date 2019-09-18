package com.game.mapper;

import com.game.entity.role.ModuleEntity;
import com.game.model.admin.role.module.ModuleListModel;
import com.game.model.admin.role.module.ModuleTreeModel;
import com.github.pagehelper.PageRowBounds;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 系统模块
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:44
 **/
public interface ModuleMapper extends Mapper<ModuleEntity> {
    /**
     * 系统模块列表
     *
     * @param parentId 父节点id
     * @param page
     * @return
     */
    @Select("select * from module where parent_id=#{parentId} order by sort desc,id")
    List<ModuleListModel> moduleList(@Param("parentId") Integer parentId, PageRowBounds page);

    /**
     * 模块树
     *
     * @return
     */
    List<ModuleTreeModel> moduleTree();

    /**
     * 系统账号左侧菜单树
     *
     * @param accountId 账号id
     * @return
     */
    List<ModuleTreeModel> leftMenuTree(@Param("accountId") Integer accountId);

    /**
     * 路由是否已经存在
     *
     * @param id  模块id
     * @param url 该模块新的url
     * @return
     */
    @Select("SELECT (CASE WHEN (SELECT COUNT(*) FROM module WHERE id!=#{id} AND url=#{url})=0 THEN FALSE ELSE TRUE END) AS is_exist")
    boolean urlExist(@Param("id") Integer id, @Param("url") String url);
}
