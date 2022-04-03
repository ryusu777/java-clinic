package com.clinic;

/**
 * Class for pagination data
 * 
 * The <code>pageNumber</code> starts from 1
 * 
 * @author Jose Ryu Leonesta <jose.leonesta@student.matanauniversity.ac.id>
 */
public class Pagination {
    public Pagination() {
        recordsPerPage = 10;
        pageNumber = 1;
    }
    public Integer recordsPerPage, pageNumber, totalRecords;
    public String sortBy, sortOrder;
}
