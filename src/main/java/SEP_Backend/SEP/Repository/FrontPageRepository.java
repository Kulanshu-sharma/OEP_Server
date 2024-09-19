package SEP_Backend.SEP.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import SEP_Backend.SEP.Entity.FrontPageEntity;

public interface FrontPageRepository extends JpaRepository<FrontPageEntity, Long> {
    List<FrontPageEntity> findByDisplayOrderGreaterThanOrderByDisplayOrderAsc(int displayOrder);
}
