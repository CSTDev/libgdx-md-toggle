package uk.co.ctdev.uiobjects;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

/**
 * A Toggle is an implementation of the Google Material Design Toggle widget. It has two states
 * either on or off and can be used to represent this for anything with those values.
 ** <p>
 * {@link ChangeListener.ChangeEvent} is fired when the progress bar knob is moved. Cancelling the event will move the knob to where it was
 * previously.
 * <p>
 * The preferred height of a progress bar is determined by the larger of the knob and background. The preferred width of progress
 * bar is 140, a relatively arbitrary size.
 */
public class Toggle extends Slider {

    private boolean isOn;

    public Toggle(boolean vertical, Skin skin) {
        this(vertical, skin.get("default-" + (vertical ? "vertical" : "horizontal"), ToggleStyle.class));
    }

    public Toggle(boolean vertical, Skin skin, String styleName) {
        this(vertical, skin.get(styleName, ToggleStyle.class));
    }

    public Toggle(boolean vertical, ToggleStyle style) {
        super(0, 1, 1, vertical, style);

        addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                isOn = Toggle.this.getValue() == 1;
            }
        });
    }

    /** Returns the toggle's style. Modifying the returned style may not have an effect until {@link #setStyle(ToggleStyle)} is
     * called. */
    public ToggleStyle getStyle(){
        return (ToggleStyle)super.getStyle();
    }

    public void setStyle(ToggleStyle style){
        if (style == null) throw new NullPointerException("style cannot be null");
        if (!(style instanceof ToggleStyle)) throw new IllegalArgumentException("style must be a ToggleStyle.");
        super.setStyle(style);
    }

    protected Drawable getKnobDrawable(){
        ToggleStyle style = getStyle();
        return isOn ? style.knobOn : style.knob;
    }


    public boolean isOn(){
        return isOn;
    }

    public void setIsOn(boolean isOn){
        if(isOn) {
            this.setValue(1);
        }else{
            this.setValue(0);
        }
        this.isOn = isOn;
    }



    /** The style for a toggle, see {@link Toggle}.
     */
    static public class ToggleStyle extends SliderStyle{
        public Drawable knobOn;

        public ToggleStyle () {
        }

        public ToggleStyle ( Drawable knobOn, Drawable background, Drawable knob) {
            super(background, knob);
            this.knobOn = knobOn;
        }

        public ToggleStyle (ToggleStyle style) {
            super(style);
            this.knobOn = style.knobOn;
        }
    }
}
