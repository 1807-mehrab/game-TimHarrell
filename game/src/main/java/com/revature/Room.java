public class Room {
    private String name;
    private Room []next;
    private String description;
    

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String desc) {
        description = desc;
    }

    public void setNextRooms(Room... args) { // is varargs ok with setnextRom in constructor
        next = args;
    }

    Room(String name, String desc, Room ...args) {
        setName(name);
        setDescription(desc);
        setNextRoom(args);
    }
}