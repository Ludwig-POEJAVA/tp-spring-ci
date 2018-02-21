package poe.spring.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomePageController
{
	@GetMapping
	public String index(Model model)
	{
		model.addAttribute("message", "Welcome $user, this is the best site of India.");
		model.addAttribute("time", new Date());
		return "index";
	}
}
