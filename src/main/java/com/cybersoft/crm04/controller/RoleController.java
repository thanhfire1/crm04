package com.cybersoft.crm04.controller;

import com.cybersoft.crm04.Entity.Roles;
import com.cybersoft.crm04.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;
    @GetMapping("/add")
   public String add(){
//        Roles roles = new Roles();
//        roles.setName();
//        roles.setDescription();
//
//        roleRepository.save(roles);
   return "role-add";
    }

    @PostMapping("")
    public String processAdd(@RequestParam String roleName , @RequestParam String desc , Model model){
       Roles roles = new Roles();
       roles.setName(roleName);
       roles.setDescription(desc);
        roleRepository.save(roles);
       if(roleName == "" || desc == ""){
           model.addAttribute("tb");
           return "role-add";
       }else{
           model.addAttribute("tb2");
           return "role-add";
       }


    }
}
