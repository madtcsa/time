package com.madchen.tomatotime.model;

import java.util.List;

/**
 * Created by chenwei on 15/03/2017.
 */

public interface TomatoDataSource {

    void saveTomato(Tomato tomato);

    void getTomato(GetTomatoCallBack getTomatoCallBack);

    void loadTomatoes(LoadTomatoesCallBack loadTomatoesCallBack);

    interface GetTomatoCallBack {

        void onTomatoLoaded(Tomato tomato);

        void onDataNotAvailable();
    }

    interface LoadTomatoesCallBack {

        void onTomatoesLoaded(List<Tomato> tomatoList);

        void onDataNotAvailable();
    }
}
