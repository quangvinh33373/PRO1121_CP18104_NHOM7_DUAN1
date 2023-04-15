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

import java.util.ArrayList;
import java.util.List;

import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.MainActivity;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.Objects.SanPham;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.R;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ReadExternalStorage;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Crud.ADT.ADT_GIay;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Crud.DAO.DAO_giay;

public class ReadEX_giay extends AppCompatActivity {
    private ActivityResultLauncher<String> mTakePhoto;
    private ImageView anhsp;
    TextView uri_store;
    EditText add_tensp1,add_soluong,add_kcsp1,add_giatien1,add_uri;
    MaterialButton btn_add;
    DAO_giay dao1;
    List<SanPham> list1=new ArrayList<>();
    ADT_GIay adt_gIay;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_ex_giay);
        add_tensp1 = findViewById(R.id.input_tensp1);
        add_kcsp1 = findViewById(R.id.input_kichco1);
        add_giatien1 = findViewById(R.id.input_giatien1);
        add_soluong=findViewById(R.id.input_soluong1);
        add_uri=findViewById(R.id.input_uri1);
        ImageView back_ic=findViewById(R.id.back_icon);
        back_ic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
       add_uri.setVisibility(View.INVISIBLE);
        anhsp=findViewById(R.id.img_anhsp1);
        btn_add=findViewById(R.id.themsp_bt1);
        dao1=new DAO_giay(getApplicationContext());
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tenSP1=add_tensp1.getText().toString();
                String kcSP1=add_kcsp1.getText().toString();
                String giaSP1=add_giatien1.getText().toString();
                String slSP=add_soluong.getText().toString().trim();

                SanPham sanPham=new SanPham(tenSP1,giaSP1,add_uri.getText().toString(),slSP,kcSP1);
                if (tenSP1.isEmpty()){
                    Toast.makeText(ReadEX_giay.this, "bạn phải nhập hết thông tin", Toast.LENGTH_SHORT).show();
                }else{
                    if(dao1.insert_giay(sanPham)>0){
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