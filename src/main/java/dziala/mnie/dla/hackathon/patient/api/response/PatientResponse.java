package dziala.mnie.dla.hackathon.patient.api.response;

import dziala.mnie.dla.hackathon.shared.enums.Gender;

import java.time.LocalDate;

public record PatientResponse(String className,
                              Long id,
                              String pesel,
                              String firstName,
                              String lastName,
                              Gender gender,
                              LocalDate dateOfBirth,
                              String phoneNumber,
                              String email) {
}
