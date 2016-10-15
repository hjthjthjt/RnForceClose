package com.jakting.fc;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;
import android.widget.EditText;
import android.content.SharedPreferences;
public class Fc extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fc);
		saveCustom();
		openFc();
	
    }
	
	
	public void saveCustom(){
        findViewById(R.id.saveText).setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
				    EditText customText = (EditText)findViewById(R.id.customText);
					String fffText = customText.getText().toString();
					if (fffText.isEmpty()) {
						Toast.makeText(Fc.this, getString(R.string.emptyText), Toast.LENGTH_SHORT).show();
						return;
					} 
                    SharedPreferences.Editor editor = getSharedPreferences("pref", MODE_WORLD_READABLE).edit();
                    editor.putString("fffcustomText", fffText);
                    editor.commit();
                    Toast.makeText(Fc.this,getString(R.string.saveText1),Toast.LENGTH_LONG).show();

				}
			});
		
    
    }
	public void openFc(){
		SharedPreferences sharedPreferences = getSharedPreferences("pref",Activity.MODE_PRIVATE);

		String FFF = sharedPreferences.getString("fffcustomText",getString(R.string.app_name));
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("");
        builder.setMessage(getString(R.string.Dialog1)+FFF+getString(R.string.Dialog2));
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface p1, int p2) {
					
				}
			});
        AlertDialog dialog= builder.create();
        dialog.show();
    }
}
