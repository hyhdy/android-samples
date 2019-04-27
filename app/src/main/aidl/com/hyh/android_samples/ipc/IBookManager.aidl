// IBookManager.aidl
package com.hyh.android_samples.ipc;
import com.hyh.android_samples.ipc.Book;

interface IBookManager {
    List<Book> getBookList();
    void addBook(in Book book);
}
