package vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.sanpham.Frag_quan;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.Objects.SanPham;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.R;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ReadExternalStorage;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Crud.ADT.ADT_GIay;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Crud.DAO.DAO_giay;

public class Frag_giay extends Fragment {

    RecyclerView rcView;


    ADT_GIay adt_gIay;
    FloatingActionButton fbtn_giay;
    List<SanPham> list1=new ArrayList<>();
    DAO_giay dao;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_giay,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rcView=view.findViewById(R.id.rcv_giay);

        dao=new DAO_giay(getContext());
        list1=dao.getAll("sp_giay");

        adt_gIay =new ADT_GIay(list1,getContext(),dao);
        RecyclerView.LayoutManager layoutManager1= new GridLayoutManager(getContext(),2,RecyclerView.VERTICAL,false);
        rcView.setLayoutManager(layoutManager1);
        rcView.setAdapter(adt_gIay);





    }

    private void intData(){
        list1.add(new SanPham("Giày MLB BigBall Chunky P ","2000","https://bizweb.dktcdn.net/100/446/974/products/giay-mlb-bigball-chunky-p-boston-red-sox-ivory-32shc2111-43i-2-47659fe4-42d1-4a37-9e40-ab3147ae87c5.jpg?v=1653920251457","5","11"));
        list1.add(new SanPham("Giày MLB Chunky Liner Mid Denim","2400","https://bizweb.dktcdn.net/100/446/974/products/giay-mlb-chunky-liner-mid-denim-boston-red-sox-d-blue-3asxcdn3n-43bld-2.jpg?v=1678035200477","5","11"));
        list1.add(new SanPham("Giày MLB Mule Playball Origin ","1500","https://bizweb.dktcdn.net/100/446/974/products/giay-mlb-mule-playball-origin-new-york-yankees-3amuua11n-50bks-3.jpg?v=1668304460317","5","11"));
        list1.add(new SanPham("Giày MLB Chunky Liner New York","2100","https://bizweb.dktcdn.net/100/446/974/products/giay-mlb-chunky-liner-new-york-yankees-off-white-3asxca12n-50whs-2.jpg?v=1645031637230","5","11"));
        list1.add(new SanPham("Giày MLB Chunky-Liner High","3100","https://bizweb.dktcdn.net/100/446/974/products/giay-mlb-chunky-liner-high-new-york-yankees-d-green-3asxcb12n-50gnd-2.jpg?v=1663313764987","5","11"));


    }
    @SuppressLint("MissingInflatedId")
    private void dialogs(){
        AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
        LayoutInflater inflater=getLayoutInflater();
        View view1=inflater.inflate(R.layout.them_sp,null);
        EditText add_tensp = view1.findViewById(R.id.input_tensp);

        EditText add_kcsp = view1.findViewById(R.id.input_kichco);
        EditText add_giatien = view1.findViewById(R.id.input_giatien);
        builder.setView(view1);
        builder.setPositiveButton("Thêm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String tenSP=add_tensp.getText().toString();

                String kcSP=add_kcsp.getText().toString();
                String giaSP=add_giatien.getText().toString();

                SanPham sanPham=new SanPham(tenSP,kcSP,giaSP,"5","11");
                if(dao.insert_giay(sanPham)>0){
                    Toast.makeText(getContext(),"Them thanh cong",Toast.LENGTH_LONG).show();
                    intData();
                    list1= dao.getAll("sp");
                    adt_gIay =new ADT_GIay(list1,getContext(),dao);
                    rcView.setAdapter(adt_gIay);

                }else{
                    Toast.makeText(getContext(),"Them ko thanh cong",Toast.LENGTH_LONG).show();
                }
            }
        });

        builder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        builder.show();
    }
}
