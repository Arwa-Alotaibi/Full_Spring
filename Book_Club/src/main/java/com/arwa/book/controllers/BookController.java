package com.arwa.book.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.arwa.book.models.User;
import com.arwa.book.services.BookService;
import com.arwa.book.services.UserServices;
import com.arwa.book.models.BookClub;

@Controller
public class BookController {
	@Autowired

private UserServices userServices;
	@Autowired

private BookService bookService;
	
	
	
	@GetMapping("/books")
	public String dashboard(HttpSession session,Model model) {
		Long id = (Long)session.getAttribute("user_id");
		if(id !=null) {
			
			// get user
			User user = userServices.findUserById(id);
			
			// fetch all book
			List<BookClub> Allbooks=bookService.findallbooks();
			
			model.addAttribute("user", user);
			model.addAttribute("Allbooks", Allbooks);

			
			return "dashboard.jsp";
		}
		
		else {
    		return "redirect:/";

		}
	}
	@GetMapping("books/new")
	public String createbook(@ModelAttribute("book") BookClub book,HttpSession session) {
		Long id = (Long)session.getAttribute("user_id");
		if(id !=null) {
			return "addbook.jsp";
		}
		else {
			return "redirect:/";
		}

		
	}
	@PostMapping("books/new")
	public String Creatingbook(@Valid @ModelAttribute("book") BookClub book, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "addbook.jsp";
		}
		else {
			Long id = (Long)session.getAttribute("user_id");
			User user = userServices.findUserById(id);
			bookService.createbook(book, user);
			
			return "redirect:/books";
			

		}
	}
	@GetMapping("/books/{id}")
	public String Showbook(@PathVariable("id") Long id, Model model,HttpSession session) {
		Long user_visite = (Long)session.getAttribute("user_id");

		if(user_visite !=null) {
			model.addAttribute("showbook",bookService.findbookbyid(id) );
			model.addAttribute("user",userServices.findUserById(id));
			return "show.jsp";
		}
		else {
			return "redirect:/";
		}
		
		
	}
	
	@GetMapping("/books/{id}/edit")
	public String editbook(@PathVariable("id") Long id, Model model,HttpSession session,@ModelAttribute("updatebook") BookClub book) {
		Long user_visite = (Long)session.getAttribute("user_id");
		if(user_visite!=null) {
			model.addAttribute("oldbook",bookService.findbookbyid(id) );
			return "edit.jsp";

		}
		else {
			return "redirect:/";
		}

		
	}
	
	@PutMapping("/books/{id}/edit")
	public String editingbook(@PathVariable("id") Long id, Model model,HttpSession session,@ModelAttribute("updatebook") BookClub book,BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		else {
			Long user_id = (Long)session.getAttribute("user_id");
			User user = userServices.findUserById(id);
			bookService.edit(book, user);
			
			return "redirect:/books";


			
			
		}
	}

}