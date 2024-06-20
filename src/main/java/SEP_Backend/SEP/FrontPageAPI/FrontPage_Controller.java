package SEP_Backend.SEP.FrontPageAPI;

import SEP_Backend.SEP.FrontPageAPI.FrontPage;
import SEP_Backend.SEP.FrontPageAPI.FrontPage_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/frontpages")
public class FrontPage_Controller {

    @Autowired
    private FrontPage_Service frontPageService;

    @GetMapping
    public List<FrontPage> getAllFrontPages() {
        return frontPageService.getAllFrontPages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FrontPage> getFrontPageById(@PathVariable Long id) {
        Optional<FrontPage> frontPage = frontPageService.getFrontPageById(id);
        return frontPage.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FrontPage> createFrontPage(@RequestBody FrontPage frontPage) {
        FrontPage createdFrontPage = frontPageService.saveFrontPage(frontPage);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFrontPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FrontPage> updateFrontPage(@PathVariable Long id, @RequestBody FrontPage frontPage) {
        if (!frontPageService.getFrontPageById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        frontPage.setId(id);
        FrontPage updatedFrontPage = frontPageService.saveFrontPage(frontPage);
        return ResponseEntity.ok(updatedFrontPage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFrontPage(@PathVariable Long id) {
        if (!frontPageService.getFrontPageById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        frontPageService.deleteFrontPage(id);
        return ResponseEntity.noContent().build();
    }
}


