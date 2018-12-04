package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.Optional;

/**
 * Created on 02-December-2018
 *
 * @author eray
 */
@Slf4j
@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "")
    public String home(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }

    @PostMapping(value ="/new")
    public String getUserForm(@Valid @ModelAttribute User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "redirect:/";
        }
        else{
            userRepository.save(user);
            return "redirect:/"; //getIndex ile bu redirecti tuttuk
        }
    }

    @DeleteMapping(value= "/{id}/delete")
    public String deleteEntry(@PathVariable("id") Integer id){

        Optional<User> userOptional = userRepository.findById(id);

        if(!userOptional.isPresent()){
            log.warn("Entry with {} id is not present", id);
            return "index";
        }
        else{
            userRepository.delete(userOptional.get());
            return "redirect:/";
        }

    }

    @GetMapping("/findOne")
    @ResponseBody
    public Optional<User> findOne(Integer id){
        return userRepository.findById(id);
    }

}
