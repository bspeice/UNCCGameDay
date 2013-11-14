package com.uncc.gameday.activities.parking;

import com.uncc.gameday.R;
import com.uncc.gameday.parking.ParkingChoice;

import android.app.DialogFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LotViewFragment extends DialogFragment {
	
	public LotViewFragment(){
	}
	
	private void initializeData(ParkingChoice pc){
		
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

		ParkingChoice pc;
		Bundle args = this.getArguments();
		
		if (args.containsKey("CHOICE"))
			pc = ParkingChoice.valueOf(String.valueOf((char[])args.get("CHOICE")));
		else
			pc = ParkingChoice.BLACK;
		
		initializeData(pc);
		
        View view = inflater.inflate(R.layout.lot_view, container);
        getDialog().setTitle(pc.getValue());

        if (view == null)
        	Log.e("LotViewFragment", "Unable to instantiate view!");
        return view;
    }

}
