package dziala.mnie.dla.hackathon.medicalReport.api.request;

public record MedicalReportRequest(Float weight,
                                   Float SPo2,
                                   Integer pulse,
                                   Integer diastolicPressure,
                                   Integer systolicPressure,
                                   Integer painInChest,
                                   String symptoms) {

}
