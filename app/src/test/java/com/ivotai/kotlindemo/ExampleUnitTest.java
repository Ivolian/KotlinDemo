package com.ivotai.kotlindemo;

import org.junit.Test;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {

        Observer observer = new Observer() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(Object s) {
                System.out.println("onNext");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError");
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };

                Observable.merge(Observable.just(1,2),Observable.just(3))
//        Observable.just(1)
//                .flatMap(new Function<Integer, ObservableSource<Integer>>() {
//                    @Override
//                    public ObservableSource<Integer> apply(Integer integer) throws Exception {
//                        return null;
//                    }
//                })
                .subscribe(System.out::println);
    }
}