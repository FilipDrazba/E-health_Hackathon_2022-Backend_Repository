package dziala.mnie.dla.hackathon.patient.api.request;

public record UpdatePatientRequest(String firstName,
                                   String lastName,
                                   String phoneNumber,
                                   String email) {
}
