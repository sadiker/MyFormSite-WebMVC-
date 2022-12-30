package com.sadiker.MyFormSite.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sadiker.MyFormSite.models.Issue;
import com.sadiker.MyFormSite.models.User;
import com.sadiker.MyFormSite.models.Comment;
import com.sadiker.MyFormSite.repository.IssueRepository;
import com.sadiker.MyFormSite.repository.UserRepository;
import com.sadiker.MyFormSite.repository.CommentRepository;

@Controller
public class CommentController {
    
    public Long issueId;
    @Autowired
    IssueRepository issueRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CommentRepository commentRepository;
    

    @GetMapping("/createComment/{id}")
    public String createComment(ModelMap map,@PathVariable("id") Long id
    ) {
        issueId=id;
        Comment comment = new Comment();
        map.addAttribute("newComment", comment);
        return "comment/createComment";
    }

    @PostMapping("/saveComment")
    public String saveComment(@ModelAttribute("newComment") Comment comment,
            Principal principal
           ) {
        Issue issue = issueRepository.findById(issueId).get();
        User user = userRepository.findByUsername(principal.getName());
        comment.setUser(user);
        comment.setIssue(issue);
        commentRepository.save(comment);
        return "redirect:/showAllIssue";
    }

    @GetMapping("/deleteComment/{id}")
    public String deleteComment(@PathVariable("id") Long id ) {
        Comment comment = commentRepository.findById(id).get();
        commentRepository.delete(comment);
        return "redirect:/showAllIssue";
    }

}
