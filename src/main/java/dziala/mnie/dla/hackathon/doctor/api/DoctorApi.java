package dziala.mnie.dla.hackathon.doctor.api;

import dziala.mnie.dla.hackathon.doctor.service.DoctorService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "Doctors")
@RequestMapping(path="api/v1/doctors")
public class DoctorApi {

    public final DoctorService doctorService;

    @Autowired
    public DoctorApi(DoctorService doctorService){
        this.doctorService=doctorService;
    }

}
