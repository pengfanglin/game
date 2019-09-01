package com.game.core.page;


/**
 * 只分页不算总条数
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/2 17:55
 **/
public class RowBounds extends org.apache.ibatis.session.RowBounds {
    public RowBounds(Integer page, Integer limit) {
        super(((page == null ? 1 : page) - 1) * (limit == null ? 10 : limit), limit == null ? 10 : limit);
    }
}
