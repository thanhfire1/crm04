package com.cybersoft.crm04.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;

@Controller
@RequestMapping("/cookie")
public class DemoCookieController {

    @GetMapping("")
    public String createCookie(HttpServletResponse response , HttpServletRequest request){
//        Cookie cookie = new Cookie("hello", "elacookienek!!!!");
//        Cookie cookie1 = new Cookie("username", URLEncoder.encode("e là cookienek!!!!", StandardCharsets.UTF_8));
//
//        response.addCookie(cookie);
//        response.addCookie(cookie1);
// lấy toàn bộ cookie client truyền lên
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie: cookies) {
           // lấy tên cookie đang duyệt đến
            String name = cookie.getName();
            String value = cookie.getValue();

            if (name.equals("hello") ){

            }
            System.out.println("Kiem Tra name" + name);
            System.out.println("Kiem Tra value" + value);
        }
        return "login";
    }
}
