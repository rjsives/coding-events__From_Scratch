package org.launchcode.codingevents.models;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Event extends AbstractEntity {
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
    @ManyToOne
    @NotNull(message = "Category is required")
    private EventCategory eventCategory;


    public Event(String name, String description, String contactEmail, EventCategory eventCategory) {
        this.description = description;
        this.contactEmail = contactEmail;
        this.eventCategory = eventCategory;
    }



    public Event(){
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

    public String getLocation(){
        return this.location;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public String getContactEmail() {return contactEmail;}
    public void setContactEmail(String contactEmail) {this.contactEmail = contactEmail;}

    public EventCategory getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(EventCategory eventCategory) {
        this.eventCategory = eventCategory;
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

}
