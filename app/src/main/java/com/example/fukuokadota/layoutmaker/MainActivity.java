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
import android.widget.Button;
import android.widget.RelativeLayout;


public class MainActivity extends ActionBarActivity {

    public static final int BUTTON_SIZE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View button = findViewById(R.id.button);
        final ViewGroup layout = (ViewGroup) findViewById(R.id.layout);

        button.setOnClickListener(new View.OnClickListener() {
            boolean isClicked = false;
            Button[] buttons = new Button[4];

            @Override
            public void onClick(View v) {
                isClicked = !isClicked;

                if (isClicked) {
                    for (int i = 0; i < buttons.length; i++) {
                        buttons[i] = new Button(MainActivity.this);
                        buttons[i].setOnTouchListener(new OnTouchActionAdapter() {
                            @Override
                            public boolean onMove(View v, MotionEvent event) {

                                return true;
                            }
                        });
                    }

                    int x = (int) button.getX();
                    int y = (int) button.getY();
                    int w = button.getWidth();
                    int h = button.getHeight();

                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(BUTTON_SIZE, BUTTON_SIZE);
                    params.leftMargin = x - BUTTON_SIZE;
                    params.topMargin = y - BUTTON_SIZE;

                    layout.addView(buttons[0], params);

                    params = new RelativeLayout.LayoutParams(BUTTON_SIZE, BUTTON_SIZE);
                    params.leftMargin = x + w - BUTTON_SIZE;
                    params.topMargin = y - BUTTON_SIZE;

                    layout.addView(buttons[1], params);

                    params = new RelativeLayout.LayoutParams(BUTTON_SIZE, BUTTON_SIZE);
                    params.leftMargin = x - BUTTON_SIZE;
                    params.topMargin = y + h - BUTTON_SIZE;

                    layout.addView(buttons[2], params);

                    params = new RelativeLayout.LayoutParams(BUTTON_SIZE, BUTTON_SIZE);
                    params.leftMargin = x + w - BUTTON_SIZE;
                    params.topMargin = y + h - BUTTON_SIZE;

                    layout.addView(buttons[3], params);

                } else {
                    for(Button b : buttons) {
                        layout.removeView(b);
                    }
                }
            }
        });

        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                button.startDrag(null, new View.DragShadowBuilder(button), button, 0);
                return true;
            }
        });

        button.setOnDragListener(new OnDragActionAdapter() {
            @Override
            public boolean onDrop(View v, DragEvent event) {
                System.out.println("view onDropped");
                button.setX(button.getX() + event.getX() - button.getWidth() / 2);
                button.setY(button.getY() + event.getY() - button.getHeight() / 2);

                return true;
            }
        });

        findViewById(R.id.layout).setOnDragListener(new OnDragActionAdapter() {
            @Override
            public boolean onDrop(View v, DragEvent event) {
                System.out.println("layout onDropped");
                button.setX(event.getX() - button.getWidth() / 2);
                button.setY(event.getY() - button.getHeight() / 2);

                return true;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    abstract class OnTouchActionAdapter extends ActionDefaultSettings implements View.OnTouchListener {

        @Override
        public final boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
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

    abstract class OnDragActionAdapter extends ActionDefaultSettings implements View.OnDragListener {

        public boolean onDragStarted(View v, DragEvent event) {
            return actionDefault;
        }

        public boolean onDrop(View v, DragEvent event) {
            return actionDefault;
        }

        public boolean onDragEntered(View v, DragEvent event) {
            return actionDefault;
        }

        public boolean onDragEnded(View v, DragEvent event) {
            return actionDefault;
        }

        public boolean onDragLocation(View v, DragEvent event) {
            return actionDefault;
        }

        public boolean onDragExisted(View v, DragEvent event) {
            return actionDefault;
        }

        @Override
        public final boolean onDrag(View v, DragEvent event) {
            switch (event.getAction()) {
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

        public void setActionDefault(boolean actionDefault) {
            this.actionDefault = actionDefault;
        }
    }
}
