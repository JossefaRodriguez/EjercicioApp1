package com.example.guiaejercicioapp2;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        setUpAdapter();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

    }
    private void setUpAdapter() {
        ListView listView = (ListView) findViewById(R.id.mainList);
        MyAdapter adapter = new MyAdapter();
        adapter.setValues(getValues());
        listView.setAdapter(adapter);
    }
    private List<String> getValues() {
        List<String> values = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            values.add("Elemento de listado " + i);
        }
        return values;
    }

    private class MyAdapter extends BaseAdapter {
        private final List<String> values = new ArrayList<>();
        @Override
        public int getCount() {
            return values.size();
        }
        @Override
        public Object getItem(int i) {
            return values.get(i);
        }
        @Override
        public long getItemId(int i) {
            return 0;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.item, container, false);
            }
            String textToShow = getItem(position).toString();
            ((TextView) convertView.findViewById(R.id.textView)).setText(textToShow);
            return convertView;
        }


        public void setValues(List<String> newValues) {
            values.clear();
            values.addAll(newValues);
        }



}
}