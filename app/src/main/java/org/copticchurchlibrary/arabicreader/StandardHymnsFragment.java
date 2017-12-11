package org.copticchurchlibrary.arabicreader;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import org.copticchurchlibrary.arabicreader.DetailFragment;



/**
 * A simple {@link Fragment} subclass.
 */
public class StandardHymnsFragment extends Fragment {


    ListView listView;

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
        final String[] StandardHymnsArray = getActivity().getResources().getStringArray(R.array.StandardHymnsArray);
        final String[] StandardHymnsArrayLyrics = getActivity().getResources().getStringArray(R.array.StandardHymnsArrayLyrics);
        String[] infoArray = getActivity().getResources().getStringArray(R.array.infoArray);
        CustomListAdapter whatever = new CustomListAdapter(getActivity(), StandardHymnsArray, infoArray);
        listView.setAdapter(whatever);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                DetailFragment fragment=new DetailFragment();
                Bundle bundle=new Bundle();
                bundle.putInt("position",position);
                bundle.putString("title",StandardHymnsArray[position]);
                bundle.putString("lyrics",StandardHymnsArrayLyrics[position]);
                fragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.screen_area, fragment,"DetailFragment").addToBackStack(DetailFragment.class.getName());
                fragmentTransaction.commit();

            }
        });

    }

    @Override
    public void onResume(){
        super.onResume();
        ((MainActivity) getActivity()).setActionBarTitle("Std. Hymns + Responses" ); //creates app bar title
    }

}
