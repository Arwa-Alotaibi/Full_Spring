package com.arwa.registration.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.arwa.registration.models.LoginUser;
import com.arwa.registration.models.User;
import com.arwa.registration.services.UserServices;



@Controller
public class HomeController {
	private UserServices userServices;
	
	public HomeController(UserServices userServices) {
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
		        return "redirect:/dashboard";
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
        return "redirect:/dashboard";
    }
	
	@GetMapping("/logout")
	public String Logout(HttpSession session) {
    	session.removeAttribute("user_id");
    	return "redirect:/";

    	
	}
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session,Model model) {
		Long id = (Long)session.getAttribute("user_id");
		if(id !=null) {
			User user = userServices.findUserById(id);
			model.addAttribute("user", user);

			
			return "dashboard.jsp";
		}
		
		else {
    		return "redirect:/";

		}
	}


}
