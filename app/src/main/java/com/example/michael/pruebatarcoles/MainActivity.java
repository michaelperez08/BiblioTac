package com.example.michael.pruebatarcoles;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private GoogleApiClient mGoogleApiClient;
    private static final int RC_SIGN_IN = 9001;
    private static final String TAG = "BiblioTac";
    static final String STATE_SCORE = "playerScore";
    static final String STATE_LEVEL = "playerLevel";
    private EditText et_fecha;
    private Button bt_fecha;
    private int dia, mes, ano, hora, minutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
          //      .requestEmail()
            //    .build();

       // mGoogleApiClient = new GoogleApiClient.Builder(this)
        //        .enableAutoManage(this /* FragmentActivity */, new GoogleApiClient.OnConnectionFailedListener() {
            //        @Override
          //          public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
          //              System.out.println("");
            //        }
              //  } /* OnConnectionFailedListener */)
               // .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                //.build();

       // signIn();

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        LinearLayout mContainer;
        Fragment fragment = null;
        Class fragmentClass;
        /**/
        if (id == R.id.reserva_salas) {
            fragment = new ReservaSala();
        } else if (id == R.id.info_general) {
            fragment = new InformacionBiblioteca();
        } else if (id == R.id.consulta) {
            fragment = new ConsultaGeneral();
        }  else if(id == R.id.info_salas){
            fragment = new InformacionSalas();
        } else if(id == R.id.reservar_libro){
            fragment = new ReservaLibros();
        } else if(id == R.id.busqueda_libro){
            fragment = new BusquedaLibro();
        }  else if(id == R.id.principal) {
            fragment = new principal();
        }
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.main_content, fragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        setTitle(item.getTitle());
        return true;
    }


    /*private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }*/

    @Override
   public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        /*if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }*/
    }

   // private void handleSignInResult(GoogleSignInResult result) {
     //   Log.d(TAG, "handleSignInResult:" + result.isSuccess());
      //  if (result.isSuccess()) {
            // Signed in successfully, show authenticated UI.
       //     GoogleSignInAccount acct = result.getSignInAccount();
        //    loadInfo(acct);
            /*mStatusTextView.setText(getString(R.string.signed_in_fmt, acct.getDisplayName()));
            updateUI(true);*/
       // } else {
         //   signIn();
       // }
    //}

   // private void loadInfo(GoogleSignInAccount acct) {
    //    Toast.makeText(getApplicationContext(), "Hola " + acct.getDisplayName(), Toast.LENGTH_SHORT).show();
    //    TextView tvnombre = (TextView) findViewById(R.id.tv_nombreUsuario);
    //    TextView tvcorreo = (TextView) findViewById(R.id.tv_correoUsuario);
    //    ImageView ivfoto = (ImageView) findViewById(R.id.iv_imgUsuario);
     //   tvnombre.setText(acct.getDisplayName());
     //   tvcorreo.setText(acct.getEmail());
      //  ivfoto.setLayoutParams(new LinearLayout.LayoutParams(150, 150));
        //ivfoto.setImageResource(R.mipmap.coco2);


    //}

    public void logout(MenuItem menuItem) {
        //Auth.GoogleSignInApi.signOut(mGoogleApiClient);
        finish();
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void elegirFecha() {
        final Calendar c = Calendar.getInstance();
        dia = c.get(Calendar.DAY_OF_MONTH);
        mes = c.get(Calendar.MONTH);
        ano = c.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                et_fecha.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
            }
        }
                , dia, mes, ano);
        datePickerDialog.show();
    }


}
