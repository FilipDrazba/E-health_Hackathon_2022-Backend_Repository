package dziala.mnie.dla.hackathon.patient.api;

import dziala.mnie.dla.hackathon.patient.api.request.PatientRequest;
import dziala.mnie.dla.hackathon.patient.api.request.UpdatePatientRequest;
import dziala.mnie.dla.hackathon.patient.api.response.PatientResponse;
import dziala.mnie.dla.hackathon.patient.service.PatientService;
import dziala.mnie.dla.hackathon.shared.api.response.IdResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "Patients")
@RequestMapping(path = "api/v1/patients")
class PatientApi {

    public final PatientService patientService;

    @Autowired
    public PatientApi(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    @ApiOperation("Create patient")
    public ResponseEntity<IdResponse> create(@RequestBody PatientRequest patientRequest) {
        IdResponse idResponse = patientService.create(patientRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(idResponse);
    }

    @GetMapping
    @ApiOperation("Find all patients")
    public ResponseEntity<List<PatientResponse>> findAll() {
        List<PatientResponse> patientResponses = patientService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(patientResponses);
    }

    @GetMapping(path = "{id}")
    @ApiOperation("Find patient by ID")
    public ResponseEntity<PatientResponse> findById(@PathVariable Long id) {
        PatientResponse patientResponse = patientService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(patientResponse);
    }

    @PutMapping(path = "{id}")
    @ApiOperation("Update patient")
    public ResponseEntity<PatientResponse> update(@PathVariable Long id,
                                                  @RequestBody UpdatePatientRequest updatePatientRequest) {
        PatientResponse patientResponse = patientService.update(id, updatePatientRequest);
        return ResponseEntity.status(HttpStatus.OK).body(patientResponse);
    }

    @DeleteMapping(path = "{id}")
    @ApiOperation("Delete patient")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        patientService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}

