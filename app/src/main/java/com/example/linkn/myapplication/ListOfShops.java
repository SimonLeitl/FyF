package com.example.linkn.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ListOfShops extends AppCompatActivity {

    private RecyclerView listOfUser;
    private List<String> shops;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
       /* setContentView(R.layout.farm_shop_list);
        listOfUser = findViewById(R.id.shop_recyclerview);
        listOfUser.setLayoutManager(new LinearLayoutManager(this));
        shops = new ArrayList<>();
        for(int i = 0; i<shops.size();i++){
            User user = new User();
            user.setmShopeName(i +"");
        }

    }
    class UserADapter
    class UserViewHolder extends RecyclerView.ViewHolder{

        public UserViewHolder() {
            super(LayoutInflater.from(ListOfShops.this).inflate(R.layout.farm_list_item, container, false));
            mShopeName = itemView.findViewById(R.id.ladenNameView);
        }

        public void bind(User user){
            mShopeName.setText(user.getmShopeName());

        }
    }

    class User {
        private String mShopeName;

        public String getmShopeName() {
            return mShopeName;
        }

        public void setmShopeName(String mShopeName) {
            this.mShopeName = mShopeName;
        }
    }



 */
    }
}
