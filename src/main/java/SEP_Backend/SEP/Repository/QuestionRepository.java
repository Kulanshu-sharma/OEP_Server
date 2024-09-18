package SEP_Backend.SEP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import SEP_Backend.SEP.Entity.QuestionTbl;


public interface QuestionRepository extends JpaRepository<QuestionTbl, Long> {
}
