package com.example.notice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatActivity extends AppCompatActivity {

    String ReciverImage,ReciverUID,ReciverName;
    CircleImageView profileImage;
    TextView reciverName;
    FirebaseDatabase database;
    FirebaseAuth firebaseAuth;
    public static String sImage;
    public static String rImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        database= FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();

        ReciverName = getIntent().getStringExtra("name");
        ReciverImage = getIntent().getStringExtra("ReciverImage");
        ReciverUID = getIntent().getStringExtra("uid");


        profileImage = findViewById(R.id.profile_image);
        reciverName = findViewById(R.id.reciverName);

        Picasso.get().load(ReciverImage).into(profileImage);
        reciverName.setText(""+ReciverName);

        DatabaseReference reference = database.getReference().child("user").child(firebaseAuth.getUid());

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               sImage = snapshot.child("imageUri").getValue().toString();
               rImage = ReciverImage;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}