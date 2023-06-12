package edu.ktp.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
public class LogAspect {

    private final static Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(* edu.ktp.controller.*.*(..))")
    public void serviceLog() {
    }

    @After(value = "serviceLog()")
    public void doAfterService(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = (HttpServletRequest) attributes.getRequest();
        SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
        String format = sdf.format(new Date());
        String ip = request.getRemoteAddr();
        String url = request.getRequestURI();
        String methodType = request.getMethod();
        //打印日志
        LOGGER.info("-----------------------------------------------------------------------------------------------------");
        LOGGER.info("时间 = {}", format);
        LOGGER.info("访问url = {}", url);
        LOGGER.info("请求方法类型 = {}", methodType);
        LOGGER.info("来源ip地址 = {}", ip);
        LOGGER.info("调用方法 = {}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        LOGGER.info("-----------------------------------------------------------------------------------------------------");
    }
}
