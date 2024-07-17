package SEP_Backend.SEP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import SEP_Backend.SEP.Entity.AdminTbl;

public interface AdminRepository extends JpaRepository<AdminTbl, Long> {
    AdminTbl findByEmail(String email);
}
