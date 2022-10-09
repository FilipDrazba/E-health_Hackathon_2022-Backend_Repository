package dziala.mnie.dla.hackathon.medicalReport.service;

import dziala.mnie.dla.hackathon.medicalReport.api.request.MedicalReportRequest;
import dziala.mnie.dla.hackathon.medicalReport.api.response.MedicalReportResponse;
import dziala.mnie.dla.hackathon.medicalReport.domain.MedicalReport;
import dziala.mnie.dla.hackathon.medicalReport.repository.MedicalReportRepository;
import dziala.mnie.dla.hackathon.medicalReport.support.MedicalReportExceptionSupplier;
import dziala.mnie.dla.hackathon.medicalReport.support.MedicalReportMapper;
import dziala.mnie.dla.hackathon.patient.api.request.UpdatePatientRequest;
import dziala.mnie.dla.hackathon.patient.api.response.PatientResponse;
import dziala.mnie.dla.hackathon.patient.domain.Patient;
import dziala.mnie.dla.hackathon.patient.service.PatientService;
import dziala.mnie.dla.hackathon.shared.api.request.IdRequest;
import dziala.mnie.dla.hackathon.shared.api.response.IdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicalReportService {

    private final MedicalReportRepository medicalReportRepository;
    private final PatientService patientService;
    private final MedicalReportMapper medicalReportMapper;

    @Autowired
    public MedicalReportService(MedicalReportRepository medicalReportRepository,
                                PatientService patientService,
                                MedicalReportMapper medicalReportMapper) {
        this.medicalReportRepository = medicalReportRepository;
        this.patientService = patientService;
        this.medicalReportMapper = medicalReportMapper;
    }

    public IdResponse create(MedicalReportRequest medicalReportRequest,
                             IdRequest patientIdRequest) {
        Patient patient = patientService.findPatientById(patientIdRequest.id());

        return medicalReportMapper.toIdResponse(medicalReportRepository.save(
                medicalReportMapper.toMedicalReport(medicalReportRequest, patient)));
    }

    public MedicalReport findMedicalReportById(Long id) {
        return medicalReportRepository.findById(id).orElseThrow(MedicalReportExceptionSupplier.notFound(id));
    }

    public MedicalReportResponse findById(Long id) {
        return medicalReportMapper.toMedicalReportResponse(findMedicalReportById(id));
    }

    public List<MedicalReportResponse> findAll() {
        return medicalReportRepository.findAll().stream().map(
                medicalReportMapper::toMedicalReportResponse).collect(Collectors.toList());
    }

    @Transactional
    public MedicalReportResponse update(Long id, MedicalReportRequest medicalReportRequest) {
        MedicalReport medicalReport = findMedicalReportById(id);
        medicalReportRepository.save(medicalReportMapper.toMedicalReport(medicalReport,medicalReportRequest));
        return medicalReportMapper.toMedicalReportResponse(medicalReport);
    }

}
