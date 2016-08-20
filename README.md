# Libgdx-MD-Toggle

__Libgdx-MD-Toggle__ is a scene2dUI implemetation of a Google material design style Toggle control. It is a simple extension of the [Libgdx Slider](<link to libgdx slider>)
with the addition of changing the knob and background as the toggle is switched, as well as providing a property to indicate whether it is on or not.

##### Screenshot
![Toggle On Screenshot](<put link here>)
![Toggle Off Screenshot](<put link here>)


##GettingStarted
##Prerequisites
This is designed to be used with [Libgdx](<link to libgdx>)


###Usage
1. Copy Toggle.java somewhere in you application
2. Create a ToggleStyle in your skin. (uiskin.json and matching requirements in uiskin.atlas and uiskin.png if you're using them, see example for uiskin.json))
  *You will need to include drawables for __background__, __knobBefore__, __knobAfter__, __knob__ and __knobOn__.
  *Ensure the package name matches that of where you put the Toggle class.
  *Some .svg files have been included to make creating each of them easier.
3. Create a new Toggle like any other UI widget:
	```
		Toggle toggle = new Toggle(false, skin);
	```