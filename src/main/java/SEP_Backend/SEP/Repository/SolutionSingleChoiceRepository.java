package SEP_Backend.SEP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import SEP_Backend.SEP.Entity.QuestionTbl;
import SEP_Backend.SEP.Entity.SolutionSingleChoiceTbl;

public interface SolutionSingleChoiceRepository extends JpaRepository<SolutionSingleChoiceTbl, Long>{

}
