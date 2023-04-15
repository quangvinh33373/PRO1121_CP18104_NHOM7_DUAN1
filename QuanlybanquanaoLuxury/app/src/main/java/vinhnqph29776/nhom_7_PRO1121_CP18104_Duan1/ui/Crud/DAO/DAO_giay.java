package vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Crud.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.Objects.SanPham;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Crud.HELPER.DBHelper_giay;

public class DAO_giay {
    SQLiteDatabase db;
    public DAO_giay(Context context) {
        DBHelper_giay dbHelper=new DBHelper_giay(context);
        db= dbHelper.getWritableDatabase();
    }

    public long insert_giay(SanPham sp){
        ContentValues values = new ContentValues();
        values.put("TenSp",sp.getTensp());
        values.put("Size",sp.getSize());
        values.put("Gia",sp.getMoney());
        values.put("Soluong",sp.getSoluong());
        values.put("Anhsp",sp.getImage());
        return db.insert("sp_giay",null,values);
    }

    public int delete_giay(SanPham sanPham){
        return db.delete("sp_giay","MaSP=?",new String[]{String.valueOf(sanPham.getMasp())});
    }
    public long update_soluong_giay(SanPham products,String msp) {
        ContentValues values = new ContentValues();

        values.put("Soluong",products.getSoluong());

        return db.update("sp_giay", values,"MaSP=?",new String[]{String.valueOf(msp)});
    }
    public long update_giay(SanPham products,String msp) {
        ContentValues values = new ContentValues();
        values.put("TenSp",products.getTensp());
        values.put("Gia",products.getMoney());
        values.put("Size",products.getSize());
        values.put("Soluong",products.getSoluong());
        values.put("Anhsp",products.getImage());
        return db.update("sp_giay", values,"MaSP=?",new String[]{String.valueOf(msp)});
    }

    @SuppressLint("Range")
    public List<SanPham> getAll(String sp_giay) {
        String sql="SELECT * FROM sp_giay";
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