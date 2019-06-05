package com.android2ee.formation.premier.projet.simple;

import com.jcertif.formation.android.brazza.mmxii.premierprojet.R;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class FirstActivity extends Activity {
	Button btnAvant;
	Button btnApres;
	ImageView imvPhoto;
	Drawable image1, image2, image3;
	int photoNum=1;
	Animation inAnimationLeft,outAnimationLeft;
	Animation inAnimationRight,outAnimationRight;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first);
		btnAvant = (Button) findViewById(R.id.previous);
		btnApres = (Button) findViewById(R.id.next);
		imvPhoto = (ImageView) findViewById(R.id.photo);
		image1 = getResources().getDrawable(R.drawable.superbasile);
		image2 = getResources().getDrawable(R.drawable.neige);
		image3 = getResources().getDrawable(R.drawable.basile);
		btnAvant.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				photoAvant();
			}
		});
		btnApres.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				photoApres();
			}
		});
		imvPhoto.setImageDrawable(image1);
		inAnimationLeft=AnimationUtils.loadAnimation(this, R.anim.anim_push_left_in);
		outAnimationLeft=AnimationUtils.loadAnimation(this, R.anim.anim_push_left_out);
		inAnimationRight=AnimationUtils.loadAnimation(this, R.anim.anim_push_right_in);
		outAnimationRight=AnimationUtils.loadAnimation(this, R.anim.anim_push_right_out);
		// Drawable image1=getResources().getDrawable(R.drawable.superbasile);
		// ImageView imv=(ImageView)findViewById(R.id.photo);
		// imv.setImageDrawable(image1);
	}

	public void photoAvant() {
		// ... faire quelque chose

		imvPhoto.startAnimation(inAnimationRight);
		Toast.makeText(this, "PhotoAvant", Toast.LENGTH_LONG).show();
		photoNum=photoNum-1;
		if(photoNum==0) {
			photoNum=3;
		}
		afficherPhoto();
	}

	public void photoApres() {
		// ... faire quelque chose
		imvPhoto.startAnimation(inAnimationLeft);
		Toast.makeText(this, "PhotoApres", Toast.LENGTH_LONG).show();
		photoNum=photoNum+1;
		if(photoNum==0) {
			photoNum=1;
		}
		afficherPhoto();
	}
	
	public void afficherPhoto() {
		
		imvPhoto.startAnimation(inAnimationRight);
		if(photoNum==1) {
			imvPhoto.setImageDrawable(image1);
		}else if(photoNum==2) {
			imvPhoto.setImageDrawable(image2);
		}else if(photoNum==3) {
			imvPhoto.setImageDrawable(image3);
		}else {
			imvPhoto.setImageDrawable(image1);
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_first, menu);
		return true;
	}
}
