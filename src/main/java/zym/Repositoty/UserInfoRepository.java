package zym.Repositoty;

import org.springframework.data.repository.CrudRepository;
import zym.entity.UserInfo;

/**
 * UserInfo持久化类
 *
 * @author Administrator
 *
 */
public interface UserInfoRepository extends CrudRepository<UserInfo, Long> {
    /** 通过username查找用户信息 **/
    public UserInfo findByUsername(String username);

}