package SEP_Backend.SEP.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;

import SEP_Backend.SEP.dtos.Constants;
import SEP_Backend.SEP.dtos.Reply;


@RestController
public class HomeController {
	
	@GetMapping("/home")
	public Reply retriveLimitConfiguration() {
		return new Reply();
	}
	
	@GetMapping("/secure/home")
	public Reply secureHome(@RequestAttribute(Constants.TOKEN_DATA) String token) {
		Reply reply = new Reply(token);
		reply.setAttribute("UserName","Genius");
		return reply;
	}
	
}
