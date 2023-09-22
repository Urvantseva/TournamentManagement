package ru.netology.TournamentManagement;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String playerNome) {
        super("Игрок с именем" + playerNome + "не найден");
    }
}
