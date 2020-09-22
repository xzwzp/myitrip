package cn.itrip.service;

import cn.itrip.itriputils.common.Page;
import cn.itrip.pojo.User;

import java.util.Map;

public interface UserService {
    Page<User>getPageUsers(int pageIndex, String userName);
}
