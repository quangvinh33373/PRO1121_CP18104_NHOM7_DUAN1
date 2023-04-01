package vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Crud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DAO {
    DBHelper dbHelper;

    public DAO(Context context) {
        dbHelper=new DBHelper(context);
    }
    public long themKH(ADD_Product products){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("TenSp",products.getTenSp());
        values.put("SoLuong",products.getSoluong());
        values.put("Size",products.getSize());
        values.put("MoTa",products.getMota());
        return db.insert("sanPham",null,values);
    }
    public long inseinsertSp(ADD_Product products){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("TenSp",products.getTenSp());
        values.put("SoLuong",products.getSoluong());
        values.put("Size",products.getSize());
        values.put("MoTa",products.getMota());
        return db.insert("sanPham",null,values);
    }

    public long update(ADD_Product products) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("TenSp",products.getTenSp());
        values.put("SoLuong",products.getSoluong());
        values.put("Size",products.getSize());
        values.put("MoTa",products.getMota());
        return db.update("sanPham", values,"MaSP=?",new String[]{products.getMaLoai()+""});
    }
    public void delete(int id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("sanPham","MaSP=?",new String[]{String.valueOf(id)});
    }

    public ArrayList<ADD_Product> getAll() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ArrayList<ADD_Product> list = new ArrayList<>();
        String[] ds_cot = new String[]{"*"};
        Cursor cursor = db.query("sanPham", ds_cot, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                ADD_Product product = new ADD_Product();
                product.setMaLoai(cursor.getString(1));
                product.setTenSp(cursor.getString(1));
                product.setSoluong(cursor.getInt(1));
                product.setSize(cursor.getDouble(2));
                product.setMota(cursor.getString(1));
                list.add(product);
                cursor.moveToNext();
            }
        }
        return list;
    }
    public ArrayList<ADD_Product> getTen(String ten) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ArrayList<ADD_Product> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM sanPham WHERE TenSp=?", new String[]{ten});
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                ADD_Product product = new ADD_Product();
                product.setMaLoai(cursor.getString(1));
                product.setTenSp(cursor.getString(1));
                product.setSoluong(cursor.getInt(1));
                product.setSize(cursor.getDouble(2));
                product.setMota(cursor.getString(1));
                list.add(product);
                cursor.moveToNext();
            }
        }
        return list;
    }
}