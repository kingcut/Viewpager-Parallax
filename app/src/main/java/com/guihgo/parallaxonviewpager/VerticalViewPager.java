package com.guihgo.parallaxonviewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.guihgo.parallaxonviewpager.kin.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class VerticalViewPager extends ViewPager {
    VerticalPageTransformer pageTransformer;
    public VerticalViewPager(Context context) {
        super(context);
        init();
    }

    public VerticalViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        pageTransformer = new VerticalPageTransformer()
                .addViewToParallax(new VerticalPageTransformer.ParallaxTransformInformation(R.id.imgIcon, 0.6f, 0.4f))
                .addViewToParallax(new VerticalPageTransformer.ParallaxTransformInformation(R.id.llRedBlock, 0.8f, 0.6f))
                .addViewToParallax(new VerticalPageTransformer.ParallaxTransformInformation(R.id.llBlueBlock, 1f, 0.8f))
                .addViewToParallax(new VerticalPageTransformer.ParallaxTransformInformation(R.id.llGreenBlock, 1.5f, 1.0f));
        // The majority of the magic happens here
        setPageTransformer(true, pageTransformer);
        // The easiest way to get rid of the overscroll drawing that happens on the left and right
        setOverScrollMode(OVER_SCROLL_NEVER);
//        setOnTouchListener(new OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//
//                Log.e("abc", "onTouch  X=" + motionEvent.getX() +  "  Y= " + motionEvent.getY()  + "   getCurrentItem() =" + getCurrentItem());
//                if (motionEvent.getAction() == MotionEvent.ACTION_MOVE){
////                    pageTransformer.transformPage(getChildAt(getCurrentItem()), motionEvent.getY());
//                    final int scrollX = (int) motionEvent.getY();
////                    final int childCount = getChildCount();
////                    for (int i = 0; i < childCount; i++) {
//                        final View child = getChildAt(getCurrentItem()).findViewById(R.id.abc);
//                        final ViewGroup.LayoutParams lp = (ViewGroup.LayoutParams) child.getLayoutParams();
//
////                        if (!lp.isDecor) {
//                            final float transformPos = (float) (child.getLeft() - scrollX) / 1920;
//                            pageTransformer.transformPage(child, transformPos);
////                        }
////                    }
//                }
//                return true;
//            }
//        });
    }



    public static class VerticalPageTransformer implements ViewPager.PageTransformer {

        private List<VerticalPageTransformer.ParallaxTransformInformation> mViewsToParallax
                = new ArrayList<VerticalPageTransformer.ParallaxTransformInformation>();

        public VerticalPageTransformer() {
        }

        public VerticalPageTransformer(List<VerticalPageTransformer.ParallaxTransformInformation> viewsToParallax) {
            mViewsToParallax = viewsToParallax;
        }

        public VerticalPageTransformer addViewToParallax(VerticalPageTransformer.ParallaxTransformInformation viewInfo) {
            if (mViewsToParallax != null) {
                mViewsToParallax.add(viewInfo);
            }
            return this;
        }

//    public void transformPage(View view, float position) {
//
//        int pageWidth = view.getWidth();
//
//        if (position < -1) {
//            // This page is way off-screen to the left.
//            view.setAlpha(1);
//
//        } else if (position <= 1 && mViewsToParallax != null) { // [-1,1]
//            for (ParallaxTransformInformation parallaxTransformInformation : mViewsToParallax) {
//                applyParallaxEffect(view, position, pageWidth, parallaxTransformInformation,
//                        position > 0);
//            }
//        } else {
//            // This page is way off-screen to the right.
//            view.setAlpha(1);
//        }
//    }

        private void applyParallaxEffect(View view, float position, int pageWidth,
                                         VerticalPageTransformer.ParallaxTransformInformation information, boolean isEnter) {
            if (information.isValid() && view.findViewById(information.resource) != null) {
                if (isEnter && !information.isEnterDefault()) {
                    view.findViewById(information.resource)
                            .setTranslationY(-position * (pageWidth / information.parallaxEnterEffect));
                } else if (!isEnter && !information.isExitDefault()) {
                    view.findViewById(information.resource)
                            .setTranslationY(-position * (pageWidth / information.parallaxExitEffect));
                }
//                if (view.findViewById(information.resource).getId() == R.id.img){
//                    view.findViewById(information.resource).setTranslationY(0);
//                }
            }
        }


        /**
         * Information to make the parallax effect in a concrete view.
         * <p>
         * parallaxEffect positive values reduces the speed of the view in the translation
         * ParallaxEffect negative values increase the speed of the view in the translation
         * Try values to see the different effects. I recommend 2, 0.75 and 0.5
         */
        public static class ParallaxTransformInformation {

            public static final float PARALLAX_EFFECT_DEFAULT = -101.1986f;

            int resource = -1;
            float parallaxEnterEffect = 1f;
            float parallaxExitEffect = 1f;

            public ParallaxTransformInformation(int resource, float parallaxEnterEffect,
                                                float parallaxExitEffect) {
                this.resource = resource;
                this.parallaxEnterEffect = parallaxEnterEffect;
                this.parallaxExitEffect = parallaxExitEffect;
            }

            public boolean isValid() {
                return parallaxEnterEffect != 0 && parallaxExitEffect != 0 && resource != -1;
            }

            public boolean isEnterDefault() {
                return parallaxEnterEffect == PARALLAX_EFFECT_DEFAULT;
            }

            public boolean isExitDefault() {
                return parallaxExitEffect == PARALLAX_EFFECT_DEFAULT;
            }
        }

        @Override
        public void transformPage(View view, float position) {
            int pageHeight = view.getHeight();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
//                view.setAlpha(0);

            } else if (position <= 1) { // [-1,1]
//                view.setAlpha(1);

                // Counteract the default slide transition
                view.setTranslationX(view.getWidth() * -position);

                //set Y position to swipe in from top
//                float yPosition = position * view.getHeight();
                float yPosition = -position * pageHeight;
                view.setTranslationY(yPosition);

                if (mViewsToParallax != null) { // [-1,1]
                    for (VerticalPageTransformer.ParallaxTransformInformation parallaxTransformInformation : mViewsToParallax) {
                        applyParallaxEffect(view, position, pageHeight, parallaxTransformInformation,
                                position > 0);
                    }

                } else { // (1,+Infinity]
                    // This page is way off-screen to the right.
//                    view.setAlpha(0);
                }
            }

        }


    }

    /**
     * Swaps the X and Y coordinates of your touch event.
     */
    private MotionEvent swapXY(MotionEvent ev) {
        float width = getWidth();
        float height = getHeight();

        float newX = (ev.getY() / height) * width;
        float newY = (ev.getX() / width) * height;

        ev.setLocation(newX, newY);

        return ev;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercepted = super.onInterceptTouchEvent(swapXY(ev));
        swapXY(ev); // return touch coordinates to original reference frame for any child views
        return intercepted;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        Log.e("abc", "onTouchEvent" + ev.getAction());
//        return false;
        return super.onTouchEvent(swapXY(ev));
    }

}
