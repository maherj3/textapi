package com.jessica.verdugo.textapi.controller;


import com.jessica.verdugo.textapi.model.OutputModel;
import com.jessica.verdugo.textapi.service.TextService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URL;



@Controller
public class TextController {

    final TextService textService;

    public TextController(TextService textService) {
        this.textService = textService;
    }

    @RequestMapping("/")
    public String index(){
        return "firstPage"; //mapping to opening page
    }

    @RequestMapping("/sendUrl")
    public String getOutput(@RequestParam(value = "url") String url, Model model) throws IOException { //the input url for the text reader to read
        OutputModel outputModel = textService.outputModelCreate(new URL(url));
        model.addAttribute("output", outputModel); //add the putput model to the front end model
        return "presentPage"; //return the new page
    }

}
