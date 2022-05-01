package com.example.skillfulhands;

import android.app.DatePickerDialog;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import java.util.Locale;

@RequiresApi(api = Build.VERSION_CODES.N)
public class OrderActivity extends AppCompatActivity {

    final Calendar myCalendar= Calendar.getInstance();
    EditText editText;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_order);
        Button angryButton = (Button) findViewById(R.id.angry_btn);
        angryButton.setOnClickListener(new View.OnClickListener() { // ДЛЯ КНОПКИ!!!
            public void onClick(View v) {
// Click event trigger here
            }
        });
        getSupportActionBar().hide();
        Spinner dropdown = findViewById(R.id.spinner_);
        String[] devices = new String[]{getResources().getString(R.string.choice), "Компьютер", "Телевизор", "Телефон", "Наушники", "Магнитофон", "Микрофон", "Принтер"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spiner_item, devices);
        dropdown.setAdapter(adapter);
        Spinner dropdown2 = findViewById(R.id.spinner__);
        String[] problems = new String[]{getResources().getString(R.string.choice), "Дисплей", "Клавиатура", "Динамики", "Видеокарта", "Картридж"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, R.layout.spiner_item, problems);
        dropdown2.setAdapter(adapter2);
        Spinner dropdown3 = findViewById(R.id.spinner___);
        String[] masters = new String[]{getResources().getString(R.string.choice), "Геннадий Масловский", "Марина Масловская", "Степан Беркунов"};
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, R.layout.spiner_item, masters);
        dropdown3.setAdapter(adapter3);
        editText=(EditText) findViewById(R.id.ВыберитеДату);
        DatePickerDialog.OnDateSetListener date =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                updateLabel();
            }
        };
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(OrderActivity.this,date,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }
    private void updateLabel(){
        String myFormat="MM/dd/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        editText.setText(dateFormat.format(myCalendar.getTime()));
    }

}
