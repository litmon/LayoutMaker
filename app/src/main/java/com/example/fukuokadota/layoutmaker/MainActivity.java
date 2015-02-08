package com.example.fukuokadota.layoutmaker;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        v.startDrag(null, new View.DragShadowBuilder(v), v, 0);
                        break;
                }

                return true;
            }
        });

        findViewById(R.id.button).setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {

                switch(event.getAction()){
                    case DragEvent.ACTION_DRAG_ENDED:
                        System.out.println("ACTION_DRAG_ENDED");
                        break;
                    case DragEvent.ACTION_DROP:
                        System.out.println("ACTION_DROP");
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        System.out.println("ACTION_DRAG_ENTERED");
                        break;
                    case DragEvent.ACTION_DRAG_STARTED:
                        System.out.println("ACTION_DRAG_STARTED");
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        System.out.println("ACTION_DRAG_EXITED");
                        break;
                    case DragEvent.ACTION_DRAG_LOCATION:
                        System.out.println("ACTION_DRAG_LOCATION");
                        break;
                }

                return true;
            }

        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
