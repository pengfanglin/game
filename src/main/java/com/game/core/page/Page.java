package com.game.core.page;


import com.github.pagehelper.PageRowBounds;

/**
 * 分页(计算总条数)
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/2 17:55
 **/
public class Page extends PageRowBounds {
    public Page(Integer page, Integer limit) {
        super(((page == null ? 1 : page) - 1) * (limit == null ? 10 : limit), limit == null ? 10 : limit);
    }
}
