package com.example.user.engCards;

public class Card {

    private String category;
    private String card_id;
    private String card_name_ru;
    private String card_name_en;


    public Card(){

    }

    public Card(String category, String cardID, String nameRu, String nameEn) {
        this.category = category;
        this.card_id = cardID;
        this.card_name_ru = nameRu;
        this.card_name_en = nameEn;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public String getCard_name_ru() {
        return card_name_ru;
    }

    public void setCard_name_ru(String card_name_ru) {
        this.card_name_ru = card_name_ru;
    }

    public String getCard_name_en() {
        return card_name_en;
    }

    public void setCard_name_en(String card_name_en) {
        this.card_name_en = card_name_en;
    }
}
