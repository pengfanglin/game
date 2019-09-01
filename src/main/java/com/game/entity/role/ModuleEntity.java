package com.game.entity.role;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 模块实体类
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:43
 **/
@Setter
@Getter
@Accessors(chain = true)
@Table(name = "module")
public class ModuleEntity{
    /**
     * 主键
     */
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    /**
     * 模块名称
     */
    private String name;
    /**
     * 模块访问路径
     */
    private String url;
    /**
     * 父节点id
     */
    private Integer parentId;
    /**
     * 权重
     */
    private Float sort;
    /**
     * 是否禁用
     */
    private Boolean disable;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
}
