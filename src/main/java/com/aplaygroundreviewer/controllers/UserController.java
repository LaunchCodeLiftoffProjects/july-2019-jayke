package com.aplaygroundreviewer.controllers;

import com.aplaygroundreviewer.models.dto.Role;
import com.aplaygroundreviewer.models.dto.User;
import com.aplaygroundreviewer.security.CustomUserDetailsService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @GetMapping(value = "adduser")
    public String addUserForm(Model model) {
        model.addAttribute("title", "Add new User");
        model.addAttribute(new User());
        return "user/addUser";
    }

    @PostMapping(value = "adduser")
    public String add(Model model, @Valid @ModelAttribute User user, Errors errors, String verify) {

        // check fields not empty
        if (errors.hasErrors()) {
            return "user/addUser";
        }

        if (!user.getPassword().equals(verify)) {
            user.setEmail(user.getEmail());
            user.setUserName(user.getUserName());
            return "user/addUser";
        }
        List<Role> roles = new ArrayList<>();
        roles.add(Role.builder().name("ROLE_ADMIN").id(1).build());
        user.setRoles(roles);
        customUserDetailsService.save(user);
        return "redirect:userInfo?username=" + user.getUserName();
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginUserForm(Model model) {
        return "login";
    }


    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String loginUser(Model model, @ModelAttribute User user) {
//        boolean validCredentials = userHelper.isCredentialsValid(user);
//        System.out.println("!!!!!validCredentials = " + validCredentials);
//        if (validCredentials) {
//            return "user/login";
//        } else {
//            model.addAttribute("isUserValid", "false");
//            return "user/login";
//        }
        return "user/login";
    }


    @RequestMapping(value = "userInfo")
    public String displayUserInfo(Model model, HttpServletRequest request) {

        model.addAttribute("user", request.getParameter("username"));
        model.addAttribute("title", "User Information");
        return "user/userInfo";

    }
}
