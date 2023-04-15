package vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.sanpham.Frag_quan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.R;


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>  {
    List<Products> list;
    private AdapterView.OnItemClickListener itemClickListener;
    Context context;

    public ProductAdapter(List<Products> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.layout_item_rcv,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        
            Products products=list.get(position);
            holder.tv1.setText(products.getName());
            holder.tv2.setText(products.getPrice()+"$");
            holder.sl_tv.setText("số lượng: "+products.getSoluong());
        Glide.with(context).load(products.getImage()).into(holder.img);



    }

    public void setItemClickListener(AdapterView.OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener {
        ImageView img;
        TextView tv1,tv2,sl_tv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.image01);
            tv1=itemView.findViewById(R.id.tv01);
            tv2=itemView.findViewById(R.id.tv02);
            sl_tv=itemView.findViewById(R.id.soluong_tv);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

        }

        @Override
        public boolean onLongClick(View v) {
            return true;
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context, "alo", Toast.LENGTH_SHORT).show();
        }

    }
public interface OnItemClickListener{
        void onItemClick(int position);
}


 
}
