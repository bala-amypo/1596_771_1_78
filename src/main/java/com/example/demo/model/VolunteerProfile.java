@Entity
public class VolunteerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long volunteerId;

    public Long getId() {
        return id;
    }

    public Long getVolunteerId() {
        return volunteerId;
    }
}
