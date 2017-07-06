package com.ak.kick.web;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ak on 9/27/16.
 */
@RestController
@RequestMapping("/greet")
public class GreetController {

    @Value("${book.author}")
    private String bookAuthor;

    @Value("${book.name}")
    private String bookName;

    @RequestMapping("/")
    public String hello() {
        return "hello greet";
    }

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "hello world") String name, Model model) {
        model.addAttribute("name", name);
        System.out.println("bookAuthor = " + bookAuthor + " bookName" + bookName);
        return "greeting:" + name;
    }

    @RequestMapping("/list")
    public List<HashMap<String, String>> list() {
        List<HashMap<String, String>> list = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            HashMap<String, String> map = new HashMap<>();
            map.put("name", "hello xx " + i);
            list.add(map);
        }
        return list;
    }

}
