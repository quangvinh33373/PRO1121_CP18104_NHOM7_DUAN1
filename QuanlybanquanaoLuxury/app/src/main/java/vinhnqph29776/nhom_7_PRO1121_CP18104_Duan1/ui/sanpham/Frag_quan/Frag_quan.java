package vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.sanpham.Frag_quan;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
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
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Crud.ADT.ADT_Quan;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Crud.DAO.DAO_giay;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Crud.DAO.DAO_quan;

public class Frag_quan extends Fragment {

    RecyclerView rcView;
    ADT_Quan adt_quan;
    FloatingActionButton fbtn_quan;
    List<SanPham> list1=new ArrayList<>();
    DAO_quan dao;
    MenuItem item;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_quan,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rcView=view.findViewById(R.id.rcv_q);

        dao=new DAO_quan(getContext());
        list1=new ArrayList<>();

        list1.addAll(dao.getAll("sp_quan"));
        adt_quan =new ADT_Quan(list1,getContext(),dao);
        RecyclerView.LayoutManager layoutManager1= new GridLayoutManager(getContext(),2,RecyclerView.VERTICAL,false);
        rcView.setLayoutManager(layoutManager1);
        rcView.setAdapter(adt_quan);





    }

    private void intData(){
        list1.add(new SanPham("Quần Dài Lifestyle Nữ Adidas W Fi 3s Pant","1000","https://cdn.tgdd.vn/Products/Images/10099/282550/adidas-w-fi-3s-pant-hc6370-1.jpg","5","11"));
        list1.add(new SanPham("Quần Short Tập Luyện Nam Adidas M FI 3B Short","1200","https://cdn.tgdd.vn/Products/Images/10099/279834/quan-short-tap-luyen-nam-adidas-m-fi-3b-short-h39798-1.jpg","5","11"));
        list1.add(new SanPham("Quần Short Tập Luyện Nam Adidas CIty","1400","https://cdn.tgdd.vn/Products/Images/10099/271267/quan-short-tap-luyen-nam-adidas-city-h29165-m-1.jpg","5","11"));
        list1.add(new SanPham("Quần Legging Tập Luyện Nữ Adidas Opt TI","2000","https://cdn.tgdd.vn/Products/Images/10099/279835/quan-legging-tap-luyen-nu-adidas-opt-ti-3-4-t-h64229-1.jpg","5","11"));
        list1.add(new SanPham("Quần Short Tập Luyện Nam Adidas 3 Bar Pack","1100","https://cdn.tgdd.vn/Products/Images/10099/271292/quan-short-tap-luyen-nam-adidas-3-bar-pack-h08755-moi-1.jpg","5","11"));


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
                if(dao.insert_quan(sanPham)>0){
                    Toast.makeText(getContext(),"Them thanh cong",Toast.LENGTH_LONG).show();
                    intData();
               list1.clear();

                    list1.addAll(dao.getAll("sp_quan"));

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
