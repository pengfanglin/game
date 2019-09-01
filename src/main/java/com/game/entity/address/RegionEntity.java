package com.game.entity.address;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 服务城市
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/8/28 13:06
 **/
@Setter
@Getter
@Accessors(chain = true)
@Table(name = "service_city")
public class RegionEntity {
    /**
     * 地区编码
     */
    @Id
    private Integer code;
    /**
     * 父级地区编码
     */
    private String parentCode;
    /**
     * 地区名称
     */
    private String name;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
}
