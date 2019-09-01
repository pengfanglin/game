package com.game.mapper;

import com.game.entity.address.RegionEntity;
import com.game.model.region.RegionTreeModel;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 区域
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:36
 **/
public interface RegionMapper extends Mapper<RegionEntity> {

    /**
     * 区域树
     *
     * @return
     */
    List<RegionTreeModel> regionTree();

    /**
     * 行业分类缓存
     *
     * @return
     */
    @Select("select code,name from region")
    List<Map<String, Object>> regionCache();
}
