package SEP_Backend.SEP.Controllers;

import java.util.Dictionary;
//import java.util.List;
import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SEP_Backend.SEP.Services.DashboardService;
import SEP_Backend.SEP.dtos.Constants;
import SEP_Backend.SEP.dtos.Reply;


@RestController
@RequestMapping("/secure")
public class DashbordController {
	@Autowired
	private DashboardService dashboardService;
	
	@PostMapping("/dashboardData")
    public Reply dashboardData(@RequestAttribute(Constants.TOKEN_DATA) String token) {
    	Reply reply = new Reply(token);
        String username = (String) reply.getAttribute(Constants.USER_ID);
        
        Dictionary<String, String> adminDetails = dashboardService.dashboardAdminData(username);
        Dictionary<String, Integer> testDetails = dashboardService.dashboardData(username);
        Dictionary<String,Dictionary> Data = new Hashtable<>();
        Data.put("Admin_Details", adminDetails );
        Data.put("Test_Details", testDetails );
        
        if(Data != null) {
    	reply.setData(Data);
    	reply.setErrFlag(false);
    	reply.setMessage("Displayed Successfully!!!");
        } 
        return reply;
	}

}
