package com.game.controller.admin;

import com.fanglin.common.core.others.Ajax;
import com.fanglin.common.core.page.Page;
import com.fanglin.common.core.page.PageResult;
import com.game.controller.common.BaseController;
import com.game.model.admin.company.AddCompanyModel;
import com.game.model.admin.company.CompanyListModel;
import com.game.service.admin.AdminCompanyService;
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
 * 后台-公司
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/19 0:20
 **/
@RestController
@RequestMapping("/admin/company/")
@Api(value = "/admin/company/", tags = {"后台-公司"})
public class AdminCompanyController extends BaseController {
    @Autowired
    AdminCompanyService companyService;

    @ApiOperation("公司列表")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "account", value = "账号"),
        @ApiImplicitParam(name = "name", value = "名称")
    })
    @PostMapping("companyList")
    public Ajax<PageResult<CompanyListModel>> companyList(String account, String name, Page page) {
        return Ajax.ok(companyService.companyList(account, name, page));
    }

    @ApiOperation("增加公司")
    @PostMapping("addCompany")
    public Ajax addCompany(AddCompanyModel addCompany) {
        companyService.addCompany(addCompany);
        return Ajax.ok();
    }

}
