package com.epicL.wakemeup;


import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {


    private String [] Names;
    private ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        //Should Do a http request to get the names from the online database
        loadNames();
        //When generating list must remeber to get the number of adds per list view by using a http request
        generateListView();

    }

    /*
    * Action Bar Functions
    * initiating the action bar (onCreateOptionsMenu)
    * Controlling response when input is received (onOptionsItemSelected)
    * */

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_action, menu);

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            //About
            case R.id.action_about:
                break;
            //Settings
            case R.id.action_settings:
                break;
            //Help
            case R.id.action_help:
                break;
            default:
                break;
        }

        return true;
    }
    /*
    * Load Names
    * Fill the array Names with the names of the added contact list
    * those names will show up in the list view
    * Add the word "add" in the list to show admob adds in the list
    * */
    private void loadNames(){
        Names = getResources().getStringArray(R.array.sample_names);
    }
    /*
    * Generate List View
    * This will Create the List View Using the ListAdapter(Custom Class Defined below)
    * */
    private void generateListView(){
        list = (ListView) findViewById(R.id.list);
        ListAdapter adapter = new ListAdapter(this);
        list.setAdapter(adapter);
    }

    /*ListAdapter
    * Extends Base Adapter
    * Get View function returns the
    * row(View) which will be the #(i)th View
    * in the list
    * */
    private class ListAdapter extends BaseAdapter{
        private LayoutInflater li;
        public ListAdapter(Context context){
            li = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return Names.length;
        }

        @Override
        public Object getItem(int i) {
            return i;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View row = view;


            row = li.inflate(R.layout.listview_item, null);
            ViewHolder vh = new ViewHolder();
            vh.text = (TextView) row.findViewById(R.id.listviewitem_text);
            vh.image = (ImageView) row.findViewById(R.id.listviewitem_image);
            row.setTag(vh);


            ViewHolder vh1 = (ViewHolder) row.getTag();
            String name = Names[i];
            if(Names[i] != null)
            vh1.text.setText(name);

            if(Names[i].equals("add")){
                row = li.inflate(R.layout.listview_add, null);
                return row;
            }
            return row;
        }
    }
    /*View Holder Class
    * To Hold the TextView
    * and the Image View
    * Which will be referred to later
    * when filling the list view with data*/
    static class ViewHolder{
        public TextView text;
        public ImageView image;
    }


}
