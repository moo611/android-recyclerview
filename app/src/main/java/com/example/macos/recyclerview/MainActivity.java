package com.example.macos.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


   RecyclerView recyclerView;

   int[]profiles={R.drawable.angel,R.drawable.fanbingbing,R.drawable.zhangziyi};

   String[]names={"angel","fanbingbing","zhangziyi"};

   List<StarModel>stars=new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

          recyclerView=findViewById(R.id.rv);
          recyclerView.setLayoutManager(new LinearLayoutManager(this));
          recyclerView.setAdapter(new RecyclerviewAdapter());






    }


    private class RecyclerviewAdapter extends RecyclerView.Adapter {

        public RecyclerviewAdapter(){


            for (int i=0;i<3;i++){

                StarModel star=new StarModel();
                star.name=names[i];
                star.profile=profiles[i];

                stars.add(star);


            }




        }


        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);


            return new CustomViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


            ((CustomViewHolder)holder).imageView.setImageDrawable(getResources().getDrawable(stars.get(position).profile));
            ((CustomViewHolder)holder).name.setText(stars.get(position).name);




        }

        @Override
        public int getItemCount() {
            return stars.size();
        }
    }



    private class CustomViewHolder extends RecyclerView.ViewHolder {


        ImageView imageView;
        TextView name;


        public CustomViewHolder(View view) {
            super(view);


            imageView=view.findViewById(R.id.image);
            name=view.findViewById(R.id.text);


        }
    }






}
