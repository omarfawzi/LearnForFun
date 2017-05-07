package learnforfun.mvc.Models;

import javax.persistence.Entity;

@Entity
public class Education {

    private String EducationalStage;
    private int AcademicYear;
    private double GPA;
    private int EID;

    public String getEducationalStage() {
        return EducationalStage;
    }

    public void setEducationalStage(String educationalStage) {
        EducationalStage = educationalStage;
    }

    public int getAcademicYear() {
        return AcademicYear;
    }

    public void setAcademicYear(int academicYear) {
        AcademicYear = academicYear;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double gPA) {
        GPA = gPA;
    }

    public int getEID() {
        return EID;
    }

    public void setEID(int eID) {
        EID = eID;
    }
}
