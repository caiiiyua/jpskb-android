package com.since1985i.jpskb;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.R.integer;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainWindow extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.main);
          
        /* bind ListView in xml to be a container of items*/
        ListView lv = (ListView)findViewById(R.id.MenuList);
        //Generate listitems
        ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();  

        HashMap<String, Object> map_stop = new HashMap<String, Object>();  
        map_stop.put("ItemText", getString(R.string.bar_stop));
        listItem.add(map_stop);
        
        HashMap<String, Object> map_train = new HashMap<String, Object>();  
        map_train.put("ItemText", getString(R.string.bar_train));
        listItem.add(map_train);  
        
        HashMap<String, Object> map_update = new HashMap<String, Object>();  
        map_update.put("ItemText", getString(R.string.bar_update));
        listItem.add(map_update);  
        
        HashMap<String, Object> map_about = new HashMap<String, Object>();  
        map_about.put("ItemText", getString(R.string.bar_about));
        listItem.add(map_about);  
        /*
        for(int i=0;i<5;i++)  
        {  
            HashMap<String, Object> map = new HashMap<String, Object>();  
            map.put("ItemText", getString(R.string.bar_stop));
            listItem.add(map);  
        }*/
        
        SimpleAdapter listItemAdatper = new SimpleAdapter(this, listItem, R.layout.menu,
        		new String[] {"ItemText"}, new int[] {R.id.ItemText});
        lv.setAdapter(listItemAdatper);
        
        lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				//setTitle("The "+arg2+" item clicked!");
				switch (arg2) {
				case 0: {
					Intent intent = new Intent(MainWindow.this, ActivityStopQuery.class);
					startActivity(intent);
					break;
				}
				case 1: {
					Intent intent = new Intent(MainWindow.this, ActivityTrainQuery.class);
					startActivity(intent);
					break;
				}
				case 2: {
					Intent intent = new Intent(MainWindow.this, ActivityUpdate.class);
					startActivity(intent);
					break;
				}
				case 3: {
					Intent intent = new Intent(MainWindow.this, ActivityAbout.class);
					startActivity(intent);
					break;
				}
				default:
					break;
				}
			}
        	
        });
    }

}