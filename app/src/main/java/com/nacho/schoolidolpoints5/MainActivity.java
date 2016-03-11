package com.nacho.schoolidolpoints5;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import android.os.CountDownTimer;

import static com.nacho.schoolidolpoints5.GlobalFunctions.writeToFile;


public class MainActivity extends MyActivity {

//    private float screenWidth, screenHeight, dens;
//    int pad, buttonsHeight, buttonsWidth;
//    float size, smallSize;
    RelativeLayout eventLay, mainLayout;
    RelativeLayout configLay;
    TableLayout cfgTable, tableEvent;
    ViewGroup currentLay;
    Button configButton, saveCfgButton, cancelCfgButton;
    Spinner evSP, nevSP;
    TextView nsongsTex;
    EditText currTokensEd, currentPointsEd, goalEd;
    private EditText[] configEds;
    //int vers;

    TextView space1, space2, rule1, rule2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.principal);
        mainLayout = (RelativeLayout) findViewById(R.id.mainlay);

        //size = pxperc(3.4f);
        //smallSize = pxperc(2.7f);
        size = pxpercRatio(2.1f);
        smallSize = pxpercRatio(1.6f);
        //size = pxPercComp2(2f, 1.5f);
        //smallSize = pxPercComp2(1.7f, 0.3f);

