package br.com.itb.pra3.animacao1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    FrameLayout cena1;
    Scene primeiraCena;
    Scene segundaCena;
    Transition changeBoundsTransition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal);

        // Create the scene root for the scenes in this app
        cena1 = findViewById(R.id.cena);

        //TransitionManager.beginDelayedTransition(cena1, new Explode());

        // Create the scenes
        primeiraCena = Scene.getSceneForLayout(cena1, R.layout.activity_main, this);
        segundaCena =
                Scene.getSceneForLayout(cena1, R.layout.activity_main2, this);

        changeBoundsTransition = TransitionInflater.from(this)
                .inflateTransition(R.transition.change_bounds_transition);
        Transition fadeTransition = TransitionInflater.from(this)
                .inflateTransition(R.transition.fade_transition);
        Transition diversasTransitions = TransitionInflater.from(this)
                .inflateTransition(R.transition.transition_set);
        Transition fadeTransition2 = new Fade(Fade.IN);

        fadeTransition.setDuration(5555);

        TransitionManager.go(primeiraCena, fadeTransition);

        findViewById(R.id.imageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransitionManager.go(segundaCena, changeBoundsTransition);
            }
        });

        //        TransitionManager.beginDelayedTransition(cena1);

        /*        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            TransitionManager.endTransitions(cena1);
        }*/

        /* Transition fadeTransition = TransitionInflater.from(this)
                .inflateTransition(R.transition.fade_transition);

        TransitionManager.go(segundaCena, fadeTransition);*/

        /*Transition diversasTransitions = TransitionInflater.from(this)
                .inflateTransition(R.transition.transition_set);

        TransitionManager.go(segundaCena, diversasTransitions);*/

    }

}