package dziala.mnie.dla.hackathon.medicalReport.domain;

import dziala.mnie.dla.hackathon.patient.domain.Patient;
import dziala.mnie.dla.hackathon.shared.enums.Gender;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "medicalReport")
@Table(name = "medicalReports")
public class MedicalReport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",
            nullable = false,
            updatable = false)
    private Long id;

    private LocalDate date;

    @ManyToOne
    private Patient patient;

    @Transient
    private Integer patientAge;

    @Transient
    private Gender patientGender;

    private Float weight;

    private Float SPo2;

    private Integer pulse;

    private Integer diastolicPressure;

    private Integer systolicPressure;

    private Integer painInChest;

    private String symptoms;

    public MedicalReport(Patient patient,
                         Float weight,
                         Float SPo2,
                         Integer pulse,
                         Integer diastolicPressure,
                         Integer systolicPressure,
                         Integer painInChest,
                         String symptoms) {
        this.date = LocalDate.now();
        this.patient = patient;//???
        this.patientAge = patient.getAge();
        this.patientGender = patient.getGender();
        this.weight = weight;
        this.SPo2 = SPo2;
        this.pulse = pulse;
        this.diastolicPressure = diastolicPressure;
        this.systolicPressure = systolicPressure;
        this.painInChest = painInChest;
        this.symptoms = symptoms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Integer getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(Integer patientAge) {
        this.patientAge = patientAge;
    }

    public Gender getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(Gender patientGender) {
        this.patientGender = patientGender;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getSPo2() {
        return SPo2;
    }

    public void setSPo2(Float SPo2) {
        this.SPo2 = SPo2;
    }

    public Integer getPulse() {
        return pulse;
    }

    public void setPulse(Integer pulse) {
        this.pulse = pulse;
    }

    public Integer getDiastolicPressure() {
        return diastolicPressure;
    }

    public void setDiastolicPressure(Integer diastolicPressure) {
        this.diastolicPressure = diastolicPressure;
    }

    public Integer getSystolicPressure() {
        return systolicPressure;
    }

    public void setSystolicPressure(Integer systolicPressure) {
        this.systolicPressure = systolicPressure;
    }

    public Integer getPainInChest() {
        return painInChest;
    }

    public void setPainInChest(Integer painInChest) {
        this.painInChest = painInChest;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }
}
