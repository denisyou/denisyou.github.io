package example.rick.denisyou;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import example.rick.tablayoutdemo.R;


public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final Button bRegister = (Button) findViewById(R.id.bRegister);

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = etUsername.getText().toString();
                final String password = etPassword.getText().toString();

                if( etUsername.length() == 0 ) {
                    Toast.makeText(Register.this, "帳號不得空白",Toast.LENGTH_SHORT).show();
                    return;
                }

                if( etUsername.length() < 8 || etUsername.length() > 16 ) {
                    Toast.makeText(Register.this, "帳號長度必須為8~16之間",Toast.LENGTH_SHORT).show();
                    return;
                }

                if( etPassword.length() == 0 ) {
                    Toast.makeText(Register.this, "密碼不得空白",Toast.LENGTH_SHORT).show();
                    return;
                }

                if( etPassword.length() < 8 || etPassword.length() >16 ) {
                    Toast.makeText(Register.this, "密碼長度必須為8~16之間",Toast.LENGTH_SHORT).show();
                    return;
                }

                Pattern pattern = Pattern.compile("[^a-zA-Z0-9_]");
                Matcher matcher = pattern.matcher(username);
                if( matcher.find() ) {
                    Toast.makeText(Register.this, "帳號不得含有數字、英文，或下底線以外的字元",Toast.LENGTH_SHORT).show();
                    return;
                }

                pattern = Pattern.compile("[^a-zA-Z0-9]");
                matcher = pattern.matcher(password);
                if( matcher.find() ) {
                    Toast.makeText(Register.this, "密碼不得含有數字或英文以外的字元",Toast.LENGTH_SHORT).show();
                    return;
                }


                final Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            boolean duplicated = jsonResponse.getBoolean("duplicated");
                            if (success) {
                                Toast.makeText(Register.this, "Register successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Register.this, MainActivity.class));

                            } else if (duplicated) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Register.this);
                                builder.setMessage("此帳號名稱已有人使用")
                                        .setNegativeButton("更改", null)
                                        .create()
                                        .show();

                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Register.this);
                                builder.setMessage("Register Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                RegisterRequest registerRequest = new RegisterRequest(username, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Register.this);
                queue.add(registerRequest);
            }
        });

    }

}
