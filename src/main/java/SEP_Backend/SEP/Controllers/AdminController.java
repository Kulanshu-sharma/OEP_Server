package SEP_Backend.SEP.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import SEP_Backend.SEP.Entity.AdminTbl;
import SEP_Backend.SEP.Entity.TestTbl;
import SEP_Backend.SEP.Services.AdminService;
import SEP_Backend.SEP.dtos.Constants;
import SEP_Backend.SEP.dtos.Reply;
import SEP_Backend.SEP.dtos.TestDto;
import SEP_Backend.SEP.dtos.AdminDto;
import SEP_Backend.SEP.dtos.ChangePasswordDto;

@RestController
@RequestMapping("/secure")
public class AdminController {
	
	    private AdminService adminService;
	    @Autowired
	    public AdminController(AdminService adminService) {
	        this.adminService = adminService;
	    }
	    
	    @PostMapping("/adminRegister")
	    public Reply registerUser(@RequestAttribute(Constants.TOKEN_DATA) String token , @RequestBody AdminDto admindto) {
	    	Reply reply = new Reply(token);
	    	try {
	    		adminService.registerUser(admindto,reply);
	    		if(reply.isErrFlag()){
	    			reply.setAllowed(false);
	    			return reply;
	    		}
	            reply.setMessage("Successfully Registered!!!");
	            reply.setErrFlag(false);
	            return reply;
	        } catch (Exception e) {
	        	reply.setMessage("Admin is Not Registered!!!");
	            reply.setErrFlag(true);
	            reply.setAllowed(false);
	            return reply;
	        }
	    }


	    @PostMapping("/adminLogin")
	    public Reply secureLogin(@RequestAttribute(Constants.TOKEN_DATA) String token , @RequestBody AdminDto admindto) {
			Reply reply = new Reply(token);
			String email = admindto.getEmailID();
			String password = admindto.getPassword();
            AdminTbl login = adminService.findByEmail(email);
	        if (login != null && login.getPassword().equals(password)) {
	            reply.setErrFlag(false);
	            reply.setMessage("Login Successfully!!!");
	            reply.setAttribute(Constants.USER_ID, email);
	        } else {
	            reply.setErrFlag(true);
	            reply.setErrMsg("Login Failed!!!");
	            reply.setAllowed(false);
	        }
	        return reply;
	    }
	    
	    @PutMapping("/adminSettings")
	    public Reply adminSettings(@RequestAttribute(Constants.TOKEN_DATA) String token , @RequestBody TestDto testdto) {
			Reply reply = new Reply(token);
			String username = (String) reply.getAttribute(Constants.USER_ID);
			TestTbl settings = adminService.adminSettings(testdto,username);
			if(settings != null) {
				reply.setErrFlag(false);
				reply.setMessage("Upadated Successfully!!!");
				return reply;
			}else {
				reply.setErrFlag(true);
				reply.setErrMsg("Can't Update the Settings");
				reply.setAllowed(false); 
			    return reply;
			}
	    }
	    

	    @PutMapping("/changePassword")
	    public Reply changePassword(@RequestAttribute(Constants.TOKEN_DATA) String token , @RequestBody ChangePasswordDto changePasswordDto) {
			Reply reply = new Reply(token);
			String username = (String) reply.getAttribute(Constants.USER_ID);
			boolean passwordUpadated = adminService.changePassword(changePasswordDto , username);
			if(passwordUpadated) {
				reply.setErrFlag(false);
				reply.setMessage("Password Upadated Successfully!!!");
				return reply;
			}else {
				reply.setErrFlag(true);
				reply.setErrMsg("Can't Update the Password");
				reply.setAllowed(false); 
			    return reply;
			}
	    }
}
