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
        int listSizeMinusOne = listsize - 1;


        //if (listsize == 1) {

            //parking lot
            //if (playgroundFeaturesArrayList.contains("ParkingLot")) {

            //See if boolean getters as strings successfully convert to useful in if statements.
            HashMap<Integer, String> testingBooleanGettersAsStrings = new HashMap<>();


            //HashMap with filtered checkbox Booleans from pFAL
            HashMap<Integer, String> filteredBooleanValuesAsStrings = new HashMap<>();
            Integer anInteger = 0;

            for (Playground playground : allPlaygrounds) {
                Accessibility accessibility = playground.getAccessibility();
                Amenities amenities = playground.getAmenities();
                Equipment equipment = playground.getEquipment();
                Shelters shelters = playground.getShelters();
                SpecialNeeds specialNeeds = playground.getSpecialNeeds();
                //Water Feature

                int counterForCheckboxItemArrayList = 0;

                //CheckboxItem List
                ArrayList<CheckboxItem> checkboxItemArrayList = new ArrayList<CheckboxItem>();

                HashMap<String, Boolean> allF = new HashMap<>();
                allF.put("ParkingLot", accessibility.isParkingLot());
                allF.put("Trail", accessibility.isTrail());
                allF.put("RestroomChangingStation", amenities.isRestroomChangingStation());
                allF.put("WaterFountain", amenities.isWaterFountain());
                allF.put("ClimbingWalls",equipment.isClimbingWalls());
                allF.put("Ladders",equipment.isLadders());
                allF.put("Seesaw",equipment.isSeesaw());
                allF.put("Slides", equipment.isSlides());
                allF.put("Structures",equipment.isStructures());
                allF.put("Swings",equipment.isSwings());
                allF.put("Benches",shelters.isBenches());
                allF.put("Pavillion",shelters.isPavillion());
                allF.put("Sensory",specialNeeds.isSensory());
                allF.put("WheelchairAccessible",specialNeeds.isWheelchairAccessible());
                allF.put("WaterFeature",playground.isWaterFeature());

                for (String key : allF.keySet()) {
                    if (playgroundFeaturesArrayList.contains(key) && allF.get(key)) {
                        CheckboxItem checkboxItem = new CheckboxItem(0, key, allF.get(key));
                        checkboxItemArrayList.add(checkboxItem);
                    }
                }

                //Counter for every .isaB that is "True"
                for (CheckboxItem checkbox : checkboxItemArrayList) {
                    //if(checkboxItemArrayList.size() > listSizeMinusOne)
                    if (checkbox.isaBoolean()) {
                        //continue; //placeholder
                        // (int variable) = ++ (int variable)
                        counterForCheckboxItemArrayList = ++ counterForCheckboxItemArrayList;

                    }
                }

                if (checkboxItemArrayList.size() > listSizeMinusOne && counterForCheckboxItemArrayList == listsize) {
                    targetedPlaygrounds.add(playground);
                }

                /*if (listsize == 1
                        && checkboxItemArrayList.size() > 0
                        && checkboxItemArrayList.get(0).isaBoolean()) {
                    targetedPlaygrounds.add(playground);
                } else if (listsize == 2
                        && checkboxItemArrayList.size() > 1
                        && checkboxItemArrayList.get(0).isaBoolean()
                        && checkboxItemArrayList.get(1).isaBoolean()) {
                    targetedPlaygrounds.add(playground);
                } else if (listsize == 3
                        && checkboxItemArrayList.size() > 2
                        && checkboxItemArrayList.get(0).isaBoolean()
                        && checkboxItemArrayList.get(1).isaBoolean()
                        && checkboxItemArrayList.get(2).isaBoolean())  {
                    targetedPlaygrounds.add(playground);
                } else if (listsize == 4
                        && checkboxItemArrayList.size() > 3
                        && checkboxItemArrayList.get(0).isaBoolean()
                        && checkboxItemArrayList.get(1).isaBoolean()
                        && checkboxItemArrayList.get(2).isaBoolean()
                        && checkboxItemArrayList.get(3).isaBoolean())  {
                    targetedPlaygrounds.add(playground);
                } else if (listsize == 5
                        && checkboxItemArrayList.size() > 4
                        && checkboxItemArrayList.get(0).isaBoolean()
                        && checkboxItemArrayList.get(1).isaBoolean()
                        && checkboxItemArrayList.get(2).isaBoolean()
                        && checkboxItemArrayList.get(3).isaBoolean()
                        && checkboxItemArrayList.get(4).isaBoolean())  {
                    targetedPlaygrounds.add(playground);
                } else if (listsize == 6
                        && checkboxItemArrayList.size() > 5
                        && checkboxItemArrayList.get(0).isaBoolean()
                        && checkboxItemArrayList.get(1).isaBoolean()
                        && checkboxItemArrayList.get(2).isaBoolean()
                        && checkboxItemArrayList.get(3).isaBoolean()
                        && checkboxItemArrayList.get(4).isaBoolean()
                        && checkboxItemArrayList.get(5).isaBoolean())  {
                    targetedPlaygrounds.add(playground);
                } else if (listsize == 7
                        && checkboxItemArrayList.size() > 6
                        && checkboxItemArrayList.get(0).isaBoolean()
                        && checkboxItemArrayList.get(1).isaBoolean()
                        && checkboxItemArrayList.get(2).isaBoolean()
                        && checkboxItemArrayList.get(3).isaBoolean()
                        && checkboxItemArrayList.get(4).isaBoolean()
                        && checkboxItemArrayList.get(5).isaBoolean()
                        && checkboxItemArrayList.get(6).isaBoolean())  {
                    targetedPlaygrounds.add(playground);
                }*/
            }

        //}
        /*else if (listsize == 2) {
            for (Playground playground : allPlaygrounds) {
                Accessibility accessibility = playground.getAccessibility();
                Amenities amenities = playground.getAmenities();
                Equipment equipment = playground.getEquipment();
                Shelters shelters = playground.getShelters();
                SpecialNeeds specialNeeds = playground.getSpecialNeeds();
                //Water Feature

                //CheckboxItem List
                ArrayList<CheckboxItem> checkboxItemArrayList = new ArrayList<CheckboxItem>();

                HashMap<String, Boolean> allF = new HashMap<>();
                allF.put("ParkingLot", accessibility.isParkingLot());
                allF.put("Slides", equipment.isSlides());

                for (String key : allF.keySet()) {
                    if (playgroundFeaturesArrayList.contains(key) && allF.get(key)) {
                        CheckboxItem checkboxItem = new CheckboxItem(0, key, allF.get(key));
                        checkboxItemArrayList.add(checkboxItem);
                    }
                }

                if (checkboxItemArrayList.size() > 1 && checkboxItemArrayList.get(0).isaBoolean() && checkboxItemArrayList.get(1).isaBoolean()) {

                    //String checkboxName = checkboxItemArrayList.get(0).getaString();
                    //System.out.println("The name is " + checkboxName);
                    //CheckboxItem checkboxItemZero = checkboxItemArrayList.get(0);
                    targetedPlaygrounds.add(playground);
                }
            }

        } else {
            System.out.println("Oh.");
        }*/

        //search for playgrounds that contain slides AND laders
        //return "redirect:playground/remove";

        model.addAttribute(new SearchForm());
        model.addAttribute("playgrounds",targetedPlaygrounds);
        return "searchbylists/listbyfields";
    }
}
