package com.uncc.gameday.activities.parking;

import javax.xml.datatype.Duration;

import com.uncc.gameday.R;
import com.uncc.gameday.parking.ParkingChoice;
import com.uncc.gameday.parking.ParkingClient;
import com.uncc.gameday.parking.ParkingCoordinate;
import com.uncc.gameday.parking.ParkingRating;
import com.uncc.gameday.parking.RatingChoices;

import android.app.DialogFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.Toast;

public class LotViewFragment extends DialogFragment {
	
	ParkingChoice pc;
	
	public LotViewFragment(){
	}
	
	private void initializeData(ParkingChoice pc){
		ParkingClient client = new ParkingClient(this.getActivity());
		ParkingCoordinate coord = client.listLotLocation(pc).getCoordinate();
		// Set up the MapView here.
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
		
		this.pc = pc;
		initializeData(pc);
		
        View view = inflater.inflate(R.layout.lot_view, container);
        getDialog().setTitle(pc.getValue());

        if (view == null)
        	Log.e("LotViewFragment", "Unable to instantiate view!");
        return view;
    }
	
	public void onSubmitRating() {
		// Submit a rating to the server
		SeekBar bar = (SeekBar)this.getView().findViewById(R.id.lotViewRateLot);
		int rating = bar.getProgress();
		// Switch between values of parking rating
		RatingChoices rc;
		if (rating < 25)
			rc = RatingChoices.EMP;
		else if (rating < 50)
			rc = RatingChoices.SCT;
		else if (rating < 75)
			rc = RatingChoices.BSY;
		else
			rc = RatingChoices.FLL;
		
		ParkingClient pc = new ParkingClient(this.getActivity());
		pc.rateLot(rc, this.pc);
		
		Toast.makeText(this.getActivity(), "Rating submitted!", Toast.LENGTH_SHORT).show();
	}

}
