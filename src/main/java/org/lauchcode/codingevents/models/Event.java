package org.lauchcode.codingevents.models;

import javax.validation.constraints.*;
import java.util.Objects;

public class Event {
    private int id;
    private static int nextId = 1;
    @NotBlank(message = "Name is a required field. Must not be blank.")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters.")
    private String name;
    @Size(max = 500, message = "Description too long. 500 character limit.")
    private String description;

    @NotBlank(message = "Email is a required field. Must not be blank.")
    @Email(message = "Invalid email. Please try again.")
    private String contactEmail;

    @NotBlank(message = "Location is a required field. Must not be blank.")
    @Size(min = 2, max = 50, message = "Name must be between 3 and 50 characters.")
    private String location;

//    @AssertTrue(message = "Registrations is required.")
//    private boolean mustRegister;
//
//    @Positive(message = "Number of Attendees must be greater than zero")
//    private int numberOfAttendees;

    private EventType type;


    public Event(String name, String description, String contactEmail, EventType type) {
        this();
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.type=type;
    }



    public Event(){
        this.id = nextId;
        nextId++;
    }

    public String getLocation(){
        return this.location;
    }

    public void setLocation(String location){
        this.location = location;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {return contactEmail;}
    public void setContactEmail(String contactEmail) {this.contactEmail = contactEmail;}

    public EventType getType() {return type;}

    public void setType(EventType type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

//    public boolean isMustRegister() {
//        return mustRegister;
//    }
//
//    public void setMustRegister(boolean mustRegister) {
//        this.mustRegister = mustRegister;
//    }
//
//    public int getNumberOfAttendees() {
//        return numberOfAttendees;
//    }
//
//    public void setNumberOfAttendees(int numberOfAttendees) {
//        this.numberOfAttendees = numberOfAttendees;
//    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