// dens = getResources().getDisplayMetrics().density;
//        screenWidth = getResources().getDisplayMetrics().widthPixels / dens;
//        screenHeight = getResources().getDisplayMetrics().heightPixels / dens;
        //screenWidth = getResources().getDisplayMetrics().widthPixels;
        //screenHeight = getResources().getDisplayMetrics().heightPixels;
        //size = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12f, metrics); //
        //size = percwf(3.8f, true);
        /*if(vers < 14) {
            size = pxpercw(3.8f);
            smallSize = pxpercw(2.7f);
        }
        else {
            size = pxpercw(4.2f);
            smallSize = pxpercw(2.7f);
        }*/

        //size = pxpercRatio(2.1f);
        //smallSize = pxpercRatio(1.6f);

        //size = pxpercRatio(2.5f);
        //smallSize = pxpercRatio(1.7f);

        //smallSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 8f, metrics); //
        //smallSize = percwf(2.6f, true);;
        //pad = perchi(5);
        mainLayout.setPadding(padw, padh, padw, padh);
        // HERE WE WILL DO SOMETHING TO ADAPT TEXT SIZE AND OTHER SIZES TO SCREEN WIDTH.
        // WO WE NEED A NUMBER AND ADAPT DINAMICALLY THE SCREEN OPERATING WITH THIS NUMBER, USING IT IN ONCREATE, TO SET THE TEXT SIZE BASICALLY, SINCE THE REST OF THE THINGS ARE "WRAP_CONTENT".
        //TokenEvent.context = this;
        //=======================================
        // LAYOUT VARIABLES
        //=======================================
        eventLay = (RelativeLayout) findViewById(R.id.MAIN_SCREEN);
        configLay = (RelativeLayout) findViewById(R.id.TEV_CONFIG);
        //tableEvent = (TableLayout) findViewById(R.id.tablEv);

        //===================================================
        // TOKEN EVENT LAYOUT ELEMENTS
        //=================================================
        //buttonsHeight = perchi(14);
        //buttonsWidth = percwi(14);
        configButton = (Button) findViewById(R.id.configTokenBtn);
        /*configButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);*/
        //configButton.setWidth(buttonsWidth);
        //configButton.setHeight(buttonsHeight);
        styleButton1(configButton, buttonsWidth, buttonsHeight);


        //configButton.setHeight((int) (screenHeight / 8));

        //evSP = (Spinner) findViewById(R.id.spEv);
        //nevSP = (Spinner) findViewById(R.id.spNonEv);
        //currTokensEd = (EditText) findViewById(R.id.currentTokens);
        //currentPointsEd = (EditText) findViewById(R.id.currentPoints);
        //goalEd = (EditText) findViewById(R.id.goal);
        //nsongsTex = (TextView) findViewById(R.id.nSongs);
        saveCfgButton = (Button) findViewById(R.id.saveCfgBtn);
        /*saveCfgButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
        saveCfgButton.setWidth(buttonsWidth);
        saveCfgButton.setHeight(buttonsHeight);*/
        styleButton1(saveCfgButton, buttonsWidth, buttonsHeight);

        cancelCfgButton= (Button) findViewById(R.id.cancelCfgBtn);
        /*cancelCfgButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
        cancelCfgButton.setWidth(buttonsWidth);
        cancelCfgButton.setHeight(buttonsHeight);*/
        styleButton1(cancelCfgButton, buttonsWidth, buttonsHeight);
        buildEventLayout();
        configButton.bringToFront();
        /*space1 = (TextView) findViewById(R.id.space1);
        space2 = (TextView) findViewById(R.id.space2);
        rule1 = (TextView) findViewById(R.id.rule1);
        space2 = (TextView) findViewById(R.id.space2);
        int spaces = (int)(screenWidth/30);
        int lines = (int)(screenHeight/3);*/

        //int children = eventLay.getChildCount();
        /*for(int i = 0; i < children; i ++) {
            eventLay.getChildAt(i)
        }*/

        /*StringBuilder sb = new StringBuilder();
        for(int i = 0; i < spaces; i ++) {
            sb.append(" ");
        }
*/
        //eventLay.setPadding(spaces, spaces, 2 * spaces, 2 * spaces);
        //rule1.setTextSize(TypedValue.COMPLEX_UNIT_SP,screenWidth/40);
        //nevSP.setPadding(spaces,spaces,2*spaces,2*spaces);
        //nevSP.setPadding(spaces,3*spaces,2*spaces,2*spaces);
        //space1.setText(sb.toString());
        //space2.setText(sb.toString());
        //space1.setText(sb.toString());
        //nevSP.set

        //===============================================================================
        // TOKEN EVENT LAYOUT ELEMENTS ACTIONS
        //========================================================================

        configButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "ratio: " + ratio, Toast.LENGTH_SHORT).show();

                if (cfgTable == null) {
                    buildConfigTable();
                    openLay(configLay);
                    customToastMessage("Change table values for your own average ones! ;)");
                } else { // I BELIEVE THIS PERHAPS IS NOT NECESSARY
                    for (int i = 0; i < 12; i++) {
                        configEds[i].setText("" + TokenEvent.configValues[i]);
                    }
                    openLay(configLay);
                }

                //customToastMessage("Change table values for your own average ones! ;)");
                //Toast.makeText(getApplicationContext(), "Change table values for your own avwerages! ;)" , Toast.LENGTH_SHORT).show();

            }
        });

        saveCfgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateConfigValues();
                saveConfig();
                setNsongsTexColor();
                openLay(eventLay);
            }
        });

        cancelCfgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLay(eventLay);
            }
        });



        evSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TokenEvent.updateValues(position, getApplicationContext());
                setNsongsTexColor();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        
        nevSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TokenEvent.updateNEValues(position, getApplicationContext());
                setNsongsTexColor();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        
        currTokensEd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String str = s.toString();
                if (str.matches("\\d+")) {
                    //Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                    TokenEvent.currentTokens = Integer.parseInt(str);
                    //Toast.makeText(getApplicationContext(), "" + currentTokens + " " + currentPoints + " " + eventGoal, Toast.LENGTH_SHORT).show();
                    TokenEvent.calculateSongs();
                    setNsongsTexColor();
                } else {
                    nsongsTex.setText("0");
                }
            }
        });

        currentPointsEd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String str = s.toString();
                if(str.matches("\\d+")) {
                    //Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                    //TokenEvent tkevent = (TokenEvent) event;
                    TokenEvent.currentPoints = Integer.parseInt(str);
                    //Toast.makeText(getApplicationContext(), "" + currentTokens + " " + currentPoints + " " + eventGoal, Toast.LENGTH_SHORT).show();
                    TokenEvent.calculateSongs();
                    setNsongsTexColor();
                }
                else {
                    nsongsTex.setText("0");
                }
            }
        });

        goalEd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String str = s.toString();
                if(str.matches("\\d+")) {
                    //Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                    TokenEvent.eventGoal = Integer.parseInt(str);
                    //Toast.makeText(getApplicationContext(), "" + currentTokens + " " + currentPoints + " " + eventGoal, Toast.LENGTH_SHORT).show();
                    TokenEvent.calculateSongs();
                    //Toast.makeText(getApplicationContext(), "" + currentTokens + " " + currentPoints + " " + eventGoal, Toast.LENGTH_SHORT).show();
                    setNsongsTexColor();
                }
                else {
                    nsongsTex.setText("0");
                }
            }
        });

        initialize();
    }

    //=======================================================================================================================================================================
