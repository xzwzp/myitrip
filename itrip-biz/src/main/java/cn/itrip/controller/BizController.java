package cn.itrip.controller;

import cn.itrip.dto.Dto;
import cn.itrip.itriputils.common.DtoUtil;
import cn.itrip.itriputils.common.Page;
import cn.itrip.pojo.User;
import cn.itrip.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BizController {
    @Resource
    UserService userService;

    @RequestMapping("/display")
    public Dto display(
            @RequestParam(value = "page",required = true,defaultValue = "1")int pageIndex,
            @RequestParam(value = "userName",required = false)String userName){
        Page<User> pagedUsers = userService.getPageUsers(pageIndex, userName);
        return DtoUtil.returnDataSuccess(pagedUsers);
    }
}
