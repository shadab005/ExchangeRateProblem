package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By sudhanshu.singh on 8/11/18
 */

@Slf4j
@RestController
@RequestMapping(value = "/workflow")
public class Workflow {

    @Autowired
    public Workflow() {
    }

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public void startWorkflow() {

    }
}