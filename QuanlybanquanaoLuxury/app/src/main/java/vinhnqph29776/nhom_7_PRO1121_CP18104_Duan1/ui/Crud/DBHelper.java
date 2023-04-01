package vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Crud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context,"QLQAL", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sanPham = "CREATE TABLE sanPham(MaSP TEXT PRIMARY KEY UNIQUE NOT NULL,SoLuong INTEGER Not Null,TenSp TEXT NOT NULL,Size Double not null,MoTa Text Not null)";
        db.execSQL(sanPham);
        String Kh="CREATE TABLE kHang(SdtKH integer PRIMARY KEY UNIQUE NOT NULL , TenKH TEXT NOT NULL, diaChi TEXT NOT NULL)";
        db.execSQL(Kh);
        String Nban="CREATE TABLE NBan(SdtNB integer PRIMARY KEY UNIQUE NOT NULL )";
        db.execSQL(Nban);
        String hoaDon = "CREATE TABLE hoaDon(MaHD TEXT PRIMARY KEY UNIQUE NOT NULL,TenSp TEXT NOT NULL,Size Integer not null,tenKH Text Not null,SdtKH integer references kHang(SdtKH) Not null, diaChi Text Not null,SdtNB integer references NBan(SdtNB) Not null,MaSp Text references sanPham(MaSP))";
        db.execSQL(hoaDon);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            if(i !=i1){
                db.execSQL("DROP TABLE IF EXISTS sanPham");
                db.execSQL("DROP TABLE IF EXISTS kHang");
                db.execSQL("DROP TABLE IF EXISTS NBan");
                db.execSQL("DROP TABLE IF EXISTS hoaDon");
                onCreate(db);
            }
    }
}
