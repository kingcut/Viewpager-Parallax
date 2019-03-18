package com.guihgo.parallaxonviewpager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private VerticalViewPager myViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //declare XML views...
        myViewPager = (VerticalViewPager) findViewById(R.id.myViewPager);

        myViewPager.setAdapter(new AdapterViewPager(getSupportFragmentManager()));  //set ViewPager adapter

        /* Setting Effects...
         *  recommended set values from 2 (slow) to -2 (fast)
         * ParallaxTransformInformation arguments =>
         * <THE ID OF VIEW THAT WILL BE PARALLAXED>,
         * <THE SPEED WHEN VIEW ENTER ON SCREEN>,
         * <THE SPEED WHEN VIEW EXIT FROM SCREEN>
         */
//
        ParallaxPageTransformer pageTransformer = new ParallaxPageTransformer()
        .addViewToParallax(new ParallaxPageTransformer.ParallaxTransformInformation(R.id.imgIcon, 0.6f, 0.4f))
        .addViewToParallax(new ParallaxPageTransformer.ParallaxTransformInformation(R.id.llRedBlock, 0.8f, 0.6f))
        .addViewToParallax(new ParallaxPageTransformer.ParallaxTransformInformation(R.id.llBlueBlock, 1f, 0.8f))
        .addViewToParallax(new ParallaxPageTransformer.ParallaxTransformInformation(R.id.llGreenBlock, 1.5f, 1.0f));


//        ParallaxPageTransformer pageTransformer = new ParallaxPageTransformer()
//                .addViewToParallax(new ParallaxPageTransformer.ParallaxTransformInformation(R.id.imgIcon, 2, 2))
//                .addViewToParallax(new ParallaxPageTransformer.ParallaxTransformInformation(R.id.llRedBlock, -0.65f,
//                        ParallaxPageTransformer.ParallaxTransformInformation.PARALLAX_EFFECT_DEFAULT));

//        myViewPager.setPageTransformer(true, pageTransformer); //set page transformer

    }
}
