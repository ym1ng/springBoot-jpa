package zym.configuration;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import zym.entity.UserInfo;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFormAuthenticationFilter extends FormAuthenticationFilter
{
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
    {
        if (isLoginRequest(request, response))
        {
            if (isLoginSubmission(request, response))
            {
                //本次用户登陆账号
                String account = this.getUsername(request);

                Subject subject = this.getSubject(request, response);
                //之前登陆的用户
                UserInfo user = (UserInfo) subject.getPrincipal();
                //如果两次登陆的用户不一样，则先退出之前登陆的用户
                if (account != null && user != null && !account.equals(user.getUsername()))
                {
                    subject.logout();
                }
            }
        }

        return super.isAccessAllowed(request, response, mappedValue);
    }
}
