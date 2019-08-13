package com.aplaygroundreviewer.aplaygroundreviewer.controllers;

import com.aplaygroundreviewer.aplaygroundreviewer.models.Playground;
import com.aplaygroundreviewer.aplaygroundreviewer.models.data.PlaygroundDao;
import com.aplaygroundreviewer.aplaygroundreviewer.models.forms.SearchForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private PlaygroundDao playgroundDao;

    static ArrayList<Playground> playgrounds = new ArrayList<>();

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("title", "Welcome to STL Playgrounds Finder");
        model.addAttribute(new SearchForm());
        //model.addAttribute("playgrounds", playgrounds);
        model.addAttribute("playgrounds", playgroundDao.findAll());
        //List<Playground> alist = playgroundDao.findByName("burp");
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
        //List<Playground> anotherlist = playgroundDao.findByName(name);
        model.addAttribute("anotherlistmodel",playgroundDao.findByNameOrDescriptionContaining(name, name));
        return "search-results"; //SUCCESSS!!!!!!
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddPlaygroundForm(Model model) {
        model.addAttribute("title", "Add a Playground Object");
        model.addAttribute(new Playground());
        return "add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddPlaygroundForm(@ModelAttribute @Valid Playground newPlayground, Errors errors, Model model) {
        //Playground newPlayground = new Playground(playgroundName, playgroundDescription);
        //playgrounds.add(newPlayground);

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Playground");
            return "add";
        }

        playgroundDao.save(newPlayground);
        return "redirect:";
    }


    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemovePlaygroundForm(Model model) {
        model.addAttribute("playgrounds", playgroundDao.findAll());
        model.addAttribute("title", "Remove Playground");
        return "remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemovePlaygroundForm(@RequestParam int[] playgroundIds) {

        for (int playgroundId : playgroundIds) {
            playgroundDao.delete(playgroundId);
        }

        return "redirect:";
    }

}
