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
public class StandardHymnsFragment extends Fragment {

    //String[] nameArray = {"Octopus","Pig","Sheep","Rabbit","Snake","Spider" };


    ListView listView;
    /*
    String[] infoArray = {
            "8 tentacled monster",
            "Delicious in rolls",
            "Great for jumpers",
            "Nice in a stew",
            "Great for shoes",
            "Scary."
    };
    */


    public StandardHymnsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_standard_hymns, container, false);
        listView = view.findViewById(R.id.listviewstandardhymns);
        return view;
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String[] StandardHymnsArray = getActivity().getResources().getStringArray(R.array.StandardHymnsArray);
        String[] infoArray = getActivity().getResources().getStringArray(R.array.infoArray);
        CustomListAdapter whatever = new CustomListAdapter(getActivity(), StandardHymnsArray, infoArray);
        listView.setAdapter(whatever);
    }

    @Override
    public void onResume(){
        super.onResume();
        ((MainActivity) getActivity()).setActionBarTitle("Std. Hymns + Responses" ); //creates app bar title
    }

}
