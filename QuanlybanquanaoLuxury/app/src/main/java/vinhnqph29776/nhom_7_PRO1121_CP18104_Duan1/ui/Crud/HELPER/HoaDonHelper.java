package vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Crud.HELPER;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class HoaDonHelper extends SQLiteOpenHelper {
    public HoaDonHelper(@Nullable Context context) {
        super(context,"HoaSDon1", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create="Create table hoadon(mahd integer primary key autoincrement ," +
                "tensp text not null," +
                "gia text not null," +
                "soluong text not null," +
                "tongtien text)";
        sqLiteDatabase.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String drop="Drop TABLE IF EXISTS hoadon";
        sqLiteDatabase.execSQL(drop);
        onCreate(sqLiteDatabase);

    }
}
