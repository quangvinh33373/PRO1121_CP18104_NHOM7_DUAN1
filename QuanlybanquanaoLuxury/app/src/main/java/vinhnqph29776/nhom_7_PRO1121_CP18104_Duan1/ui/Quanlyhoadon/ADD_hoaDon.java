package vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Quanlyhoadon;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.MainActivity;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.Objects.HoaDon;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.Objects.SanPham;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.R;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Crud.DAO.DAO;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Crud.DAO.DAO_giay;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Crud.DAO.DAO_quan;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Crud.DAO.HoaDon_Dao;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.HoaDon.MainHoaDon;

public class ADD_hoaDon extends AppCompatActivity {

DAO_quan dao_quan;
    TextView tv_tong;
    EditText name,gia,soluong;
    MaterialButton btn_add;

DAO dao_ao;

DAO_giay dao_giay;
    SanPham sanPham;
 HoaDon hoaDon;

    HoaDon_Dao dao;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_hoa_don);
        name=findViewById(R.id.ed_namehd);
        gia=findViewById(R.id.ed_giahd);
        soluong=findViewById(R.id.ed_slhd);
        tv_tong=findViewById(R.id.tong);
        Bundle bundle = getIntent().getExtras();
        name.setText(bundle.getString("tensp"));
        gia.setText(bundle.getString("gia"));

        String msp=bundle.getString("masp");


        dao=new HoaDon_Dao(getApplicationContext());
        soluong.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH ||
                        actionId == EditorInfo.IME_ACTION_DONE ||
                        event != null &&
                                event.getAction() == KeyEvent.ACTION_DOWN &&
                                event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    if (event == null || !event.isShiftPressed()) {
                        // the user is done typing.
                        if(soluong.getText().toString().equals("")){
                            Toast.makeText(ADD_hoaDon.this, "vui lòng nhập số lượng", Toast.LENGTH_SHORT).show();
                        }else{
                            if(Integer.parseInt(soluong.getText().toString())>Integer.parseInt(bundle.getString("sl"))){
                                soluong.setText("");
                                Toast.makeText(ADD_hoaDon.this, "không thể mua hàng quá số lượng trong kho", Toast.LENGTH_SHORT).show();
                            }else{
                                String so1=gia.getText().toString();
                                int a=Integer.parseInt(so1);
                                String so2=soluong.getText().toString();
                                int b=Integer.parseInt(so2);

                                int tong=a*b;
                                tv_tong.setText(String.valueOf(tong));
                            }
                        }


                        return true; // consume.
                    }
                }
                    return  false;
                }
        });


        ImageView back_ic=findViewById(R.id.back_icon);
        back_ic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        dao_quan=new DAO_quan(getApplicationContext());

        dao_ao=new DAO(getApplicationContext());

        dao_giay=new DAO_giay(getApplicationContext());
        SanPham sanPham1=new SanPham();
        name.setFocusableInTouchMode(false);
        gia.setFocusableInTouchMode(false);
        btn_add=findViewById(R.id.themhd_btn);


        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String namehd=name.getText().toString();
                String giahd=gia.getText().toString();
                String slhd=soluong.getText().toString();



                if(slhd.isEmpty()){
                    Toast.makeText(ADD_hoaDon.this, "không được để trống", Toast.LENGTH_SHORT).show();

                }
                if(tv_tong.getText().toString().isEmpty()){
                    Toast.makeText(ADD_hoaDon.this, "chưa có tổng tiền", Toast.LENGTH_SHORT).show();
                }
                else{
                    int soluong_update=Integer.parseInt(bundle.getString("sl"))-Integer.parseInt(slhd);
                    String loai=bundle.getString("loai_sp");
                    int ghd=Integer.parseInt(giahd);
                    int sl=Integer.parseInt(slhd);

                    hoaDon =new HoaDon(namehd,slhd,giahd,ghd *sl);
                    if(dao.insert_hd(hoaDon)>0){
                        if(loai.equals("ao")){

                            sanPham1.setSoluong(String.valueOf(soluong_update));
                            dao_ao.update_soluong_ao(sanPham1,msp);




                        }
                        if(loai.equals("quan")){

                            sanPham1.setSoluong(String.valueOf(soluong_update));
                            dao_quan.update_soluong_quan(sanPham1,msp);




                        }
                        if(loai.equals("giay")){

                            sanPham1.setSoluong(String.valueOf(soluong_update));
                            dao_giay.update_soluong_giay(sanPham1,msp);




                        }
                        Toast.makeText(getApplicationContext(),"thành công",Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(ADD_hoaDon.this, MainActivity.class);




                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(),"khong thành công",Toast.LENGTH_LONG).show();
                    }
                }


            }
        });
    }
}