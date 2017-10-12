package com.example.kira.orderfoodapp.FragmentApp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.kira.orderfoodapp.R;

/**
 * Created by KIRA on 10/11/2017.
 */

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int date) {
        EditText edNgaySinh = getActivity().findViewById(R.id.edNgaySinhDK);
        String ngaySinh = date+"/"+(month +1)+"/"+year;
        edNgaySinh.setText(ngaySinh);
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        Calendar calendar = Calendar.getInstance();
        int iNam = calendar.get(Calendar.YEAR);
        int iMon = calendar.get(Calendar.MONTH);
        int iNgay = calendar.get(Calendar.DAY_OF_MONTH);
        return  new DatePickerDialog(getActivity(),this,iNam,iMon,iNgay);
    }
}
