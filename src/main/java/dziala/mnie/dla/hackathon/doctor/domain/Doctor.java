package dziala.mnie.dla.hackathon.doctor.domain;

import dziala.mnie.dla.hackathon.patient.domain.Patient;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "doctor")
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",
            nullable = false,
            updatable = false)
    private Long id;

    @Column(name = "first_name",
            nullable = false)
    private String firstName;

    @Column(name = "last_name",
            nullable = false)
    private String lastName;

    @OneToMany
    @JoinColumn(name = "patient")
    private Set<Patient> petients;

    public Doctor() {
    }

    public Doctor(String firstName,
                  String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
