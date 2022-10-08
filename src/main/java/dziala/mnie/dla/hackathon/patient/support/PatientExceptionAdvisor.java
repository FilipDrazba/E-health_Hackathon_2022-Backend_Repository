package dziala.mnie.dla.hackathon.patient.support;

import dziala.mnie.dla.hackathon.patient.support.exception.PatientAlreadyContainResearchProjectException;
import dziala.mnie.dla.hackathon.patient.support.exception.PatientDoesNotContainResearchProjectException;
import dziala.mnie.dla.hackathon.patient.support.exception.PatientNotFoundException;
import dziala.mnie.dla.hackathon.patient.support.exception.UniquePeselException;
import dziala.mnie.dla.hackathon.shared.api.response.ErrorMessageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class PatientExceptionAdvisor {

    private static final Logger LOG = LoggerFactory.getLogger(PatientExceptionAdvisor.class);

    @ExceptionHandler(PatientNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorMessageResponse notFound(PatientNotFoundException exception) {
        LOG.error(exception.getMessage(), exception);
        return new ErrorMessageResponse(exception.getLocalizedMessage());
    }

    @ExceptionHandler(UniquePeselException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ResponseBody
    public ErrorMessageResponse uniquePesel(UniquePeselException exception) {
        LOG.error(exception.getMessage(), exception);
        return new ErrorMessageResponse(exception.getLocalizedMessage());
    }

    @ExceptionHandler(PatientAlreadyContainResearchProjectException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ResponseBody
    public ErrorMessageResponse patientAlreadyContainResearchProjectException(PatientAlreadyContainResearchProjectException exception) {
        LOG.error(exception.getMessage(), exception);
        return new ErrorMessageResponse(exception.getLocalizedMessage());
    }

    @ExceptionHandler(PatientDoesNotContainResearchProjectException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ResponseBody
    public ErrorMessageResponse patientDoesNotContainResearchProjectException(PatientDoesNotContainResearchProjectException exception) {
        LOG.error(exception.getMessage(), exception);
        return new ErrorMessageResponse(exception.getLocalizedMessage());
    }

}
