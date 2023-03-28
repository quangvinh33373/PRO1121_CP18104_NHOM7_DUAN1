package vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.taikhoan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.R;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.databinding.FragmentSanphamBinding;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.databinding.FragmentTaikhoanBinding;

public class Fragment_taikhoan extends Fragment {

    private FragmentTaikhoanBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentTaikhoanBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}