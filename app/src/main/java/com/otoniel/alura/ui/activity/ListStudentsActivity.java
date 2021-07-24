package com.otoniel.alura.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.otoniel.alura.R;
import com.otoniel.alura.model.Student;
import com.otoniel.alura.ui.view.StudentListView;

import static com.otoniel.alura.ui.activity.ConstantsActivities.KEY_STUDENT_EDIT;

public class ListStudentsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    final private StudentListView studentListView = new StudentListView(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_students);
        setTitle(getResources().getString(R.string.acitivy_list_student_button));

        createListView();
        handleFabButton();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.activity_student_list_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        final int itemMenuId = item.getItemId();
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Student student = studentListView.getStudent(menuInfo.position);
        if (itemMenuId == R.id.activity_student_list_menu_remove) {
            studentListView.showDialogRemove(student);
        } else if (itemMenuId == R.id.activity_student_list_menu_edit) {
            initFormActivityEdit(student);
        }
        return super.onContextItemSelected(item);
    }

    private void handleFabButton() {
        FloatingActionButton actionButton = findViewById(R.id.list_student_activity_fab_add);
        actionButton.setOnClickListener(v -> initFormActivity());
    }

    private void initFormActivity() {
        startActivity(
                new Intent(this, FormStudentActivity.class)
        );
    }

    private void initFormActivityEdit(Student student) {
        Intent formActivity = new Intent(this, FormStudentActivity.class);
        formActivity.putExtra(KEY_STUDENT_EDIT, student);
        startActivity(formActivity);
    }

    @Override
    protected void onResume() {
        super.onResume();
        studentListView.refreshAdapter();
    }

    private void createListView() {
        ListView listView = findViewById(R.id.activity_list_student_listview);
        listView.setAdapter(studentListView.getAdapterView());
        listView.setOnItemClickListener(this);
        registerForContextMenu(listView);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Student student = (Student) parent.getItemAtPosition(position);
        initFormActivityEdit(student);
    }
}