package com.example.notice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatActivity extends AppCompatActivity {

    String ReciverImage,ReciverUID,ReciverName;
    CircleImageView profileImage;
    TextView reciverName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        ReciverName = getIntent().getStringExtra("name");
        ReciverImage = getIntent().getStringExtra("ReciverImage");
        ReciverUID = getIntent().getStringExtra("uid");


        profileImage = findViewById(R.id.profile_image);
        reciverName = findViewById(R.id.reciverName);

        Picasso.get().load(ReciverImage).into(profileImage);
        reciverName.setText(""+ReciverName);
    }
}