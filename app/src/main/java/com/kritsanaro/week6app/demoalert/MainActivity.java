package com.kritsanaro.week6app.demoalert;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_alert,btn_input_alert,btn_custom_alert;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //bind widget
        btn_alert = findViewById(R.id.btn_alert);
        btn_input_alert = findViewById(R.id.btn_input_alert);
        btn_custom_alert = findViewById(R.id.btn_custom_alert);


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

        btn_custom_alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                custom_alert();
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

    private void custom_alert(){

        final AlertDialog dialog;
        AlertDialog.Builder toniAlert = new AlertDialog.Builder(context);

        LayoutInflater inflater = getLayoutInflater();
        View customLayout = inflater.inflate(R.layout.layout_custom,null);

        final EditText et_fullname = customLayout.findViewById(R.id.et_fullname);
        final EditText et_phone = customLayout.findViewById(R.id.et_phone);
        Button btn_save = customLayout.findViewById(R.id.btn_save);
        Button btn_close = customLayout.findViewById(R.id.btn_close);

        toniAlert.setIcon(getResources().getDrawable(R.drawable.ic_warning));
        toniAlert.setTitle("ข้อมูลส่วนตัว");
        toniAlert.setView(customLayout);

        dialog = toniAlert.show();

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fullname = et_fullname.getText().toString();
                String phone  = et_phone.getText().toString();
                Toast.makeText(context,
                        "FULL NAME :"+fullname+" \n PHONE : "+phone,
                        Toast.LENGTH_SHORT).show();
                dialog.dismiss();

            }
        });
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });





    }

}
