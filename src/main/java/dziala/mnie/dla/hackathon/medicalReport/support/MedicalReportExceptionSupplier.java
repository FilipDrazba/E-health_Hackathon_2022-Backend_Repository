package dziala.mnie.dla.hackathon.medicalReport.support;

import dziala.mnie.dla.hackathon.medicalReport.support.exception.MedicalReportNotFoundException;

import java.util.function.Supplier;

public class MedicalReportExceptionSupplier {

    public static Supplier<MedicalReportNotFoundException> notFound(Long id) {
        return () -> new MedicalReportNotFoundException(id);
    }

}
