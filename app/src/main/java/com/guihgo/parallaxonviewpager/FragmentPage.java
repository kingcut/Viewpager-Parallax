package com.guihgo.parallaxonviewpager;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Random;

public class FragmentPage extends Fragment{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_page, null);
		Random rnd = new Random();
		int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
		v.setBackgroundColor(color);
		ImageView imageView = v.findViewById(R.id.img);
		int imgRes = getArguments().getInt("img");
		imageView.setBackgroundResource(imgRes);
		return v;
	}
	
}
