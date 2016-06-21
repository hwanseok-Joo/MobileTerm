package helloworld.example.com.payback;


import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;




public class HistoryTab extends Fragment {
    
    private Context mContext;
    HistoryListAdapter adapter;
    /*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstatnceState) {
        View  view = inflater.inflate(R.layout.tab3, null);
        ListView listview = (ListView) view.findViewById(R.id.listView3);
        adapter = new HistoryListAdapter(getActivity());

        adapter.addItem(new HistoryItem("주환석", "Good"," 4","Normal"," 4","Bad"," 4"));
        adapter.addItem(new HistoryItem( "전주희","Good"," 4","Normal"," 4","Bad"," 4"));
        adapter.addItem(new HistoryItem( "곽성훈", "Good"," 4","Normal"," 4","Bad"," 4"));

        listview.setAdapter(adapter);
        return listview;
*/   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstatnceState) {

    View  view = inflater.inflate(R.layout.tab3, container, false);

        ListView listview = (ListView) view.findViewById(R.id.listView3);
        adapter = new HistoryListAdapter(getActivity());

        adapter.addItem(new HistoryItem("주환석", "Good"," 4","Normal"," 4","Bad"," 4"));
        adapter.addItem(new HistoryItem( "전주희","Good"," 4","Normal"," 4","Bad"," 4"));
        adapter.addItem(new HistoryItem( "곽성훈", "Good"," 4","Normal"," 4","Bad"," 4"));

        listview.setAdapter(adapter);

        return listview;

     //   return view;
    }

}



