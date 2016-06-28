package app.lugcor.co.com.medireminder.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
/**
 * Created by luisgabrielcorredorcombita on 27/07/15.
 */

@DatabaseTable(tableName = "dosis")
public class Dosis {

    public static final String ID = "ID";
    public static final String MEDICAMENTO = "medicamento";
    public static final String FRECUENCIA = "frecuencia";
    public static final String MEDIDA_TIEMPO = "medida_tiempo";
    public static final String DOSIFICACION = "dosificacion";
    public static final String TERMINADA = "terminada";
    public static final String FOTO = "foto";
    public static final String VISIBLE = "visible";

    @DatabaseField(generatedId = true, columnName = "ID")
    private int id;
    @DatabaseField(columnName = MEDICAMENTO)
    private String medicamento;
    @DatabaseField(columnName = FRECUENCIA)
    private int frecuencia;
    @DatabaseField(columnName = MEDIDA_TIEMPO)
    private String medida_tiempo;
    @DatabaseField(columnName = DOSIFICACION)
    private String dosificacion;
    @DatabaseField(columnName = TERMINADA)
    private boolean terminada;
    @DatabaseField(columnName = FOTO, dataType = DataType.BYTE_ARRAY)
    private byte[] foto;
    @DatabaseField(columnName = VISIBLE)
    private boolean visible;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getMedida_tiempo() {
        return medida_tiempo;
    }

    public void setMedida_tiempo(String medida_tiempo) {
        this.medida_tiempo = medida_tiempo;
    }

    public String getDosificacion() {
        return dosificacion;
    }

    public void setDosificacion(String dosificacion) {
        this.dosificacion = dosificacion;
    }

    public boolean isTerminada() {
        return terminada;
    }

    public void setTerminada(boolean terminada) {
        this.terminada = terminada;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
