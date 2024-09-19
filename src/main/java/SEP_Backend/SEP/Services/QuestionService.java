package SEP_Backend.SEP.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SEP_Backend.SEP.Entity.OptionTbl;
import SEP_Backend.SEP.Entity.QuestionTbl;
import SEP_Backend.SEP.Entity.TestTbl;
import SEP_Backend.SEP.Entity.SolutionDescriptionTbl;
import SEP_Backend.SEP.Entity.SolutionMultipleChoiceTbl;
import SEP_Backend.SEP.Entity.SolutionSingleChoiceTbl;
import SEP_Backend.SEP.Repository.OptionRepository;
import SEP_Backend.SEP.Repository.QuestionRepository;
import SEP_Backend.SEP.Repository.SolutionDescriptionRepository;
import SEP_Backend.SEP.Repository.SolutionMultipleChoiceRepository;
import SEP_Backend.SEP.Repository.SolutionSingleChoiceRepository;
import SEP_Backend.SEP.Repository.TestRepository;
import SEP_Backend.SEP.dtos.OptionDto;
import SEP_Backend.SEP.dtos.QuestionDto;
import SEP_Backend.SEP.dtos.Reply;

@Service
public class QuestionService {
	
	@Autowired
    private TestRepository testRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private OptionRepository optionRepository;

    @Autowired
    private SolutionSingleChoiceRepository solutionSingleChoiceRepository;

    @Autowired
    private SolutionDescriptionRepository solutionDescriptionRepository;

    @Autowired
    private SolutionMultipleChoiceRepository solutionMultipleChoiceRepository;

    
    public Reply addQuestion(QuestionDto questionDto) {
        Reply reply = new Reply();
        try {
        	TestTbl test = testRepository.findById(questionDto.getTestId()).orElseThrow(() -> new IllegalArgumentException("Invalid test ID"));
            QuestionTbl question = new QuestionTbl();
            question.setTestTbl(test);
            question.setQuestype(questionDto.getQuesType());
            question.setQuesdes(questionDto.getQuesDescription());
            question.setMarks(questionDto.getMarks());
            question.setOptioncount(questionDto.getOptionsCount());
            question = questionRepository.save(question);

            
            if (questionDto.getOptionsCount() != 0) {
            	for (OptionDto optionDto : questionDto.getOptions()) {
            		OptionTbl option = new OptionTbl();
            		option.setQuestionTbl(question);
            		option.setOptionID(optionDto.getOptionID());
            		option.setOptionContent(optionDto.getOptionDes());
            		optionRepository.save(option);
            	}
            
            }

          
            switch (questionDto.getQuesType()) {
            
                case 0: 
                	SolutionDescriptionTbl description = new SolutionDescriptionTbl();
                	description.setQuestionTbl(question);
                	description.setDescription(questionDto.getAnsDescription());
                	solutionDescriptionRepository.save(description);
                break;
                
                case 1: 
                    SolutionSingleChoiceTbl singleChoice = new SolutionSingleChoiceTbl();
                    singleChoice.setQuestionTbl(question);
                    OptionTbl correctOption = optionRepository.findById( (long) questionDto.getCorrectOptionId()).orElseThrow(() -> new IllegalArgumentException("Invalid option ID"));
                    singleChoice.setSolutionOptionTbl(correctOption);
                    solutionSingleChoiceRepository.save(singleChoice);
                break;   
                
                case 2: 
                	for (Long optionId : questionDto.getCorrectOptionIds()) {
                    OptionTbl option = optionRepository.findById(optionId).orElseThrow(() -> new IllegalArgumentException("Invalid option ID"));
                    SolutionMultipleChoiceTbl.CompositeKey compositeKey = new SolutionMultipleChoiceTbl.CompositeKey();
                    compositeKey.setQuestionTbl(question);
                    compositeKey.setOptionTbl(option);
                    SolutionMultipleChoiceTbl multipleChoice = new SolutionMultipleChoiceTbl();
                    multipleChoice.setId(compositeKey);
                    solutionMultipleChoiceRepository.save(multipleChoice);
                    }
                 break;
                 default:
                    throw new IllegalArgumentException("Invalid question type");
            }

            reply.setMessage("Question added successfully!");
            reply.setErrFlag(false);
            
        } catch (Exception e) {
            reply.setErrMsg("Error adding question: " + e.getMessage());
            reply.setErrFlag(true);
            reply.setAllowed(false);
        }
        return reply;
    }
}