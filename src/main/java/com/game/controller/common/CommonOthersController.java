package com.game.controller.common;

import com.fanglin.common.core.others.Ajax;
import com.fanglin.common.util.UploadUtils;
import com.game.enums.others.CodeTypeEnum;
import com.game.enums.others.SettingTypeEnum;
import com.game.model.common.region.RegionTreeModel;
import com.game.service.common.CommonOthersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 其他接口控制器
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:36
 **/
@RestController
@RequestMapping("/common/others/")
@Api(value = "/common/others/", tags = {"公共-其他"})
public class CommonOthersController {

    @Autowired
    CommonOthersService commonOthersService;

    @ApiOperation("上传多个文件")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "files", value = "图片文件", required = true),
        @ApiImplicitParam(name = "path", value = "保存路径", defaultValue = "/files/others")
    })
    @PostMapping("uploadFiles")
    public Ajax uploadFiles(@RequestParam("files") MultipartFile[] files, String path) {
        return UploadUtils.uploadFiles(files, false, path);
    }

    @ApiOperation("发送验证码")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "mobile", value = "手机号", required = true),
        @ApiImplicitParam(name = "type", value = "验证码类型", required = true)
    })
    @PostMapping("sendCode")
    public Ajax sendCode(@RequestParam String mobile, @RequestParam CodeTypeEnum type) {
        commonOthersService.sendCode(mobile, type.toString());
        return Ajax.ok("发送成功");
    }

    @ApiOperation("发送测试验证码")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "mobile", value = "手机号", required = true),
        @ApiImplicitParam(name = "type", value = "验证码类型", required = true)
    })
    @PostMapping("sendCodeTest")
    public Ajax sendCodeTest(@RequestParam String mobile, @RequestParam CodeTypeEnum type) {
        String code = commonOthersService.sendTestCode(mobile, type.toString());
        return Ajax.ok(code);
    }

    @ApiOperation("区域树")
    @PostMapping("regionTree")
    public Ajax<List<RegionTreeModel>> regionTree() {
        return Ajax.ok(commonOthersService.regionTree());
    }

    @ApiOperation("查询平台设置")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "type", value = "PLATFORM_NAME:平台名称 PLATFORM_LOGO:平台logo CONTACT:联系方式 WX_LOGIN:微信登录 ACCOUNT_REGISTER:账号注册", required = true)
    })
    @PostMapping("getPlatformSetting")
    public Ajax getPlatformSetting(@RequestParam SettingTypeEnum type) {
        return Ajax.ok(commonOthersService.getPlatformSetting(type));
    }
}
