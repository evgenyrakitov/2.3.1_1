package crud.controller;


import crud.dao.UserDao;
import crud.model.User;
import crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public String getUser(ModelMap modelMap) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findUserByUserName(userName);
        modelMap.addAttribute("user", user);
        return "user";
    }
}
