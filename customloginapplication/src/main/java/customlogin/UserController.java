//package customlogin;
//
//import java.security.Principal;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import customlogin.dto.UserDto;
//import customlogin.model.User;
//import customlogin.service.UserService;
//
//
//@Controller
//public class UserController {
//
//	@Autowired
//	private UserDetailsService userDetailsService;
//
//	private UserService userService;
//	public UserController(UserService userService) {
//
//		this.userService = userService;
//	}
//
//	@GetMapping("/home")
//	public String home(Model model, Principal principal) {
//		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
//		List<User> allUsers = userService.findAll();
//
//
//		model.addAttribute("userdetail", userDetails);
//		model.addAttribute("allUsers", allUsers);
//
//		allUsers.removeIf(user -> user.getUsername().equals(userDetails.getUsername()));
//
//		return "home";
//	}
//
//	@GetMapping("/login")
//	public String login(Model model, UserDto userDto) {
//
//		model.addAttribute("user", userDto);
//		return "login";
//	}
//
//	@GetMapping("/register")
//	public String register(Model model, UserDto userDto) {
//		model.addAttribute("user", userDto);
//		return "register";
//	}
//
//	@PostMapping("/register")
//	public String registerSave(@ModelAttribute("user") UserDto userDto, Model model) {
//		User user = userService.findByUsername(userDto.getUsername());
//		if(user !=null) {
//			model.addAttribute("userexist", user);
//			return "register";
//		}
//		userService.save(userDto);
//		return "redirect:/register?success";
//	}
//
//}
package customlogin;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import customlogin.dto.UserDto;
import customlogin.model.User;
import customlogin.service.UserService;


@Controller
public class UserController {

	@Autowired
	private UserDetailsService userDetailsService;

	private UserService userService;
	public UserController(UserService userService) {

		this.userService = userService;
	}

	@GetMapping("/home")
	public String home(Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		List<User> allUsers = userService.findAll();


		model.addAttribute("userdetail", userDetails);
		model.addAttribute("allUsers", allUsers);

		allUsers.removeIf(user -> user.getUsername().equals(userDetails.getUsername()));

		return "home";
	}

	@GetMapping("/login")
	public String login(Model model, UserDto userDto) {

		model.addAttribute("user", userDto);
		return "login";
	}

	@GetMapping("/register")
	public String register(Model model, UserDto userDto) {
		model.addAttribute("user", userDto);
		return "register";
	}

	@PostMapping("/register")
	public String registerSave(@ModelAttribute("user") UserDto userDto, Model model) {
		User user = userService.findByUsername(userDto.getUsername());
		if(user !=null) {
			model.addAttribute("userexist", user);
			return "register";
		}
		userService.save(userDto);
		return "redirect:/register?success";
	}

}
