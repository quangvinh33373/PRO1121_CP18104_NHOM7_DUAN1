package vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.sanpham;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.R;

import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.databinding.FragmentSanphamBinding;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.sanpham.Frag_quan.Frag_ao;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.sanpham.Frag_quan.Frag_quan;

public class Fragment_sanpham extends Fragment {
    FragmentManager fm;
    ImageView img_ao,img_quan,img_shop;
    Button btn_ao,btn_quan;
    private FragmentSanphamBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {



        binding = FragmentSanphamBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        img_ao=view.findViewById(R.id.img_ao);
        img_quan=view.findViewById(R.id.img_q);
        img_shop=view.findViewById(R.id.img_shop);
        btn_ao=view.findViewById(R.id.btn_ao);
        btn_quan=view.findViewById(R.id.btn_quan);
        fm= getActivity().getSupportFragmentManager();
        Frag_quan frag_quan=new Frag_quan();
        Frag_ao frag_ao=new Frag_ao();
        fm.beginTransaction().add(R.id.frag_ctn_sp,frag_quan).commit();
        btn_quan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fm.beginTransaction().replace(R.id.frag_ctn_sp,frag_quan).commit();
            }
        });

        btn_ao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fm.beginTransaction().replace(R.id.frag_ctn_sp,frag_ao).commit();
            }
        });

        img_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Helllo", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}