//                            FUNCTION DECLARATIONS
//=======================================================================================================================================================================
    /**
     * This function simply changes the layout (LinearLayout) which is set to visible.
     * @param lay The layout variable which is going to become visible
     */
    public void openLay (ViewGroup lay) {
        if(currentLay == null) {
            currentLay = eventLay;
        }
        currentLay.setVisibility(View.GONE);
        lay.setVisibility(View.VISIBLE);
        currentLay = lay;
        //Toast.makeText(getApplicationContext(), "cambio de pantalla hecho" , Toast.LENGTH_SHORT).show();
    }

    void buildConfigTable() {
        size = pxPercComp2(2.5f, 0.5f);
        smallSize = pxPercComp2(1.7f, 0.3f);
        //size = pxpercRatio(2.1f);
        //smallSize = pxpercRatio(1.6f);
        cfgTable = (TableLayout) findViewById(R.id.cfgTbl);
        TableRow tableRow = new TableRow(this);

        tableRow.addView(newText2Bold("MODE  "));
        tableRow.addView(newText2Bold("Tokens Gained"));
        tableRow.addView(newText2Bold("    Price    "));
        tableRow.addView(newText2Bold("Points Gained"));
        cfgTable.addView(tableRow);

        String[] modes = getResources().getStringArray(R.array.mode);

        int maxLength = 5;
        InputFilter[] fArray = new InputFilter[1];
        fArray[0] = new InputFilter.LengthFilter(maxLength);
        configEds = new EditText[12];

        for(int i = 0; i < 4; i ++) {
            tableRow = new TableRow(this);
            tableRow.addView(newText2Bold(modes[i] + " "));
            for(int j = 0; j < 3; j ++) {

                EditText editText = newEdit1(fArray);
                editText.setText("" + TokenEvent.configValues[i * 3 + j]);
                configEds[i*3+j] = editText;
                tableRow.addView(editText);
            }
            cfgTable.addView(tableRow);
        }
//        RelativeLayout.LayoutParams relativeParams = new RelativeLayout.LayoutParams(null);
//        relativeParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
//        relativeParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        //cfgTable.setGravity();
        //configLay.addView(cfgTable, relativeParams);

        TableLayout informTable = (TableLayout) findViewById(R.id.infoTbl);
        tableRow = new TableRow(this);
        tableRow.addView(newText3SmallBold("Tokens Gained "));
        tableRow.addView(newText4Small("in a non-event song"));
        informTable.addView(tableRow);
        tableRow = new TableRow(this);
        tableRow.addView(newText3SmallBold("Price "));
        tableRow.addView(newText4Small("of an event live show"));
        informTable.addView(tableRow);
        tableRow = new TableRow(this);
        tableRow.addView(newText3SmallBold("Points Gained "));
        tableRow.addView(newText4Small("in the event song"));
        informTable.addView(tableRow);
        //configLay.addView(informTable);
    }

    /**
     * Initializes variables, being called inside "onCreate"
     */
    private void initialize() {
        TokenEvent.loadEvent(this);
        currentLay = eventLay;
    }

    /**
     * Saves the current event in its file and show its data in a toast
     */
    @Override
    protected void onPause() {
        super.onPause();
        //Toast.makeText(getApplicationContext(), "joder pausa", Toast.LENGTH_SHORT).show();
        TokenEvent.saveEvent();
    }

    /**
     * Loads the LAST EVENT data. This event name is saved in preferences file with the key "current_event".
     * So if we have been seeing an old event in the last run of the apk, we will see the last event anyway.
     */
    @Override
    protected void onResume() {
        super.onResume();
        //Toast.makeText(getApplicationContext(), "w: " + screenWidth, Toast.LENGTH_SHORT).show();
        //Toast.makeText(getApplicationContext(), "h: " + screenHeight, Toast.LENGTH_SHORT).show();
        //Toast.makeText(getApplicationContext(), "density: " + dens, Toast.LENGTH_SHORT).show();
        if(TokenEvent.eventFile == null) {
            TokenEvent.loadEvent(this);
        }

        loadValues();
    }

    private void loadValues() {
        evSP.setSelection(TokenEvent.eventMode);
        nevSP.setSelection(TokenEvent.nonEventMode);
        currTokensEd.setText("" + TokenEvent.currentTokens);
        currentPointsEd.setText("" + TokenEvent.currentPoints);
        goalEd.setText("" + TokenEvent.eventGoal);
    }

    void updateConfigValues() {
        for(int i = 0; i < 12; i ++) {
            TokenEvent.configValues[i] = Integer.parseInt(configEds[i].getText().toString());
            TokenEvent.updateCfg();
            TokenEvent.calculateSongs();
        }
    }

    void setNsongsTexColor() {
        nsongsTex.setText("" + TokenEvent.nSongs);
        if(TokenEvent.nSongs > 80) {
            nsongsTex.setTextColor(Color.RED);
        }
        else if(TokenEvent.nSongs > 20) {
            nsongsTex.setTextColor(Color.YELLOW);
        }

        else {
            nsongsTex.setTextColor(Color.GREEN);
        }
    }

    void buildEventLayout() {

        size = pxpercRatio(2.1f);
        smallSize = pxpercRatio(1.6f);
        //eventLay = new RelativeLayout(this);
        tableEvent = new TableLayout(this);//
        //tableEvent = (TableLayout) findViewById(R.id.tablEv);

        TableRow tableRow = new TableRow(this);

        tableRow.addView(newText1("Playing non-ev songs in "));
        //tableRow.setBackgroundColor(Color.TRANSPARENT);

        nevSP = new Spinner(this);
        evSP = new Spinner(this);
        SpinnerAdapter adapter = new SpinnerAdapter(this,
                android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.mode));

        //ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.mode, android.R.layout.simple_spinner_item);
        nevSP.setAdapter(adapter);
        evSP.setAdapter(adapter);


        tableRow.addView(nevSP);

        tableRow.addView(newText1(" mode"));
        tableEvent.addView(tableRow);
