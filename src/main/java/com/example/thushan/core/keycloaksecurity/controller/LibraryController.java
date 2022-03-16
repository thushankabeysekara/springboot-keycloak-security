package com.example.thushan.core.keycloaksecurity.controller;

import com.example.thushan.core.keycloaksecurity.repository.BookRepository;
import org.keycloak.KeycloakSecurityContext;
import org.springframework.ui.Model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
public class LibraryController {
    private final HttpServletRequest request;
    private final BookRepository bookRepository;

    public LibraryController(HttpServletRequest request, BookRepository bookRepository) {
        this.request = request;
        this.bookRepository = bookRepository;
    }

    @GetMapping(value = "/")
    public String getHome() {
        return "index";
    }

    @GetMapping(value = "/books")
    public String getBooks(Model model) {
        configCommonAttributes(model);
        model.addAttribute("books", bookRepository.readAll());
        return "books";
    }

    @GetMapping(value = "/manager")
    public String getManager(Model model) {
        configCommonAttributes(model);
        model.addAttribute("books", bookRepository.readAll());
        return "manager";
    }

    @GetMapping(value = "/logout")
    public String logout() throws ServletException {
        request.logout();
        return "redirect:/";
    }

    /**
     * KeycloakSecurityContext to retrieve the IdToken, from which we can get the first name of the authenticated user
     * @param model
     */
    private void configCommonAttributes(Model model) {
        model.addAttribute("name", getKeycloakSecurityContext().getIdToken().getGivenName());
    }

    /**
     * The KeycloakSecurityContext provides access to several pieces of information
     * contained in the security token, such as user profile information.
     */
    private KeycloakSecurityContext getKeycloakSecurityContext() {
        return (KeycloakSecurityContext) request.getAttribute(KeycloakSecurityContext.class.getName());
    }
}
