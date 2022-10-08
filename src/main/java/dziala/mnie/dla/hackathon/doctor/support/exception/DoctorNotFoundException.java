package dziala.mnie.dla.hackathon.doctor.support.exception;

import dziala.mnie.dla.hackathon.shared.support.NotFoundException;

public class DoctorNotFoundException extends NotFoundException {
    public DoctorNotFoundException(Long id) {
        super("Doctor", id);
    }

}
