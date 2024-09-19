

package SEP_Backend.SEP.Services;

import java.util.List;

import SEP_Backend.SEP.Entity.FrontPageEntity;
import SEP_Backend.SEP.Repository.FrontPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FrontPageService {
    @Autowired
    private FrontPageRepository frontPageRepository;

    public List<FrontPageEntity> getAllEntities() {
        
    	return frontPageRepository.findAll();
    }

    public FrontPageEntity getNextEntity(List<FrontPageEntity> allEntities, int displayOrder) {
        for (FrontPageEntity entity : allEntities) {
            if (entity.getDisplayOrder() > displayOrder) {
                return entity;
            }
        }
        
        return allEntities.get(0);
    }
}
