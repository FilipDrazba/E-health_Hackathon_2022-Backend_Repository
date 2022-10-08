package dziala.mnie.dla.hackathon.patient.support.exception;

import dziala.mnie.dla.hackathon.shared.support.NotFoundException;

public class PatientNotFoundException extends NotFoundException {

    public PatientNotFoundException(Long id) {
        super("Patient", id);
    }

}
