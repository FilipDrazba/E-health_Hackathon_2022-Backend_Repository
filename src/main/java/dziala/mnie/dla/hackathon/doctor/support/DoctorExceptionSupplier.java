package dziala.mnie.dla.hackathon.doctor.support;

import dziala.mnie.dla.hackathon.doctor.support.exception.DoctorNotFoundException;

import java.util.function.Supplier;

public class DoctorExceptionSupplier {

    public static Supplier<DoctorNotFoundException> notFound(Long id){
        return ()->new DoctorNotFoundException(id);
    }




}
