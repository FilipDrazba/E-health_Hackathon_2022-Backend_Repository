package dziala.mnie.dla.hackathon.medicalReport.repository;

import dziala.mnie.dla.hackathon.medicalReport.domain.MedicalReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MedicalReportRepository extends JpaRepository<MedicalReport, Long> {

    @Query("SELECT p FROM medicalReport p WHERE p.id = ?1")
    Optional<MedicalReport> findMedicalReportById(Long id);

}
