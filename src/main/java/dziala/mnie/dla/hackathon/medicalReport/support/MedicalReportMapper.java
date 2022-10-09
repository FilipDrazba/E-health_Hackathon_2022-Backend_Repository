package dziala.mnie.dla.hackathon.medicalReport.support;

import dziala.mnie.dla.hackathon.medicalReport.api.request.MedicalReportRequest;
import dziala.mnie.dla.hackathon.medicalReport.api.response.MedicalReportResponse;
import dziala.mnie.dla.hackathon.medicalReport.domain.MedicalReport;
import dziala.mnie.dla.hackathon.patient.domain.Patient;
import dziala.mnie.dla.hackathon.shared.api.response.IdResponse;
import org.springframework.stereotype.Component;

@Component
public class MedicalReportMapper {

    public MedicalReport toMedicalReport(MedicalReportRequest medicalReportRequest,
                                         Patient patient) {
        return new MedicalReport(
                patient,
                medicalReportRequest.weight(),
                medicalReportRequest.SPo2(),
                medicalReportRequest.pulse(),
                medicalReportRequest.diastolicPressure(),
                medicalReportRequest.systolicPressure(),
                medicalReportRequest.painInChest(),
                medicalReportRequest.symptoms()
        );
    }

    public MedicalReport toMedicalReport(MedicalReport medicalReport, MedicalReportRequest medicalReportRequest) {
        medicalReport.setWeight(medicalReportRequest.weight());
        medicalReport.setSPo2(medicalReportRequest.SPo2());
        medicalReport.setPulse(medicalReportRequest.pulse());
        medicalReport.setPulse(medicalReportRequest.diastolicPressure());
        medicalReport.setSystolicPressure(medicalReportRequest.systolicPressure());
        medicalReport.setPainInChest(medicalReportRequest.painInChest());
        medicalReport.setSymptoms(medicalReportRequest.symptoms());
        return medicalReport;
    }

    public IdResponse toIdResponse(MedicalReport medicalReport) {
        return new IdResponse(medicalReport.getId());
    }

    public MedicalReportResponse toMedicalReportResponse(MedicalReport medicalReport) {
        return new MedicalReportResponse(
                "MedicalReport",
                medicalReport.getId(),
                medicalReport.getDate(),
                medicalReport.getPatient(),
                medicalReport.getPatientAge(),
                medicalReport.getPatientGender(),
                medicalReport.getWeight(),
                medicalReport.getSPo2(),
                medicalReport.getPulse(),
                medicalReport.getDiastolicPressure(),
                medicalReport.getSystolicPressure(),
                medicalReport.getPainInChest(),
                medicalReport.getSymptoms()
        );
    }

}
