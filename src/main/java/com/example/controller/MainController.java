package com.example.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.repo.UserRepository;
import com.example.entity.User;

@Controller
//@RequestMapping(path="/demo")
public class MainController {
  @Autowired
  private UserRepository userRepository;

  @GetMapping
  public String root() {
	  return "index";
  }
  
  @PostMapping(path="/add")
  public String addNewUser (@RequestParam String name, @RequestParam String email) {
    
    User n = new User();
    n.setName(name);
    n.setEmail(email);
    userRepository.save(n);
    return "redirect:all";
  }

  @GetMapping(path="/all")
  public ModelAndView getAllUsers() {
    List<User> list = StreamSupport.stream(userRepository.findAll().spliterator(),false).collect(Collectors.toList());
    ModelAndView mv= new ModelAndView();
    mv.addObject("list", list);
    mv.setViewName("user");
    return mv;
  }
}
