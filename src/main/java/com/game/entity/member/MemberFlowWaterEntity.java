package com.game.entity.member;

import com.game.enums.member.MemberFlowWaterTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 会员流水
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/8/28 13:06
 **/
@Setter
@Getter
@Accessors(chain = true)
@Table(name = "member_flow_water")
public class MemberFlowWaterEntity {
    /**
     * 主键
     */
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    /**
     * 账号
     */
    private Integer member_id;
    /**
     * 手机号
     */
    private MemberFlowWaterTypeEnum type;
    /**
     * 密码
     */
    private BigDecimal value;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
}
