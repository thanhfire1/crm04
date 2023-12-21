package com.cybersoft.crm04.controller;

import com.cybersoft.crm04.Entity.Users;
import com.cybersoft.crm04.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.sql.SQLOutput;
import java.util.List;

@Controller
@RequestMapping("*")
public class LoginCotroller {
    /*các bước:
    * bươc 1: Phân tích yêu cầu chức năng
    * bước 2: Xác định câu truy vấn dành cho chức năng đó (câu query)
    * bước 3: từ câu truy vấn sẽ xác định được đường dẫn mik có nhận tham số hay ko và số lượng tham số là bao nhiu
    * bước 4: */
@Autowired
private UsersRepository usersRepository;

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @PostMapping("/index")
    public String processLogin(@RequestParam String email, @RequestParam String password, Model model) {
        // Thực hiện kiểm tra đăng nhập ở đây
        List<Users> userList = usersRepository.findByEmailAndPassword(email, password);

        if (userList != null && !userList.isEmpty()) {
            // Đăng nhập thành công
            return "index";
        } else {
            // Đăng nhập thất bại
            model.addAttribute("error", "Invalid email or password");
            return "login";
        }
    }
}
