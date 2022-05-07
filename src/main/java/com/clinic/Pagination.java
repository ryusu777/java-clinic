package com.clinic;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Class for pagination data
 * 
 * The <code>pageNumber</code> starts from 1
 * 
 * @author Jose Ryu Leonesta <jose.leonesta@student.matanauniversity.ac.id>
 */
public class Pagination {
    public Pagination() {
        recordsPerPage.setValue(10);
        pageNumber.setValue(1);
    }

    private IntegerProperty recordsPerPage = new SimpleIntegerProperty();

    public IntegerProperty recordsPerPageProperty() {
        return recordsPerPage;
    }

    public Integer getRecordsPerPage() {
        return recordsPerPage.get();
    }

    public Pagination setRecordsPerPage(Integer recordsPerPage) {
        this.recordsPerPage.setValue(recordsPerPage);
        return this;
    }

    private IntegerProperty pageNumber = new SimpleIntegerProperty();

    public IntegerProperty pageNumberProperty() {
        return pageNumber;
    }

    public Integer getPageNumber() {
        return pageNumber.get();
    }

    public Pagination setPageNumber(Integer pageNumber) {
        this.pageNumber.setValue(pageNumber);
        return this;
    }
    
    private IntegerProperty totalRecords = new SimpleIntegerProperty();

    public IntegerProperty totalRecordsProperty() {
        return totalRecords;
    }

    public Integer getTotalRecords() {
        return totalRecords.get();
    }

    public Pagination setTotalRecords(Integer totalRecords) {
        this.totalRecords.setValue(totalRecords);
        return this;
    }

    private StringProperty sortBy = new SimpleStringProperty();

    public StringProperty sortByProperty() {
        return sortBy;
    }

    public String getSortBy() {
        return sortBy.get();
    }

    public Pagination setSortBy(String sortBy) {
        this.sortBy.setValue(sortBy);
        return this;
    }

    private StringProperty sortOrder = new SimpleStringProperty();

    public StringProperty sortOrderProperty() {
        return sortOrder;
    }

    public String getSortOrder() {
        return sortOrder.get();
    }

    public Pagination setSortOrder(String sortOrder) {
        this.sortOrder.setValue(sortOrder);
        return this;
    }
}
