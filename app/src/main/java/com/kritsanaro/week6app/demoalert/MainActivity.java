package com.kritsanaro.week6app.demoalert;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_alert,btn_input_alert;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //bind widget
        btn_alert = findViewById(R.id.btn_alert);
        btn_input_alert = findViewById(R.id.btn_input_alert);

        context = MainActivity.this;

        btn_alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDemo();
            }
        });

        btn_input_alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertInput();
            }
        });
    }

    private  void alertDemo(){

        AlertDialog.Builder dialogDemo = new AlertDialog.Builder(context);
        dialogDemo.setIcon(getResources().getDrawable(R.drawable.ic_warning));
        dialogDemo.setTitle("คำเตือน");
        dialogDemo.setMessage("คุณต้องการที่จะซื้อ Red Label ?? ");
        dialogDemo.setPositiveButton("ยกเลิก", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context,
                        "คุณได้กด ยกเลิก"
                        , Toast.LENGTH_SHORT).show();
            }
        });

        dialogDemo.setNegativeButton("ตกลง", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Toast.makeText(context,
                        "คุณได้กด ตกลง!"
                        , Toast.LENGTH_SHORT).show();
            }
        });

        dialogDemo.show();
    }

    private  void alertInput(){

        AlertDialog.Builder dialogDemo = new AlertDialog.Builder(context);
        dialogDemo.setIcon(getResources().getDrawable(R.drawable.ic_warning));

        final EditText inputEt = new EditText(context);

        dialogDemo.setTitle("คำเตือน");
        dialogDemo.setMessage("กรุณาป้อนชื่อของคุณ !");

        dialogDemo.setView(inputEt);

        dialogDemo.setPositiveButton("ยกเลิก", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context,
                        "คุณได้กด ยกเลิก"
                        , Toast.LENGTH_SHORT).show();
            }
        });

        dialogDemo.setNegativeButton("ตกลง", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String inputStr = inputEt.getText().toString();

                Toast.makeText(context,
                        "สวัสดีคุณ : "+inputStr
                        , Toast.LENGTH_SHORT).show();
            }
        });

        dialogDemo.show();
    }

}
