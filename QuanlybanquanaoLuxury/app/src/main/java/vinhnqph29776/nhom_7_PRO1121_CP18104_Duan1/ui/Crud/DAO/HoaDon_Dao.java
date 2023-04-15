package vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Crud.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.Objects.HoaDon;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Crud.HELPER.HoaDonHelper;

public class HoaDon_Dao {
    HoaDonHelper helper;
    SQLiteDatabase db;
    public HoaDon_Dao(Context context) {
        helper=new HoaDonHelper(context);
        db=helper.getWritableDatabase();
    }

    public long insert_hd(HoaDon hoaDon){
        ContentValues values=new ContentValues();
        values.put("tensp",hoaDon.getTensp());
        values.put("soluong",hoaDon.getSoluong());
        values.put("gia",hoaDon.getGia());
        values.put("tongtien",hoaDon.getTongtien());
      return   db.insert("hoadon",null,values);
    }

    public int delete(HoaDon hoaDon){
        return db.delete("hoadon","mahd=?",new String[]{String.valueOf(hoaDon.getMahd())});
    }

    public List<HoaDon> getAll(String hoadon){
        String sql="SELECT *FROM hoadon";
        return getData(sql);


    }

    @SuppressLint("Range")
    private List<HoaDon> getData(String sql, String ...Args) {
        List<HoaDon> list=new ArrayList<>();
        Cursor cursor=db.rawQuery(sql,Args);
        while (cursor.moveToNext()){
            HoaDon hoaDon=new HoaDon();
            hoaDon.setMahd(Integer.parseInt(cursor.getString(cursor.getColumnIndex("mahd"))));
            hoaDon.setTensp(cursor.getString(cursor.getColumnIndex("tensp")));
            hoaDon.setSoluong(cursor.getString(cursor.getColumnIndex("soluong")));
            hoaDon.setGia(cursor.getString(cursor.getColumnIndex("gia")));
            hoaDon.setTongtien(Integer.parseInt(cursor.getString(cursor.getColumnIndex("tongtien"))));
            list.add(hoaDon);
        }
            return list;
    }
}