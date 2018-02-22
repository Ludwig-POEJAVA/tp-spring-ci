package poe.spring.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import poe.spring.dataTransferObject.LoginForm;
import poe.spring.service.UserManagerService;

@Controller
@RequestMapping("/signup")
public class SignupPageController
{

	@Autowired
	UserManagerService userManagerService;

	@GetMapping
	public String signup(Model model)
	{
		model.addAttribute("title", "Account creation");
		model.addAttribute("message", "Welcome, create an account");
		model.addAttribute("time", new Date());
		return "signup";
	}

	@PostMapping
	public String saveUser(@Valid LoginForm form, BindingResult bindingResult, RedirectAttributes attr)
	{
		String nextPage = "forward:/signup";
		String username = form.getUsername();
		String password = form.getPassword();

		if (bindingResult.hasErrors())
			return nextPage;

		attr.addAttribute("usernameCreated", username);
		try
		{
			this.userManagerService.signup(username, password);
			nextPage = "redirect:/signup/success";
		}
		//TODO : plein d'exceptions et pleins de messages d'erreurs
		catch (Exception e)
		{
			attr.addAttribute("erreur", "j'ai glissé chef");
		}
		return nextPage;
	}

	@GetMapping("/success")
	public String signupSucces(@RequestParam(name = "usernameCreated") String username, Model model)
	{
		model.addAttribute("title", "Account created");
		model.addAttribute("username", username);
		model.addAttribute("time", new Date());
		return "success";
	}

}
