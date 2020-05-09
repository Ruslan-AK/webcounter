package com.yalantis.reneuby.webcounter.controller;

import com.yalantis.reneuby.webcounter.filter.CurrentPageUsersCountProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {
    @Autowired
    CurrentPageUsersCountProcessor countProcessor;

    @RequestMapping("/")
    public String rootPage() {
        return "index";
    }

    @RequestMapping("/counter")
    public ModelAndView counterPage() {
        return new ModelAndView("counter")
                .addObject("counter", countProcessor.getCount("/counter"));
    }
}
