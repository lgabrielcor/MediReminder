package app.lugcor.co.com.medireminder.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import app.lugcor.co.com.medireminder.model.Dosis;
import app.lugcor.co.com.medireminder.model.Dosis_Historial;

/**
 * Created by luisgabrielcorredorcombita on 27/07/15.
 */


public class MediReminderORMHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "medi_reminder.db";
    private static final int DATABASE_VERSION = 1;

    private Dao<Dosis, Integer> dosisDAO;
    private Dao<Dosis_Historial, Integer> dosis_HistorialDAO;

    public MediReminderORMHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Dosis.class);
            TableUtils.createTable(connectionSource, Dosis_Historial.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        onCreate(database, connectionSource);
    }

    public Dao<Dosis, Integer> getDosisDAO() throws SQLException {
        if(dosisDAO==null)
            dosisDAO=getDao(Dosis.class);

        return dosisDAO;
    }

    public Dao<Dosis_Historial, Integer> getDosis_HistorialDAO() throws SQLException {
        if(dosis_HistorialDAO==null)
            dosis_HistorialDAO=getDao(Dosis_Historial.class);

        return dosis_HistorialDAO;
    }

    @Override
    public void close() {
        super.close();
        dosisDAO = null;
        dosis_HistorialDAO = null;
    }
}
