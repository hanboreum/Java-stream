package main.part10designpattern.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class UserB {

    private int id;
    private String name;
    private String emailAddress;
    private boolean isVerified;
    private List<Integer> friendUserIds;
    private String optionalEmail;
    private LocalDateTime createdAt;

    public UserB(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.emailAddress = builder.emailAddress;
        this.isVerified = builder.isVerified;
        this.friendUserIds = builder.friendUserIds;
        this.createdAt = builder.createdAt;
    }

    public static UserB.Builder builder(int id, String name) {
        return new UserB.Builder(id, name);
    }

    public static class Builder {
        public int id;
        public String name;
        public String emailAddress;
        public boolean isVerified;
        public List<Integer> friendUserIds = new ArrayList<>(); //지정 값 가능
        public String optionalEmail;
        public LocalDateTime createdAt;

        private Builder(int id, String name) {
            this.id = id;
            this.name = name;
        }
        public Builder with(Consumer<Builder> consumer){
            consumer.accept(this);
            return this;
        }

        public UserB build(){
            return new UserB(this);
        }

    }

    @Override
    public String toString() {
        return "UserB{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", isVerified=" + isVerified +
                ", friendUserIds=" + friendUserIds +
                ", optionalEmail='" + optionalEmail + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
