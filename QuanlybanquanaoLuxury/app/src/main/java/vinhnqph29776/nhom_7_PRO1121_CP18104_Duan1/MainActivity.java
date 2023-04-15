package vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;


import org.jetbrains.annotations.NotNull;

import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.databinding.ActivityMainBinding;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Quanlyhoadon.Fragment_thongbao;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.sanpham.Frag_quan.READEX_quan;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.sanpham.Frag_quan.ReadEX_giay;

public class MainActivity extends AppCompatActivity {
FragmentManager fm;
MenuItem themsp;
FragmentContainerView fragmentContainerView;
    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        fm= getSupportFragmentManager();
        setSupportActionBar(binding.appBarMain.toolbar);


        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery,R.id.nav_exit)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);

        NavigationUI.setupWithNavController(navigationView, navController);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                if (item.getItemId() == R.id.nav_exit) {
                    finish();
                    System.exit(1);
                } else {
                    NavigationUI.onNavDestinationSelected(item, navController);
                    drawer.closeDrawers();
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {

 if(item.getItemId() == R.id.themsp_ao_settings){
     Intent intent_ao=new Intent(getApplicationContext(),ReadExternalStorage.class);
     startActivity(intent_ao);
 }
        if(item.getItemId() == R.id.themsp_quan_settings){
            Intent intent_ao=new Intent(getApplicationContext(), READEX_quan.class);
            startActivity(intent_ao);
        }
        if(item.getItemId() == R.id.themsp_giay_settings){
            Intent intent_ao=new Intent(getApplicationContext(), ReadEX_giay.class);
            startActivity(intent_ao);
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}