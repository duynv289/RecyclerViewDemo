package adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liz.demorecyclerview.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>{

    private List<String> name;
    private List<Integer> image;

    private static OnItemClickListener listener;
    public interface OnItemClickListener{
        void OnItemClick(List<String> name, int position);
    }
    public void OnItemClickListener(OnItemClickListener listener){
        RecyclerViewAdapter.listener = listener;
    }

    public RecyclerViewAdapter(List<String> name, List<Integer> image) {
        this.name = name;
        this.image = image;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_recyclerview,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
       holder.setView(name.get(position),image.get(position));
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView mTextView;
        ImageView mImageView;
        RecyclerViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_hero);
            mTextView  = itemView.findViewById(R.id.text_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) listener.OnItemClick(name,getLayoutPosition());
                }
            });
        }
        private void setView(String name,Integer image){
            mTextView.setText(name);
            mImageView.setImageResource(image);
        }
    }
}