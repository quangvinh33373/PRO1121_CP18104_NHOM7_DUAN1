package vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Quanlyhoadon;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.Objects.HoaDon;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.R;

import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Crud.ADT.AdapterHoaDon;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Crud.DAO.HoaDon_Dao;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.HoaDon.MainHoaDon;

public class Fragment_thongbao extends Fragment {
    ImageView imghd;
    private Fragment_thongbao binding;
    ListView lview;
    Button add;
    ArrayList<HoaDon> list=new ArrayList<>();
    HoaDon_Dao dao;
    AdapterHoaDon adt;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_main_hoa_don,container,false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lview=view.findViewById(R.id.lv_hoadon);


        dao=new HoaDon_Dao(getActivity());


        list= (ArrayList<HoaDon>) dao.getAll("hoadon");
        adt=new AdapterHoaDon(list,getActivity(),dao);
        adt.setData(list);
        lview.setAdapter(adt);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}