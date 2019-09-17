package com.aplaygroundreviewer.controllers;

import com.aplaygroundreviewer.dto.*;
import com.aplaygroundreviewer.repository.PlaygroundDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "searchbylists")
public class ListController {

    @Autowired
    private PlaygroundDao playgroundDao;

    /*
    @RequestMapping(value="")
    public String (Model model) {
        model.addAttribute(new SearchForm());
        return "searchbylists/";
    }
    */

    @RequestMapping(value="")
    public String index(Model model) {
        model.addAttribute(new SearchForm());
        return "searchbylists/index";
    }

    //List by Accessibility fields

        //Parking Lot
    @RequestMapping(value = "parking-lot")
    public String parkingLot(Model model) {
        model.addAttribute(new SearchForm());
        List<Playground> allPlaygrounds = playgroundDao.findAll();
        List<Playground> targetedPlaygrounds = new ArrayList<>();
        for (Playground playground : allPlaygrounds) {
            Accessibility accessibility = playground.getAccessibility();
            if (accessibility.isParkingLot()) {
                targetedPlaygrounds.add(playground);
            } else {
                continue;
            }
        }
        model.addAttribute("playgrounds",targetedPlaygrounds);
        return "searchbylists/listbyfields";
    }

        //Trail
    @RequestMapping(value = "trail")
    public String trail(Model model) {
        model.addAttribute(new SearchForm());
        List<Playground> allPlaygrounds = playgroundDao.findAll();
        List<Playground> targetedPlaygrounds = new ArrayList<>();
        for (Playground playground : allPlaygrounds) {
            Accessibility accessibility = playground.getAccessibility();
            if (accessibility.isTrail()) {
                targetedPlaygrounds.add(playground);
            } else {
                continue;
            }
        }
        model.addAttribute("playgrounds",targetedPlaygrounds);
        return "searchbylists/listbyfields";
    }


    //List by Amenities fields

        //Restroom Changing Station
    @RequestMapping(value = "restroom-changing-station")
    public String restroomChangingStation(Model model) {
        model.addAttribute(new SearchForm());
        List<Playground> allPlaygrounds = playgroundDao.findAll();
        List<Playground> targetedPlaygrounds = new ArrayList<>();
        for (Playground playground : allPlaygrounds) {
            Amenities amenities = playground.getAmenities();
            if (amenities.isRestroomChangingStation()) {
                targetedPlaygrounds.add(playground);
            } else {
                continue;
            }
        }
        model.addAttribute("playgrounds",targetedPlaygrounds);
        return "searchbylists/listbyfields";
    }


        //Water Fountain
    @RequestMapping(value = "water-fountain")
    public String waterFountain(Model model) {
        model.addAttribute(new SearchForm());
        List<Playground> allPlaygrounds = playgroundDao.findAll();
        List<Playground> targetedPlaygrounds = new ArrayList<>();
        for (Playground playground : allPlaygrounds) {
            Amenities amenities = playground.getAmenities();
            if (amenities.isWaterFountain()) {
                targetedPlaygrounds.add(playground);
            } else {
                continue;
            }
        }
        model.addAttribute("playgrounds",targetedPlaygrounds);
        return "searchbylists/listbyfields";
    }

    //List by Equipment fields

        //Climbing Walls
    @RequestMapping(value = "climbing-walls")
    public String climbingwalls(Model model) {
        model.addAttribute(new SearchForm());
        List<Playground> allPlaygrounds = playgroundDao.findAll();
        List<Playground> targetedPlaygrounds = new ArrayList<>();
        for (Playground playground : allPlaygrounds) {
            Equipment equipment = playground.getEquipment();
            if (equipment.isClimbingWalls()) {
                targetedPlaygrounds.add(playground);
            } else {
                continue;
            }
        }
        model.addAttribute("playgrounds",targetedPlaygrounds);
        return "searchbylists/listbyfields";
    }

        //Ladders
    @RequestMapping(value = "ladders")
    public String ladders(Model model) {
        model.addAttribute(new SearchForm());
        List<Playground> allPlaygrounds = playgroundDao.findAll();
        List<Playground> targetedPlaygrounds = new ArrayList<>();
        for (Playground playground : allPlaygrounds) {
            Equipment equipment = playground.getEquipment();
            if (equipment.isLadders()) {
                //System.out.println("Yes ladder");
                targetedPlaygrounds.add(playground);
            } else {
                //System.out.println("No ladder");
                continue;
            }
        }
        model.addAttribute("playgrounds",targetedPlaygrounds);
        return "searchbylists/listbyfields";
    }

        //Seesaw
    @RequestMapping(value = "seesaw")
    public String seesaw(Model model) {
        model.addAttribute(new SearchForm());
        List<Playground> allPlaygrounds = playgroundDao.findAll();
        List<Playground> targetedPlaygrounds = new ArrayList<>();
        for (Playground playground : allPlaygrounds) {
            Equipment equipment = playground.getEquipment();
            if (equipment.isSeesaw()) {
                targetedPlaygrounds.add(playground);
            } else {
                continue;
            }
        }
        model.addAttribute("playgrounds",targetedPlaygrounds);
        return "searchbylists/listbyfields";
    }


