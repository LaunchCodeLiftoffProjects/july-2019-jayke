package com.aplaygroundreviewer.controllers;

import com.aplaygroundreviewer.dto.Role;
import com.aplaygroundreviewer.dto.User;
import com.aplaygroundreviewer.dto.SearchForm;
import com.aplaygroundreviewer.repository.UserRepository;
import com.aplaygroundreviewer.security.CustomUserDetailsService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "addUser")
    public String addUserForm(Model model) {
        model.addAttribute("title", "Sign up for STL Playground Finder");
        model.addAttribute(new SearchForm());
        model.addAttribute(new User());
        return "user/addUser";
    }

    @PostMapping(value = "addUser")
    public String add(Model model, @Valid @ModelAttribute User user, Errors errors, String verifyPassword) {
        model.addAttribute(new SearchForm());


        // check fields not empty
        if (errors.hasErrors()) {
            model.addAttribute("user", user);
            return "user/addUser";
        }

        if (!user.getPassword().equals(verifyPassword)) {
            model.addAttribute("user", user);
            model.addAttribute("errormessage",  "Password and verify password doesn't match");
            return "user/addUser";
        }


    //    List<User> userList = userRepository.findByEmail(user.getEmail());

    //    boolean emailExist = userList.contains(user);



        List<Role> roles = new ArrayList<>();
        roles.add(Role.builder().name("ROLE_USER").id(2).build());
        user.setRoles(roles);
        customUserDetailsService.save(user);

        UserDetails userDetails = customUserDetailsService.loadUserByUsername(user.getEmail());
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, user.getPassword(), userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

        return "redirect:/";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginUserForm(Model model) {
        model.addAttribute(new SearchForm());
        model.addAttribute("title", "Login to STL Playground Finder");
        return "login";
    }


    @RequestMapping(value ="admin", method = RequestMethod.GET)
    public String displayAdminPage(Model model) {
        model.addAttribute(new SearchForm());
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("title", "All users");
        return "user/admin";
    }

    @RequestMapping(value ="admin", method = RequestMethod.POST)
    public String processRemoveUsers(@RequestParam int[] userIds) {
        for (int userId : userIds) {
            userRepository.deleteById(userId);
        }
        return "redirect:admin";
    }

    @RequestMapping(value = "userInfo")
    public String displayUserInfo(Model model, HttpServletRequest request) {
        model.addAttribute(new SearchForm());
        model.addAttribute("user", request.getParameter("username"));
        model.addAttribute("title", "User Information");
        return "user/userInfo";

    }
}
