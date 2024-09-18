package SEP_Backend.SEP.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "SOLUTION_DESCRIPTION_TBL")

public class SolutionDescriptionTbl {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QUES_ID")
    private Long quesId;
	
	@OneToOne
    @MapsId
    @JoinColumn(name = "QUES_ID")
    private QuestionTbl questionTbl;

    @Column(name = "DESCRIPTION")
    private String description;

	public QuestionTbl getQuestionTbl() {
		return questionTbl;
	}

	public void setQuestionTbl(QuestionTbl questionTbl) {
		this.questionTbl = questionTbl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getQuesId() {
		return quesId;
	}

	public void setQuesId(Long quesId) {
		this.quesId = quesId;
	}

}
