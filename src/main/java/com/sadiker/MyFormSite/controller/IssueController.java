package com.sadiker.MyFormSite.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sadiker.MyFormSite.models.Issue;
import com.sadiker.MyFormSite.models.Comment;
import com.sadiker.MyFormSite.repository.IssueRepository;
import com.sadiker.MyFormSite.repository.UserRepository;
import com.sadiker.MyFormSite.repository.CommentRepository;

@Controller
public class IssueController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    IssueRepository issueRepository;

    @Autowired
    CommentRepository commentRepository;

    @GetMapping("/showAllIssue")
    public String showAll(ModelMap map) {
        List<Issue> issues = issueRepository.findAll();
        map.addAttribute("issues", issues);
        return "/issue/showAllIssue";
    }

    @GetMapping("/createIssue")
    public String createIssue(ModelMap map) {
        Issue issue = new Issue();
        map.addAttribute("newIssue", issue);
        return "/issue/createIssue";
    }

    @PostMapping("/saveIssue")
    public String saveIssue(@ModelAttribute Issue issue, Principal principal) {
        issue.setUser(userRepository.findByUsername(principal.getName()));
        issueRepository.save(issue);
        return "redirect:/showAllIssue";
    }

    @GetMapping("/showIssue/{id}")
    public String showOneIssue(ModelMap map,
            @PathVariable(required = false, value = "id") Long id) {
        Issue issue = issueRepository.findById(id).get();
        List<Comment> comments = issue.getComments();
        map.addAttribute("comments", comments);
        String issueName = issue.getName();
        map.addAttribute("issueName", issueName);
        return "comment/showAllCommentByIssue";
    }

    @GetMapping("/deleteIssue/{id}")
    public String deleteIssue(@PathVariable("id") Long id) {
            Issue issue = issueRepository.findById(id).get();
            issueRepository.delete(issue);
            return "redirect:/showAllIssue";
       
       
    }

}
