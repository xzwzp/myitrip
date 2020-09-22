package cn.itrip.service.Impl;

import cn.itrip.dao.UserMapper;
import cn.itrip.itriputils.common.Page;
import cn.itrip.pojo.User;
import cn.itrip.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;


    @Override
    public Page<User> getPageUsers(int pageIndex, String userName) {

        int pageSize=5;
        Map<String,Object>params=new HashMap<>();
        params.put("userName",userName);
        params.put("from",(pageIndex-1)*pageSize);
        params.put("limit",pageSize);

        List<User> users = userMapper.getUsersByParams(params);
        int totalCount = userMapper.getUserCountByParams(params);
        Page<User>pagedUsers=new Page<>(pageIndex,pageSize,totalCount,users);
        return pagedUsers;
    }
}
