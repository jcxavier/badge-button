/*
 * Copyright (C) 2011 João Xavier
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package pt.nb.acp.layout;

import pt.nb.acp.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Represents a push-button widget, similar to {@link Button},
 * allowing the user to show a badge with text in the a corner of the view.
 * 
 * Typical uses would include showing the number of notifications under a screen.
 * 
 * The implementation uses {@code badge_button.xml}, which can be customized to choose
 * the badge corner (default is {@code top|right}), the badge itself, between
 * {@code badge1} or {@code badge2}, as well as the text font, size, color and typeface.
 * 
 * It is advised, for the button property layout_margin="5dip", that the image is around 25x25 px.
 * 
 * @version 1.0
 * @author João Xavier <joao.xavier@novabase.pt>
 */
public class BadgeButton extends FrameLayout {
    /**
     * The {@link TextView} containing the text in the badge.
     */
    private TextView badgeText;
    
    /**
     * The {@link RelativeLayout} containing the badge view.
     */
    private RelativeLayout badgeView;
    
    /**
     * The {@link Button} inside the {@link BadgeButton}.
     */
    private Button btnClickThrough;
    
    public BadgeButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.drawable.badge_button, this);
        
        // initialize layout components
        badgeText = (TextView) findViewById(R.id.badgebtn_txt);
        badgeView = (RelativeLayout) findViewById(R.id.badgebtn_rl);
        btnClickThrough = (Button) findViewById(R.id.badgebtn_btn);
        
        int count = attrs.getAttributeCount();
        
        for (int i = 0; i != count; i++) {
            String attrName = attrs.getAttributeName(i);
            int attrValue = attrs.getAttributeResourceValue(i, 0);
            
            // search for android:text
            if (attrName.equals("text")) {
                if (attrValue == 0) // string literal
                    btnClickThrough.setText(attrs.getAttributeValue(i));
                else // string id, contained in R.string
                    btnClickThrough.setText(context.getResources().getString(attrValue));
            }
            // search for android:textColor
            else if (attrName.equals("textColor")) {
                if (attrValue == 0) // color literal
                    btnClickThrough.setTextColor(attrs.getAttributeIntValue(i, 0));
                else // color id, contained in R.color
                    btnClickThrough.setTextColor(context.getResources().getColor(attrValue));
            }
            // search for android:background
            else if (attrName.equals("background")) {
                // use drawable id
                this.setBackgroundResource(0);
                btnClickThrough.setBackgroundDrawable(context.getResources().getDrawable(attrValue));
            }
        }
    }
    
    /**
     * Attributes the {@link OnClickListener} to the button inside the {@link BadgeButton}.
     * 
     * @param listener the {@link OnClickListener} to pass to the button.
     */
    @Override
    public void setOnClickListener(OnClickListener listener) {
        btnClickThrough.setOnClickListener(listener);
    }
    
    /**
     * Sets the text inside the badge.
     * 
     * @param badgeText the text to set.
     */
    public void setBadgeText(String badgeTextString) {
        badgeText.setText(badgeTextString);
    }
 
    /**
     * Retrieves the text inside the badge.
     * 
     * @return the text inside the badge.
     */
    public String getBadgeText() {
        return badgeText.getText().toString();
    }
    
    /**
     * Hides the badge from the view.
     * The badge starts hidden.
     */
    public void hideBadge() {
        badgeView.setVisibility(View.GONE);
    }
    
    /**
     * Shows the badge.
     * The badge starts hidden.
     */
    public void showBadge() {
        badgeView.setVisibility(View.VISIBLE);
    }
}
