package com.example.students;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class GroupsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups_list);

        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String group = ((StudentsGroup) adapterView.getItemAtPosition(i)).toString();
                Intent intent = new Intent( GroupsListActivity.this, StudentsGroupActivity.class);
                intent.putExtra(StudentsGroupActivity.GROUP_NUMBER, group);
                startActivity(intent);
            }
        };
        ListView listView = (ListView) findViewById(R.id.groups_list);
        listView.setOnItemClickListener(listener);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ListView listView = (ListView) findViewById(R.id.groups_list);

        ArrayAdapter<StudentsGroup> adapter = new ArrayAdapter<StudentsGroup>(
                this, android.R.layout.simple_list_item_1, StudentsGroup.getGroups());
        listView.setAdapter(adapter);
    }

    public void onGrpAddClick(View view){
        startActivity(new Intent(this, AddStudentsGroup.class));
    }
}