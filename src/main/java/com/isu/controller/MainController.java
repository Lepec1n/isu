package com.isu.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@Scope("session")
public class MainController {

    String currentUser = null;

    @GetMapping({"/", "/index"})
    public ModelAndView index() {
        String pageName = (this.currentUser != null) ? "admin" : "login";

        return new ModelAndView("redirect:/" + pageName);
    }

    @GetMapping("/login")
    public ModelAndView loginPage() {
        if (this.currentUser != null) {
            return this.index();
        }
        return new ModelAndView("login");
    }

    @GetMapping("/log_in")
    public int logIn(@RequestParam String username) {
        if (true) { //todo: add DB check
            this.currentUser = username;
            return 1;
        }

        return 0;
    }

    @GetMapping("/log_out")
    public ModelAndView logOut() {
        this.currentUser = null;
        return this.index();
    }

    @GetMapping("/admin")
    public ModelAndView adminPage() {
        if (this.currentUser == null) {
            return new ModelAndView("redirect:/login");
        }

        ModelAndView mav = new ModelAndView("admin");

        mav.addObject("username", this.currentUser);

        return mav;
    }


}
