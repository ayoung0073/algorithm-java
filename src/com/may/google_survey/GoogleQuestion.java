package com.may.google_survey;

import java.util.Arrays;

public class GoogleQuestion {
    String questionText;
    String category;
    boolean required;
    String[] questionChoices;

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public String[] getQuestionChoices() {
        return questionChoices;
    }

    public void setQuestionChoices(String[] questionChoices) {
        this.questionChoices = questionChoices;
    }

    @Override
    public String toString() {
        return "GoogleQuestion{" +
                "questionText='" + questionText + '\'' +
                ", category='" + category + '\'' +
                ", required=" + required +
                ", questionChoices=" + Arrays.toString(questionChoices) +
                '}';
    }
}
