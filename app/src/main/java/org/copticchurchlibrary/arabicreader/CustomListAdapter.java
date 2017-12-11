package org.copticchurchlibrary.arabicreader;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


/**
 * Created by ${Abanoub} on 12/8/2017.
 */

public class CustomListAdapter extends ArrayAdapter {
    //to reference the Activity
    private final Activity context;

    //to store the list of countries
    private final String[] nameArray;

    //to store the list of countries
    private final String[] infoArray;


    CustomListAdapter(Activity context, String[] nameArrayParam, String[] infoArrayParam){

        super(context, R.layout.listview_row , nameArrayParam);

        this.context=context;
        this.nameArray = nameArrayParam;
        this.infoArray = infoArrayParam;


    }

    @NonNull
    public View getView(int position, View view, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listview_row, null,true);

        //this code gets references to objects in the listview_row.xml file
        TextView nameTextField = rowView.findViewById(R.id.nameTextViewID);
        TextView infoTextField = rowView.findViewById(R.id.infoTextViewID);

        //this code sets the values of the objects to values from the arrays
        nameTextField.setText(nameArray[position]);
        infoTextField.setText(infoArray[position]);

        return rowView;

    }
}


