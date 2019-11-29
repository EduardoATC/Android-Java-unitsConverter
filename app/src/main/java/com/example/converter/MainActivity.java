package com.example.converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Type;


public class MainActivity extends AppCompatActivity {
    private Spinner TypeSpinner;
    private Spinner UnitsSpinner;
    private Spinner UnitsSpinner2;
    private EditText cantidad;
    private TextView resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TypeSpinner = findViewById(R.id.spinnerType);
        ArrayAdapter <CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.typeOfUnits, android.R.layout.simple_spinner_item);
        TypeSpinner.setAdapter(adapter);
        adapter.setDropDownViewResource(R.layout.spinner_style);

        UnitsSpinner = findViewById(R.id.spinnerUnits);

        UnitsSpinner2 = findViewById(R.id.spinnerUnits2);



        applyMethods ();


    }

    /**
     * Según la selección de capa Spinner aplica los métodos correspondientes
     */
    void applyMethods () {

            TypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (TypeSpinner.getSelectedItem().toString().equals("Foreign exchange")){
                    spinnersContent ();
                    foreignExchange ();
                }
                else  if (TypeSpinner.getSelectedItem().toString().equals("Data units")){
                    spinnersContent ();
                    dataUnits ();
                }
                else if (TypeSpinner.getSelectedItem().toString().equals("Temperature")){
                    spinnersContent ();
                    temperature ();
;
                }
                else if (TypeSpinner.getSelectedItem().toString().equals("Distance")){
                    spinnersContent ();
                    distance();

                }



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




    }

    /**
     * Realiza las diferentes conversiones de divisas basandose en la posición de la selección de cada Spinner
     */
    void foreignExchange (){
            resultado = findViewById(R.id.resultado);
            cantidad = findViewById(R.id.cantidad);
            cantidad.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int entero;

                if (UnitsSpinner.getSelectedItemPosition()== UnitsSpinner2.getSelectedItemPosition()) {
                    resultado.setText(cantidad.getText());

                }

                else if (cantidad.getText().toString().isEmpty()){
                    resultado.setText("");
                }


                                    //Euro

                else if (UnitsSpinner.getSelectedItemPosition() == 0 && UnitsSpinner2.getSelectedItemPosition()== 1) {
                    //euro a dolar
                    entero = Integer.parseInt(cantidad.getText().toString());
                    resultado.setText(String.valueOf(entero * 1.13) + " " + "$");
                }

                else if (UnitsSpinner.getSelectedItemPosition() == 0 && UnitsSpinner2.getSelectedItemPosition()== 2) {
                    //euro a libra
                    entero = Integer.parseInt(cantidad.getText().toString());
                    resultado.setText(String.valueOf(entero * 0.87) + " " + "£");
                }
                else if (UnitsSpinner.getSelectedItemPosition() == 0 && UnitsSpinner2.getSelectedItemPosition()== 3) {
                    //euro a yen
                    entero = Integer.parseInt(cantidad.getText().toString());
                    resultado.setText(String.valueOf(entero * 124.97) + " " + "¥");
                }


                                //Dolar

                else if (UnitsSpinner.getSelectedItemPosition() == 1 && UnitsSpinner2.getSelectedItemPosition()== 0){
                    //dolar a euro
                        entero = Integer.parseInt(cantidad.getText().toString());
                        resultado.setText(String.valueOf(entero * 0.88) + " " + "£");

                }

                else if (UnitsSpinner.getSelectedItemPosition() == 1 && UnitsSpinner2.getSelectedItemPosition()== 2){
                    //dolar a libra
                    entero = Integer.parseInt(cantidad.getText().toString());
                    resultado.setText(String.valueOf(entero * 0.77) + " " + "£");

                }
                else if (UnitsSpinner.getSelectedItemPosition() == 1 && UnitsSpinner2.getSelectedItemPosition()== 3){
                    //dolar a yen
                    entero = Integer.parseInt(cantidad.getText().toString());
                    resultado.setText(String.valueOf(entero * 110.78) + " " + "¥");

                }

                                                //Pound

                else if (UnitsSpinner.getSelectedItemPosition() == 2 && UnitsSpinner2.getSelectedItemPosition()== 0) {
//                              Pound a euro
                    entero = Integer.parseInt(cantidad.getText().toString());
                    resultado.setText(String.valueOf(entero * 1.15) + " " + "€");
                }
                                     //Pound a dollar
                else if (UnitsSpinner.getSelectedItemPosition() == 2 && UnitsSpinner2.getSelectedItemPosition()== 1) {

                    entero = Integer.parseInt(cantidad.getText().toString());
                    resultado.setText(String.valueOf(entero * 1.29) + " " + "$");
                }
                //Pound a yen
                else if (UnitsSpinner.getSelectedItemPosition() == 2 && UnitsSpinner2.getSelectedItemPosition()== 3) {

                    entero = Integer.parseInt(cantidad.getText().toString());
                    resultado.setText(String.valueOf(entero * 143.21) + " " + "¥");
                }



                //Yen
                else if (UnitsSpinner.getSelectedItemPosition() == 3 && UnitsSpinner2.getSelectedItemPosition()== 0) {
                                //Yen a euro
                    entero = Integer.parseInt(cantidad.getText().toString());
                    resultado.setText(String.valueOf(entero * 0.0080) + " " + "€");
                }
                            //Yen a dolar
                else if (UnitsSpinner.getSelectedItemPosition() == 3 && UnitsSpinner2.getSelectedItemPosition()== 1) {

                    entero = Integer.parseInt(cantidad.getText().toString());
                    resultado.setText(String.valueOf(entero * 0.0090) + " " + "$");
                }
                //yen a libra
                else if (UnitsSpinner.getSelectedItemPosition() == 3 && UnitsSpinner2.getSelectedItemPosition()== 2) {

                    entero = Integer.parseInt(cantidad.getText().toString());
                    resultado.setText(String.valueOf(entero * 0.0070) + " " + "£");
                }

            }
        });


     }

    /**
     * Realiza las diferentes conversiones de unidades de datos basandose en la posición de la selección de cada Spinner
     */
    void dataUnits () {


                cantidad.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {

                    int entero;

                    if (UnitsSpinner.getSelectedItemPosition()== UnitsSpinner2.getSelectedItemPosition()) {
                        resultado.setText(cantidad.getText());

                    }

                    else if (cantidad.getText().toString().isEmpty()){
                        resultado.setText("");
                    }

                                        //KB
                    else if (UnitsSpinner.getSelectedItemPosition() == 0 && UnitsSpinner2.getSelectedItemPosition()== 1) {
                        //Kb to Mb
                        entero = Integer.parseInt(cantidad.getText().toString());
                        resultado.setText(String.valueOf( (double) entero / 1024) + " " + "MB");
                    }
                    else if (UnitsSpinner.getSelectedItemPosition() == 0 && UnitsSpinner2.getSelectedItemPosition()== 2) {
                        //Kb to Gb
                        entero = Integer.parseInt(cantidad.getText().toString());
                        resultado.setText(String.valueOf(entero / 1e6) + " " + "Gb");
                    }
                    else if (UnitsSpinner.getSelectedItemPosition() == 0 && UnitsSpinner2.getSelectedItemPosition()== 3) {
                        //Kb to Tb
                        entero = Integer.parseInt(cantidad.getText().toString());
                        resultado.setText(String.valueOf(entero /(1e9)) + " " + "Tb");
                    }

                                                //Mb

                    else if (UnitsSpinner.getSelectedItemPosition() == 1 && UnitsSpinner2.getSelectedItemPosition()== 0) {
                        //Mb to Kb
                        entero = Integer.parseInt(cantidad.getText().toString());
                        resultado.setText(String.valueOf(entero * 1000) + " " + "Kb");
                    }
                    else if (UnitsSpinner.getSelectedItemPosition() == 1 && UnitsSpinner2.getSelectedItemPosition()== 2) {
                        //Mb to Gb
                        entero = Integer.parseInt(cantidad.getText().toString());
                        resultado.setText(String.valueOf((double) entero / 1000) + " " + "Gb");
                    }
                    else if (UnitsSpinner.getSelectedItemPosition() == 1 && UnitsSpinner2.getSelectedItemPosition()== 3) {
                        //Mb to Tb
                        entero = Integer.parseInt(cantidad.getText().toString());
                        resultado.setText(String.valueOf(entero /(1e6)) + " " + "Tb");
                    }


                                    //Gb
                    else if (UnitsSpinner.getSelectedItemPosition() == 2 && UnitsSpinner2.getSelectedItemPosition()== 0) {
                        //Gb to Kb
                        entero = Integer.parseInt(cantidad.getText().toString());
                        resultado.setText(String.valueOf(entero * 1e6) + " " + "Kb");
                    }
                    else if (UnitsSpinner.getSelectedItemPosition() == 2 && UnitsSpinner2.getSelectedItemPosition()== 1) {
                        //Gb to Mb
                        entero = Integer.parseInt(cantidad.getText().toString());
                        resultado.setText(String.valueOf(entero * 1000) + " " + "Mb");
                    }
                    else if (UnitsSpinner.getSelectedItemPosition() == 2 && UnitsSpinner2.getSelectedItemPosition()== 3) {
                        //Gb to Tb
                        entero = Integer.parseInt(cantidad.getText().toString());
                        resultado.setText(String.valueOf((double)entero / 1000) + " " + "Tb");
                    }

                                        //Tb
                    else if (UnitsSpinner.getSelectedItemPosition() == 3 && UnitsSpinner2.getSelectedItemPosition()== 0) {
                        //Tb to Kb
                        entero = Integer.parseInt(cantidad.getText().toString());
                        resultado.setText(String.valueOf(entero * 1e9) + " " + "Kb");
                    }
                    else if (UnitsSpinner.getSelectedItemPosition() == 3 && UnitsSpinner2.getSelectedItemPosition()== 1) {
                        //Tb to Mb
                        entero = Integer.parseInt(cantidad.getText().toString());
                        resultado.setText(String.valueOf(entero * 1e6) + " " + "Mb");
                    }
                    else if (UnitsSpinner.getSelectedItemPosition() == 3 && UnitsSpinner2.getSelectedItemPosition()== 2) {
                        //Tb to Gb
                        entero = Integer.parseInt(cantidad.getText().toString());
                        resultado.setText(String.valueOf(entero * 1000) + " " + "Gb");
                    }


                }
            });



    }
    /**
     * Realiza las diferentes conversiones de distancia basandose en la posición de la selección de cada Spinner
     */
    void distance () {
            resultado = findViewById(R.id.resultado);
            cantidad = findViewById(R.id.cantidad);
            cantidad.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                int entero;

                if (UnitsSpinner.getSelectedItemPosition()== UnitsSpinner2.getSelectedItemPosition()) {
                    resultado.setText(cantidad.getText());

                }

                else if (cantidad.getText().toString().isEmpty()){
                    resultado.setText("");
                }

                                    //Kilometer

                else if (UnitsSpinner.getSelectedItemPosition() == 0 && UnitsSpinner2.getSelectedItemPosition()== 1) {
                        //Km to mile
                    entero = Integer.parseInt(cantidad.getText().toString());
                    resultado.setText(String.valueOf((double)entero /1.069) + " " + "M");
                }

                else if (UnitsSpinner.getSelectedItemPosition() == 1 && UnitsSpinner2.getSelectedItemPosition()== 0) {
                    //mile to Km
                    entero = Integer.parseInt(cantidad.getText().toString());
                    resultado.setText(String.valueOf((double) entero *1.069) + " " + "Km");
                }

            }
        });




    }

    /**
     * Realiza las diferentes conversiones de temperatura basandose en la posición de la selección de cada Spinner
     */
    void temperature () {
            resultado = findViewById(R.id.resultado);
            cantidad = findViewById(R.id.cantidad);
            cantidad.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                int entero;

                if (UnitsSpinner.getSelectedItemPosition()== UnitsSpinner2.getSelectedItemPosition()) {
                    resultado.setText(cantidad.getText());

                }

                else if (cantidad.getText().toString().isEmpty()){
                    resultado.setText("");
                }

                else if (UnitsSpinner.getSelectedItemPosition() == 0 && UnitsSpinner2.getSelectedItemPosition()== 1) {
                    //Fh to C
                    entero = Integer.parseInt(cantidad.getText().toString());
                    resultado.setText(String.valueOf(((entero-32)*(0.5555)))  + " " + "C");
                }

                else if (UnitsSpinner.getSelectedItemPosition() == 1 && UnitsSpinner2.getSelectedItemPosition()== 0) {
                    //C to Fh
                    entero = Integer.parseInt(cantidad.getText().toString());
                    resultado.setText(String.valueOf(((entero * 0.555) +32)) + " " + "Fh");
                }

            }
        });




    }

    /**
     * Añade contenid a los Spinners
     */

    void spinnersContent () {
        if (TypeSpinner.getSelectedItem().toString().equals("Foreign exchange")) {
            ArrayAdapter<CharSequence> adapterUnitsForeing = ArrayAdapter.createFromResource(MainActivity.this, R.array.foreign_exchange_array, android.R.layout.simple_spinner_item);

            UnitsSpinner.setAdapter(adapterUnitsForeing);
            adapterUnitsForeing.setDropDownViewResource(R.layout.spinner_style);
            UnitsSpinner2.setAdapter(adapterUnitsForeing);
            adapterUnitsForeing.setDropDownViewResource(R.layout.spinner_style);
        }

        else  if (TypeSpinner.getSelectedItem().toString().equals("Data units")){
            ArrayAdapter <CharSequence> adapterUnitsData = ArrayAdapter.createFromResource(MainActivity.this , R.array.data_units_array, android.R.layout.simple_spinner_item);

            UnitsSpinner.setAdapter(adapterUnitsData);
            adapterUnitsData.setDropDownViewResource(R.layout.spinner_style);
            UnitsSpinner2.setAdapter(adapterUnitsData);
            adapterUnitsData.setDropDownViewResource(R.layout.spinner_style);

        }
        else if (TypeSpinner.getSelectedItem().toString().equals("Temperature")){
            ArrayAdapter <CharSequence> adapterUnitsTemperature = ArrayAdapter.createFromResource(MainActivity.this , R.array.units_temperature_array, android.R.layout.simple_spinner_item);

            UnitsSpinner.setAdapter(adapterUnitsTemperature);
            adapterUnitsTemperature.setDropDownViewResource(R.layout.spinner_style);
            UnitsSpinner2.setAdapter(adapterUnitsTemperature);
            adapterUnitsTemperature.setDropDownViewResource(R.layout.spinner_style);


        }
        else if (TypeSpinner.getSelectedItem().toString().equals("Distance")){
            ArrayAdapter <CharSequence> adapterUnitsDistance = ArrayAdapter.createFromResource(MainActivity.this , R.array.units_distance_array, android.R.layout.simple_spinner_item);

            UnitsSpinner.setAdapter(adapterUnitsDistance);
            adapterUnitsDistance.setDropDownViewResource(R.layout.spinner_style);
            UnitsSpinner2.setAdapter(adapterUnitsDistance);
            adapterUnitsDistance.setDropDownViewResource(R.layout.spinner_style);

        }



    }
 }


