package com.first.mycalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{
    private enum OPERATOR{
        PLUS, SUBTRACT, MULTIPLY, DIVIDE, EQUAL
    }
    TextView txtresult;
    TextView txtcalculation;


    private String Currentnumber;
    private String Stringnumberatleft="";
    private String Stringnumberatright ="";
    private OPERATOR Currentoperator;
    private int Calculationresult;
    private String Calculationstring="";

    private void numberistapped(int tappednumber){
        Currentnumber = Currentnumber + String.valueOf(tappednumber);
        txtresult.setText(Currentnumber);
        Calculationstring = Currentnumber;
        txtcalculation.setText(Calculationstring);
    }
    private void operatoristapped(OPERATOR tappedoperator) {
        if (Currentoperator != null ) {
            if (Currentnumber != "") {
                Stringnumberatright = Currentnumber;
                Currentnumber = "";

                switch (Currentoperator) {
                    case PLUS:
                        Calculationresult = Integer.parseInt(Stringnumberatleft) + Integer.parseInt(Stringnumberatright);
                        break;
                    case SUBTRACT:
                        Calculationresult = Integer.parseInt(Stringnumberatleft) - Integer.parseInt(Stringnumberatright);
                        break;
                    case DIVIDE:
                        Calculationresult = Integer.parseInt(Stringnumberatleft) / Integer.parseInt(Stringnumberatleft);
                        break;
                    case MULTIPLY:
                        Calculationresult = Integer.parseInt(Stringnumberatleft) * Integer.parseInt(Stringnumberatright);
                        break;
                }
                Stringnumberatleft = String.valueOf(Calculationresult);
                txtresult.setText(Stringnumberatleft);
                Calculationstring = Stringnumberatleft;
            }
        }else {
            Stringnumberatleft = Currentnumber;
            Currentnumber = "";

        }
        Currentoperator = tappedoperator;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Currentnumber ="";
        Calculationresult = 0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtresult = findViewById(R.id.txtresult);
        txtcalculation= findViewById(R.id.txtcalculation);
        findViewById(R.id.btnequal).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn1).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn2).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn3).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn4).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn5).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn5).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn6).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn7).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn8).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn9).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnclear).setOnClickListener(MainActivity.this);
        findViewById(R.id.btndivide).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnplus).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnsubtract).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnmultiply).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnzero).setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnequal:
                operatoristapped(OPERATOR.EQUAL);
                break;
            case R.id.btnplus:
                operatoristapped(OPERATOR.PLUS);
                Calculationstring = Calculationstring + " + ";
                break;
            case R.id.btnsubtract:
                operatoristapped(OPERATOR.SUBTRACT);
                Calculationstring = Calculationstring + " - ";
                break;
            case R.id.btnmultiply:
                operatoristapped(OPERATOR.MULTIPLY);
                Calculationstring = Calculationstring + " - ";
                break;
            case R.id.btndivide:
                operatoristapped(OPERATOR.DIVIDE);
                Calculationstring= Calculationstring + " + ";
                break;
            case R.id.btnclear:
                cleartapped();
                break;
            case R.id.btn1:
                numberistapped(1);
                break;
            case R.id.btn2:
                numberistapped(2);
                break;
            case R.id.btn3:
                numberistapped(3);
                break;
            case R.id.btn4:
                numberistapped(4);
                break;
            case R.id.btn5:
                numberistapped(5);
                break;
            case R.id.btn6:
                numberistapped(6);
                break;
            case R.id.btn7:
                numberistapped(7);
                break;
            case R.id.btn8:
                numberistapped(8);
                break;
            case R.id.btn9:
                numberistapped(9);
                break;
            case R.id.btnzero:
                numberistapped(0);
                break;


        }
        txtcalculation.setText(Calculationstring);


    }
    private void cleartapped()
    {
        Stringnumberatleft="";
        Stringnumberatright="";
        Calculationresult=0;
        Currentnumber="";
        Currentoperator= null;
        txtresult.setText("0");
        Calculationstring="";
        txtcalculation.setText("");
    }
}
