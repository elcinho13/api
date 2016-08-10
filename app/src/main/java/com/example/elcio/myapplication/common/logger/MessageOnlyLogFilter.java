package com.example.elcio.myapplication.common.logger;


public class MessageOnlyLogFilter extends LogNode {

    LogNode mNext;

    public MessageOnlyLogFilter(LogNode next) {
        mNext = next;
    }

    public MessageOnlyLogFilter() {
    }

    @Override
    public void println(int priority, String tag, String msg, Throwable tr) {
        if (mNext != null) {
            getNext().println(Log.NONE, null, msg, null);
        }
    }

    public LogNode getNext() {
        return mNext;
    }

    public void setNext(LogNode node) {
        mNext = node;
    }

}