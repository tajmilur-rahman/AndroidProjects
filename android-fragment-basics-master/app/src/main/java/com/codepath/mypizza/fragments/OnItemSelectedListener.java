package com.codepath.mypizza.fragments;

// Define the events that the fragment will use to communicate
public interface OnItemSelectedListener {
    // This can be any number of events to be sent to the activity
    void onPizzaItemSelected(int position);
}
