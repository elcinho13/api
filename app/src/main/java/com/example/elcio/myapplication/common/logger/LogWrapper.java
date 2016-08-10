package com.example.elcio.myapplication.common.logger;

import android.util.Log;


public class LogWrapper extends LogNode {

    // For piping:  The next node to receive Log data after this one has done its work.
    private LogNode mNext;

    /**
     * Returns the next LogNode in the linked list.
     */
    public LogNode getNext() {
        return mNext;
    }

    /**
     * Sets the LogNode data will be sent to..
     */
    public void setNext(LogNode node) {
        mNext = node;
    }


    @Override
    public void println(int priority, String tag, String msg, Throwable tr) {
        String useMsg = msg;
        if (useMsg == null) {
            useMsg = "";
        }

        if (tr != null) {
            msg += "\n" + Log.getStackTraceString(tr);
        }

        Log.println(priority, tag, useMsg);

        if (mNext != null) {
            mNext.println(priority, tag, msg, tr);
        }
    }
}