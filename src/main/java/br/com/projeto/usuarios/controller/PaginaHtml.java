package br.com.projeto.usuarios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaginaHtml {

    @GetMapping("/user")
    public String form() {
        return "user-form";
    }

    @GetMapping("/user/search-by-name")
    public String pageSearch(){
        return "search-by-name";
    }

    @GetMapping("/user/list-all")
    public String listAll() {
        return "list-all";
    }
}
