package vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.sanpham.Frag_quan;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.MainActivity;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.Objects.SanPham;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.R;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ReadExternalStorage;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Crud.DAO.DAO;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Crud.DAO.DAO_giay;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Crud.DAO.DAO_quan;

public class READEX_quan extends AppCompatActivity {
    private ActivityResultLauncher<String> mTakePhoto2;
    private ImageView anhsp2;
    EditText add_tensp2,add_uri,add_kcsp2,add_giatien2,add_soluong2;
    MaterialButton btn_add2;
    TextView uri_store;
    DAO_quan dao;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readex_quan);
        add_tensp2 = findViewById(R.id.input_tensp2);
        add_kcsp2 = findViewById(R.id.input_kichco2);
        add_giatien2 = findViewById(R.id.input_giatien2);
        add_soluong2=findViewById(R.id.input_soluong2);
        anhsp2=findViewById(R.id.img_anhsp2);
        btn_add2=findViewById(R.id.themsp_bt2);
        add_uri=findViewById(R.id.input_uri2);
    add_uri.setVisibility(View.INVISIBLE);
        ImageView back_ic=findViewById(R.id.back_icon);
        back_ic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        dao=new DAO_quan(getApplicationContext());
        btn_add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tenSP1=add_tensp2.getText().toString();

                String kcSP1=add_kcsp2.getText().toString();
                String giaSP1=add_giatien2.getText().toString();
                String slSP=add_soluong2.getText().toString().trim();

                SanPham sanPham=new SanPham(tenSP1,giaSP1,add_uri.getText().toString(),slSP,kcSP1);
                if (tenSP1.isEmpty()){
                    Toast.makeText(READEX_quan.this, "bạn phải nhập hết thông tin", Toast.LENGTH_SHORT).show();
                }else{
                    if(dao.insert_quan(sanPham)>0){
                        Toast.makeText(getApplicationContext(),"Them thanh cong",Toast.LENGTH_LONG).show();
                        Intent intentback=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intentback);
                    }
                }
            }
        });
        init();
    }
    private void init(){
        mTakePhoto2=registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {
                anhsp2.setImageURI(result);
                add_uri.setText(result.toString());
            }
        });
        anhsp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    mTakePhoto2.launch("image/*");
                }catch (Exception ex)  {

                }
            }
        });
    }
}