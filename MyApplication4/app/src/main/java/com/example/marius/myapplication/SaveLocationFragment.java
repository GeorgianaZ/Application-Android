package com.example.marius.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SaveLocationFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SaveLocationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SaveLocationFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SaveLocationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SaveLocationFragment newInstance(String param1, String param2) {
        SaveLocationFragment fragment = new SaveLocationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public SaveLocationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View saveLocationView =inflater.inflate(R.layout.fragment_save_location, container, false);
        Button saveLocationButton = (Button) saveLocationView.findViewById(R.id.saveLocationButtonInSaveLocationFragment);
        saveLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String departureCity = ((TextView)saveLocationView.findViewById(R.id.departureCityEditText)).getText().toString();
                String destinationCity = ((TextView)saveLocationView.findViewById(R.id.destinationCityEditText)).getText().toString();
                String description = ((TextView)saveLocationView.findViewById(R.id.descriptionEditText)).getText().toString();
                try {
                    mListener.onSaveLocationCoordinatesInSaveLocationFragment(departureCity, destinationCity, description);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Button cancelButton = (Button) saveLocationView.findViewById(R.id.cancelSaveButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onCancelButtonPressedInSaveLocationFragment();
            }
        });
        return saveLocationView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        public void onSaveLocationCoordinatesInSaveLocationFragment(String departureCity, String destinationCity, String description) throws InterruptedException;
        public void onCancelButtonPressedInSaveLocationFragment();
    }

}
