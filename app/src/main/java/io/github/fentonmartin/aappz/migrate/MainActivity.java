package io.github.fentonmartin.aappz.migrate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import io.github.fentonmartin.aappz.AappZ;

public class MainActivity extends AappZ {

    private Button buttonMigrateAction, buttonMigrateSecondary, buttonMigrateThird;
    private TextView textTitle, textContent;
    private ImageView imageClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setActionBarFull();
        setContentView(R.layout.activity_main);
        setActionBarHide();

        buttonMigrateAction = findViewById(R.id.migrate_action);
        buttonMigrateSecondary = findViewById(R.id.migrate_second_action);
        buttonMigrateThird = findViewById(R.id.migrate_third_action);
        textTitle = findViewById(R.id.migrate_title);
        textContent = findViewById(R.id.migrate_content);
        imageClose = findViewById(R.id.migrate_close);
        imageClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

//        setLayout("This is an example of content migration", "Migrate Now!");

        setLayout("Hello world!", "This is the content", "One", "Two", "Three", true,
                new OnButtonClicked() {

                    @Override
                    public void onPrimaryClick() {
                        setToast("This is one!");
                    }

                    @Override
                    public void onSecondaryClick() {
                        setToast("This is two!");
                    }

                    @Override
                    public void onThirdClick() {

                    }
                });
    }

    private void setLayout(String title, String content, String buttonPrimary, String buttonSecondary, String buttonThird, boolean isClose, final OnButtonClicked listener) {
        textTitle.setText(title);
        textContent.setText(content);
        if (!isClose)
            imageClose.setVisibility(View.GONE);
        buttonMigrateAction.setText(buttonPrimary);
        buttonMigrateAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null)
                    listener.onPrimaryClick();
            }
        });
        buttonMigrateSecondary.setVisibility(View.VISIBLE);
        buttonMigrateSecondary.setText(buttonSecondary);
        buttonMigrateSecondary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null)
                    listener.onSecondaryClick();
            }
        });
        buttonMigrateThird.setVisibility(View.VISIBLE);
        buttonMigrateThird.setText(buttonThird);
        buttonMigrateThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null)
                    listener.onThirdClick();
            }
        });
    }

    public interface OnButtonClicked {

        void onPrimaryClick();

        void onSecondaryClick();

        void onThirdClick();
    }
}
