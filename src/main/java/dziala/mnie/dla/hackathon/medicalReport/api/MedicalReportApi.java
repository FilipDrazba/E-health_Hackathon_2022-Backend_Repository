package dziala.mnie.dla.hackathon.medicalReport.api;

import dziala.mnie.dla.hackathon.medicalReport.service.MedicalReportService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "MedicalReports")
@RequestMapping(path = "api/v1/medicalreports")
public class MedicalReportApi {
    public final MedicalReportService medicalReportService;

    @Autowired
    public MedicalReportApi(MedicalReportService medicalReportService) {
        this.medicalReportService = medicalReportService;
    }

}
