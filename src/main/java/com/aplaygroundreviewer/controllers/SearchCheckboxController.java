package com.aplaygroundreviewer.controllers;

import com.aplaygroundreviewer.dto.*;
import com.aplaygroundreviewer.repository.PlaygroundDao;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.Access;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class SearchCheckboxController {

    @Autowired
    private PlaygroundDao playgroundDao;
    //private static HashMap<String, String> playgroundFeatures = new HashMap<>();


    @RequestMapping(value = "searchbyfeatures", method = RequestMethod.POST)
    public String processSearchByFeatures(Model model, @RequestParam String[] pFeatures) {

        ArrayList<String> playgroundFeaturesArrayList = new ArrayList<String>();

        List<Playground> allPlaygrounds = playgroundDao.findAll();
        List<Playground> targetedPlaygrounds = new ArrayList<>();

        int listsize = playgroundFeaturesArrayList.size();

        for (String feature : pFeatures) {
            System.out.println(feature);
            playgroundFeaturesArrayList.add(feature);
            listsize = ++listsize;
        }



        //////LENGTH = 2
        /*if (listsize == 2) {

            //////PARKING LOT
            //parking lot and trail
            if (playgroundFeaturesArrayList.contains("parkingLot") && playgroundFeaturesArrayList.contains("trail")) {

                for (Playground playground : allPlaygrounds) {
                    Accessibility accessibility = playground.getAccessibility();
                    if (accessibility.isParkingLot() && accessibility.isTrail()) {
                        targetedPlaygrounds.add(playground);
                    } else {
                        continue;
                    }
                }
            }


            //parking lot and restroom changing station

            if (playgroundFeaturesArrayList.contains("restroomChangingStation") && playgroundFeaturesArrayList.contains("parkingLot")) {

                for (Playground playground : allPlaygrounds) {
                    Accessibility accessibility = playground.getAccessibility();
                    Amenities amenities = playground.getAmenities();

                    if (accessibility.isParkingLot() && amenities.isRestroomChangingStation()) {
                        targetedPlaygrounds.add(playground);
                    } else {
                        continue;
                    }

                }
            }


            //parking lot and water fountain

            if (playgroundFeaturesArrayList.contains("waterFountain") && playgroundFeaturesArrayList.contains("parkingLot")) {

                for (Playground playground : allPlaygrounds) {
                    Accessibility accessibility = playground.getAccessibility();
                    Amenities amenities = playground.getAmenities();

                    if (accessibility.isParkingLot() && amenities.isWaterFountain()) {
                        targetedPlaygrounds.add(playground);
                    } else {
                        continue;
                    }

                }
            }


            //parking lot and climbing walls

            if (playgroundFeaturesArrayList.contains("parkingLot") && playgroundFeaturesArrayList.contains("climbingWalls")) {

                for (Playground playground : allPlaygrounds) {
                    Accessibility accessibility = playground.getAccessibility();
                    Equipment equipment = playground.getEquipment();

                    if (accessibility.isParkingLot() && equipment.isClimbingWalls()) {
                        targetedPlaygrounds.add(playground);
                    } else {
                        continue;
                    }

                }
            }

            //parking lot and ladders

            if (playgroundFeaturesArrayList.contains("parkingLot") && playgroundFeaturesArrayList.contains("ladders")) {

                for (Playground playground : allPlaygrounds) {
                    Accessibility accessibility = playground.getAccessibility();
                    Equipment equipment = playground.getEquipment();

                    if (accessibility.isParkingLot() && equipment.isLadders()) {
                        targetedPlaygrounds.add(playground);
                    } else {
                        continue;
                    }

                }
            }


            //parking lot and seesaw

            if (playgroundFeaturesArrayList.contains("parkingLot") && playgroundFeaturesArrayList.contains("seesaw")) {

                for (Playground playground : allPlaygrounds) {
                    Accessibility accessibility = playground.getAccessibility();
                    Equipment equipment = playground.getEquipment();

                    if (accessibility.isParkingLot() && equipment.isSeesaw()) {
                        targetedPlaygrounds.add(playground);
                    } else {
                        continue;
                    }

                }
            }


            //parking lot and slides

            if (playgroundFeaturesArrayList.contains("parkingLot") && playgroundFeaturesArrayList.contains("slides")) {

                for (Playground playground : allPlaygrounds) {
                    Accessibility accessibility = playground.getAccessibility();
                    Equipment equipment = playground.getEquipment();

                    if (accessibility.isParkingLot() && equipment.isSlides()) {
                        targetedPlaygrounds.add(playground);
                    } else {
                        continue;
                    }

                }
            }


            //parking lot and structures

            if (playgroundFeaturesArrayList.contains("parkingLot") && playgroundFeaturesArrayList.contains("structures")) {

                for (Playground playground : allPlaygrounds) {
                    Accessibility accessibility = playground.getAccessibility();
                    Equipment equipment = playground.getEquipment();

                    if (accessibility.isParkingLot() && equipment.isStructures()) {
                        targetedPlaygrounds.add(playground);
                    } else {
                        continue;
                    }

                }
            }


            //parking lot and swings

            if (playgroundFeaturesArrayList.contains("parkingLot") && playgroundFeaturesArrayList.contains("swings")) {

                for (Playground playground : allPlaygrounds) {
                    Accessibility accessibility = playground.getAccessibility();
                    Equipment equipment = playground.getEquipment();

                    if (accessibility.isParkingLot() && equipment.isSwings()) {
                        targetedPlaygrounds.add(playground);
                    } else {
                        continue;
                    }

                }
            }


            //parking lot and benches

            if (playgroundFeaturesArrayList.contains("parkingLot") && playgroundFeaturesArrayList.contains("benches")) {

                for (Playground playground : allPlaygrounds) {
                    Accessibility accessibility = playground.getAccessibility();
                    Shelters shelters = playground.getShelters();

                    if (accessibility.isParkingLot() && shelters.isBenches()) {
                        targetedPlaygrounds.add(playground);
                    } else {
                        continue;
                    }

                }
            }


            //parking lot and pavillion

            if (playgroundFeaturesArrayList.contains("parkingLot") && playgroundFeaturesArrayList.contains("pavillion")) {

                for (Playground playground : allPlaygrounds) {
                    Accessibility accessibility = playground.getAccessibility();
                    Shelters shelters = playground.getShelters();

                    if (accessibility.isParkingLot() && shelters.isPavillion()) {
                        targetedPlaygrounds.add(playground);
                    } else {
                        continue;
                    }

                }
            }


            //parking lot and sensory

            if (playgroundFeaturesArrayList.contains("parkingLot") && playgroundFeaturesArrayList.contains("sensory")) {

                for (Playground playground : allPlaygrounds) {
                    Accessibility accessibility = playground.getAccessibility();
                    SpecialNeeds specialNeeds = playground.getSpecialNeeds();

                    if (accessibility.isParkingLot() && specialNeeds.isSensory()) {
                        targetedPlaygrounds.add(playground);
                    } else {
                        continue;
                    }

                }
            }


            //parking lot and wheelchairAccessible

            if (playgroundFeaturesArrayList.contains("parkingLot") && playgroundFeaturesArrayList.contains("wheelchairAccessible")) {

                for (Playground playground : allPlaygrounds) {
                    Accessibility accessibility = playground.getAccessibility();
                    SpecialNeeds specialNeeds = playground.getSpecialNeeds();

                    if (accessibility.isParkingLot() && specialNeeds.isWheelchairAccessible()) {
                        targetedPlaygrounds.add(playground);
                    } else {
                        continue;
                    }

                }
            }


            //parking lot and water feature

            if (playgroundFeaturesArrayList.contains("parkingLot") && playgroundFeaturesArrayList.contains("waterFeature")) {

                for (Playground playground : allPlaygrounds) {
                    Accessibility accessibility = playground.getAccessibility();

                    if (accessibility.isParkingLot() && playground.isWaterFeature()) {
                        targetedPlaygrounds.add(playground);
                    } else {
                        continue;
                    }

                }
            }


            // slides and ladders
            if (playgroundFeaturesArrayList.contains("slides") && playgroundFeaturesArrayList.contains("ladders")) {
                //System.out.println("Yes, slides AND ladders");
                //Create a list of all playgrounds

                //List<Playground> allPlaygrounds = playgroundDao.findAll();
                //List<Playground> targetedPlaygrounds = new ArrayList<>();

                //For each playground in allPlaygroundsList
                for (Playground playground : allPlaygrounds) {
                    //Create Equipment object
                    Equipment equipment = playground.getEquipment();
                    //If equipment.isLadders AND equipment.isSlides
                    if (equipment.isLadders() && equipment.isSlides()) {
                        //add playground to targetedPlaygrounds list
                        targetedPlaygrounds.add(playground); //SUCCESS!!!!!!!!!!!!!!!!
                    //else continue
                    } else {
                        System.out.println("Continue");
                        continue;
                    }
                }

            }


            //Testing
            if (playgroundFeaturesArrayList.contains("slides") && playgroundFeaturesArrayList.contains("food")) {
                System.out.println("Yes, slides AND food");
            } else {
                System.out.println("Yeah, no food.");
            }



        } else*/
        if (listsize == 1) {


            /*for (Playground playground : allPlaygrounds) {
                for (String item : playgroundFeaturesArrayList) {
                    if ()
                }

            }*/

            //parking lot
            if (playgroundFeaturesArrayList.contains("ParkingLot")) {


                for (Playground playground : allPlaygrounds) {
                    Accessibility accessibility = playground.getAccessibility();

                    //Having working HashMap with Boolean values and strings
                    HashMap<String, Boolean> booleanValues = new HashMap<>();
                    booleanValues.put("ParkingLot", accessibility.isParkingLot());
                    String isParking = "accessibility.isParkingLot()";
                    boolean varBoolean = Boolean.parseBoolean(isParking); //Return false do to string not being "true"

                    if (booleanValues.get("ParkingLot")) {
                        targetedPlaygrounds.add(playground);
                    } else{
                        continue;
                    }

                }
            }


            //trail
            if (playgroundFeaturesArrayList.contains("trail")) {

                for (Playground playground : allPlaygrounds) {
                    Accessibility accessibility = playground.getAccessibility();

                    if (accessibility.isTrail()) {
                        targetedPlaygrounds.add(playground);
                    } else {
                        continue;
                    }

                }
            }




        } else {
            System.out.println("No, not two");
        }

        //search for playgrounds that contain slides AND laders
        //return "redirect:playground/remove";

        model.addAttribute(new SearchForm());
        model.addAttribute("playgrounds",targetedPlaygrounds);
        return "searchbylists/listbyfields";
    }
}
