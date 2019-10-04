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


        if (listsize == 1) {

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

                    testingBooleanGettersAsStrings.put(0,"accessibility.isParkingLot()");

                    //MAY USE
                    /*for (String checkbox : playgroundFeaturesArrayList) {
                        if (checkbox.contains("ParkingLot")) {
                            filteredBooleanValuesAsStrings.put(anInteger,"accessibility.isParkingLot()");
                        } else {
                            continue;
                        }

                        anInteger = ++anInteger;
                    }*/

                    /*for (String checkbox : playgroundFeaturesArrayList) {
                        //if statements (put current anInteger value, and set boolean values)
                        if (checkbox.contains("ParkingLot")) {
                            filteredBooleanValues.put(anInteger,accessibility.isParkingLot());
                        } else {
                            continue;
                        }

                        //integer counter increase by 1
                    }*/

                    //NOT NEEDED, TESTING: add all checkbox Boolean values, later compare this HashMap's key with strings in pFAL
                    //booleanValues.put("ParkingLot", accessibility.isParkingLot());

                    //Can probably comment out these permanently, still present for a reference
                    //String isParking = "accessibility.isParkingLot()";
                    //boolean varBoolean = Boolean.parseBoolean(isParking); //Return false do to string not being "true"

                    //*********Do something similar to this, except...
                    /*if (booleanValues.get("ParkingLot")) {
                        targetedPlaygrounds.add(playground);
                    } else{
                        continue;
                    }*/


                    //...For each Str in pFAL
                    /*for (String astring : playgroundFeaturesArrayList) {
                        //For each Key in booleanValues
                        for (String key : booleanValues.keySet()) {
                            //if Str in pFAL == Key
                            if (key.contains(astring)) {
                                //put Key:Value set in filteredBooleanValues
                                filteredBooleanValues.put(key, booleanValues.get(key));
                            }

                        }
                    }*/
                }
            //}

        } else {
            System.out.println("No, listsize not one.");
        }

        //search for playgrounds that contain slides AND laders
        //return "redirect:playground/remove";

        model.addAttribute(new SearchForm());
        model.addAttribute("playgrounds",targetedPlaygrounds);
        return "searchbylists/listbyfields";
    }
}
