package vn.tranhoangtrong.a63135901_thigiuaky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import android.text.method.LinkMovementMethod;

public class Cau4Activity extends AppCompatActivity {

    public void quayVeManHinh(View v){
        Intent iMainScreen = new Intent(this, MainActivity.class);
        startActivity(iMainScreen);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau4);

        TextView gitHubTextView = findViewById(R.id.gitHubTextView);
        TextView yTTextView = findViewById(R.id.yTTextView);

        // Enable clickable hyperlinks

        gitHubTextView.setText(Html.fromHtml(getString(R.string.gitHubLink))); //This line is for custom link
        gitHubTextView.setMovementMethod(LinkMovementMethod.getInstance());

        yTTextView.setText(Html.fromHtml(getString(R.string.yTLink))); //This line is for custom link
        yTTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}