package com.clinic.interfaces;

public interface ICopyable<T> {
    /**
     * A method to generate new object containing every property in the
     * parameter <code>entity</code>
     * @return new object containing identical property as <code>entity</code>
     */
    public abstract T copy(T entity);
}