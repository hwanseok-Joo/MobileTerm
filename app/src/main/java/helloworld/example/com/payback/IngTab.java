package helloworld.example.com.payback;


import android.content.Context;
import android.content.res.Resources;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;




public class IngTab extends Fragment {
    private Context mContext;
    IngListAdapter adapter;
    ImageButton imgBtn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstatnceState) {

        View view = inflater.inflate(R.layout.tab2, null);
        ListView listview = (ListView) view.findViewById(R.id.listView2);
        imgBtn = (ImageButton)view.findViewById(R.id.iconItem);
        adapter = new IngListAdapter(getActivity());
        Resources res = getResources();

        adapter.addItem(new IngItem(res.getDrawable(R.drawable.message), "주환석", "30,000 원", "D-10"));
        adapter.addItem(new IngItem(res.getDrawable(R.drawable.message), "전주희", "26,000 원", "D-22"));
        adapter.addItem(new IngItem(res.getDrawable(R.drawable.message), "곽성훈", "300,000 원", "D-25"));
        listview.setAdapter(adapter);
        return listview;
    }
}
