package com.codeup.sittergitter.controllers;

import com.codeup.sittergitter.models.Post;
import com.codeup.sittergitter.models.User;
import com.codeup.sittergitter.repositories.PostRepository;
import com.codeup.sittergitter.repositories.UserRepository;
import com.codeup.sittergitter.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {

    private final PostRepository postsRepo;
    private final UserRepository usersRepo;
    private EmailService emailService;

    public PostController(PostRepository postsRepo, UserRepository usersRepo, EmailService emailService) {
        this.postsRepo = postsRepo;
        this.usersRepo = usersRepo;
        this.emailService = emailService;
    }

    @GetMapping("/posts")
    public String showPosts(Model model) {
        model.addAttribute("posts", postsRepo.findAll());
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String showPost(@PathVariable Long id, Model model) {
        User author = usersRepo.findOne(1L);
        model.addAttribute("author", author);
        //////////////////////////// refactor ^

        Post post = postsRepo.findOne(id);
        model.addAttribute("post", post);
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    public String showCreatePost(Model model) {
        model.addAttribute("post", new Post());
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post postToSaved) {
//        postToSaved.setAuthor(usersRepo.findOne(1L));
//        Post savedPost = postsRepo.save(postToSaved);

        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userDB = usersRepo.findOne(sessionUser.getId());
        postToSaved.setAuthor(userDB);
        Post savedPost = postsRepo.save(postToSaved);

//        emailService.prepareAndSend(savedPost, "Post has been created", "The post has been created successfully and " + "you can find it with the ID of " + savedPost.getId());
        return "redirect:/posts/" + savedPost.getId();
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditPost(@PathVariable Long id, Model model){
        Post post = postsRepo.findOne(id);
        User user = usersRepo.findOne(id);
        model.addAttribute("user", user);
        model.addAttribute("post", post);
        return "/posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(@ModelAttribute Post postToBeEdited){
        postToBeEdited.setAuthor(usersRepo.findOne(1L));
        postsRepo.save(postToBeEdited);
        return "redirect:/posts/" + postToBeEdited.getId();
    }

    @GetMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable Long id){
        postsRepo.deleteById(id);
        return "redirect:/posts";
    }

}