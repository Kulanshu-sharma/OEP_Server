package SEP_Backend.SEP.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import  SEP_Backend.SEP.dtos.Constants;
import SEP_Backend.SEP.Services.ScheduledTestService;
import SEP_Backend.SEP.dtos.Reply;
import SEP_Backend.SEP.dtos.TestDto;

@RestController
@RequestMapping("/secure")
public class ScheduledTestController {

	@Autowired
	 private ScheduledTestService scheduledTestService;
	
	@PostMapping("/scheduleTest")
    public Reply scheduleTest(@RequestAttribute(Constants.TOKEN_DATA) String token, @RequestBody TestDto testdto) {
		Reply reply = new Reply(token);
		String username = (String) reply.getAttribute(Constants.USER_ID);
	    return scheduledTestService.executeTest(testdto,username);    
	}
}
