/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerseymikes;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author CJ
 */
public class nStore {

    private final SimpleStringProperty storeId;
    private final SimpleStringProperty storeName;


    public nStore(String sId, String sName) {
        this.storeId = new SimpleStringProperty(sId);
        this.storeName = new SimpleStringProperty(sName);
    

    }

    public String getStoreId() {
        return storeId.get();
    }

    public void setStoreId(String id) {
        storeId.set(id);
    }

    public String getStoreName() {
        return storeName.get();
    }

    public void setStoreName(String sName) {
        storeName.set(sName);
    }


}
