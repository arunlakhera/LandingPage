package com.example.android.landingpage;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Created by arunlakhera on 24/03/18.
 */

public class TypeWriter extends android.support.v7.widget.AppCompatTextView {


    private CharSequence mText;
    private int mIndex;
    private long mDelay = 150; //in ms

    public TypeWriter(Context context) {
        super(context);

    }

    public TypeWriter(Context context, AttributeSet attrs) {

        super(context, attrs);
    }

    private Handler mHandler = new Handler() {
        @Override
        public void publish(LogRecord record) {

        }

        @Override
        public void flush() {

        }

        @Override
        public void close() throws SecurityException {

        }
    };

    private Runnable characterAdder = new Runnable() {


        @Override
        public void run() {
            setText(mText.subSequence(0,mIndex++));

            if (mIndex < mText.length()) {
                try {
                    mHandler.wait(mDelay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    };


}
