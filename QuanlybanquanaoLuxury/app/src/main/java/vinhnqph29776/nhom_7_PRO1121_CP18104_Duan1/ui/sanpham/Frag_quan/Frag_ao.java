package vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.sanpham.Frag_quan;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
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
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Crud.DAO.DAO;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.sanpham.ADT_SanPham;

public class Frag_ao extends Fragment {
MenuItem test;
    RecyclerView rcView;
ReadExternalStorage read;
    ADT_SanPham adt_sanPham;
    FloatingActionButton fbtn_ao;
    private ActivityResultLauncher<String> mTakePhoto;
    List<SanPham> list1=new ArrayList<>();
    SearchView sv;
    DAO dao;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_ao,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rcView=view.findViewById(R.id.rcv_ao);


        dao=new DAO(getContext());
        list1.clear();
        list1.addAll(dao.getAll("sp"));

        adt_sanPham =new ADT_SanPham(list1,getContext(),dao);
        RecyclerView.LayoutManager layoutManager1= new GridLayoutManager(getContext(),2,RecyclerView.VERTICAL,false);
        rcView.setLayoutManager(layoutManager1);

        rcView.setAdapter(adt_sanPham);

        rcView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



    }

    private void intData(){
        list1.add(new SanPham("Pro01","1000","https://bizweb.dktcdn.net/100/446/974/products/ao-thun-mlb-basic-monogram-allover-new-york-yankees-d-beige-3atsm1023-50bgd-1.jpg?v=1658465074880","5","11"));
        list1.add(new SanPham("Pro02","1200","https://bizweb.dktcdn.net/100/446/974/products/ao-thun-mlb-basic-monogram-allover-new-york-yankees-navy-3atsm1023-50nys-1.jpg?v=1658464351263","5","11"));
        list1.add(new SanPham("Pro03","1400","https://bizweb.dktcdn.net/100/446/974/products/ao-thun-mlb-monogram-all-over-print-boston-red-sox-black-3atsm4023-43bks-1.jpg?v=1654410162017","5","11"));
        list1.add(new SanPham("Pro04","2000","https://bizweb.dktcdn.net/100/446/974/products/ao-thun-mlb-checkerboard-back-logo-new-york-yankees-black-3atsm8023-50bks-1.jpg?v=1654342721187","5","11"));
        list1.add(new SanPham("Pro05","1100","https://bizweb.dktcdn.net/100/446/974/products/ao-thun-mlb-gradient-monogram-overfit-new-york-yankees-blue-3atsm6223-50bls-1.jpg?v=1654343965870","5","11"));


    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

}
