package poe.spring.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import poe.spring.api.User;

@Controller
@RequestMapping("/signup")
public class SignupPageController
{
	@GetMapping
	public String signup(Model model)
	{
		model.addAttribute("message", "Welcome $user, give me your €€€€€!!!!!");
		model.addAttribute("time", new Date());
		return "signup";
	}

	@PostMapping
	public String saveUser(@RequestParam(name = "username") String username, RedirectAttributes attr)
	{
		//model.addAttribute("username", username);
		//model.addAttribute("time", new Date());
		attr.addAttribute("userName", username);
		return "redirect:/signup/success";
	}

	@GetMapping("/success")
	public String signupSucces(@RequestParam(name = "userName") String userName, Model model)
	{
		model.addAttribute("username", userName);
		model.addAttribute("time", new Date());
		return "success";
	}

}
