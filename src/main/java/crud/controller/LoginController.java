package crud.controller;


import crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(name = "/login")
public class LoginController {
    @Autowired
    UserService UserService;

    @GetMapping(value = "login")
    public String loginPage() {
        return "login";
    }

}
