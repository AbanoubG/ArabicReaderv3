package org.copticchurchlibrary.arabicreader;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.app.SearchManager;
import android.support.v7.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class StandardHymnsFragment extends Fragment {


    ListView listView;
    CustomListAdapter whatever;
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
        whatever = new CustomListAdapter(getActivity(), StandardHymnsArray, infoArray);
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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_search, menu);
        MenuItem searchItem = menu.findItem(R.id.menu_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                whatever.getFilter().filter(query);
                listView.setAdapter(whatever);
                return true;

            }

            @Override
            public boolean onQueryTextChange(String newText) {
                whatever.getFilter().filter(newText);
                return true;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onResume(){
        super.onResume();
        ((MainActivity) getActivity()).setActionBarTitle("Std. Hymns + Responses" ); //creates app bar title
    }

}
