package vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.sanpham;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.R;

import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.databinding.FragmentSanphamBinding;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.sanpham.Frag_quan.Frag_ao;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.sanpham.Frag_quan.Frag_giay;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.sanpham.Frag_quan.Frag_quan;

public class Fragment_sanpham extends Fragment {
    FragmentManager fm;
    ImageView img_ao,img_quan,img_giay;
    LinearLayout layout_ao,layout_quan,layout_giay;
    SearchView sv;
    private FragmentSanphamBinding binding;
    CardView cv01,cv03;
    LinearLayout cv02;

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
        layout_ao=view.findViewById(R.id.layout_ao);
        layout_giay=view.findViewById(R.id.layout_giay);
        layout_quan=view.findViewById(R.id.layout_quan);

        cv03=view.findViewById(R.id.cv_giay);
        fm= getActivity().getSupportFragmentManager();
        Frag_quan frag_quan=new Frag_quan();
        Frag_ao frag_ao=new Frag_ao();
        Frag_giay frag_giay=new Frag_giay();
        img_ao=view.findViewById(R.id.ibtn_ao);
        img_giay=view.findViewById(R.id.ibtn_giay);
        img_quan=view.findViewById(R.id.ibtn_q);
        fm.beginTransaction().add(R.id.frag_ctn_sp,frag_ao).commit();


        img_ao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout_ao.setBackgroundColor(Color.parseColor("#eeeee4"));
                layout_quan.setBackgroundColor(Color.WHITE);
                layout_giay.setBackgroundColor(Color.WHITE);
                fm.beginTransaction().replace(R.id.frag_ctn_sp,frag_ao).commit();
            }
        });

        img_quan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout_giay.setBackgroundColor(Color.WHITE);
                layout_quan.setBackgroundColor(Color.parseColor("#eeeee4"));
                layout_ao.setBackgroundColor(Color.WHITE);
                fm.beginTransaction().replace(R.id.frag_ctn_sp,frag_quan).commit();
            }
        });

        img_giay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout_ao.setBackgroundColor(Color.WHITE);
                layout_quan.setBackgroundColor(Color.WHITE);
                layout_giay.setBackgroundColor(Color.parseColor("#eeeee4"));
                fm.beginTransaction().replace(R.id.frag_ctn_sp,frag_giay).commit();
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}