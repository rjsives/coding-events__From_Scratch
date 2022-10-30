package org.launchcode.codingevents.controllers;


import org.launchcode.codingevents.data.EventRepository;
import org.launchcode.codingevents.models.Event;
import org.launchcode.codingevents.models.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;
    @GetMapping
    public String displayAllEvents(Model model){
        model.addAttribute("title", "All Events");
        model.addAttribute("events", eventRepository.findAll());
        return "events/index";
    }

    // lives at /events/create
    @GetMapping("create")
    public String renderCreateEventForm(Model model){
        model.addAttribute("title", "Create Event");
        model.addAttribute(new Event());
        model.addAttribute("types", EventType.values());
        return "events/create";
    }
    // lives at /events/create

    @PostMapping("create")
    public String createEvent(@ModelAttribute @Valid Event newEvent, Errors errors, Model model) {
        if(errors.hasErrors()){
            model.addAttribute("title", "Create Event");
            return "events/create";
        }
        eventRepository.save(newEvent);
        return "redirect:";
    }

    @GetMapping("delete")
        public String renderDeleteEventForm(Model model){
            model.addAttribute("title", "Delete Event");
            model.addAttribute("events", eventRepository.findAll());
            return "events/delete";
    }

    @PostMapping("delete")
    public String deleteEvent(@RequestParam(required = false) int[] eventIds) {
        if (eventIds != null) {
            for (int id : eventIds) {
                eventRepository.deleteById(id);
            }
        }
        return "redirect:";
    }
//
//    @GetMapping("edit/{eventId}")
//    public String displayEditForm(Model model, @PathVariable int eventId) {
//        Event eventToEdit = eventRepository.findById(eventId);
//        model.addAttribute("event", eventToEdit);
//        String title = "Edit Event " + eventToEdit.getName() +  " (id=" + eventToEdit.getId() + ")";
//        model.addAttribute("title", title);
//        return "events/edit";
//    }
//
//    @PostMapping("edit")
//    public String editEvent(int eventId, String name, String description, String contactEmail, EventType type) {
//        Event eventToEdit = eventRepository.findById(eventId);
//        eventToEdit.setName(name);
//        eventToEdit.setDescription(description);
//        eventToEdit.setContactEmail(contactEmail);
//        eventToEdit.setType(type);
//        return "redirect:";
//    }
}
