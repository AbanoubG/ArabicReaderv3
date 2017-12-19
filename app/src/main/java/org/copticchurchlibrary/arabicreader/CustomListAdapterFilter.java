package org.copticchurchlibrary.arabicreader;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by ${Abanoub} on 12/8/2017.
 */

public class CustomListAdapterFilter extends BaseAdapter {
    //to reference the Activity
    private final Activity context;

    //to store the list of countries
    private List<String> nameArray;

    //to store the list of countries
    private final String[] infoArray;


    CustomListAdapterFilter(Activity context, List<String> nameArrayParam, String[] infoArrayParam){
        this.context=context;
        this.nameArray = nameArrayParam;
        this.infoArray = infoArrayParam;


    }
    public void filterStudents(String filter,List<String> originalList)
    {
        // Create new empty list to add matched elements to
        List<String> filtered = new ArrayList<>();
        // examine each element to build filtered list
        // remember to always use your original items list
        String lowercasefilter=filter.toLowerCase();
        for(String s : originalList)
        {
            String item=s.toLowerCase();
            if (item.contains(lowercasefilter))
            {
                filtered.add(s);
            }
        }

        //set new (filterd) current list of items
        this.nameArray = filtered;

        //notify ListView to Rebuild
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return nameArray.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @NonNull
    public View getView(int position, View view, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listview_row, null,true);

        //this code gets references to objects in the listview_row.xml file
        TextView nameTextField = rowView.findViewById(R.id.nameTextViewID);
        TextView infoTextField = rowView.findViewById(R.id.infoTextViewID);

        //this code sets the values of the objects to values from the arrays
        nameTextField.setText(nameArray.get(position));
        infoTextField.setText(infoArray[position]);

        return rowView;

    }
}


