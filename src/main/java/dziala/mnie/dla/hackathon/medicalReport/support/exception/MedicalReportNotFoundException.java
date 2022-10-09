package dziala.mnie.dla.hackathon.medicalReport.support.exception;

import dziala.mnie.dla.hackathon.shared.support.NotFoundException;

public class MedicalReportNotFoundException extends NotFoundException {
    public MedicalReportNotFoundException(Long id) {
        super("MedicalReport", id);
    }
}
