package org.lauchcode.codingevents.controllers;

import data.EventData;
import org.lauchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {


    @GetMapping
    public String displayAllEvents(Model model){
        model.addAttribute("events", EventData.getAll());
        return "events/index";
    }

    // lives at /events/create
    @GetMapping("create")
    public String renderCreateEventForm(){
        return "events/create";
    }
    // lives at /events/create
    @PostMapping("create")
    public String createEvent(@RequestParam String eventName,
                              @RequestParam String eventDescription) {
       EventData.add(new Event(eventName, eventDescription));
        return "redirect:";
    }

    @GetMapping("delete")
        public String renderDeleteEventForm(Model model){
            model.addAttribute("title", "Delete Event");
            model.addAttribute("events", EventData.getAll());
            return "events/delete";
    }

    @PostMapping("delete")
    public String deleteEvent(@RequestParam(required = false) int[] eventIds){
        if (eventIds != null) {
            for (int id : eventIds) {
                EventData.remove(id);
            }
        }
        return "redirect:";
    }
}