//=========================================================================
        tableRow = new TableRow(this);

        tableRow.addView(newText1("Playing event song in "));

        evSP = new Spinner(this);
        evSP.setAdapter(adapter);

        tableRow.addView(evSP);
        /*if(vers < 14) {
            ViewGroup.LayoutParams params = evSP.getLayoutParams();
            params.width = pxpercw(19f);
            evSP.setLayoutParams(params);
            nevSP.setLayoutParams(params);
            //evSP.setBackgroundColor(Color.TRANSPARENT);
        }*/

        tableRow.addView(newText1(" mode"));
        tableEvent.addView(tableRow);
        //=============================================================
        tableRow = new TableRow(this);

        tableRow.addView(newText1("You have now "));

        InputFilter[] fArray = new InputFilter[1];
        fArray[0] = new InputFilter.LengthFilter(5);

        currTokensEd = newEdit1(fArray);
        tableRow.addView(currTokensEd);

        tableRow.addView(newText1(" tokens"));
        tableEvent.addView(tableRow);
        //=============================================================
        tableRow = new TableRow(this);

        tableRow.addView(newText1("You have now "));

        currentPointsEd = newEdit1(fArray);
        tableRow.addView(currentPointsEd);

        tableRow.addView(newText1(" event points"));
        tableEvent.addView(tableRow);
        //=============================================================
        tableRow = new TableRow(this);

        tableRow.addView(newText1("Your goal is "));

        goalEd = newEdit1(fArray);
        tableRow.addView(goalEd);

        tableRow.addView(newText1(" event points"));
        tableEvent.addView(tableRow);
        //=============================================================
        tableRow = new TableRow(this);

        tableRow.addView(newText1("You need to play "));

        nsongsTex = newText1("");
        nsongsTex.setTypeface(null, Typeface.BOLD);
        nsongsTex.setGravity(Gravity.CENTER_HORIZONTAL);
        tableRow.addView(nsongsTex);

        tableRow.addView(newText1(" non-ev songs"));
        tableEvent.addView(tableRow);
        //=======================================
        //tableEvent.setBackgroundColor(Color.TRANSPARENT);
        eventLay.addView(tableEvent);

    }



    private class SpinnerAdapter extends ArrayAdapter<String> {
        Context context;
        String[] items = new String[]{};

        public SpinnerAdapter(final Context context,
                              final int textViewResourceId, final String[] objects) {
            super(context, textViewResourceId, objects);
            this.items = objects;
            this.context = context;
        }

        @Override
        public View getDropDownView(int position, View convertView,
                                    ViewGroup parent) {

            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(context);
                convertView = inflater.inflate(
                        android.R.layout.simple_spinner_item, parent, false);
            }

            TextView tv = (TextView) convertView
                    .findViewById(android.R.id.text1);
            tv.setText(items[position]);
            //tv.setTextColor(Color.BLUE);
            /*if(vers > 13) {
                tv.setTextSize(size);
            }
            else {
                tv.setTextSize(smallSize);
            }*/
            tv.setTextSize(size);
            return convertView;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(context);
                convertView = inflater.inflate(
                        android.R.layout.simple_spinner_item, parent, false);
            }

            // android.R.id.text1 is default text view in resource of the android.
            // android.R.layout.simple_spinner_item is default layout in resources of android.

            TextView tv = (TextView) convertView
                    .findViewById(android.R.id.text1);
            tv.setText(items[position]);
            //tv.setTextColor(Color.BLUE);
            /*if(vers > 13) {
                tv.setTextSize(size);
            }
            else {
                tv.setTextSize(smallSize);
            }*/
            tv.setTextSize(size);
            return convertView;
        }
    }



    @Override
    public void onBackPressed() {
        if(!(currentLay == null) && currentLay.equals(configLay)) {
            openLay(eventLay);
        }
        else {
            super.onBackPressed();
        }
    }

    void saveConfig() {
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < 12; i ++) {
            s.append(TokenEvent.configValues[i]); s.append(" ");
        }
        writeToFile(s.toString(), TokenEvent.configFile);
    }

    void customToastMessage(String message) {
        /*LayoutInflater inflater = getLayoutInflater();
        View toastLayout = inflater.inflate(R.layout.custom_toast,
                (ViewGroup) findViewById(R.id.toastLayout));

        toastLayout.setBackgroundColor(Color.TRANSPARENT);
        TextView toastText = (TextView) toastLayout.findViewById(R.id.toastText);
        toastText.setTextSize(size);
        toastText.setText(message);
        //toastText.setHeight(pdperc(20f));
        //toastText.setWidth(pdperc(100f));
        toastText.setHeight(pxpercRatio(20f));
        toastText.setWidth(pxpercRatio(100f));

        toastText.setTypeface(null, Typeface.BOLD);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(toastLayout);
        toast.show();*/
//        int mShortAnimationDuration = getResources().getInteger(
//                android.R.integer.config_shortAnimTime);
//        final TextView toastText = (TextView) findViewById(R.id.toastText);
//        toastText.setTextSize(size);
//        toastText.setText(message);
//        //toastText.setHeight(pdperc(20f));
//        //toastText.setWidth(pdperc(100f));
//        toastText.setTypeface(null, Typeface.BOLD);
//        toastText.bringToFront();
        //toastText.setVisibility(View.VISIBLE);
        //toastText.setAlpha(0f);

        /*toastText.setVisibility(View.VISIBLE);

        // Animate the content view to 100% opacity, and clear any animation
        // listener set on the view.
        *//*toastText.animate()
                .alpha(1f)
                .setDuration(mShortAnimationDuration)
                .setListener(null);*//*
        final int paso=400, total=2000;
        CountDownTimer countDownTimer = new CountDownTimer(total, paso) {
            //float s = 0f;
            @Override
            public void onTick(long millisUntilFinished) {
                //s += size*paso/total;
                //toastText.setTextSize(s);
            }
            @Override
            public void onFinish() {
                toastText.setVisibility(View.GONE);
            }
        }.start();*/



        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG);
        LinearLayout linearLayout = (LinearLayout) toast.getView();
        linearLayout.setBackgroundResource(R.drawable.message_background);
        TextView messageTextView = (TextView) linearLayout.getChildAt(0);
        messageTextView.setTextSize(size);
        messageTextView.setGravity(Gravity.CENTER);
        //messageTextView.setHeight(pdperc(20f));
        //messageTextView.setWidth(pdperc(100f));
        messageTextView.setTypeface(null, Typeface.BOLD);
//        messageTextView.setBackgroundResource(R.drawable.message_background);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }

}
