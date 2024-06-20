package SEP_Backend.SEP.Repositories;

import SEP_Backend.SEP.Entities.FrontPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrontPageRepository extends JpaRepository<FrontPage, Long> {
   
}
