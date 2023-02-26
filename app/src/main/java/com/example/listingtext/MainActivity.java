package com.example.listingtext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> cardTexts;
    private RecyclerView cardList;
    private EditText editText;
    private Button addButton;
    private CardAdapter cardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardTexts = new ArrayList<>();
        cardList = findViewById(R.id.card_list);
        editText = findViewById(R.id.edit_text);
        addButton = findViewById(R.id.add_button);
        cardAdapter = new CardAdapter(cardTexts);
        cardList.setAdapter(cardAdapter);
        cardList.setLayoutManager(new LinearLayoutManager(this));

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                if (!text.isEmpty()) {
                    cardTexts.add(text);
                    cardAdapter.notifyDataSetChanged();
                    editText.getText().clear();
                }
            }
        });
    }
}
