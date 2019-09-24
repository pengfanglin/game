package com.game.controller.admin;

import com.fanglin.common.annotation.Token;
import com.fanglin.common.core.others.Ajax;
import com.fanglin.common.core.page.Page;
import com.fanglin.common.core.page.PageResult;
import com.game.controller.common.BaseController;
import com.game.model.admin.member.MemberListModel;
import com.game.model.admin.member.MemberListSearch;
import com.game.service.admin.AdminMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 会员
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/19 0:20
 **/
@RestController
@RequestMapping("/admin/member/")
@Api(value = "/admin/member/", tags = {"后台-会员"})
@Token("admin")
public class AdminMemberController extends BaseController {
    @Autowired
    AdminMemberService memberService;

    @ApiOperation("会员列表")
    @PostMapping("memberList")
    public Ajax<PageResult<MemberListModel>> memberList(MemberListSearch search, Page page) {
        return Ajax.ok(memberService.memberList(search, page));
    }

    @ApiOperation("增加会员")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "account", value = "账号", required = true),
        @ApiImplicitParam(name = "password", value = "密码", required = true)
    })
    @PostMapping("addMember")
    public Ajax addMember(@RequestParam String account, @RequestParam String password) {
        memberService.addMember(account, password);
        return Ajax.ok();
    }

    @ApiOperation("删除会员")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "会员id", required = true)
    })
    @PostMapping("deleteMember")
    public Ajax deleteMember(@RequestParam Integer id) {
        memberService.deleteMember(id);
        return Ajax.ok();
    }

    @ApiOperation("充值")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "memberId", value = "会员id", required = true),
        @ApiImplicitParam(name = "value", value = "充值金额", required = true)
    })
    @PostMapping("topUp")
    public Ajax topUp(@RequestParam Integer memberId, @RequestParam Float value) {
        memberService.topUp(memberId,value);
        return Ajax.ok();
    }
}
