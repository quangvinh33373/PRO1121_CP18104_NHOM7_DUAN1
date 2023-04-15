package vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.sanpham;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButton;

import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.MainActivity;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.Objects.SanPham;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.R;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Crud.DAO.DAO;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Crud.DAO.DAO_quan;

public class SuaSP_Quan extends AppCompatActivity {
    private ActivityResultLauncher<String> mTakePhoto;
private ImageView anhsp;

DAO_quan dao;
    EditText add_tensp,add_kcsp,add_giatien,add_soluong,add_uri;
   MaterialButton btn_add;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.them_sp);
        add_tensp = findViewById(R.id.input_tensp);

        add_kcsp = findViewById(R.id.input_kichco);
        add_soluong=findViewById(R.id.input_soluong);
        add_giatien = findViewById(R.id.input_giatien);

        anhsp=findViewById(R.id.img_anhsp);
        add_uri=findViewById(R.id.input_uri);
        btn_add=findViewById(R.id.themsp_bt);
        add_uri.setVisibility(View.INVISIBLE);


        dao=new DAO_quan(getApplicationContext());
//        add_uri.setVisibility(View.INVISIBLE);
        init1();
//        bundle.getString("tensp")
        Bundle bundle = getIntent().getExtras();
        add_tensp.setText(bundle.getString("tensp_q"));
        add_kcsp.setText(bundle.getString("size_q"));
        add_giatien.setText(bundle.getString("gia_q"));
        add_soluong.setText(bundle.getString("sl_q"));
        add_uri.setText(bundle.getString("anhsp"));
        Glide.with(getApplicationContext()).load(bundle.getString("anhsp")).into(anhsp);


btn_add.setText("Sửa Sản Phẩm");

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

 dao=new DAO_quan(getApplicationContext());

                String tenSP=add_tensp.getText().toString().trim();
                String kcSP=add_kcsp.getText().toString().trim();
                String giaSP=add_giatien.getText().toString().trim();
                String slSP=add_soluong.getText().toString().trim();
                //thứ tự insert tên sp,giá, ảnh, số lượng, size
                SanPham sanPham1=new SanPham(tenSP,giaSP,add_uri.getText().toString(),slSP,kcSP);

                String msp=bundle.getString("masp_q");
                if(dao.update_quan(sanPham1,msp)>0){
                    Toast.makeText(getApplicationContext(),"Sửa thanh cong",Toast.LENGTH_LONG).show();
                    Intent intentback=new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intentback);
                }else{
                    Toast.makeText(getApplicationContext(),"Sửa ko thanh cong",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
    public void init1(){
        mTakePhoto=registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {
anhsp.setImageURI(result);
add_uri.setText(result.toString());
            }
        });
        anhsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          try{
              mTakePhoto.launch("image/*");
          }catch (Exception ex)  {

          }
            }
        });
    }
}
