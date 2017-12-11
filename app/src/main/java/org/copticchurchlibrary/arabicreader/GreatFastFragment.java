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
public class GreatFastFragment extends Fragment {

    ListView listView;


    public GreatFastFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_great_fast, container, false);
        listView = view.findViewById(R.id.listviewsgreatfast);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String[] GreatFastArray = getActivity().getResources().getStringArray(R.array.GreatFastArray);
        String[] infoArray = getActivity().getResources().getStringArray(R.array.infoArray);
        CustomListAdapter whatever = new CustomListAdapter(getActivity(), GreatFastArray, infoArray);
        listView.setAdapter(whatever);
    }

    @Override
    public void onResume(){
        super.onResume();
        ((MainActivity) getActivity()).setActionBarTitle("Great Fast" ); //creates app bar title
    }

}
