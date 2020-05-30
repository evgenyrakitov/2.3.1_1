package crud.controller;


import crud.model.User;
import crud.service.RoleService;
import crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserService UserService;

    @Autowired
    RoleService roleService;

    @GetMapping
    public String printUser(ModelMap modelMap) {
        modelMap.addAttribute("allUser", UserService.getAllUser());
        return "admin";
    }

    @GetMapping(value = "/add")
    public String createAddPage(ModelMap modelMap) {
        modelMap.addAttribute("roles", roleService.getRoles());
        return "add";
    }

    @PostMapping(value = "/add")
    public String addUser(@RequestParam String userName, @RequestParam String lastName, @RequestParam String email, @RequestParam String password, @RequestParam String[] role) {
        User user = new User(userName, lastName, email, password);
        UserService.addUser(user, role);
        return "redirect:/admin";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        UserService.removeUser(id);
        return "redirect:/admin";
    }

    @GetMapping(value = "/update/{id}")
    public String editPage (@PathVariable Long id, ModelMap modelMap) {
        modelMap.addAttribute("user", UserService.getUserById(id));
        modelMap.addAttribute("roles", roleService.getRoles());
        return "update";
    }

    @PostMapping(value = "/update")
    public String updateUser (Long id, String userName, String lastName, String email, String password, String[] role) {
        User user = new User(id, userName, lastName, email, password);
        UserService.updateUser(user, role);
        return "redirect:/admin";
    }

}
