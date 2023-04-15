package vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Crud.HELPER;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper_giay extends SQLiteOpenHelper {
    public DBHelper_giay(@Nullable Context context) {
        super(context,"giay_02", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sanPham1 = "CREATE TABLE sp_giay(MaSP INTEGER PRIMARY KEY AUTOINCREMENT," +
                " TenSp TEXT Not Null," +
                "Size TEXT not null," +
                "Gia Text Not null," +
                "Soluong TEXT NOT NULL," +
                "Anhsp Text Not null)";
        db.execSQL(sanPham1);
//        String Nban="CREATE TABLE NBan(SdtNB integer PRIMARY KEY UNIQUE NOT NULL )";
//        db.execSQL(Nban);
//        String hoaDon = "CREATE TABLE hoaDon(MaHD TEXT PRIMARY KEY UNIQUE NOT NULL,TenSp TEXT NOT NULL,Size Integer not null,tenKH Text Not null,SdtKH integer references kHang(SdtKH) Not null, diaChi Text Not null,SdtNB integer references NBan(SdtNB) Not null,MaSp Text references sanPham(MaSP))";
//        db.execSQL(hoaDon);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
                db.execSQL("DROP TABLE IF EXISTS sp_giay");
//                db.execSQL("DROP TABLE IF EXISTS NBan");
//                db.execSQL("DROP TABLE IF EXISTS hoaDon");
                onCreate(db);

    }
}
