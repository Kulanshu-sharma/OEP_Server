package SEP_Backend.SEP.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import SEP_Backend.SEP.Entity.AdminTbl;
import SEP_Backend.SEP.Entity.TestTbl;

public interface TestRepository extends JpaRepository<TestTbl, Long>{
	List<TestTbl> findByAdminTblEmail(String email);
}
