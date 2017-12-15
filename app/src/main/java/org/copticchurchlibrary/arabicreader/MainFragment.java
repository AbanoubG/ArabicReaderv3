package org.copticchurchlibrary.arabicreader;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;


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

        final String[] HomeArray = getActivity().getResources().getStringArray(R.array.HomeArray);
        String[] infoArray = getActivity().getResources().getStringArray(R.array.HomeDescArray);
        CustomListAdapter whatever = new CustomListAdapter(getActivity(), HomeArray, infoArray);
        listView.setAdapter(whatever);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment fragment=null;
                String tag="";
                switch (position){
                    case 0:
                        fragment=new StandardHymnsFragment();
                        tag=StandardHymnsFragment.class.getName();
                        break;
                    case 1:
                        fragment=new StandardResponsesFragment();
                        tag=StandardResponsesFragment.class.getName();

                        break;
                    case 2:
                        fragment=new GreatFastFragment();
                        tag=GreatFastFragment.class.getName();

                        break;
                    case 3:
                        fragment=new ResurrectionFragment();
                        tag=ResurrectionFragment.class.getName();

                        break;

                }

                if(fragment !=null){
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction()
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    ft.replace(R.id.screen_area, fragment, tag).addToBackStack(tag);
                    ft.addToBackStack(null);

                    ft.commit();

                /*if(fragment!=null) {
                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.screen_area, fragment, tag).addToBackStack(tag);
                    fragmentTransaction.commit();*/
                }
                /*FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                DetailFragment fragment=new DetailFragment();
                Bundle bundle=new Bundle();
                bundle.putInt("position",position);
                bundle.putString("title",HomeArray[position]);
                fragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.screen_area, fragment,"DetailFragment").addToBackStack(DetailFragment.class.getName());
                fragmentTransaction.commit();*/

            }
        });





    }

    @Override
    public void onResume(){
        super.onResume();
        ((MainActivity) getActivity()).setActionBarTitle("Arabic Reader" ); //creates app bar title
    }
}

