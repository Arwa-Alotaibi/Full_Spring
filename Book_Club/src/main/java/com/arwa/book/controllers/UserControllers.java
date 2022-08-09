package com.arwa.book.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.arwa.book.models.LoginUser;
import com.arwa.book.models.User;
import com.arwa.book.services.UserServices;




@Controller
public class UserControllers {
	private UserServices userServices;
	
	public UserControllers(UserServices userServices) {
		this.userServices = userServices;
	}
	
	@GetMapping("/")
	public String index(Model model) {
		 model.addAttribute("newUser", new User());
	        model.addAttribute("newLogin", new LoginUser());
	        return "index.jsp";
	}
	
	
	@PostMapping("/register")
	public String index(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
		
		userServices.regirster(newUser,result);
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
		}
		else {
			 session.setAttribute("user_id", newUser.getId());
		        return "redirect:/books";
		}
	}
	@PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        User user = userServices.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        session.setAttribute("user_id", user.getId());
        return "redirect:/books";
    }
	
	@GetMapping("/logout")
	public String Logout(HttpSession session) {
    	session.removeAttribute("user_id");
    	return "redirect:/";

    	
	}
	
	
	
	
	
}