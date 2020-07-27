package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    JobRepository jobRepository;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("jobs", jobRepository.findAll());
        return "index";
    }

    @RequestMapping("/addUser")
    public String addUser(Model model){
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping("/processUser")
    public String processUser(@ModelAttribute User user){
        userRepository.save(user);
        return "redirect:/addJob";
    }

    @RequestMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") long id, Model model){
        model.addAttribute("user", userRepository.findById(id));
        return "addUser";
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable ("id") long id){
        userRepository.deleteById(id);
        return "redirect:/";
    }

    @RequestMapping ("/detailUser/{id}")
    public String detailUser (@PathVariable("id") long id, Model model){
        User user = userRepository.findById(id).get();
        model.addAttribute("user", user);
        return "detailUser";
    }

    @RequestMapping("/listUsers")
    public String listJobs(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "listUsers";
    }

    @RequestMapping("/addJob")
    public String addJob(Model model){
    model.addAttribute("job", new Job());
    model.addAttribute("users", userRepository.findAllByIdGreaterThanOrderByUserName(13));
        return "addJob";
    }

    @PostMapping("/addJob")
    public String processJob(@ModelAttribute Job job, @RequestParam("userID") long userID){
        User user = userRepository.findById(userID).get();
        job.setUser(user);
        jobRepository.save(job);
        return "redirect:/";
    }

    @RequestMapping("/updateJob/{id}")
    public String updateJob(@PathVariable("id") long id, Model model){
        Job job = jobRepository.findById(id).get();
        model.addAttribute("job", job);
        model.addAttribute("users",userRepository.findAllByIdGreaterThanOrderByUserName(13));
        return "addJob";
    }

    @RequestMapping("/deleteJob/{id}")
    public String deleteJob(@PathVariable("id") long id){
        jobRepository.deleteById(id);
        return "redirect:/";
    }

    @RequestMapping("/detailJob/{id}")
    public String detailJob(@PathVariable("id") long id, Model model){
        Job job = jobRepository.findById(id).get();
        model.addAttribute("job", job);
        return "detailJob";
    }





}