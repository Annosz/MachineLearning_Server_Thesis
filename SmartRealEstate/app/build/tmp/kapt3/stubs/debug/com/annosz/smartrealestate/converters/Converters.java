package com.annosz.smartrealestate.converters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007\u00a2\u0006\u0002\u0010\u0007J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0007\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/annosz/smartrealestate/converters/Converters;", "", "()V", "dateFromTimestamp", "Ljava/util/Date;", "value", "", "(Ljava/lang/Long;)Ljava/util/Date;", "dateToTimestamp", "date", "(Ljava/util/Date;)Ljava/lang/Long;", "app_debug"})
public final class Converters {
    
    @org.jetbrains.annotations.Nullable()
    @android.arch.persistence.room.TypeConverter()
    public final java.util.Date dateFromTimestamp(@org.jetbrains.annotations.Nullable()
    java.lang.Long value) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @android.arch.persistence.room.TypeConverter()
    public final java.lang.Long dateToTimestamp(@org.jetbrains.annotations.Nullable()
    java.util.Date date) {
        return null;
    }
    
    public Converters() {
        super();
    }
}