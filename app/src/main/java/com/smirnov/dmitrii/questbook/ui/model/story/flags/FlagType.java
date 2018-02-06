package com.smirnov.dmitrii.questbook.ui.model.story.flags;

import com.google.gson.annotations.SerializedName;

/**
 * @author Dmitry Smirnov
 * @version 06.02.2018.
 */

public enum FlagType {
    @SerializedName("user_has")
    USER_HAS,           //true если у персонажа есть все флаги из списка
    @SerializedName("user_has_not")
    USER_HAS_NOT,       //true если у персонажа нет всех флагов из списка
    @SerializedName("add_flag")
    ADD_FLAG,           //добавление всех флагов из списка юзеру
    @SerializedName("remove_flag")
    REMOVE_FLAG         //true если у персонажа есть  все флаги из списка, удаление флага
}
