package com.uncc.gameday.activities.parking;

import android.app.DialogFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Toast;

import com.uncc.gameday.R;
import com.uncc.gameday.parking.ParkingChoice;
import com.uncc.gameday.parking.ParkingClient;
import com.uncc.gameday.parking.ParkingCoordinate;
import com.uncc.gameday.parking.ParkingLot;
import com.uncc.gameday.parking.RatingChoices;

// TODO: Auto-generated Javadoc
/**
 * The Class LotViewFragment.
 */
public class LotViewFragment extends DialogFragment {
	
	/** The ParkingChoice that we are viewing */
	ParkingChoice pc;
	
	/**
	 * Instantiates a new lot view fragment.
	 */
	public LotViewFragment(){
	}
	
	/**
	 * Initialize the data when the fragment is started.
	 * Specifically, set up the MapView to display, and fetch
	 * other information about the parking lot.
	 *
	 * @param pc - The Parking lot we need to get information for
	 */
	private void initializeData(ParkingChoice pc){
		ParkingClient client = new ParkingClient(this.getActivity());
		
		ParkingLot pl = client.listLot(pc);
		ProgressBar bar = (ProgressBar)this.getView().findViewById(R.id.lotViewCurrentFilled);
		bar.setProgress(pl.getFilledPct());
		
		ParkingCoordinate coord = client.listLotLocation(pc).getCoordinate();
		// Set up the MapView here.
	}
	
	/* (non-Javadoc)
	 * @see android.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
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

		View view = inflater.inflate(R.layout.lot_view, container);
        getDialog().setTitle(pc.getValue());
        initializeData(pc);

        if (view == null)
        	Log.e("LotViewFragment", "Unable to instantiate view!");
        return view;
    }
	
	/**
	 * Send a parking lot rating to the server
	 */
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
