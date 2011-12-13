package com.jcxavier.widget.test;

import com.jcxavier.widget.R;
import com.jcxavier.widget.BadgeButton;

import android.app.Activity;
import android.os.Bundle;

/**
 * @author João Xavier <jcxavier@jcxavier.com>
 */
public class BadgeButtonTestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.badgebtn_test);
        
        showButtonWithText(R.id.btn1, "1");
        showButtonWithText(R.id.btn2, "2");
        showButtonWithText(R.id.btn3, "3");
        showButtonWithText(R.id.btn4, "++");
        showButtonWithText(R.id.btn5, "AM");
        showButtonWithText(R.id.btn6, "!!");
        
        ((BadgeButton) findViewById(R.id.btn2)).hideBadge();
        ((BadgeButton) findViewById(R.id.btn3)).setBadgeDrawable(getResources().getDrawable(R.drawable.badge2));
    }
    
    private void showButtonWithText(int id, String text) {
        BadgeButton btn = (BadgeButton) findViewById(id);
        btn.setBadgeText(text);
        btn.showBadge();
    }
}
