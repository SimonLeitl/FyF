package com.example.linkn.myapplication.userInput;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.EditText;

import java.util.Map;
import java.util.function.Function;

@RequiresApi(api = Build.VERSION_CODES.N)
public class UserInputBuilder {

    private Map<String, Object> userInput;

    private Function<Integer, View> findViewByIdMethod;

    public UserInputBuilder(Map<String, Object> userInput, Function<Integer, View> findViewByIdMethod) {

        this.findViewByIdMethod = findViewByIdMethod;
        this.userInput = userInput;
    }

    public UserInputBuilder readUserInput(int id, String target) {

        EditText editText = (EditText) findViewByIdMethod.apply(id);
        userInput.put(target, editText.getText().toString());

        return this;
    }
}
