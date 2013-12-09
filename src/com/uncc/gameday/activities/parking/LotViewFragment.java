package com.uncc.gameday.activities.parking;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Toast;

import com.uncc.gameday.R;
import com.uncc.gameday.parking.ParkingChoice;
import com.uncc.gameday.parking.ParkingClient;
import com.uncc.gameday.parking.ParkingLot;
import com.uncc.gameday.parking.RatingChoices;

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
	private void initializeData(ParkingLot pl){
		ProgressBar bar = (ProgressBar)this.getView().findViewById(R.id.lotViewCurrentFilled);
		bar.setProgress(pl.getFilledPct());
		
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
        
        // Initialize our data
        new InitializeThread(pc, this).start();
        
        view.findViewById(R.id.lotViewSubmitRating).setOnClickListener(new SubmitListener(this));
        
        return view;
    }
	
	/**
	 * Send a parking lot rating to the server
	 */
	public void onSubmitRating(View v) {
		// Submit a rating to the server
		SeekBar bar = (SeekBar)this.getView().findViewById(R.id.lotViewLotRating);
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
		
		new SubmitThread(this.pc, rc).start();
		Toast.makeText(getActivity(), "Rating submitted!", Toast.LENGTH_SHORT).show();
	}
	
	private class InitializeThread extends Thread {
		
		ParkingChoice pc;
		LotViewFragment f;
		
		public InitializeThread(ParkingChoice pc, LotViewFragment f) {
			this.pc = pc;
			this.f = f;
		}

		@Override
		public void run() {
			ParkingClient client = new ParkingClient(f.getActivity());
			ParkingLot pl = client.listLot(this.pc);
			ParkingLot pl2 = client.listLotLocation(this.pc);
			pl.setCoordinate(pl2.getCoordinate());
			f.initializeData(pl);
		}
		
	}
	
	private class SubmitThread extends Thread {
		
		ParkingChoice pc;
		RatingChoices r;
		
		public SubmitThread(ParkingChoice pc, RatingChoices r) {
			this.pc = pc;
			this.r = r;
		}
		
		public void run() {
			ParkingClient pc = new ParkingClient(getActivity());
			pc.rateLot(r, this.pc);
		}
	}
	
	private class SubmitListener implements OnClickListener {
		LotViewFragment f;
		
		public SubmitListener(LotViewFragment f) {
			this.f = f;
		}

		@Override
		public void onClick(View v) {
			f.onSubmitRating(v);
		}
	}
}
