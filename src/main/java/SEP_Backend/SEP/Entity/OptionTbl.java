package SEP_Backend.SEP.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "OPTION_TBL")
public class OptionTbl {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OPTION_ID",insertable=false, updatable=false)
    private Long optionID;
	
	@ManyToOne
    @JoinColumn(name = "QUES_ID")
    private QuestionTbl questionTbl;
	
	@Column(name = "OPTION_NUMBER")
    private int optionNumber;
	
	@Column(name = "OPTION_CONTENT")
    private String optionContent;
	
	@OneToOne(mappedBy = "solutionOptionTbl")
    private SolutionSingleChoiceTbl solutionSingleChoiceTbl;
	
	
	public Long getOptionID() {
		return optionID;
	}

	public void setOptionID(Long optionID) {
		this.optionID = optionID;
	}

	public QuestionTbl getQuestionTbl() {
		return questionTbl;
	}

	public void setQuestionTbl(QuestionTbl questionTbl) {
		this.questionTbl = questionTbl;
	}

	public int getOptionNumber() {
		return optionNumber;
	}

	public void setOptionNumber(int optionNumber) {
		this.optionNumber = optionNumber;
	}

	public String getOptionContent() {
		return optionContent;
	}

	public void setOptionContent(String optionContent) {
		this.optionContent = optionContent;
	}

	public SolutionSingleChoiceTbl getSolutionSingleChoiceTbl() {
		return solutionSingleChoiceTbl;
	}

	public void setSolutionSingleChoiceTbl(SolutionSingleChoiceTbl solutionSingleChoiceTbl) {
		this.solutionSingleChoiceTbl = solutionSingleChoiceTbl;
	}

}
