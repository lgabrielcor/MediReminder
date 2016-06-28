package app.lugcor.co.com.medireminder.model;

/**
 * Created by luisgabrielcorredorcombita on 23/07/15.
 */
public class Historial_Dosis {

    private int medicamentId;
    private String medicamentName;
    private String patology;
    private String nextDose;
    private String dose;

    public String getMedicamentName() {
        return medicamentName;
    }

    public void setMedicamentName(String medicamentName) {
        this.medicamentName = medicamentName;
    }

    public String getPatology() {
        return patology;
    }

    public void setPatology(String patology) {
        this.patology = patology;
    }

    public String getNextDose() {
        return nextDose;
    }

    public void setNextDose(String nextDose) {
        this.nextDose = nextDose;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public int getMedicamentId() {
        return medicamentId;
    }

    public void setMedicamentId(int medicamentId) {
        this.medicamentId = medicamentId;
    }
}
