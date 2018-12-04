package com.example.demo.controller;

import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 02-December-2018
 *
 * @author eray
 */
@RestController
public class AjaxController {
    @Autowired
    private UserRepository userRepository;

    @DeleteMapping("/deleteAll")
    public void delete() {
        userRepository.deleteAll();
    }
}
