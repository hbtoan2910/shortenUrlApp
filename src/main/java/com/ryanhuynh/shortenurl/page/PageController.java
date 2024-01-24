package com.ryanhuynh.shortenurl.page;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ryanhuynh.shortenurl.page.PageController;

@Controller
@RequestMapping("/api/v1")
public class PageController {
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@GetMapping({"/", "/home", "/index"})
    public String home(Model model) {
        model.addAttribute("message", "This is Home Page created with Spring Boot Thymeleaf!");
        logger.info("in Home method");
        return "index";
    }
}
