package com.aplaygroundreviewer.controllers;

import com.aplaygroundreviewer.dto.Equipment;
import com.aplaygroundreviewer.dto.Playground;
import com.aplaygroundreviewer.dto.PlaygroundInfo;
import com.aplaygroundreviewer.dto.SearchForm;
import com.aplaygroundreviewer.repository.PlaygroundDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private PlaygroundDao playgroundDao;
    private static HashMap<String, String> singleSelectAllValues = new HashMap<>();

    //This functionality will helpful when will take playgrounds list from our db not from google directly
    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute(new SearchForm());
        List<Playground> playgrounds = playgroundDao.findAll();
        List<PlaygroundInfo> list = new ArrayList<>();

        for (int i = 0; i < playgrounds.size(); i++) {
            Playground playground = playgrounds.get(i);
            String url = "http://localhost:8080/list/view/"+playground.getId();
            list.add(PlaygroundInfo.builder().playgroundName(playground.getName()).playgroundAddress(playground.getAddress()).url(url).build());
        }

        model.addAttribute("list", list);

        return "index";
    }

    @RequestMapping(value="search")
    public String search(Model model){
        singleSelectAllValues.put("searchTerm", "Keyword");
        singleSelectAllValues.put("location", "Location");

        model.addAttribute("singleSelectAllValues", singleSelectAllValues);
        String radioButtonSelectedValue;

        model.addAttribute(new SearchForm());
        return "search/search";
    }

    @RequestMapping(value="results")
    public String search(Model model, @ModelAttribute SearchForm searchForm, @RequestParam(value = "searchBy",defaultValue = "searchTerm", required=false) String searchBy) {
        model.addAttribute("aname", searchForm.getName());
        //Search term
        if (searchBy.equals("searchTerm")) {
            model.addAttribute("anotherlistmodel", playgroundDao.findByNameContainingOrDescriptionContaining
                                                                         (searchForm.getName(), searchForm.getName()));
        }
        //location
        else if (searchBy.equals("location")) {
            model.addAttribute("location", searchForm.getName());
        }
        return "search/search-results";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddPlaygroundForm(Model model) {
        model.addAttribute("title", "Add a Playground");
        model.addAttribute(new SearchForm());
        model.addAttribute(new Playground());
        return "playground/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddPlaygroundForm(@ModelAttribute @Valid Playground newPlayground, Errors errors, Model model) {
        if (errors.hasErrors()) {
            Playground playground = newPlayground;
            model.addAttribute(new SearchForm());
            model.addAttribute("title", "Add Playground");
            return "playground/add";
        }
        playgroundDao.save(newPlayground);
        return "redirect:/view/" + newPlayground.getId();
    }


    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemovePlaygroundForm(Model model) {
        model.addAttribute(new SearchForm());
        model.addAttribute("playgrounds", playgroundDao.findAll());
        model.addAttribute("title", "Remove Playground(s)");
        return "playground/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemovePlaygroundForm(@RequestParam int[] playgroundIds) {
        for (int playgroundId : playgroundIds) {
            playgroundDao.deleteById(playgroundId);
        }
        return "redirect:playground/remove";
    }


    //Viewing a Playground's details by ID in URL
    @RequestMapping(value="view/{id}", method = RequestMethod.GET)
    public String viewPlayground(Model model,
                                 @PathVariable int id){
        Playground playground = playgroundDao.findOneById(id);
        model.addAttribute(new SearchForm());
        model.addAttribute("playground", playground);
        model.addAttribute("title", "View a Playground");

        return "playground/view";
    }

    //Returns all playgrounds
    @RequestMapping(value="list")
    public String listPlayground(Model model){
        model.addAttribute(new SearchForm());
        model.addAttribute("playgrounds", playgroundDao.findAll());
        model.addAttribute("title", "All Playgrounds");
        return "playground/list";
    }

    //Edit Playground
    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String displayEditPlayground(Model model, @PathVariable int id) {
        Playground playground = playgroundDao.findOneById(id);
        model.addAttribute(new SearchForm());
        model.addAttribute("playground", playground);

        return "playground/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String processEditPlayground(int id, @ModelAttribute @Valid Playground playground, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute(new SearchForm());
            model.addAttribute("title", "Edit Playground");
            return "playground/edit";
        }

        Playground editPlayground = playgroundDao.findOneById(id);
        editPlayground.setName(playground.getName());
        editPlayground.setAddress(playground.getAddress());
        editPlayground.setDescription(playground.getDescription());
        editPlayground.setWaterFeature(playground.getWaterFeature());
        editPlayground.setEquipment(playground.getEquipment());
        editPlayground.setAmenities(playground.getAmenities());
        editPlayground.setAccessibility(playground.getAccessibility());
        editPlayground.setShelters(playground.getShelters());
        editPlayground.setSpecialNeeds(playground.getSpecialNeeds());

        playgroundDao.save(editPlayground);

        return "redirect:/view/" + editPlayground.getId();
    }

}
