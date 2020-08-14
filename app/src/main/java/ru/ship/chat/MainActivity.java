package ru.ship.chat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ru.ship.chat.provider.UserProvider;
import ru.ship.chat.support.SupportChat;

public class MainActivity extends AppCompatActivity {
    private Button loginButton;

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginButton = findViewById(R.id.btn_login);
        editText = findViewById(R.id.et_user_name);
    }

    @Override
    protected void onStart() {
        super.onStart();
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText.getText().toString();
                if (name.isEmpty()) {
                    Toast.makeText(
                        MainActivity.this,
                        getResources().getString(R.string.empty_name_message),
                        Toast.LENGTH_LONG
                    ).show();
                } else {
                    UserProvider.getInstance().setName(name);
                    Intent intent = new Intent(MainActivity.this, SupportChat.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        loginButton.setOnClickListener(null);
    }
}