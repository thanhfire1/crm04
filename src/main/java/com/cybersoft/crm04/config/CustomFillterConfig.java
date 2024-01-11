package com.cybersoft.crm04.config;



import com.cybersoft.crm04.filter.CustomFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.RegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomFillterConfig {
    // Khai báo thông tin cấu hình cho filter.
    @Bean
    public FilterRegistrationBean<CustomFilter> filterConfig(){
        FilterRegistrationBean<CustomFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new CustomFilter());
//      link Liên quan đến set quyền.
        registrationBean.addUrlPatterns("/login");   // Khi người dùng gọi link là /role mới kích hoạt filter.
        registrationBean.setOrder(1);

        return registrationBean;
    }


//    @Bean
//    public FilterRegistrationBean<CustomFilter> filterConfig(){
//        FilterRegistrationBean<CustomFilter> registrationBean = new FilterRegistrationBean<>();
//        registrationBean.setFilter(new CustomFilter());
////      link Liên quan đến set quyền.
//        registrationBean.addUrlPatterns("/role");   // Khi người dùng gọi link là /role mới kích hoạt filter.
//        registrationBean.setOrder(2);
//        return registrationBean;
//    }
}
/*
1. Nếu như đã đăng nhập rồi thì không cần đăng nhập lại đá về trang chủ không cho vô trang đăng nhập lại.
    - B1: Khi đăng nhập thành công thì phải lưu lại thông tin user đã đăng nhập (Session/Cookie).
    - B2: Khi người dùng vào lại trang login thì kiểm tra xem Session/Cookie lưu trữ thông tin người dùng có đang tồn tại không.
    - B3: Nếu tồn tại, Chuyển hướng về trang chủ.
    - B4: Nếu không tồn tại thì cho đi vào trang login.

*2. Hãy làm tính năng phân quyền cho hệ thống CRM:
*   - ADMIN: thêm,xóa, sửa ROLE
*
*
*
* */

