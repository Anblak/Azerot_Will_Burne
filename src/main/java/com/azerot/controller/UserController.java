package com.azerot.controller;

import java.security.Principal;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.azerot.dto.DtoUtilMapper;
import com.azerot.entity.User;
import com.azerot.service.MailSenderService;
import com.azerot.service.UserService;
import com.azerot.validator.UserValidationMessages;



@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired 
	private MailSenderService mailSenderService;

	@RequestMapping("/registration")
	public String newUser(Model model) {
//		model.addAttribute("userDTOs", DtoUtilMapper.userTOUserDTOs(userService.findAll()));
//		model.addAttribute("user", new User());
		return "views-security-registration";
	}

	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute User user, Model model) {
//		model.addAttribute("user", new User());
		
	       String uuid = UUID.randomUUID().toString();

	        user.setUuid(uuid);
		try {
			userService.save(user);
		} catch (Exception e) {
			if(e.getMessage().equals(UserValidationMessages.EMPTY_USERNAME_FIELD)||
					e.getMessage().equals(UserValidationMessages.NAME_ALREADY_EXIST)){
				model.addAttribute("usernameException", e.getMessage());
			}else if(e.getMessage().equals(UserValidationMessages.EMPTY_EMAIl_FIELD )||
					e.getMessage().equals(UserValidationMessages.EMAIL_ALREADY_EXIST)){
				model.addAttribute("emailException", e.getMessage());
			}else if(e.getMessage().equals(UserValidationMessages.EMPTY_PASSWORD_FIELD)){
				model.addAttribute("passwordException", e.getMessage());
			}
			return "views-security-registration";
		}
		
		 String theme = "thank's for registration";
	        String mailBody =
	                "hi, if u confirm registration click on link    http://localhost:8080/AZEROT_WIIL_BURNE/confirm/" + uuid;

	        mailSenderService.sendMail(theme, mailBody, user.getEmail());
		
		return "redirect:/";
	}
	
	
	   @RequestMapping(value = "/confirm/{uuid}", method = RequestMethod.GET)
	    public String confirm(@PathVariable String uuid) {

	        User user = userService.findByUUID(uuid);
	        user.setEnabled(true);

	        userService.update(user);

	        return "redirect:/";
	    }

	
	@RequestMapping("/profile")
	public String profile(Principal principal, Model model) {

		User user =userService.findOne(Integer.parseInt(principal.getName()));
		
		
		model.addAttribute("user",user);
		

		return "views-security-profile";
	}
	
	
	
	@RequestMapping(value = "/saveImage", method = RequestMethod.POST)
	public String saveImage(Principal principal,@RequestParam MultipartFile image){
		userService.saveImage(principal, image);

		return "redirect:/profile";
	}
	
	
	
	
    @RequestMapping("/updateProfile")
    public String updateProfile(Principal principal, Model model){
        User user = userService.findOne(Integer.parseInt(principal.getName()));
        model.addAttribute("user", user);
        return "views-security-updateProfile";
    }

    @RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
    public String updateProfile(Principal principal, @RequestParam String name,
                                @RequestParam String email,
                                @RequestParam String phone,
                                @RequestParam String password){
        User user = userService.findOne(Integer.parseInt(principal.getName()));

        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        userService.updateProfile(user);

        return "redirect:/profile";
    }
	
}
