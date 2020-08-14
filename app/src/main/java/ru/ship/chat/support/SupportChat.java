package ru.ship.chat.support;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ru.ship.chat.R;
import ru.ship.chat.provider.UserProvider;

public class SupportChat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support_chat);
        TextView label = findViewById(R.id.tv_hello_message);
        label.setText(getResources().getString(R.string.hello_with_name_label, UserProvider.getInstance().getName()));
    }
}