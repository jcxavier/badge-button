Represents a push-button widget for Android, similar to Button, allowing the user to show a badge with text in the corner of the view (inspired on iOS).
Typical uses would include showing the number of notifications under a screen.
The implementation uses badge_button.xml, which can be customized to choose the badge corner (default is top|right),
the badge itself, between badge1 or badge2, as well as the text font, size, color and typeface.
It is advised, for the button property layout_margin="5dip", that the image is around 27x27 or 28x28 px in mdpi.

The badge initializes hidden.

The test activity BadgeButtonTestActivity exemplifies how to quickly set up a dashboard with buttons and buttons with badge.


![Demo] (https://raw.github.com/jcxavier/badge-button/master/demo.png)


## Version log
### v1.1
* supplying android:background to the button (as a drawable id)
* supplying android:textColor to the button (with a literal or color id)
* supplying android:textSize to the button (with a literal or dimen id)
* supplying android:gravity to the button

### v1.0
* supplying android:text to the button
* supplying OnClickListener to the button
* getting/setting the badge text
* hiding/showing the badge
* two different badge images to choose from
