package com.smirnov.dmitrii.questbook.ui.model.story.flags;

import com.google.gson.annotations.SerializedName;

/**
 * @author Dmitry Smirnov
 * @version 06.02.2018.
 */

public enum FlagType {
    @SerializedName("user_has")
    USER_HAS,           //если у персонажа есть
    @SerializedName("user_has_not")
    USER_HAS_NOT,       //если у персонажа нет
    @SerializedName("add_flag")
    ADD_FLAG,           //добавление флага
    @SerializedName("remove_flag")
    REMOVE_FLAG         //если у персонажа есть, удаление флага
}
