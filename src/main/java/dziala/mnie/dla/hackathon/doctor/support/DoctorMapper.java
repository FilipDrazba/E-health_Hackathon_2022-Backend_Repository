package dziala.mnie.dla.hackathon.doctor.support;

import dziala.mnie.dla.hackathon.doctor.api.request.DoctorRequest;
import dziala.mnie.dla.hackathon.doctor.api.request.UpdateDoctorRequest;
import dziala.mnie.dla.hackathon.doctor.api.response.DoctorResponse;
import dziala.mnie.dla.hackathon.doctor.domain.Doctor;
import dziala.mnie.dla.hackathon.shared.api.response.IdResponse;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapper {

    public Doctor toDoctor(DoctorRequest doctorRequest) {
        return new Doctor(doctorRequest.firstName(),
                doctorRequest.lastName());
    }

    public Doctor toDoctor(Doctor doctor,
                           UpdateDoctorRequest updateDoctorRequest) {
        doctor.setFirstName(updateDoctorRequest.fistName());
        doctor.setLastName(updateDoctorRequest.lastName());

        return doctor;
    }

    public IdResponse toIdResponse(Doctor doctor) {
        return new IdResponse(doctor.getId());
    }

    public DoctorResponse toDoctorResponse(Doctor doctor) {
        return new DoctorResponse(
                "Docotor",
                doctor.getId(),
                doctor.getFirstName(),
                doctor.getLastName()
        );
    }

}
