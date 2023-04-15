package vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.HoaDon.MainHoaDon;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Quanlyhoadon.ADD_hoaDon;

public class Chitietsp_activity extends AppCompatActivity {
    TextView ten,size,gia,sl;
    Button delete,update;
    ImageView anhsp,gioHang,back_img;


    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.row_sanpham);
        anhsp = findViewById(R.id.img_chitietsanpham);
        ten = findViewById(R.id.tv_tensp);
        size = findViewById(R.id.tv_kichco);
        gia = findViewById(R.id.tv_giatien);
        sl = findViewById(R.id.tv_soluong);
        back_img = findViewById(R.id.back_icon);
        gioHang = findViewById(R.id.shop);
        back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chitietsp_activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Bundle bundle = getIntent().getExtras();
        ten.setText(bundle.getString("tensp"));
        size.setText(bundle.getString("size"));
        gia.setText(bundle.getString("gia"));
        sl.setText(bundle.getString("sl"));
        Glide.with(getApplicationContext()).load(bundle.getString("anhsp")).into(anhsp);



            gioHang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (0== Integer.parseInt(sl.getText().toString())) {
                        Toast.makeText(view.getContext(), "Sản phẩm hiện tại đã hết hàng ", Toast.LENGTH_SHORT).show();
                    }else{
                        Intent themhoadon = new Intent(getApplicationContext(), ADD_hoaDon.class);
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("tensp", ten.getText().toString());
                        bundle2.putString("size", size.getText().toString());
                        bundle2.putString("gia",gia.getText().toString() );
                        bundle2.putString("sl", sl.getText().toString());
                        bundle2.putString("anhsp",bundle.getString("anhsp"));
bundle2.putString("loai_sp",bundle.getString("loai_sp"));
                        bundle2.putString("masp", bundle.getString("masp"));

                        themhoadon.putExtras(bundle2);
                        startActivity(themhoadon);
                    }


                }
            });

        }
//    }

}
