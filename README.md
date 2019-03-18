# Parallax Effect On ViewPager
A simple ViewPager with parallax effect

### Min Android API:
> 9 (Need to import [NineOldAndroids](http://nineoldandroids.com/))

> 21 (withless NineOldAndroids)



**NOTE: Download the project to learn how to usage**

##Demo
![](http://imgur.com/7OArgCy.gif)


## Fast Usage

        ViewPager myViewPager;
        
        //declare XML views...
        myViewPager = (ViewPager) findViewById(R.id.myViewPager);

        myViewPager.setAdapter(new adapterViewPager(getSupportFragmentManager()));  //set ViewPager adapter

        /* Setting Effects...
         *  recommended set values from 2 (slow) to -2 (fast)
         * ParallaxTransformInformation arguments =>
         * <THE ID OF VIEW THAT WILL BE PARALLAXED>,
         * <THE SPEED WHEN VIEW ENTER ON SCREEN>,
         * <THE SPEED WHEN VIEW EXIT FROM SCREEN>
         */

        ParallaxPageTransformer pageTransformer = new ParallaxPageTransformer()
        .addViewToParallax(new ParallaxPageTransformer.ParallaxTransformInformation(R.id.imgIcon, 0.6f, 0.4f))
        .addViewToParallax(new ParallaxPageTransformer.ParallaxTransformInformation(R.id.llRedBlock, 0.8f, 0.6f))
        .addViewToParallax(new ParallaxPageTransformer.ParallaxTransformInformation(R.id.llBlueBlock, 1f, 0.8f))
        .addViewToParallax(new ParallaxPageTransformer.ParallaxTransformInformation(R.id.llGreenBlock, 1.5f, 1.0f));

        myViewPager.setPageTransformer(true, pageTransformer); //set page transformer
        
        
### Thanks to:
 
 - Marcos Trujillo (original creator)
 - Guihgo (update and recreate lib)
 

```
Copyright 2016 Guihgo

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
# Viewpager-Parallax
