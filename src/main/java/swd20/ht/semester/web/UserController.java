package swd20.ht.semester.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import swd20.ht.semester.domain.SignupForm;
import swd20.ht.semester.domain.User;
import swd20.ht.semester.domain.UserRepository;


@Controller
public class UserController {

	@Autowired
	private UserRepository urepository;
	
	@RequestMapping(value = "signup")
	public String addUser(Model model) {
		model.addAttribute("signupform", new SignupForm());
		return "signup";
	}
	
	@RequestMapping(value = "saveuser", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("signupform") SignupForm signupForm, BindingResult bindingResult) {
		
			if (!bindingResult.hasErrors()) {
				
				if (signupForm.getPassword().equals(signupForm.getPasswordCheck())) {
					
					String pwd = signupForm.getPassword();
					BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
					String hashPwd = bc.encode(pwd);
					
					User newUser = new User();
					newUser.setPasswordHash(hashPwd);
					newUser.setUsername(signupForm.getUsername());
					newUser.setEmail(signupForm.getEmail());
					newUser.setRole("USER");
						
						if (urepository.findByUsername(signupForm.getUsername()) == null) {
							urepository.save(newUser);
						} else {
							bindingResult.rejectValue("username", "err.username", "Username already exists");
							return "signup";
						}
						
				} else {
					bindingResult.rejectValue("passwordCheck", "err.passCheck", "Passwords does not macth");
					return "signup";
				}
				
			} else {
				return "signup";
			}
			
		return "redirect:/login";
		
	}
}

