package vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.button.MaterialButton;

import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.Objects.SanPham;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Crud.DAO.DAO;

public class ReadExternalStorage extends AppCompatActivity {
    private ActivityResultLauncher<String> mTakePhoto;
private ImageView anhsp;
TextView uri_store;
    EditText add_tensp,add_kcsp,add_giatien,add_soluong,add_uri;
   MaterialButton btn_add;
    DAO dao;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.them_sp);

        ImageView back_ic=findViewById(R.id.back_icon);
        back_ic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        add_tensp = findViewById(R.id.input_tensp);

        add_kcsp = findViewById(R.id.input_kichco);
        add_soluong=findViewById(R.id.input_soluong);
        add_giatien = findViewById(R.id.input_giatien);
         uri_store=findViewById(R.id.uri_store);
        uri_store.setVisibility(View.INVISIBLE);
        anhsp=findViewById(R.id.img_anhsp);
        add_uri=findViewById(R.id.input_uri);
        btn_add=findViewById(R.id.themsp_bt);
        dao=new DAO(getApplicationContext());
        add_uri.setVisibility(View.INVISIBLE);

  init1(anhsp);




        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tenSP = add_tensp.getText().toString().trim();
                String kcSP = add_kcsp.getText().toString().trim();
                String giaSP = add_giatien.getText().toString().trim();
                String slSP = add_soluong.getText().toString().trim();
                //thứ tự insert tên sp,giá, ảnh, số lượng, size
                SanPham sanPham1 = new SanPham(tenSP, giaSP, add_uri.getText().toString(), slSP, kcSP);
                if (tenSP.isEmpty()){
                    Toast.makeText(ReadExternalStorage.this, "bạn phải nhập hết thông tin", Toast.LENGTH_SHORT).show();
                }else{
                    if(dao.insertSp(sanPham1)>0){
                        Toast.makeText(getApplicationContext(),"Them thanh cong",Toast.LENGTH_LONG).show();
                        Intent intentback=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intentback);
                    }
                }
            }
        });


    }
    public void init1(ImageView anhsp){
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
