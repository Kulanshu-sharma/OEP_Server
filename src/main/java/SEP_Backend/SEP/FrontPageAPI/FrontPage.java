package SEP_Backend.SEP.FrontPageAPI;
import jakarta.persistence.*;

@Entity
@Table(name = "frontpage_details")
public class FrontPage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String tagline;

   
    public FrontPage() {}

    public FrontPage(String name, String tagline) {
        this.name = name;
        this.tagline = tagline;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }
}

