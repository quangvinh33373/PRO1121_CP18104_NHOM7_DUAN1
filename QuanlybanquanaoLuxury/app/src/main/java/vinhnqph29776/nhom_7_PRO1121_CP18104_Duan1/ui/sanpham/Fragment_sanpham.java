package vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.sanpham;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.R;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.databinding.FragmentSanphamBinding;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.sanpham.Frag_quan.Frag_ao;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.sanpham.Frag_quan.Frag_giay;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.sanpham.Frag_quan.Frag_quan;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.sanpham.rcv.cate_ADT;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.sanpham.rcv.category;

public class Fragment_sanpham extends Fragment {
    FragmentManager fm;
    ImageView img_shop;
    private FragmentSanphamBinding binding;
    cate_ADT adt;
    ArrayList<category> list;

    CardView cv01,cv02,cv03;


    private OnItemCLickListener lickListener;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {



        binding = FragmentSanphamBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
  
        cv01=view.findViewById(R.id.cv_ao);
        cv02=view.findViewById(R.id.cv_q);
        cv03=view.findViewById(R.id.cv_giay);
        fm= getActivity().getSupportFragmentManager();
        Frag_quan frag_quan=new Frag_quan();
        Frag_ao frag_ao=new Frag_ao();
        Frag_giay frag_giay=new Frag_giay();

////        recyclerView=view.findViewById(R.id.rcv_homefrag);
//
//        adt=new cate_ADT(list,this);
//        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL,false);
//
//        recyclerView.setLayoutManager(layoutManager);
//        adt.setData(getList());
//        recyclerView.setAdapter(adt);

        fm.beginTransaction().add(R.id.frag_ctn_sp,frag_ao).commit();



        cv01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fm.beginTransaction().replace(R.id.frag_ctn_sp,frag_ao).commit();
            }
        });
        cv02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fm.beginTransaction().replace(R.id.frag_ctn_sp,frag_quan).commit();
            }
        });

        cv03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fm.beginTransaction().replace(R.id.frag_ctn_sp,frag_giay).commit();
            }
        });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public List<category> getList() {
        List<category> categoryList=new ArrayList<>();
        categoryList.add(new category(R.drawable.mlb_ao,"ÁO"));
        categoryList.add(new category(R.drawable.mlb_q,"Quần"));
        categoryList.add(new category(R.drawable.img,"Giày"));
        return categoryList;
    }


}