package com.game.controller.admin;

import com.fanglin.common.annotation.Token;
import com.fanglin.common.core.others.Ajax;
import com.fanglin.common.util.UploadUtils;
import com.game.core.others.AppTokenData;
import com.game.enums.others.AuthCodeTypeEnum;
import com.game.enums.others.CodeTypeEnum;
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

/**
 * 其他接口控制器
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:36
 **/
@RestController
@RequestMapping("/admin/others/")
@Token("admin")
@Api(value = "/admin/others/", tags = {"后台-其他"})
public class AdminOthersController {

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

    @ApiOperation("发送鉴权验证码")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "type", value = "验证码类型", required = true)
    })
    @PostMapping("sendAuthCode")
    public Ajax sendCode(AppTokenData tokenData, @RequestParam AuthCodeTypeEnum type) {
        commonOthersService.sendCode(tokenData.getMobile(), type.toString());
        return Ajax.ok("发送成功");
    }

    @ApiOperation("发送测试鉴权验证码")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "type", value = "验证码类型", required = true)
    })
    @PostMapping("sendAuthCodeTest")
    public Ajax sendAuthCodeTest(AppTokenData tokenData, @RequestParam AuthCodeTypeEnum type) {
        String code = commonOthersService.sendTestCode(tokenData.getMobile(), type.toString());
        return Ajax.ok(code);
    }
}
