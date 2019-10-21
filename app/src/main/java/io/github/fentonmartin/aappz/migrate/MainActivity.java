package io.github.fentonmartin.aappz.migrate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import io.github.fentonmartin.aappz.AappZ;

public class MainActivity extends AappZ {

    private Button buttonAction;
    private TextView textContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setActionBarFull();
        setContentView(R.layout.activity_main);
        setActionBarHide();

        buttonAction = findViewById(R.id.migrate_action);
        textContent = findViewById(R.id.migrate_content);

//        setLayout("This is an example of content migration", "Migrate Now!");
    }

    private void setLayout(String text, String button) {
        setLayout(text, button, null);
    }

    private void setLayout(String text, String button, View.OnClickListener listener) {
        buttonAction.setOnClickListener(listener);
        buttonAction.setText(button);
        textContent.setText(text);
    }
}
