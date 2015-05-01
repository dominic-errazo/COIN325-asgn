package derrazo.coin325final;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Set;

public class TagListScreen extends ListActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //get loader

        final Loader data = new TSVLoader();
        Set<String> tagSet = data.getTags();
        tagSet.add("VIEW ALL CHEESES");
        final String[] rawTags = tagSet.toArray(new String[0]);
        setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, rawTags));

        ListView lv = getListView();
        lv.setTextFilterEnabled(false);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //would switch to next screen here
                String selected = rawTags[position];
                Set<String> cheeses;
                if(selected.equals("VIEW ALL CHEESES")) {
                    //list of cheeses to send: all cheeses
                    cheeses = data.getCheeses();
                }
                else {
                    //list of cheeses to send: get from the tag
                    cheeses = data.getCheeses(selected);
                }
                //pass the processed set into the next screen to be displayed
                Intent cheeseScreen = new Intent(getApplicationContext(), CheeseListScreen.class);
                cheeseScreen.putExtra("cheeses", cheeses.toArray(new String[0]));
                startActivity(cheeseScreen);
            }
        });
    }
}
