package com.example.examinationservice.helper;

import com.example.examinationservice.dto.VitalSignsDto;
import com.example.examinationservice.entity.Examination;

public class ExaminationHelper {
    public static Examination updateDiagnosis(Examination exam, String diagnosis) {
        exam.setDiagnosis(diagnosis);
        return exam;
    }
    public static Examination updateSurvey(Examination exam, String survey) {
        exam.setSurvey(survey);
        return exam;
    }
    public static Examination updateInstruction(Examination exam, String instruction) {
        exam.setTreatmentInstruction(instruction);
        return exam;
    }
    public static Examination updatePrescription(Examination exam, String prescription) {
        exam.setPrescription(prescription);
        return exam;
    }
    public static Examination updateReport(Examination exam, String report) {
        exam.setReport(report);
        return exam;
    }
    public static Examination updateVitalSigns(Examination exam, VitalSignsDto vitals) {
        exam.setBodyTemperature(vitals.getBodyTemperature());
        exam.setHeartRate(vitals.getHeartRate());
        exam.setRespiratoryRate(vitals.getRespiratoryRate());
        exam.setBloodPressure(vitals.getBloodPressure());
        exam.setVitalSignsMeasuredAt(vitals.getMeasuredAt());
        return exam;
    }
}
