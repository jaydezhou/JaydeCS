package net.jayde.app.vcard;

import net.sourceforge.cardme.vcard.VCardImpl;

import java.util.LinkedList;

public class VcardCategory {
    String CategoryName = "NULL";
    LinkedList<VCardImpl> listVcards = new LinkedList<>();

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public LinkedList<VCardImpl> getListVcards() {
        return listVcards;
    }

    public void setListVcards(LinkedList<VCardImpl> listVcards) {
        this.listVcards = listVcards;
    }
}
