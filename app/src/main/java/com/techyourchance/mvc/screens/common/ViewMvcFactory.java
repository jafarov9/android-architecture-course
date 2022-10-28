package com.techyourchance.mvc.screens.common;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.techyourchance.mvc.screens.questionslist.QuestionsListItemMvc;
import com.techyourchance.mvc.screens.questionslist.QuestionsListItemMvcImpl;
import com.techyourchance.mvc.screens.questionslist.QuestionsListViewMvc;
import com.techyourchance.mvc.screens.questionslist.QuestionsListViewMvcImpl;

public class ViewMvcFactory {
    private final LayoutInflater layoutInflater;

    public ViewMvcFactory(LayoutInflater layoutInflater) {
        this.layoutInflater = layoutInflater;
    }

    public QuestionsListViewMvc getQuestionListViewMvc(@Nullable  ViewGroup parent) {
        return new QuestionsListViewMvcImpl(layoutInflater, parent, this);
    }

    public QuestionsListItemMvc getQuestionListItemViewMvc(@Nullable ViewGroup parent) {
        return new QuestionsListItemMvcImpl(layoutInflater, parent);
    }
}
