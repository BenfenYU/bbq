package com.funtl.oauth2.server.service;

import com.funtl.oauth2.common.BaseResult;

public interface CommonService {
    public BaseResult register(String userAccount, String userPassword, String userName, String userEmail);
    public BaseResult getPermissions(Integer offset,Integer limit);
    public BaseResult getRoles(Integer offset,Integer limit);
    public BaseResult whichRole(String userAccount);
    public BaseResult updateRole(String userAccount);
}
