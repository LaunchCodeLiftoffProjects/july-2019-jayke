package com.aplaygroundreviewer.aplaygroundreviewer.controllers;

import com.aplaygroundreviewer.aplaygroundreviewer.helpers.UserHelper;
import com.aplaygroundreviewer.aplaygroundreviewer.models.dto.User;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    UserHelper userHelper;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addUserForm(Model model) {
        model.addAttribute("title", "Add new User");
        model.addAttribute(new User());
        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @Valid @ModelAttribute User user, Errors errors, String verify) {

        // check fields not empty
        if (errors.hasErrors()) {
            return "user/add";
        }

        if (!user.getPassword().equals(verify)) {
            user.setEmail(user.getEmail());
            user.setUserName(user.getUserName());
            return "user/add";
        }

        return "redirect:userInfo?username=" + user.getUserName();
    }
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginUserForm(Model model) {
        model.addAttribute(new User());
        return "user/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String loginUser(Model model, @ModelAttribute User user) {
        boolean validCredentials = userHelper.isCredentialsValid(user);
        System.out.println("!!!!!validCredentials = " + validCredentials);
        if (validCredentials) {
            return "user/login";
        } else {
            model.addAttribute("isUserValid", "false");
            return "user/login";
        }
    }





    @RequestMapping(value = "userInfo")
    public String displayUserInfo(Model model, HttpServletRequest request) {

        model.addAttribute("user", request.getParameter("username"));
        model.addAttribute("title", "User Information");
        return "user/userInfo";

    }
}
