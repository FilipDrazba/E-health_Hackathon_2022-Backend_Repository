package dziala.mnie.dla.hackathon.patient.support.exception;

public class PatientDoesNotContainResearchProjectException extends RuntimeException{

    public PatientDoesNotContainResearchProjectException(Long patientId,
                                                         Long researchProjectId) {
        super(String.format(
                "Patient with ID %d has not consented to participate in the research project with ID %d",
                patientId, researchProjectId));
    }

}
