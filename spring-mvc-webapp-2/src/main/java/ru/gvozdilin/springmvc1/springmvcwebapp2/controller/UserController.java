package ru.gvozdilin.springmvc1.springmvcwebapp2.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ru.gvozdilin.springmvc1.springmvcwebapp2.model.User;
import ru.gvozdilin.springmvc1.springmvcwebapp2.model.UserForm;
import ru.gvozdilin.springmvc1.springmvcwebapp2.service.UserService;


@Controller
public class UserController {
	
	
	private final UserService service;
	
	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}
	
	@GetMapping("/users")
	public String findAll(Model model, @RequestParam(defaultValue="0") int page) {
		
		model.addAttribute("users", service.findAll(PageRequest.of(page, 4)));
		model.addAttribute("currentPage", page);
		return "user-list";
	}

	@GetMapping("/user-create")
	public String createUserForm(User user) {
		return "user-create";
	}
	
	@PostMapping("/user-create")
	public String createUser(User user){
		service.saveUser(user);
		return "redirect:/users";
	}
	
	@GetMapping("/user-delete/{id}")
	public String deleteUser(@PathVariable("id") Long id) {
		service.deleteById(id);
		return "redirect:/users";
	}
	
	
	@GetMapping("/user-update/{id}")
	public String updateUserForm(@PathVariable("id") Long id, Model model) {
		User user = service.findById(id);
		model.addAttribute("user", user);
		return "user-update";
	}
	
	@PostMapping("/user-update")
	public String udateUser(User user) {
		service.saveUser(user);
		return "redirect:/users";
	}
	
	@GetMapping("/user-difference")
	public String calculateDifferenceForm(Model model) {
		 model.addAttribute("users", service.findAllUsers());	
		 model.addAttribute("formData", new UserForm());
		 return "user-difference";
	}

	
	@PostMapping("/calculate_years")
	 @ResponseBody
	 public String calculateDifferenceForm(HttpServletRequest request, Model model){
		
		String first = request.getParameter("user1");
		String second = request.getParameter("user2");
		
		User user1 = service.findById(Long.parseLong(first));
		User user2 = service.findById(Long.parseLong(second));
		model.addAttribute("kek", service.calculateDaysDifference(user1, user2));
		
		return service.calculateDaysDifference(user1, user2);
	}
}
