package derrazo.coin325final;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CheeseListScreen extends ListActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //get loader

        final Loader data = new TSVLoader();
        Intent intent = getIntent();
        final String[] cheeses = intent.getStringArrayExtra("cheeses");
        setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, cheeses));

        ListView lv = getListView();
        lv.setTextFilterEnabled(false);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String selected = cheeses[position];
                Cheese cheese = data.getCheese(selected);
                Intent infoScreen = new Intent(getApplicationContext(), null);
                infoScreen.putExtra("cName", cheese.getName());
                infoScreen.putExtra("cDesc", cheese.getDescription());
                startActivity(infoScreen);
            }
        });
    }
}
