package com.aplaygroundreviewer.controllers;
import com.aplaygroundreviewer.dto.*;
import com.aplaygroundreviewer.repository.PlaygroundDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class SearchCheckboxController {

    @Autowired
    private PlaygroundDao playgroundDao;


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
                    if (checkbox.isaBoolean()) {
                        counterForCheckboxItemArrayList = ++ counterForCheckboxItemArrayList;
                    }
                }

                //If all CheckboxItem objects in checkboxItemArrayList are "true" (check via counterForCheckboxItemArrayList), add playground object to targetedPlaygrounds arraylist.
                if (checkboxItemArrayList.size() > listSizeMinusOne && counterForCheckboxItemArrayList == listsize) {
                    targetedPlaygrounds.add(playground);
                }
            }
        model.addAttribute(new SearchForm());
        model.addAttribute("playgrounds",targetedPlaygrounds);
        return "searchbylists/listbyfields";
    }
}
