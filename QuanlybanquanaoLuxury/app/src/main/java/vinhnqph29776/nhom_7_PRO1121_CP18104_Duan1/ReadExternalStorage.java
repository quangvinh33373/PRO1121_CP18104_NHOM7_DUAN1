package vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1;

import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class ReadExternalStorage extends AppCompatActivity {
    private ActivityResultLauncher<String> mTakePhoto;
private ImageView anhsp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.them_sp);
        anhsp=findViewById(R.id.img_anhsp);
        init();

    }
    private void init(){
        mTakePhoto=registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {
anhsp.setImageURI(result);
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
