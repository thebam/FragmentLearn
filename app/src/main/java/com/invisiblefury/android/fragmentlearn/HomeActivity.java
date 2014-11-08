package com.invisiblefury.android.fragmentlearn;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class HomeActivity extends Activity implements AddMessageFragment.MessageAddedCallback, AllMessagesFragment.DisplayMessageCallback {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

            Fragment fragment = new AllMessagesFragment();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.fragmentPlaceholder, fragment);
            ft.commit();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_add) {
            Fragment fr = new AddMessageFragment();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragmentPlaceholder,fr);
            //ft.addToBackStack(null);
            ft.commit();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void messageAdded(Message newMessage){
        /*
        Fragment fr = new ViewMessageFragment();
        Bundle args = new Bundle();
        args.putSerializable(AddMessageFragment.ARG_MESSAGE, newMessage);
        fr.setArguments(args);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragmentPlaceholder,fr);
        ft.addToBackStack(null);
        ft.commit();
        */
        Fragment fr = new AllMessagesFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragmentPlaceholder,fr);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void showMessage(Message message){
        Fragment fr = new ViewMessageFragment();
        Bundle args = new Bundle();
        args.putSerializable(AddMessageFragment.ARG_MESSAGE, message);
        fr.setArguments(args);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragmentPlaceholder,fr);
        ft.addToBackStack(null);
        ft.commit();
    }
}
