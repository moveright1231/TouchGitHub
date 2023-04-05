package com.example.touch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener, onDraw {

    float x = 100f, y = 100f;
    String str;
    Paint paint;

    class MyView extends View {
        public MyView(Context context) {
            super(context);
            setBackgroundColor(Color.YELLOW);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            paint.setColor(Color.MAGENTA);
            paint.setTextSize(48f);
            canvas.drawText("액션의 종류" + str, 0, 50, paint);
            canvas.drawRect(x, y, x + 100, y + 100, paint);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyView myView = new MyView(this);
        myView.setOnTouchListener(this);
        setContentView(myView);

        paint = new Paint();
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            x = motionEvent.getX();
            y = motionEvent.getY();

            paint = new Paint();
            paint.setColor(Color.RED);
            paint.setStyle(Paint.Style.FILL);
        } else if (motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
            x = motionEvent.getX();
            y = motionEvent.getY();
        } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
            paint = new Paint();
            paint.setColor(Color.MAGENTA);
            paint.setStyle(Paint.Style.FILL);
        }

        if (paint != null) {
            view.invalidate((int) (x - 100), (int) (y - 100), (int) (x + 100), (int) (y + 100));
        }

        return true;
    }
}
