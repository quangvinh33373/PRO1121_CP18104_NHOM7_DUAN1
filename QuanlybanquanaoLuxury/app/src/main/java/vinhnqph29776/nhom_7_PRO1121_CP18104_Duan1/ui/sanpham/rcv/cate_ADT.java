package vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.sanpham.rcv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.R;
import vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.sanpham.OnItemCLickListener;


public class cate_ADT extends RecyclerView.Adapter<cate_ADT.CategoryViewHolder> {

    List<category> list;
    Context context;
    OnItemCLickListener cLickListener;

    public cate_ADT(Context context) {
        this.context = context;
    }

    public cate_ADT(List<category> list, OnItemCLickListener cLickListener) {
        this.list = list;
        this.cLickListener = cLickListener;
    }

    public void setData(List<category> mlList){
        this.list=mlList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        category category=list.get(position);
        if (category==null){
            return;
        }
        holder.img.setImageResource(category.getImage());
        holder.tv.setText(category.getName());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{

        LinearLayout fr_ao,fr_quan;
        private ImageView img;
        TextView tv;
        category category;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            img=itemView.findViewById(R.id.img_ctg);
            tv=itemView.findViewById(R.id.tv_name);

            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    cLickListener.OnItemCLickListener(category);
                }
            });


        }
    }

}
