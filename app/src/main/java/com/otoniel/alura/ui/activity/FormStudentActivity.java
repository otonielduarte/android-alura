package com.otoniel.alura.ui.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.otoniel.alura.R;
import com.otoniel.alura.model.Student;
import com.otoniel.alura.ui.view.FormStudentView;

import static com.otoniel.alura.ui.activity.ConstantsActivities.KEY_STUDENT_EDIT;

public class FormStudentActivity extends AppCompatActivity {

    EditText editTextName;
    EditText editTextPhone;
    EditText editTextEmail;
    private final FormStudentView formStudentView = new FormStudentView();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_student);
        bindFields();
        handleFormType();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_student_form_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        final int index = item.getItemId();
        if(index == R.id.activity_student_form_menu_save) {
            handleClick();
        }
        return super.onOptionsItemSelected(item);
    }

    private void handleFormType() {
        Student student = (Student) getIntent().getSerializableExtra(KEY_STUDENT_EDIT);
        if(student != null) {
            setTitle(getResources().getString(R.string.activity_form_student_edit));
            setFormValues(student);
        } else {
            setTitle(getResources().getString(R.string.activity_form_student_add));
            student = new Student();
        }
        formStudentView.setStudent(student);
    }

    private void bindFields() {
        editTextName = findViewById(R.id.activity_form_name);
        editTextPhone = findViewById(R.id.activity_form_phone);
        editTextEmail = findViewById(R.id.activity_form_email);
    }

    private void setFormValues(Student student) {
        editTextName.setText(student.getNome());
        editTextPhone.setText(student.getPhone());
        editTextEmail.setText(student.getEmail());
    }

    private void handleClick() {
        setStudentWithFormValues();
        finish();
    }

    private void setStudentWithFormValues() {
        String name = editTextName.getText().toString();
        String phone = editTextPhone.getText().toString();
        String email = editTextEmail.getText().toString();

        Student student = formStudentView.getStudent();
        student.setEmail(email);
        student.setPhone(phone);
        student.setNome(name);

        formStudentView.save();
    }
}
