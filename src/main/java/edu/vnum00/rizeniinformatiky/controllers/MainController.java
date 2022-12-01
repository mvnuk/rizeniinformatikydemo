package edu.vnum00.rizeniinformatiky.controllers;

import edu.vnum00.rizeniinformatiky.entity.User;
import edu.vnum00.rizeniinformatiky.services.OsService;
import edu.vnum00.rizeniinformatiky.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("mainController")
@RequestMapping("/")
public class MainController {

    private final OsService osService;
    private final UserService userService;

    @Autowired
    public MainController(OsService osService, UserService userService) {
        this.osService = osService;
        this.userService = userService;
    }


    @GetMapping
    public String getMainPage(Model model) {
        model.addAttribute("os", osService.getOs());

        model.addAttribute("users", userService.getAllUsers());

        model.addAttribute("newUser", new User());

        return "main-page";
    }

    @PostMapping("deleteUser")
    public String deleteUser(Long userId) {
        System.out.println("called" + userId);
        userService.deleteUser(userId);
        return "redirect:/";
    }

    @PostMapping
    public String resolveForm(User newUser) {
        userService.addUser(newUser);
        return "redirect:/";
    }
}
