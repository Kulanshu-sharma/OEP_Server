package SEP_Backend.SEP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import SEP_Backend.SEP.Entity.QuestionTbl;
import SEP_Backend.SEP.Entity.SolutionMultipleChoiceTbl;


public interface SolutionMultipleChoiceRepository extends JpaRepository<SolutionMultipleChoiceTbl, SolutionMultipleChoiceTbl.CompositeKey>{

}
