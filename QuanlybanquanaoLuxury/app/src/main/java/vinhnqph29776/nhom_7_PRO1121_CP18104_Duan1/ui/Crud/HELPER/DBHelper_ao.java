package vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Crud.HELPER;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper_ao extends SQLiteOpenHelper {
    public DBHelper_ao(@Nullable Context context) {
        super(context,"ao", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sanPham1 = "CREATE TABLE sp(MaSP INTEGER PRIMARY KEY AUTOINCREMENT," +
                " TenSp TEXT Not Null," +
                  "Size TEXT not null," +
                "Gia TEXT NOT NULL," +
                "Soluong TEXT NOT NULL," +
                "Anhsp Text Not null)";
        String hoadon = "CREATE TABLE hoadon(Mahd INTEGER PRIMARY KEY AUTOINCREMENT," +
                " TenSp TEXT Not Null," +
                "Gia TEXT NOT NULL," +
                "Soluong TEXT not null," +
                "Tongtien TEXT NOT NULL )";
        db.execSQL(sanPham1);
        db.execSQL(hoadon);
//        String Nban="CREATE TABLE NBan(SdtNB integer PRIMARY KEY UNIQUE NOT NULL )";
//        db.execSQL(Nban);
//        String hoaDon = "CREATE TABLE hoaDon(MaHD TEXT PRIMARY KEY UNIQUE NOT NULL,TenSp TEXT NOT NULL,Size Integer not null,tenKH Text Not null,SdtKH integer references kHang(SdtKH) Not null, diaChi Text Not null,SdtNB integer references NBan(SdtNB) Not null,MaSp Text references sanPham(MaSP))";
//        db.execSQL(hoaDon);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
                db.execSQL("DROP TABLE IF EXISTS sp");
//                db.execSQL("DROP TABLE IF EXISTS NBan");
//                db.execSQL("DROP TABLE IF EXISTS hoaDon");
                onCreate(db);

    }
}
