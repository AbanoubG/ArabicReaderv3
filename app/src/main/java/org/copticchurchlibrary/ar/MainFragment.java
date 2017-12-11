package org.copticchurchlibrary.ar;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    ListView listView;


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_main, container, false);
        listView = view.findViewById(R.id.listviewsmain);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String[] HomeArray = getActivity().getResources().getStringArray(R.array.HomeArray);
        String[] infoArray = getActivity().getResources().getStringArray(R.array.BlankArray);
        CustomListAdapter whatever = new CustomListAdapter(getActivity(), HomeArray, infoArray);
        listView.setAdapter(whatever);
    }

    @Override
    public void onResume(){
        super.onResume();
        ((MainActivity) getActivity()).setActionBarTitle("Arabic Reader" ); //creates app bar title
    }

}
