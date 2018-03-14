package zym.Service;

import zym.entity.UserInfo;

public interface UserInfoService {
    public UserInfo findByUsername(String username);
}
