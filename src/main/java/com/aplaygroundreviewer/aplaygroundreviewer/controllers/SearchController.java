package com.aplaygroundreviewer.aplaygroundreviewer.controllers;

import com.aplaygroundreviewer.aplaygroundreviewer.models.Playground;
import com.aplaygroundreviewer.aplaygroundreviewer.models.forms.SearchForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class SearchController {

    static ArrayList<Playground> playgrounds = new ArrayList<>();

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("title", "Welcome to Playground Reviewer");
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

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddPlaygroundForm(Model model) {
        model.addAttribute("title", "Add a Playground Object");
        return "add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddPlaygroundForm(@RequestParam String playgroundName, @RequestParam String playgroundDescription) {
        Playground newPlayground = new Playground(playgroundName, playgroundDescription);
        playgrounds.add(newPlayground);
        return "redirect: ";
    }

}
