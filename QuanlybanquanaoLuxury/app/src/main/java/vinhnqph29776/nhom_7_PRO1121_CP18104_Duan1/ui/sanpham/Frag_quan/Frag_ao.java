package vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.sanpham.Frag_quan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.R;

public class Frag_ao extends Fragment {

    RecyclerView rcView;
    List<Products> list=new ArrayList<>();
    ProductAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_ao,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rcView=view.findViewById(R.id.rcv_ao);
        intData();
        adapter=new ProductAdapter(list,getContext());
        RecyclerView.LayoutManager layoutManager= new GridLayoutManager(getContext(),2,RecyclerView.VERTICAL,false);
//        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        rcView.setAdapter(adapter);
        rcView.setLayoutManager(layoutManager);
        rcView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Helooooo", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void intData(){
        list.add(new Products("Pro01",1000,"https://bizweb.dktcdn.net/100/446/974/products/ao-thun-mlb-basic-monogram-allover-new-york-yankees-d-beige-3atsm1023-50bgd-1.jpg?v=1658465074880"));
        list.add(new Products("Pro02",1200,"https://bizweb.dktcdn.net/100/446/974/products/ao-thun-mlb-basic-monogram-allover-new-york-yankees-navy-3atsm1023-50nys-1.jpg?v=1658464351263"));
        list.add(new Products("Pro03",1400,"https://bizweb.dktcdn.net/100/446/974/products/ao-thun-mlb-monogram-all-over-print-boston-red-sox-black-3atsm4023-43bks-1.jpg?v=1654410162017"));
        list.add(new Products("Pro04",2000,"https://bizweb.dktcdn.net/100/446/974/products/ao-thun-mlb-checkerboard-back-logo-new-york-yankees-black-3atsm8023-50bks-1.jpg?v=1654342721187"));
        list.add(new Products("Pro05",1100,"https://bizweb.dktcdn.net/100/446/974/products/ao-thun-mlb-gradient-monogram-overfit-new-york-yankees-blue-3atsm6223-50bls-1.jpg?v=1654343965870"));


    }
}
