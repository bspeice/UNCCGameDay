package com.uncc.gameday.activities;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;

import com.uncc.gameday.R;
import com.uncc.gameday.activities.parking.LotViewFragment;
import com.uncc.gameday.parking.ParkingChoice;


// TODO: Auto-generated Javadoc
/**
 * The Class Parking.
 */
public class Parking extends MenuActivity {

	/* (non-Javadoc)
	 * @see com.uncc.gameday.activities.MenuActivity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_parking);
	}
	
	/**
	 * On radio button click.
	 *
	 * @param v the v
	 */
	public void onRadioButtonClick(View v) {
		FragmentManager fm = this.getFragmentManager();
		LotViewFragment f = new LotViewFragment();
		Bundle fBundle = new Bundle();
		
		switch (v.getId()) {
			case R.id.radioButtonBlack:
				fBundle.putCharArray("CHOICE", ParkingChoice.BLACK.getValue().toCharArray());
				break;
			case R.id.radioButtonBlue:
				fBundle.putCharArray("CHOICE", ParkingChoice.BLUE.getValue().toCharArray());
				break;
			case R.id.radioButtonGold:
				fBundle.putCharArray("CHOICE", ParkingChoice.GOLD.getValue().toCharArray());
				break;
			case R.id.radioButtonGreen:
				fBundle.putCharArray("CHOICE", ParkingChoice.GREEN.getValue().toCharArray());
				break;
			case R.id.radioButtonOrange:
				fBundle.putCharArray("CHOICE", ParkingChoice.ORANGE.getValue().toCharArray());
				break;
			case R.id.radioButtonPink:
				fBundle.putCharArray("CHOICE", ParkingChoice.PINK.getValue().toCharArray());
				break;
			case R.id.radioButtonPurple:
				fBundle.putCharArray("CHOICE", ParkingChoice.PURPLE.getValue().toCharArray());
				break;
			case R.id.radioButtonRed:
				fBundle.putCharArray("CHOICE", ParkingChoice.RED.getValue().toCharArray());
				break;
			case R.id.radioButtonSilver:
				fBundle.putCharArray("CHOICE", ParkingChoice.SILVER.getValue().toCharArray());
				break;
			case R.id.radioButtonWhite:
				fBundle.putCharArray("CHOICE", ParkingChoice.WHITE.getValue().toCharArray());
				break;
			case R.id.radioButtonYellow:
				fBundle.putCharArray("CHOICE", ParkingChoice.YELLOW.getValue().toCharArray());
				break;
		}
		
		f.setArguments(fBundle);
		f.show(fm, "lot_view");
	}
}