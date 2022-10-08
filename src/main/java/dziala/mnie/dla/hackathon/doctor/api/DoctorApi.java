package dziala.mnie.dla.hackathon.doctor.api;

import dziala.mnie.dla.hackathon.doctor.api.request.DoctorRequest;
import dziala.mnie.dla.hackathon.doctor.api.response.DoctorResponse;
import dziala.mnie.dla.hackathon.doctor.domain.Doctor;
import dziala.mnie.dla.hackathon.doctor.service.DoctorService;
import dziala.mnie.dla.hackathon.patient.api.request.UpdatePatientRequest;
import dziala.mnie.dla.hackathon.patient.api.response.PatientResponse;
import dziala.mnie.dla.hackathon.shared.api.response.IdResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "Doctors")
@RequestMapping(path="api/v1/doctors")
public class DoctorApi {

    public final DoctorService doctorService;

    @Autowired
    public DoctorApi(DoctorService doctorService){
        this.doctorService = doctorService;
    }

    @PostMapping
    @ApiOperation("Create doctor")
    public ResponseEntity<IdResponse> create(@RequestBody DoctorRequest doctorRequest){
        IdResponse idResponse = doctorService.create(doctorRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(idResponse);
    }

    @GetMapping
    @ApiOperation("Find all doctors")
    public ResponseEntity<List<DoctorResponse>> findAll() {
        List<DoctorResponse> doctorResponses = doctorService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(doctorResponses);
    }

    @GetMapping(path = "{id}")
    @ApiOperation("Find doctor by ID")
    public ResponseEntity<DoctorResponse> findById(@PathVariable Long id) {
        DoctorResponse doctorResponse = doctorService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(doctorResponse);
    }

//    @PutMapping(path = "{id}")
//    @ApiOperation("Update doctor")
//    public ResponseEntity<DoctorResponse> update(@PathVariable Long id,
//                                                  @RequestBody UpdateDoctorRequest updateDoctorRequest) {
//        DoctorResponse doctorResponse = doctorService.update(id, updateDoctorRequest);
//        return ResponseEntity.status(HttpStatus.OK).body(doctorResponse);
//    }

    @DeleteMapping(path = "{id}")
    @ApiOperation("Delete doctor")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        doctorService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
