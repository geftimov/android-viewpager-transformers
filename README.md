android-viewpager-transformers
==============================

A collection of view pager transformers.

This repos is fork from [daimajia](https://github.com/daimajia/ViewPagerTransforms) but i uploaded it to maven central and added some more javadoc.

#Getting Started

Add gradle dependency to your application.
```
repositories {
    maven { url "https://oss.sonatype.org/content/repositories/snapshots/" }
    mavenCentral()
}
dependencies {
    compile 'com.eftimoff:android-viewpager-transformers:1.0.0-SNAPSHOT@aar'
}
```

How you can use it:

```java
// Reference (or instantiate) a ViewPager instance and apply a transformer
pager = (ViewPager) findViewById(R.id.container);
pager.setAdapter(mAdapter);
pager.setPageTransformer(true, new RotateUpTransformer());
```

#List of trasnformers

* [AccordionTransformer](https://github.com/geftimov/android-viewpager-transformers/wiki/AccordionTransformer)
* [BackgroundToForegroundTransformer](https://github.com/geftimov/android-viewpager-transformers/wiki/BackgroundToForegroundTransformer)
* [CubeInTransformer](https://github.com/geftimov/android-viewpager-transformers/wiki/CubeInTransformer)
* [CubeOutTransformer](https://github.com/geftimov/android-viewpager-transformers/wiki/CubeOutTransformer)
* [DefaultTransformer](https://github.com/geftimov/android-viewpager-transformers/wiki/DefaultTransformer)
* [DepthPageTransformer](https://github.com/geftimov/android-viewpager-transformers/wiki/DepthPageTransformer)
* [DrawFromBackTransformer](https://github.com/geftimov/android-viewpager-transformers/wiki/DrawFromBackTransformer)
* [FlipHorizontalTransformer](https://github.com/geftimov/android-viewpager-transformers/wiki/FlipHorizontalTransformer)
* [FlipVerticalTransformer](https://github.com/geftimov/android-viewpager-transformers/wiki/FlipVerticalTransformer)
* [ForegroundToBackgroundTransformer](https://github.com/geftimov/android-viewpager-transformers/wiki/ForegroundToBackgroundTransformer)
* [ParallaxPageTransformer](https://github.com/geftimov/android-viewpager-transformers/wiki/ParallaxPageTransformer)
* [RotateDownTransformer](https://github.com/geftimov/android-viewpager-transformers/wiki/RotateDownTransformer)
* [RotateUpTransformer](https://github.com/geftimov/android-viewpager-transformers/wiki/RotateUpTransformer)
* [StackTransformer](https://github.com/geftimov/android-viewpager-transformers/wiki/StackTransformer)
* [TabletTransformer](https://github.com/geftimov/android-viewpager-transformers/wiki/TabletTransformer)
* [ZoomInTransformer](https://github.com/geftimov/android-viewpager-transformers/wiki/ZoomInTransformer)
* [ZoomOutSlideTransformer](https://github.com/geftimov/android-viewpager-transformers/wiki/ZoomOutSlideTransformer)
* [ZoomOutTranformer](https://github.com/geftimov/android-viewpager-transformers/wiki/ZoomOutTranformer)





#Creating Custom Transforms

All ViewPagerTransform implementations extend [BaseTransformer](https://github.com/geftimov/android-viewpager-transformers/blob/master/library/src/main/java/com/eftimoff/viewpager/tranformators/BaseTransformer.java) providing useful hooks improving readability of animations and basic functionality important when switching between animations. [BaseTransformer](https://github.com/geftimov/android-viewpager-transformers/blob/master/library/src/main/java/com/eftimoff/viewpager/tranformators/BaseTransformer.java) provides three lifecycle hooks and two flags for default handling of hiding offscreen fragments and mimicking the default paging functionality of the ViewPager.

* [preTransform(View view, float position)](https://github.com/geftimov/android-viewpager-transformers/blob/master/library/src/main/java/com/eftimoff/viewpager/tranformators/BaseTransformer.java#L42)
 * Default implementation resets the animation state of the fragment to defaults that will place it on the screen if its position permits.
* [onTransform(View view, float position)](https://github.com/geftimov/android-viewpager-transformers/blob/master/library/src/main/java/com/eftimoff/viewpager/tranformators/BaseTransformer.java#L14)
 * Animations should perform all or most of their work inside this callback.
* [postTransform(View view, float position)](https://github.com/geftimov/android-viewpager-transformers/blob/master/library/src/main/java/com/eftimoff/viewpager/tranformators/BaseTransformer.java#L75)
 * Default implementation does nothing. This provides a logical location for any additional work to be done that is not directly related to the animation.

#Special thanks for
[daimajia](https://github.com/daimajia)

[ToxicBakery](https://github.com/ToxicBakery)
