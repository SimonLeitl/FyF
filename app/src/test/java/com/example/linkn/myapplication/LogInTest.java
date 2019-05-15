package com.example.linkn.myapplication;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class LogInTest {
    private CountDownLatch authSignal=null;
    private FirebaseAuth auth;
    @Before
    public void setUp()throws InterruptedException{
        authSignal=new CountDownLatch(1);
       auth=FirebaseAuth.getInstance();
        if(auth.getCurrentUser() == null) {
            auth.signInWithEmailAndPassword("test@test.de", "123456").addOnCompleteListener(
                    new OnCompleteListener<AuthResult>() {


                        public void onComplete(@NonNull final Task<AuthResult> task) {

                            final AuthResult result = task.getResult();
                            final FirebaseUser user = result.getUser();
                            authSignal.countDown();
                        }
                    });
        } else {
            authSignal.countDown();
        }
        authSignal.await(10, TimeUnit.SECONDS);
    }

    public void tearDown() throws Exception {
        if(auth != null) {
            auth.signOut();
            auth = null;
        }
    }
   @Test
   public void LoginActivityExists(){
       final CountDownLatch writeSignal = new CountDownLatch(1);
       LoginActivity loginActivityTest=new LoginActivity();



   }
}
