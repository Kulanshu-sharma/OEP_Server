package SEP_Backend.SEP.Entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;
@Entity
@Table(name = "SOLUTION_MULTIPLE_CHOICE_TBL")

public class SolutionMultipleChoiceTbl {
	
	@Embeddable
    public static class CompositeKey implements Serializable {
		
		@ManyToOne
		@JoinColumn(name = "QUES_ID")
	    private QuestionTbl questionTbl;

	    @ManyToOne
	    @JoinColumn(name = "OPTION_ID")
	    private OptionTbl optionTbl;

		public CompositeKey() {}

		public CompositeKey(QuestionTbl questionTbl, OptionTbl optionTbl) {
			super();
			this.questionTbl = questionTbl;
			this.optionTbl = optionTbl;
		}

		
		public QuestionTbl getQuestionTbl() {
			return questionTbl;
		}

		public void setQuestionTbl(QuestionTbl questionTbl) {
			this.questionTbl = questionTbl;
		}

		public OptionTbl getOptionTbl() {
			return optionTbl;
		}

		public void setOptionTbl(OptionTbl optionTbl) {
			this.optionTbl = optionTbl;
		}
		
		@Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CompositeKey that = (CompositeKey) o;
            return Objects.equals(questionTbl, that.questionTbl) &&
                   Objects.equals(optionTbl, that.optionTbl);
        }

        @Override
        public int hashCode() {
            return Objects.hash(questionTbl, optionTbl);
        }
	}
	

	 @EmbeddedId
	    private CompositeKey id;


	public CompositeKey getId() {
		return id;
	}


	public void setId(CompositeKey id) {
		this.id = id;
	}

}
