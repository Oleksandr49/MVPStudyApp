package com.archstud.architecturestudyapp.repository;

import com.archstud.architecturestudyapp.fragments.Presenter;

public interface DataObjectRepository {
     void readAll(Presenter presenterCallback);
     void create(DataObject dataObject, Presenter presenterCallback);
     void read(String objectName, Presenter presenterCallback);
     void update(DataObject dataObject, Presenter presenterCallback);
     void delete(DataObject dataObject, Presenter presenterCallback);
     void deleteByName(String dataObjectName, Presenter presenterCallBack);
}
