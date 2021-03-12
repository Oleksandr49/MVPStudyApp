package com.archstud.architecturestudyapp.fragments;

import com.archstud.architecturestudyapp.PresenterListener;
import com.archstud.architecturestudyapp.RecyclerViewAdapter;
import com.archstud.architecturestudyapp.myObservers.MyCompletableObserver;
import com.archstud.architecturestudyapp.repository.DataObject;
import com.archstud.architecturestudyapp.repository.DataObjectRepository;

import java.util.List;

import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class ListFragmentPresenter extends DataObjectPresenter implements PresenterListener {

    private RecyclerViewAdapter adapterListener;

    public void setView(View view) {
        super.view = view;
    }

    public void setRepository(DataObjectRepository repository) {
        super.repository = repository;
    }

    public void initListItems(){
        repository.readAll().subscribeOn(Schedulers.io())
                            .subscribe(new SingleObserver<List<DataObject>>() {
                                @Override
                                public void onSubscribe(@NonNull Disposable d) {

                                }

                                @Override
                                public void onSuccess(@NonNull List<DataObject> dataObjects) {
                                    adapterListener.addListOfItemsToAdapter(dataObjects);
                                }

                                @Override
                                public void onError(@NonNull Throwable e) {

                                }
                            });
    }

    @Override
    public void deleteObjectFromDatabase(Long dataObjectId) {
        repository.deleteById(dataObjectId)
                .subscribeOn(Schedulers.io())
                .subscribe(new MyCompletableObserver());
    }

    @Override
    public void showRemovalConfirmationDialog(int itemPosition){
        view.showDialog(new ConfirmationDialog(() -> adapterListener.removeItemFromAdapter(itemPosition)));
    }

    public void addPositionToAdapter(Long dataObjectId){
        repository.read(dataObjectId)
        .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new MaybeObserver<DataObject>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onSuccess(@NonNull DataObject dataObject) {
                adapterListener.addItemToAdapter(dataObject);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    public void setAdapterListener(RecyclerViewAdapter adapterListener) {
        this.adapterListener = adapterListener;
    }

    public interface ConfirmationDialogCallBack{
        void onConfirm();
    }
}
