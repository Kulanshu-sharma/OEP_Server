package SEP_Backend.SEP.FrontPageAPI;

import SEP_Backend.SEP.FrontPageAPI.FrontPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrontPageRepository extends JpaRepository<FrontPage, Long> {
   
}
