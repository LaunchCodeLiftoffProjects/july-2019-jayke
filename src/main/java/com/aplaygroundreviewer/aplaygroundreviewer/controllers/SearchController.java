package com.aplaygroundreviewer.aplaygroundreviewer.controllers;

import com.aplaygroundreviewer.aplaygroundreviewer.models.forms.SearchForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SearchController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("title", "Welcome to STL Playgrounds Finder");
        model.addAttribute(new SearchForm());
        return "index";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String index(Model model, SearchForm searchForm) {
        String name = searchForm.getName();

        return "redirect:/search?term=" + name;
    }

    @RequestMapping(value = "search", method = RequestMethod.GET)
    //public String displaySearch(Model model, String name)
    public String displaySearch(Model model, HttpServletRequest request) {
        //model.addAttribute("aname", name);
        String name = request.getParameter("term");
        model.addAttribute("aname", name);
        return "search-results"; //SUCCESSS!!!!!!
    }
}
