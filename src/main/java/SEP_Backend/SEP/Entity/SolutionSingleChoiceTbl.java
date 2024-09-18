package SEP_Backend.SEP.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "SOLUTION_SINGLE_CHOICE_TBL")
public class SolutionSingleChoiceTbl {
	
	 
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "QUES_ID")
	 private Long quesId;
		
	 @OneToOne
	 @MapsId
	 @JoinColumn(name = "QUES_ID", referencedColumnName = "QUES_ID")
	 private QuestionTbl questionTbl;

	 @OneToOne
	 @JoinColumn(name = "SOL_OPTION_ID", referencedColumnName = "OPTION_ID")
	 private OptionTbl solutionOptionTbl;

	public Long getQuesId() {
		return quesId;
	}

	public void setQuesId(Long quesId) {
		this.quesId = quesId;
	}

	public QuestionTbl getQuestionTbl() {
		return questionTbl;
	}

	public void setQuestionTbl(QuestionTbl questionTbl) {
		this.questionTbl = questionTbl;
	}

	public OptionTbl getSolutionOptionTbl() {
		return solutionOptionTbl;
	}

	public void setSolutionOptionTbl(OptionTbl solutionOptionTbl) {
		this.solutionOptionTbl = solutionOptionTbl;
	}

}
