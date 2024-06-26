package SEP_Backend.SEP.Services;

import SEP_Backend.SEP.Entities.FrontPage;
import SEP_Backend.SEP.Repositories.FrontPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FrontPage_Service {

    @Autowired
    private FrontPageRepository frontPageRepository;

    public List<FrontPage> getAllFrontPages() {
        return frontPageRepository.findAll();
    }

    public Optional<FrontPage> getFrontPageById(Long id) {
        return frontPageRepository.findById(id);
    }

    public FrontPage saveFrontPage(FrontPage frontPage) {
        return frontPageRepository.save(frontPage);
    }

    public void deleteFrontPage(Long id) {
        frontPageRepository.deleteById(id);
    }
}

