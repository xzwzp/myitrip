package cn.itrip.dao;

import cn.itrip.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User>getUsersByParams(Map<String,Object>params);

    int getUserCountByParams(Map<String,Object>params);
}
