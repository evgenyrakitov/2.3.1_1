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
public class AdminController {

    @Autowired
    UserService UserService;

    @GetMapping(value = "admin")
    public String printUser(ModelMap modelMap) {
        modelMap.addAttribute("allUser", UserService.getAllUser());
        return "admin";
    }

    @GetMapping(value = "admin/add")
    public String createAddPage(ModelMap modelMap) {
        return "redirect:/admin/update/0";
    }

    @PostMapping(value = "admin/add")
    public String addUser(@ModelAttribute("User") User user) {
        UserService.addUser(user);
        return "redirect:/admin";
    }

    @GetMapping(value = "admin/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        UserService.removeUser(id);
        return "admin";
    }

    @GetMapping(value = "admin/update/{id}")
    public String editPage (@PathVariable Long id, ModelMap modelMap) {
        modelMap.addAttribute("user", UserService.getUserById(id));
        return "update";
    }

    @PostMapping(value = "admin/update")
    public String updateUser (@ModelAttribute User user, @RequestParam Long id) {
        UserService.updateUser(user);
        return "redirect:/admin";
    }

}
