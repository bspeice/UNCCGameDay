package com.uncc.gameday.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.uncc.gameday.R;

/**
 * The Class Registration.
 */
public class Registration extends MenuActivity {

	/* (non-Javadoc)
	 * @see com.uncc.gameday.activities.MenuActivity#onCreate(android.os.Bundle)
	 */
	
	private Button b;
	private TextView t;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registration);
        
        t=(TextView)findViewById(R.id.buttonRegister);

	}
	
	public void onClick(View v) {
		RSVPListener listener = new RSVPListener();
	
		AlertDialog ad = new AlertDialog.Builder(this)
		.setMessage("Are you ready to register with UNCC GAME DAY?")
		.setTitle("Confirmation")
		.setPositiveButton("Yes", listener)
		.setNegativeButton("No", listener)
		.setNeutralButton("Edit", listener)
		.setCancelable(false)
		.create();
		
		ad.show();
	}

	public void onClick(DialogInterface dialog, int which) {
	
		switch(which){
		case DialogInterface.BUTTON_POSITIVE: // yes
			t.setText("Your registration has been accepted.  Welcome!");
			break;
		case DialogInterface.BUTTON_NEGATIVE: // no
			t.setText("You may come back and register at amy time.");
			break;
		case DialogInterface.BUTTON_NEUTRAL: // neutral
			t.setText("Please correct any errors and select REGISTER.");
			break;
		default:
			// nothing
			break;
		}
	}
	
	private class RSVPListener implements OnClickListener {
		
		public void onClick(DialogInterface dialog, int which) {
			
			switch(which){
				case DialogInterface.BUTTON_POSITIVE: // yes
					t.setText("Your registration has been accepted.  Welcome!");
					break;
				case DialogInterface.BUTTON_NEGATIVE: // no
					t.setText("You may come back and register at amy time.");
					break;
				case DialogInterface.BUTTON_NEUTRAL: // neutral
					t.setText("Please correct any errors and select REGISTER.");
					break;
				default:
					// nothing
					break;
			}
		}
	}
}
