package dziala.mnie.dla.hackathon.patient.support;

import dziala.mnie.dla.hackathon.patient.support.exception.PatientAlreadyContainResearchProjectException;
import dziala.mnie.dla.hackathon.patient.support.exception.PatientDoesNotContainResearchProjectException;
import dziala.mnie.dla.hackathon.patient.support.exception.PatientNotFoundException;
import dziala.mnie.dla.hackathon.patient.support.exception.UniquePeselException;

import java.util.function.Supplier;

public class PatientExceptionSupplier {

    public static Supplier<PatientNotFoundException> notFound(Long id) {
        return () -> new PatientNotFoundException(id);
    }

    public static Supplier<UniquePeselException> uniquePesel(String pesel) {
        return () -> new UniquePeselException(pesel);
    }

    public static Supplier<PatientAlreadyContainResearchProjectException>
    patientAlreadyContainResearchProjectException(Long patientId,
                                                  Long researchProjectId) {
        return () -> new PatientAlreadyContainResearchProjectException(patientId, researchProjectId);
    }

    public static Supplier<PatientDoesNotContainResearchProjectException>
    patientDoesNotContainResearchProjectException(Long patientId,
                                                  Long researchProjectId) {
        return () -> new PatientDoesNotContainResearchProjectException(patientId, researchProjectId);
    }

//    public static Supplier<IncorrectPeselException> incorrectPesel(String incorrectPeselValue) {
//        return () -> new IncorrectPeselException(incorrectPeselValue);
//    }

}
