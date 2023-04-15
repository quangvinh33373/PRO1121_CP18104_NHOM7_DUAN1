package vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Crud.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.Objects.HoaDon;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.Objects.SanPham;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Crud.HELPER.DBHelper_ao;

public class DAO {
    List<SanPham> list1=new ArrayList<>();
    SQLiteDatabase db;
    public DAO(Context context) {
        DBHelper_ao dbHelper=new DBHelper_ao(context);
        db= dbHelper.getWritableDatabase();

    }
    public long insertHoadon(HoaDon hd){
        ContentValues values = new ContentValues();
        values.put("TenSp",hd.getTensp());
        values.put("Soluong",hd.getSoluong());
        values.put("Gia",hd.getGia());
        values.put("Tongtien",hd.getTongtien());
        return db.insert("sp",null,values);
    }
    public long updateHoadon(HoaDon hd) {
        ContentValues values = new ContentValues();
        values.put("TenSp",hd.getTensp());
        values.put("Soluong",hd.getSoluong());
        values.put("Gia",hd.getGia());
        values.put("Tongtien",hd.getTongtien());


        return db.update("honado", values,"Mahd=?",new String[]{String.valueOf(hd.getMahd())});
    }
    @SuppressLint("Range")
    private List<HoaDon> getDataHoadon(String sql, String...Args) {
        List<HoaDon> list1= new ArrayList<>();
        Cursor cursor=db.rawQuery(sql,Args);
        while (cursor.moveToNext()) {

           HoaDon product = new HoaDon();
            product.setMahd(Integer.parseInt(cursor.getString(cursor.getColumnIndex("Mahd"))));
            product.setTensp(cursor.getString(cursor.getColumnIndex("TenSp")));
            product.setSoluong(cursor.getString(cursor.getColumnIndex("Soluong")));
            product.setGia(cursor.getString(cursor.getColumnIndex("Gia")));
            product.setTongtien(Integer.parseInt(cursor.getString(cursor.getColumnIndex("Tongtien"))));

            list1.add(product);
        }

        return list1;
    }
    public List<HoaDon> getAllHoadon(String Hoadon) {
        String sql="SELECT * FROM hoadon";
        return getDataHoadon(sql);
    }
    public int deleteHoadon(HoaDon hd){
        return db.delete("hoadon","Mahd=?",new String[]{String.valueOf(hd.getMahd())});
    }
    public long insertSp(SanPham sp){
        ContentValues values = new ContentValues();
        values.put("TenSp",sp.getTensp());
        values.put("Size",sp.getSize());
        values.put("Gia",sp.getMoney());
        values.put("Soluong",sp.getSoluong());
        values.put("Anhsp",sp.getImage());
        return db.insert("sp",null,values);
    }
    public long update_soluong_ao(SanPham sp,String masp){
        ContentValues values = new ContentValues();

        values.put("Soluong",sp.getSoluong());

        return db.update("sp", values,"MaSP=?",new String[]{String.valueOf(masp)});
    }
    public int delete(SanPham sanPham){
        return db.delete("sp","MaSP=?",new String[]{String.valueOf(sanPham.getMasp())});
    }
    public long update(SanPham products,String masp) {
        ContentValues values = new ContentValues();
        values.put("TenSp",products.getTensp());
        values.put("Size",products.getSize());
        values.put("Gia",products.getMoney());
        values.put("Soluong",products.getSoluong());
        values.put("Anhsp",products.getImage());


        return db.update("sp", values,"MaSP=?",new String[]{String.valueOf(masp)});
    }

    @SuppressLint("Range")
    public List<SanPham> getAll(String sanPham) {
        String sql="SELECT * FROM sp";
        return getData(sql);
    }
    @SuppressLint("Range")
    private List<SanPham> getData(String sql, String...Args) {
      List<SanPham > list1= new ArrayList<>();
        Cursor cursor=db.rawQuery(sql,Args);
            while (cursor.moveToNext()) {

                SanPham product = new SanPham();
                product.setMasp(Integer.parseInt(cursor.getString(cursor.getColumnIndex("MaSP"))));
                product.setTensp(cursor.getString(cursor.getColumnIndex("TenSp")));
                product.setSize(cursor.getString(cursor.getColumnIndex("Size")));
                product.setMoney(cursor.getString(cursor.getColumnIndex("Gia")));
                product.setSoluong(cursor.getString(cursor.getColumnIndex("Soluong")));
                product.setImage(cursor.getString(cursor.getColumnIndex("Anhsp")));
                list1.add(product);
            }

        return list1;
    }
}