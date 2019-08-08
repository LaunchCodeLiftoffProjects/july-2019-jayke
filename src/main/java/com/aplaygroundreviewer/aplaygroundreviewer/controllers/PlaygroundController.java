package com.aplaygroundreviewer.aplaygroundreviewer.controllers;

import com.aplaygroundreviewer.aplaygroundreviewer.models.Playground;
import com.aplaygroundreviewer.aplaygroundreviewer.models.data.PlaygroundDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PlaygroundController {

    @Autowired
    private PlaygroundDao playgroundDao;

    @RequestMapping(value="view/{id}", method = RequestMethod.GET)
    public String viewPlayground(Model model,
                                 @PathVariable int id){
        Playground playground = playgroundDao.findOne(id);
        model.addAttribute("playground", playground);
        model.addAttribute("title", "View a Playground");

        return "view";

    }
}
