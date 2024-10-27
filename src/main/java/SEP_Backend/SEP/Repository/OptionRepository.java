package SEP_Backend.SEP.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import SEP_Backend.SEP.Entity.OptionTbl;




public interface OptionRepository extends JpaRepository<OptionTbl, Long>{
	OptionTbl findByOptionNumber(int optionNumber);
	List<OptionTbl> findByQuestionTbl_quesID(Long quesID);
}
