package SEP_Backend.SEP.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "QUESTION_TBL")
public class QuestionTbl {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QUES_ID")
    private Long quesID;
	
	@ManyToOne
    @JoinColumn(name = "TEST_ID", referencedColumnName = "TEST_ID")
    private TestTbl testTbl;
	
	@Column(name = "QUES_TYPE")
    private int questype;
	
	@Column(name = "QUES_DES")
    private String quesdes;
	
	@Column(name = "MARKS")
    private int marks;
	
	@Column(name = "OPTION_COUNT")
    private int optioncount;

	@OneToMany(mappedBy = "questionTbl")
	@Column(name="OPTION_TBL")
	private List<OptionTbl> options = new ArrayList<>();
	
	@OneToOne(mappedBy = "questionTbl")
    private SolutionSingleChoiceTbl solutionSingleChoiceTbl;
	
	@OneToOne(mappedBy = "questionTbl")
    private SolutionDescriptionTbl solutionDescriptionTbl;
	
   public Long getQuesID() {
		return quesID;
	}

	public void setQuesID(Long quesID) {
		this.quesID = quesID;
	}

	public TestTbl getTestTbl() {
		return testTbl;
	}

	public void setTestTbl(TestTbl testTbl) {
		this.testTbl = testTbl;
	}

	public int getQuestype() {
		return questype;
	}

	public void setQuestype(int questype) {
		this.questype = questype;
	}

	public String getQuesdes() {
		return quesdes;
	}

	public void setQuesdes(String quesdes) {
		this.quesdes = quesdes;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public int getOptioncount() {
		return optioncount;
	}

	public void setOptioncount(int optioncount) {
		this.optioncount = optioncount;
	}

	public List<OptionTbl> getOptions() {
		return options;
	}

	public void setOptions(List<OptionTbl> options) {
		this.options = options;
	}

	public SolutionSingleChoiceTbl getSolutionSingleChoiceTbl() {
		return solutionSingleChoiceTbl;
	}

	public void setSolutionSingleChoiceTbl(SolutionSingleChoiceTbl solutionSingleChoiceTbl) {
		this.solutionSingleChoiceTbl = solutionSingleChoiceTbl;
	}

	public SolutionDescriptionTbl getSolutionDescriptionTbl() {
		return solutionDescriptionTbl;
	}

	public void setSolutionDescriptionTbl(SolutionDescriptionTbl solutionDescriptionTbl) {
		this.solutionDescriptionTbl = solutionDescriptionTbl;
	}

}
