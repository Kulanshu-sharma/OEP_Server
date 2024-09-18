package SEP_Backend.SEP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import SEP_Backend.SEP.Entity.QuestionTbl;
import SEP_Backend.SEP.Entity.SolutionDescriptionTbl;

public interface SolutionDescriptionRepository extends JpaRepository<SolutionDescriptionTbl, Long>{

}
