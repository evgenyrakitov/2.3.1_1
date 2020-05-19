package crud.controller;


import crud.model.Car;
import crud.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.Callable;

@Controller
@RequestMapping("/")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping(value = "cars")
    public String printCar(ModelMap modelMap) {
        modelMap.addAttribute("allCar", carService.getAllCar());
        return "cars";
    }

    @GetMapping(value = "add")
    public String createAddPage(ModelMap modelMap) {

        return "update";
    }

    @PostMapping(value = "add")
    public String addCar(@ModelAttribute("car") Car car) {
        carService.addCar(car);
        return "redirect:/cars";
    }

    @GetMapping(value = "delete/{id}")
    public String deleteCar(@PathVariable Long id) {
        carService.removeCar(id);
        return "redirect:/cars";
    }

    @GetMapping(value = "update/{id}")
    public ModelAndView editPage (@PathVariable Long id) {
        Car car = carService.getCarById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("update");
        modelAndView.addObject("car", car);
        return modelAndView;
    }

    @PostMapping(value = "update")
    public ModelAndView updateCar (@ModelAttribute Car car, @RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/cars");
        carService.updateCar(car);
        return modelAndView;
    }

}
