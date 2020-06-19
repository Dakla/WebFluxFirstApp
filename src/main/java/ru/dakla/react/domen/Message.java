package ru.dakla.react.domen;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class Message {
    private String data;

    public Message(String data) {
        this.data = data;
    }
}
