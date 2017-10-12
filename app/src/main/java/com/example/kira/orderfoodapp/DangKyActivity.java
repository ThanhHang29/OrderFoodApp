package com.example.kira.orderfoodapp;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.kira.orderfoodapp.DAO.NhanVienDAO;
import com.example.kira.orderfoodapp.DTO.NhanVienDTO;
import com.example.kira.orderfoodapp.FragmentApp.DatePickerFragment;
import com.example.kira.orderfoodapp.database.CreateDatabase;

import java.util.ArrayList;

public class DangKyActivity extends AppCompatActivity implements View.OnClickListener ,View.OnFocusChangeListener{

    EditText edDangKyDK,edMatKhauDK,edNgaySinhDK,edCMNDDK;
    Button btnDongYDK,btnThoatDK;
    RadioGroup rgGioitinhDK;
    RadioButton gioiTinhNam, gioiTinhNu;
    String gioiTinh;
    private ArrayList<NhanVienDTO> arrNhanVienDTOs;
    private CreateDatabase mCreateDatabase;
    private NhanVienDAO nhanVienDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dangky);

        nhanVienDAO = new NhanVienDAO(this);
        arrNhanVienDTOs = new ArrayList<>();
        arrNhanVienDTOs.addAll(nhanVienDAO.getAllItems());
        edDangKyDK = (EditText) findViewById(R.id.edDangKyDK);
        edNgaySinhDK = (EditText) findViewById(R.id.edNgaySinhDK);
        edMatKhauDK = (EditText) findViewById(R.id.edMatKhauDK);
        edCMNDDK = (EditText) findViewById(R.id.edCMNDDK);

        btnDongYDK = (Button) findViewById(R.id.btnDongYDK);
        btnThoatDK = (Button) findViewById(R.id.btnThoatDK);

        rgGioitinhDK = (RadioGroup) findViewById(R.id.rgGioitinhDK);
        gioiTinhNam = (RadioButton) findViewById(R.id.rgNamDK);
        gioiTinhNu = (RadioButton) findViewById(R.id.rgNuDK);

        btnDongYDK.setOnClickListener(this);
        btnThoatDK.setOnClickListener(this);
        edNgaySinhDK.setOnFocusChangeListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id)
        {
            case R.id.btnDongYDK:
            {
                DongYComman();
                break;
            }
            case R.id.btnThoatDK:
            {

                finish();
                break;
            }
            default:
                break;
        }
    }

    private void DongYComman() {
        String tenDangNhap = edDangKyDK.getText().toString();
        String matKhau = edMatKhauDK.getText().toString();
        getGioiTinh();
//        switch (rgGioitinhDK.getCheckedRadioButtonId())
//        {
//            case R.id.rgNamDK:
//                gioiTinh="Nam";break;
//            case R.id.rgNuDK:
//                gioiTinh="Nữ";break;
//        }
        String ngaySinh = edNgaySinhDK.getText().toString();
        String Cmnd = edCMNDDK.getText().toString();

        if(tenDangNhap.isEmpty()){
            Toast.makeText(DangKyActivity.this,getResources().getString(R.string.nhapten),Toast.LENGTH_SHORT).show();
        }else{

            NhanVienDTO nhanVienDTO = new NhanVienDTO(1, tenDangNhap, matKhau, gioiTinh, ngaySinh, Integer.parseInt(Cmnd));


            long aiResult = nhanVienDAO.ThemNhanVien(nhanVienDTO);
            Log.e("DangkyActivity", "/////////////"+nhanVienDTO.toString());
            if(aiResult != 0){
                Toast.makeText(DangKyActivity.this,"Success",Toast.LENGTH_SHORT).show();
            }else
            {
                Toast.makeText(DangKyActivity.this,"Failed",Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void getGioiTinh() {

        rgGioitinhDK.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int idButton) {
                switch (idButton){
                    case R.id.rgNamDK:
                        gioiTinh = "Nam";
                        break;
                    case R.id.rgNuDK:
                        gioiTinh = "Nu";
                        break;
                }
            }
        });

    }

    @Override
    public void onFocusChange(View view, boolean b) {
        int id = view.getId();
        switch (id){
            case R.id.edNgaySinhDK:
            {
                focusNgaySinh(b);
                break;
            }
            default:
                break;
        }
    }

    private void focusNgaySinh(boolean hasFocus) {
        if(hasFocus){
            DatePickerFragment datePickerFragment = new DatePickerFragment();
            datePickerFragment.show(getFragmentManager(),"Ngày Sinh ");
        }
    }
}
