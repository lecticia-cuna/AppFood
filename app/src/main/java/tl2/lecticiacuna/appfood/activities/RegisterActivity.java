package tl2.lecticiacuna.appfood.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import tl2.lecticiacuna.appfood.databinding.ActivityRegisterBinding;
import tl2.lecticiacuna.appfood.models.UserModel;

public class RegisterActivity extends AppCompatActivity {
    private ActivityRegisterBinding binding;
    FirebaseAuth auth;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        binding.tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LogInActivity.class));
            }
        });

        binding.btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                createUser();

            }
        });
    }

    private void createUser() {
        String userName=binding.nameReg.getText().toString();
        String userEmail=binding.emailReg.getText().toString();
        String userPass=binding.passReg.getText().toString();


        if(TextUtils.isEmpty(userName) ){
            Toast.makeText(this, "Name is Empty!!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(userEmail)){
            Toast.makeText(this, "Email is Empty!!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(userPass)){
            Toast.makeText(this, "Password is Empty!!", Toast.LENGTH_SHORT).show();
            return;
        }

        if(userPass.length()<6){
            Toast.makeText(this, "A password deve ter pelo menos 6 digitos", Toast.LENGTH_SHORT).show();
            return;
        }

        auth.createUserWithEmailAndPassword(userEmail,userPass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            UserModel userModel = new UserModel(userName,userEmail,userPass);
                            Toast.makeText(RegisterActivity.this, "Registro Efectuado com Sucesso!!", Toast.LENGTH_SHORT).show();
                            String id= task.getResult().getUser().getUid();
                            database.getReference().child("Users").child(id).setValue(userModel);
                            startActivity(new Intent(RegisterActivity.this, LogInActivity.class));
                            finish();
                        }else{
                            Toast.makeText(RegisterActivity.this, "Erro ao registrar"+task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
}