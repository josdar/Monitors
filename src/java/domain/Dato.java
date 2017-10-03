/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author kevin
 */
public class Dato {
    private String tableSpace_name;
    private String table_name;
    private Integer num_rows;
    private String lastDate;

    public Dato() {
    }

    public Dato(String tableSpace_name, String table_name, Integer num_rows, String lastDate) {
        this.tableSpace_name = tableSpace_name;
        this.table_name = table_name;
        this.num_rows = num_rows;
        this.lastDate = lastDate;
    }
    
    

    public String getTableSpace_name() {
        return tableSpace_name;
    }

    public void setTableSpace_name(String tableSpace_name) {
        this.tableSpace_name = tableSpace_name;
    }

    public String getTable_name() {
        return table_name;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }

    public Integer getNum_rows() {
        return num_rows;
    }

    public void setNum_rows(Integer num_rows) {
        this.num_rows = num_rows;
    }

    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }

    @Override
    public String toString() {
        return "Dato{" + "tableSpace_name=" + tableSpace_name + ", table_name=" + table_name + ", num_rows=" + num_rows + ", lastDate=" + lastDate + '}';
    }
    
    
    
}
