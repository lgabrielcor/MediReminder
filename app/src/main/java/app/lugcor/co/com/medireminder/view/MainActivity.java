package app.lugcor.co.com.medireminder.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.List;

import app.lugcor.co.com.medireminder.R;
import app.lugcor.co.com.medireminder.controller.Medicament_List_Adapter;
import app.lugcor.co.com.medireminder.data.MediReminderORMHelper;
import app.lugcor.co.com.medireminder.data.Medicament_List_DAO;
import app.lugcor.co.com.medireminder.model.Dosis;


public class MainActivity extends Activity {

    private Button button_a;
    private ListView medicament_list;

    private MediReminderORMHelper mDBHelper;
    private Dao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //se crea la base de datos
        mDBHelper= OpenHelperManager.getHelper(this.getBaseContext(), MediReminderORMHelper.class);

        //pruebas de concepto de insert y de query
        crearObjectoConcepto();
        obtenerObjetoConcepto();
        medicament_list = (ListView)findViewById(R.id.medicament_list);

        Medicament_List_Adapter adaptador = new Medicament_List_Adapter(this, new Medicament_List_DAO(4).getDummy());
        medicament_list.setAdapter(adaptador);


        medicament_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(MainActivity.this, Medicament_Detail.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mDBHelper != null) {
            OpenHelperManager.releaseHelper();
            Log.d(this.getClass().toString(), "se cierra la conexion");
            mDBHelper = null;
        }
    }

    private MediReminderORMHelper getHelper() {
        if (mDBHelper == null) {
            mDBHelper = OpenHelperManager.getHelper(this, MediReminderORMHelper.class);
        }
        return mDBHelper;
    }



    private void crearObjectoConcepto(){

        try{
            dao = getHelper().getDosisDAO();
            Dosis dosis = new Dosis();
            dosis.setDosificacion("prueba uno");
            dosis.setFrecuencia(1);
            dosis.setMedicamento("prueba nombre uno");
            dosis.setMedida_tiempo("diario");
            dosis.setTerminada(false);
            dosis.setVisible(true);
            dosis.setFoto("prueba".getBytes());
            dao.create(dosis);
            Log.d(this.getClass().toString(), "registro almacenado");

        }catch (SQLException ex){

            Log.e(this.getClass().toString(), "Error creando usuario");
            ex.printStackTrace();
        }
    }

    private void obtenerObjetoConcepto(){

        try {
            dao = getHelper().getDosisDAO();
            QueryBuilder queryBuilder = dao.queryBuilder();
            queryBuilder.setWhere(queryBuilder.where().eq(Dosis.MEDICAMENTO, "prueba nombre uno"));
            //Dosis dosis = dao.queryBuilder()
            List dosisList= dao.query(queryBuilder.prepare());
            if(dosisList.isEmpty()){
                Log.d(this.getClass().toString(), "registro no encontrado");
            }else{
                Log.d(this.getClass().toString(), "registro encontrado");
                Log.d(this.getClass().toString(), dosisList.size()+"");
                for (int i = 0; i < dosisList.size(); i++) {
                    Log.d(this.getClass().toString(), "registro encontrado");
                    Log.d(this.getClass().toString(),((Dosis) dosisList.get(i)).getId()+" "+ ((Dosis) dosisList.get(i)).getDosificacion());
                }
            }
         } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
