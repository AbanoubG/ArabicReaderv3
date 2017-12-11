package org.copticchurchlibrary.arabicreader;


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
public class ResurrectionFragment extends Fragment {

    ListView listView;


    public ResurrectionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_resurrection, container, false);
        listView = view.findViewById(R.id.listviewsresurrection);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String[] ResurrectionArray = getActivity().getResources().getStringArray(R.array.ResurrectionArray);
        String[] infoArray = getActivity().getResources().getStringArray(R.array.infoArray);
        CustomListAdapter whatever = new CustomListAdapter(getActivity(), ResurrectionArray, infoArray);
        listView.setAdapter(whatever);
    }

    @Override
    public void onResume(){
        super.onResume();
        ((MainActivity) getActivity()).setActionBarTitle("Holy Resurrection" ); //creates app bar title
    }

}
