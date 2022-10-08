package dziala.mnie.dla.hackathon.patient.support.exception;

public class PatientAlreadyContainResearchProjectException extends RuntimeException {

    public PatientAlreadyContainResearchProjectException(Long patientId,
                                                         Long researchProjectId) {
        super(String.format(
                "Patient with ID %d has already consented to participate in the research project with ID %d",
                patientId, researchProjectId));
    }

}
