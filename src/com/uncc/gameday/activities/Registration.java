package com.uncc.gameday.activities;

import retrofit.RetrofitError;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.uncc.gameday.R;
import com.uncc.gameday.registration.Attendee;
import com.uncc.gameday.registration.RegistrationClient;

/**
 * The Class Registration.
 */
public class Registration extends MenuActivity {

	/* (non-Javadoc)
	 * @see com.uncc.gameday.activities.MenuActivity#onCreate(android.os.Bundle)
	 */
	
	private TextView t;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registration);
        
        t=(TextView)findViewById(R.id.buttonRegister);

	}
	
	public void onClick(View v) {
		Attendee a = new Attendee();
		a.setFirstName(((TextView)findViewById(R.id.editStudentFirstName)).getText().toString());
		a.setLastName(((TextView)findViewById(R.id.editStudentLastName)).getText().toString());
		a.setSection(((TextView)findViewById(R.id.editSectionNumber)).getText().toString());
		a.setRow(Integer.parseInt(((TextView)findViewById(R.id.editRowNumber)).getText().toString()));
		
		RSVPListener listener = new RSVPListener(this, a);
	
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
		
		private Context c;
		private Attendee a;
		
		public RSVPListener(Context c, Attendee a) {
			this.c = c;
			this.a = a;
		}
		
		public void onClick(DialogInterface dialog, int which) {
			
			switch(which){
				case DialogInterface.BUTTON_POSITIVE: // yes
					new RegisterThread(a, c).start();
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
	
	private class RegisterThread extends Thread {
		
		Attendee a;
		Context c;
		
		public RegisterThread(Attendee a, Context c) {
			this.a = a;
			this.c = c;
		}
		
		public void run() {
			try {
				RegistrationClient client = new RegistrationClient(c);
				client.registerAttendee(a);
			} catch (RetrofitError e) {
				Toast.makeText(c, R.string.internet_down_error, Toast.LENGTH_SHORT).show();
				Log.e("Registration", e.getLocalizedMessage());
			}
		}
	}
}
