package com.example.kira.orderfoodapp.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.kira.orderfoodapp.DTO.NhanVienDTO;
import com.example.kira.orderfoodapp.database.CreateDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KIRA on 10/11/2017.
 */

public class NhanVienDAO {
    SQLiteDatabase mDatabase;
    private CreateDatabase mCreateDatabase;

    public NhanVienDAO(Context context) {
        mCreateDatabase = new CreateDatabase(context);
    }

    public long ThemNhanVien(NhanVienDTO nhanVienDTO) {

        mDatabase = mCreateDatabase.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(CreateDatabase.TB_NHANVIEN_TENDN, nhanVienDTO.getTENDN());
        contentValues.put(CreateDatabase.TB_NHANVIEN_MATKHAU, nhanVienDTO.getMATKHAU());
        contentValues.put(CreateDatabase.TB_NHANVIEN_CMND, nhanVienDTO.getCMND());
        contentValues.put(CreateDatabase.TB_NHANVIEN_GIOITINH, nhanVienDTO.getGIOITINH());
        contentValues.put(CreateDatabase.TB_NHANVIEN_NGAYSINH, nhanVienDTO.getNGAYSINH());

        long kiemtra = mDatabase.insert(CreateDatabase.TB_NHANVIEN, null, contentValues);
        mDatabase.close();
        return kiemtra;
    }

    //Query All Items
    public List<NhanVienDTO> getAllItems() {
        List<NhanVienDTO> arrNhanVienDTOs = new ArrayList<NhanVienDTO>();

//        // Select All Query
//        String selectQuery = "SELECT * FROM " + CreateDatabase.TB_NHANVIEN;
//
//        mCreateDatabase.getReadableDatabase();
//
//        Cursor cursor = mDatabase.rawQuery(selectQuery, null);
//
//        //Looping through all rows and adding to list
//        if (cursor.moveToFirst()) {
//            do {
//                NhanVienDTO nhanVienDTO = new NhanVienDTO();
//                nhanVienDTO.setMANV(Integer.parseInt(cursor.getString(0)));
//                nhanVienDTO.setTENDN(cursor.getString(1));
//                nhanVienDTO.setMATKHAU(cursor.getString(2));
//                nhanVienDTO.setGIOITINH(cursor.getString(3));
//                nhanVienDTO.setNGAYSINH(cursor.getString(4));
//                nhanVienDTO.setCMND(Integer.parseInt(cursor.getString(5)));
//
//                //Adding Inventory to List
//                arrNhanVienDTOs.add(nhanVienDTO);
//            } while (cursor.moveToNext());
//        }
        //hp = new HashMap();
        mDatabase = mCreateDatabase.getReadableDatabase();
        Cursor cursor = mDatabase.query(CreateDatabase.TB_NHANVIEN, null, null, null, null, null, null);
        cursor.moveToFirst();
        int indextMANV= cursor.getColumnIndex(CreateDatabase.TB_NHANVIEN_MANV);
        int indextTENDN = cursor.getColumnIndex(CreateDatabase.TB_NHANVIEN_TENDN);
        int indextMATKHAU = cursor.getColumnIndex(CreateDatabase.TB_NHANVIEN_MATKHAU);
        int indextGIOITINH = cursor.getColumnIndex(CreateDatabase.TB_NHANVIEN_GIOITINH);
        int indextNGAYSINH = cursor.getColumnIndex(CreateDatabase.TB_NHANVIEN_NGAYSINH);
        int indextCMND = cursor.getColumnIndex(CreateDatabase.TB_NHANVIEN_CMND);
        while (!cursor.isAfterLast()){
            int maNv = cursor.getInt(indextMANV);
            String tenDn = cursor.getString(indextTENDN);
            String pass = cursor.getString(indextMATKHAU);
            String gioiTinh = cursor.getString(indextGIOITINH);
            String dateOfBirth = cursor.getString(indextNGAYSINH);
            int cmt = cursor.getInt(indextCMND);

            NhanVienDTO nhanVienDTO= new NhanVienDTO(maNv, tenDn, pass, gioiTinh, dateOfBirth, cmt);
            arrNhanVienDTOs.add(nhanVienDTO);

            Log.e("==============", "" + maNv + tenDn + pass + gioiTinh + dateOfBirth + cmt);
            cursor.moveToNext();
        }
        Log.e("NhanVienDAO.class","______________"+arrNhanVienDTOs);
        //Return Inventory List
        return arrNhanVienDTOs;

    }

}
