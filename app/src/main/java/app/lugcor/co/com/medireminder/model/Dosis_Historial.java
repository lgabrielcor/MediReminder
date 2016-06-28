package app.lugcor.co.com.medireminder.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
/**
 * Created by luisgabrielcorredorcombita on 27/07/15.
 */

@DatabaseTable(tableName = "historial_dosis")
public class Dosis_Historial {

    public static final String ID = "ID";
    public static final String ID_DOSIS ="id_dosis";
    public static final String FECHA_DOSIS_TIMESTAMP_UTC="fecha_dosis_timestamp_utc";
    public static final String CUMPLIDA="cumplida";
    public static final String FECHA_DOSIS_APLICADA_TIMESTAMP_UTC="fecha_dosis_aplicada_timestamp_utc";
    public static final String VISIBLE="visible";

    @DatabaseField(generatedId = true, columnName = ID)
    private int id;
    @DatabaseField(columnName = ID_DOSIS, foreign = true)
    private Dosis dosis;
    @DatabaseField(columnName = FECHA_DOSIS_TIMESTAMP_UTC)
    private int fecha_dosis_timestamp_utc;
    @DatabaseField(columnName = CUMPLIDA)
    private boolean cumplida;
    @DatabaseField(columnName = FECHA_DOSIS_APLICADA_TIMESTAMP_UTC)
    private int fecha_dosis_aplicada_timestamp_utc;
    @DatabaseField(columnName = VISIBLE)
    private boolean visible;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Dosis getDosis() {
        return dosis;
    }

    public void setDosis(Dosis dosis) {
        this.dosis = dosis;
    }

    public int getFecha_dosis_timestamp_utc() {
        return fecha_dosis_timestamp_utc;
    }

    public void setFecha_dosis_timestamp_utc(int fecha_dosis_timestamp_utc) {
        this.fecha_dosis_timestamp_utc = fecha_dosis_timestamp_utc;
    }

    public boolean isCumplida() {
        return cumplida;
    }

    public void setCumplida(boolean cumplida) {
        this.cumplida = cumplida;
    }

    public int getFecha_dosis_aplicada_timestamp_utc() {
        return fecha_dosis_aplicada_timestamp_utc;
    }

    public void setFecha_dosis_aplicada_timestamp_utc(int fecha_dosis_aplicada_timestamp_utc) {
        this.fecha_dosis_aplicada_timestamp_utc = fecha_dosis_aplicada_timestamp_utc;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
