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

import tl2.lecticiacuna.appfood.MainActivity;
import tl2.lecticiacuna.appfood.databinding.ActivityLogInBinding;

public class LogInActivity extends AppCompatActivity {
    private ActivityLogInBinding binding;
    boolean isClicked = false;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLogInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        auth = FirebaseAuth.getInstance();

        binding.tvReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LogInActivity.this, RegisterActivity.class));
            }
        });
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(isClicked){
                    return;
                }


                loginUser();

            }
        });
    }

    private void loginUser() {
        isClicked=true;

        String userEmail=binding.emailLogin.getText().toString();
        String userPass=binding.passLogin.getText().toString();



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

        //Login User

        auth.signInWithEmailAndPassword(userEmail,userPass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){
                            Toast.makeText(LogInActivity.this, "Login efectuado com Sucesso!!!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LogInActivity.this, MainActivity.class));
                            finish();
                        }else{
                            isClicked=false;
                            Toast.makeText(LogInActivity.this, "ERROR: Email ou senha incorretos"+task.isSuccessful(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });






    }
}