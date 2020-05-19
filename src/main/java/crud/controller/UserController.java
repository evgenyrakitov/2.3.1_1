package crud.controller;


import crud.model.User;
import crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService UserService;

    @GetMapping(value = "users")
    public String printUser(ModelMap modelMap) {
        modelMap.addAttribute("allUser", UserService.getAllUser());
        return "users";
    }

    @GetMapping(value = "add")
    public String createAddPage(ModelMap modelMap) {

        return "update";
    }

    @PostMapping(value = "add")
    public String addUser(@ModelAttribute("User") User user) {
        UserService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping(value = "delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        UserService.removeUser(id);
        return "redirect:/users";
    }

    @GetMapping(value = "update/{id}")
    public ModelAndView editPage (@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("update");
        modelAndView.addObject("user", UserService.getUserById(id));
        return modelAndView;
    }

    @PostMapping(value = "update")
    public ModelAndView updateUser (@ModelAttribute User user, @RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/users");
        UserService.updateUser(user);
        return modelAndView;
    }

}
