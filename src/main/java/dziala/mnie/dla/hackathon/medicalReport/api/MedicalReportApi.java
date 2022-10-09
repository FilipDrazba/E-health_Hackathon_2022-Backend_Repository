package dziala.mnie.dla.hackathon.medicalReport.api;

import dziala.mnie.dla.hackathon.medicalReport.api.request.MedicalReportRequest;
import dziala.mnie.dla.hackathon.medicalReport.api.request.UpdateMedicalReportRequest;
import dziala.mnie.dla.hackathon.medicalReport.api.response.MedicalReportResponse;
import dziala.mnie.dla.hackathon.medicalReport.service.MedicalReportService;
import dziala.mnie.dla.hackathon.patient.api.request.PatientRequest;
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
@Api(tags = "MedicalReports")
@RequestMapping(path = "api/v1/medicalreports")
public class MedicalReportApi {
    public final MedicalReportService medicalReportService;

    @Autowired
    public MedicalReportApi(MedicalReportService medicalReportService) {
        this.medicalReportService = medicalReportService;
    }

//    @PostMapping
//    @ApiOperation("Create MedicalReport")
//    public ResponseEntity<IdResponse> create(@RequestBody MedicalReportRequest medicalReportRequest) {
//        IdResponse idResponse = medicalReportService.create(medicalReportRequest, );
//        return ResponseEntity.status(HttpStatus.CREATED).body(idResponse);
//    }

    @GetMapping
    @ApiOperation("Find all MedicalReports")
    public ResponseEntity<List<MedicalReportResponse>> findAll() {
        List<MedicalReportResponse> medicalReportResponses = medicalReportService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(medicalReportResponses);
    }

    @GetMapping(path = "{id}")
    @ApiOperation("Find medicalreport by ID")
    public ResponseEntity<MedicalReportResponse> findById(@PathVariable Long id) {
        MedicalReportResponse medicalReportResponse = MedicalReportService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(medicalReportResponse);
    }

    @PutMapping(path = "{id}")
    @ApiOperation("Update medicalreport")
    public ResponseEntity<MedicalReportResponse> update(@PathVariable Long id,
                                                        @RequestBody UpdateMedicalReportRequest MedicalReportRequest) {
        MedicalReportResponse medicalReportResponse = medicalReportService.update(id, MedicalReportRequest);
        return ResponseEntity.status(HttpStatus.OK).body(medicalReportResponse);
    }

    @DeleteMapping(path = "{id}")
    @ApiOperation("Delete medicalreport")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        medicalReportService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



}
