package com.techyourchance.mvc.screens.questionslist;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.techyourchance.mvc.R;
import com.techyourchance.mvc.questions.Question;
import com.techyourchance.mvc.screens.common.BaseObservableViewMvc;

import java.util.ArrayList;
import java.util.List;

public class QuestionsListItemMvcImpl extends BaseObservableViewMvc<QuestionsListItemMvc.Listener>
        implements QuestionsListItemMvc {

    private Question mQuestion;
    private TextView txtTitle;

    public QuestionsListItemMvcImpl(LayoutInflater inflater, ViewGroup parent) {
        setRootView(inflater.inflate(R.layout.layout_question_list_item, parent, false));
        txtTitle = findViewById(R.id.txt_title);
        getRootView().setOnClickListener(v -> {
            for (Listener listener : getListeners()) {
                listener.onQuestionClicked(mQuestion);
            }
        });
    }



    @Override
    public void bindQuestion(Question question) {
        mQuestion = question;
        txtTitle.setText(mQuestion.getTitle());
    }
}
