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

public class Frag_giay extends Fragment {

    RecyclerView rcView;
    List<Products> list=new ArrayList<>();
    ProductAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_giay,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rcView=view.findViewById(R.id.rcv_giay);
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
        list.add(new Products("Giày MLB BigBall Chunky P ",2000,"https://bizweb.dktcdn.net/100/446/974/products/giay-mlb-bigball-chunky-p-boston-red-sox-ivory-32shc2111-43i-2-47659fe4-42d1-4a37-9e40-ab3147ae87c5.jpg?v=1653920251457"));
        list.add(new Products("Giày MLB Chunky Liner Mid Denim",2400,"https://bizweb.dktcdn.net/100/446/974/products/giay-mlb-chunky-liner-mid-denim-boston-red-sox-d-blue-3asxcdn3n-43bld-2.jpg?v=1678035200477"));
        list.add(new Products("Giày MLB Mule Playball Origin ",1500,"https://bizweb.dktcdn.net/100/446/974/products/giay-mlb-mule-playball-origin-new-york-yankees-3amuua11n-50bks-3.jpg?v=1668304460317"));
        list.add(new Products("Giày MLB Chunky Liner New York",2100,"https://bizweb.dktcdn.net/100/446/974/products/giay-mlb-chunky-liner-new-york-yankees-off-white-3asxca12n-50whs-2.jpg?v=1645031637230"));
        list.add(new Products("Giày MLB Chunky-Liner High",3100,"https://bizweb.dktcdn.net/100/446/974/products/giay-mlb-chunky-liner-high-new-york-yankees-d-green-3asxcb12n-50gnd-2.jpg?v=1663313764987"));


    }
}
