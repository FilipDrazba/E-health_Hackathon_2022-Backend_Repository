package dziala.mnie.dla.hackathon.patient.repository;

import dziala.mnie.dla.hackathon.patient.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Query("SELECT p FROM patient p WHERE p.id = ?1")
    Optional<Patient> findPatientById(Long id);

    boolean existsPatientByPesel(String pesel);

    Optional<Patient> findByPesel(String pesel);
}
