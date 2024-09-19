package SEP_Backend.SEP.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import SEP_Backend.SEP.Services.TestService;
import SEP_Backend.SEP.dtos.Constants;
import SEP_Backend.SEP.dtos.Reply;
import SEP_Backend.SEP.dtos.TestDto;

@RestController
@RequestMapping("/secure")
public class TestController {
	 private TestService testService;
	    @Autowired
	    public TestController(TestService testService) {
	    	this.testService = testService;
	    }
	    
	    @PostMapping("/testDisplay")
	    public Reply getTestsForLoggedInAdmin(@RequestAttribute(Constants.TOKEN_DATA) String token) {
	    	Reply reply = new Reply(token);
	        String username = (String) reply.getAttribute(Constants.USER_ID);
	        List<TestDto> testDtoList = testService.getAllTestsForAdmin(username);
	        if(testDtoList != null){
	        	reply.setData(testDtoList);
	        	reply.setErrFlag(false);
	        	reply.setMessage("Displayed Successfully!!!");
	        } else {
	        	reply.setErrFlag(true);
	            reply.setErrMsg("Can't Display, Username not founds!!!");
	            reply.setAllowed(false);
	        }
	        return reply;
	    }
}
