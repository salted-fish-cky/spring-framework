package com.spring.mvc.init;

import com.spring.mvc.config.AppConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebApplicationInitializer implements WebApplicationInitializer {


    //0配置原理
    //servlet 3.0 SPI规范
    //AppConfig
    //内嵌Tomcat
    //自己实现SPI..
    // 为什么 spring boot  能解析 非 web app 目录下的资源


    //实现0xml
    //写一个类 实现spring 的接口：WebApplicationInitializer


    //tomcat 启动的时候会调用 onStartup方法 为什么？

    //传入一个ServletContext ： web上下文对象   web.xml能做的 ServletContext都能做
    //因为servlet 3.0的一个新规范   为什么不是tomcat规范而是servlet规范
    //SPI “你”
    @Override
    public void onStartup(ServletContext servletCxt) {
        //初始化spring 容器  以注解的方式
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        ac.register(AppConfig.class);
//        ac.setServletContext(servletCxt);
//        ac.refresh();
        DispatcherServlet servlet = new DispatcherServlet(ac);
        ServletRegistration.Dynamic registration = servletCxt.addServlet("app", servlet);
        registration.setLoadOnStartup(1);
//        registration.setInitParameter("contextConfigLocation","spring mvc.xml 的地址");
        registration.addMapping("/*");
		System.out.println("调用onStartup");
}
}