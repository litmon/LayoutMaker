package com.example.fukuokadota.layoutmaker;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnTouchListener(new OnTouchActionAdapter(){

            @Override
            public boolean onDown(View v, MotionEvent event) {
                findViewById(R.id.button).startDrag(null, new View.DragShadowBuilder(v), v, 0);
                return true;
            }

        });

        findViewById(R.id.button).setOnDragListener(new OnDragActionAdapter() {

            @Override
            public boolean onDrop(View v, DragEvent event) {
                System.out.println("view onDropped");
                return true;
            }
        });

        findViewById(R.id.layout).setOnDragListener(new OnDragActionAdapter() {

            @Override
            public boolean onDrop(View v, DragEvent event) {
                System.out.println("layout onDropped");
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

    abstract class OnTouchActionAdapter extends ActionDefaultSettings implements View.OnTouchListener{

        @Override
        public final boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    return onDown(v, event);
                case MotionEvent.ACTION_MOVE:
                    return onMove(v, event);
                case MotionEvent.ACTION_UP:
                    return onUp(v, event);
                case MotionEvent.ACTION_CANCEL:
                    return onCancel(v, event);
                case MotionEvent.ACTION_HOVER_ENTER:
                    return onHoverEnter(v, event);
                case MotionEvent.ACTION_HOVER_MOVE:
                    return onHoverMove(v, event);
                case MotionEvent.ACTION_HOVER_EXIT:
                    return onHoverExit(v, event);
                case MotionEvent.ACTION_OUTSIDE:
                    return onOutSide(v, event);
                case MotionEvent.ACTION_POINTER_DOWN:
                    return onPointerDown(v, event);
                case MotionEvent.ACTION_POINTER_UP:
                    return onPointerUp(v, event);
                case MotionEvent.ACTION_SCROLL:
                    return onScroll(v, event);

            }

            return actionDefault;
        }

        public boolean onPointerUp(View v, MotionEvent event) {
            return actionDefault;
        }

        public boolean onPointerDown(View v, MotionEvent event) {
            return actionDefault;
        }

        public boolean onOutSide(View v, MotionEvent event) {
            return actionDefault;
        }

        public boolean onHoverExit(View v, MotionEvent event) {
            return actionDefault;
        }

        public boolean onHoverMove(View v, MotionEvent event) {
            return actionDefault;
        }

        public boolean onHoverEnter(View v, MotionEvent event) {
            return actionDefault;
        }

        public boolean onCancel(View v, MotionEvent event) {
            return actionDefault;
        }

        public boolean onUp(View v, MotionEvent event) {
            return actionDefault;
        }

        public boolean onMove(View v, MotionEvent event) {
            return actionDefault;
        }

        public boolean onScroll(View v, MotionEvent event) {
            return actionDefault;
        }

        public boolean onDown(View v, MotionEvent event) {
            return actionDefault;
        }

    }

    abstract class OnDragActionAdapter extends ActionDefaultSettings implements View.OnDragListener{

        public boolean onDragStarted(View v, DragEvent event){
            return actionDefault;
        }

        public boolean onDrop(View v, DragEvent event){
            return actionDefault;
        }

        public boolean onDragEntered(View v, DragEvent event){
            return actionDefault;
        }

        public boolean onDragEnded(View v, DragEvent event){
            return actionDefault;
        }

        public boolean onDragLocation(View v, DragEvent event){
            return actionDefault;
        }

        public boolean onDragExisted(View v, DragEvent event) {
            return actionDefault;
        }

        @Override
        public final boolean onDrag(View v, DragEvent event) {
            switch(event.getAction()){
                case DragEvent.ACTION_DRAG_ENDED:
                    return onDragEnded(v, event);
                case DragEvent.ACTION_DROP:
                    return onDrop(v, event);
                case DragEvent.ACTION_DRAG_ENTERED:
                    return onDragEntered(v, event);
                case DragEvent.ACTION_DRAG_STARTED:
                    return onDragStarted(v, event);
                case DragEvent.ACTION_DRAG_EXITED:
                    return onDragExisted(v, event);
                case DragEvent.ACTION_DRAG_LOCATION:
                    return onDragLocation(v, event);
            }

            return actionDefault;
        }
    }

    abstract public class ActionDefaultSettings {
        protected boolean actionDefault = true;
        public void setActionDefault(boolean actionDefault){
            this.actionDefault = actionDefault;
        }
    }
}
