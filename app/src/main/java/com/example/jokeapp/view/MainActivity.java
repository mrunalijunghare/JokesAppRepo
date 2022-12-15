package com.example.jokeapp.view;

import static com.example.jokeapp.model.Util.KEY_JOKE_REQUEST;
import static com.example.jokeapp.model.Util.categoryStrArray;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import com.example.jokeapp.R;
import com.example.jokeapp.model.JokesRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button searchButton;
    private RadioButton rbCustom;
    private RadioButton rbAny;
    private CheckBox checkboxSingle;
    private CheckBox checkboxTwopart;
    List<String> selectedCatergories;
    private Spinner spinnerAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init() {
        rbAny = findViewById(R.id.RBAny);
        rbAny.setChecked(true);
        rbCustom = findViewById(R.id.RBCustom);
        checkboxSingle = findViewById(R.id.checkboxSingle);
        checkboxTwopart = findViewById(R.id.checkboxTwopart);
        spinnerAmount = findViewById(R.id.spinnerAmount);
        setCustomCategoryDialog();
        setButtonClickListener();
        setSpinnerAdapter();
    }

    private void setSpinnerAdapter() {
        List<Integer> arrayAmounts = new ArrayList<Integer>();
        for (int i=1; i<=10; i++) {
            arrayAmounts.add(i);
        }

        ArrayAdapter<Integer> amountSpinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arrayAmounts);
        amountSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerAmount.setAdapter(amountSpinnerAdapter);
    }

    private void setCustomCategoryDialog() {
        final boolean[] checkedItems = new boolean[categoryStrArray.length];
        selectedCatergories = new ArrayList<>(categoryStrArray.length);

        rbCustom.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

            builder.setTitle("Choose Category");

            builder.setMultiChoiceItems(categoryStrArray, checkedItems, (dialog, which, isChecked) -> {

                checkedItems[which] = isChecked;

            });

            builder.setCancelable(false);

            builder.setPositiveButton("Done", (dialog, which) -> {
                selectedCatergories.clear();
                int i = 0;
                for (Boolean isChecked: checkedItems) {
                    if (isChecked)
                        selectedCatergories.add(categoryStrArray[i]);
                    i++;
                }
                if (selectedCatergories.isEmpty()){
                    rbAny.setChecked(true);
                    Arrays.fill(checkedItems, false);
                }
            });

            builder.setNegativeButton("CANCEL", (dialog, which) -> {
                if (selectedCatergories.isEmpty()) {
                    rbAny.setChecked(true);
                    Arrays.fill(checkedItems, false);
                } else {
                    for (int i=0; i<categoryStrArray.length; i++) {
                        if (!selectedCatergories.contains(categoryStrArray[i]) && checkedItems[i]) {
                            checkedItems[i] = false;
                        }
                        if (selectedCatergories.contains(categoryStrArray[i]) && !checkedItems[i]) {
                            checkedItems[i] = true;
                        }
                    }
                }
            });

            builder.setNeutralButton("CLEAR ALL", (dialog, which) -> {
                Arrays.fill(checkedItems, false);
                selectedCatergories.clear();
                rbAny.setChecked(true);
             });

            builder.create();

            AlertDialog customCategoryDialog = builder.create();
            customCategoryDialog.show();

        });
    }

    private void setButtonClickListener() {
        searchButton = findViewById(R.id.searchButton);
        searchButton.setOnClickListener(v ->  {
            Intent intent = new Intent(MainActivity.this, ListActivity.class);
            intent.putExtra(KEY_JOKE_REQUEST, getJokeRequestData());
            startActivity(intent);
        });
    }

    private JokesRequest getJokeRequestData() {
        JokesRequest jokesRequest = new JokesRequest();
        if (selectedCatergories != null && selectedCatergories.size()>0) {
            jokesRequest.setCategory(String.join(",", selectedCatergories));
        }
        if (!(checkboxSingle.isChecked() && checkboxTwopart.isChecked())) {
            if (checkboxSingle.isChecked())
                jokesRequest.setJokeType(getResources().getString(R.string.single));
            if (checkboxTwopart.isChecked())
                jokesRequest.setJokeType(getResources().getString(R.string.twopart));
        }
        if (spinnerAmount.getSelectedItem() != null
            && Integer.parseInt(spinnerAmount.getSelectedItem().toString())>1)
                jokesRequest.setAmount(spinnerAmount.getSelectedItem().toString());

        return jokesRequest;
    }
}
