package vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.sanpham.Frag_quan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.R;


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>  {
    List<Products> list;
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
        Glide.with(context).load(products.getImage()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tv1,tv2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.image01);
            tv1=itemView.findViewById(R.id.tv01);
            tv2=itemView.findViewById(R.id.tv02);
        }
    }
}
