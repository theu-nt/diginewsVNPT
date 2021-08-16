package adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ttvnpt.R;

import java.util.ArrayList;

import DAO.DataLocalManager;

import static android.content.Context.MODE_PRIVATE;

public class tinhAdapter extends RecyclerView.Adapter<tinhAdapter.ItemViewHolder>{
    ArrayList <String> arrayListTinh;
    //Context context;
    IClickListener iClickListener;
    String data;
    int vtri;
    ItemViewHolder holder1;
    SharedPreferences sharedPreferences;//=getSharedPreferences("tindp",MODE_PRIVATE);


    public tinhAdapter(ArrayList<String> arrayListTinh, IClickListener iClickListener) {
        this.arrayListTinh = arrayListTinh;
        this.iClickListener = iClickListener;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.chondiaphuong_adapter,parent,false);
        return new ItemViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        data= DataLocalManager.getFirstInstall();
            final String tinh=arrayListTinh.get(position);
            if(tinh==null){
                return;
            }

            holder.tv.setText(tinh);
            if(data.equals(holder.tv.getText().toString())&& data!=null){
                holder.check.setVisibility(View.VISIBLE);
                holder1=holder;
                //

            }
            holder.tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //ItemViewHolder holder1;



                    if(!data.equals(holder.tv.getText().toString())&& data!=null){
                        holder1.check.setVisibility(View.INVISIBLE);
                    }
                    iClickListener.clickIem(tinh);
                    holder.check.setVisibility(View.VISIBLE);


                }
            });
    }

    @Override
    public int getItemCount() {
        if(arrayListTinh!=null)
            return  arrayListTinh.size();

        return 0;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        ImageView check;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tvtinh);
            check=itemView.findViewById(R.id.check);

        }
    }


}
