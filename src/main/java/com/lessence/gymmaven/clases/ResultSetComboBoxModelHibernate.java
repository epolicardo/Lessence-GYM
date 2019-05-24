/*
 * ResultSetComboBoxModel.java
 */

package com.lessence.gymmaven.clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 * ResultSet ComboBoxModel
 * @author Yo
 * @version 1.0
 */
public class ResultSetComboBoxModelHibernate implements ComboBoxModel {

    private Vector<ResultSetComboBoxModelObject> data = new Vector<ResultSetComboBoxModelObject>();
    private Vector<ListDataListener> list = new Vector<ListDataListener>();
    private ResultSetComboBoxModelObject selectedItem;

    public ResultSetComboBoxModelHibernate(ResultSet r, String codigo, String descri) throws SQLException {
        r.beforeFirst();
        while (r.next()) {
            data.add(new ResultSetComboBoxModelObject(r.getInt(codigo), r.getString(descri)));
        }
    }

       
    public ResultSetComboBoxModelObject searchSelectedItem(Integer i) {
        for (ResultSetComboBoxModelObject o : data) {
            if (i.equals(o.getCodigo())) {
                return o;
            }
        }
        return null;
    }

    public ResultSetComboBoxModelObject searchSelectedItem(String s) {
        for (ResultSetComboBoxModelObject o : data) {
            if (s.equals(o.getDescri())) {
                return o;
            }
        }
        return null;
    }

    public void setSelectedItem(Object anItem) {
        selectedItem = anItem instanceof ResultSetComboBoxModelObject ? (ResultSetComboBoxModelObject) anItem : null;
        for (ListDataListener l : list) {
            l.contentsChanged(new ListDataEvent(this, javax.swing.event.ListDataEvent.CONTENTS_CHANGED, 0, 0));
        }
    }

    public Object getSelectedItem() {
        return selectedItem;
    }

    public int getSize() {
        return data.size();
    }

    public Object getElementAt(int index) {
        return data.get(index);
    }

    public void addListDataListener(ListDataListener l) {
        list.add(l);
    }

    public void removeListDataListener(ListDataListener l) {
        list.remove(l);
    }

    public Integer getSelectedCodigo() {
        return selectedItem == null ? null : selectedItem.getCodigo();
    }

    public String getSelectedDescri() {
        return selectedItem == null ? null : selectedItem.getDescri();
    }
}