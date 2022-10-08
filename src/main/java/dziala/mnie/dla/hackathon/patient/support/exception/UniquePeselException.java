package dziala.mnie.dla.hackathon.patient.support.exception;

public class UniquePeselException extends RuntimeException {

    public UniquePeselException(String pesel) {
        super(String.format("Patient with PESEL %s already exists in the database.", pesel));
    }

}
