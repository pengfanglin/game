package com.game.mapper;

import com.game.core.page.Page;
import com.game.entity.role.RoleEntity;
import com.game.model.role.role.RoleListModel;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 角色
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:39
 **/
public interface RoleMapper extends Mapper<RoleEntity> {

    /**
     * 角色列表
     *
     * @param page
     * @return
     */
    @Select("select id,name,disable,sort,create_time,module_ids from role order by id")
    List<RoleListModel> roleList(Page page);
}
