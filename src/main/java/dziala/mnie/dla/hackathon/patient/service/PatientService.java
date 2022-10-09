package dziala.mnie.dla.hackathon.patient.service;

import dziala.mnie.dla.hackathon.medicalReport.api.request.MedicalReportRequest;
import dziala.mnie.dla.hackathon.medicalReport.repository.MedicalReportRepository;
import dziala.mnie.dla.hackathon.medicalReport.support.MedicalReportMapper;
import dziala.mnie.dla.hackathon.patient.api.request.PatientRequest;
import dziala.mnie.dla.hackathon.patient.api.request.UpdatePatientRequest;
import dziala.mnie.dla.hackathon.patient.api.response.PatientResponse;
import dziala.mnie.dla.hackathon.patient.domain.Patient;
import dziala.mnie.dla.hackathon.patient.repository.PatientRepository;
import dziala.mnie.dla.hackathon.patient.support.PatientExceptionSupplier;
import dziala.mnie.dla.hackathon.patient.support.PatientMapper;
import dziala.mnie.dla.hackathon.shared.api.response.IdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final MedicalReportRepository medicalReportRepository;

    private final PatientMapper patientMapper;
    private final MedicalReportMapper medicalReportMapper;

    @Autowired
    public PatientService(PatientRepository patientRepository,
                          MedicalReportRepository medicalReportRepository,
                          PatientMapper patientMapper,
                          MedicalReportMapper medicalReportMapper) {
        this.patientRepository = patientRepository;
        this.medicalReportRepository=medicalReportRepository;
        this.patientMapper = patientMapper;
        this.medicalReportMapper = medicalReportMapper;
    }

    public IdResponse create(PatientRequest patientRequest) {
        if (patientRepository.existsPatientByPesel(patientRequest.peselValue())) {
            throw PatientExceptionSupplier.uniquePesel(patientRequest.peselValue()).get();
        }
        return patientMapper.toIdResponse(patientRepository.save(patientMapper.toPatient(patientRequest)));
    }

    public Patient findPatientById(Long id) {
        return patientRepository.findById(id).orElseThrow(PatientExceptionSupplier.notFound(id));
    }

    public PatientResponse findById(Long id) {
        return patientMapper.toPatientResponse(findPatientById(id));
    }

    public List<PatientResponse> findAll() {
        return patientRepository.findAll().stream().map(patientMapper::toPatientResponse).collect(Collectors.toList());
    }

    @Transactional
    public PatientResponse update(Long id, UpdatePatientRequest updatePatientRequest) {
        Patient patient = findPatientById(id);
        patientRepository.save(patientMapper.toPatient(patient, updatePatientRequest));
        return patientMapper.toPatientResponse(patient);
    }

    public void delete(Long id) {
        Patient patient = findPatientById(id);
        patientRepository.deleteById(patient.getId());
    }
}
