package vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.HoaDon;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.Objects.HoaDon;

import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.R;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Crud.ADT.AdapterHoaDon;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Crud.DAO.HoaDon_Dao;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Quanlyhoadon.ADD_hoaDon;

public class MainHoaDon extends AppCompatActivity {
ListView lview;
Button add;
ArrayList<HoaDon> list=new ArrayList<>();
HoaDon_Dao dao;
AdapterHoaDon adt;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_hoa_don);
        lview=findViewById(R.id.lv_hoadon);


        dao=new HoaDon_Dao(getApplicationContext());


        list.addAll(dao.getAll("hoadon"));
        adt=new AdapterHoaDon(list,getApplicationContext(),dao);
        adt.setData(list);
        lview.setAdapter(adt);

    }

}