package dziala.mnie.dla.hackathon.doctor.repository;

import dziala.mnie.dla.hackathon.doctor.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    @Query("SELECT p FROM doctor p WHERE p.id = ?1")
    Optional<Doctor> findDoctorById(Long id);

}


