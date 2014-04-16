package com.example.moreitemadapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;

public class MainActivity extends Activity {
	private static final int ALL_COUNT = 30;
	private static final int TYPE_1 = 0;
	private static final int TYPE_2 = 1;
	private static final int TYPE_3 = 2;
	private static final int TYPE_COUNT = 3;

	ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv = (ListView) findViewById(R.id.lv);

		lv.setAdapter(new MyAdapter());
		System.out.println();
		
	}

	private class MyAdapter extends BaseAdapter {
		LayoutInflater inflater;

		public MyAdapter() {
			this.inflater = LayoutInflater.from(getApplicationContext());
		}

		@Override
		public int getItemViewType(int position) {
			if(position == 3 || position == 20){
				return TYPE_2;
			}
			if (position % 2 == 0) { //Å¼Êý
				return TYPE_1;
			} else {
				return TYPE_3;
			}
		}

		@Override
		public int getViewTypeCount() {
			return TYPE_COUNT;
		}

		@Override
		public int getCount() {
			return ALL_COUNT;
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			Holder holder = null;
			int viewType = getItemViewType(position);
			if (convertView == null) {
				holder = new Holder();
				switch (viewType) {
				case TYPE_1:
					convertView = inflater.inflate(R.layout.item_1, null);
					holder.btn = (Button)convertView.findViewById(R.id.btn);
					break;
					
				case TYPE_2:
					convertView = inflater.inflate(R.layout.item_2, null);
					holder.cb = (CheckBox)convertView.findViewById(R.id.cb);
					break;
					
				case TYPE_3:
					convertView = inflater.inflate(R.layout.item_3, null);
					break;
					
				default:
					break;
				}
				convertView.setTag(holder);
			}else{
				holder = (Holder)convertView.getTag();
			}
			
			switch (viewType) {
			case TYPE_1:
				holder.btn.setText("" +position);
				break;
			case TYPE_2:
				holder.cb.setChecked(true);
				break;
			default:
				break;
			}

			return convertView;
		}

	}

	private class Holder {
		Button btn;
		CheckBox cb;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
