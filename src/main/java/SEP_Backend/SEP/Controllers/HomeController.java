package SEP_Backend.SEP.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;

import SEP_Backend.SEP.dtos.Constants;
import SEP_Backend.SEP.dtos.Reply;
import SEP_Backend.SEP.Entity.FrontPageEntity;
import SEP_Backend.SEP.Services.FrontPageService;
import jakarta.servlet.http.HttpSession;

@RestController
public class HomeController {
	
	        @Autowired
	        private FrontPageService frontPageService;

	        @GetMapping("/home")
	        public Reply getEntity(HttpSession session) {
	            int displayOrder = 0;
	            if (session.getAttribute("displayOrder")!= null) {
	                displayOrder = (int) session.getAttribute("displayOrder");
	            }
	            
	            List<FrontPageEntity> allEntities = frontPageService.getAllEntities();
	            FrontPageEntity nextEntity = frontPageService.getNextEntity(allEntities, displayOrder);
	            
	            session.setAttribute("displayOrder", nextEntity.getDisplayOrder());
	            
	            Reply reply = new Reply();
	            reply.setData(nextEntity);
	            return reply;
	        }

	        @GetMapping("/secure/home")
	        public Reply secureHome(@RequestAttribute(Constants.TOKEN_DATA) String token) {
	            Reply reply = new Reply(token);
	            reply.setAttribute("UserName","Genius");
	            return reply;
	        }
	 }


	
	