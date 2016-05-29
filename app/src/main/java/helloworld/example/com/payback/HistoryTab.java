package helloworld.example.com.payback;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import helloworld.example.com.payback.R;


public class HistoryTab extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstatnceState) {
        View  view = inflater.inflate(R.layout.tab3, container, false);
        return view;
    }

}
