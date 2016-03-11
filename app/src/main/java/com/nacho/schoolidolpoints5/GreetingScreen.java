package com.nacho.schoolidolpoints5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import static com.nacho.schoolidolpoints5.GlobalFunctions.pushBoolean;

/**
 * Created by nacho on 6/9/15.
 */
public class GreetingScreen extends MyActivity {
    CheckBox checkbox;
    Button btnGreet;
    //static float screenWidth, screenHeight;
    //float size, smallSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.greeting);

//        screenWidth = getResources().getDisplayMetrics().widthPixels;
//        screenHeight = getResources().getDisplayMetrics().heightPixels;
//        size = percwf(3f, true);
//        smallSize = percwf(2.5f, true);

        //size = pxperc(3.7f);
        //smallSize = pxperc(2.2f);
//        size = pxpercRatio(2.1f);
//        smallSize = pxpercRatio(1.3f);
        size = pxPercComp2(2f, 1.5f);
        smallSize = pxPercComp2(1.7f, 0.3f);

        //size = pxpercRatio(8f);
        //smallSize = pxpercRatio(4.5f);
        //size = pxperc(5f);
        //smallSize = pxperc(3.7f);
        //size = dpToPx((int)(15*metrics.xdpi/100));
        //smallSize = dpToPx((int)(8.5*metrics.xdpi/100));
        //size = myDpToPx(20);
        //smallSize = myDpToPx(14);
        //size = dpToPx(15);
        //smallSize = dpToPx(8);
        //size = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 15, metrics);
        //smallSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 9, metrics);

        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Log.d(TAG, "onCreate");
        LinearLayout greetLayout =(LinearLayout) findViewById(R.id.greetLay);
        greetLayout.setPadding(padw, padh, padw, padh);
        TextView welcome = (TextView) findViewById(R.id.welcome);
        welcome.setTextSize(size);
        checkbox =(CheckBox) findViewById(R.id.checkBox);
        btnGreet =(Button) findViewById(R.id.goBtn);
        styleButton1(btnGreet, buttonsWidth, buttonsHeight);
        //btnGreet.setTextSize(size);
        //btnGreet.setWidth(buttonsWidth);
        //btnGreet.setHeight(buttonsHeight);
        btnGreet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pushBoolean("checked", checkbox.isChecked(), getApplicationContext());
                changeScreenClosing(MainActivity.class);
                /*Toast.makeText(getApplicationContext(), "metrics: " + metrics, Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), "xdpi: " + metrics.xdpi, Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), "ydpi: " + metrics.ydpi, Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), "dens default: " + metrics.DENSITY_DEFAULT, Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), "dens dpi: " + metrics.densityDpi, Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), "density: " + metrics.density, Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), "scaled density: " + metrics.scaledDensity, Toast.LENGTH_SHORT).show();*/

            }
        });

        greetLayout.addView(newText4Small("\nThis apk calculates the number of live shows you have to play, in order to gather enough event tokens or icons to achieve your goal, whatever it is."));
        greetLayout.addView(newText4Small("No need to say it only works for token collecting events."));
        greetLayout.addView(newText4Small("Previously to run any calculation you MUST tap the CONFIG buton and change some default values for your own average ones. If you don't have a clue you can change them at any moment, but remember that the calculation may be quite inaccurate if the values are too different."));
        greetLayout.addView(newText4Small("\nWant to contact me?"));
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.addView(newText3SmallBold("mail: "));
        linearLayout.addView(newText4Small("nash.makineta@gmail.com"));
        linearLayout.addView(newText3SmallBold("facebook: "));
        linearLayout.addView(newText4Small("Nash Makineta"));
        greetLayout.addView(linearLayout);
        greetLayout.addView(newText3SmallBold("School Idol Festival ID: 431519586 (Nash)   BE MY FRIEND! ;)"));
        greetLayout.addView(newText4Small("This is all free. ENJOY!! HARASHOOOO XD"));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
