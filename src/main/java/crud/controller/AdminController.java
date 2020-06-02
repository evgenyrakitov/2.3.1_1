package crud.controller;


import crud.dto.UserDTO;
import crud.model.Role;
import crud.model.User;
import crud.service.RoleService;
import crud.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserService UserService;

    @Autowired
    RoleService roleService;

    @ModelAttribute("role")
    public List<Role> initializeRole() {
        return  roleService.getRoles();
    }

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
    public String addUser(User user, String[] role) {
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
    public String updateUser (User user, String[] role) {
        UserService.updateUser(user, role);
        return "redirect:/admin";
    }

}
