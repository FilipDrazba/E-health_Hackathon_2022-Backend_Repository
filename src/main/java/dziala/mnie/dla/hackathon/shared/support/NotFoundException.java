package dziala.mnie.dla.hackathon.shared.support;

public abstract class NotFoundException extends RuntimeException {

    public NotFoundException(String type, Long id) {
        super(String.format("%s with ID %d not found.", type, id));
    }

}
