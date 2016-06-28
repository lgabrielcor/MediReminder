package app.lugcor.co.com.medireminder.data;

import app.lugcor.co.com.medireminder.model.Historial_Dosis;

/**
 * Created by luisgabrielcorredorcombita on 23/07/15.
 */
public class Medicament_List_DAO {
    private Historial_Dosis[] dummy;

    public Medicament_List_DAO(){

    }

    public Medicament_List_DAO(int i){
        setDummy(new Historial_Dosis[i]);
        for (int j = 0; j < i; j++) {
            Historial_Dosis item = new Historial_Dosis();
            item.setDose("Dose "+j);
            item.setMedicamentId(j);
            item.setMedicamentName("medicamento "+j);
            item.setNextDose("siguiente dosis "+j);
            item.setPatology("patologia "+j);
            this.dummy[j] = item;
        }
    }

    public Historial_Dosis[] getDummy() {
        return dummy;
    }

    public void setDummy(Historial_Dosis[] dummy) {
        this.dummy = dummy;
    }
}
