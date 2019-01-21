package com.stackroute.controller;

import com.stackroute.dao.LoginDAO;
import com.stackroute.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private LoginDAO loginDAO;
    private  User user=new User();
    @GetMapping
    public String greeting(ModelMap map){
        return "index";
    }

    @RequestMapping("loginaadmele")
    public ModelAndView populate (@RequestParam("username") String name,@RequestParam("password") String password ){
       user.setUsername(name);
       user.setPassword(password);
       boolean status=loginDAO.addToDatabase(user);
       if(status){
          // User user1=loginDAO.getUserName(name);
           ModelAndView mv= new ModelAndView();
           mv.addObject("obj",loginDAO.getUserName(name).getUsername());
           mv.setViewName("result");
        return mv;
       }else{
           ModelAndView mv= new ModelAndView();
           mv.setViewName("index");
           return mv;
       }
    }
}
