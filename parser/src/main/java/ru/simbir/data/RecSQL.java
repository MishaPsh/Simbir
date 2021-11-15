package ru.simbir.data;

import javax.persistence.*;

@Entity
@Table(name="stat02")
public class RecSQL {
    @Id
    @Column(name="id")
    private int id;

    @Column(name="word")
    private String word;

    @Column(name="quantity")
    private int quantity;

    public RecSQL() {
    }

    public RecSQL(String word, int quantity) {
        this.word = word;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "RecSQL{" +
                "id=" + id +
                ", word='" + word + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
