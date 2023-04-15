package vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Crud.ADT;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.Objects.HoaDon;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.R;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Crud.DAO.DAO;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Crud.DAO.HoaDon_Dao;

public class AdapterHoaDon extends BaseAdapter {
    ArrayList<HoaDon> list=new ArrayList<>();
    Context context;
    HoaDon_Dao dao;

    public AdapterHoaDon(ArrayList<HoaDon> list, Context context, HoaDon_Dao dao) {
        this.list = list;
        this.context = context;
        this.dao = dao;
    }
    public void setData(ArrayList<HoaDon> list1){
        this.list= list1;
        notifyDataSetChanged();//refresh lại adapter
    }
    public final class ViewHolder{
        ImageView delete,setting;
        TextView tv1,tv2,tv3,tv4;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return list.get(i).getMahd();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder mview=null;
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(view==null){
            mview=new ViewHolder();
            view=inflater.inflate(R.layout.layout_item_hoadon,null);
            mview.tv1=view.findViewById(R.id.tv_name_sp);
            mview.tv2=view.findViewById(R.id.tv_slitem);
            mview.tv3=view.findViewById(R.id.tv_gsp);
            mview.tv4=view.findViewById(R.id.tv_tongit);
            mview.delete=view.findViewById(R.id.delete_hd);

            view.setTag(mview);
        }else{
            mview= (ViewHolder) view.getTag();
        }
        mview.tv1.setText(list.get(i).getTensp());
        mview.tv2.setText(list.get(i).getSoluong());
        mview.tv3.setText(list.get(i).getGia());
        mview.tv4.setText(String.valueOf(list.get(i).getTongtien()));
        mview.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dao.delete(list.get(i))>0){
                    Toast.makeText(context,"Xoa Thanh cong",Toast.LENGTH_LONG).show();
                    setData();
                }else{
                    Toast.makeText(context,"Khong Thanh cong",Toast.LENGTH_LONG).show();
                }
            }
        });


        return view;
    }
    private void setData() {
        list.clear();
        list= (ArrayList<HoaDon>) dao.getAll("hoadon");
        notifyDataSetChanged();
    }

//        @SuppressLint("MissingInflatedId")
//    private void showDialogSua(SanPham sanPham){
//        AlertDialog.Builder builder=new AlertDialog.Builder(context);
//        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View view= inflater.inflate(R.layout.,null);
//        EditText sua_tensp = view.findViewById(R.id.sua_tensp);
//        EditText sua_sl = view.findViewById(R.id.sua_soluong);
//        EditText sua_kcsp = view.findViewById(R.id.sua_kichco);
//        EditText sua_giatien = view.findViewById(R.id.sua_giatien);
//
//        builder.setView(view);
//        sua_tensp.setText(sanPham.getTensp());
//        sua_kcsp.setText(sanPham.getSize());
//        sua_giatien.setText(sanPham.getMoney());
//        sua_sl.setText(sanPham.getSoluong());
//
//        builder.setPositiveButton("Sửa",new DialogInterface.OnClickListener(){
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                String tenSP=sua_tensp.getText().toString();
//                sanPham.setTensp(tenSP);
//                String kcSP=sua_kcsp.getText().toString();
//                sanPham.setSize(kcSP);
//                String giaSP=sua_giatien.getText().toString();
//                sanPham.setMoney(giaSP);
//                String slSP=sua_sl.getText().toString();
//                sanPham.setSoluong(slSP);
//                dao=new DAO_quan(context);
//                if(dao.update_quan(sanPham)>0){
//                    Toast.makeText(context,"thanh cong",Toast.LENGTH_LONG).show();
//                }else{
//                    Toast.makeText(context,"khong thanh cong",Toast.LENGTH_LONG).show();
//                }
//            }
//        });
//        builder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//
//            }
//        });
//
//
//        builder.show();
//    }
}
