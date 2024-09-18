package SEP_Backend.SEP.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import SEP_Backend.SEP.Services.QuestionService;
import SEP_Backend.SEP.dtos.Constants;
import SEP_Backend.SEP.dtos.QuestionDto;
import SEP_Backend.SEP.dtos.Reply;

@RestController
@RequestMapping("/secure")
public class QuestionController {
	
	@Autowired
    private QuestionService questionService;

    @PostMapping("/addQuestion")
    public Reply addQuestion(@RequestAttribute(Constants.TOKEN_DATA) String token ,@RequestBody QuestionDto questionDto) {
    	return questionService.addQuestion(questionDto);
    }
    
}
