package vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.home.Frag_quan;

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

public class Frag_quan extends Fragment {

    RecyclerView rcView;
    List<Products> list=new ArrayList<>();
    ProductAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_quan,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rcView=view.findViewById(R.id.rcv_q);
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
        list.add(new Products("Quần Dài Lifestyle Nữ Adidas W Fi 3s Pant",1000,"https://cdn.tgdd.vn/Products/Images/10099/282550/adidas-w-fi-3s-pant-hc6370-1.jpg"));
        list.add(new Products("Quần Short Tập Luyện Nam Adidas M FI 3B Short",1200,"https://cdn.tgdd.vn/Products/Images/10099/279834/quan-short-tap-luyen-nam-adidas-m-fi-3b-short-h39798-1.jpg"));
        list.add(new Products("Quần Short Tập Luyện Nam Adidas CIty",1400,"https://cdn.tgdd.vn/Products/Images/10099/271267/quan-short-tap-luyen-nam-adidas-city-h29165-m-1.jpg"));
        list.add(new Products("Quần Legging Tập Luyện Nữ Adidas Opt TI",2000,"https://cdn.tgdd.vn/Products/Images/10099/279835/quan-legging-tap-luyen-nu-adidas-opt-ti-3-4-t-h64229-1.jpg"));
        list.add(new Products("Quần Short Tập Luyện Nam Adidas 3 Bar Pack",1100,"https://cdn.tgdd.vn/Products/Images/10099/271292/quan-short-tap-luyen-nam-adidas-3-bar-pack-h08755-moi-1.jpg"));


    }
}
