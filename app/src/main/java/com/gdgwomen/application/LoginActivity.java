package com.gdgwomen.application;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
           final View rootView = inflater.inflate(R.layout.fragment_login, container, false);

            Button btnLogin=(Button) rootView.findViewById(R.id.btnLogin);
            btnLogin.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    Toast.makeText(getActivity(),"hola wen boton",Toast.LENGTH_SHORT).show();

                    EditText edtUser = (EditText) rootView.findViewById(R.id.edtUser);
                    EditText edtPass= (EditText) rootView.findViewById(R.id.edtPass);
                    String user=edtUser.getText().toString();
                    String pass=edtPass.getText().toString();

                    if(user.equals("wen") && pass.equals("clave")){
                        Intent intent= new Intent(getActivity(),MySecondActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getActivity(),"Usuario o clave  incorrecta",Toast.LENGTH_SHORT).show();
                    }

                }
            } );

            return rootView;
        }
    }
}
