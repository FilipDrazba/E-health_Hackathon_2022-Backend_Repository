package dziala.mnie.dla.hackathon.patient.support;

import dziala.mnie.dla.hackathon.patient.api.request.PatientRequest;
import dziala.mnie.dla.hackathon.patient.api.request.UpdatePatientRequest;
import dziala.mnie.dla.hackathon.patient.api.response.PatientResponse;
import dziala.mnie.dla.hackathon.patient.domain.Patient;
import dziala.mnie.dla.hackathon.shared.api.response.IdResponse;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

    public Patient toPatient(PatientRequest patientRequest) {
        return new Patient(
                patientRequest.peselValue(),
                patientRequest.firstName(),
                patientRequest.lastName(),
                patientRequest.phoneNumber(),
                patientRequest.email()
        );
    }

    public Patient toPatient(Patient patient, UpdatePatientRequest updatePatientRequest) {
        patient.setFirstName(updatePatientRequest.firstName());
        patient.setLastName(updatePatientRequest.lastName());
        patient.setPhoneNumber(updatePatientRequest.phoneNumber());
        patient.setEmail(updatePatientRequest.email());

        return patient;
    }

    public PatientResponse toPatientResponse(Patient patient) {
        return new PatientResponse(
                "Patient",
                patient.getId(),
                patient.getPesel(),
                patient.getFirstName(),
                patient.getLastName(),
                patient.getGender(),
                patient.getDateOfBerth(),
                patient.getPhoneNumber(),
                patient.getEmail()
        );
    }

    public IdResponse toIdResponse(Patient patient) {
        return new IdResponse(patient.getId());
    }

}
