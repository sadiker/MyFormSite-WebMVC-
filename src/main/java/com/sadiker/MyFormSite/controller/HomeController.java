package com.sadiker.MyFormSite.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.sadiker.MyFormSite.models.Issue;
import com.sadiker.MyFormSite.models.Comment;
import com.sadiker.MyFormSite.repository.IssueRepository;
import com.sadiker.MyFormSite.repository.CommentRepository;

@Controller
public class HomeController {


    //github yorum satırı
    @Autowired
    IssueRepository issueRepository;

    @Autowired
    CommentRepository commentRepository;

    @GetMapping(path = { "/", "", "/home" })
    public String showAll(ModelMap map) {

        List<Issue> allissues = issueRepository.findAll();
        List<Issue> issues = new ArrayList<Issue>();
        forRandomMethodIssue(allissues, issues);
        map.addAttribute("issues", issues);

        List<Comment> allcomments = commentRepository.findAll();
        List<Comment> comments = new ArrayList<Comment>();
        forRandomMethodComment(allcomments, comments);
        map.addAttribute("comments", comments);
        return "home";
    }

    public static void forRandomMethodComment(List<Comment> allcomments, List<Comment> comments) {
        Random rand = new Random();
        if (allcomments.size() >= 4) {
            int r1 = rand.nextInt(0, allcomments.size());
            int r2 = rand.nextInt(0, allcomments.size());
            int r3 = rand.nextInt(0, allcomments.size());
            int r4 = rand.nextInt(0, allcomments.size());

            comments.add(allcomments.get(r4));
            comments.add(allcomments.get(r3));
            comments.add(allcomments.get(r2));
            comments.add(allcomments.get(r1));
        }

    }

    public static void forRandomMethodIssue(List<Issue> allissues, List<Issue> issues) {

        Random rand = new Random();
        if (allissues.size() >= 3) {
            int r1 = rand.nextInt(0, allissues.size());
            int r2 = rand.nextInt(0, allissues.size());
            int r3 = rand.nextInt(0, allissues.size());

            issues.add(allissues.get(r3));
            issues.add(allissues.get(r2));
            issues.add(allissues.get(r1));
        }

    }

}
