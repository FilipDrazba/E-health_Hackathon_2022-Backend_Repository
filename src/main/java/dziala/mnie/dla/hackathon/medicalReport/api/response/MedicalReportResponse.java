package dziala.mnie.dla.hackathon.medicalReport.api.response;

import dziala.mnie.dla.hackathon.patient.domain.Patient;
import dziala.mnie.dla.hackathon.shared.enums.Gender;

import java.time.LocalDate;

public record MedicalReportResponse(
        String className,
        Long id,
        LocalDate date,
        Patient patient,
        Integer patientAge,
        Gender patientGender,
        Float weight,
        Float SPo2,
        Integer pulse,
        Integer diastolicPressure,
        Integer systolicPressure,
        Integer painInChest,
        String symptoms
) {

}
