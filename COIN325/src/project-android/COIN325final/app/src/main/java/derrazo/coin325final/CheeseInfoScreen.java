package derrazo.coin325final;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class CheeseInfoScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cheese_desc);
        TextView title = (TextView)findViewById(R.id.title);
        TextView descr = (TextView)findViewById(R.id.description);
        Intent intent = getIntent();
        title.setText(intent.getStringExtra("cName"));
        descr.setText(intent.getStringExtra("cDesc"));
    }
}
