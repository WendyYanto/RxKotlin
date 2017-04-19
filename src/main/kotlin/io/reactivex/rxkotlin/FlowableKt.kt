package io.reactivex.rxkotlin

import io.reactivex.Flowable
import io.reactivex.functions.BiFunction
import io.reactivex.functions.Function3
import io.reactivex.functions.Function4
import io.reactivex.functions.Function5
import org.reactivestreams.Publisher


object FlowableKt {

    inline fun <T1,T2,R> combineLatest(source1: Flowable<T1>, source2: Flowable<T2>, crossinline combineFunction: (T1, T2) -> R) =
            Flowable.combineLatest(source1, source2,
                    BiFunction<T1, T2, R> { t1, t2 -> combineFunction(t1,t2) })!!

    inline fun <T1,T2,T3,R> combineLatest(source1: Flowable<T1>, source2: Flowable<T2>, source3: Flowable<T3>, crossinline combineFunction: (T1, T2, T3) -> R) =
            Flowable.combineLatest(source1, source2,source3,
                    io.reactivex.functions.Function3<T1, T2, T3, R> { t1: T1, t2: T2, t3: T3 -> combineFunction(t1,t2, t3) })!!

    inline fun <T1,T2,T3,T4,R> combineLatest(source1: Flowable<T1>, source2: Flowable<T2>, source3: Flowable<T3>,
                                             source4: Flowable<T4>, crossinline combineFunction: (T1, T2, T3, T4) -> R) =
            Flowable.combineLatest(source1, source2,source3, source4,
                    io.reactivex.functions.Function4<T1, T2, T3, T4, R> { t1: T1, t2: T2, t3: T3, t4: T4 -> combineFunction(t1,t2, t3, t4) })!!


    inline fun <T1,T2,T3,T4,T5,R> combineLatest(source1: Flowable<T1>, source2: Flowable<T2>,
                                                source3: Flowable<T3>, source4: Flowable<T4>,
                                                source5: Flowable<T5>, crossinline combineFunction: (T1, T2, T3, T4, T5) -> R) =
            Flowable.combineLatest(source1, source2,source3, source4, source5,
                    io.reactivex.functions.Function5<T1, T2, T3, T4, T5, R> { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5 -> combineFunction(t1,t2, t3, t4, t5) })!!





    inline fun <T1,T2,R> zip(source1: Flowable<T1>, source2: Flowable<T2>, crossinline combineFunction: (T1, T2) -> R) =
            Flowable.zip(source1, source2,
                    BiFunction<T1, T2, R> { t1, t2 -> combineFunction(t1,t2) })!!

    inline fun <T1,T2,T3,R> zip(source1: Flowable<T1>, source2: Flowable<T2>, source3: Flowable<T3>, crossinline combineFunction: (T1, T2, T3) -> R) =
            Flowable.zip(source1, source2,source3,
                    io.reactivex.functions.Function3<T1, T2, T3, R> { t1: T1, t2: T2, t3: T3 -> combineFunction(t1,t2, t3) })!!

    inline fun <T1,T2,T3,T4,R> zip(source1: Flowable<T1>, source2: Flowable<T2>, source3: Flowable<T3>, source4: Flowable<T4>, crossinline combineFunction: (T1, T2, T3, T4) -> R) =
            Flowable.zip(source1, source2,source3, source4,
                    io.reactivex.functions.Function4<T1, T2, T3, T4, R> { t1: T1, t2: T2, t3: T3, t4: T4 -> combineFunction(t1,t2, t3, t4) })!!

    inline fun <T1,T2,T3,T4,T5,R> zip(source1: Flowable<T1>, source2: Flowable<T2>,
                                      source3: Flowable<T3>, source4: Flowable<T4>,
                                      source5: Flowable<T5>, crossinline combineFunction: (T1, T2, T3, T4, T5) -> R) =
            Flowable.zip(source1, source2,source3, source4, source5,
                    io.reactivex.functions.Function5<T1, T2, T3, T4, T5, R> { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5 -> combineFunction(t1,t2, t3, t4, t5) })!!
}


/**
 * An alias to [Flowable.withLatestFrom], but allowing for cleaner lambda syntax.
 */
inline fun <T, U, R> Flowable<T>.withLatestFrom(other: Publisher<U>, crossinline combiner: (T, U) -> R): Flowable<R>
        = withLatestFrom(other, BiFunction<T, U, R> { t, u -> combiner.invoke(t, u)  })

/**
 * An alias to [Flowable.withLatestFrom], but allowing for cleaner lambda syntax.
 */
inline fun <T, T1, T2, R> Flowable<T>.withLatestFrom(o1: Publisher<T1>, o2: Publisher<T2>, crossinline combiner: (T, T1, T2) -> R): Flowable<R>
        = withLatestFrom(o1, o2, Function3<T, T1, T2, R> { t, t1, t2 -> combiner.invoke(t, t1, t2) })

/**
 * An alias to [Flowable.withLatestFrom], but allowing for cleaner lambda syntax.
 */
inline fun <T, T1, T2, T3, R> Flowable<T>.withLatestFrom(o1: Publisher<T1>, o2: Publisher<T2>, o3: Publisher<T3>, crossinline combiner: (T, T1, T2, T3) -> R): Flowable<R>
        = withLatestFrom(o1, o2, o3, Function4<T, T1, T2, T3, R> { t, t1, t2, t3 -> combiner.invoke(t, t1, t2, t3) })

/**
 * An alias to [Flowable.withLatestFrom], but allowing for cleaner lambda syntax.
 */
inline fun <T, T1, T2, T3, T4, R> Flowable<T>.withLatestFrom(o1: Publisher<T1>, o2: Publisher<T2>, o3: Publisher<T3>, o4: Publisher<T4>, crossinline combiner: (T, T1, T2, T3, T4) -> R): Flowable<R>
        = withLatestFrom(o1, o2, o3, o4, Function5<T, T1, T2, T3, T4, R> { t, t1, t2, t3, t4 -> combiner.invoke(t, t1, t2, t3, t4) })

/**
 * An alias to [Flowable.zipWith], but allowing for cleaner lambda syntax.
 */
inline fun <T, U, R> Flowable<T>.zipWith(other: Publisher<U>, crossinline zipper: (T, U) -> R): Flowable<R>
        = zipWith(other, BiFunction { t, u -> zipper.invoke(t, u) })