        //Slides
    @RequestMapping(value = "slides")
    public String slides(Model model) {
        model.addAttribute(new SearchForm());
        List<Playground> allPlaygrounds = playgroundDao.findAll();
        List<Playground> targetedPlaygrounds = new ArrayList<>();
        for (Playground playground : allPlaygrounds) {
            Equipment equipment = playground.getEquipment();
            if (equipment.isSlides()) {
                targetedPlaygrounds.add(playground);
            } else {
                continue;
            }
        }
        model.addAttribute("playgrounds",targetedPlaygrounds);
        return "searchbylists/listbyfields";
    }


        //Structures
    @RequestMapping(value = "structures")
    public String structures(Model model) {
        model.addAttribute(new SearchForm());
        List<Playground> allPlaygrounds = playgroundDao.findAll();
        List<Playground> targetedPlaygrounds = new ArrayList<>();
        for (Playground playground : allPlaygrounds) {
            Equipment equipment = playground.getEquipment();
            if (equipment.isStructures()) {
                targetedPlaygrounds.add(playground);
            } else {
                continue;
            }
        }
        model.addAttribute("playgrounds",targetedPlaygrounds);
        return "searchbylists/listbyfields";
    }


        //Swings
    @RequestMapping(value = "swings")
    public String swings(Model model) {
        model.addAttribute(new SearchForm());
        List<Playground> allPlaygrounds = playgroundDao.findAll();
        List<Playground> targetedPlaygrounds = new ArrayList<>();
        for (Playground playground : allPlaygrounds) {
            Equipment equipment = playground.getEquipment();
            if (equipment.isSwings()) {
                targetedPlaygrounds.add(playground);
            } else {
                continue;
            }
        }
        model.addAttribute("playgrounds",targetedPlaygrounds);
        return "searchbylists/listbyfields";
    }



    //List by Shelters fields

        //Benches
    @RequestMapping(value = "benches")
    public String benches(Model model) {
        model.addAttribute(new SearchForm());
        List<Playground> allPlaygrounds = playgroundDao.findAll();
        List<Playground> targetedPlaygrounds = new ArrayList<>();
        for (Playground playground : allPlaygrounds) {
            Shelters shelters = playground.getShelters();
            if (shelters.isBenches()) {
                targetedPlaygrounds.add(playground);
            } else {
                continue;
            }
        }
        model.addAttribute("playgrounds",targetedPlaygrounds);
        return "searchbylists/listbyfields";
    }

        //Pavillion
    @RequestMapping(value = "pavillion")
    public String pavillion(Model model) {
        model.addAttribute(new SearchForm());
        List<Playground> allPlaygrounds = playgroundDao.findAll();
        List<Playground> targetedPlaygrounds = new ArrayList<>();
        for (Playground playground : allPlaygrounds) {
            Shelters shelters = playground.getShelters();
            if (shelters.isPavillion()) {
                targetedPlaygrounds.add(playground);
            } else {
                continue;
            }
        }
        model.addAttribute("playgrounds",targetedPlaygrounds);
        return "searchbylists/listbyfields";
    }

    //List by Special Needs

        //Sensory
    @RequestMapping(value = "sensory")
    public String sensory(Model model) {
        model.addAttribute(new SearchForm());
        List<Playground> allPlaygrounds = playgroundDao.findAll();
        List<Playground> targetedPlaygrounds = new ArrayList<>();
        for (Playground playground : allPlaygrounds) {
            SpecialNeeds specialNeeds = playground.getSpecialNeeds();
            if (specialNeeds.isSensory()) {
                targetedPlaygrounds.add(playground);
            } else {
                continue;
            }
        }
        model.addAttribute("playgrounds",targetedPlaygrounds);
        return "searchbylists/listbyfields";
    }

        //Wheelchair Accessible
    @RequestMapping(value = "wheelchair-accessible")
    public String wheelchairAccessible(Model model) {
        model.addAttribute(new SearchForm());
        List<Playground> allPlaygrounds = playgroundDao.findAll();
        List<Playground> targetedPlaygrounds = new ArrayList<>();
        for (Playground playground : allPlaygrounds) {
            SpecialNeeds specialNeeds = playground.getSpecialNeeds();
            if (specialNeeds.isWheelchairAccessible()) {
                targetedPlaygrounds.add(playground);
            } else {
                continue;
            }
        }
        model.addAttribute("playgrounds",targetedPlaygrounds);
        return "searchbylists/listbyfields";
    }

    //List by Water Feature field
    @RequestMapping(value = "water-feature")
    public String waterFeature(Model model) {
        model.addAttribute(new SearchForm());
        List<Playground> allPlaygrounds = playgroundDao.findAll();
        List<Playground> targetedPlaygrounds = new ArrayList<>();
        for (Playground playground : allPlaygrounds) {
            if (playground.isWaterFeature()) {
                targetedPlaygrounds.add(playground);
            } else {
                continue;
            }
        }
        model.addAttribute("playgrounds",targetedPlaygrounds);
        return "searchbylists/listbyfields";
    }
}
