package dziala.mnie.dla.hackathon.patient.domain;

import dziala.mnie.dla.hackathon.shared.enums.Gender;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "patient")
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",
            nullable = false,
            updatable = false)
    private Long id;

    @Column(name = "pesel",
            nullable = false,
            updatable = false,
            length = 11)
    private String pesel;

    @Column(name = "first_name",
            nullable = false)
    private String firstName;

    @Column(name = "last_name",
            nullable = false)
    private String lastName;

    @Column(name = "phone_number",
            nullable = false)
    private String phoneNumber;

    @Column(name = "email",
            nullable = false)
    private String email;

    private Boolean alert;

    @Transient
    private LocalDate dateOfBerth;

    @Transient
    private Integer age;

    @Transient
    private Gender gender;

    public Patient() {

    }

    public Patient(String pesel, String firstName, String lastName, String phoneNumber, String email) {
        //todo: incorrectPeselException FooExceptionSupplier?
        this.pesel = pesel;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.alert = false;
    }

    public Long getId() {
        return id;
    }

    public String getPesel() {
        return pesel;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBerth() {
        int day = Integer.parseInt(pesel.substring(4, 6));
        int month = Integer.parseInt(pesel.substring(2, 4));
        int year = Integer.parseInt(pesel.substring(0, 2));

        if (month >= 1 && month <= 12) {
            year += 1900;

        } else if (month >= 21
                && month <= 32) {
            year += 2000;
            month -= 20;

        } else if (month >= 41
                && month <= 52) {
            year += 2100;
            month -= 40;

        } else if (month >= 61
                && month <= 72) {
            year += 2200;
            month -= 60;

        } else if (month >= 81
                && month <= 92) {
            year += 1800;
            month -= 80;
        }

        return LocalDate.of(year, month, day);
    }

    public Integer getAge() {
        return LocalDate.now().getYear() - getDateOfBerth().getYear();
    }

    public Gender getGender() {
        return Integer.parseInt(pesel.substring(9, 10)) % 2 == 0 ? Gender.FEMALE : Gender.MALE;
    }

    public Boolean getAlert(){
        return alert;
    }

    public void setAlert(Boolean alert) {
        this.alert = alert;
    }
}
