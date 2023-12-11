package com.example.myapplication;

import android.app.AlertDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class CalculatorActivity extends AppCompatActivity {

    MaterialToolbar materialToolbar;

    LinearLayout layout;

    TextView zakatnisab;

    MaterialButton zakathishab;
    TextInputEditText gold, silver, diposit, haj, bank, loan, animal, house, dokan, share, company, myLoan, beton, bill, due;

    String Sgold, Ssilver, Sdiposit, Shaj, Sbank, Sloan, Sanimal, Shouse, Sdokan, Sshare, Scompany, SmyLoan, Sbeton, Sbill, Sdue;

    float Fgold = 0, Fsilver = 0, Fdiposit = 0, Fhaj = 0, Fbank = 0, Floan = 0, Fanimal = 0, Fhouse = 0, Fdokan = 0, Fshare = 0, Fcompany = 0, FmyLoan = 0, Fbeton = 0, Fbill = 0, Fdue = 0;


    float zNisab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        materialToolbar = findViewById(R.id.materialToolbar);
        zakatnisab = findViewById(R.id.zakatnisab);
        layout = findViewById(R.id.layout);
        zakathishab = findViewById(R.id.zakathishab);


        //INPUT ==============================================

        gold = findViewById(R.id.gold);
        silver = findViewById(R.id.silver);
        diposit = findViewById(R.id.diposit);
        haj = findViewById(R.id.haj);
        bank = findViewById(R.id.bank);
        loan = findViewById(R.id.loan);
        animal = findViewById(R.id.animal);
        house = findViewById(R.id.house);
        dokan = findViewById(R.id.dokan);
        share = findViewById(R.id.company);
        company = findViewById(R.id.company);
        myLoan = findViewById(R.id.myLoan);
        beton = findViewById(R.id.beton);
        bill = findViewById(R.id.bill);
        due = findViewById(R.id.due);


        materialToolbar.setNavigationOnClickListener(v -> finish());

        ShowDialogBox();

        layout.setOnClickListener(v -> ShowDialogBox());


        zakathishab.setOnClickListener(v -> {


            //Toast.makeText(CalculatorActivity.this, "আপনার সম্পদের পরিমান দিন", Toast.LENGTH_SHORT).show();


            zakatHishab();
            //Toast.makeText(CalculatorActivity.this, "আপনার সম্পদের পরিমান দিন", Toast.LENGTH_SHORT).show();


        });


    }
    //==========================================================================================
    //==========================================================================================

    private void ShowDialogBox() {
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        View mView = getLayoutInflater().inflate(R.layout.nisab_dialogue, null);
        alert.setView(mView);

        final AlertDialog alertDialog = alert.create();
        alertDialog.setCancelable(false);


        TextView show = mView.findViewById(R.id.show);
        EditText editText = mView.findViewById(R.id.editText);


        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                String nisab = editText.getText().toString();
                float Fnisab = ParseFloat(nisab);
                zNisab = (float) (Fnisab * 52.5);
                show.setText("যাকাতের নিসাবঃ " + zNisab);

            }
        });


        mView.findViewById(R.id.batil).setOnClickListener(v -> {
            alertDialog.dismiss();
            finish();
        });

        mView.findViewById(R.id.add).setOnClickListener(v -> {
            // Toast.makeText(this, "Clicked OK BTN", Toast.LENGTH_SHORT).show();


            if (editText.getText().toString().isEmpty()) {

                Toast.makeText(this, "দয়া করে ১ ভরি (তোলা ) রুপা মূল্য লিখুন। ", Toast.LENGTH_SHORT).show();

            } else {
                zakatnisab.setText("যাকাতের নিসাবঃ " + zNisab);
                alertDialog.dismiss();

            }


        });

        alertDialog.show();
    }

    float ParseFloat(String strNumber) {
        if (strNumber != null && strNumber.length() > 0) {
            try {
                return Float.parseFloat(strNumber);

            } catch (Exception e) {
                return -1;   // or some value to mark this field is wrong. or make a function validates field first ...
            }
        } else return 0;
    }


    //==========================================================================================
    //==========================================================================================


    private void zakatHishab() {

        Sgold = gold.getText().toString();
        Ssilver = silver.getText().toString();
        Sdiposit = diposit.getText().toString();
        Shaj = haj.getText().toString();
        Sbank = bank.getText().toString();
        Sloan = loan.getText().toString();
        Sanimal = animal.getText().toString();
        Shouse = house.getText().toString();
        Sdokan = dokan.getText().toString();
        Sshare = share.getText().toString();
        Scompany = company.getText().toString();
        SmyLoan = myLoan.getText().toString();
        Sbeton = beton.getText().toString();
        Sbill = bill.getText().toString();
        Sdue = due.getText().toString();

        if (Sgold.length() > 0) {

            Fgold = Float.parseFloat(Sgold);
        } else {

            Fgold = 0;
        }


        if (Ssilver.length() > 0) {

            Fsilver = Float.parseFloat(Ssilver);
        } else {

            Fsilver = 0;
        }


        if (Sdiposit.length() > 0) {

            Fdiposit = Float.parseFloat(Sdiposit);
        } else {

            Fdiposit = 0;
        }


        if (Shaj.length() > 0) {

            Fhaj = Float.parseFloat(Shaj);
        } else {

            Fhaj = 0;
        }


        if (Sbank.length() > 0) {

            Fbank = Float.parseFloat(Sbank);
        } else {

            Fbank = 0;
        }


        if (Sloan.length() > 0) {

            Floan = Float.parseFloat(Sloan);
        } else {

            Floan = 0;
        }


        if (Sanimal.length() > 0) {

            Fanimal = Float.parseFloat(Sanimal);
        } else {

            Fanimal = 0;
        }


        if (Shouse.length() > 0) {

            Fhouse = Float.parseFloat(Shouse);
        } else {

            Fhouse = 0;
        }


        if (Sdokan.length() > 0) {

            Fdokan = Float.parseFloat(Sdokan);
        } else {

            Fdokan = 0;
        }


        if (Sshare.length() > 0) {

            Fshare = Float.parseFloat(Sshare);
        } else {

            Fshare = 0;
        }


        if (Scompany.length() > 0) {

            Fcompany = Float.parseFloat(Scompany);
        } else {

            Fcompany = 0;
        }


        if (SmyLoan.length() > 0) {

            FmyLoan = Float.parseFloat(SmyLoan);
        } else {

            FmyLoan = 0;
        }


        if (Sbeton.length() > 0) {

            Fbeton = Float.parseFloat(Sbeton);
        } else {

            Fbeton = 0;
        }


        if (Sbill.length() > 0) {

            Fbill = Float.parseFloat(Sbill);
        } else {

            Fbill = 0;
        }


        if (Sdue.length() > 0) {

            Fdue = Float.parseFloat(Sdue);
        } else {

            Fdue = 0;
        }

        float plus = Fgold + Fsilver + Fdiposit + Fhaj + Fbank + Floan + Fanimal + Fhouse + Fdokan + Fshare + Fcompany;

        float minus = FmyLoan + Fbeton + Fbill + Fdue;

        float MAIN = plus - minus;

        if (MAIN >= zNisab) {

            float Fzakat = (float) (MAIN * 0.025);
            ResultDialogBox(MAIN, Fzakat);

        } else {

            ResultDialogBox(MAIN, 0);
        }


    }

    //============================================================================================================


    private void ResultDialogBox(float Fmot, float Fz) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        View mView = getLayoutInflater().inflate(R.layout.result, null);
        alert.setView(mView);

        final AlertDialog alertDialog = alert.create();
        alertDialog.setCancelable(false);


        TextView mot = mView.findViewById(R.id.mot);
        TextView zakat = mView.findViewById(R.id.zakat);

        mot.setText("মোট সম্পদঃ " + Fmot);
        zakat.setText("যাকাতঃ " + Fz);


        mView.findViewById(R.id.add).setOnClickListener(v -> {

            alertDialog.dismiss();
            //startActivity(new Intent(CalculatorActivity.this,MainActivity.class));


        });

        alertDialog.show();
    }


    @Override
    public void onBackPressed() {

        //  startActivity(new Intent(CalculatorActivity.this,MainActivity.class));
        finish();

    }
}