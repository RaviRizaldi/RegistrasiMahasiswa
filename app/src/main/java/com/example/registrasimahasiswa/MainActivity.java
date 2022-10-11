package com.example.registrasimahasiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

public abstract class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
EditText etnm;
EditText etem;
EditText etps;
RadioGroup rb;
RadioButton rb2;
SeekBar sb;
Spinner sp;
ToggleButton tb;
TextView tu,tp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Inputan
        etnm = findViewById(R.id.etnm);
        etem = findViewById(R.id.etem);
        etps = findViewById(R.id.etps);

        //JenisKelamin
        rb = findViewById(R.id.rb);

        //Usia
        sb = findViewById(R.id.sb);
        tu = findViewById(R.id.tu);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean FromUser) {
                tu.setText(String.valueOf(progress + "Tahun"));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //Asrama
        tb = findViewById(R.id.tb);

        //Prodi
            sp = findViewById(R.id.sp);
            tp = findViewById(R.id.tp);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.nama_Prodi, android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent,View view, int position, long id){
        String programstudi = parent.getItemAtPosition(position).toString();
        tp.setText(String.valueOf(programstudi));
    }
    public void onNothingSelected(AdapterView<?> parent){


    }
    public void kirimdata(View view) {
        int idradio = rb.getCheckedRadioButtonId();
        rb2 = findViewById(idradio);

        Intent i1 = new Intent(this, HasilActivity.class);
        i1.putExtra( "nama",etnm.getText().toString());
        i1.putExtra( "email",etem.getText().toString());
        i1.putExtra( "katasandi",etps.getText().toString());
        i1.putExtra( "jeniskelamin",rb2.getText().toString());
        i1.putExtra( "usia",tu.getText().toString());
        i1.putExtra( "prodi",tp.getText().toString());
        i1.putExtra( "asrama",tb.getText().toString());
        startActivity(i1);
    }
}