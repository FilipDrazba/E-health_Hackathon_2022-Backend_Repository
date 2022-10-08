package dziala.mnie.dla.hackathon.patient.api.request;

public record PatientRequest(String peselValue,
                             String firstName,
                             String lastName,
                             String phoneNumber,
                             String email) {
}
