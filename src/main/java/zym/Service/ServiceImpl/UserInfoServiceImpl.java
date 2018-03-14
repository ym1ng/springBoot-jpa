package zym.Service.ServiceImpl;

import org.springframework.stereotype.Service;
import zym.Repositoty.UserInfoRepository;
import zym.Service.UserInfoService;

import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;
import zym.entity.UserInfo;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoRepository userInfoRepository;

    @Transactional(readOnly=true)
    @Override
    public UserInfo findByUsername(String username) {
        return userInfoRepository.findByUsername(username);
    }

}
