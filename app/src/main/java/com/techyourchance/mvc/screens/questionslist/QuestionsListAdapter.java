package com.techyourchance.mvc.screens.questionslist;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.techyourchance.mvc.R;
import com.techyourchance.mvc.questions.Question;
import com.techyourchance.mvc.screens.common.ViewMvcFactory;

public class QuestionsListAdapter extends ArrayAdapter<Question> implements QuestionsListItemMvc.Listener {

    private final OnQuestionClickListener mOnQuestionClickListener;
    private ViewMvcFactory viewMvcFactory;

    public interface OnQuestionClickListener {
        void onQuestionClicked(Question question);
    }

    public QuestionsListAdapter(Context context,
                                OnQuestionClickListener onQuestionClickListener, ViewMvcFactory viewMvcFactory) {
        super(context, 0);
        mOnQuestionClickListener = onQuestionClickListener;
        this.viewMvcFactory = viewMvcFactory;
    }

    @SuppressLint("CutPasteId")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            QuestionsListItemMvc viewMvc = viewMvcFactory.getQuestionListItemViewMvc(parent);

            viewMvc.registerListener(this);

            convertView = viewMvc.getRootView();
            convertView.setTag(viewMvc);
        }

        final Question question = getItem(position);

        // bind the data to views
        QuestionsListItemMvc viewMvc = (QuestionsListItemMvc) convertView.getTag();

        viewMvc.bindQuestion(question);

        return convertView;
    }

    @Override
    public void onQuestionClicked(Question question) {
        mOnQuestionClickListener.onQuestionClicked(question);
    }
}
