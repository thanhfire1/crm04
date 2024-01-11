package com.cybersoft.crm04.controller;

import com.cybersoft.crm04.Entity.Roles;
import com.cybersoft.crm04.Entity.Users;
import com.cybersoft.crm04.Repository.UsersRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.SQLOutput;
import java.util.List;

@Controller
@RequestMapping("")
public class LoginCotroller {
    /*các bước:
    * bươc 1: Phân tích yêu cầu chức năng
    * bước 2: Xác định câu truy vấn dành cho chức năng đó (câu query)
    * bước 3: từ câu truy vấn sẽ xác định được đường dẫn mik có nhận tham số hay ko và số lượng tham số là bao nhiu
    * bước 4: */
@Autowired
private UsersRepository usersRepository;

    @GetMapping("/login")
    public String login(HttpServletResponse response , HttpServletRequest request , Model model){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie: cookies) {
            // lấy tên cookie đang duyệt đến

            if (cookie.getName().equals("email")) {
                model.addAttribute("email", cookie.getValue());
            }
            if (cookie.getName().equals("password")) {
                model.addAttribute("password", cookie.getValue());
            }
        }
        return "login";
    }

    @PostMapping("/index")
    public String processLogin(@RequestParam String email, @RequestParam String password, Model model, HttpServletResponse response, HttpServletRequest request, HttpSession httpSession ,boolean remember) {
        // Thực hiện kiểm tra đăng nhập ở đây
        List<Users> userList = usersRepository.findByEmailAndPassword(email, password);
        Roles roles;

        Cookie cookie;
        Cookie cookie1;
        if (userList != null && !userList.isEmpty()) {
            // Đăng nhập thành công

            cookie = new Cookie("email", email);
            cookie1 = new Cookie("password", password);

            response.addCookie(cookie);
            response.addCookie(cookie1);
            return "index";
        } else {
            // Đăng nhập thất bại
            model.addAttribute("error", "Invalid email or password");
            return "login";
        }

        if (cookie != null && cookie1 !=null){

            return "index";
        }
    }
}
