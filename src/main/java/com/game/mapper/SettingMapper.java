package com.game.mapper;

import com.game.entity.others.SettingEntity;
import com.game.enums.others.SettingTypeEnum;
import com.game.model.admin.others.SettingListModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


/**
 * 系统设置
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:41
 **/
public interface SettingMapper extends Mapper<SettingEntity> {

    /**
     * 查询平台设置
     *
     * @param type
     * @return
     */
    @Select("select value from setting where type=#{type}")
    String getPlatformSetting(@Param("type") SettingTypeEnum type);

    /**
     * 修改平台设置
     *
     * @param type  类型
     * @param value 新的值
     * @return
     */
    @Update("update setting set value=#{value} where type=#{type}")
    int updatePlatformSetting(@Param("type") SettingTypeEnum type, @Param("value") String value);

    /**
     * 平台设置列表
     *
     * @return
     */
    @Select("select * from setting order by id")
    List<SettingListModel> platformSettingList();
}
