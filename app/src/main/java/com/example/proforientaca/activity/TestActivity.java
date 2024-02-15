package com.example.proforientaca.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proforientaca.R;

public class TestActivity extends AppCompatActivity{

    private Button[] answerButtons;
    private TextView questionText;
    private int questionIndex = 0;
    private int[] scores = new int[4]; // массив для подсчета количества ответов 1, 2, 3, 4

    private String[] questions = {
            "Какие из следующих предметов вам нравится больше всего?",
            "Что вам интереснее",
            "Каковы ваши сильные стороны",
            "Что вам нравится делать в свободное время?",
            "Как вы предпочитаете учиться новому материалу?",
            "Какие из следующих профессий вам интересны?",
            "Чего вы ожидаете от будущей работы?",
            "Ваша реакция на сложные задачи и ситуации?",
            "Какие из следующих качеств вам свойственны?",
            "Как вы предпочитаете работать: самостоятельно или в команде?"
    };

    private String[][] answers = {
            {"Математика", "Литература", "Биология", "Иностранные языки"},
            {"Работа с цифрами и анализ данных", "Творческое писательство и анализ текстов", "Изучение живых организмов и их взаимодействия", "Общение с людьми из разных стран и культур"},
            {"Логическое мышление и аналитические навыки", "Воображение и способность выражать свои мысли на бумаге", "Внимательность к деталям и умение работать с природными объектами", "Умение общаться и налаживать контакты с людьми"},
            {"Решать математические головоломки и задачи", "Читать книги и писать свои истории", "Путешествовать и проводить время на природе", "Общаться с друзьями и знакомиться с новыми людьми"},
            {"Через логические алгоритмы и решение задач", "Через чтение и обсуждение текстов с другими людьми", "Через практическую работу с конкретными объектами и эксперименты", "Через общение и обмен опытом с другими учениками"},
            {"Инженер", "Журналист", "Биолог", "Дипломат"},
            {"Материальной безопасности и возможности развития своих навыков", "Творческого самовыражения и вдохновения", "Возможности изучать и исследовать новые явления", "Международного общения и сотрудничества"},
            {"Анализировать и разбивать на более простые компоненты", "Искать творческие решения и пробовать разные подходы", "Изучать и анализировать предметы, искать закономерности", "Консультироваться с другими людьми и объединять усилия"},
            {"Систематичность и точность", "Воображение и художественный вкус", "Внимательность и эмпатия", "Коммуникабельность и умение сотрудничать"},
            {"Самостоятельно, чтобы сфокусироваться на задаче", "В команде, чтобы обмениваться идеями и получать обратную связь", "В команде или самостоятельно в зависимости от ситуации", "В команде, чтобы работать вместе и достигать общих целей"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        questionText = findViewById(R.id.text_question);
        answerButtons = new Button[4];

        answerButtons[0] = findViewById(R.id.button_answer1);
        answerButtons[1] = findViewById(R.id.button_answer2);
        answerButtons[2] = findViewById(R.id.button_answer3);
        answerButtons[3] = findViewById(R.id.button_answer4);

        showQuestion(); // показываем первый вопрос

        for (int i = 0; i < answerButtons.length; i++) {
            final int finalI = i;
            answerButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    scores[finalI]++; // увеличиваем счетчик для выбранного ответа
                    questionIndex++; // переходим к следующему вопросу

                    if (questionIndex < questions.length) {
                        showQuestion(); // показываем следующий вопрос
                    } else {
                        showResult(); // показываем результат по окончании вопросов
                    }
                }
            });
        }
    }

    private void showQuestion() {
        questionText.setText(questions[questionIndex]);

        for (int i = 0; i < answerButtons.length; i++) {
            answerButtons[i].setText(answers[questionIndex][i]);
        }
    }

    private void showResult() {
        int maxScore = 0;
        int maxScoreIndex = 0;

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > maxScore) {
                maxScore = scores[i];
                maxScoreIndex = i + 1;
            }
        }

        // Определение результата в зависимости от выбранных ответов
        String result;
        switch (maxScoreIndex) {
            case 1:
                result = "Вам подойдут направления связанные с точными науками, технологиями или инженерией.";
                break;
            case 2:
                result = "Вы можете рассмотреть профессии связанные с литературой, искусством, медиа или журналистикой.";
                break;
            case 3:
                result = "Вам подойдут профессии в сфере биологии, медицины, экологии или исследований.";
                break;
            case 4:
                result = "Вам стоит обратить внимание на профессии, связанные с международными отношениями, дипломатией или коммуникациями.";
                break;
            default:
                result = "Вы не выбрали ни одного варианта ответа.";
        }

        Intent intent = new Intent(this, TestResActivity.class);
        intent.putExtra("result", result);
        startActivity(intent);
    }
}