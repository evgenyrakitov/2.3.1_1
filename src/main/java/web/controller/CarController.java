package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.LocaleResolver;
import web.service.CarService;

import java.util.Locale;

@Controller
@RequestMapping("/")
public class CarController {


    @Autowired
    CarService carService;

    @RequestMapping(value = "cars", method = RequestMethod.GET)
    public String printCar(ModelMap model) {
        model.addAttribute("message", carService.getCarList());
        return "cars";
    }
}
