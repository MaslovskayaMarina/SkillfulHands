package com.example.skillfulhands.Views;

import android.app.DatePickerDialog;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.skillfulhands.R;
import com.example.skillfulhands.Succesfully;
import com.example.skillfulhands.ViewModels.MakeOrderViewModel;
import com.example.skillfulhands.databinding.CreateOrderBinding;
import com.example.skillfulhands.databinding.InformationAboutBinding;

import java.util.Locale;

@RequiresApi(api = Build.VERSION_CODES.N)
public class MakeOrderFragment extends Fragment {
    final Calendar myCalendar = Calendar.getInstance();
    EditText editText;

    private MakeOrderViewModel order;
    private CreateOrderBinding binding;

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.create_order, container, false);
        order = new ViewModelProvider(this).get(MakeOrderViewModel.class);

        binding = CreateOrderBinding.bind(v);
        Button angryButton = binding.angryBtn;

        Spinner dropdown = v.findViewById(R.id.spinner1);
        String[] devices = new String[]{getResources().getString(R.string.choice), "Компьютер", "Телевизор", "Телефон", "Наушники", "Магнитофон", "Микрофон", "Принтер"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.spiner_item, devices);
        dropdown.setAdapter(adapter);

        Spinner dropdown2 = v.findViewById(R.id.spinner2);
        String[] problems = new String[]{getResources().getString(R.string.choice), "Дисплей", "Клавиатура", "Динамики", "Видеокарта", "Картридж"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(), R.layout.spiner_item, problems);
        dropdown2.setAdapter(adapter2);

        Spinner dropdown3 = v.findViewById(R.id.spinner3);
        String[] masters = new String[]{getResources().getString(R.string.choice), "Геннадий Масловский", "Марина Масловская", "Степан Беркунов"};
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(getActivity(), R.layout.spiner_item, masters);
        dropdown3.setAdapter(adapter3);

        //editText=(EditText) v.findViewById(R.id.date_choice);
        editText = binding.dateChoice;
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
                new DatePickerDialog(getActivity(),date,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        angryButton.setOnClickListener(new View.OnClickListener() { // ДЛЯ КНОПКИ!!!
            @Override
            public void onClick(View v) {
                String clientFullName = binding.fioInput.getText().toString();
                String clientPhoneNum = binding.phoneNumInput.getText().toString();
                String deviceType = dropdown.getSelectedItem().toString();
                String problemType = dropdown2.getSelectedItem().toString();
                String problemDesc = binding.problemText.getText().toString();
                String clientMaster = dropdown3.getSelectedItem().toString();
                String dateToCome = binding.dateChoice.getText().toString();
                String promoCode = binding.promocodeInput.getText().toString();

                order.makeOrder(clientFullName, clientPhoneNum, deviceType, problemType, problemDesc, clientMaster, dateToCome, promoCode);

                Fragment someFragment = new Succesfully();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.My2st, someFragment );
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return v;
    }
    private void updateLabel(){
        String myFormat="MM/dd/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        editText.setText(dateFormat.format(myCalendar.getTime()));
    }
}