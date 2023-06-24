package edu.ktp.config;

import com.alibaba.druid.util.StringUtils;
import edu.ktp.dao.UserDao;
import edu.ktp.entity.User;
import edu.ktp.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Enumeration;

@Slf4j
@Component // @Component注解一定要加上
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private UserDao userDao;

    // 处理请求之前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getMethod().equals("OPTIONS")) {
            return true;
        }
        // 取出请求头中Authorization的信息，就是token内容，接下来就是各种判断
        String requestToken = request.getHeader("token");
        if(!StringUtils.isEmpty(requestToken)){
            Claims claims = JwtUtil.checkToken(requestToken);
            if (claims != null) {
                // token有效，可以获取用户信息
                String username = (String) claims.get("username"); // 获取用户名
                String password = (String) claims.get("password"); // 获取密码
                User user = userDao.getUser(username);
                if(!password.equals(user.getPassword())){
                    response.setStatus(401);
                    return  false;
                }
                // 这里可以根据你的业务逻辑来判断用户是否有权限访问该资源，比如查询数据库或者缓存等
                // 如果有权限，返回true，否则返回false并设置响应状态码
                return true;
            }
            // token无效或过期
            response.setStatus(401);
            return false;
        }
        // requestToken为空
        response.setStatus(401);
        return false;
    }

    // 处理请求之后执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

}


