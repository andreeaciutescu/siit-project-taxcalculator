package com.java.siit.taxcalculator.controller;

import com.java.siit.taxcalculator.domain.entity.LoginEntity;
import com.java.siit.taxcalculator.domain.model.LoginDTO;
import com.java.siit.taxcalculator.service.LoginService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

    @Autowired
    private final LoginService service ;

    @GetMapping("/users")
    public String getAllUsersWithBusiness(Model model) {
        List<LoginEntity> users = service.getAllUsersWithBusiness();
        model.addAttribute("users", users);
        return "users";
    }
    @RequestMapping("/users/edit/{id}")
    public ModelAndView editUser(@PathVariable(name = "id") int id) throws NotFoundException {

        ModelAndView mav = new ModelAndView("edit_user");
        LoginDTO login = service.findById(id);
        mav.addObject("login", login);
        return mav;
    }
}
