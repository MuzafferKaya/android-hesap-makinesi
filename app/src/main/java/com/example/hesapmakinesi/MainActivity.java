package com.example.hesapmakinesi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnSilme, btnCE, btnC, btnToplama, btnCikartma, btnBolme, btnCarpma, btnYuzde, btnEsittir;
    EditText txtSayi;
    public float Sayi1 = 0;
    public String Operator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtSayi = findViewById(R.id.txtSayi);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnSilme = findViewById(R.id.btnSilme);
        btnCE = findViewById(R.id.btnCe);
        btnC = findViewById(R.id.btnC);
        btnToplama = findViewById(R.id.btnToplama);
        btnCikartma = findViewById(R.id.btnCikartma);
        btnBolme = findViewById(R.id.btnBolme);
        btnCarpma = findViewById(R.id.btnCarpma);
        btnYuzde = findViewById(R.id.btnYuzde);
        btnEsittir = findViewById(R.id.btnEsittir);

        btn0.setOnClickListener(this::btnSayi);
        btn1.setOnClickListener(this::btnSayi);
        btn2.setOnClickListener(this::btnSayi);
        btn3.setOnClickListener(this::btnSayi);
        btn4.setOnClickListener(this::btnSayi);
        btn5.setOnClickListener(this::btnSayi);
        btn6.setOnClickListener(this::btnSayi);
        btn7.setOnClickListener(this::btnSayi);
        btn8.setOnClickListener(this::btnSayi);
        btn9.setOnClickListener(this::btnSayi);

        btnToplama.setOnClickListener(this::btnOperator);
        btnCikartma.setOnClickListener(this::btnOperator);
        btnCarpma.setOnClickListener(this::btnOperator);
        btnBolme.setOnClickListener(this::btnOperator);
        btnYuzde.setOnClickListener(this::btnOperator);

        btnEsittir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (Operator){
                    case "+":
                        Sayi1 += Float.parseFloat(txtSayi.getText().toString());
                        break;
                    case "-":
                        Sayi1 -= Float.parseFloat(txtSayi.getText().toString());
                        break;
                    case "×":
                        Sayi1 *= Float.parseFloat(txtSayi.getText().toString());
                        break;
                    case "÷":
                        Sayi1 /= Float.parseFloat(txtSayi.getText().toString());
                        break;
                    case "%":
                        Sayi1 %= Float.parseFloat(txtSayi.getText().toString());
                        break;
                }
                txtSayi.setHint(Float.toString(Sayi1));
                txtSayi.setText("");
            }
        });

        btnSilme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = txtSayi.getText().toString();
                if (text.length() > 0) {
                    String newText = text.substring(0, text.length() - 1);
                    txtSayi.setText(newText);
                }
                else{
                    txtSayi.setHint("0");
                }
            }
        });

        btnCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtSayi.setHint("0");
                txtSayi.setText("");
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtSayi.setHint("0");
                txtSayi.setText("");
                Sayi1 = 0;
            }
        });
    }

    public void btnSayi(View View){
        Button Sayi = findViewById(View.getId());
        txtSayi.setText(txtSayi.getText().toString() + Sayi.getText());
    }

    public void btnOperator(View View){
        Button Operatorler = findViewById(View.getId());
        Operator = Operatorler.getText().toString();
        if(Sayi1 != 0){
            switch (Operator){
                case "+":
                    Sayi1 += Float.parseFloat(txtSayi.getText().toString());
                    break;
                case "-":
                    Sayi1 -= Float.parseFloat(txtSayi.getText().toString());
                    break;
                case "×":
                    Sayi1 *= Float.parseFloat(txtSayi.getText().toString());
                    break;
                case "÷":
                    Sayi1 /= Float.parseFloat(txtSayi.getText().toString());
                    break;
                case "%":
                    Sayi1 %= Float.parseFloat(txtSayi.getText().toString());
                    break;
            }
            txtSayi.setHint(Float.toString(Sayi1));
            txtSayi.setText("");
        }
        else{
            Sayi1 = Float.parseFloat(txtSayi.getText().toString());
            txtSayi.setText("");
        }
    }
}