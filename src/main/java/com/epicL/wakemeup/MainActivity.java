package com.epicL.wakemeup;


import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
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

        loadNames();
        generateListView();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_action, menu);

        return super.onCreateOptionsMenu(menu);
    }

    private void loadNames(){
        Names = getResources().getStringArray(R.array.sample_names);
    }

    private void generateListView(){
        list = (ListView) findViewById(R.id.list);
        ListAdapter adapter = new ListAdapter(this);
        list.setAdapter(adapter);
    }

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

    static class ViewHolder{
        public TextView text;
        public ImageView image;
    }


}
