package vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Crud.ADT;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.Chitietsp_activity;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.Objects.SanPham;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.R;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.SuaSP_activity;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Crud.DAO.DAO;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Crud.DAO.DAO_quan;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.sanpham.SuaSP_Quan;

public class ADT_Quan extends RecyclerView.Adapter<ADT_Quan.ViewHolder>{

    List<SanPham> list=new ArrayList<>();
    Context context;
    DAO_quan dao;

    public ADT_Quan(List<SanPham> list, Context context, DAO_quan dao) {
        this.list = list;
        this.context = context;
        this.dao = dao;
    }

    @NonNull
    @Override
    public ADT_Quan.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.layout_item_rcv,parent,false);
        return  new ADT_Quan.ViewHolder(view);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull ADT_Quan.ViewHolder holder, int i) {
        holder.tv1.setText(list.get(i).getTensp());
        holder.tv2.setText(list.get(i).getMoney()+"kVND");
        holder.tv3.setText(list.get(i).getSoluong());
        Glide.with(context).load(list.get(i).getImage()).into(holder.img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Chitietsp_activity.class);
                Bundle bundle = new Bundle();
                bundle.putString("tensp",list.get(i).getTensp());
                bundle.putString("size",list.get(i).getSize());
                bundle.putString("gia",list.get(i).getMoney());
                bundle.putString("sl",list.get(i).getSoluong());
                bundle.putString("anhsp",list.get(i).getImage());
                bundle.putString("loai_sp", "quan");
                bundle.putString("masp",list.get(i).toString());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
//uuuuuuuuuuuu Intent intent = new Intent(context, Chitietsp_activity.class);
//        Bundle bundle = new Bundle();
//        bundle.putString("tensp",list.get(i).getTensp());
//        bundle.putString("size",list.get(i).getSize());
//        bundle.putString("gia",list.get(i).getMoney());
//        bundle.putString("sl",list.get(i).getSoluong());
//        bundle.putString("anhsp",list.get(i).getImage());
//        intent.putExtras(bundle);
//        context.startActivity(intent);
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(context);
                builder.setMessage("Có muốn xóa không !");
                builder.setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int ia) {
                        if(dao.delete_quan(list.get(i))>0){
                            Toast.makeText(context,"Thanh cong",Toast.LENGTH_SHORT).show();
                            list.clear();
                            list.addAll(dao.getAll("sp_quan"));
                            notifyDataSetChanged();
                        }else{
                            Toast.makeText(context,"khong thanh cong",Toast.LENGTH_LONG).show();
                        }
                    }
                });

                builder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
            }
        });


    holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {

//            Dialog dialog = new Dialog(context);
//            dialog.setContentView(R.layout.holding_dialog);
//            WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
//            lp.copyFrom(dialog.getWindow().getAttributes());
//            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
//            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
//            dialog.show();
//            dialog.getWindow().setAttributes(lp);
            Intent suaactivity=new Intent(v.getContext(), SuaSP_Quan.class);
            Bundle bundle = new Bundle();
            bundle.putString("tensp_q",list.get(i).getTensp());
            bundle.putString("size_q",list.get(i).getSize());
            bundle.putString("gia_q",list.get(i).getMoney());
            bundle.putString("sl_q",list.get(i).getSoluong());
            bundle.putString("anhsp",list.get(i).getImage());
            bundle.putString("masp_q", String.valueOf(list.get(i)));
            suaactivity.putExtras(bundle);
            v.getContext().startActivity(suaactivity);
            setData();
            return true;
        }
    });
    }

    @Override
    public int getItemCount() {
        if(list!=null)
            return list.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView delete,edit,img;
        TextView tv1,tv2,tv3;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.image01);
            tv1=itemView.findViewById(R.id.tv01);
            tv2=itemView.findViewById(R.id.tv02);
            tv3=itemView.findViewById(R.id.soluong_tv);
            delete=itemView.findViewById(R.id.img_delete);

        }
    }

    private void setData() {
        list.clear();
        list=dao.getAll("sp_quan");
        notifyDataSetChanged();
    }
//    @SuppressLint("MissingInflatedId")
//    private void showDialogSua(SanPham sanPham){
//        AlertDialog.Builder builder=new AlertDialog.Builder(context);
//        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View view= inflater.inflate(R.layout.sua_sp,null);
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
