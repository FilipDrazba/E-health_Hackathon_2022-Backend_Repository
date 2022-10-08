package dziala.mnie.dla.hackathon.doctor.service;

import dziala.mnie.dla.hackathon.doctor.api.request.DoctorRequest;
import dziala.mnie.dla.hackathon.doctor.api.request.UpdateDoctorRequest;
import dziala.mnie.dla.hackathon.doctor.api.response.DoctorResponse;
import dziala.mnie.dla.hackathon.doctor.domain.Doctor;
import dziala.mnie.dla.hackathon.doctor.repository.DoctorRepository;
import dziala.mnie.dla.hackathon.doctor.support.DoctorExceptionSupplier;
import dziala.mnie.dla.hackathon.doctor.support.DoctorMapper;
import dziala.mnie.dla.hackathon.shared.api.response.IdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    private final DoctorMapper doctorMapper;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository,
                         DoctorMapper doctorMapper) {
        this.doctorRepository = doctorRepository;
        this.doctorMapper = doctorMapper;
    }

    public IdResponse create(DoctorRequest doctorRequest) {
        return doctorMapper.toIdResponse(doctorRepository.save(doctorMapper.toDoctor(doctorRequest)));
    }

    public Doctor findDoctorById(Long id) {
        return doctorRepository.findDoctorById(id).orElseThrow(DoctorExceptionSupplier.notFound(id));
    }

    public DoctorResponse findById(Long id) {
        return doctorMapper.toDoctorResponse(findDoctorById(id));
    }

    public List<DoctorResponse> findAll() {
        return doctorRepository.findAll().stream().map(doctorMapper::toDoctorResponse).collect(Collectors.toList());
    }

    @Transactional
    public DoctorResponse update(Long id,
                                 UpdateDoctorRequest updateDoctorRequest){
        Doctor doctor= findDoctorById(id);
        doctorRepository.save(doctorMapper.toDoctor(doctor,updateDoctorRequest));
        return doctorMapper.toDoctorResponse(doctor);
    }

    public void delete(Long id){
        Doctor doctor = findDoctorById(id);
        doctorRepository.deleteById(doctor.getId());
    }

}
