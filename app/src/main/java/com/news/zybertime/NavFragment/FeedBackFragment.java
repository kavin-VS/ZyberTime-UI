package com.news.zybertime.NavFragment;

import android.content.res.ColorStateList;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.news.zybertime.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FeedBackFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FeedBackFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FeedBackFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FeedBackFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FeedBackFragment newInstance(String param1, String param2) {
        FeedBackFragment fragment = new FeedBackFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private SeekBar seekBar;
    private TextView seekBarResult;
    private ImageView seekBarIndicator;
    private TextInputLayout shortFeedBack, largeFeedBack;

    private RadioGroup feedRadioButton;

    private MaterialButton submitBtn, clearBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_feed_back, container, false);

        seekBar = view.findViewById(R.id.seekBar);
        seekBarResult = view.findViewById(R.id.seekbar_value);
        seekBarIndicator = view.findViewById(R.id.seekbar_indicator);
        feedRadioButton = view.findViewById(R.id.feed_radio_group);

        shortFeedBack = view.findViewById(R.id.feed_short_input);
        largeFeedBack = view.findViewById(R.id.feed_large_input);

        submitBtn = view.findViewById(R.id.feed_submit_btn);
        clearBtn = view.findViewById(R.id.feed_clear_btn);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarResult.setText(progress + "/10");

                if (seekBar.getProgress() <= 0) {
                    seekBarResult.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.defaultGrey)));
                } else if (seekBar.getProgress() < 5) {
                    seekBarResult.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.heartPink)));
                } else if (seekBar.getProgress() <= 7) {
                    seekBarResult.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorYellow)));
                } else if (seekBar.getProgress() >= 8) {
                    seekBarResult.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGreen)));
                } else {
                    seekBarResult.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.defaultGrey)));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        /*shortFeedBack.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (v.getId() == R.id.feed_short_input) {
                    v.getParent().requestDisallowInterceptTouchEvent(true);
                    switch (event.getAction() & MotionEvent.ACTION_MASK) {
                        case MotionEvent.ACTION_UP:
                            v.getParent().requestDisallowInterceptTouchEvent(false);
                            break;
                    }
                }
                return false;
            }
        });*/

        feedRadioButton.clearCheck();

        feedRadioButton.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = view.findViewById(checkedId);
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seekBar.setProgress(0);
                feedRadioButton.clearCheck();
                shortFeedBack.getEditText().setText(null);
                largeFeedBack.getEditText().setText(null);
            }
        });
        return view;
    }
}